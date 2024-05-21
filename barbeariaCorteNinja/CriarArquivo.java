package barbeariaCorteNinja;

import java.io.File; 
import java.io.IOException;

public class CriarArquivo {
  public static void main(String[] args) {
    try {
      File arquivo = new File("dados.txt");
      if (arquivo.createNewFile()) {
        System.out.println("Arquivo criado com sucesso: " + arquivo.getName());
      } else {
        System.out.println("O arquivo já existe");
      }
    } catch (IOException erro) {
      System.out.println("Um erro aconteceu.");
      erro.printStackTrace();
    }
  }
}