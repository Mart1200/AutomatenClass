package auto;

public class AutomatMealey {
	//int[zust�nde][eingang][Ausgang,Folgezustand]
	
	int[][][] automatentabelle;
	int zust�nde;
	int eing�nge;
	int startzustand;

	public AutomatMealey(int[][][] tabelle, int start) {
		automatentabelle = tabelle;
		zust�nde = tabelle.length;
		eing�nge = tabelle[0].length;
		startzustand = start;
	}
	
	
}
