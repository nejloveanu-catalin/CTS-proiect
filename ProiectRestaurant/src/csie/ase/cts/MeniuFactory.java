package csie.ase.cts;

public class MeniuFactory {
	
	public MeniuStrategy getMeniu(String tipMeniu){
		if(tipMeniu.equalsIgnoreCase("MeniuMic"))
			return new MeniuMic();
		else if (tipMeniu.equalsIgnoreCase("MeniuMediu"))
			return new MeniuMediu();
		else if (tipMeniu.equalsIgnoreCase("MeniuMare"))
			return new MeniuMare();
		
		return null;
	}
}
