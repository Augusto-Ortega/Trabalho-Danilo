package barbeariaCorteNinja;


import java.io.FileWriter; 
import java.io.IOException;


public class Gravar {
    public static void main(String[] args) {
        try {
          FileWriter escrever = new FileWriter("dados.txt", true);
          escrever.write(texto);
          escrever.close();
          System.out.println("Gravado com sucesso no arquivo!");
        } catch (IOException e) {
          System.out.println("Um erro aconteceu: ");
          e.printStackTrace();
        }
      }
      
      public static void setTexto(String novoTexto) {
        texto = novoTexto;
    }

      private static String texto = "Arquivos em java pode ser interessante\n";
      
    }

