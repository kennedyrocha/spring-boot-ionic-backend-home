package com.kennedy.cursomc.resources.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class URL {
	
	public static List<Integer> decodeIntList(String s) {
		
		/*List<Integer> lista = new ArrayList<>();
		
		String[] vet = s.split(",");
		
		for (int i = 0; i < vet.length; i++) {
			
			lista.add(Integer.parseInt(vet[i]));
		}
		
		return lista;*/
		
		return Arrays.asList(s.split(",")).stream().map(x -> Integer.parseInt(x)).collect(Collectors.toList());
	}
	
	public static String decodeParam(String s) {
		
		try {
			return URLDecoder.decode(s, "UTF-8");
			
		} catch (UnsupportedEncodingException e) {

			return "";
		}
	}
}
