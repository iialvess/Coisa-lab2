package lab2;

/**
 * Representação do descanso do aluno, auxiliando no seu monitoramento.
 * Todo aluno tem uma rotina de descanso que envolve horas totais e as semanas
 * em que essas horas foram distribuídas.
 *
 * @author Iago Alves
 */
public class Descanso {
    private int horasDeDescanso;
    private int numeroDeSemana;

    /**
     * Inicializa o monitoramento do descanso do aluno.
     * Todo aluno começa com as horas de descanso zeradas e o número de semanas igual a 1.
     */
    public Descanso() {
        this.horasDeDescanso = 0;
        this.numeroDeSemana = 1;
    }

    /**
     * Define as horas de descanso do aluno com base no valor fornecido.
     *
     * @param valor o valor inteiro que define a quantidade de horas de descanso
     */
    public void defineHorasDescanso(int valor) {
        this.horasDeDescanso = valor;
    }

    /**
     * Define as semanas em que o aluno distribuiu seu descanso com base no valor fornecido.
     *
     * @param valor o valor inteiro que define a quantidade de semanas de descanso
     */
    public void defineNumeroSemanas(int valor) {
        this.numeroDeSemana = valor;
    }

    /**
     * Calcula a distribuição do descanso durante as semanas e define o status do aluno
     * com base nesse cálculo, ou seja, verifica se o aluno está cansado ou descansado.
     *
     * @return retorna uma string representando o estado do aluno: "descansado" ou "cansado"
     */
    public String getStatusGeral() {
        if (this.numeroDeSemana == 0) {
            return "cansado";
        }

        int mediaHorasPorSemana = this.horasDeDescanso / this.numeroDeSemana;

        if (mediaHorasPorSemana >= 26) {
            return "descansado";
        } else {
            return "cansado";
        }
    }
}