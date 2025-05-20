package project.game.list.models;

public class GameList {

    private String nome;
    private int ano;
    private String genero;
    private String duracao;
    private String data;

    //GETTERS E SETTERS

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getNome() {
        return nome;
    }

    public int getAno() {
        return ano;
    }

    public String getGenero() {
        return genero;
    }

    public String getDuracao() {
        return duracao;
    }

    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return String.format("""
        ***********************************************
        Nome do jogo: %s
        Ano de lançamento: %d
        Gênero: %s
        Tempo de jogo: %s
        Data que zerou o jogo: %s
        
        """, this.nome, this.ano, this.genero, this.duracao, this.data);
    }


}
