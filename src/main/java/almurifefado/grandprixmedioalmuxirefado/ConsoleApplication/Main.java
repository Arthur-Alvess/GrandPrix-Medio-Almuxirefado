package almurifefado.grandprixmedioalmuxirefado.ConsoleApplication;

import almurifefado.grandprixmedioalmuxirefado.Models.*;
import almurifefado.grandprixmedioalmuxirefado.Storage.*;
import almurifefado.grandprixmedioalmuxirefado.Util.*;

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
            System.out.println("1. Cadastro");
            System.out.println("2. Login");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

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
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void cadastrarUsuario(Scanner scanner) {
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
        System.out.println("Usuário cadastrado com sucesso!");
    }

    private static void login(Scanner scanner) {
        System.out.print("Email ou CPF: ");
        String emailCpf = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        User user = userContas.autenticar(emailCpf, senha);
        if (user != null) {
            System.out.println("Login bem-sucedido!");
            menuPrincipal(scanner, user);
        } else {
            System.out.println("Credenciais inválidas.");
        }
    }

    private static void menuPrincipal(Scanner scanner, User user) {
        while (true) {
            System.out.println("1. Gerenciar Funcionários");
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
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void gerenciarFuncionarios(Scanner scanner) {
        while (true) {
            System.out.println("1. Cadastrar Funcionário");
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
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void cadastrarFuncionario(Scanner scanner) {
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
        System.out.println("Funcionário cadastrado com sucesso!");
    }

    private static void visualizarFuncionarios() {
        for (Funcionário funcionario : listaFuncionarios.getFuncionarios()) {
            System.out.println(funcionario);
        }
    }

    private static void desativarExcluirFuncionario(Scanner scanner) {
        System.out.print("CPF do funcionário: ");
        String cpf = scanner.nextLine();
        Funcionário funcionario = listaFuncionarios.buscarFuncionario(cpf);
        if (funcionario != null) {
            System.out.println("1. Desativar");
            System.out.println("2. Excluir");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    funcionario.setStatus(StatusAtualFuncionario.INATIVO);
                    System.out.println("Funcionário desativado.");
                    break;
                case 2:
                    listaFuncionarios.removerFuncionario(funcionario);
                    System.out.println("Funcionário excluído.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } else {
            System.out.println("Funcionário não encontrado.");
        }
    }

    private static void gerenciarEstoque(Scanner scanner) {
        while (true) {
            System.out.println("1. Adicionar Item");
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
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void adicionarItem(Scanner scanner) {
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
        System.out.println("Item adicionado com sucesso!");
    }

    private static void editarItem(Scanner scanner) {
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
            System.out.println("Item editado com sucesso!");
        } else {
            System.out.println("Item não encontrado.");
        }
    }

    private static void removerItem(Scanner scanner) {
        System.out.print("Código do item: ");
        String codigo = scanner.nextLine();
        Item item = estoque.buscarItem(codigo);
        if (item != null) {
            estoque.removerItem(item);
            System.out.println("Item removido com sucesso!");
        } else {
            System.out.println("Item não encontrado.");
        }
    }

    private static void visualizarEstoque() {
        for (Item item : estoque.getItens()) {
            System.out.println(item);
        }
    }

    private static void galeriaDeItens(Scanner scanner) {
        while (true) {
            System.out.println("1. Retirar Item");
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
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void retirarItem(Scanner scanner) {
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
                System.out.println("Item retirado com sucesso!");
            } else {
                System.out.println("Quantidade insuficiente em estoque.");
            }
        } else {
            System.out.println("Item não encontrado.");
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
            System.out.println("Retirada cancelada com sucesso!");
        } else {
            System.out.println("Item não encontrado no carrinho.");
        }
    }

    private static void devolverItem(Scanner scanner) {
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
            System.out.println("Item devolvido com sucesso!");
        } else {
            System.out.println("Item não encontrado.");
        }
    }

    private static void visualizarHistorico() {
        for (String registro : historico.getRegistros()) {
            System.out.println(registro);
        }
    }
}