package lab2;

import java.util.Arrays;

/**
 * Local onde se registram todos os resumos e encapsula todas as operações com resumos.
 *
 * @author Iago Alves
 */
public class RegistroResumos {
    private Resumo[] resumos;
    private int proximaPosicao;

    /**
     * Constrói o RegistroResumos, inicializa o array onde serão armazenados os resumos
     * e o índice que servirá de apontador para a próxima posição livre.
     *
     * @param numeroResumos define a capacidade máxima do array de resumos
     */
    public RegistroResumos(int numeroResumos) {
        this.resumos = new Resumo[numeroResumos];
        this.proximaPosicao = 0;
    }

    /**
     * Adiciona um novo resumo ao registro na próxima posição disponível,
     * desde que ainda não exista um resumo cadastrado com o mesmo tema.
     *
     * @param tema o tema do resumo a ser adicionado
     * @param conteudo o conteúdo do resumo a ser adicionado
     */
    public void adiciona(String tema, String conteudo) {
        if (this.temResumo(tema)) {
            return;
        }
        this.resumos[this.proximaPosicao] = new Resumo(tema, conteudo);

        if (this.proximaPosicao == this.resumos.length - 1) {
            this.proximaPosicao = 0;
        } else {
            this.proximaPosicao += 1;
        }
    }

    /**
     * Retorna um array de String contendo a representação de todos os resumos cadastrados.
     *
     * @return um array de String com os resumos formatados no padrão "tema: conteúdo"
     */
    public String[] pegaResumos() {
        int qntdResumos = this.conta();
        String[] resumosFormatado = new String[qntdResumos];

        for (int i = 0; i < qntdResumos; i++) {
            resumosFormatado[i] = this.resumos[i].toString();
        }
        return resumosFormatado;
    }

    /**
     * Retorna uma String com as informações gerais e temas de todos os resumos cadastrados.
     *
     * @return uma String contendo a quantidade e os temas dos resumos
     */
    public String imprimeResumos() {
        int qntdResumos = this.conta();
        String impressao = "- " + qntdResumos + " resumo(s) cadastrado(s)\n-";
        for (int i = 0; i < qntdResumos; i++) {
            if (i != qntdResumos - 1) {
                impressao += " " + this.resumos[i].getTema() + " |";
            } else {
                impressao += " " + this.resumos[i].getTema();
            }
        }
        return impressao;
    }

    /**
     * Conta a quantidade de resumos válidos armazenados atualmente no array.
     *
     * @return a quantidade de resumos cadastrados
     */
    public int conta() {
        int contagem = 0;
        for (int i = 0; i < this.resumos.length; i++) {
            if (this.resumos[i] == null) {
                return contagem;
            }
            contagem += 1;
        }
        return contagem;
    }

    /**
     * Verifica se já existe um resumo cadastrado com o tema informado.
     *
     * @param tema o tema do resumo procurado
     * @return true caso exista um resumo com esse tema, false caso contrário
     */
    public boolean temResumo(String tema) {
        int qntdResumos = this.conta();
        for (int i = 0; i < qntdResumos; i++) {
            if (this.resumos[i].getTema().equals(tema)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Busca os temas dos resumos cujo conteúdo contém a palavra chave informada,
     * ignorando diferenças entre maiúsculas e minúsculas.
     *
     * @param chaveDeBusca termo a ser pesquisado dentro do conteúdo dos resumos
     * @return um array de String com os temas encontrados ordenados alfabeticamente
     */
    public String[] busca(String chaveDeBusca) {
        String chaveLower = chaveDeBusca.toLowerCase();
        int qntdResumos = this.conta();
        int contador = 0;

        for (int i = 0; i < qntdResumos; i++) {
            if (this.resumos[i].getConteudo().toLowerCase().contains(chaveLower)) {
                contador++;
            }
        }

        String[] resultados = new String[contador];
        int index = 0;

        for (int i = 0; i < qntdResumos; i++) {
            if (this.resumos[i].getConteudo().toLowerCase().contains(chaveLower)) {
                resultados[index] = this.resumos[i].getTema();
                index++;
            }
        }

        Arrays.sort(resultados);
        return resultados;
    }
}