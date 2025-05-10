package Main;

import Models.Cliente;
import Models.Conta;
import Models.ContaCorrente;
import Models.ContaPoupanca;

import java.util.Scanner;



public class Aplicacao {
    public static class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            System.out.println("Digite seu nome: ");
            String nomeDoCliente = sc.nextLine();
            Cliente cliente = new Cliente(nomeDoCliente);

            // Repete até que seja inserido um valor valido
            String tipoDeConta;
            Conta conta = null;

            do {
                System.out.println("Digite o seu tipo de conta (Corrente/Poupanca)");
                tipoDeConta = sc.nextLine();

                // Verifica se a pessoa digitou uma conta "Corrente" ou "Poupanca"
                if (Conta.verificarConta(tipoDeConta)){
                    if (tipoDeConta.equalsIgnoreCase("Corrente")){
                        conta = new ContaCorrente(cliente, 0);
                    }
                    if (tipoDeConta.equalsIgnoreCase("Poupanca")){
                        conta = new ContaPoupanca(cliente, 0);
                    }
                } else {
                    System.out.println("Tipo de conta invalido. Escolha uma conta Corrente ou Poupanca.");
                }
            } while (conta == null);

            // Faz a mesma verificação que a de cima, só que para verificar o deposito de um numero positivo
            double saldo;
            do {
                System.out.println("Digite o valor do deposito inicial: ");
                saldo = sc.nextDouble();
            }while (!conta.depositar(saldo));


            String menu = """
                    ___________________________
                    Dados iniciais do cliente:
                    
                    Nome:           %s
                    Tipo de conta:  %s
                    Saldo inicial:  R$ %.2f
                    ___________________________
                    """.formatted(nomeDoCliente, tipoDeConta, conta.getSaldo());
            System.out.println(menu);

            String operacoes = """
                    ___________________________
                    Operaçoes disponiveis:
                    
                    1- Consultar saldo
                    2- Depositar
                    3- Sacar
                    4- Sair
                    
                    Digite a opção desejada:
                    """;

            int opcao;
            do{
                System.out.print(operacoes);
                opcao = sc.nextInt();

                // Eu preferi usar switch Case do que encadear if e elses, fica mais legivel e facil de entender.
                switch (opcao) {
                    case 1:
                        System.out.printf("Saldo Atual: R$ %.2f %n", conta.getSaldo());
                        break;
                    case 2:

                        System.out.println("Digite o valor que deseja depositar: ");
                        double deposito = sc.nextDouble();

                        while(!conta.depositar(deposito)){
                            System.out.println("Digite o valor que deseja depositar: ");
                            deposito = sc.nextDouble();
                        }

                        System.out.printf("Deposito realizado! \n Novo saldo = %.2f %n", conta.getSaldo());
                        break;

                    case 3:
                        System.out.println("Digite o valor que deseja sacar: ");
                        int saque = sc.nextInt();
                        if (!conta.sacar(saque)) {
                            System.out.println("O valor que deseja sacar está indisponivel. Consulte seu saldo para verificar a quantidade disponivel.");
                        } else {
                            System.out.printf("Saque realizado! \n Novo saldo = %.2f %n", conta.getSaldo());
                        }
                        break;

                    case 4:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção nao disponivel.");
                        break;
                }
            } while (opcao != 4);
        }
    }
}
