package OneEyeOwl;

import java.util.*;
import java.util.stream.IntStream;

public class ReceiveDecryption {

    private String encryptedText;
    private final List<Integer> keys;

    public ReceiveDecryption(String encryptedText, Integer[] randomKeys) {

        this.encryptedText = encryptedText;
        keys = new ArrayList<>();
        Collections.addAll(keys, randomKeys);

    }

    public void decryption(HashMap<Character, Integer> mapping) {
        var o = new Object() {
            String decryptedText = "";
            int index = 0;
            boolean cipherFlag = false;
            int num = 0;
        };

        IntStream.iterate(0, v -> v + 1).limit(encryptedText.length()).forEach(valueIndex -> {
            char character = encryptedText.charAt(valueIndex);  // A

            for (Map.Entry<Character, Integer> entrySet : mapping.entrySet()) {

                if (character == entrySet.getKey()) {
                    o.num = ((entrySet.getValue() - keys.get(o.index)   ) % 26) + 65;
                    if (o.index == keys.size() - 1)
                        o.index = 0;
                    else
                        o.index++;
                    o.cipherFlag = true;
                }
            }

            for (Map.Entry<Character, Integer> entry : mapping.entrySet()) {
                if (o.cipherFlag && o.num == entry.getValue()) {
                    char gettingCharFromEntry = entry.getKey();
                    o.decryptedText = o.decryptedText.concat(String.valueOf(gettingCharFromEntry));
                    o.cipherFlag = false;
                }
            }
        });
        String decryption = o.decryptedText;
        System.out.println("decryption = " + decryption);
    }
}
