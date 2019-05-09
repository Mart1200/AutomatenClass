package auto;


import java.util.Arrays;

public class AutomatMoore {
	//int[zustände][eingang][folgezustand,ausgang]
	
	private int[][][] automatentabelle;
	private int zustände;
	private int eingänge;
	private int startzustand;
	private int letzterZustand = -1;

	public AutomatMoore(int[][][] tabelle, int start) {
		automatentabelle = tabelle;
		zustände = tabelle.length;
		eingänge = tabelle[0].length;
		startzustand = start;
	}

	public int[][][] getAutomatentabelle() {
		return automatentabelle;
	}

	public void setAutomatentabelle(int[][][] automatentabelle) {
		this.automatentabelle = automatentabelle;
	}

	public int getZustände() {
		return zustände;
	}

	public void setZustände(int zustände) {
		this.zustände = zustände;
	}

	public int getEingänge() {
		return eingänge;
	}

	public void setEingänge(int eingänge) {
		this.eingänge = eingänge;
	}

	public int getStartzustand() {
		return startzustand;
	}

	public void setStartzustand(int startzustand) {
		this.startzustand = startzustand;
	}

	@Override
	public String toString() {
		//anpassung für Eingänge > 10 fehlt noch
		String output = "Startzustand: " + startzustand + "\n     ";
		
		for(int l = 0; l < automatentabelle[0].length; l++) {
			output = output + "X" + l + "    ";
		}
		output = output + "\n";

		for(int j = 0; j < automatentabelle.length; j++) {
			output = output + "Z" + j + "   ";
			
			for(int i = 0; i < automatentabelle[0].length; i++) {
				output = output + automatentabelle[j][i][0] + "|" + automatentabelle[j][i][1] + "   ";
			}
			
			output = output + "\n";
		}	
		return output;
	}
	
	public int simpelInput(int in) {
		int out = 0;
		
		if(letzterZustand == -1) {
			out = automatentabelle[startzustand][in][1];
			letzterZustand = automatentabelle[startzustand][in][0];
		}else {
			out = automatentabelle[letzterZustand][in][1];
			letzterZustand = automatentabelle[letzterZustand][in][0];
		}
		return out;
	}
	
	public int[] insertWord(int[] in) {
		int[] out = new int[in.length];
		
		for(int i = 0; i < in.length; i++) {
			out[i]= this.simpelInput(in[i]);
		}
		return out;
	}
	
//	public AutomatMealey toMealy() {
//		
//	}
	
	
}
