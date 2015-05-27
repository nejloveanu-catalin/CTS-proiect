package csie.ase.cts;

public abstract class DecoratorMeniu extends MeniuStrategy{
	MeniuStrategy meniuDecorat;
	
	public DecoratorMeniu(MeniuStrategy meniu){
		meniuDecorat = meniu;
	}
	
	public void comanda(){
		meniuDecorat.comanda();
	}
}
