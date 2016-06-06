package chipher2;

import Transposition.ColumnarTransposition;

public class Chipher2 {

    public static void main(String[] args) {
        String plainText = "A gente não se liberta de um hábito atirando-o pela janela: é preciso fazê-lo descer a escada, degrau por degrau.";
        String key = "MarkTwain";
        String ciphedText = ColumnarTransposition.encrypt(key, plainText);
        System.out.println(ciphedText);
        
        String deciphedText = ColumnarTransposition.decrypt(key, ciphedText);
        System.out.println(deciphedText);
    }
    
}
