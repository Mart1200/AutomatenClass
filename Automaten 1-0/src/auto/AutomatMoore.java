package auto;

import java.util.Arrays;

public class AutomatMoore {
	//int[zust�nde][eingang][folgezustand,ausgang]
	// folgezustand auf -1 falls unbestimmt, fehler entstehen bei input falls unbestimmt, sollte abbrechen
	private int[][][] automatentabelle;
	private int zust�nde;
	private int eing�nge;
	private int startzustand;
	private int letzterZustand = -1;
	private boolean unbestimmt = false;

	public AutomatMoore(int[][][] tabelle, int start) {
		automatentabelle = tabelle;
		zust�nde = tabelle.length;
		eing�nge = tabelle[0].length;
		startzustand = start;
		
		for(int i = 0; i < zust�nde; i++) {
			for(int j = 0; j < eing�nge; j++) {
				if(tabelle[i][j][0] == -1) {
					unbestimmt = true;
				}
			}
		}
		
	}

	public int[][][] getAutomatentabelle() {
		return automatentabelle;
	}

	public void setAutomatentabelle(int[][][] automatentabelle) {
		this.automatentabelle = automatentabelle;
	}

	public int getZust�nde() {
		return zust�nde;
	}

	public void setZust�nde(int zust�nde) {
		this.zust�nde = zust�nde;
	}

	public int getEing�nge() {
		return eing�nge;
	}

	public void setEing�nge(int eing�nge) {
		this.eing�nge = eing�nge;
	}

	public int getStartzustand() {
		return startzustand;
	}

	public void setStartzustand(int startzustand) {
		this.startzustand = startzustand;
	}

	@Override
	public String toString() {
		//anpassung f�r Eing�nge > 10 fehlt noch
		String output = "Startzustand: " + startzustand + "\n     ";
		for(int l = 0; l < eing�nge; l++) {
			output = output + "X" + l + "    ";
		}
		output = output + "\n";

		for(int j = 0; j < zust�nde; j++) {
			output = output + "Z" + j + "   ";
			for(int i = 0; i < eing�nge; i++) {
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
//		int[][] tabelle;
//		int[]	out;
//		
//		
//		
//		AutomatMealey newMealy = new AutomatMealey(tabelle, out, startzustand);
//		return newMealy;
//	}
	
	
}
