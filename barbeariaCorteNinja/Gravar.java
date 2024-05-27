package barbeariaCorteNinja;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.io.FileWriter;
import java.io.IOException;

public class Gravar {
    private static String texto = "\n"; // Inicializa a variável texto

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

        // Formata o texto a ser gravado
        texto = novoTexto + "||" + dataFormatada + "||" + horaFormatada + "\n";
    }

    public static void main(String[] args) {
        try {
            FileWriter escrever = new FileWriter("dados.txt", true);
            escrever.write(texto);  // Usa a variável estática texto
            escrever.close();
            System.out.println("Gravado com sucesso no arquivo!");
        } catch (IOException erro) {
            System.out.println("Um erro aconteceu: ");
            erro.printStackTrace();
        }
    }
}
