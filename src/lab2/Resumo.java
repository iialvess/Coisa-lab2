package lab2;

/**
 * Classe responsável por armazenar o tema e o conteúdo inserido pelo aluno para compor um resumo.
 *
 * @author Iago Alves
 */
public class Resumo {
    private String tema;
    private String conteudo;

    /**
     * Inicializa um novo Resumo com o tema e o conteúdo informados pelo aluno.
     *
     * @param tema o tema ou assunto do resumo
     * @param conteudo o texto descritivo/conteúdo do resumo
     */
    public Resumo(String tema, String conteudo) {
        this.tema = tema;
        this.conteudo = conteudo;
    }

    /**
     * Retorna o tema do resumo criado.
     *
     * @return o tema do resumo
     */
    public String getTema() {
        return this.tema;
    }

    /**
     * Retorna o conteúdo do resumo criado.
     *
     * @return o conteúdo do resumo
     */
    public String getConteudo() {
        return this.conteudo;
    }

    /**
     * Retorna a representação em String do resumo no formato "tema: conteúdo".
     *
     * @return uma String formatada contendo o tema e o conteúdo do resumo
     */
    @Override
    public String toString() {
        return this.tema + ": " + this.conteudo;
    }
}