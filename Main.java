import Classes.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);
        ArrayList<Espetaculo> espetaculos = new ArrayList<Espetaculo>();
        ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
        int opcao = 0;
        do {
            terminalMack();
            opcao = src.nextInt();
            src.nextLine();
            switch (opcao) {
                case 1:
                    System.out.print("Nome do Espetáculo: ");
                    String nomeEspc = src.nextLine();
                    System.out.print("\nData do Espetáculo: ");
                    String dataEspc = src.nextLine();
                    System.out.print("\nHora do Espetáculo: ");
                    String horaEspc = src.nextLine();
                    System.out.print("\nPreço da entrada do Espetáculo: ");
                    double valorEspc = src.nextDouble();
                    Espetaculo espetaculo = new Espetaculo(nomeEspc, dataEspc, horaEspc, valorEspc);
                    espetaculos.add(espetaculo);
                    break;
                case 2:
                    System.out.print("Insira seu nome: ");
                    String nomePess = src.nextLine();
                    System.out.print("\nInsira seu CPF: ");
                    String cpf = src.nextLine();
                    Pessoa pessoa = new Pessoa(nomePess, cpf);
                    pessoas.add(pessoa);
                    break;
                case 3:
                    if (espetaculos.size() == 0 || pessoas.size() == 0) {
                        System.out.println("É necessário pelo menos 1 espetáculo e cliente cadastrado no sistema.");
                        break;
                    }
                    mostrarPessoas(pessoas);
                    opcao = src.nextInt();
                    int opcaoCadeira = 0;
                    int assentoDesejado = 0;
                    if(opcao <= pessoas.size() && opcao >= 1) {
                        Pessoa p1 = retornarPessoa(opcao, pessoas);
                        mostrarEspetaculos(espetaculos);
                        opcao = src.nextInt();
                        if(opcao <= espetaculos.size() && opcao >= 1) {
                            Espetaculo e1 = retornarEspetaculo(opcao, espetaculos);
                            p1.criarPedio(e1.getNome());
                            do {
                                e1.mostrarCadeiras();
                                System.out.print("Informe o Assento Desejado: ");
                                assentoDesejado = src.nextInt();
                                boolean pode = e1.verificarCadeira(assentoDesejado);
                                if (pode != true) {
                                    while (pode == false) {
                                        System.out.print("Informe um assento válido: ");
                                        assentoDesejado = src.nextInt();
                                        pode = e1.verificarCadeira(assentoDesejado);
                                    }
                                }
                                terminalEntradas();
                                int tipoEntrada = src.nextInt();
                                terminalCadeiras();
                                opcaoCadeira = scanner.nextInt();
                                if (opcaoCadeira != 1 && opcaoCadeira != 0){
                                    while(opcaoCadeira != 1 || opcaoCadeira != 0) {
                                        System.out.print("Opção Inválida! Informe um valor válido para prosseguir: ");
                                        opcaoCadeira = scanner.nextInt();
                                    }}
                                } while(opcaoCadeira != 0);
                                src.nextLine();
                                System.out.print("Para prosseguir com a compra, informe corretamente seu CPF: ");
                                String cpfInformado = src.nextLine();
                                if(cpfInformado.equals(p1.getCpf())) {
                                    p1.getPedido.addEntrada(assentoDesejado, e1.getValor, tipoEntrada);
                                    p1.finalizarPedido(p1.getPedido);
                                    e1.atualizarCadeiras(p1.getAssentos());
                                    System.out.println("Pedido Finalizado!");
                                } else {
                                    p1.clearPedido();
                                    System.out.println("CPF Informado incorreto! Transação negada.");
                                }
                        } else {
                            System.out.println("Valor de opção inválido");
                            break;
                        }
                    } else {
                        System.out.println("Valor opção inválido!");
                        break;
                    }
                    break;
                case 4:
                    System.out.println("Saindo do Sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while(opcao != 4);
        src.close();
        scanner.close();
    }
    public static void terminalCadeiras() {
        System.out.println("0. Seguir próxima fase");
        System.out.println("1. Selecionar Cadeira");
        System.out.print("Selecione uma opção acima: ");
    }

    public static void terminalEntradas() {
        System.out.println("1. Inteira");
        System.out.println("2. Meia");
        System.out.println("3. Professor");
        System.out.print("Informe o tipo de entrada para o seu assento: ");
    }

    public static void terminalMack() {
        System.out.println("1. Cadastrar Espetáculo");
        System.out.println("2. Cadastrar Cliente");
        System.out.println("3. Compra de Entradas");
        System.out.println("4. Sair");
        System.out.println("Selecione uma opção:");
    }

    public static void mostrarEspetaculos(ArrayList<Espetaculo> especs) {
        System.out.println("Informe o espetáculo que deseja comprar entradas:");
        for(int i = 0; i < especs.size(); i++) {
            System.out.println((i + 1) + ". " + especs.get(i));
        }
    }

    public static Espetaculo retornarEspetaculo(int i, ArrayList<Espetaculo> espec) {
        i--;
        return espec.get(i);
    }

    public static void mostrarPessoas(ArrayList<Pessoa> pessoas) {
        System.out.println("Informe a Pessoa que realizará a compra:");
        for(int i = 0; i < pessoas.size(); i++) {
            System.out.println((i + 1) + ". " + pessoas.get(i));
        }
    }

    public static Pessoa retornarPessoa(int i, ArrayList<Pessoa> pessoas) {
        i--;
        return pessoas.get(i);
    }
}
