package chipher2;

import Transposition.ColumnarTransposition;
import java.io.Console;
import java.util.Scanner;

public class Chipher2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Scanner text = new Scanner(System.in);
        String ciphedText = "";
        String deciphedText = "";
        
        String plainText = "A gente não se liberta de um hábito atirando-o pela janela: é preciso fazê-lo descer a escada, degrau por degrau.";
        String key = "MarkTwain";
       
        int op = 0;
        while (op != 3) {
            System.out.println("\nChipher2 - Criptografia de Transposicao");        
            System.out.println("Digite sua opção:\n\n1- Encriptar um texto\n2- Decriptar um texto\n3- Sair\n");
            op = in.nextInt();
        
            if (op == 1) {
                System.out.println("Digite uma frase a ser encriptada:");
                plainText = text.nextLine();
                System.out.println("Frase lida: '"+plainText+"'");
                
                ciphedText = ColumnarTransposition.encrypt(key, plainText);
                System.out.println("Frase encriptada: '"+ciphedText+"'");
            }
            
        
            if (op == 2) {
                System.out.println("Digite uma frase a ser decriptada:");
                ciphedText = text.nextLine();
                System.out.println("Frase lida: '"+ciphedText+"'");
                
                deciphedText = ColumnarTransposition.decrypt(key, ciphedText);
                System.out.println("Frase decriptada: '"+deciphedText+"'");
            }

        }
    }
    
}
