package database;



import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.util.Scanner;



public class Database {



    public static Connection conexao;

    public static PreparedStatement ps;

    public static ResultSet rs;

    public static ResultSet hs;

    public static String sql;



    public static void main(String[] args) throws SQLException {



        int id;

        String nome;

        String cpf;



        Scanner in = new Scanner(System.in);



        System.out.println("Digite o Id");

        id = Integer.parseInt(in.nextLine());



        System.out.println("Digite o Nome");

        nome = in.nextLine();



        System.out.println("Digite o Cpf");

        cpf = in.nextLine();



        String usuario = "root";

        String senha = "";

        conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/cadastro", usuario, senha);



        sql = "INSERT INTO contato (id, nome, cpf) VALUES (?, ?, ?)";

        ps = conexao.prepareStatement(sql);



        ps.setInt(1, id);

        ps.setString(2, nome);

        ps.setString(3, cpf);



        ps.execute();

        ps.close();

        conexao.close();



        System.out.println("\n\nListando os Registros Gravados");

        

        // Leitura do Banco de Dados

        conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/cadastro", usuario, senha);

        sql = "SELECT * FROM contato ORDER BY nome";

        ps = conexao.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();



        while (rs.next()) {

            System.out.println("Id..:" + rs.getInt("id"));

            System.out.println("Nome:" + rs.getString("nome"));

            System.out.println("Cpf.:" + rs.getString("cpf"));

            System.out.println("");

        }

        

        

        // Atualização de um nome

        

        

        System.out.println("Digite o novo nome");

        nome = in.nextLine();

        

        System.out.println("Digite o Id para mudar");

        id = Integer.parseInt(in.nextLine());

        

        conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/cadastro", usuario, senha);



        sql = "UPDATE contato SET nome = ? where id = ?";

        ps = conexao.prepareStatement(sql);



        ps.setString(1, nome);

        ps.setInt(2, id);

        

        ps.execute();

        ps.close();

        conexao.close();



        System.out.println("\n\nValores atualizados");

        

        

        //Deletar um campo por meio de um ID

        

        System.out.println("Digite o Id para apagar");

        id = Integer.parseInt(in.nextLine());

        

        conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/cadastro", usuario, senha);



        sql = "DELETE FROM contato WHERE id = ?";

        ps = conexao.prepareStatement(sql);



        ps.setInt(1, id);

        

        ps.execute();

        ps.close();

        conexao.close();



        System.out.println("\n\nRegistros Apagados");

        System.out.println("");

         System.out.println("\n\nLista após alterações"); 

        

        conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/cadastro", usuario, senha);

        sql = "SELECT * FROM contato ORDER BY nome";

        ps = conexao.prepareStatement(sql);

        ResultSet hs = ps.executeQuery();



        while (hs.next()) {

            System.out.println("Id..:" + hs.getInt("id"));

            System.out.println("Nome:" + hs.getString("nome"));

            System.out.println("Cpf.:" + hs.getString("cpf"));

            System.out.println("");

        

    }

    

    }

}
