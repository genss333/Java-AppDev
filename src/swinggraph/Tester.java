package swinggraph;


public class Tester {
	
	
	public static void test() {
		
		DataFactory fact = new DataFactory();
		
		int[] intSet10_10 = fact.genNormalInt(10, 10);
		int[] histSet10_10 = fact.histogramInt(10, intSet10_10);
		ArrayViewer.view1DIntArray(intSet10_10);
		ArrayViewer.view1DIntArray(histSet10_10);
		int minSet10_10 = fact.minInt(intSet10_10);
		int minHist10_10 = fact.minInt(histSet10_10);
		System.out.println("minSet10_10:" + minSet10_10 + ", minHist10_10:" + minHist10_10);
		int maxSet10_10 = fact.maxInt(intSet10_10);
		int maxHist10_10 = fact.maxInt(histSet10_10);
		System.out.println("maxSet10_10:" + maxSet10_10 + ", maxHist10_10:" + maxHist10_10);
		double averageDataDouble = fact.average(intSet10_10);
		int averageDataInt = fact.averageRound(intSet10_10);
		double averageHistDouble = fact.average(intSet10_10);
		int aveargeHistInt = fact.averageRound(intSet10_10);
		System.out.println("averageDataDouble:" + averageDataDouble 
				+ ", averageDataInt:" + averageDataInt
				+ ", averageHistDouble:" + averageHistDouble
				+ ", averageHistInt:" + aveargeHistInt);

		int[] intSet10_100 = fact.genNormalInt(10, 100);
		int[] histSet10_100 = fact.histogramInt(10, intSet10_100);
		ArrayViewer.view1DIntArray(intSet10_100);
		ArrayViewer.view1DIntArray(histSet10_100);
		int minSet10_100 = fact.minInt(intSet10_100);
		int minHist10_100 = fact.minInt(histSet10_100);
		System.out.println("minSet10_100:" + minSet10_100 + ", minHist10_100:" + minHist10_100);
		int maxSet10_100 = fact.maxInt(intSet10_100);
		int maxHist10_100 = fact.maxInt(histSet10_100);
		System.out.println("maxSet10_100:" + maxSet10_100 + ", maxHist10_100:" + maxHist10_100);
		averageDataDouble = fact.average(intSet10_100);
		averageDataInt = fact.averageRound(intSet10_100);
		averageHistDouble = fact.average(intSet10_100);
		aveargeHistInt = fact.averageRound(intSet10_100);
		System.out.println("averageDataDouble:" + averageDataDouble 
				+ ", averageDataInt:" + averageDataInt
				+ ", averageHistDouble:" + averageHistDouble
				+ ", averageHistInt:" + aveargeHistInt);
		
		int[] intSet10_1000 = fact.genNormalInt(10, 1000);
		int[] histSet10_1000 = fact.histogramInt(10, intSet10_1000);
		ArrayViewer.view1DIntArray(intSet10_1000);
		ArrayViewer.view1DIntArray(histSet10_1000);
		int minSet10_1000 = fact.minInt(intSet10_1000);
		int minHist10_1000 = fact.minInt(histSet10_1000);
		System.out.println("minSet10_1000:" + minSet10_1000 + ", minHist10_1000:" + minHist10_1000);
		int maxSet10_1000 = fact.maxInt(intSet10_1000);
		int maxHist10_1000 = fact.maxInt(histSet10_1000);
		System.out.println("maxSet10_1000:" + maxSet10_1000 + ", maxHist10_10:" + maxHist10_1000);
		averageDataDouble = fact.average(intSet10_1000);
		averageDataInt = fact.averageRound(intSet10_1000);
		averageHistDouble = fact.average(intSet10_1000);
		aveargeHistInt = fact.averageRound(intSet10_1000);
		System.out.println("averageDataDouble:" + averageDataDouble 
				+ ", averageDataInt:" + averageDataInt
				+ ", averageHistDouble:" + averageHistDouble
				+ ", averageHistInt:" + aveargeHistInt);
		
		int[] intSet10_10000 = fact.genNormalInt(10, 10000);
		int[] histSet10_10000 = fact.histogramInt(10, intSet10_10000);
		ArrayViewer.view1DIntArray(intSet10_10000);
		ArrayViewer.view1DIntArray(histSet10_10000);
		int minSet10_10000 = fact.minInt(intSet10_10000);
		int minHist10_10000 = fact.minInt(histSet10_10000);
		System.out.println("minSet10_10000:" + minSet10_10000 + ", minHist10_10000:" + minHist10_10000);
		int maxSet10_10000 = fact.maxInt(intSet10_10000);
		int maxHist10_10000 = fact.maxInt(histSet10_10000);
		System.out.println("maxSet10_10000:" + maxSet10_10000 + ", maxHist10_10000:" + maxHist10_10000);
		averageDataDouble = fact.average(intSet10_10000);
		averageDataInt = fact.averageRound(intSet10_10000);
		averageHistDouble = fact.average(intSet10_10000);
		aveargeHistInt = fact.averageRound(intSet10_10000);
		System.out.println("averageDataDouble:" + averageDataDouble 
				+ ", averageDataInt:" + averageDataInt
				+ ", averageHistDouble:" + averageHistDouble
				+ ", averageHistInt:" + aveargeHistInt);

		int[] intSet100_10000 = fact.genNormalInt(100, 10000);
		int[] histSet100_10000 = fact.histogramInt(100, intSet100_10000);
		ArrayViewer.view1DIntArray(intSet100_10000);
		ArrayViewer.view1DIntArray(histSet100_10000);
		int minSet100_10000 = fact.minInt(intSet100_10000);
		int minHist100_10000 = fact.minInt(histSet100_10000);
		System.out.println("minSet100_10000:" + minSet100_10000 + ", minHist100_10000:" + minHist100_10000);
		int maxSet100_10000 = fact.maxInt(intSet100_10000);
		int maxHist100_10000 = fact.maxInt(histSet100_10000);
		System.out.println("maxSet100_10000:" + maxSet100_10000 + ", maxHist100_10000:" + maxHist100_10000);
		averageDataDouble = fact.average(intSet100_10000);
		averageDataInt = fact.averageRound(intSet100_10000);
		averageHistDouble = fact.average(intSet100_10000);
		aveargeHistInt = fact.averageRound(intSet100_10000);
		System.out.println("averageDataDouble:" + averageDataDouble 
				+ ", averageDataInt:" + averageDataInt
				+ ", averageHistDouble:" + averageHistDouble
				+ ", averageHistInt:" + aveargeHistInt);
		
	}
	
	public static void main(String[] args) {
		
		test();
		
		

	}

}
