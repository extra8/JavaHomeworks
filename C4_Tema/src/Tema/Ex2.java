package Tema;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Ex2 
{	
	public static List<String> transformedList(List<String> params, Function<String, String> condition)
	{ 
		return params.stream().map(condition).collect(Collectors.toList());	}
}
