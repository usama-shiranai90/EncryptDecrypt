package OneEyeOwl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // Run-Time insertion

    public static void main(String[] args) {

        Integer[] randomKeys;

        randomKeys = logistic(10, 3.99, 0.56);


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


        System.out.println("randomKeys = " + Arrays.toString(randomKeys));
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
            System.out.printf("| %s | %d |\n", textCap.charAt(value), (int) textCapBytes[value]);
        });
        System.out.println("----------");
    }

    public static boolean isAlphabetString(String message) {
        return message != null && message.matches("^[a-zA-Z]*$");
    }

    public static Integer[] logistic(int sizeOfArray, double r, double Xn) {

        Integer[] tempArray = new Integer[sizeOfArray];

        double xn_plus1;

        for (int i = 0; i < sizeOfArray; i++) {

            xn_plus1 = ((r * Xn) * (1 - Xn));
            Xn = xn_plus1;
            int p=(int) (Xn * 26) % 256;
            tempArray[i] = p;
        }

        return tempArray;
    }


}
