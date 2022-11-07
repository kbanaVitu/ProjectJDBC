package schooljdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

public class SubjectManager extends Subject {

	private static String DB_URL = "jdbc:mysql://localhost/school";
	private static String DB_USER = "root";
	private static String DB_PASSWORD = "";

	public void addSubject(Subject subject) {
		try {
			Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			Statement stmt = conn.createStatement();
			String sqlCommand = "INSERT INTO disciplina (nome, creditos) VALUES ('" + subject.getNome() + "', '"
					+ subject.getCreditos() + "')";

			stmt.executeUpdate(sqlCommand, Statement.RETURN_GENERATED_KEYS);
			int rowsUpdated = stmt.getUpdateCount();
			if (rowsUpdated >= 1) 
				System.out.println("Tupla adicionada!");
			else
				System.out.println("Erro ao adicionar.");
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<Subject> getSubjects() {
		try {
			Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			Statement stmt = conn.createStatement();

			String sqlCommand = "SELECT * FROM disciplina";
			stmt.execute(sqlCommand);

			ResultSet rs = stmt.getResultSet();

			while (rs.next()) {
				int codigo = rs.getInt("codigo");
				String nome = rs.getString("nome");
				int creditos = rs.getInt("creditos");
				System.out.println("Código: " + codigo + " - Nome: " + nome + " - Créditos: " + creditos);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}

	public void updateStudent(Subject subject) {
		try {

			Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			Statement stmt = conn.createStatement();
			Scanner scanner = new Scanner(System.in);
			String newName = "";
			String newCreditos;

			int codigo = subject.getCodigo();
			System.out.println("Digite o novo nome: ");
			newName += scanner.nextLine();
			System.out.println("Digite a nova quantidade de créditos: ");
			newCreditos = scanner.nextLine();

			String sqlCommand = "UPDATE disciplina SET nome = '" + newName + "', creditos = '" + newCreditos
					+ "' WHERE codigo = " + codigo;
			stmt.execute(sqlCommand);

			int rowsUpdated = stmt.getUpdateCount();
			if (rowsUpdated >= 1) 
				System.out.println("Tupla cujo códito era " + codigo + " foi atualizada!");
			else
				System.out.println("Codígo de turma não encontrado");

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteSubject(Subject subject) {

		try {
			Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			Statement stmt = conn.createStatement();
			int codigo = subject.getCodigo();
			String sqlCommand = "DELETE FROM disciplina  WHERE codigo = " + codigo;

			stmt.execute(sqlCommand);
			int rowsUpdated = stmt.getUpdateCount();
			if (rowsUpdated >= 1) 
				System.out.println("Tupla cujo códito era " + codigo + " foi atualizada!");
			else
				System.out.println("Codígo de turma não encotrado");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
