package br.unicap.so2;

public class Arquivo {
    private String nome;
    private byte[] conteudo;

    public Arquivo(String nome, byte[] conteudo) {
        this.nome = nome;
        this.conteudo = conteudo;
    }
    public Arquivo(String nome){
        this.nome = nome;
        conteudo = new byte[100];
    }

    public String getNome() {
        return this.nome;
    }

    public int getTamanho() {
        return this.conteudo.length;
    }

    public byte[] getConteudo() {
        return this.conteudo;
    }

    @Override
    public boolean equals(Object o) {
        if(o.getClass() == this.getClass()) {
            Arquivo other  = (Arquivo) o;
            return other.getNome().equals(this.getNome());
        } else {
            return false;
        }
    } 
}