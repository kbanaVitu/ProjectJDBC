package schooljdbc;

public class Student {
	private long id;
	private String name;
	private String email;
	private String telefone;
	private String data;	
	private boolean sexo;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public boolean isSexo() {
		return sexo;
	}
	public void setSexo(boolean sexo) {
		this.sexo = sexo;
	}

}
