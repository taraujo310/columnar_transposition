package chipher2;

import Transposition.ColumnarTransposition;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

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
                
                System.out.println("\nDigite uma chave secreta:");
                key = text.nextLine();
                System.out.println("Chave lida: '"+key+"'");
                key = cleanKey(key);
                System.out.println("Chave limpa: '"+key+"'");
                ciphedText = ColumnarTransposition.encrypt(key, plainText);
                System.out.println("Frase encriptada: '"+ciphedText+"'");
            }
            
        
            if (op == 2) {
                System.out.println("Digite uma frase a ser decriptada:");
                ciphedText = text.nextLine();
                System.out.println("Frase lida: '"+ciphedText+"'");

                System.out.println("\nDigite uma chave secreta:");
                key = text.nextLine();
                System.out.println("Chave lida: '"+key+"'");

                deciphedText = ColumnarTransposition.decrypt(key, ciphedText);
                System.out.println("Frase decriptada: '"+deciphedText+"'");
            }

        }
    }

    private static String cleanKey(String str) {
        String key = "";
        
        key = str.replaceAll("\\s+","");
        
        char[] chars = key.toCharArray();
        Set<Character> charSet = new LinkedHashSet<>();
        for (char c : chars) {
            charSet.add(c);
        }

        StringBuilder sb = new StringBuilder();
        charSet.stream().forEach((character) -> {
            sb.append(character);
        });
        
        return sb.toString();
    }
    
}
