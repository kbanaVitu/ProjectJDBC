package schooljdbc;

import java.util.Scanner;

public class App {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		System.out.println("Bem-vindo ao sistema de manipulação de dados de alunos!");
		StudentManager man = new StudentManager();
		StudentSubject ss = new StudentSubject();
		Subject sb = new Subject();
		SubjectManager sm = new SubjectManager();
		Results r = new Results();
		Student st = new Student();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println(
				"O que deseja fazer? Digite: \n1: Adicionar estudante\n2: Alterar dados de um estudante\n3: Remover estudante\n4: Listar estudantes\n5: Buscar por estudante\n6: Adicionar disciplina\n7: Alterar dados de uma disciplina\n8: Remover disciplina\n9: Listar disciplinas\n10: Adicionar resultado de um estudante\n11: Exibir histórico de um estudante\n12: Exibir turma\n0: Fechar o programa");
		int op = sc.nextInt();
		while (op != 0) {

			if (op == 1) {
				Scanner sc1 = new Scanner(System.in);
				Scanner sc2 = new Scanner(System.in);
				Scanner sc3 = new Scanner(System.in);
				Scanner sc4 = new Scanner(System.in);
				Scanner sc5 = new Scanner(System.in);
				System.out.println("Opção 1 escolhida!\nPor favor, informe o nome do estudante: ");
				String name = sc1.nextLine();
				System.out.println("Informe o email do estdante: ");
				String email = sc2.nextLine();
				System.out.println("Digite o telefone do estudante com DDD (exemplo: '88999999999'): ");
				String telefone = sc3.nextLine();
				System.out.println("Digite a data de nascimento do estudante no formato aaaa-mm-dd: ");
				String data = sc4.nextLine();
				System.out.println("Digite:\n1 Para masculino\n0 para feminino");
				int op1 = sc5.nextInt();
				boolean sexo;
				if (op1 == 1)
					sexo = true;
				else
					sexo = false;

				st.setName(name);
				st.setEmail(email);
				st.setTelefone(telefone);
				st.setData(data);
				st.setSexo(sexo);

				man.addStudent(st);
			}

			else if (op == 2) {
				Scanner sc1 = new Scanner(System.in);
				System.out.println("Opção 2 escolhida!\nDigite a matrícula pertecente à tupla que deseja atualizar: ");
				long id = sc1.nextLong();
			}

			else if (op == 3) {
				Scanner sc1 = new Scanner(System.in);
				System.out.println("Opção 3 escolhida!\nDigite a matrícula pertecente à tupla que deseja remover: ");
			}

			else if (op == 4) {
				System.out.println("Opção 4 escolhida!");
				man.getStudents();
			}

			else if (op == 5) {
				System.out.println("Opção 5 escolhida!");
				man.searchStudent();
			}

			else if (op == 6) {
				Scanner sc1 = new Scanner(System.in);
				Scanner sc2 = new Scanner(System.in);
				System.out.println("Opção 6 escolhida!\nInforme o nome da disciplina: ");
				String nome = sc1.nextLine();
				System.out.println("Informe a quantidade de créditos da disciplina: ");
				int credito = sc2.nextInt();
				sb.setCreditos(credito);
				sb.setNome(nome);
				sm.addSubject(sb);
			}

			else if (op == 7) {
				Scanner sc1 = new Scanner(System.in);
				System.out.println("Opção 7 escolhida!\nInforme o código da disciplina que deseja alterar: ");
				int codigo = sc1.nextInt();
				sb.setCodigo(codigo);
				sm.updateStudent(sb);
			}

			else if (op == 8) {
				Scanner sc1 = new Scanner(System.in);
				System.out.println("Opção 8 escolhida!\nDigite o código da disciplina que deseja remover: ");
				int codigo = sc1.nextInt();
				sb.setCodigo(codigo);
				sm.deleteSubject(sb);
			}

			else if (op == 9) {
				System.out.println("Opção 9 escolhida!");
				sm.getSubjects();

			}

			else if (op == 10) {
				Scanner sc1 = new Scanner(System.in);
				Scanner sc2 = new Scanner(System.in);
				Scanner sc3 = new Scanner(System.in);
				Scanner sc4 = new Scanner(System.in);
				Scanner sc5 = new Scanner(System.in);
				System.out.println("Opção 10 escolhida!\nInforme a matrícula do estudante: ");
				long id = sc1.nextLong();
				System.out.println("Informe o código da disciplina: ");
				int cod = sc2.nextInt();
				System.out.println("Informe o período: ");
				float periodo = sc3.nextFloat();
				System.out.println("Informe a nota do estudante: ");
				float nota = sc4.nextFloat();
				System.out.println("Informe a frenquência do estudante: ");
				int frequencia = sc5.nextInt();

				ss.setCodigo(cod);
				ss.setFrequencia(frequencia);
				ss.setId(id);
				ss.setNota(nota);
				ss.setPeriodo(periodo);
				r.addStudentResults(ss);
			}

			else if (op == 11) {
				Scanner sc1 = new Scanner(System.in);
				System.out.println("Opção 11 escolhida!\nInforme a matrícula do aluno para ver suas disciplinas: ");
				long id = sc1.nextLong();

				ss.setId(id);
				r.studentRecords(ss);
			}

			else if (op == 12) {
				Scanner sc1 = new Scanner(System.in);
				Scanner sc2 = new Scanner(System.in);
				System.out.println("Informe o código da discplina desejada: ");
				int codigo = sc1.nextInt();
				System.out.println("Informe o período: ");
				float periodo = sc2.nextFloat();

				ss.setCodigo(codigo);
				ss.setPeriodo(periodo);
				r.showClass(ss);
			} else {
				System.out.println("Apenas opções de 0 a 4!!");
			}
			sc = new Scanner(System.in);
			System.out.println(
					"O que deseja fazer? Digite: \n1: Adicionar estudante\n2: Alterar dados de um estudante\n3: Remover estudante\n4: Listar estudantes\n5: Buscar por estudante\n6: Adicionar disciplina\n7: Alterar dados de uma disciplina\n8: Remover disciplina\n9: Listar disciplinas\n10: Adicionar resultado de um estudante\n11: Exibir histórico de um estudante\n12: Exibir turma\n0: Fechar o programa");
			op = sc.nextInt();

		}
		System.out.println("Programa finalizado!");
	}
}
