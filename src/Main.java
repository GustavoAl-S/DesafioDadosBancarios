import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite seu nome: ");
        String nomeDoCliente = sc.nextLine();

        // Repete até que seja inserido um valor valido
        String tipoDeConta;
        do {
            System.out.println("Digite o seu tipo de conta (Corrente/Poupanca)");
            tipoDeConta = sc.nextLine();

            // Verifica se a pessoa digitou uma conta "Corrente" ou "Poupanca", equalIgnoreCase ignora a diferença de palavras minusculas e maisusculas
            if (!tipoDeConta.equalsIgnoreCase("Corrente") && !tipoDeConta.equalsIgnoreCase("Poupanca")){
                System.out.println("Tipo de conta invalido. Escolha uma conta Corrente ou Poupanca.");
            }
        } while (!tipoDeConta.equalsIgnoreCase("Corrente") && !tipoDeConta.equalsIgnoreCase("Poupanca"));

        // Faz a mesma verificação que a de cima, só que para verificar o deposito de um numero positivo
        double saldo;
        do {
            System.out.println("Digite o valor do deposito inicial: ");
            saldo = sc.nextDouble();
            if (saldo <= 0 ){
                System.out.println("O valor do deposito inicial deve ser positivo.");
            }
        }while (saldo <= 0);


        String menu = """
                ___________________________
                Dados iniciais do cliente:
                
                Nome:           %s
                Tipo de conta:  %s
                Saldo inicial:  R$ %.2f
                ___________________________
                """.formatted(nomeDoCliente, tipoDeConta, saldo);
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
                    System.out.printf("Saldo Atual: R$ %.2f %n", saldo);
                    break;
                case 2:
                    System.out.println("Digite o valor que deseja depositar: ");
                    double deposito = sc.nextDouble();
                    while(deposito <= 0 ){
                        System.out.println("O valor do deposito não pode ser negativo ou zero");

                        System.out.println("Digite o valor que deseja depositar: ");
                        deposito = sc.nextDouble();
                    }
                    saldo += deposito;
                    System.out.printf("Deposito realizado! \n Novo saldo = %.2f %n", saldo);
                    break;
                case 3:
                    System.out.println("Digite o valor que deseja sacar: ");
                    int saque = sc.nextInt();
                    if (saque > saldo) {
                        System.out.println("Operação invalida!");
                        System.out.println("O valor que deseja sacar está indisponivel. Consulte seu saldo para verificar a quantidade disponivel.");
                    } else {
                        saldo -= saque;
                        System.out.printf("Saque realizado! \n Novo saldo = %.2f %n", saldo);
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