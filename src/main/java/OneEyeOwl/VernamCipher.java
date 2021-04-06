package OneEyeOwl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.IntStream;

public class VernamCipher {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // Run-Time insertion

    public static void main(String[] args) {

        Integer[] randomKeys = new Integer[]{6, 5, 1, 4, 3, 2, 1, 11, 4, 9, 8, 5}; // keys list provided by sir.
        HashMap<Character, Integer> alphabetsMap = new HashMap<>();
        generateIndexValueMapping(alphabetsMap); // calling method for storing value reference against each character.

        System.out.print("Enter your Message = ");
        String senderMessage = null;
        try {
            senderMessage = reader.readLine();

            while (!isAlphabetString(senderMessage)) {  // method check for inserting only non-numeric
                System.out.print("Only alphabets are allowed , try again = ");
                senderMessage = reader.readLine();
            }
            senderMessage = senderMessage.toUpperCase(); // converting message into capital.
            reader.close();     //Closes the stream and releases any system resources
        } catch (IOException e) {
            e.printStackTrace();
        }

        OneEyeOwl.SenderEncryption senderEncryption = new OneEyeOwl.SenderEncryption(senderMessage, randomKeys);
        String encryption = senderEncryption.encryption(alphabetsMap);
        System.out.println("encryption = " + encryption);

        OneEyeOwl.ReceiveDecryption decryption = new OneEyeOwl.ReceiveDecryption(encryption, randomKeys);
        decryption.decryption(alphabetsMap);

    }

    private static void generateIndexValueMapping(HashMap<Character, Integer> mapping) {

        String textCap = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        // translating text String to 7 bit ASCII encoding
        byte[] textCapBytes = textCap.getBytes(StandardCharsets.US_ASCII);
        System.out.println("----------");
        IntStream.iterate(0, i -> i + 1).limit(textCap.length()).forEach(value -> {
            mapping.put(textCap.charAt(value), (int) textCapBytes[value]);
//            mapping.put(textCap.charAt(value), value +1);
            System.out.printf("| %s | %d |\n" , textCap.charAt(value) , (int) textCapBytes[value]);
        });
        System.out.println("----------");
    }

    public static boolean isAlphabetString(String message) {
        return message != null && message.matches("^[a-zA-Z]*$");
    }






}
