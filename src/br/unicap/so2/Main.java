package br.unicap.so2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        byte[] disco = new byte[100];
        MapaDeBits mapaDeBits = MapaDeBits.getInstace(disco);
        byte[] buffer = new byte[100];
        Scanner i = new Scanner(System.in);
        int escolha;
        String nome;

        do{
            menu();
            escolha = i.nextInt(); i.nextLine();
            switch(escolha){
                case 1: 
                    
                    break;
                case 2: 
                    System.out.println("Digite o nome do arquivo:");
                    nome = i.nextLine();
                    System.out.println("Digite o que deseja escrever no arquivo:");
                    
                    Arquivo arquivo = new Arquivo();
                    break;
                case 0: 
                    System.out.println("Até logo!");
                    break;
                default: System.out.println("Opção inválida. Tente novamente.");break;
            }
        }while(escolha != 0);
    }

    public static void ler(String nome){
        
    }

    public static void escrever(Arquivo aquivo){
         if(mapaDeBits.get
    }
    public static void menu(){
        System.out.println("1 - Ler arquivo");
        System.out.println("2 - Escrever no arquivo");
        System.out.println("Escolha uma opção:");
    }
}