package Tema;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Ex4 
{
	public static Object arrayQAndE(List<String> params, String letter)
	{ 
		return params.stream()
				.map(String::toUpperCase)
		        .filter(w -> w.length() < 4)
		        .filter(w -> w.contains(letter))
		        .collect(Collectors.toCollection(ArrayList::new));
	}
}
