package lab2;

import java.util.Arrays;

/**
 * Classe responsável por gerenciar as notas e as horas de estudo de uma disciplina específica.
 * Por padrão, uma disciplina tem 4 notas.
 * O aluno estará aprovado uma vez que a média das suas 4 notas resulte em 7.0 ou mais.
 *
 * @author Iago Alves
 */
public class Disciplina {
    private String nomeDisciplina;
    private int horasDeEstudo;
    private double[] notas = new double[4];

    /**
     * Inicializa uma nova disciplina recebendo o seu nome.
     *
     * @param nomeDisciplina o nome da disciplina a ser criada
     */
    public Disciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
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
     * Define o valor de uma das quatro notas da disciplina.
     *
     * @param nota a posição da nota de 1 a 4 que se deseja modificar
     * @param valorNota o novo valor da nota selecionada
     */
    public void cadastraNota(int nota, double valorNota) {
        this.notas[nota - 1] = valorNota;
    }

    /**
     * Método auxiliar para o cálculo da média das 4 notas.
     *
     * @return a média aritmética das notas
     */
    public double calculaMedia() {
        double soma = 0;

        for (int i = 0; i < this.notas.length; i++) {
            soma += this.notas[i];
        }

        return (soma / this.notas.length);
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