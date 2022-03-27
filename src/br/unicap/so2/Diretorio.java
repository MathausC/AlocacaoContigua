package br.unicap.so2; 

import java.util.ArrayList;

public class Diretorio {
    private ArrayList<Arquivo> arquivos;
    private int inicio;

    public Diretorio(){
        this.arquivos = new ArrayList<Arquivo>();
    }

    public int getInicio() {
        return this.inicio;
    }

    public void setInicio(int inicio) {
        this.inicio = inicio;
    }

    public void addArquivo(Arquivo arquivo) {
        if(arquivo != null) 
            this.arquivos.add(arquivo);
    }

    public void removeArquivo(Arquivo arquivo) {
        if(arquivo !=  null)
            this.arquivos.remove(arquivo);
    }
}