package Tema;

import java.util.Arrays;
import java.util.List;

public class Start 
{
	public static void main(String[] args)
	{
		List<String> words = Arrays.asList("EbQ","EiiQ","EibbiQ","EiiiiQ");
		System.out.println(words);
		System.out.println("------------------------------------------------------------------------------------------------------------");

		List<String> shortWords = Ex1.allMatches(words, s -> s.length() < 4);
		System.out.println(shortWords);
		List<String> wordsWithB = Ex1.allMatches(words, s -> s.contains("b"));
		System.out.println(wordsWithB);
		List<String> evenLengthWords = Ex1.allMatches(words, s -> (s.length() % 2) == 0);
		System.out.println(evenLengthWords);
		System.out.println("------------------------------------------------------------------------------------------------------------");
		
		
		List<String> exclamationWords = Ex2.transformedList(words, s -> s + "!");
		System.out.println(exclamationWords);
		List<String> eyeWords = Ex2.transformedList(words, s -> s.replace("i", "eye"));
		System.out.println(eyeWords);
	    List<String> upperCaseWords = Ex2.transformedList(words, String::toUpperCase);
	    System.out.println(upperCaseWords);
	    System.out.println("------------------------------------------------------------------------------------------------------------");
	    
	    
	    List<String> e = Ex3.filteringQAndE(words, "E");
	    System.out.println(e);
	    List<String> q = Ex3.filteringQAndE(words, "Q");
	    System.out.println(q);
	    System.out.println("------------------------------------------------------------------------------------------------------------");
	    
	    
	    Object ea = Ex4.arrayQAndE(words, "E");
	    System.out.println(ea);
	    Object qa = Ex4.arrayQAndE(words, "Q");
	    System.out.println(qa);
	    System.out.println("------------------------------------------------------------------------------------------------------------");
	    

		String upperConcat = Ex5.upperConcat(words);
		System.out.println(upperConcat);
	}
}
