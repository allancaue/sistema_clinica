package pacotes;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class App {

    public static void main(String[] args) {

        Queue<Cliente> filaClientes = new LinkedList<>();

        Scanner scan = new Scanner(System.in);

        System.out.println("Ficha de Cadastro");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.print("\033[H\033[2J");
        System.out.flush();

        while (true) {
            System.out.print("Incira seu Nome: ");

            String nome = scan.nextLine();
    
            System.out.print("\nIndique sua Idade: ");
    
            int idade = scan.nextInt();

            scan.nextLine();

            Cliente cliente = new Cliente(nome, idade);

            filaClientes.add(cliente);

            System.out.print("Deseja adicionar outro cliente? (s/n): ");
            String resposta = scan.nextLine();
            if (!resposta.equalsIgnoreCase("s")) {
                break;
            }
        }

        while (true) {
            System.out.println("\nClientes na fila:");
            if (filaClientes.isEmpty()) {
                System.out.println("Não há clientes na fila.");
            } else {
                int contador = 1;
                for (Cliente cliente : filaClientes) {
                    System.out.println(contador++ + ". Nome: " + cliente.getNomeCliente() + ", Idade: " + cliente.getIdade());
                }
            }

            System.out.println("\nOpções:");
            System.out.println("1. Chamar próximo cliente");
            System.out.println("2. Adicionar novo cliente");
            System.out.println("3. Sair");

            System.out.print("\nEscolha uma opção: ");
            int opcao = scan.nextInt();
            scan.nextLine(); // Consumir a nova linha pendente

            switch (opcao) {
                case 1:
                    if (filaClientes.isEmpty()) {
                        System.out.println("Não há clientes na fila para chamar.");
                    } else {
                        Cliente clienteAtual = filaClientes.poll(); // Remove e retorna o cliente do início da fila
                        System.out.println("Cliente chamado: " + clienteAtual.getNomeCliente() + ", Idade: " + clienteAtual.getIdade());
                    }
                    break;
                case 2:
                    System.out.print("Insira o nome do novo cliente: ");
                    String nome = scan.nextLine();
                    System.out.print("Insira a idade do novo cliente: ");
                    int idade = scan.nextInt();
                    scan.nextLine(); // Consumir a nova linha pendente
                    Cliente novoCliente = new Cliente(nome, idade);
                    filaClientes.add(novoCliente);
                    System.out.println("Novo cliente adicionado à fila.");
                    break;
                case 3:
                    System.out.println("Saindo...");
                    scan.close();
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                    break;
            }
        }
    }
    
}


