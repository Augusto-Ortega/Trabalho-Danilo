package barbeariaCorteNinja;

import java.util.Scanner;

class Cadastrar {
  public static void main(String[] args) {
    Scanner leitor = new Scanner(System.in);
    System.out.println("Entre com o nome e sobrenome do cliente:");
    String nomeUsu = leitor.nextLine();

    System.out.println("Entre com o Email do usuário:");
    String emailUsu = leitor.nextLine();
    
    System.out.println("Entre com o numero do usuario");
    String numUsu = leitor.nextLine();

    System.out.println("Deseja gravar os dados? (sim) ou (não)");
    String confirmaGrav = leitor.nextLine();

    if (confirmaGrav.equalsIgnoreCase("sim")) {
      // Verificar se o nome do cliente já está cadastrado usando LerArquivo
      if (LerArquivo.isNomeCadastrado(nomeUsu)) {
        System.out.println("falha na execução: Nome já cadastrado no sitema.");
      } else {
        Gravar.setTexto(nomeUsu);
        Gravar.main(null);

        Gravar.setTexto(emailUsu);
        Gravar.main(null);

        Gravar.setTexto(numUsu);
        Gravar.main(null);
      }
    }

    leitor.close();
  }
}
