package csie.ase.cts;

public class DecoratorBautura extends DecoratorMeniu{

	public DecoratorBautura(MeniuStrategy meniu) {
		super(meniu);
	}
	
	public void comanda(){
		meniuDecorat.comanda();
		adaugaBauturaLaMeniu(meniuDecorat);
	}
	
	public void adaugaBauturaLaMeniu(MeniuStrategy meniu){
		System.out.println("La meniu se va adauga o Coca-Cola.");
	}

}
