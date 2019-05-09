package auto;

public class AutomatMealey {
	//int[zustände][eingang][Ausgang,Folgezustand]
	
	int[][][] automatentabelle;
	int zustände;
	int eingänge;
	int startzustand;

	public AutomatMealey(int[][][] tabelle, int start) {
		automatentabelle = tabelle;
		zustände = tabelle.length;
		eingänge = tabelle[0].length;
		startzustand = start;
	}
	
	
}
