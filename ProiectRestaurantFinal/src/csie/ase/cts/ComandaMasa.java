package csie.ase.cts;

import java.util.ArrayList;

import csie.ase.exceptii.DiscountMaiMareDe100Exception;
import csie.ase.exceptii.DiscountNegativException;
import csie.ase.exceptii.DiscountNulException;
import csie.ase.exceptii.NiciunMeniuComandatException;

public class ComandaMasa {
	ArrayList<MeniuStrategy> comanda;
	double valoare;
	
	public ComandaMasa(){
		comanda = new ArrayList<>();
		valoare = 0;
	}
	
	public double getValoareComanda(){
		return valoare;
	}
	
	private void adaugaCost(MeniuStrategy m){
		valoare += m.pret;
	}
	
	public void adaugaMeniu(MeniuStrategy m){
		comanda.add(m);
		adaugaCost(m);
	}
	
	public void stergeMeniu(MeniuStrategy m){
		for(int i=0;i<comanda.size();i++){
			if(comanda.get(i).descriere.equals(m.descriere)){
				comanda.remove(i);
			}
		}
	}
	
	public void afiseazaComanda(){
		for(int i=0;i<comanda.size();i++){
			comanda.get(i).comanda();
		}
	}
	
	public void notaDePlata(double discount) throws DiscountNegativException, DiscountNulException, DiscountMaiMareDe100Exception, NiciunMeniuComandatException{
		if(discount < 0 ) throw new DiscountNegativException();
		else if (discount == 0) throw new DiscountNulException();
		else if (discount > 100) throw new DiscountMaiMareDe100Exception();
		else if (this.comanda.size() == 0) throw new NiciunMeniuComandatException();
		else{
			this.valoare = this.valoare*(100 - discount)/100;
			System.out.println("Nota de plata: "+this.valoare);
		}
	}
}
