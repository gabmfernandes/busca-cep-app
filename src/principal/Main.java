package principal;

import modelos.BuscadorCEP;
import modelos.Endereco;
import modelos.GeradorArquivo;

import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BuscadorCEP buscador = new BuscadorCEP();
        System.out.println("Digite um cep para a pesquisa: ");
        String cep = scanner.nextLine();

        try{
            Endereco endereco = buscador.buscarCep(cep);
            System.out.println(endereco);
            GeradorArquivo geradorArquivo = new GeradorArquivo();
            geradorArquivo.gerarArquivo(endereco);
        }catch(RuntimeException | IOException e){
            System.out.println(e.getMessage());
            System.out.println("Finalizando a aplicação");
        }










        /*FileWriter escrita = new FileWriter(cep + ".txt");
        escrita.write(gson.toJson(endereco));
        escrita.close();*/
    }
}
