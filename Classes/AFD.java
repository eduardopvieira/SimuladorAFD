package Classes;
import Exception.MyException;
import java.util.Scanner;


public class AFD {
    private char[] alfabeto;
    private int qtdEstados;
    private int estadoInicial;
    private int[] estadosAceitacao;
    private int estadoAtual;
    private int[][] tabelaTransicoes;

    public AFD(){}
    public AFD(int qtdEstados, char[] alfabeto, int estadoInicial, int[] estadosAceitacao, int[][] tabelaTransicoes) {
        this.qtdEstados = qtdEstados;
        this.alfabeto = alfabeto;
        this.estadoInicial = estadoInicial;
        this.estadosAceitacao = estadosAceitacao;
        this.tabelaTransicoes = tabelaTransicoes;
    }




//=========================Get e Set alfabeto===========================
    public char[] getAlfabeto () {
        return alfabeto;
    }

    public void setAlfabeto ( char[] alfabeto){
        if (alfabeto.length > 0 && alfabeto.length < 2) {
            this.alfabeto = alfabeto;
        }
    }
//=========================Get e Set QTD Estados===========================
    public int getQtdEstados () {
        return qtdEstados;
    }

    public void setQtdEstados ( int qtdEstados) throws MyException {
        if (qtdEstados > 0) {
            this.qtdEstados = qtdEstados;
        }
    }
//=========================Get e Set Estado Inicial===========================
    public int getEstadoInicial () {
        return estadoInicial;
    }

    public void setEstadoInicial ( int estadoInicial){
        if (estadoInicial > 0 || estadoInicial > this.getQtdEstados()) {
            this.estadoInicial = estadoInicial;
        }
    }
    //=========================Get e Set Estados de Aceitacao==========================
    public int[] getEstadosAceitacao () {
        return estadosAceitacao;
    }

    public void setEstadosAceitacao ( int[] estadosAceitacao){
        if (estadosAceitacao.length > 0) {
            this.estadosAceitacao = estadosAceitacao;
        }
    }
    //=========================Get e Set Estado Atual=========================
    public int getEstadoAtual () {
        return estadoAtual;
    }

    public void setEstadoAtual ( int estadoAtual){
        if (estadoAtual > 0 && estadoAtual <= qtdEstados) {
            this.estadoAtual = estadoAtual;
        }
    }
    //==========================Get tabela de transiçoes=======================

    public int[][] getTabelaTransicoes() {
        return this.tabelaTransicoes;
    }
}
