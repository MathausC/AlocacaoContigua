package br.unicap.so2;

import java.util.ArrayList;

public class MapaDeBits {
    private ArrayList<Integer> blocosLivres;
    private byte[] blocos;

    private static MapaDeBits instace;
    
    private  MapaDeBits(byte[] disco){
        blocosLivres = new ArrayList<Integer>();
        blocos = new byte[disco.length];
        this.remapearBloco(blocos);
        this.mapear(disco);
    }

    public static MapaDeBits getInstace(byte[] disco) {
        if(instace == null) {
            instace = new MapaDeBits(disco);
        }
        return instace;
    }

    public void mapear(byte[] blocos) {
        for(int i = 0; i < blocos.length; i++) {
            System.out.println("bloco: "+blocos[i]);
            if(blocos[i] == -1) {
                blocosLivres.add(i);
            }
        }
    }
    
    public ArrayList<Integer> getBlocosLivres(){
        return blocosLivres;
    }

    public int getFreeSpace(Arquivo arquivo) {
        if(!blocosLivres.isEmpty()) {
            int tam = blocosLivres.size();
            for(int i = 0; i < tam; i++) {
                int b = blocosLivres.get(i) ;
                int cont = b;
                while(cont < b + arquivo.getTamanho()) {
                    if(blocos[cont] == -1) {
                        cont++;
                    } else {
                        break;
                    }
                }
                if(cont >= b + arquivo.getTamanho()) {
                    return b;
                }
            }
            return -1;
        }
        return -1;
    }

    private void remapearBloco(byte[] blocos) {
        for (int i = 0; i < blocos.length; i++) {
            blocos[i] = -1;
            System.out.println("Remapear: " + blocos[i]);
        }
    }
}