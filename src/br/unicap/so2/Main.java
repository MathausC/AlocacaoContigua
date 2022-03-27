package br.unicap.so2;
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        byte[] disco = new byte[100];
        byte[] buffer = new byte[100];
        remapeaArrays(disco);
        remapeaArrays(buffer);
        MapaDeBits mapaDeBits = MapaDeBits.getInstace(disco);
        Diretorio diretorio = new Diretorio();
        Scanner i = new Scanner(System.in);
        int escolha;
        String nome, conteudo;
        Arquivo arquivo;


        do{
            menu();
            escolha = i.nextInt(); i.nextLine();
            switch(escolha){
                case 1: 
                    System.out.println("Digite o nome do arquivo:");
                    nome = i.nextLine();
                    arquivo = new Arquivo(nome);
                    ler(arquivo, buffer, diretorio, disco);
                    break;
                case 2: 
                    System.out.println("Digite o nome do arquivo:");
                    nome = i.nextLine();
                    System.out.println("Digite o que deseja escrever no arquivo:");
                    conteudo = i.nextLine();
                    try{
                        arquivo = new Arquivo(nome, convertToByte(conteudo));
                        escrever(arquivo, mapaDeBits, disco, diretorio, buffer);
                    }catch(UnsupportedEncodingException e){
                        System.err.println("falha ao tentar converter o conteudo");
                    }
                    break;
                case 0: 
                    System.out.println("Até logo!");
                    break;
                default: System.out.println("Opção inválida. Tente novamente.");break;
            }
        }while(escolha != 0);

        i.close();
    }

    public static void ler(Arquivo arquivo, byte[] buffer, Diretorio diretorio, byte[] disco){
        int index = diretorio.posicaoArquivo(arquivo);
        limpaBuffer(buffer);
        if(index != -1) {
            int node = diretorio.getInicio(index);
            int tamanho = diretorio.tamanhoArquivo(arquivo);
            for(int i = node; i < tamanho; i++ ) {
                buffer[i-node] = disco[i];
            }
            imprimeBuffer(buffer);
            try{
                imprimeConteudo(buffer);
            }catch(UnsupportedEncodingException e){
                System.err.println("Falha ao tentar exibir o conteudo em Texto");
            }
        } else {
            System.err.println("Arquivo não encontrado.");
        }
    }

    private static void carregaNoBuffer(byte[] buffer, Arquivo arquivo) {
        if(arquivo != null && buffer != null) {
            for(int i = 0; i < arquivo.getTamanho(); i++) {
                buffer[i] = arquivo.getConteudo()[i];
            }
        }
    }

    private static void limpaBuffer(byte[] buffer) {
        for(int i = 0; i < buffer.length; i++) {
            buffer[i] = 0;
        }
    }
 
    public static void escrever(Arquivo arquivo, MapaDeBits mapaDeBits, byte[] disco, Diretorio diretorio, byte[] buffer){
        int node = mapaDeBits.getFreeSpace(arquivo);
        if(node != -1) {
            carregaNoBuffer(buffer, arquivo);
            for(int i = node; i < arquivo.getTamanho(); i++) {
                disco[i] = buffer[i-node];
            }
            imprimeDisco(disco);
            limpaBuffer(buffer);
            mapaDeBits.mapear(disco);
            diretorio.addArquivo(arquivo);
            diretorio.addInicio(node);
        } else {
            System.err.println("Não há espaço suficiente no disco.");
        }
    }
    public static void menu(){
        System.out.println("1 - Ler arquivo");
        System.out.println("2 - Escrever no arquivo");
        System.out.println("0 - Sair");
        System.out.println("Escolha uma opção:");
    }
    public static byte[] convertToByte(String conteudo) throws UnsupportedEncodingException{
        byte[] byteArray = conteudo.getBytes("UTF-8");
        return byteArray;  
    }
    private static void imprimeBuffer(byte[] buffer) {
        String mensagem = "Buffer: ";
        for (int i = 0; i < buffer.length; i++) {
            mensagem += buffer[i];
        }
        System.out.println(mensagem);
    }

    private static void imprimeDisco(byte[] disco) {
        String mensagem = "Disco: ";
        for (int i = 0; i < disco.length; i++) {
            mensagem += disco[i];
        }
        System.out.println(mensagem);
    }
    public static void imprimeConteudo(byte[] buffer) throws UnsupportedEncodingException{
        String texto = new String(buffer, "UTF-8");
        System.out.println("Conteudo: "+texto);
    }

    private static void remapeaArrays(byte[] array) {
        for(int i = 0; i < array.length; i++) {
            array[i] = -1;
        }
    }
}