package barbeariaCorteNinja;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Eliminar {
    public static boolean excluirCliente(String nome) {
        File arquivo = new File("dados.txt");
        ArrayList<String> linhas = new ArrayList<>();
        boolean encontrado = false;

        try (Scanner leitorArquivo = new Scanner(arquivo)) {
            while (leitorArquivo.hasNextLine()) {
                String linha = leitorArquivo.nextLine();
                String[] dadosCliente = linha.split("\\|\\|");

                if (dadosCliente.length > 0 && dadosCliente[0].equals(nome)) {
                    // Pula as próximas duas linhas correspondentes ao e-mail e número
                    if (leitorArquivo.hasNextLine()) leitorArquivo.nextLine();
                    if (leitorArquivo.hasNextLine()) leitorArquivo.nextLine();
                    encontrado = true;
                } else {
                    linhas.add(linha);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado.");
            e.printStackTrace();
            return false;
        }

        // Regrava o arquivo sem as linhas do cliente excluído
        try (FileWriter escritor = new FileWriter("dados.txt")) {
            for (String linha : linhas) {
                escritor.write(linha + "\n");
            }
        } catch (IOException e) {
            System.out.println("Um erro aconteceu ao gravar no arquivo.");
            e.printStackTrace();
            return false;
        }

        return encontrado;
    }
}
