package Tema;

import java.util.List;

public class Ex5 
{
	public static String upperConcat(List<String> params)
	{ 
		return params.stream().reduce("", (str1,str2) -> str1.toUpperCase() + str2.toUpperCase());
	}
}
