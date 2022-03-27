package br.unicap.so2;

public class Arquivo {
    private String nome;
    private byte[] conteudo;

    public Arquivo(String nome, byte[] conteudo) {
        this.nome = nome;
        this.conteudo = conteudo;
    }

    public String getNome() {
        return this.nome;
    }

    public int getTamanho() {
        return this.conteudo.length;
    }
}