package csie.ase.cts;

public class MeniuMic extends MeniuStrategy{
	
	public MeniuMic(){
		this.descriere = "Hamburger mic cu sos de rosii";
		this.pret = 5.0;
	}

	@Override
	public void comanda() {
		System.out.println("Meniul mic: "+this.descriere+". Pret: "+this.pret);
	}

}
