package barbeariaCorteNinja;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LerArquivo {
    private static String clienteProcurado;

    public static void setClienteProcurado(String nome) {
        clienteProcurado = nome;
    }

    public static void verCadastroCliente(String nomeCliente) {
        setClienteProcurado(nomeCliente);
        boolean clienteEncontrado = false;

        try {
            File meuArquivo = new File("dados.txt");
            Scanner meuLeitor = new Scanner(meuArquivo);

            while (meuLeitor.hasNextLine()) {
                String dados = meuLeitor.nextLine();
                String[] dadosCliente = dados.split("\\|\\|");

                if (dadosCliente.length > 0 && dadosCliente[0].equals(clienteProcurado)) {
                    System.out.println("Nome: " + dadosCliente[0]);
                    System.out.println("Email: " + meuLeitor.nextLine().split("\\|\\|")[0]);
                    System.out.println("Número: " + meuLeitor.nextLine().split("\\|\\|")[0]);
                    clienteEncontrado = true;
                    break;
                }
            }

            meuLeitor.close();

            if (!clienteEncontrado) {
                System.out.println("Cliente " + clienteProcurado + " não encontrado.");
            }
        } catch (FileNotFoundException erro) {
            System.out.println("Algum erro ocorreu.");
            erro.printStackTrace();
        }
    }

    public static boolean isNomeCadastrado(String nome) {
        try {
            File meuArquivo = new File("dados.txt");
            Scanner meuLeitor = new Scanner(meuArquivo);

            while (meuLeitor.hasNextLine()) {
                String dados = meuLeitor.nextLine();
                String[] dadosCliente = dados.split("\\|\\|");

                if (dadosCliente.length > 0 && dadosCliente[0].equals(nome)) {
                    meuLeitor.close();
                    return true;
                }
            }

            meuLeitor.close();
        } catch (FileNotFoundException erro) {
            System.out.println("Arquivo não encontrado.");
            erro.printStackTrace();
        }

        return false;
    }
}
