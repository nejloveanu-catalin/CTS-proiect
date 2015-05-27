package csie.ase.cts;

import java.util.ArrayList;

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
	
//	public void costComanda(){
//		for(int i=0;i<comanda.size();i++){
//			valoare += comanda.get(i).pret;
//		}
//	}
//	
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
}
