package csie.ase.cts;

public class MeniuMare extends MeniuStrategy{

	public MeniuMare(){
		this.descriere = "Dublu hamburger cu cartofi prajiti si salata de varza";
		this.pret = 20.0;
	}
	
	@Override
	public void comanda() {
		System.out.println("Meniul mare: "+this.descriere+". Pret: "+this.pret);
	}

}
