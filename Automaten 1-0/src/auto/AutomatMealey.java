package auto;

import java.util.Arrays;

public class AutomatMealey {
	//fehler bei unbestimmt tretten auf, für unbestimmt als folgezustand -1 eintragen
	private int[][] automatenTabelle;
	private int[] outputTabelle;
	private int zustände;
	private int eingänge;
	private int startzustand;
	private int letzterZustand = -1;
	private boolean unbestimmt = false;
	
	public AutomatMealey(int[][] tabelle, int[] out, int start) {
		automatenTabelle = tabelle;
		outputTabelle = out;
		zustände = tabelle.length;
		eingänge = tabelle[0].length;
		startzustand = start;
		for(int i = 0; i < zustände; i++) {
			for(int j = 0; j < eingänge; j++) {
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

	public int getLetzterZustand() {
		return letzterZustand;
	}

	public void setLetzterZustand(int letzterZustand) {
		this.letzterZustand = letzterZustand;
	}

	@Override
	public String toString() {
		//anpassung für Eingänge > 10 fehlt noch
		String output = "Startzustand: " + startzustand + "\n     ";
		for(int l = 0; l < eingänge; l++) {
			output = output + "X" + l + "  ";
		}
		output = output + "\n";

		for(int j = 0; j < zustände; j++) {
			output = output + "Z" + j + "   ";
			for(int i = 0; i < eingänge; i++) {
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
		int[][][] tabelle = new int[zustände][eingänge][2];
		
		for(int i = 0; i < zustände; i++) {
			for(int j  = 0; j < eingänge; j++) {
				tabelle[i][j][0] = automatenTabelle[i][j];
				tabelle[i][j][1] = outputTabelle[automatenTabelle[i][j]];
			}
		}
		AutomatMoore newMoore = new AutomatMoore(tabelle, startzustand);
		return newMoore;
	}
	
	
	
}
