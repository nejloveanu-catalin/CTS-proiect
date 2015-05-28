package csie.ase.unitTesting;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import junit.framework.TestCase;
import org.junit.Before;

import csie.ase.cts.ComandaMasa;
import csie.ase.cts.MeniuFactory;
import csie.ase.cts.MeniuMare;
import csie.ase.cts.MeniuMic;
import csie.ase.cts.MeniuStrategy;
import csie.ase.exceptii.ComandaException;
import csie.ase.exceptii.DiscountMaiMareDe100Exception;
import csie.ase.exceptii.DiscountNegativException;
import csie.ase.exceptii.DiscountNulException;
import csie.ase.exceptii.NiciunMeniuComandatException;


public class TestComandaMasa extends TestCase{

	ComandaMasa comanda;
	String fisier ="DateComanda.txt";

	@Before
	public void setUp() throws Exception {
		System.out.println("SetUp");
		comanda = new ComandaMasa();
		
		//citirea valorilor initiale din fisier
		File file = new File(fisier);
		if(!file.exists()) throw new FileNotFoundException();
		
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String linie = null;
		
		while((linie = reader.readLine()) != null){
			
			if(linie.startsWith("initial")){
				String[] valori = linie.split("\t");
				
				MeniuFactory factory = new MeniuFactory();
				MeniuStrategy m1 = factory.getMeniu(valori[1]);
			
				comanda.adaugaMeniu(m1);
			}
		}
//		comanda.afiseazaComanda();
	}
	
	
//	@Before
//	public void setUp() throws Exception {
//		comanda = new ComandaMasa();
//		MeniuStrategy m1 = new MeniuMic();
//		MeniuStrategy m2 = new MeniuMare();
//		comanda.adaugaMeniu(m1);
//		comanda.adaugaMeniu(m2);	
//	}
	
	
	
	//testare metoda notaDePlata
	//testare cu valori normale
	public void testValoriNormaleNotaDePlata() throws ComandaException, IOException{
		
		File file = new File(fisier);
		if(!file.exists()) throw new FileNotFoundException();
		
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String linie = null;
		
		while((linie = reader.readLine()) != null){
			
			//elimin comentariile
			if(linie.startsWith("#")) continue;
			
			//elimin randurile cu valori initiale
			if(linie.startsWith("initial")) continue;
			
			//elimin randurile goale
			if(linie.trim().isEmpty()) continue;
			
			//creare valori de testare
			ComandaMasa comanda2 = new ComandaMasa();
			comanda2 = new ComandaMasa();
			MeniuStrategy m1 = new MeniuMic();
			MeniuStrategy m2 = new MeniuMare();
			comanda2.adaugaMeniu(m1);
			comanda2.adaugaMeniu(m2);
			
			String[] valori = linie.split("\t");
			double expected = Double.parseDouble(valori[0]);
			double discount = Double.parseDouble(valori[1]);
			
			comanda2.notaDePlata(discount);
			assertEquals("Testare metoda NotaDePlata cu valori normale",expected,comanda2.getValoareComanda());
			
			System.out.println("Testare linie: "+linie);
		}
		reader.close();
		
//		double expected = 22.5;
//		comanda.notaDePlata(10);
//		assertEquals("Testare metoda NotaDePlata cu valori normale",expected,comanda.getValoareComanda());
	}

	//testare metoda cu valoarea discountului negativa
	public void testDiscountNegativNotaDePlata() throws ComandaException{
		try{
			comanda.notaDePlata(-10);
			assertFalse("Metoda nu arunca exceptie pe discount negativ", true);
		}catch(DiscountNegativException ex){
			assertTrue(true);
		}
	}
	
	//testare metoda cu valoarea discountului 0
	public void testDiscountNulNotaDePlata() throws ComandaException{
		try{
			comanda.notaDePlata(0);
			assertFalse("Metoda nu arunca exceptie pe discount egal cu 0", true);
		}catch(DiscountNulException ex){
			assertTrue(true);
		}
	}
	
	
	//testare valori aberante discount
	public void testDiscountMaiMareDe100() throws ComandaException{
		try{
			comanda.notaDePlata(120);
			assertFalse("Metoda nu arunca exceptie pe discount mai mare de 100%", true);
		}catch(DiscountMaiMareDe100Exception ex){
			assertTrue(true);
		}
	}

	//testare comanda fara meniu
	public void testNiciunMeniuComandat() throws ComandaException{
		try{
			ComandaMasa comanda2 = new ComandaMasa();
			comanda2.notaDePlata(10);
			assertFalse("Metoda nu arunca exceptie pe niciun meniu comandat", true);
		}catch(NiciunMeniuComandatException ex){
			assertTrue(true);
		}
	}
	
	public void tearDown(){
		System.out.println("TearDown");
	}
}
