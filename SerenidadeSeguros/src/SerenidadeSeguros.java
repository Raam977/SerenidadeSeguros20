import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

public class SerenidadeSeguros {


    private static Scanner scanner = new Scanner(System.in);

    protected static ArrayList<Cliente> clientes = new ArrayList<>();
    protected static ArrayList<Veiculo> veiculos = new ArrayList<>();

    protected static ArrayList<Veiculo> veiculosPrincipal = new ArrayList<>();
    protected static ArrayList<Campanha> campanhas = new ArrayList<>();

    protected static ArrayList<Cliente> getClientes() {
        return clientes;
    }

    protected static   ArrayList<Veiculo> getVeiculos() {
        return veiculos;
    }
    protected static ArrayList<Veiculo> getVeiculosPrincipal() {
        return veiculosPrincipal;
    }
    protected static int getNumVeiculosPrincipal() {
        return veiculosPrincipal.size();
    }

    protected static void adicionarCliente() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insira o nome do cliente:");
        String nome = scanner.nextLine();
        int contato = getInputInt("Insira o contato do cliente:");
        scanner.nextLine(); // Limpar o buffer do scanner
        System.out.println("Insira o email do cliente:");
        String email = scanner.nextLine();
        System.out.println("Insira a morada do cliente:");
        String morada = scanner.nextLine();

        new Cliente(nome, contato, email, morada);

