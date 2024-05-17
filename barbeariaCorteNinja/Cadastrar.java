package barbeariaCorteNinja;


import java.util.Scanner;  // Import the Scanner class

class Cadastrar {
  public static void main(String[] args) {
    Scanner leitor = new Scanner(System.in); 
    System.out.println("Entre com o nome de Usuário:");
    String nomeUsu = leitor.nextLine();  

    System.out.println("Entre com o Email do usuário:");
    String emailUsu = leitor.nextLine();
    
    System.out.println("Entre com o numero do usuario");
    String numUsu = leitor.nextLine();

    System.out.println("Deseja gravar os dados? (sim) ou (não)");
    String confirmaGrav = leitor.nextLine();

    leitor.close();

    if (confirmaGrav.equals("sim")){
        Gravar.setTexto(nomeUsu);
        Gravar.main(null);

        Gravar.setTexto(emailUsu);
        Gravar.main(null);

        Gravar.setTexto(numUsu);
        Gravar.main(null);
    }
  }
}