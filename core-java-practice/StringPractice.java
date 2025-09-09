/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;
public class StringPractice
{
	public static void main(String[] args) {
		//count the number of repeted character from given String
		countNumberOfchar();
		
		//count the number of repeted character from given String by using map
		countNumberOfcharUsingMap();
		
		// remove duplicates from given String
		remvoeDuplicates();
		
		// count vowles and consonents
		printNumberOfVowelsAndConsonents();
		
		
		// return index of given number with in the range
		printIndexOfrangeNumbers();
		
		//reverse the given String and chec paindrome or not
		palindromeOrNot();
		
		//reverse the given number
		reverseTheGivenNumber();
	}
	
	private static void countNumberOfchar(){
	    String word = "aabbcccccdddd";
	    StringBuilder stb = new StringBuilder();
	    int count = 1;
	    for(int i =0; i < word.length()-1; i++){
	        if(word.charAt(i) == word.charAt(i+1)){
	            count++;
	        }
	        else{
	            stb.append(count).append(word.charAt(i));
	            count = 1;
	        }
	        
	        
	    }
	    
	    stb.append(count).append(word.charAt(word.length()-1));
	    System.out.println(stb);
	}
	
	private static void countNumberOfcharUsingMap(){
	    String word = "aabbcccccdddd";
	    Map<Character, Integer> mapOfChar = new HashMap<>();
	    for(char ch : word.toCharArray()){
	        mapOfChar.put(ch, mapOfChar.getOrDefault(ch, 0) +1);
	    }
	    
	    System.out.println("given map details :" + mapOfChar);
	}
	
	private static void remvoeDuplicates(){
	   String word = "aabbcccccdddd";
	   String emptyString = "";
	   for(int i =0; i< word.length()-1; i++){
	       char ch = word.charAt(i);
	       if(emptyString.indexOf(ch) ==-1){
	           emptyString+=ch;
	       }
	   }
	   System.out.println("result after removal of duplicates : " +emptyString);
	}
	
	private static void printNumberOfVowelsAndConsonents(){
	    String word = "aabbcccccdddd";
	    int vowels = 0;
	    int consonents = 0;
	    for(int i=0; i < word.length()-1; i++){
	        char ch = word.charAt(i);
	        if("aeiou".indexOf(ch) >= 0){
	            vowels++;
	        }
	        else{
	            consonents++;
	        }
	    }
	    
	    System.out.println("number of vowels are :" + vowels);
	    System.out.println("number of consonents are : " + consonents);
	}
	
	private static void printIndexOfrangeNumbers(){
	    int[] arr = {1,2,3,4,5,6,7};
	    int number = 11;
	    List<Integer> list = new ArrayList<>();
	    Map<Integer, Integer> map = new HashMap<>();
	    for(int i = 0; i < arr.length; i++){
	        int remainingValue = number-arr[i];
	        if(map.containsKey(remainingValue)){
	            list.add(map.get(remainingValue)); //4 is there already, then index is 3
	            list.add(i);// 6
	        }
	        map.put(arr[i],i);
	    }
	    
	    System.out.println("range indexes are :" +list);

	}
	
	private static void palindromeOrNot(){
	    String name = "mama";
	    String reversedString = "";
	    for(int i = name.length()-1; i>=0; i--){
	        reversedString+= name.charAt(i);
	    }
	    if(name.equals(reversedString)){
	        System.out.println("the given string is palindrome : " + reversedString);
	    }
	    else{
	        System.out.println("given string is not palindrome");
	    }
	}
	
	private static void reverseTheGivenNumber(){
	    int number = 12345;
	    int reversedNumber = 0;
	    while(number > 0){
	        reversedNumber = reversedNumber*10 + number%10;
	       number= number/10;
	    }
	    System.out.println("reversed number is : " + reversedNumber);
	    
	}
}