        System.out.println("Cliente adicionado com sucesso!");
    }



    protected static void excluirCliente() {
        System.out.println("Insira o ID do cliente que deseja excluir:");
        int id = scanner.nextInt();
        scanner.nextLine();

        excluirCliente(id);
    }

    protected static void excluirCliente(int id) {
        Cliente clienteParaExcluir = null;
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                clienteParaExcluir = cliente;
                break;
            }
        }

        if (clienteParaExcluir != null) {
            clientes.remove(clienteParaExcluir);
            System.out.println("Cliente excluído com sucesso.");
        } else {
            System.out.println("Erro: Cliente não encontrado");
        }
    }

    protected static void displayClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Ainda não existem clientes");
            return;
        }

        for (Cliente cliente : clientes) {
            System.out.println(cliente.toString());
            System.out.println("Veículos do Cliente:");
            displayVeiculos();
            System.out.println();
        }
    }

    // Métodos adicionais, como editarConta e excluirConta, permanecem inalterados...

    protected static void editarConta() {
        System.out.println("Insira o seu ID:");
        int id = lerInteiro();

        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getId() == id) {
                System.out.println("Insira o novo nome:");
                String nome = lerLinha();
                clientes.get(i).setNome(nome);
                System.out.println("Insira o novo contato:");
                int contato = lerInteiro();
                clientes.get(i).setContato(contato);
                System.out.println("Insira o novo email:");
                String email = lerLinha();
                clientes.get(i).setEmail(email);
                System.out.println("Insira a nova morada:");
                String morada = lerLinha();
                clientes.get(i).setMorada(morada);
                System.out.println("Concluido");
                return;
            }
        }

        System.out.println("Erro: Cliente não encontrado");
    }

    private static int lerInteiro() {
        while (!scanner.hasNextInt()) {
            System.out.println("Isso não é um número. Por favor, insira um número:");
            scanner.next();
        }
        int numero = scanner.nextInt();
        scanner.nextLine(); // descarta a quebra de linha
        return numero;
    }

    private static String lerLinha() {
        String linha = scanner.nextLine();
        return linha;
    }



    protected static void excluirConta() {
        System.out.println("Insira o seu ID:");
        int id = scanner.nextInt();
        scanner.nextLine();

        excluirCliente(id);
    }


    protected static void adicionarVeiculo(Veiculo veiculo) {
        if (veiculos.size() < 10) {
            veiculos.add(veiculo);
        } else {
            System.out.println("Erro: número máximo de veículos por cliente atingido");
        }
    }
    protected static void displayVeiculos() {
        if (veiculos.isEmpty()) {
            System.out.println("O cliente não possui veículos associados.");
            return;
        }

        for (Veiculo veiculo : veiculos) {
            System.out.println(veiculo.toString());
        }
    }
    private static int getInputInt(String prompt) {
        System.out.println(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Isso não é um número. Por favor, insira um número:");
            scanner.next();
        }
        return scanner.nextInt();
    }




    private static Cliente getClienteById(int idCliente) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == idCliente) {
                return cliente;
            }
        }
        return null;
    }




    //veiculos


    protected static void adicionarVeiculo() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insira o ID do cliente ao qual deseja adicionar um veículo:");
        int idCliente = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Insira o modelo do veículo:");
        String modelo = scanner.nextLine();
        System.out.println("Insira o ano do veículo:");
        int ano = scanner.nextInt();
        if(verificaAno(ano)){
            
      
        scanner.nextLine();
        System.out.println("Insira a marca do veículo:");
        String marca = scanner.nextLine();
        System.out.println("Insira o número do chassi do veículo:");
        String numeroChassis = scanner.nextLine();
        if(verificaChassi(numeroChassis)){
            System.out.println("Erro: Numero de chassi já existente");
        }
        else{
        System.out.println("Insira a origem do veículo (1. Importado / 2. Nacional):");
        int escolhaOrigem = scanner.nextInt();
        Origem origemVeiculo = (escolhaOrigem == 1) ? Origem.IMPORTADO : Origem.NACIONAL;
        int preco = getInputInt("Insira o preco do veículo:");
        System.out.println("Insira o tipo de veiculo");
        for (int i = 0; i < TipoVeiculo.values().length; i++) {
            System.out.println((i + 1) + ". " + TipoVeiculo.values()[i].getDescricao());
        }
        int escolhaTipo = scanner.nextInt();
        scanner.nextLine();
        TipoVeiculo tipoVeiculoEscolhido = TipoVeiculo.values()[escolhaTipo - 1];
        System.out.println("Insira a matricula do veículo:");

        String matricula = scanner.nextLine();

        if(verificaMatricula(matricula)){
            System.out.println("Erro: Matricula já existente");
        }
        else{
            for (Cliente cliente : SerenidadeSeguros.getClientes()) {
                if (cliente.getId() == idCliente) {
                    Veiculo veiculo = new Veiculo(idCliente, modelo, ano, marca, numeroChassis, origemVeiculo, preco, matricula);
                    veiculo.setTipo(tipoVeiculoEscolhido);
                    adicionarVeiculo(veiculo);
                    return;
                }
                
       
            }
            System.out.println("Erro: Cliente não encontrado");
        }

    }
}
    else{
        System.out.println("Erro: Ano inválido");
    }

    }

    public static boolean verificaMatricula(String matricula) {
        for (Veiculo veiculo : veiculosPrincipal) {
            if (veiculo.getMatricula().equals(matricula)) {
                return true;
            }
        }
        return false;
    }
    public static boolean verificaChassi(String numeroChassis) {
        for (Veiculo veiculo : veiculosPrincipal) {
            if (veiculo.getNumeroChassis().equals(numeroChassis)) {
                return true;
            }
        }
        return false;
    }
  

