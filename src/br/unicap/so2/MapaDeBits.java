package br.unicap.so2;

import java.util.ArrayList;

public class MapaDeBits {
    private ArrayList<Integer> blocosLivres;
    private byte[] blocos;

    private static MapaDeBits instace;
    
    private  MapaDeBits(byte[] disco){
        this.blocos = disco;
        blocosLivres = new ArrayList<Integer>();
        this.mapear();
    }

    public static MapaDeBits getInstace(byte[] disco) {
        if(instace == null) {
            instace = new MapaDeBits(disco);
        }
        return instace;
    }

    public void mapear() {
        for(int i = 0; i < blocos.length; i++) {
            if(blocos[i] == 0) {
                blocosLivres.add(i);
            }
        }
    }
    
    public ArrayList<Integer> getBlocosLivres(){
        return blocosLivres;
    }

    public boolean isFreeSpace(Arquivo arquivo) {
        if(!blocosLivres.isEmpty()) {
            for(int b : blocosLivres) {
                int cont = b;
                while(cont < b + arquivo.getTamanho()) {
                    if(blocos[cont] == 0) {
                        cont++;
                    } else {
                        break;
                    }
                }
                if(cont >= b + arquivo.getTamanho()) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}