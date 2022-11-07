
package schooljdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Results extends StudentSubject {
	private static String DB_URL = "jdbc:mysql://localhost/school";
	private static String DB_USER = "root";
	private static String DB_PASSWORD = "";

	public void addStudentResults(StudentSubject student) {
		try {
			Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			Statement stmt = conn.createStatement();
			String sqlCommand = "INSERT INTO aluno_disciplina (aluno_matr, disciplina_cod, periodo, nota, frequencia) VALUES ('"
					+ student.getId() + "', '" + student.getCodigo() + "', '" + student.getPeriodo() + "', '"
					+ student.getNota() + "', '" + student.getFrequencia() + "')";

			stmt.executeUpdate(sqlCommand, Statement.RETURN_GENERATED_KEYS);
			int rowsUpdated = stmt.getUpdateCount();
			if (rowsUpdated >= 1) {
				System.out.println("Tupla adicionada!");
			}
			else
				System.out.println("Erro ao adicionar resultado.");
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void studentRecords(StudentSubject records) {
		try {
			Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			Statement stmt = conn.createStatement();

			String sqlCommand = "SELECT  d.nome, ad.periodo, ad.nota, ad.frequencia FROM student s JOIN aluno_disciplina ad ON s.id = ad.aluno_matr JOIN disciplina d ON d.codigo = ad.disciplina_cod where s.id = '"
					+ records.getId() + "'";
			stmt.execute(sqlCommand);

			nome(records);
			ResultSet rs = stmt.getResultSet();

			while (rs.next()) {
				String nome = rs.getString("nome");
				float periodo = rs.getFloat("periodo");
				float nota = rs.getFloat("nota");
				String frequencia = rs.getString("frequencia");
				System.out.println("- Disciplina: " + nome + " - Período: " + periodo + " - Nota: " + nota
						+ " - Frequência: " + frequencia);
			}
			int rowsUpdated = stmt.getUpdateCount();
			if (rowsUpdated < 1) 
				System.out.println("Matrícula informada não existe.");
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void nome(StudentSubject records) {
		try {
			Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			Statement stmt = conn.createStatement();

			String sqlCommand = "SELECT name FROM student WHERE id = '" + records.getId() + "'";
			stmt.execute(sqlCommand);

			ResultSet rs = stmt.getResultSet();

			while (rs.next()) {
				String name = rs.getString("name");
				System.out.println("- Estudante: " + name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void showClass(StudentSubject clas) {
		try {
			Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			Statement stmt = conn.createStatement();

			String sqlCommand = "SELECT ad.aluno_matr, s.name, ad.nota, ad.frequencia FROM aluno_disciplina ad JOIN student s ON ad.aluno_matr = s.id JOIN disciplina d ON ad.disciplina_cod = d.codigo WHERE d.codigo = '"
					+ clas.getCodigo() + "' AND ad.periodo = '" + clas.getPeriodo() + "';";
			stmt.execute(sqlCommand);

			ResultSet rs = stmt.getResultSet();

			while (rs.next()) {
				long aluno_matr = rs.getLong("aluno_matr");
				String name = rs.getString("name");
				float nota = rs.getFloat("nota");
				String frequencia = rs.getString("frequencia");
				System.out.println("- Matrícula: " + aluno_matr + " - Nome: " + name + " - Nota: " + nota
						+ " - Frequência: " + frequencia);
			}
			int rowsUpdated = stmt.getUpdateCount();
			if (rowsUpdated < 1) 
				System.out.println("Codígo de turma ou período não encontrado(s)");
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
