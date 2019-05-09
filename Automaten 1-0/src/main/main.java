package main;

import auto.AutomatMealey;
import auto.AutomatMoore;

public class main {

	public static void main(String[] args) {
//		int[][][] tabelle = {{{1,1},{0,0}},{{0,0},{1,1}}};
		int[] word = {0,0};
//		
//
//		int start = 0;
//		
//		
//		AutomatMoore test = new AutomatMoore(tabelle, start);
//		
//		int[] out = test.insertWord(word);
//		
//		System.out.println(test);
//		System.out.println(test.simpelInput(0));
//		System.out.println(test.simpelInput(0));
//
//		for(int i = 0; i < out.length; i++) {
//			System.out.print(out[i]);
//		}
		

		int[][] tabelle = {{1,0},{0,1}};
		int[] out = {1,0};
		int start = 0;
		
		AutomatMealey test = new AutomatMealey(tabelle, out, start);
//		int[] out2 = test.insertWord(word);
		
		System.out.println(test);
		
//		for(int i = 0; i < out.length; i++) {
//			System.out.print(out2[i]);
//		}
		
		AutomatMoore test2 = test.toMoore();
		
		System.out.println(test2);
	}

}
