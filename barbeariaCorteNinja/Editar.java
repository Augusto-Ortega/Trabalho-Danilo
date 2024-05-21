package barbeariaCorteNinja;

import java.io.File;
import java.io.IOException;


public class Editar {
    public static void main(String[] args) {
        // Modificando o valor da variável texto através do setter
        Gravar.setTexto("Novo texto definido por outra classe!");
        Gravar.main(null);
        System.out.println("Teste");
    }
}
