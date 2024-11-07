// Arquivo: Main.java
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Funcionario> funcionarios = new ArrayList<>();
    private static List<Cliente> clientes = new ArrayList<>();
    private static List<Joia> joias = new ArrayList<>();
    private static List<Pedido> pedidos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Sistema de Joalheria ---");
            System.out.println("1. Gerenciar Funcionários");
            System.out.println("2. Gerenciar Clientes");
            System.out.println("3. Gerenciar Joias");
            System.out.println("4. Gerenciar Pedidos");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Limpar o buffer

            switch (choice) {
                case 1 -> gerenciarFuncionarios(scanner);
                case 2 -> gerenciarClientes(scanner);
                case 3 -> gerenciarJoias(scanner);
                case 4 -> gerenciarPedidos(scanner);
                case 5 -> running = false;
                default -> System.out.println("Opção inválida.");
            }
        }
        scanner.close();
    }
    private static void gerenciarPedidos(Scanner scanner) {
        System.out.println("\n--- Gerenciar Pedidos ---");
        System.out.println("1. Criar Pedido");
        System.out.println("2. Listar Pedidos");
        System.out.println("3. Atualizar Status do Pedido");
        System.out.print("Escolha uma opção: ");

        int choice = scanner.nextInt();
        scanner.nextLine();  // Limpar o buffer
    }

    private static void gerenciarJoias(Scanner scanner) {
        System.out.println("\n--- Gerenciar Joias ---");
        System.out.println("1. Adicionar Joia");
        System.out.println("2. Listar Joias");
        System.out.println("3. Remover Joia");
        System.out.print("Escolha uma opção: ");

        int choice = scanner.nextInt();
        scanner.nextLine();  // Limpar o buffer

        switch (choice) {
            case 1 -> adicionarJoia(scanner);
            case 2 -> listarJoias();
            case 3 -> removerJoia(scanner);
            default -> System.out.println("Opção inválida.");
        }
    }

    private static void adicionarJoia(Scanner scanner) {
        System.out.print("ID: ");
        String id = scanner.nextLine();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Material: ");
        String material = scanner.nextLine();
        System.out.print("Peso: ");
        double peso = scanner.nextDouble();
        System.out.print("Preço: ");
        double preco = scanner.nextDouble();
        System.out.print("Quantidade em Estoque: ");
        int quantidadeEstoque = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Classificação (casual ou luxo): ");
        String classificacao = scanner.nextLine();
        System.out.print("Tipo de Joia (1. Colar, 2. Brinco, 3. Anel): ");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        Joia joia = null;
        switch (tipo) {
            case 1 -> {
                System.out.print("Comprimento do Colar: ");
                double comprimento = scanner.nextDouble();
                scanner.nextLine();
                joia = new Colar(id, nome, material, peso, preco, quantidadeEstoque, classificacao, comprimento);
            }
            case 2 -> {
                System.out.print("Tipo de Fecho do Brinco: ");
                String tipoFecho = scanner.nextLine();
                joia = new Brinco(id, nome, material, peso, preco, quantidadeEstoque, classificacao, tipoFecho);
            }
            case 3 -> {
                System.out.print("Tamanho do Anel: ");
                int tamanho = scanner.nextInt();
                scanner.nextLine();
                joia = new Anel(id, nome, material, peso, preco, quantidadeEstoque, classificacao, tamanho);
            }
            default -> System.out.println("Tipo de Joia inválido.");
        }

        if (joia != null) {
            joias.add(joia);
            try {
                joia.salvar();
                System.out.println("Joia adicionada com sucesso.");
            } catch (IOException e) {
                System.out.println("Erro ao salvar a joia.");
            }
        }
    }
    private static void listarJoias() {
        System.out.println("\n--- Lista de Joias ---");
        for (Joia joia : joias) {
            System.out.println(joia);
        }
    }

    private static void removerJoia(Scanner scanner) {
        System.out.print("Digite o ID da joia a ser removida: ");
        String id = scanner.nextLine();

        joias.removeIf(j -> j.id.equals(id));
        System.out.println("Joia removida.");
    }
    private static void gerenciarFuncionarios(Scanner scanner) {
        System.out.println("\n--- Gerenciar Funcionários ---");
        System.out.println("1. Adicionar Funcionário");
        System.out.println("2. Listar Funcionários");
        System.out.println("3. Atualizar Funcionário");
        System.out.println("4. Remover Funcionário");
        System.out.print("Escolha uma opção: ");

        int choice = scanner.nextInt();
        scanner.nextLine();  // Limpar o buffer

        switch (choice) {
            case 1 -> adicionarFuncionario(scanner);
            case 2 -> listarFuncionarios();
            case 3 -> atualizarFuncionario(scanner);
            case 4 -> removerFuncionario(scanner);
            default -> System.out.println("Opção inválida.");
        }
    }


    private static void adicionarFuncionario(Scanner scanner) {
        System.out.print("ID: ");
        String id = scanner.nextLine();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("NIF: ");
        String nif = scanner.nextLine();
        System.out.print("Data de Contrato: ");
        String dataContrato = scanner.nextLine();
        System.out.print("Salário: ");
        double salario = scanner.nextDouble();
        System.out.print("Meta de Vendas: ");
        double metaVendas = scanner.nextDouble();
        scanner.nextLine();  // Limpar o buffer
        System.out.print("Tipo (1. Dono, 2. Gerente, 3. Vendedor): ");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        Funcionario funcionario = switch (tipo) {
            case 1 -> new Dono(id, nome, nif, dataContrato, salario, metaVendas);
            case 2 -> new Gerente(id, nome, nif, dataContrato, salario, metaVendas);
            case 3 -> new Vendedor(id, nome, nif, dataContrato, salario, metaVendas);
            default -> null;
        };

        if (funcionario != null) {
            funcionarios.add(funcionario);
            try {
                funcionario.salvar();
                System.out.println("Funcionário adicionado com sucesso.");
            } catch (IOException e) {
                System.out.println("Erro ao salvar o funcionário.");
            }
        } else {
            System.out.println("Tipo inválido.");
        }
    }

    private static void listarFuncionarios() {
        System.out.println("\n--- Lista de Funcionários ---");
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario);
        }
    }

    private static void atualizarFuncionario(Scanner scanner) {
        System.out.print("Digite o ID do funcionário a ser atualizado: ");
        String id = scanner.nextLine();

        Funcionario funcionario = funcionarios.stream()
                .filter(f -> f.id.equals(id))
                .findFirst()
                .orElse(null);

        if (funcionario != null) {
            System.out.print("Novo Salário: ");
            funcionario.salario = scanner.nextDouble();
            System.out.print("Nova Meta de Vendas: ");
            funcionario.metaVendas = scanner.nextDouble();
            scanner.nextLine();
            System.out.println("Funcionário atualizado.");
        } else {
            System.out.println("Funcionário não encontrado.");
        }
    }

    private static void removerFuncionario(Scanner scanner) {
        System.out.print("Digite o ID do funcionário a ser removido: ");
        String id = scanner.nextLine();

        if (funcionarios.removeIf(f -> f.id.equals(id))) {
            System.out.println("Funcionário removido.");
        } else {
            System.out.println("Funcionário não encontrado.");
        }
    }

    private static void gerenciarClientes(Scanner scanner) {
        System.out.println("\n--- Gerenciar Clientes ---");
        System.out.println("1. Adicionar Cliente");
        System.out.println("2. Listar Clientes");
        System.out.println("3. Remover Cliente");
        System.out.print("Escolha uma opção: ");

        int choice = scanner.nextInt();
        scanner.nextLine();  // Limpar o buffer

        switch (choice) {
            case 1 -> adicionarCliente(scanner);
            case 2 -> listarClientes();
            case 3 -> removerCliente(scanner);
            default -> System.out.println("Opção inválida.");
        }
    }

    private static void adicionarCliente(Scanner scanner) {
        System.out.print("ID: ");
        String id = scanner.nextLine();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("NIF: ");
        String nif = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();

        Cliente cliente = new Cliente(id, nome, nif, email, telefone, endereco);
        clientes.add(cliente);
        try {
            cliente.salvar();
            System.out.println("Cliente adicionado com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar o cliente.");
        }
    }

    private static void listarClientes() {
        System.out.println("\n--- Lista de Clientes ---");
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }

    private static void removerCliente(Scanner scanner) {
        System.out.print("Digite o ID do cliente a ser removido: ");
        String id = scanner.nextLine();

        if (clientes.removeIf(c -> c.equals(id))) {
            System.out.println("Cliente removido.");
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    // Os métodos gerenciarJoias, gerenciarPedidos e demais métodos CRUD já implementados seguem aqui...
}
