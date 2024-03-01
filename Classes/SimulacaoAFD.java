package Classes;
import Exception.MyException;
import java.util.Scanner;

public class SimulacaoAFD {

    public AFD lerDetalhesAFD() {
        Scanner scanner = new Scanner(System.in);
        // ============ DEFININDO ESTADOS DO AFD =============
        System.out.print("Digite a quantidade de estados: ");
        int qtdEstados = scanner.nextInt();
        int[][] tabelaTransicoes = new int[qtdEstados][];
        for (int i = 0; i < qtdEstados; i++) {
            tabelaTransicoes[i] = new int[qtdEstados];
        }

        // =========== DEFININDO O ALFABETO ===========
        scanner.nextLine(); // serve pra limpar o buffer, nao tirar
        System.out.print("Digite o alfabeto (sem separação entre os símbolos) ");
        String alfabetoString = scanner.nextLine();
        char[] alfabeto = alfabetoString.toCharArray();

        // =========== DEFININDO FUNCOES DE TRANSICAO ===========
        for (int i = 0; i < qtdEstados; i++) { //linhas correspondem a quantidade de estados
            for (int j = 0; j < alfabeto.length; j++) { //colunas correspondem ao tamanho do alfabeto
                System.out.printf("Digite o estado de transição para quando " + i + " recebe " + alfabeto[j] + ": ");
                tabelaTransicoes[i][j] = scanner.nextInt();
            }
        }
        // ============ DEFININDO O ESTADO INICIAL ============
        System.out.println("Digite o estado inicial: ");
        int estadoInicial = scanner.nextInt();

        // =========== DEFININDO ESTADOS DE ACEITACAO ===========
        scanner.nextLine(); // serve pra limpar o buffer, nao tirar
        System.out.print("Digite o(s) estado(s) de aceitação (separado por espaços)");
        String strEstadosAceitacao = scanner.nextLine();
        String[] arrayStr = strEstadosAceitacao.split(" ");

        int[] estadosAceitacao = new int[arrayStr.length];
        for (int i = 0; i < arrayStr.length; i++) {
            estadosAceitacao[i] = Integer.parseInt(arrayStr[i]);
        }

        try {
            return new AFD(qtdEstados, alfabeto, estadoInicial, estadosAceitacao, tabelaTransicoes);
        } catch (MyException e) {
            throw new RuntimeException("Não foi possivel criar instância de AFD.");
        }

    }





    public boolean simularAFD(String cadeia, AFD afd) {
        int estadoAtual = afd.getEstadoAtual();
        for (int i = 0; i < cadeia.length(); i++) {
            char simbolo = cadeia.charAt(i);
            int indiceSimbolo = -1; //Caso o símbolo esteja na cadeia, esse índice vai ser alterado. se não alterar, vai interromper

            for (int j = 0; j < afd.getAlfabeto().length; j++) {
                if (simbolo == afd.getAlfabeto()[j]) {
                    indiceSimbolo = j;
                    break;
                }
            }

            if (indiceSimbolo == -1) {
                System.out.println("Erro: símbolo inválido encontrado na cadeia.");
                return false;
            }

            estadoAtual = afd.getTabelaTransicoes()[estadoAtual][indiceSimbolo];
            System.out.println("Você está no estado " + estadoAtual);
        }

        for (int estado : afd.getEstadosAceitacao()) {
            if (estado == estadoAtual) {
                return true;
            }
        }
        return false;
    }
}
