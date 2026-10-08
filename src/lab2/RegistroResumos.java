package lab2;

/**
 * Classe responsável pelo armazenamento dos resumos criados pelo aluno.
 * Armazena uma quantidade limitada de resumos definida pelo próprio aluno.
 *
 * @author Iago Alves
 */
public class RegistroResumos {
    private Resumo[] totalResumos;
    private int numeroDeResumos; // Capacidade máxima
    private int quantidadeAtual;
    private int proximaPosicao;

    /**
     * Inicializa um novo Registro para os resumos do aluno.
     * Define a capacidade máxima com base no valor fornecido e inicializa o array de resumos.
     *
     * @param numeroDeResumos número máximo de resumos que podem ser adicionados ao registro
     */
    public RegistroResumos(int numeroDeResumos) {
        this.numeroDeResumos = numeroDeResumos;
        this.totalResumos = new Resumo[numeroDeResumos];
        this.quantidadeAtual = 0;
        this.proximaPosicao = 0;
    }

    /**
     * Adiciona um novo resumo ao registro na próxima posição disponível,
     * desde que ainda não exista um resumo cadastrado com o mesmo tema.
     *
     * @param tema o tema do resumo
     * @param conteudo o conteúdo do resumo
     */
    public void adiciona(String tema, String conteudo) {
        if (this.temResumo(tema)) {
            return;
        }
        this.totalResumos[this.proximaPosicao] = new Resumo(tema, conteudo);

        // Controla o incremento da quantidade de resumos válidos cadastrados
        if (this.quantidadeAtual < this.numeroDeResumos) {
            this.quantidadeAtual++;
        }

        // Substituição circular
        if (this.proximaPosicao == this.totalResumos.length - 1) {
            this.proximaPosicao = 0;
        } else {
            this.proximaPosicao += 1;
        }
    }

    /**
     * Gera um array contendo os resumos cadastrados formatados como "tema: resumo".
     *
     * @return um array de String contendo os resumos cadastrados
     */
    public String[] pegaResumos() {
        String[] copiaResumos = new String[this.quantidadeAtual];
        for (int i = 0; i < this.quantidadeAtual; i++) {
            copiaResumos[i] = this.totalResumos[i].toString();
        }
        return copiaResumos;
    }

    /**
     * Retorna a quantidade de resumos cadastrados atualmente no registro.
     *
     * @return o total de posições preenchidas com resumos
     */
    public int conta() {
        return this.quantidadeAtual;
    }

    /**
     * Imprime a quantidade de resumos cadastrados e, na linha seguinte, os temas desses resumos.
     *
     * @return uma String com a quantidade e os temas dos resumos cadastrados
     */
    public String imprimeResumos() {
        int qntdResumos = this.conta();
        String impressao = "- " + qntdResumos + " resumo(s) cadastrado(s)\n-";
        for (int i = 0; i < qntdResumos; i++) {
            if (i != qntdResumos - 1) {
                impressao += " " + this.totalResumos[i].getTema() + " |";
            } else {
                impressao += " " + this.totalResumos[i].getTema();
            }
        }
        return impressao;
    }

    /**
     * Percorre o registro verificando se existe algum resumo cadastrado com o tema informado.
     *
     * @param tema o tema do resumo a ser pesquisado
     * @return true caso exista um resumo com o tema informado, false caso contrário
     */
    public boolean temResumo(String tema) {
        for (int i = 0; i < this.quantidadeAtual; i++) {
            if (totalResumos[i].getTema().equals(tema)) {
                return true;
            }
        }
        return false;
    }
}