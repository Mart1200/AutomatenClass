package main;

import auto.AutomatMealey;
import auto.AutomatMoore;

public class main {

	public static void main(String[] args) {
		int[][][] tabelle = {{{1,1},{0,0}},{{0,0},{1,1}}};
		int[] word = {0,0};
		

		int start = 0;
		
		
		AutomatMoore test = new AutomatMoore(tabelle, start);
		
		int[] out = test.insertWord(word);
		
		System.out.println(test);
		System.out.println(test.simpelInput(0));
		System.out.println(test.simpelInput(0));

		for(int i = 0; i < out.length; i++) {
			System.out.println(out[i]);
		}
		

	}

}
