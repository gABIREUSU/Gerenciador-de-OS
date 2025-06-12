package model;

public class Empresa {
	private int cod;
	private String nome;
	private String cnpj;
	private String endereco;
	private String telefone;

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Empresa(String nome, String cnpj, String endereco, String telefone) {
		super();
		setNome(nome);
		setCnpj(cnpj);
		setEndereco(endereco);
		setTelefone(telefone);
	}

	public Empresa(int Cod_Emp, String nome, String cnpj, String endereco, String telefone) {
		super();
		setCod(Cod_Emp);
		setNome(nome);
		setCnpj(cnpj);
		setEndereco(endereco);
		setTelefone(telefone);
	}

}
