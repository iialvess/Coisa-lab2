package lab2;

/**
 * Classe responsável por manter a informação sobre a quantidade de horas de internet
 * que o aluno tem dedicado a uma disciplina remota.
 *
 * @author Iago Alves
 */
public class RegistroTempoOnline {

    private int tempoEsperado;
    private String nomeDisciplina;
    private int tempoInvestidoOnline;

    /**
     * Inicializa um novo registro de tempo online recebendo o nome da disciplina a ser monitorada.
     * Define por padrão o atributo tempoEsperado como 120.
     *
     * @param nomeDisciplina o nome da disciplina a ser monitorada
     */
    public RegistroTempoOnline(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
        this.tempoEsperado = 120;
    }

    /**
     * Inicializa um novo registro de tempo online recebendo o nome da disciplina a ser monitorada
     * e a quantidade de tempo esperado que se deve dedicar a essa disciplina.
     *
     * @param nomeDisciplina o nome da disciplina a ser monitorada
     * @param tempoEsperado a quantidade de tempo esperado a ser dedicada
     */
    public RegistroTempoOnline(String nomeDisciplina, int tempoEsperado) {
        this.nomeDisciplina = nomeDisciplina;
        this.tempoEsperado = tempoEsperado;
    }

    /**
     * Permite adicionar uma quantidade de tempo ao atributo tempoInvestidoOnline
     * referente ao tempo dedicado à disciplina.
     *
     * @param valor valor adicional a ser somado ao total de tempo investido online
     */
    public void adicionaTempoOnline(int valor) {
        tempoInvestidoOnline += valor;
    }

    /**
     * Confere se o aluno atingiu o tempo online esperado pela disciplina.
     *
     * @return true se o tempo investido for maior ou igual ao tempo esperado, false caso contrário
     */
    public boolean atingiuMetaTempoOnline() {
        return tempoInvestidoOnline >= tempoEsperado;
    }

    /**
     * Retorna a representação em String do registro de tempo online.
     *
     * @return uma String contendo o nome da disciplina e a relação do tempo investido pelo tempo esperado
     */
    @Override
    public String toString() {
        return nomeDisciplina + " " + tempoInvestidoOnline + "/" + tempoEsperado;
    }
}