package barbeariaCorteNinja;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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


        // Obtém a data atual do sistema
        LocalDate dataAtual = LocalDate.now();

        // Obtém a hora atual do sistema
        LocalTime horaAtual = LocalTime.now();

         // Define os formatos desejados para data e hora
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yy");
        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm");

        // Formata a data e a hora de acordo com os formatos definidos
        String dataFormatada = dataAtual.format(formatoData);
        String horaFormatada = horaAtual.format(formatoHora);

        texto = novoTexto + "||"+ dataFormatada+"||"+ horaFormatada +"\n";
    }

      private static String texto = "\n";
      
    }

