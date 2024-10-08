import java.util.Scanner;

public class SistemaBancario {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao Sistema Bancário!");
        System.out.println("Selecione o tipo de conta:");
        System.out.println("1. Conta Corrente");
        System.out.println("2. Conta Poupança");
        int opcaoConta = scanner.nextInt();
        scanner.nextLine();

        ContaBancaria conta = null;

        System.out.print("Digite o nome do titular: ");
        String titular = scanner.nextLine();

        if (opcaoConta == 1) {
            conta = new ContaCorrente(titular);
        } else if (opcaoConta == 2) {
            System.out.print("Digite a taxa Selic atual (%): ");
            double selic = scanner.nextDouble();
            conta = new ContaPoupanca(titular, selic);
        }

        boolean sair = false;

        while (!sair) {
            System.out.println("\nSelecione uma operação:");
            if (conta instanceof ContaCorrente) {
                System.out.println("1. Depositar");
                System.out.println("2. Sacar");
                System.out.println("3. Usar Cheque Especial");
                System.out.println("4. Exibir dados da conta");
                System.out.println("5. Sair");
            } else if (conta instanceof ContaPoupanca) {
                System.out.println("1. Depositar");
                System.out.println("2. Sacar");
                System.out.println("3. Calcular rendimento");
                System.out.println("4. Exibir dados da conta");
                System.out.println("5. Sair");
            }

            int opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor para depositar: ");
                    double deposito = scanner.nextDouble();
                    conta.depositar(deposito);
                    break;
                case 2:
                    System.out.print("Digite o valor para sacar: ");
                    double saque = scanner.nextDouble();
                    conta.sacar(saque);
                    break;
                case 3:
                    if (conta instanceof ContaCorrente) {
                        System.out.print("Digite o valor para usar do cheque especial: ");
                        double valorChequeEspecial = scanner.nextDouble();
                        conta.sacar(valorChequeEspecial);
                    } else if (conta instanceof ContaPoupanca) {
                        ((ContaPoupanca) conta).calcularRendimento();
                    }
                    break;
                case 4:
                    conta.exibirDados();
                    break;
                case 5:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }

        scanner.close();
        System.out.println("Obrigado por usar o Sistema Bancário!");
    }
}

