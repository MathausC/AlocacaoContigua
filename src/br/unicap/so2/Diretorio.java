package br.unicap.so2; 

import java.util.ArrayList;

public class Diretorio {
    private ArrayList<Arquivo> arquivos;
    private ArrayList<Integer> inicios;

    public Diretorio(){
        this.arquivos = new ArrayList<Arquivo>();
        this.inicios = new ArrayList<Integer>();
    }

    public int getInicio(int index) {
        return this.inicios.get(index);
    }

    public void addInicio(int inicio) {
        this.inicios.add(inicio);
    }

    public void addArquivo(Arquivo arquivo) {
        if(arquivo != null) 
            this.arquivos.add(arquivo);
    }

    public int posicaoArquivo(Arquivo arquivo) {
        return arquivos.indexOf(arquivo);
    }

    public int tamanhoArquivo(Arquivo arquivo) {
        int index = posicaoArquivo(arquivo);
        if(index != -1) {
            return arquivos.get(index).getTamanho();
        }
        return -1;
    }

    public void removeArquivo(Arquivo arquivo) {
        if(arquivo !=  null)
            this.arquivos.remove(arquivo);
    }
}