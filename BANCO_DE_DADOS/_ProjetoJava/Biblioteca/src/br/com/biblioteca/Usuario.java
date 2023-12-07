package br.com.biblioteca;

/*
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 */

import java.sql.*;

public class Usuario {
	
	public String nome, telefone, email, rua, numero, cep, bairro, cidade, estado;
	public int codUsuario;
	public String URL = "jdbc:sqlite:banco.db";
	public Connection connection;
	
	
	public Usuario() {
		System.out.println("instancia OK");
	}
	
	public void conectar() {
		try {
			this.connection = DriverManager.getConnection("jdbc:sqlite:banco.db");
			System.out.println("Tudo certo");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void inserir() {
		this.conectar();
		
		// Definição da query SQL
        String sql = "INSERT INTO Usuario (nome, telefone, email, rua, numero, cep, bairro, cidade, estado) "
        		+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)"; 
        
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sql)) {
               // Atribuição dos valores aos parâmetros do Prepared Statement
	        	preparedStatement.setString(1, nome);
	            preparedStatement.setString(2, telefone);
	            preparedStatement.setString(3, email); 
	            preparedStatement.setString(4, rua); 
	            preparedStatement.setString(5, numero);   
	            preparedStatement.setString(6, cep);  
	            preparedStatement.setString(7, bairro);  
	            preparedStatement.setString(8, cidade);   
	            preparedStatement.setString(9, estado);

               // Execução da consulta
               preparedStatement.executeUpdate();

               System.out.println("Usuario inserido com sucesso!");
           } catch (SQLException e) {
               System.err.println("Erro ao inserir Usuario: " + e.getMessage());
           }
       }
	
	public void consultar() {
		this.conectar();
		
		// Definição da query SQL
        String sql = "SELECT * FROM Usuario"; 
        
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        		ResultSet resultSet = preparedStatement.executeQuery()){
        	
        	
        	while (resultSet.next()) {
        	    // Imprimir os dados do Usuario na tela
        	    System.out.println("Código: " + resultSet.getInt("cod_Usuario"));
        	    System.out.println("Nome: " + resultSet.getString("nome"));
        	    System.out.println("Telefone: " + resultSet.getString("telefone"));
        	    System.out.println("Email: " + resultSet.getString("email"));
        	    System.out.println("Rua: " + resultSet.getString("rua"));
        	    System.out.println("Número: " + resultSet.getString("numero"));
        	    System.out.println("CEP: " + resultSet.getString("cep"));
        	    System.out.println("Bairro: " + resultSet.getString("bairro"));
        	    System.out.println("Cidade: " + resultSet.getString("cidade"));
        	    System.out.println("Estado: " + resultSet.getString("estado"));
        	    System.out.println();
        	}
           } catch (SQLException e) {
               System.err.println("Erro ao inserir Usuario: " + e.getMessage());
           }
       }
    }