public static boolean verificaAno(int ano) {
    int anoAtual = LocalDate.now().getYear();
    if (ano <= anoAtual) {
        return true;
    } else {
        System.out.println("Erro: O ano do veículo não pode ser superior ao ano atual.");
        return false;
    }
}



    protected static void excluirVeiculo() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insira o ID do cliente do qual deseja excluir um veículo:");
        int idCliente = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Insira o ID do veículo que deseja excluir:");
        int idVeiculo = scanner.nextInt();
        scanner.nextLine();

        boolean clienteEncontrado = false;
        for (Cliente cliente : SerenidadeSeguros.getClientes()) {
            if (cliente.getId() == idCliente) {
                clienteEncontrado = true;
                break;
            }
        }

        if (clienteEncontrado) {
            boolean veiculoEncontrado = false;
            for (Veiculo veiculo : SerenidadeSeguros.getVeiculosPrincipal()) {
                if (veiculo.getIdCliente() == idCliente) {
                    System.out.println(veiculo.toString());
                    veiculoEncontrado = true;

                    for (int j = 0; j < veiculosPrincipal.size(); j++) {
                        if (veiculosPrincipal.get(j).getId() == idVeiculo) {
                            veiculosPrincipal.remove(j);
                            System.out.println("Veículo excluído com sucesso.");
                            return;
                        }
                    }
                    System.out.println("Erro: Veículo não encontrado");
                }
            }
            if (!veiculoEncontrado) {
                System.out.println("Este cliente não tem veículos associados");
            }
        } else {
            System.out.println("Erro: cliente não encontrado");
        }
    }

    protected static void displayVeiculosPrincipal() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insira o ID do cliente cujos veículos deseja visualizar:");
        while (!scanner.hasNextInt()) {
            System.out.println("Isso não é um número. Por favor, insira um número:");
            scanner.next(); // descarta a entrada incorreta
        }
        int idCliente = scanner.nextInt();
        scanner.nextLine();

        boolean clienteEncontrado = false;
        for (Cliente cliente : SerenidadeSeguros.getClientes()) {
            if (cliente.getId() == idCliente) {
                clienteEncontrado = true;
                break;
            }
        }

        if (clienteEncontrado) {
            boolean veiculoEncontrado = false;
            for (Veiculo veiculo : SerenidadeSeguros.getVeiculosPrincipal()) {
                if (veiculo.getIdCliente() == idCliente) {
                    System.out.println(veiculo.toString());
                    veiculoEncontrado = true;
                }
            }
            if (!veiculoEncontrado) {
                System.out.println("Este cliente não tem veículos associados");
            }
        } else {
            System.out.println("Erro: cliente não encontrado");
        }
    }



    protected static void adicionarHistoricoSinistros() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o ID do veículo: ");
        int idVeiculo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite o histórico de sinistros: ");
        String historicoSinistros = scanner.nextLine();

        System.out.println("Insira o seu ID de cliente:");
        int idCliente = scanner.nextInt();
        scanner.nextLine();

        boolean clienteEncontrado = false;
        for (Cliente cliente : SerenidadeSeguros.getClientes()) {
            if (cliente.getId() == idCliente) {
                clienteEncontrado = true;
                boolean veiculoEncontrado = false;
                for (Veiculo veiculo : SerenidadeSeguros.getVeiculosPrincipal()) {
                    if (veiculo.getIdCliente() == idCliente && veiculo.getId() == idVeiculo) {
                        veiculoEncontrado = true;
                        veiculo.historicoSinistros = historicoSinistros;
                        System.out.println(veiculo.toString());
                        break;
                    }
                }
                if (!veiculoEncontrado) {
                    System.out.println("Este cliente não tem veículos associados");
                }
                break;
            }
        }
        if (!clienteEncontrado) {
            System.out.println("Erro: cliente não encontrado");
        }
    }










    public static void executarFuncoesParaVeiculo() {
        Scanner scanner = new Scanner(System.in);

        // Solicitar o ID do cliente
        System.out.println("Digite o seu ID de cliente:");
        int idCliente = scanner.nextInt();
        scanner.nextLine();  // Limpar o buffer do teclado

        // Solicitar o ID do veículo
        System.out.println("Digite o ID do veículo:");
        int idVeiculo = scanner.nextInt();
        scanner.nextLine();  // Limpar o buffer do teclado

        // Executar os métodos para o veículo específico
        Cliente cliente = getClienteById(idCliente);
        if (cliente != null) {
            Veiculo veiculo = getVeiculoById(cliente, idVeiculo);
            if (veiculo != null) {
                System.out.println("Fator de Desvalorização: " );
                double depreciationFactor = veiculo.getDepreciationFactor();
                double currentValue = veiculo.getCurrentValue();



                System.out.println("Valor Atual: " + currentValue);
            } else {
                System.out.println("Veículo não encontrado para o cliente com ID " + idCliente);
            }
        } else {
            System.out.println("Cliente não encontrado com ID " + idCliente);
        }
    }



    private static Veiculo getVeiculoById(Cliente cliente, int idVeiculo) {
        for (Veiculo veiculo : SerenidadeSeguros.getVeiculos()) {
            if (veiculo.getId() == idVeiculo) {
                return veiculo;
            }
        }
        return null;
    }

    public static void agenteObterEstatisticasPorOrigem() {
        int nacionalCount = 0;
        int importadoCount = 0;

        for (Veiculo veiculo : veiculosPrincipal) {
            if (veiculo.getOrigem() == Origem.NACIONAL) {
                nacionalCount++;
            } else if (veiculo.getOrigem() == Origem.IMPORTADO) {
                importadoCount++;
            }
        }

        System.out.println("Estatísticas por Origem para Todos os Veículos:");
        System.out.println("Nacional: " + nacionalCount + " veículos");
        System.out.println("Importado: " + importadoCount + " veículos");
    }

    // Método para obter estatísticas por tipo para todos os veículos
    public static void agenteObterEstatisticasPorTipo() {
        int automovelCount = 0;
        int motocicloCount = 0;
        int pesadoCount = 0;

        for (Veiculo veiculo : veiculosPrincipal) {
            switch (veiculo.getTipo()) {
                case LIGEIRO_PASSAGEIROS:
                case LIGEIRO_MERCADORIAS:
                    automovelCount++;
                    break;
                case MOTOCICLO:
                    motocicloCount++;
                    break;
                case PESADO:
                    pesadoCount++;
                    break;
                default:
                    System.out.println("Tipo de veículo não reconhecido");
            }
        }

        System.out.println("\nEstatísticas por Tipo para Todos os Veículos:");
        System.out.println("Automóvel: " + automovelCount + " veículos");
        System.out.println("Motociclo: " + motocicloCount + " veículos");
        System.out.println("Pesado: " + pesadoCount + " veículos");
    }

    // Método para obter estatísticas de valor atual para todos os veículos
    public static void agenteObterEstatisticasValorAtual() {
        int totalValorAtual = 0;

        for (Veiculo veiculo : veiculosPrincipal) {
            totalValorAtual += (int) veiculo.getCurrentValue();
        }

        double valorMedio = (veiculosPrincipal.size() > 0) ? (double) totalValorAtual / veiculosPrincipal.size() : 0;

        System.out.println("\nEstatísticas de Valor Atual para Todos os Veículos:");
        System.out.println("Total do Valor Atual: " + totalValorAtual);
        System.out.println("Valor Médio: " + valorMedio);
    }


    protected static void displayEstatisticas() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insira o ID do cliente cujos veículos deseja visualizar:");
        while (!scanner.hasNextInt()) {
            System.out.println("Isso não é um número. Por favor, insira um número:");
            scanner.next(); // descarta a entrada incorreta
        }
        int idCliente = scanner.nextInt();
        scanner.nextLine();

        boolean clienteEncontrado = false;
        for (Cliente cliente : SerenidadeSeguros.getClientes()) {
            if (cliente.getId() == idCliente) {
                clienteEncontrado = true;
                break;
            }
        }

        // Variáveis fora do loop para manter o estado
        int automovelCount = 0;
        int motocicloCount = 0;
        int pesadoCount = 0;
        int nacionalCount = 0;
        int importadoCount = 0;
        int totalValorAtual = 0;

        if (clienteEncontrado) {
            boolean veiculoEncontrado = false;
            for (Veiculo veiculo : SerenidadeSeguros.getVeiculosPrincipal()) {
                if (veiculo.getIdCliente() == idCliente) {
                    switch (veiculo.getTipo()) {
                        case LIGEIRO_PASSAGEIROS:
                            automovelCount++;
                            break;
                        case LIGEIRO_MERCADORIAS:
                            automovelCount++;
                            break;
                        case MOTOCICLO:
                            motocicloCount++;
                            break;
                        case PESADO:
                            pesadoCount++;
                            break;
                        default:
                            System.out.println("Tipo de veículo não reconhecido");
                    }

                    if (veiculo.getOrigem() == Origem.NACIONAL) {
                        nacionalCount++;
                    } else if (veiculo.getOrigem() == Origem.IMPORTADO) {
                        importadoCount++;
                    }

                    // Atualizar o total do valor atual
                    totalValorAtual += (int) veiculo.getCurrentValue();

                    veiculoEncontrado = true;
                }
            }
            if (!veiculoEncontrado) {
                System.out.println("Este cliente não tem veículos associados");
            } else {
                // Imprimir estatísticas fora do loop
                System.out.println("\nEstatísticas por Tipo para o Cliente " + idCliente + ":");
                System.out.println("Automóvel: " + automovelCount + " veículos");
                System.out.println("Motociclo: " + motocicloCount + " veículos");
                System.out.println("Pesado: " + pesadoCount + " veículos");

                System.out.println("Estatísticas por Origem para o Cliente " + idCliente + ":");
                System.out.println("Nacional: " + nacionalCount + " veículos");
                System.out.println("Importado: " + importadoCount + " veículos");

                System.out.println("Estatísticas de Valor Atual para o Cliente " + idCliente + ":");
                System.out.println("Total do Valor Atual: " + totalValorAtual);
            }
        } else {
            System.out.println("Erro: cliente não encontrado");
        }
    }
    // campanhas

    protected static void criarCampanha() {
        String nome = getInputString("Insira o nome da campanha:");
        scanner.nextLine();
        scanner.nextLine();
        String descricao = getInputString("Insira a descrição da campanha:");
        scanner.nextLine();
        int desconto = getInputInt("Insira o desconto:");
        boolean sinistros = getInputBoolean("A campanha aceita carros com sinistros? (true/false):");

        campanhas.add(new Campanha(nome, descricao, desconto, sinistros));
        System.out.println("Campanha adicionada com sucesso.");
    }
    private static String getInputString(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }


    private static boolean getInputBoolean(String prompt) {
        System.out.println(prompt);
        while (!scanner.hasNextBoolean()) {
            System.out.println(". Por favor, insira True/false:");
            scanner.next();
        }
        return scanner.nextBoolean();
    }

    protected static void associarVeiculoCampanha() {
        System.out.print("Digite o ID do veículo: ");
        int idVeiculo = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Insira o seu ID de cliente:");
        int idCliente = scanner.nextInt();

        boolean clienteEncontrado = false;
        for (Cliente cliente : getClientes()) {
            if (cliente.getId() == idCliente) {
                clienteEncontrado = true;
                boolean veiculoEncontrado = false;

                for (Veiculo veiculo : getVeiculosPrincipal()) {
                    if (veiculo.getId() == idVeiculo && veiculo.getIdCliente() == idCliente) {
                        veiculoEncontrado = true;

                        System.out.print("Digite o ID da campanha: ");
                        int idCampanha = scanner.nextInt();

                        boolean campanhaEncontrada = existeCampanha(idCampanha);

                        if (campanhaEncontrada) {
                            Campanha campanha = campanhas.get(idCampanha);

                            if (campanha.isSinistros() && veiculo.getHistoricoSinistros().equals("")) {
                                veiculo.setCampanha(campanha.getNome());
                                System.out.println(veiculo.toString());
                            } else if (!campanha.isSinistros() && veiculo.getHistoricoSinistros().equals("")) {
                                veiculo.setCampanha(campanha.getNome());
                                System.out.println(veiculo.toString());
                            } else {
                                System.out.println("Este veículo tem histórico de sinistros associado");
                            }
                        } else {
                            System.out.println("Erro: campanha não encontrada");
                        }

                        break;
                    }
                }

                if (!veiculoEncontrado) {
                    System.out.println("Erro: veículo não encontrado");
                }

                break; // Adicionado para encerrar o loop após encontrar o cliente
            }
        }

        if (!clienteEncontrado) {
            System.out.println("Erro: cliente não encontrado");
        }
    }
    protected static void excluirCampanha() {
        System.out.println("Insira o ID da campanha que deseja excluir:");
        while (!scanner.hasNextInt()) {
            System.out.println("Isso não é um número. Por favor, insira um número:");
            scanner.next();
        }
        int idCampanha = scanner.nextInt();
        scanner.nextLine();

        int index = -1;
        for (int i = 0; i < campanhas.size(); i++) {
            if (campanhas.get(i).getId() == idCampanha) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            campanhas.remove(index);
            System.out.println("Campanha excluída com sucesso.");
        } else {
            System.out.println("Erro: campanha não encontrada");
        }
    }

    private static boolean existeCampanha(int idCampanha) {
        for (Campanha campanha : campanhas) {
            if (campanha.getId() == idCampanha) {
                return true;
            }
        }
        return false;
    }
}
