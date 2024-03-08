package Classes;
import Exception.MyException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SimulacaoAFD {

    public AFD lerDetalhesAFD() {

        Scanner scanner = new Scanner(System.in);

        // ============ DEFININDO ESTADOS DO AFD =============
        System.out.print("Digite a quantidade de estados: ");
        int qtdEstados = scanner.nextInt();

        scanner.nextLine(); // serve pra limpar o buffer, nao tirar
        // =========== DEFININDO O ALFABETO ===========
        System.out.print("Digite o alfabeto (sem nenhuma separação entre os símbolos): ");
        String alfabetoString = scanner.nextLine();
        char[] alfabeto = alfabetoString.toCharArray();
        int qtdSimbolos = alfabeto.length;

        //============ CRIANDO A MATRIZ COM FUNÇOES DE TRANSIÇAO ============
        int[][] tabelaTransicoes = new int[qtdEstados][qtdSimbolos];

        // =========== DEFININDO FUNCOES DE TRANSICAO ===========
        for (int i = 0; i < qtdEstados; i++) { //linhas correspondem a quantidade de estados
            for (int j = 0; j < alfabeto.length; j++) { //colunas correspondem ao tamanho do alfabeto
                System.out.print("Digite o estado de transição para quando " + i + " recebe " + alfabeto[j] + ": ");
                tabelaTransicoes[i][j] = scanner.nextInt();
            }
        }
        // ============ DEFININDO O ESTADO INICIAL ============
        System.out.print("Digite o estado inicial: ");
        int estadoInicial = scanner.nextInt();

        // =========== DEFININDO ESTADOS DE ACEITACAO ===========
        scanner.nextLine(); // serve pra limpar o buffer, nao tirar
        System.out.print("Digite o(s) estado(s) de aceitação (separado por espaços): ");
        String strEstadosAceitacao = scanner.nextLine();
        String[] pivo = strEstadosAceitacao.split(" ");

        //Colocando os estados de aceitacao no vetor de estados de aceitacao
        int[] estadosAceitacao = new int[pivo.length];
        for (int i = 0; i < pivo.length; i++) {
            estadosAceitacao[i] = Integer.parseInt(pivo[i]);
        }

        try {
            return new AFD(qtdEstados, alfabeto, estadoInicial, estadosAceitacao, tabelaTransicoes);
        } catch (MyException e) {
            throw new RuntimeException("Não foi possivel criar instância de AFD.");
        }

    }




    public boolean simularAFD(String cadeia, AFD afd) {

        int estadoAtual = afd.getEstadoInicial();
        Map<Character, Integer> mapaAlfabeto = new HashMap<>();

        //Mapeando os valores das letras num hashmap, evitando que simbolos repetidos existam
        for (int i = 0; i < afd.getAlfabeto().length; i++) {
            mapaAlfabeto.put(afd.getAlfabeto()[i], i);
        }

        //repete pra cada simbolo dentro da cadeia enviada pelo usuario
        for (int i = 0; i < cadeia.length(); i++) {
            char simbolo = cadeia.charAt(i);
            int indiceSimbolo = -1; //Caso o símbolo esteja na cadeia, esse índice vai ser alterado. se não alterar, vai interromper

           //verifica se a letra ta dentro do alfabeto
            if (mapaAlfabeto.containsKey(simbolo)) {
                indiceSimbolo = mapaAlfabeto.get(simbolo);
            } else {
                System.out.println("Foi digitado um símbolo não pertencente a cadeia.");
                return false;
            }

            //Altera o estado atual.
            estadoAtual = afd.getTabelaTransicoes()[estadoAtual][indiceSimbolo];
            System.out.println("Você está no estado " + estadoAtual);
        }

        for (int estadoAceitacao : afd.getEstadosAceitacao()) {
            if (estadoAceitacao == estadoAtual) {
                return true;
            }
        }
        return false;
    }
}
