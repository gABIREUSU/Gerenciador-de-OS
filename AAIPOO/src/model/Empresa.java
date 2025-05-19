package model;

public class Empresa {
	private String nome;
	private String cnpj;
	private String endereco;
	private String tel;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public Empresa(String nome, String cnpj, String endereco, String tel) {
		super();
		this.setNome(nome);
		this.setCnpj(cnpj);
		this.setEndereco(endereco);
		this.setTel(tel);
	}
	
	
	
	
}
