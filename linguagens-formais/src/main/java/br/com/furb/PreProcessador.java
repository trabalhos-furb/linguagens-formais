package br.com.furb;

import java.util.ArrayList;
import java.util.List;

public class PreProcessador {

	private static final char[] CARACTERES_BRANCOS = new char[] {'\n', '\t', ' ', '\r'};
	private static final char[] SIMBOLOS_ESPECIAIS = new char[] {';', ',', '.'};
	private List<String> palavras = new ArrayList<>();
	
	public String[] processar(String texto) {
		char[] simbolos = texto.toCharArray();
		String palavra = "";
		for (char c : simbolos) {
			if (isCaractereBranco(c)) {
				addPalavra(palavra);
				palavra = "";
			} else if (isSimboloEspecial(c)) {
				addPalavra(palavra);
				addPalavra(String.valueOf(c));
				palavra = "";
			} else {
				palavra += c;
				
			}
		}
		addPalavra(palavra);
		return palavras.toArray(new String[palavras.size()]);
	}

	private void addPalavra(String palavra) {
		if (!palavra.isEmpty()) {
			palavras.add(palavra);
		}
	}

	private boolean isCaractereBranco(char c) {
		for (char character : CARACTERES_BRANCOS) {
			if (character == c) {
				return true;
			}
		}
		return false;
	}
	
	private boolean isSimboloEspecial(char c) {
		for (char caractere : SIMBOLOS_ESPECIAIS) {
			if (caractere == c) {
				return true;
			}
		}
		return false;
	}

}
