package biGram;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class BiGramModel {
	
	public static String Path;
	public static String stmt1 = "The company chairman said he will increase the profit next year";
	public static String stmt2 = "The president said he believes the last year profit were good";
	public static int V =5049; //Value of the Vocabulary is derived from the Python Code submitted with the assignments 
	public static void main(String[] args) throws FileNotFoundException {
		Scanner ip = new Scanner(System.in);
		System.out.print("Enter the Corpus File with complete path");
		System.out.println(" For e.g.(F:\\Assignments\\Sample_1.txt)");
		Path = ip.nextLine();  				
		float probability=1;
		File text = new File(Path);
		Scanner scanText = new Scanner(text);
		System.out.println("=====================Prcessing Statement-1 w/o Smoothing==========================");
		probWithoutSmoothing(convertToArray(stmt1));
		System.out.println("=====================Prcessing Statement-2 w/o Smoothing==========================");
		probWithoutSmoothing(convertToArray(stmt2));		
		System.out.println("=====================Prcessing Statement-1 with Add-One Smoothing==========================");
		probWithAddOneSmoothing(convertToArray(stmt1));
		System.out.println("=====================Prcessing Statement-2 with Add-One Smoothing==========================");
		probWithAddOneSmoothing(convertToArray(stmt2));
		System.out.println("=======Prcessing Statement-1 with Good-Turing Smoothing========================");
		probWithGoodSmoothing(convertToArray(stmt1));
		System.out.println("=======Prcessing Statement-2 with Good-Turing Smoothing========================");
		probWithGoodSmoothing(convertToArray(stmt2));
		System.out.println("-- -----------------------------------------------------------------------------------------");
		System.out.println("Do you want to test any other statement?(Y/N)");
		String decision=ip.nextLine().toLowerCase();
		if(decision.equals("y")) {
			System.out.println("Enter any other statement you want to test");
			String stmt=ip.nextLine();
			System.out.println("=====================Prcessing Statement w/o Smoothing==========================");
			probWithoutSmoothing(convertToArray(stmt));
			System.out.println("=====================Prcessing Statement with Add-One Smoothing==========================");
			probWithAddOneSmoothing(convertToArray(stmt));
			System.out.println("=======Prcessing Statement with Good-Turing Smoothing========================");
			probWithGoodSmoothing(convertToArray(stmt));					
		} else {
			System.out.println("Exit.......!!!!");
		}
	}
	public static String [] convertToArray(String nextLine) {
		String [] Line= nextLine.replaceAll("[^a-zA-Z0-9 ]", " ").split("\\s+");
		int trav = 0;
		return Line;
	}
	public static float calCount(String token,String token1) throws FileNotFoundException {
		float count = 0;
		int i;
		String [] nextLine;
		File text = new File(Path);
		Scanner scanText = new Scanner(text);
		while (scanText.hasNextLine()) {
			nextLine = convertToArray(scanText.nextLine());
			for (i=1;i<nextLine.length;i++) {
				if (nextLine[i-1].equalsIgnoreCase(token)&&nextLine[i].equalsIgnoreCase(token1)) {
					count++;
				}	
			}
			if(nextLine[i-1].equalsIgnoreCase(token)) {
				String[] nextLine1 = convertToArray(scanText.nextLine());
				if(nextLine1[0].equalsIgnoreCase(token1)) {
					count++;
					nextLine = nextLine1;
				}
			}
		}
		return count;
	}
	public static float calCount(String token) throws FileNotFoundException {
		float count = 0;
		File text = new File(Path);
		Scanner scanText = new Scanner(text);
		while(scanText.hasNextLine()) {
			String [] nextLine=convertToArray(scanText.nextLine());
			for(int i=0;i<nextLine.length;i++) {
				if (nextLine[i].toLowerCase().equals(token.toLowerCase())) {
					count++;
				}					
			}
		}			
		return count;
	}
	public static void probWithoutSmoothing(String [] inputArray) throws FileNotFoundException {
		double probability=1.0;
		for(int trav=1;trav<inputArray.length;trav++) {
			float numerator= calCount(inputArray[trav-1],inputArray[trav]);
			float denominator= calCount(inputArray[trav-1]);
			System.out.println("C("+inputArray[trav-1]+","+inputArray[trav]+"): "+numerator);
			System.out.println("C("+inputArray[trav-1]+"): "+denominator);
			float individualProbability=(numerator/denominator);
			probability = probability*individualProbability; 
			System.out.println("-- P(("+inputArray[trav-1]+","+inputArray[trav]+")/"+"("+inputArray[trav-1]+"))="+individualProbability);
		}
		System.out.println("Final Probability: "+probability);

	}
	public static void probWithAddOneSmoothing(String [] inputArray) throws FileNotFoundException {
		double probability=1.0;
		for(int trav=1;trav<inputArray.length;trav++) {
			float numerator= calCount(inputArray[trav-1],inputArray[trav]);
			float denominator= calCount(inputArray[trav-1]);
			System.out.println("C("+(inputArray[trav-1])+","+inputArray[trav]+")+1: "+(numerator+1));
			System.out.println("C("+(inputArray[trav-1])+"+V):"+(denominator+V));
			float individualProbability=(numerator+1)/(denominator+V);
			probability = probability*individualProbability; 
			System.out.println("-- P(("+(inputArray[trav-1])+","+inputArray[trav]+")+1/("+(inputArray[trav-1])+"+V))= "+individualProbability);
		}
		System.out.println("Final Probability: "+probability);

	}
	public static void probWithGoodSmoothing(String[] stmt) throws FileNotFoundException {
		HashMap<String, Float> bigramCounts = new HashMap<String, Float>();
		HashMap<Float, Integer> reverseSorted = new HashMap<Float, Integer>();
		float[] mapKeys = new float[100];
		int[] mapValues= new int[100];
		float total_N=0;
		float probability=1;
		for (int trav=1;trav<stmt.length;trav++) {
			String token=(stmt[trav-1]+' '+stmt[trav]).toLowerCase();
			if(!bigramCounts.containsKey(token)) {
				bigramCounts.put(token, calCount(stmt[trav-1], stmt[trav]));
			}
		}	
		for(String key: bigramCounts.keySet()) { 			
			float value1=bigramCounts.get(key);
			if(reverseSorted.containsKey(value1)) {
				reverseSorted.put(value1, reverseSorted.get(value1)+1);
			} else {
				reverseSorted.put(value1, 1);
			}
			total_N=total_N+value1;
		}
		SortedMap<Float, Integer> sortedMap = new TreeMap<>(reverseSorted); //Sorting the HashMap Bucket according to c(The count)
		int index=0;
		for(Float key: sortedMap.keySet()) { 
			mapKeys[index]=key;
			mapValues[index]=sortedMap.get(key);
			index++;
		}		
		for(int i=1;i<index;i++) {
			if(mapKeys[i-1]==0.0) {
				probability=probability*(mapValues[i]/total_N);
				System.out.println("P*("+mapKeys[i-1]+"): "+(mapValues[i]/total_N));
			} else {
				float temp_prob=((mapKeys[i-1]+1)*mapValues[i])/mapValues[i-1];
				probability=probability*(temp_prob/total_N);
				System.out.println("P*("+mapKeys[i-1]+"): "+(temp_prob/total_N));
			}
		}
		System.out.println("Good Turing Probability:"+probability);
	}
}