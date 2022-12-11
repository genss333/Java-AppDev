package RandomNumber;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.Random;

public class RandomNumber {

	Random random;
	int number;
	int bound;
	
	int[] genInt(int number) {
		int[] figures = new int[number];
		for(int i=0; i<number; i++) {
			int figure = random.nextInt();
			figures[i] = figure;
		}
		
		return figures;
	}
	
	int[] genInt(int number, int bound) {
		
		int[] figures = new int[number];
		for(int i=0; i<number; i++) {
			int figure = random.nextInt(bound);
			figures[i] = figure;
		}
		
		return figures;
		
	}
	
	double[] genGaussian(int number) {
		
		double[] figures = new double[number];
		for(int i=0; i<number; i++) {
			double figure = random.nextGaussian();
			figures[i] = figure;
		}
		
		return figures;

	}
	
	public RandomNumber() {
		
		random = new Random(System.currentTimeMillis());
		number = 0;
		bound = 0;
	}
	
	
	public static void test() {
		RandomNumber randomNumber = new RandomNumber();
		randomNumber.number = 1;
		int[] intFigures = randomNumber.genInt(randomNumber.number);
		int counter = 0;
		for(int figure : intFigures) {
			System.out.println("intFigures[" + counter + "]:" + intFigures[(counter++)] + 
					", " + figure);
		}
		
		int bound = 1000;
		intFigures = randomNumber.genInt(randomNumber.number, bound);
		counter = 0;
		for(int figure : intFigures) {
			System.out.println("intFigures[" + counter + "]:" + intFigures[(counter++)] +
					", " + figure);
		}
		
		double[] doubleFigures = randomNumber.genGaussian(randomNumber.number);
		counter = 0;
		for(double figure : doubleFigures) {
			System.out.println("doubleFigures[" + counter + "]:" + doubleFigures[(counter++)] +
					", " + figure);
		}

	
	}
	public static void main(String[] args) {
		
		test();
	}
}
