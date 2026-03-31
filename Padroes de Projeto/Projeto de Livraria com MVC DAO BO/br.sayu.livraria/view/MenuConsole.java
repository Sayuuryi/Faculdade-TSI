package br.sayu.livraria.view;

import br.sayu.livraria.controller.BibliotecaController;
import br.sayu.livraria.model.Livro;
import java.util.Scanner;

public class MenuConsole {

    public static void main(String[] args) {
        BibliotecaController controller = new BibliotecaController();
        Scanner sc = new Scanner(System.in);

        int op;
        do {
            System.out.println("\n1 Cadastrar Livro");
            System.out.println("2 Listar Livros Disponíveis");
            System.out.println("3 Realizar Empréstimo");
            System.out.println("4 Devolver Livro");
            System.out.println("5 Sair");
            System.out.print("Escolha: ");

            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:
                    System.out.print("Título: ");
                    String titulo = sc.nextLine();
                    System.out.print("Autor: ");
                    String autor = sc.nextLine();
                    System.out.println(controller.cadastrarLivro(titulo, autor));
                    break;

                case 2:
                    for (Livro l : controller.listarDisponiveis()) {
                        System.out.println(l.getId() + " - " + l.getTitulo() + " / " + l.getAutor());
                    }
                    break;

                case 3:
                    System.out.print("ID do Livro: ");
                    int idEmp = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Leitor: ");
                    String leitor = sc.nextLine();
                    System.out.println(controller.emprestarLivro(idEmp, leitor));
                    break;

                case 4:
                    System.out.print("ID do Livro: ");
                    int idDev = sc.nextInt();
                    sc.nextLine();
                    System.out.println(controller.devolverLivro(idDev));
                    break;
            }
        } while (op != 5);

        sc.close();
    }
}