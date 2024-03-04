import java.util.Scanner;
import Classes.AFD;
import Classes.SimulacaoAFD;

public class Testes {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SimulacaoAFD simu = new SimulacaoAFD();
        AFD afd = simu.lerDetalhesAFD();


        System.out.println("Digite uma cadeia para ser reconhecida (digite '.' para encerrar os testes):");

        while (true) {
            String cadeia = sc.nextLine();

            if (cadeia.equals(".")) {
                System.out.println("Encerrando");
                break;
            }

            boolean resultado = simu.simularAFD(cadeia, afd);
            if (resultado) {
                System.out.println("Cadeia reconhecida!");
            } else {
                System.out.println("Cadeia não reconhecida!");
            }
        }
        sc.close();
    }
}