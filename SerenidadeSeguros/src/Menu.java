import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);


    public void exibirMenu() {
        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Agente");
            System.out.println("2. Cliente");
            System.out.println("3. Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                exibirMenuAgente();
            } else if (opcao == 2) {
                exibirMenuCliente();
            } else if (opcao == 3) {
                break;
            } else {
                System.out.println("Opção inválida");
            }
        }
    }

    private void exibirMenuAgente() {
        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Adicionar cliente");
            System.out.println("2. Visualizar clientes");
            System.out.println("3. Editar cliente");
            System.out.println("4. Excluir cliente");
            System.out.println("5. Adicionar Campanha");
            System.out.println("6. Visualizar Campanhas");
            System.out.println("7. Excluir Campanha");
            System.out.println("8. Voltar");
            System.out.println("9. Ver estatisticas por origem");
            System.out.println("10. Ver estatísticas por tipo");
            System.out.println("11. Ver estatatisticas de valor atual");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                SerenidadeSeguros.adicionarCliente();
            } else if (opcao == 2) {
                SerenidadeSeguros.displayClientes();
            } else if (opcao == 3) {
                SerenidadeSeguros.editarConta();
            } else if (opcao == 4) {
                SerenidadeSeguros.excluirCliente();
            } else if (opcao == 5) {
                SerenidadeSeguros.criarCampanha();
            } else if (opcao == 6) {
                Campanha.getCampanhas();
            } else if (opcao == 7) {
                SerenidadeSeguros.excluirCampanha();
            } else if (opcao == 8) {
                break;
            } else if (opcao == 9) {
                SerenidadeSeguros.agenteObterEstatisticasPorOrigem();
            } else if (opcao == 10) {
                SerenidadeSeguros.agenteObterEstatisticasPorTipo();
            } else if (opcao == 11) {
                SerenidadeSeguros.agenteObterEstatisticasValorAtual();
            } else {
                System.out.println("Opção inválida");
            }
        }
    }

    private void exibirMenuCliente() {
        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Editar conta");
            System.out.println("2. Adicionar veículo");
            System.out.println("3. Excluir veículo");
            System.out.println("4. Visualizar veículos");
            System.out.println("5. Excluir conta");
            System.out.println("6. Adicionar/Alterar histórico de sinistros a um veículo");
            System.out.println("7. Ver campanhas");
            System.out.println("8. Adicionar/Alterar campanhha a um veículo");
            System.out.println("9. Voltar");
            System.out.println("10. Ver Desvalorização de um veiculo");
            System.out.println("11. Ver estatisticas");
            ;

            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                SerenidadeSeguros.editarConta();
            } else if (opcao == 2) {
                SerenidadeSeguros.adicionarVeiculo();
            } else if (opcao == 3) {
                SerenidadeSeguros.excluirVeiculo();
            } else if (opcao == 4) {
                SerenidadeSeguros.displayVeiculosPrincipal();
            } else if (opcao == 5) {
                SerenidadeSeguros.excluirConta();
            } else if (opcao == 6) {
                SerenidadeSeguros.adicionarHistoricoSinistros();
            } else if (opcao == 7) {
                Campanha.getCampanhas();
            } else if (opcao == 8) {
                SerenidadeSeguros.associarVeiculoCampanha();
            } else if (opcao == 9) {
                break;
            } else if (opcao == 10) {
                SerenidadeSeguros.executarFuncoesParaVeiculo();
            } else if (opcao == 11) {
                SerenidadeSeguros.displayEstatisticas();

            } else {
                System.out.println("Opção inválida");
            }
        }
    }
}












