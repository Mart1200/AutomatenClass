package auto;

import java.util.Arrays;

public class AutomatMealey {
	//fehler bei unbestimmt tretten auf, f�r unbestimmt als folgezustand -1 eintragen
	private int[][] automatenTabelle;
	private int[] outputTabelle;
	private int zust�nde;
	private int eing�nge;
	private int startzustand;
	private int letzterZustand = -1;
	private boolean unbestimmt = false;
	
	public AutomatMealey(int[][] tabelle, int[] out, int start) {
		automatenTabelle = tabelle;
		outputTabelle = out;
		zust�nde = tabelle.length;
		eing�nge = tabelle[0].length;
		startzustand = start;
		for(int i = 0; i < zust�nde; i++) {
			for(int j = 0; j < eing�nge; j++) {
				if(tabelle[i][j] == -1) {
					unbestimmt = true;
				}
			}
		}
	}

	public int[][] getAutomatenTabelle() {
		return automatenTabelle;
	}

	public void setAutomatenTabelle(int[][] automatenTabelle) {
		this.automatenTabelle = automatenTabelle;
	}

	public int[] getOutputTabelle() {
		return outputTabelle;
	}

	public void setOutputTabelle(int[] outputTabelle) {
		this.outputTabelle = outputTabelle;
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

	public int getLetzterZustand() {
		return letzterZustand;
	}

	public void setLetzterZustand(int letzterZustand) {
		this.letzterZustand = letzterZustand;
	}

	@Override
	public String toString() {
		//anpassung f�r Eing�nge > 10 fehlt noch
		String output = "Startzustand: " + startzustand + "\n     ";
		for(int l = 0; l < eing�nge; l++) {
			output = output + "X" + l + "  ";
		}
		output = output + "\n";

		for(int j = 0; j < zust�nde; j++) {
			output = output + "Z" + j + "   ";
			for(int i = 0; i < eing�nge; i++) {
				output = output + automatenTabelle[j][i] + "   ";
			}
			output = output + outputTabelle[j] +"\n";
		}	
		return output;
	}
	
	public int simpelInput(int in) {
		int out = 0;
		if(letzterZustand == -1) {
			out = outputTabelle[automatenTabelle[startzustand][in]];
			letzterZustand = automatenTabelle[startzustand][in];
		}else {
			out = outputTabelle[automatenTabelle[letzterZustand][in]];
			letzterZustand = automatenTabelle[letzterZustand][in];
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
	
	public AutomatMoore toMoore() {
		int[][][] tabelle = new int[zust�nde][eing�nge][2];
		
		for(int i = 0; i < zust�nde; i++) {
			for(int j  = 0; j < eing�nge; j++) {
				tabelle[i][j][0] = automatenTabelle[i][j];
				tabelle[i][j][1] = outputTabelle[automatenTabelle[i][j]];
			}
		}
		AutomatMoore newMoore = new AutomatMoore(tabelle, startzustand);
		return newMoore;
	}
	
	
	
}
