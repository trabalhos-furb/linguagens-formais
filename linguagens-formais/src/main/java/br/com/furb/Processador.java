package br.com.furb;

public class Processador {

	private Palavra palavra;
	private char[] caracteres;
	private int indiceAtual;
	private String reconhecimento = "";

	public void processar(Palavra palavra) {
		this.palavra = palavra;
		this.caracteres = palavra.getSequencia().toCharArray();
		this.indiceAtual = 0;
		q0();
		this.palavra.setReconhecimento(this.reconhecimento);
	}

	private void palavraInvalida() {
		this.palavra.setResultado(ResultadoProcessamento.PALAVRA_INVALIDA);
		this.reconhecimento += "qerro";
	}

	private void palavraValida() {
		this.palavra.setResultado(ResultadoProcessamento.PALAVRA_VALIDA);
	}

	private boolean terminouPalavra() {
		return indiceAtual == this.caracteres.length;
	}

	private char getCaracterAtual() {
		char c = caracteres[indiceAtual];
		indiceAtual++;
		return c;
	}

	private void q0() {
		this.reconhecimento += "q0, ";
		char c = getCaracterAtual();
		if (PreProcessador.isSimboloEspecial(c)) {
			this.palavra.setResultado(ResultadoProcessamento.SIMBOLO_ESPECIAL);
		} else if (c == 'a') {
			q1q5();
		} else if (c == 'b' || c == 'c') {
			q7();
		} else {
			this.palavra.setResultado(ResultadoProcessamento.SIMBOLOS_INVALIDOS);
			this.reconhecimento += "qerro";
		}

	}

	private void q7() {
		this.reconhecimento += "q7, ";
		char c = getCaracterAtual();
		if (terminouPalavra()) {
			palavraValida();
		} else if (c == 'b' || c == 'c') {
			q8();
		} else {
			palavraInvalida();
		}

	}

	private void q8() {
		this.reconhecimento += "q8, ";
		char c = getCaracterAtual();
		if (c == 'b' || c == 'c') {
			q7();
		} else {
			palavraInvalida();
		}
	}

	private void q1q5() {
		this.reconhecimento += "q1q5, ";
		char c = getCaracterAtual();
		if (c == 'a') {
			q1q6();
		} else if (c == 'b') {
			q2();
		} else if (terminouPalavra()) {
			palavraValida();
		} else {
			palavraInvalida();
		}

	}

	private void q2() {
		this.reconhecimento += "q2, ";
		char c = getCaracterAtual();
		if (c == 'a') {
			q3();
		} else {
			palavraInvalida();
		}

	}

	private void q3() {
		this.reconhecimento += "q3, ";
		char c = getCaracterAtual();
		if (c == 'a') {
			q4();
		} else if (c == 'b') {
			q2();
		} else if (terminouPalavra()) {
			palavraValida();
		} else {
			palavraInvalida();
		}
	}

	private void q4() {
		this.reconhecimento += "q4, ";
		char c = getCaracterAtual();
		if (c == 'a') {
			q3();
		} else {
			palavraInvalida();
		}
	}

	private void q1q6() {
		this.reconhecimento += "q1q6, ";
		char c = getCaracterAtual();
		if (c == 'a') {
			q1q5();
		} else if (c == 'b') {
			q2q7();
		} else if (c == 'c') {
			q7();
		} else if (terminouPalavra()) {
			palavraValida();
		} else {
			palavraInvalida();
		}
	}

	private void q2q7() {
		this.reconhecimento += "q2, ";
		char c = getCaracterAtual();
		if (c == 'a') {
			q3();
		} else if (c == 'b' || c == 'c') {
			q8();
		} else if (terminouPalavra()) {
			palavraValida();
		} else {
			palavraInvalida();
		}

	}

}
