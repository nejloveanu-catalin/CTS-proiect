package csie.ase.cts;

public class MeniuMediu extends MeniuStrategy{

	public MeniuMediu(){
		this.descriere = "Hamburger cu cartofi prajiti si sos de maioneza";
		this.pret = 10.0;
	}
	
	@Override
	public void comanda() {
		System.out.println("Meniul mediu: "+this.descriere+". Pret: "+this.pret);
	}
	
}
