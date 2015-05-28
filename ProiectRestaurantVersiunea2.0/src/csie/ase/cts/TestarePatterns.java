package csie.ase.cts;

public class TestarePatterns {
	
	
	public static void main(String[] args){
		
		//testare Factory
		MeniuFactory factory = new MeniuFactory();
	
		MeniuStrategy meniu1 = factory.getMeniu("MeniuMare");
		MeniuStrategy meniu2 = factory.getMeniu("MeniuMic");
		
		ComandaMasa comanda = new ComandaMasa();
		comanda.adaugaMeniu(meniu1);
		comanda.adaugaMeniu(meniu2);
		
		comanda.afiseazaComanda();
		System.out.println("Valoare comanda: "+comanda.getValoareComanda());
		
		//testare Strategy - stabilire tip meniu la run-time
		comanda.adaugaMeniu(new MeniuMediu());
		comanda.adaugaMeniu(new MeniuMare());
		comanda.afiseazaComanda();
		System.out.println("Valoare comanda: "+comanda.getValoareComanda());
		
		
		//testare Decorator
		MeniuStrategy m1 = new DecoratorBautura(new MeniuMic());
		m1.comanda();
		MeniuStrategy m2 = new DecoratorBautura(new MeniuMediu());
		m2.comanda();
		
	}
}
