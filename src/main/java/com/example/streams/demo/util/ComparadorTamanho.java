package com.example.streams.demo.util;

import java.util.Comparator;

/**
 * Classe responsável por ordernar uma string por tamanho
 * 
 * @author jlv
 *
 */
public class ComparadorTamanho implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {

		if (s1.length() < s2.length())
			return -1;

		if(s1.length() > s2.length())
			return 1;
		
		return 0;
	}

}
