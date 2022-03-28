package br.unicap.so2;

import java.util.ArrayList;

public class MapaDeBits {
    private ArrayList<Integer> blocosLivres;
    private byte[] blocos;
    
    public MapaDeBits(byte[] disco){
        blocosLivres = new ArrayList<Integer>();
        blocos = new byte[disco.length];
        this.remapearBloco(blocos);
        this.mapear(disco);
    }

    public void mapear(byte[] blocos) {
        for(int i = 0; i < blocos.length; i++) {
            if(blocos[i] == -1) {
                blocosLivres.add(i);
            }
        }
    }
    
    public ArrayList<Integer> getBlocosLivres(){
        return blocosLivres;
    }

    private void remapearBloco(byte[] blocos) {
        for (int i = 0; i < blocos.length; i++) {
            blocos[i] = -1;
        }
    }
    public int getEspacoLivre(Arquivo arquivo){
        int tamanhoArquivo = arquivo.getTamanho();
        int contSeguidos = 0;
        if(!blocosLivres.isEmpty()){
            int tamanhoLivre = blocosLivres.size();
            for(int i = 1; i < tamanhoLivre; i++){
                if(blocosLivres.get(i) == (blocosLivres.get(i-1) + 1)){
                    contSeguidos++;
                    if(contSeguidos >= tamanhoArquivo){
                        return (blocosLivres.get(i) - contSeguidos +1);
                    }
                }else{
                    contSeguidos = 0;
                }
            }
        }
        return -1;
    }
}