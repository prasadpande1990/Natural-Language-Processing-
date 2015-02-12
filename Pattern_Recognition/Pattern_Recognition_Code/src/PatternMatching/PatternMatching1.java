package PatternMatching;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatching1 {

	public static String path;
	public static String DatePattern ="\\s*[0-9]+(st|nd|rd|th)?\\s*,?";
	public static String YearPattern="\\W?[0-9]{2,4},?\\W?";
	public static String MonthPattern="\\W?(January|February|March|April|May|June|July|August|September|October|November|December)\\s?,?";
	public static String HolidayPattern = "^.*\\W?\\s?,?(Labor Day|Christmas|Independence day|Martin Luther King Day|Presidents Day|Memorial Day|Thanksgiving)\\s?,?.*$";
	public static Pattern pattern = Pattern.compile(DatePattern,Pattern.CASE_INSENSITIVE);
	public static Pattern pattern1 = Pattern.compile(YearPattern,Pattern.CASE_INSENSITIVE);
	public static Pattern pattern2 = Pattern.compile(MonthPattern,Pattern.CASE_INSENSITIVE);
	public static Pattern pattern3 = Pattern.compile(HolidayPattern,Pattern.CASE_INSENSITIVE);
	public static void main(String[] args) throws FileNotFoundException {
		String monthVal;
		String [] month;
		Scanner ip = new Scanner(System.in);
		System.out.print("Enter the filename with complete path");
		System.out.println(" For e.g.(F:\\Assignments\\Sample_1.txt)");
		path = ip.nextLine();  		
		File text = new File(path);
		Scanner scanText = new Scanner(text);
		while (scanText.hasNextLine()) {
			String [] nextLine = Convert2Array(scanText.nextLine());
			for (int index=0;index<nextLine.length;index++) {
				if(matchMonth(nextLine[index])){         //This main If loop is for the patterns starting with month first e.g. January 1st,1990
					if(index == nextLine.length-1) {     //This condition is valid if the month is detected as the last character of the line before EoF
						System.out.println(nextLine[index]);
						String [] nextLine1 = Convert2Array(scanText.nextLine());
						int index1=0;
						if(matchDate(nextLine1[index1])) {
							if(matchYear(nextLine1[index1+1])) {
								System.out.println(nextLine1[index1]+" "+nextLine1[index1+1]);
								index1 = index1+2;
							}
							else {
								//This else is for patterns like May 20th of where year is not present
								if(nextLine1[index1+1].equals("of")) {
									if(matchYear(nextLine1[index+2])) {
										System.out.println(nextLine1[index1]+" "+nextLine1[index+1]+" "+nextLine1[index+2]);
										index1 = index+3;
									} else {
										System.out.println(nextLine1[index1]);
									}
								}else {
									System.out.println(nextLine1[index1]);
									index1 = index1+1;
								}
							}
						}
						else {
							// This else will be used for the string pattern 29,1990
							System.out.println(nextLine1[index1]);
							index1 = index1+1;
					} 
					nextLine = nextLine1;
					index = index1;
					continue;
					}
					else if (index == nextLine.length-2) {  //This condition will verify if Last 2 words of the lines are Month and year e.g. January 1990 before EOF
						System.out.println(""+nextLine[index]+" "+nextLine[index+1]);
						String [] nextLine1 = Convert2Array(scanText.nextLine());
						int index1=0;
						if(matchYear(nextLine1[index1])) {
							System.out.println(nextLine1[index1]);
							index1= index1+1;
						}
						nextLine = nextLine1;
						index = index1;
						continue;
					} else {
					if(matchDate(nextLine[index+1])) {
							if(matchYear(nextLine[index+2])) {
								System.out.println(nextLine[index]+" "+nextLine[index+1]+" "+nextLine[index+2]);
								index = index+3;
							}
							else {
								//This else is for patterns like May 20th of where year is not present
								if(nextLine[index+2].equals("of")) {
									if(matchYear(nextLine[index+3])) {
										System.out.println(nextLine[index]+" "+nextLine[index+1]+" "+nextLine[index+2]+" "+nextLine[index+3]);
										index = index+4;
									}
								}else {
									System.out.println(nextLine[index]+" "+nextLine[index+1]);
									index = index+2;
								}
							}
						}
						else {
							// This else will be used for the string pattern 29,1990
							System.out.println(nextLine[index]+" "+nextLine[index+1]);
							index = index+2;
						} 
					}	
				}
				else{   //Else will match the condition where pattern like 20th of January 1990 will occur 
					if(matchDate(nextLine[index])){
						if(index == nextLine.length-1) { //This if condition will be considered if 20th in (20th January 1990) occur as last character of the line 
							String [] nextLine1 = Convert2Array(scanText.nextLine());
							int index1=0;
							if (nextLine1[index1].equals("of")) {
								if(nextLine1[index1+1].contains(",")) {
									month = nextLine1[index1+1].split(",");
									monthVal = month[0];
								} else {
									monthVal = nextLine1[index+1];
									
								}
								if(matchMonth(monthVal)){
									if(matchYear(nextLine1[index1+2])){
										System.out.println(nextLine[index]+" "+nextLine1[index1]+" "+nextLine1[index1+1]+" "+nextLine1[index1+2]);
										index1 = index1 +3;
									}else{
										System.out.println(nextLine[index]+" "+nextLine1[index1]+" "+nextLine1[index1+1]);
										index1 = index1 +2;
									}
								}
							} 		
							nextLine = nextLine1;
							index= index1;
							continue;
						} else if (index == nextLine.length-2) { //This block will verify if "20th of" are the last 2 characters in the line before EoF 
							String [] nextLine1 = Convert2Array(scanText.nextLine());
							int index1=0;
							if(nextLine1[index1].contains(",")) {
								month = nextLine1[index1].split(",");
								monthVal = month[0];
							} else {
								monthVal = nextLine1[index1];
								
							}
							if(matchMonth(monthVal)){
								if(matchYear(nextLine1[index1+1])){
									System.out.println(nextLine[index]+" "+nextLine[index+1]+" "+nextLine1[index1]+" "+nextLine1[index1+1]);
									index1 = index1 +2;
								}else{
									System.out.println(nextLine[index]+" "+nextLine[index+1]+" "+nextLine1[index1]);
									index1 = index1 +1;
								}
							}		
							nextLine = nextLine1;
							index= index1;
							continue;							
						} else if (index == nextLine.length-3) { //This block will verify if "20th of January" are the last 2 characters in the line before EoF
							System.out.println(nextLine[index]+" "+nextLine[index+1]+" "+nextLine[index+2]);
							String [] nextLine1 = Convert2Array(scanText.nextLine());
							int index1=0;
							if(matchYear(nextLine1[index1])) {
								System.out.println(nextLine1[index1]);
								index1=index1+1;
							}
							nextLine = nextLine1;
							index= index1;
							continue;
						} else {
							if (nextLine[index+1].equals("of")) {
								if(nextLine[index+2].contains(",")) {
									month = nextLine[index+2].split(",");
									monthVal = month[0];
								} else {
									monthVal = nextLine[index+2];
									
								}
								if(matchMonth(monthVal)){
									if(matchYear(nextLine[index+3])){
										System.out.println(nextLine[index]+" "+nextLine[index+1]+" "+nextLine[index+2]+" "+nextLine[index+3]);
										index = index +4;
									}else{
										System.out.println(nextLine[index]+" "+nextLine[index+1]+" "+nextLine[index+2]);
										index = index +3;
									}
								}
							} 
						}
					} else {
						continue;
					}	
				}
			}
		}
		matchHolidays();
	}
	public static String [] Convert2Array(String nextLine) {
		String[] lineArray = nextLine.split("\\s+");
	   return lineArray;
	}
	public static boolean matchDate(String token) { //Function will return True if Given token match the Date Pattern else False
		Matcher matcher= pattern.matcher(token);
		if (matcher.matches()) {
		return true;
		} else {
			return false;
		}
	}
	public static boolean matchYear(String token) { //Function will return True if Given token match the Year Pattern else False
		Matcher matcher= pattern1.matcher(token);
		if (matcher.matches()) {
		return true;
		} else {
			return false;
		}
	}
	public static boolean matchMonth(String token) {
		Matcher matcher= pattern2.matcher(token);
		if (matcher.matches()) {
		return true;
		} else {
			return false;
		}
	}
	public static void matchHolidays() throws FileNotFoundException {
		File text = new File(path);
		Scanner scanText = new Scanner(text);
		while (scanText.hasNextLine()) {
			String nextLine = scanText.nextLine();
			Matcher matcher=pattern3.matcher(nextLine);
			if(matcher.matches()){
				System.out.println(matcher.group(1));
			}
		}
	}
}
