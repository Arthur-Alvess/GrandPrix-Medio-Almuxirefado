package almurifefado.grandprixmedioalmuxirefado.ConsoleApplication;

import almurifefado.grandprixmedioalmuxirefado.Models.*;
import almurifefado.grandprixmedioalmuxirefado.Storage.*;
import almurifefado.grandprixmedioalmuxirefado.Util.*;
import java.io.IOException;
import java.util.Scanner;


public class Main {
    private static UserContas userContas = new UserContas();
    private static ListaFuncionários listaFuncionarios = new ListaFuncionários();
    private static Estoque estoque = new Estoque();
    private static CarrinhoItens carrinhoItens = new CarrinhoItens();
    private static Historico historico = new Historico();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Cadastro");
            System.out.println("2. Login");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();
            limparConsole();

            switch (opcao) {
                case 1:
                    cadastrarUsuario(scanner);
                    break;
                case 2:
                    login(scanner);
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("\nOpção inválida.");
            }
        }
    }

    private static void cadastrarUsuario(Scanner scanner) {
        limparConsole();
        System.out.println("\nVocê está na area de cadastro\n");
        System.out.print("Nome completo: ");
        String nome = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Número de celular: ");
        String celular = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        User user = new User(nome, new EmailAddress(email), new CPF(cpf), new CellphoneNumber(celular), senha);
        userContas.adicionarUsuario(user);
        System.out.println("\nUsuário cadastrado com sucesso!");

        System.out.println("Pressione Enter para continuar...");
        scanner.nextLine();
        limparConsole();
    }

    private static void login(Scanner scanner) {
        limparConsole();
        System.out.println("\nVocê está na area de login\n");
        System.out.print("Email ou CPF: ");
        String emailCpf = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        User user = userContas.autenticar(emailCpf, senha);
        if (user != null) {
            System.out.println("\nLogin bem-sucedido!");

            System.out.println("Pressione Enter para continuar...");
            scanner.nextLine();
            limparConsole();
            menuPrincipal(scanner, user);
        } else {
            System.out.println("\nCredenciais inválidas.");
            System.out.println("Pressione Enter para continuar...");
            scanner.nextLine();
            limparConsole();
        }
    }

    private static void menuPrincipal(Scanner scanner, User user) {
        while (true) {
            limparConsole();
            System.out.println("\nMenu principal");
            System.out.println("\n1. Gerenciar Funcionários");
            System.out.println("2. Gerenciar Estoque");
            System.out.println("3. Galeria de Itens");
            System.out.println("4. Histórico");
            System.out.println("5. Logout");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    gerenciarFuncionarios(scanner);
                    break;
                case 2:
                    gerenciarEstoque(scanner);
                    break;
                case 3:
                    galeriaDeItens(scanner);
                    break;
                case 4:
                    visualizarHistorico();
                    break;
                case 5:
                limparConsole();
                    return;
                default:
                    System.out.println("\nOpção inválida.");

                    System.out.println("Pressione Enter para continuar...");
                    scanner.nextLine();
                    limparConsole();
            }
        }
    }

    private static void gerenciarFuncionarios(Scanner scanner) {
        while (true) {
            limparConsole();
            System.out.println("\nVocê esta na area de gerenciar funcionários");
            System.out.println("\n1. Cadastrar Funcionário");
            System.out.println("2. Visualizar Funcionários");
            System.out.println("3. Desativar/Excluir Funcionário");
            System.out.println("4. Voltar");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarFuncionario(scanner);
                    break;
                case 2:
                    visualizarFuncionarios();
                    break;
                case 3:
                    desativarExcluirFuncionario(scanner);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("\nOpção inválida.");
                    System.out.println("Pressione Enter para continuar...");
                    scanner.nextLine();
                    limparConsole();
            }
        }
    }

    private static void cadastrarFuncionario(Scanner scanner) {
        limparConsole();
        System.out.println("\nVoce está cadastrando um funcionário\n");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Número de celular: ");
        String celular = scanner.nextLine();
        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();

        Funcionário funcionario = new Funcionário(nome, new EmailAddress(email), new CPF(cpf), new CellphoneNumber(celular), idade, descricao, StatusAtualFuncionario.ATIVO);
        listaFuncionarios.adicionarFuncionario(funcionario);
        System.out.println("\nFuncionário cadastrado com sucesso!");
        System.out.println("Pressione Enter para continuar...");
        scanner.nextLine();
        limparConsole();
    }

    private static void visualizarFuncionarios() {
        Scanner scanner = new Scanner(System.in);
        for (Funcionário funcionario : listaFuncionarios.getFuncionarios()) {
            System.out.println(funcionario);
        }
        System.out.println("Pressione Enter para continuar...");
        scanner.nextLine();
    }

    private static void desativarExcluirFuncionario(Scanner scanner) {
        System.out.print("CPF do funcionário: ");
        String cpf = scanner.nextLine();
        Funcionário funcionario = listaFuncionarios.buscarFuncionario(cpf);
        if (funcionario != null) {
            System.out.println("\n1. Desativar");
            System.out.println("2. Excluir");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    funcionario.setStatus(StatusAtualFuncionario.INATIVO);
                    System.out.println("\nFuncionário desativado.");

                    System.out.println("Pressione Enter para continuar...");
                    scanner.nextLine();
                    limparConsole();
                    break;
                case 2:
                    listaFuncionarios.removerFuncionario(funcionario);
                    System.out.println("\nFuncionário excluído.");

                    System.out.println("Pressione Enter para continuar...");
                    scanner.nextLine();
                    limparConsole();
                    break;
                default:
                    System.out.println("\nOpção inválida.");

                    System.out.println("Pressione Enter para continuar...");
                    scanner.nextLine();
                    limparConsole();
            }
        } else {
            System.out.println("\nFuncionário não encontrado.");

            System.out.println("Pressione Enter para continuar...");
            scanner.nextLine();
            limparConsole();
        }
    }

    private static void gerenciarEstoque(Scanner scanner) {
        while (true) {
            limparConsole();
            System.out.println("\nArea de gerenciar estoque");
            System.out.println("\n1. Adicionar Item");
            System.out.println("2. Editar Item");
            System.out.println("3. Remover Item");
            System.out.println("4. Visualizar Estoque");
            System.out.println("5. Voltar");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    adicionarItem(scanner);
                    break;
                case 2:
                    editarItem(scanner);
                    break;
                case 3:
                    removerItem(scanner);
                    break;
                case 4:
                    visualizarEstoque();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("\nOpção inválida.");

                    System.out.println("Pressione Enter para continuar...");
                    scanner.nextLine();
                    limparConsole();
            }
        }
    }

    private static void adicionarItem(Scanner scanner) {
        limparConsole();
        System.out.println("\nVoce está adicionando um item\n");
        System.out.print("Código: ");
        String codigo = scanner.nextLine();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        System.out.print("Quantidade: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();

        Item item = new Item(nome,descricao, quantidade, codigo);
        estoque.adicionarItem(item);
        System.out.println("\nItem adicionado com sucesso!");
        
        System.out.println("Pressione Enter para continuar...");
        scanner.nextLine();
        limparConsole();
    }

    private static void editarItem(Scanner scanner) {
        limparConsole();
        System.out.println("\nVoce está editando um item\n");
        System.out.print("Código do item: ");
        String codigo = scanner.nextLine();
        Item item = estoque.buscarItem(codigo);
        if (item != null) {
            System.out.print("Novo nome: ");
            String nome = scanner.nextLine();
            System.out.print("Nova descrição: ");
            String descricao = scanner.nextLine();
            System.out.print("Nova quantidade: ");
            int quantidade = scanner.nextInt();
            scanner.nextLine();

            item.setNome(nome);
            item.setDescricao(descricao);
            item.setQuantidade(quantidade);
            System.out.println("\nItem editado com sucesso!");

            System.out.println("Pressione Enter para continuar...");
            scanner.nextLine();
            limparConsole();
        } else {
            System.out.println("\nItem não encontrado.");

            System.out.println("Pressione Enter para continuar...");
            scanner.nextLine();
            limparConsole();
        }
    }

    private static void removerItem(Scanner scanner) {
        System.out.print("Código do item: ");
        String codigo = scanner.nextLine();
        Item item = estoque.buscarItem(codigo);
        if (item != null) {
            estoque.removerItem(item);
            System.out.println("\nItem removido com sucesso!");

            System.out.println("Pressione Enter para continuar...");
            scanner.nextLine();
            limparConsole();
        } else {
            System.out.println("\nItem não encontrado.");

            System.out.println("Pressione Enter para continuar...");
            scanner.nextLine();
            limparConsole();
        }
    }

    private static void visualizarEstoque() {
        Scanner scanner = new Scanner(System.in);
        for (Item item : estoque.getItens()) {
            System.out.println(item);
        }
        System.out.println("Pressione Enter para continuar...");
        scanner.nextLine();
    }

    private static void galeriaDeItens(Scanner scanner) {
        while (true) {
            limparConsole();
            System.out.println("\nArea de galeria de itens");
            System.out.println("\n1. Retirar Item");
            System.out.println("2. Cancelar Retirada");
            System.out.println("3. Devolver Item");
            System.out.println("4. Voltar");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    retirarItem(scanner);
                    break;
                case 2:
                    cancelarRetirada(scanner);
                    break;
                case 3:
                    devolverItem(scanner);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("\nOpção inválida.");

                    System.out.println("Pressione Enter para continuar...");
                    scanner.nextLine();
                    limparConsole();
            }
        }
    }

    private static void retirarItem(Scanner scanner) {
        limparConsole();
        System.out.println("\nRetirada de item\n");
        System.out.print("Código do item: ");
        String codigo = scanner.nextLine();
        Item item = estoque.buscarItem(codigo);
        if (item != null) {
            System.out.print("Quantidade: ");
            int quantidade = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Nome do funcionário: ");
            String nomeFuncionario = scanner.nextLine();

            if (item.getQuantidade() >= quantidade) {
                item.setQuantidade(item.getQuantidade() - quantidade);
                carrinhoItens.adicionarItem(item, quantidade, nomeFuncionario);
                historico.adicionarRegistro("Item retirado: " + item.getNome() + ", Quantidade: " + quantidade + ", Funcionário: " + nomeFuncionario);
                System.out.println("\nItem retirado com sucesso!");

                System.out.println("Pressione Enter para continuar...");
                scanner.nextLine();
                limparConsole();
            } else {
                System.out.println("\nQuantidade insuficiente em estoque.");

                System.out.println("Pressione Enter para continuar...");
                scanner.nextLine();
                limparConsole();
            }
        } else {
            System.out.println("\nItem não encontrado.");

            System.out.println("Pressione Enter para continuar...");
            scanner.nextLine();
            limparConsole();
        }
    }

    private static void cancelarRetirada(Scanner scanner) {
        System.out.print("Código do item: ");
        String codigo = scanner.nextLine();
        Item item = carrinhoItens.buscarItem(codigo);
        if (item != null) {
            System.out.print("Quantidade: ");
            int quantidade = scanner.nextInt();
            scanner.nextLine();

            carrinhoItens.removerItem(item, quantidade);
            item.setQuantidade(item.getQuantidade() + quantidade);
            historico.adicionarRegistro("Retirada cancelada: " + item.getNome() + ", Quantidade: " + quantidade);
            System.out.println("\nRetirada cancelada com sucesso!");

            System.out.println("Pressione Enter para continuar...");
            scanner.nextLine();
            limparConsole();
        } else {
            System.out.println("\nItem não encontrado no carrinho.");

            System.out.println("Pressione Enter para continuar...");
            scanner.nextLine();
            limparConsole();
        }
    }

    private static void devolverItem(Scanner scanner) {
        limparConsole();
        System.out.println("\n Devolver Item");
        System.out.print("Código do item: ");
        String codigo = scanner.nextLine();
        Item item = estoque.buscarItem(codigo);
        if (item != null) {
            System.out.print("Quantidade: ");
            int quantidade = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Nome do funcionário: ");
            String nomeFuncionario = scanner.nextLine();

            item.setQuantidade(item.getQuantidade() + quantidade);
            historico.adicionarRegistro("Item devolvido: " + item.getNome() + ", Quantidade: " + quantidade + ", Funcionário: " + nomeFuncionario);
            System.out.println("\nItem devolvido com sucesso!");

            System.out.println("Pressione Enter para continuar...");
            scanner.nextLine();
            limparConsole();
        } else {
            System.out.println("\nItem não encontrado.");

            System.out.println("Pressione Enter para continuar...");
            scanner.nextLine();
            limparConsole();
        }
    }

    private static void visualizarHistorico() {
        Scanner scanner = new Scanner(System.in);
        for (String registro : historico.getRegistros()) {
            System.out.println(registro);
        }
        System.out.println("Pressione Enter para continuar...");
        scanner.nextLine();
    }
    public static void limparConsole() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (IOException | InterruptedException ex) {
            System.out.println("Erro ao limpar o console.");
        }
    }
}