package COD;

import java.util.HashMap;
import java.util.Map;

public class Encrpt {
    static String valueToEncrypt = "";
    static String valueToDecrypt = "";

    static int[] randomKeys = {6, 5, 1, 4, 3, 2, 1, 11, 4, 9, 8, 5};

    public static void main(String[] args) {

        String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";


        HashMap<Character, Integer> dictionary = new HashMap<>();

        for (int i = 0; i < alphabets.length(); i++) {
            char c = alphabets.charAt(i);
            dictionary.put(c, i + 1);
        }

        System.out.println("dictionary.toString() = " + dictionary.toString());
        String message = "attack".toUpperCase();

        encryption(message, dictionary);
        System.out.println("valueToEncrypt = " + valueToEncrypt);

        decryption(valueToEncrypt, dictionary);
        System.out.println("valueToDecrypt = " + valueToDecrypt);
    }


    public static void encryption(String message, HashMap<Character, Integer> hashMap) {  // message = ATTACK ;
        int index = 0;
        for (int i = 0; i < message.length(); i++) {
            char charOfMessage = message.charAt(i); // A
            int cipherValue = 0;

            for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {

                if (charOfMessage == entry.getKey()) {  // A == A (1)
                    cipherValue = (entry.getValue() + randomKeys[index]) % 26; // 20 +
                    System.out.println("index = " + index);
                    System.out.println("cipherValue = " + cipherValue);
                    System.out.println("entry. = " + entry.getValue());

                if (index == randomKeys.length - 1) //  0
                    index = 0;
                else
                    index++;
                }
            }

            for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {

                if (entry.getValue() == cipherValue) {
                    char gettingCharFromEntry = entry.getKey();
                    valueToEncrypt = valueToEncrypt.concat(String.valueOf(gettingCharFromEntry));
                    break;
                }
            }
        }
    }


    public static void decryption(String encryption, HashMap<Character, Integer> dic) {
        int index = 0;
        for (int i = 0; i < encryption.length(); i++) {
            char charOfMessage = encryption.charAt(i); // A
            int cipherValue = 0;

            for (Map.Entry<Character, Integer> entry : dic.entrySet()) {

                if (charOfMessage == entry.getKey()) {  // G == G (7)
                    cipherValue = Math.floorMod(entry.getValue() - randomKeys[index], 26); // 20 +
                    if (index == randomKeys.length - 1) //  0
                        index = 0;
                    else
                        index++;
                }

            }

            for (Map.Entry<Character, Integer> entry : dic.entrySet()) {

                if (entry.getValue() == cipherValue) {
                    char gettingCharFromEntry = entry.getKey();
                    valueToDecrypt = valueToDecrypt.concat(String.valueOf(gettingCharFromEntry));
                    break;
                }
            }
        }

    }

}