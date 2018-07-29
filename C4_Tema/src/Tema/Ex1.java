package Tema;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Ex1 
{
	public static List<String> allMatches(List<String> params, Predicate<String> condition)
	{ 
		return params.stream().filter(condition).collect(Collectors.toList());
	}
}
