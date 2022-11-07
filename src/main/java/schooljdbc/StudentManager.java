package schooljdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

public class StudentManager extends Student {

	private static String DB_URL = "jdbc:mysql://localhost/school";
	private static String DB_USER = "root";
	private static String DB_PASSWORD = "";

	public void addStudent(Student student) {
		try {
			int a;
			if (student.isSexo())
				a = 1;
			else
				a = 0;
			Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			Statement stmt = conn.createStatement();
			String sqlCommand = "INSERT INTO student (name, email, telefone,data_nasc, sexo) VALUES ('"
					+ student.getName() + "', '" + student.getEmail() + "', '" + student.getTelefone() + "', '"
					+ student.getData() + "', '" + a + "')";

			stmt.executeUpdate(sqlCommand, Statement.RETURN_GENERATED_KEYS);
			int rowsUpdated = stmt.getUpdateCount();
			if (rowsUpdated >= 1) 
				System.out.println("Tupla adicionada!");
			else
				System.out.println("Erro ao adicionar estudante.");
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<Student> getStudents() {
		try {
			Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			Statement stmt = conn.createStatement();

			String sqlCommand = "SELECT * FROM student";
			stmt.execute(sqlCommand);

			ResultSet rs = stmt.getResultSet();

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String telefone = rs.getString("telefone");
				String data = rs.getString("data_nasc");
				boolean sexo = rs.getBoolean("sexo");
				String a;
				if (sexo)
					a = "M";
				else
					a = "F";
				System.out.println("Matrícula: " + id + " - Name: " + name + " - Email: " + email + " - Telefone: "
						+ telefone + " - Data de nascimento: " + data + " - Sexo: " + a);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}

	public void updateStudent(Student student) {
		try {

			Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			Statement stmt = conn.createStatement();
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			String newName;
			String newEmail;
			String newTelefone;
			String newData;
			boolean newSexo;
			System.out.println("Informe o novo nome: ");
			newName = scanner.nextLine();
			System.out.println("Informe o novo email: ");
			newEmail = scanner.nextLine();
			System.out.println("Informe o novo  telefone (exemplo: '88999999999'): ");
			newTelefone = scanner.nextLine();
			System.out.println("Informe a nova data de nascimento(com formtando aaaa-mm-dd): ");
			newData = scanner.nextLine();
			System.out.println("Digite:\n1 Para masculino\n0 para feminino");
			int op1 = scanner.nextInt();
			if (op1 == 1)
				newSexo = true;
			else
				newSexo = false;

			String sqlCommand = "UPDATE student SET name = '" + newName + "', email = '" + newEmail + "', telefone = '"
					+ newTelefone + "', data_nasc = '" + newData + "', sexo = '" + newSexo + "' WHERE id = "
					+ student.getId();
			stmt.execute(sqlCommand);

			int rowsUpdated = stmt.getUpdateCount();
			if (rowsUpdated >= 1) 
				System.out.println("Tupla cuja matrícula era " + student.getId() + " foi atualizada!");
			else
				System.out.println("Matrícula informada não existente.");

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteStudent(Student student) {

		try {
			Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			Statement stmt = conn.createStatement();
			long id = student.getId();
			String sqlCommand = "DELETE FROM student  WHERE id = " + id;

			stmt.execute(sqlCommand);
			int rowsUpdated = stmt.getUpdateCount();
			if (rowsUpdated >= 1) 
				System.out.println("Tupla cuja matrícula era " + id + " foi removida!");
			else
				System.out.println("Matrícula informada não encontrada.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void searchStudent() {
		try {
			Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			Statement stmt = conn.createStatement();
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			System.out.println("Digite o nome ou o email que deseja buscar: ");
			String busca = sc.nextLine();
			String sqlCommand = "select * from student where name LIKE '%" + busca + "%' or email LIKE '%" + busca
					+ "%';";

			stmt.execute(sqlCommand);

			ResultSet rs = stmt.getResultSet();

			while (rs.next()) {
				long id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String telefone = rs.getString("telefone");
				String data = rs.getString("data_nasc");
				boolean sexo = rs.getBoolean("sexo");
				String a;
				if (sexo)
					a = "M";
				else
					a = "F";
				System.out.println("Matrícula: " + id + " - Name: " + name + " - Email: " + email + " - Telefone: "
						+ telefone + " - Data de nascimento: " + data + " - Sexo: " + a);
			}int rowsUpdated = stmt.getUpdateCount();
			if (rowsUpdated >= 1) {
				System.out.println("Tupla adicionada!");
			}
			else
				System.out.println("Nenhum estudante encontrado.");

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}