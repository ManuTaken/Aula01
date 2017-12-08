# Aula01

package agenda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

public class Agenda {

    public static Connection conexao;
    public static PreparedStatement ps;
    public static ResultSet rs;
    public static ResultSet hs;
    public static String sql;

    public static void main(String[] args) throws SQLException, ParseException {

        int id;
        String nome;
        String endereco;
        String email;
        int numero;

        int opcao = 0;
        String continuar = "";

        Scanner entrada = new Scanner(System.in);

        String usuario = "root";
        String senha = "";
        conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda", usuario, senha);

        do {

            System.out.println("Escolha uma opção: 1-Incluir  2-Listar 3-Atualizar contato 4- Excluir ");
            opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {
                case 1:

                    do {
                        System.out.println("Digite o id: ");
                        id = Integer.parseInt(entrada.nextLine());

                        System.out.print("Digite o nome: ");
                        nome = entrada.nextLine();

                        System.out.print("Digite o endereço: ");
                        endereco = entrada.nextLine();

                        System.out.print("Digite o email: ");
                        email = entrada.nextLine();

                        System.out.print("Digite o telefone: ");
                        numero = Integer.parseInt(entrada.nextLine());

                        conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda", usuario, senha);
                        sql = "INSERT INTO agendas (id, nome, endereco, email, numero) VALUES (?, ?, ?, ?, ?)";
                        ps = conexao.prepareStatement(sql);

                        ps.setInt(1, id);
                        ps.setString(2, nome);
                        ps.setString(3, endereco);
                        ps.setString(4, email);
                        ps.setInt(5, numero);

                        ps.execute();
                        ps.close();
                        conexao.close();

                        System.out.print("Deseja continuar o cadastramento? 1-Sim  2-Nao ");
                        continuar = entrada.nextLine();

                    } while (continuar.equals("1"));

                case 2:
                    conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda", usuario, senha);
                    sql = "SELECT * FROM agenda ORDER BY nome ASC";
                    ps = conexao.prepareStatement(sql);
                    ResultSet rb = ps.executeQuery();

                    while (rb.next()) {
                        System.out.println("Id..:" + rb.getInt("id"));
                        System.out.println("Nome:" + rb.getString("nome"));
                        System.out.println("EndereÃ§o.:" + rb.getString("endereco"));
                        System.out.println("Email.:" + rb.getString("email"));
                        System.out.println("numero.:" + rb.getString("numero"));
                        System.out.println("");
                    }
                    ps.execute();
                    ps.close();
                    conexao.close();
                    break;

                case 3:

                    System.out.println("Digite o nome do contato a ser atualizado ");
                    nome = entrada.nextLine();

                    System.out.print("Digite o endereço: ");
                    endereco = entrada.nextLine();

                    System.out.print("Digite o email: ");
                    email = entrada.nextLine();

                    System.out.print("Digite o telefone: ");
                    numero = Integer.parseInt(entrada.nextLine());

                    conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda", usuario, senha);
                    sql = "UPDATE agenda SET ( nome, endereco, email, numero) VALUES (?, ?, ?, ?) WHERE nome=" + nome;
                    ps = conexao.prepareStatement(sql);
                    rs = ps.executeQuery();
                    ps.execute();
                    ps.close();
                    conexao.close();
                    break;

                case 4:
                    System.out.println("Digite o id do compromisso a ser excluido ");
                    id = Integer.parseInt(entrada.nextLine());
                    conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda", usuario, senha);
                    sql = "DELETE FROM descricao WHERE id=" + id;
                    ps = conexao.prepareStatement(sql);
                    rs = ps.executeQuery();
                    ps.execute();
                    ps.close();
                    conexao.close();

                default:
                    System.out.println("Opcao Invalida! Tente novamente.");
                    break;
            }

        } while (opcao != 4);

    }

}
