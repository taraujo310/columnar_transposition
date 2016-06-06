/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transposition;

import java.util.Arrays;

public class ColumnarTransposition {
    public static String encrypt(String key, String plainText) {
        String cleanText = getCleanText(plainText, key.length());
        char matrix[][] = getEncryptMatrix(key, cleanText);
        
        return getEncryptedText(matrix, key);
    }
    
    public static String decrypt(String key, String cryptedText) {
        char matrix[][] = getDecryptMatrix(key, cryptedText);
        return getDecryptedText(matrix, key);
    }
    
    public static void printMatrix(char[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println("");
        }
    }
    
    public static char[][] getEncryptMatrix(String key, String text) {
        int columns = key.length();
        int lines = lines(text, columns);
        char matrix[][] = new char[lines][columns];
        
        for (int i = 0; i < text.length(); i++) {
            int line = (int) i/columns;
            int offset = (i%columns);
            matrix[line][offset] = text.charAt(i);
        }
        
        return matrix;
    }
    
    public static char[][] getDecryptMatrix(String key, String text) {
        String sortedKey = getSortedKey(key);
        int columns = key.length();
        int lines = lines(text, columns);
        char matrix[][] = new char[lines][columns];
        
        for (int i = 0; i < columns; i++) {
            char index_key = sortedKey.charAt(i);
            int index = key.indexOf(index_key);
            
            for (int j = 0; j < lines; j++) {
                matrix[j][index] = text.charAt((i*lines)+j);
            }
        }
        
        return matrix;
    }
    
    public static String getEncryptedText(char[][] matrix, String key) {
        String sortedKey = getSortedKey(key);
        String text = "";
        
        for (int j = 0; j < sortedKey.length(); j++) {
            char index_key = sortedKey.charAt(j);
            int index = key.indexOf(index_key);
            
            for (int i = 0; i < matrix.length; i++) {
                text += matrix[i][index];
            }
        }
        
        return text;
    }
    
    public static String getDecryptedText(char[][] matrix, String key) {
        String text = "";
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                text += matrix[i][j];
            }
        }
        
        return text;
    }
    
    public static String getCleanText(String text, int keySize) {
       
       text = text.replaceAll("[ÂÀÁÄÃ]", "A");
       text = text.replaceAll("[âãàáä]", "a");
       text = text.replaceAll("[ÊÈÉË]", "E");
       text = text.replaceAll("[êèéë]", "e");
       text = text.replaceAll("[ÎÍÌÏ]", "I");
       text = text.replaceAll("[îíìï]", "i");
       text = text.replaceAll("[ÔÕÒÓÖ]", "O");
       text = text.replaceAll("[ôõòóö]", "o");
       text = text.replaceAll("[ÛÙÚÜ]", "U");
       text = text.replaceAll("[ûúùü]", "u");
       text = text.replaceAll("Ç", "C");
       text = text.replaceAll("ç", "c");
       text = text.replaceAll("[ýÿ]", "y");
       text = text.replaceAll("Ý", "Y");
       text = text.replaceAll("ñ", "n");
       text = text.replaceAll("Ñ", "N");
       text = text.replaceAll("[-+=*&;%$#@!_]", "");
       text = text.replaceAll("['\"]", "");
       text = text.replaceAll("[<>()\\{\\}]", "");
       text = text.replaceAll("['\\\\.,()|/]", "");
       text = text.replaceAll("[^!-ÿ]{1}[^ -ÿ]{0,}[^!-ÿ]{1}|[^!-ÿ]{1}", " ");
       //text = text.replaceAll(" ", "");
       text = text.toUpperCase();
       
       int textDivision = text.length()%keySize;
       if (textDivision != 0) {
           int complete = keySize - textDivision;
           for (int i = 0; i < complete; i++) {
               text += getNextChar("A", i);
           }
       }
       
       return text;
    }
    
    public static int lines(String text, int columns) {
        float lines = (float) text.length()/columns;
        int lines_count = (int)Math.ceil(lines);
        
        return lines_count;
    }
    
    public static String getSortedKey(String key) {
        char[] sortedKey = key.toCharArray();
        Arrays.sort(sortedKey);
        
        return new String(sortedKey);
    }
    
    public static String getNextChar(String value, int offset) {
        int charValue = value.charAt(0);
        String next = String.valueOf( (char) (charValue + offset));
        
        return next;
    }
}
