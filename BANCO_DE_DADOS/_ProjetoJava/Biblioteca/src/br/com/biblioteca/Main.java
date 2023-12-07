package br.com.biblioteca;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Usuario cl = new Usuario();
		
		
        System.out.print("Digite seu nome: ");
        cl.nome = scanner.nextLine();

        System.out.print("Digite seu telefone: ");
        cl.telefone = scanner.nextLine();

        System.out.print("Digite seu email: ");
        cl.email = scanner.nextLine();

        System.out.print("Digite seu rua: ");
        cl.rua = scanner.nextLine();

        System.out.print("Digite seu numero: ");
        cl.numero = scanner.nextLine();

        System.out.print("Digite seu cep: ");
        cl.cep = scanner.nextLine();

        System.out.print("Digite seu bairro: ");
        cl.bairro = scanner.nextLine();
        
        System.out.print("Digite seu cidade: ");
        cl.cidade = scanner.nextLine();

        System.out.print("Digite seu estado: ");
        cl.estado = scanner.nextLine();

        cl.inserir();
        
		
		//cl.consultar();

	}

}
