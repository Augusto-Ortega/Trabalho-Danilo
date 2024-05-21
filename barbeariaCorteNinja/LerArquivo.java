package barbeariaCorteNinja;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LerArquivo {
  public static void main(String[] args) {
    String clienteProcurado = "Vitoria Moretto";  // Especifique o nome do cliente que você quer encontrar

    boolean clienteEncontrado = false;

    try {
      // Definindo o arquivo e o leitor do arquivo
      File meuArquivo = new File("dados.txt");
      Scanner meuLeitor = new Scanner(meuArquivo);

      // Loop While para rodar todas as linhas do arquivo
      while (meuLeitor.hasNextLine()) {
        String dados = meuLeitor.nextLine();
        // Separa a linha antes do "||" e pega somente a primeira parte
        String[] dadosCliente = dados.split("\\|\\|");

        // Verifica se a linha contém o nome do cliente procurado
        if (dadosCliente.length > 0 && dadosCliente[0].equals(clienteProcurado)) {
          // Se encontrado, imprime os dados do cliente
          System.out.println("Nome: " + dadosCliente[0]);
          System.out.println("Email: " + meuLeitor.nextLine().split("\\|\\|")[0]);
          System.out.println("Número: " + meuLeitor.nextLine().split("\\|\\|")[0]);
          clienteEncontrado = true;
          break;
        }
      }

      // Fechamento do leitor e tratamento de mensagem de erro
      meuLeitor.close();

      // Mensagem caso o cliente não seja encontrado
      if (!clienteEncontrado) {
        System.out.println("Cliente " + clienteProcurado + " não encontrado.");
      }
    } catch (FileNotFoundException e) {
      System.out.println("Algum erro ocorreu.");
      e.printStackTrace();
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
    } catch (FileNotFoundException e) {
      System.out.println("Arquivo não encontrado.");
      e.printStackTrace();
    }

    return false;
  }
}
