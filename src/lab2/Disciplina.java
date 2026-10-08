package lab2;

import java.util.Arrays;

/**
 * Classe responsável por gerenciar as notas e as horas de estudo de uma disciplina específica.
 * Permite o cálculo de média aritmética ou ponderada com base na quantidade de notas e pesos definidos.
 *
 * @author Iago Alves
 */
public class Disciplina {
    private String nomeDisciplina;
    private int horasDeEstudo;
    private double[] notas;
    private int[] pesos;

    /**
     * Inicializa uma nova disciplina recebendo o seu nome.
     * Por padrão, a disciplina é criada com 4 notas e pesos iguais a 1.
     *
     * @param nomeDisciplina o nome da disciplina a ser criada
     */
    public Disciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
        this.horasDeEstudo = 0;
        this.notas = new double[4];
        this.pesos = new int[4];

        for (int i = 0; i < notas.length; i++) {
            this.notas[i] = 0;
            this.pesos[i] = 1;
        }
    }

    /**
     * Inicializa uma nova disciplina recebendo o seu nome e a quantidade de notas.
     * Por padrão, todas as notas possuem pesos iguais a 1.
     *
     * @param nomeDisciplina o nome da disciplina a ser criada
     * @param qtdNotas a quantidade de notas da disciplina
     */
    public Disciplina(String nomeDisciplina, int qtdNotas) {
        this.nomeDisciplina = nomeDisciplina;
        this.horasDeEstudo = 0;
        this.notas = new double[qtdNotas];
        this.pesos = new int[qtdNotas];

        for (int i = 0; i < notas.length; i++) {
            this.notas[i] = 0;
            this.pesos[i] = 1;
        }
    }

    /**
     * Inicializa uma nova disciplina recebendo o seu nome, a quantidade de notas
     * e o array contendo os pesos para o cálculo de média ponderada.
     *
     * @param nomeDisciplina o nome da disciplina a ser criada
     * @param qtdNotas a quantidade de notas da disciplina
     * @param pesos array contendo os pesos inteiros de cada nota
     */
    public Disciplina(String nomeDisciplina, int qtdNotas, int[] pesos) {
        this.nomeDisciplina = nomeDisciplina;
        this.horasDeEstudo = 0;
        this.notas = new double[qtdNotas];
        this.pesos = pesos;

        for (int i = 0; i < notas.length; i++) {
            this.notas[i] = 0;
        }
    }

    /**
     * Adiciona horas de estudo ao acumulador da disciplina.
     *
     * @param horas a quantidade de horas a ser adicionada
     */
    public void cadastraHoras(int horas) {
        this.horasDeEstudo += horas;
    }

    /**
     * Define o valor de uma das notas da disciplina.
     *
     * @param nota a posição da nota (de 1 até a quantidade total de notas) que se deseja modificar
     * @param valorNota o novo valor da nota selecionada
     */
    public void cadastraNota(int nota, double valorNota) {
        this.notas[nota - 1] = valorNota;
    }

    /**
     * Método auxiliar para o cálculo da média (ponderada ou aritmética) das notas.
     *
     * @return a média calculada das notas
     */
    public double calculaMedia() {
        double somaPonderada = 0;
        double somaPesos = 0;

        for (int i = 0; i < this.notas.length; i++) {
            somaPonderada += this.notas[i] * this.pesos[i];
            somaPesos += this.pesos[i];
        }

        return (somaPonderada / somaPesos);
    }

    /**
     * Analisa a média do aluno e a sua situação de aprovação frente à disciplina.
     *
     * @return true caso a média seja maior ou igual a 7.0, false caso contrário
     */
    public boolean aprovado() {
        return calculaMedia() >= 7.0;
    }

    /**
     * Retorna a representação em String da disciplina.
     *
     * @return uma String contendo o nome da disciplina, as horas estudadas, a média das notas e o array com cada nota
     */
    @Override
    public String toString() {
        double media = this.calculaMedia();
        return this.nomeDisciplina + " " + this.horasDeEstudo + " " + media + " " + Arrays.toString(this.notas);
    }
}