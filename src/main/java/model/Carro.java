package model;

public class Carro {
	private Long id;
	private String nome;
	private Integer ano;
	private String cor;
	private String placa;
	private Integer qtde;
	private String novaPlaca;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public Integer getQtde() {
		return qtde;
	}
	public void setQtde(Integer qtde) {
		this.qtde = qtde;
	}
	public String getNovaPlaca() {
		return novaPlaca;
	}
	public void setNovaPlaca(String novaPlaca) {
		this.novaPlaca = novaPlaca;
	}
	@Override
	public String toString() {
		return "Carro [id=" + id + ", nome=" + nome + ", ano=" + ano + ", cor=" + cor + ", placa=" + placa + ", qtde="
				+ qtde + "]";
	}
	
	

}
