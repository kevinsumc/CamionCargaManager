package Semana9;

public class encomendas {

    private String nome;
    private String origem;
    private String destino;
    private int volume;

    public encomendas(String nome, String origem, String destino, int volume) {
        this.nome = nome;
        this.origem = origem;
        this.destino = destino;
        this.volume = volume;
    }

    public String getNome() {
        return nome;
    }

    public String getOrigem() {
        return origem;
    }

    public String getDestino() {
        return destino;
    }

    public int getVolume() {
        return volume;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Encomenda:" + "\nNome:" + nome
                + "\nOrigem:" + origem
                + "\nDestino:" + destino
                + "\nVolumen:" + volume;
    }

}
