package barbeariaCorteNinja;

import java.util.Scanner;

public class Vender {
    private static final double DESCONTO = 0.10; // Constante privada para o desconto

    // Método privado para calcular o preço com desconto, se aplicável
    private static double calcularPreco(double preco, boolean desconto) {
        if (desconto) {
            return preco * (1 - DESCONTO);  // Aplica 10% de desconto
        }
        return preco;
    }

    // Método protegido para verificar se o cliente está cadastrado
    protected static boolean isClienteCadastrado(String nome) {
        return LerArquivo.isNomeCadastrado(nome);
    }

    // Método protegido para realizar a venda
    protected static void realizarVenda(String nomeCliente, String opcaoServico) {
        double precoServico = 0.0;

        switch (opcaoServico.toLowerCase()) {
            case "corte":
                precoServico = 50.0;
                break;
            case "barba":
                precoServico = 30.0;
                break;
            case "combo":
                precoServico = 70.0;
                break;
            default:
                System.out.println("Opção de serviço inválida.");
                return;
        }

        boolean clienteCadastrado = isClienteCadastrado(nomeCliente);
        double precoFinal = calcularPreco(precoServico, clienteCadastrado);

        System.out.println("Cliente: " + nomeCliente);
        System.out.println("Serviço: " + opcaoServico);
        System.out.println("Preço: R$ " + precoFinal);
        if (clienteCadastrado) {
            System.out.println("Desconto de 10% aplicado.");
        }
    }

    // Método main para interação com o usuário
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do cliente:");
        String nomeCliente = scanner.nextLine();

        System.out.println("Escolha o serviço (corte/barba/combo):");
        String opcaoServico = scanner.nextLine();

        realizarVenda(nomeCliente, opcaoServico);

        scanner.close();
    }
}
