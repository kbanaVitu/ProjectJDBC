
package schooljdbc;

public class StudentSubject{
	private long aluno_matr;
	private int disciplina_cod;
	private float periodo;
	private float nota;
	private int frequencia;
	
	public long getId() {
		return aluno_matr;
	}
	public void setId(long id) {
		this.aluno_matr = id;
	}
	public int getCodigo() {
		return disciplina_cod;
	}
	public void setCodigo(int codigo) {
		this.disciplina_cod = codigo;
	}
	public float getPeriodo() {
		return periodo;
	}
	public void setPeriodo(float periodo) {
		this.periodo = periodo;
	}
	public float getNota() {
		return nota;
	}
	public void setNota(float nota) {
		this.nota = nota;
	}
	public int getFrequencia() {
		return frequencia;
	}
	public void setFrequencia(int frequencia) {
		this.frequencia = frequencia;
	}

}
