import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Conta[] contas = new Conta[100];

        int opcao;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Criar nova Conta");
            System.out.println("2. Selecionar conta");
            System.out.println("9. Sair");
            System.out.print("\nEscolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    criarConta(contas);
                    break;
                case 2:
                    selecionarConta(contas);
                    break;
                case 9:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Escolha novamente.");
            }
        } while (opcao != 9);
    }

    private static void criarConta(Conta[] contas) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nTipos de Conta:");
        System.out.println("1. Conta");
        System.out.println("2. Conta PJ");
        System.out.println("3. Conta Poupança");
        System.out.print("\nEscolha o tipo de conta a ser criada: ");
        int tipoConta = scanner.nextInt();

        switch (tipoConta) {
            case 1:
                criarContaRegular(contas);
                break;
            case 2:
                criarContaPJ(contas);
                break;
            case 3:
                criarContaPoupanca(contas);
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    private static void criarContaRegular(Conta[] contas) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Número da conta: ");
        int numero = scanner.nextInt();
        System.out.print("Nome do titular: ");
        String nome = scanner.next();
        System.out.print("Saldo inicial: ");
        double saldo = scanner.nextDouble();

        for (int i = 0; i < contas.length; i++) {
            if (contas[i] == null) {
                contas[i] = new Conta(numero, nome, saldo);
                break;
            }
        }

        System.out.println("Conta criada com sucesso.");
    }

    private static void criarContaPJ(Conta[] contas) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Número da conta: ");
        int numero = scanner.nextInt();
        System.out.print("Nome da empresa: ");
        String nome = scanner.next();
        System.out.print("Saldo inicial: ");
        double saldo = scanner.nextDouble();
        System.out.print("Limite de empréstimo: ");
        double limiteEmprestimo = scanner.nextDouble();

        for (int i = 0; i < contas.length; i++) {
            if (contas[i] == null) {
                contas[i] = new ContaPJ(numero, nome, saldo, limiteEmprestimo);
                break;
            }
        }

        System.out.println("Conta PJ criada com sucesso.");
    }

    private static void criarContaPoupanca(Conta[] contas) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Número da conta: ");
        int numero = scanner.nextInt();
        System.out.print("Nome do titular: ");
        String nome = scanner.next();
        System.out.print("Saldo inicial: ");
        double saldo = scanner.nextDouble();
        System.out.print("Taxa de juros: ");
        double taxaJuro = scanner.nextDouble();

        for (int i = 0; i < contas.length; i++) {
            if (contas[i] == null) {
                contas[i] = new ContaPoupanca(numero, nome, saldo, taxaJuro);
                break;
            }
        }

        System.out.println("Conta Poupança criada com sucesso.");
    }

    private static void selecionarConta(Conta[] contas) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nSelecione a Conta:");

        for (int i = 0; i < contas.length; i++) {
            if (contas[i] != null) {
                System.out.println((i + 1) + ". " + contas[i].getTitular());
            }
        }

        System.out.print("\nEscolha o número da conta: ");
        int escolha = scanner.nextInt();

        Conta contaSelecionada = contas[escolha - 1];

        if (contaSelecionada != null) {
            System.out.println("\nOpções para " + contaSelecionada.getTitular() + ":");
            if (contaSelecionada instanceof ContaPJ) {
                System.out.println("1. Realizar depósito");
                System.out.println("2. Realizar saque");
                System.out.println("3. Realizar empréstimo");
                System.out.println("4. Mostrar informações da conta");
            } else if (contaSelecionada instanceof ContaPoupanca) {
                System.out.println("1. Realizar depósito");
                System.out.println("2. Realizar saque");
                System.out.println("3. Atualizar saldo (juros)");
                System.out.println("4. Mostrar informações da conta");
            } else {
                System.out.println("1. Realizar depósito");
                System.out.println("2. Realizar saque");
                System.out.println("4. Mostrar informações da conta");
            }

            System.out.print("\nEscolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor do depósito: ");
                    double deposito = scanner.nextDouble();
                    contaSelecionada.deposito(deposito);
                    System.out.println("Depósito realizado com sucesso.");
                    break;
                case 2:
                    System.out.print("Digite o valor do saque: ");
                    double saque = scanner.nextDouble();
                    contaSelecionada.saque(saque);
                    System.out.println("Saque realizado com sucesso.");
                    break;
                case 3:
                    if (contaSelecionada instanceof ContaPJ) {
                        ContaPJ contaPJ = (ContaPJ) contaSelecionada;
                        System.out.print("Digite o valor do empréstimo: ");
                        double emprestimo = scanner.nextDouble();
                        contaPJ.emprestimo(emprestimo);
                        System.out.println("Empréstimo realizado com sucesso.");
                    } else if (contaSelecionada instanceof ContaPoupanca) {
                        ContaPoupanca contaPoupanca = (ContaPoupanca) contaSelecionada;
                        contaPoupanca.atualizaSaldo();
                        System.out.println("Saldo atualizado com sucesso.");
                    }
                    break;
                case 4:
                    System.out.println(contaSelecionada.toString());
                    System.out.println("\nAperte enter para continuar...");
                    scanner.nextLine(); //consome enter
                    scanner.nextLine(); //faz o usuario pressionar alguma tecla
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } else {
            System.out.println("Conta não encontrada.");
        }
    }
}
