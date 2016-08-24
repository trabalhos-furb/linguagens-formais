package br.com.furb;

public class Palavra {

	private final int linha;
	private final String sequencia;
	private ResultadoProcessamento resultado = ResultadoProcessamento.NAO_PROCESSADO;
	private String reconhecimento;

	public Palavra(int linha, String sequencia) {
		this.linha = linha;
		this.sequencia = sequencia;
	}

	public ResultadoProcessamento getResultado() {
		return resultado;
	}

	public void setResultado(ResultadoProcessamento resultado) {
		this.resultado = resultado;
	}

	public String getReconhecimento() {
		return reconhecimento;
	}

	public void setReconhecimento(String reconhecimento) {
		this.reconhecimento = reconhecimento;
	}

	public int getLinha() {
		return linha;
	}

	public String getSequencia() {
		return sequencia;
	}

}
