package swinggraph;

import java.util.Random;

public class DataFactory {
	
	public static final String[] MONTH = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

	public static SaleData[] saleData = {
			new SaleData(MONTH[0], 40), 
			new SaleData(MONTH[1], 35),
			new SaleData(MONTH[2], 57),
			new SaleData(MONTH[3], 65),
			new SaleData(MONTH[4], 61),
			new SaleData(MONTH[5], 52),
			new SaleData(MONTH[6], 40),
			new SaleData(MONTH[7], 35),
			new SaleData(MONTH[8], 38),
			new SaleData(MONTH[9], 42),
			new SaleData(MONTH[10], 39),
			new SaleData(MONTH[11], 37)
	};

	public SaleData[] genNormal(int avg, int bound, int round) {
		
		SaleData[] saleData = new SaleData[12];
		int[] accuSale = new int[12];
		
		Random rand = new Random(System.currentTimeMillis());
		
		for(int i=0; i<round; i++) {
			
			double rawData = rand.nextInt(bound);
			
		}
		
		return saleData;
	}
	
	public int[] genNormalInt(int bound, int round) {
		
		Random rand = new Random(System.currentTimeMillis());
		
		int[] data = new int[round];
		
		for(int i=0; i<data.length; i++) {
			
			data[i] = rand.nextInt(bound);
			// System.out.println("data[" + i + "]:" + data[i]);
			
		}
		
		return data;
		
	}

	public int[] histogramInt(int bound, int[] data) {
		
		int[] hist = new int[bound];
		
		for(int i=0; i<data.length; i++) {
			
			int value = data[i];
			hist[value] += 1;
			// System.out.println("hist[" + i + "]:" + hist[i]);
			
		}
		
		return hist;
	}
	
	public int minInt(int[] array) {

		int min = Integer.MAX_VALUE;
		
		for(int i : array) {
			if(i < min) {
				min = i;
			}
		}
		
		return min;
		
	}

	public int maxInt(int[] array) {

		int max = Integer.MIN_VALUE;
		
		for(int i : array) {
			if(i > max) {
				max = i;
			}
		}
		
		return max;
		
	}
	
	public double average(int[] array) {

		double sum = 0;
		
		for(double d : array) {
			sum += d;
		}
		
		double avg = sum/array.length;
		return avg;
		
	}

	public int averageRound(int[] array) {

		double sum = 0;
		
		for(double d : array) {
			sum += d;
		}
		
		double avg = sum/array.length;
		int rnd = (int)Math.round(avg);
		return rnd;
		
	}

}