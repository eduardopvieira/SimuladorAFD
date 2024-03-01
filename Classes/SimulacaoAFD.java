package Classes;
import Classes.AFD;

import java.sql.SQLOutput;
import java.util.Scanner;

public class SimulacaoAFD {

    public AFD lerDetalhesAFD() {
        Scanner scanner = new Scanner(System.in);
        // ============ LER ESTADOS =============
        System.out.print("Digite a quantidade de estados: ");
        int qtdEstados = scanner.nextInt();
        int[][] tabelaTransicoes = new int[qtdEstados][];
        for (int i = 0; i < qtdEstados; i++) {
            tabelaTransicoes[i] = new int[qtdEstados];
        }

        // =========== LER O ALFABETO ===========
        scanner.nextLine(); // serve pra limpar o buffer, nao tirar
        System.out.print("Digite o alfabeto (sem separação entre os símbolos) ");
        String alfabetoString = scanner.nextLine();
        char[] alfabeto = alfabetoString.toCharArray();

        // =========== DEFININDO FUNCOES DE TRANSICAO ===========
        for (int i = 0; i < qtdEstados; i++) {
            for (int j = 0; j < alfabeto.length; j++) {
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

        return new AFD(qtdEstados, alfabeto, estadoInicial, estadosAceitacao, tabelaTransicoes);
    }





    public boolean simularAFD(String cadeia, AFD afd) {
        int estadoAtual = afd.getEstadoAtual();

        for (int i = 0; i < cadeia.length(); i++) {
            char simbolo = cadeia.charAt(i);
            int indiceSimbolo = -1;

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
        }

        for (int estado : afd.getEstadosAceitacao()) {
            if (estado == estadoAtual) {
                return true;
            }
        }
        return false;
    }
}
