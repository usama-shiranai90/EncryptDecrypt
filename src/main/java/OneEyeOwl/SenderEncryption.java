package OneEyeOwl;

import java.util.*;
import java.util.stream.IntStream;

public class SenderEncryption {


    private String message;
    private List<Integer> keys;

    public SenderEncryption(String message, Integer[] randomKeys) {

        this.message = message;
        keys = new ArrayList<>();
        Collections.addAll(keys, randomKeys);

    }


    public String encryption(HashMap<Character, Integer> mapping) {
        var objectReferences = new Object() {
            String cipherText = "";
            int index = 0;
            boolean cipherFlag = false;
            int number = 0;
        };

        IntStream.iterate(0, v -> v + 1).limit(message.length()).forEach(valueIndex -> {
            char character = message.charAt(valueIndex);  // A

            for (Map.Entry<Character, Integer> entrySet : mapping.entrySet()) {

                if (character == entrySet.getKey()) {
                    objectReferences.number = ((entrySet.getValue() + keys.get(objectReferences.index)) % 26) + 65;
//                    System.out.print("Original Character: " + character + "  , index= " + entrySet.getValue());
                    if (objectReferences.index == keys.size() - 1)
                        objectReferences.index = 0;
                    else
                        objectReferences.index++;

                    objectReferences.cipherFlag = true;
                }
            }

            for (Map.Entry<Character, Integer> entry : mapping.entrySet()) {
                if (objectReferences.cipherFlag && objectReferences.number == entry.getValue()) {
                    char gettingCharFromEntry = entry.getKey();
//                    System.out.println("  Converted Character: " + entry.getKey() + "|");
                    objectReferences.cipherText = objectReferences.cipherText.concat(String.valueOf(gettingCharFromEntry));
                    objectReferences.cipherFlag = false;
                    break;
                }
            }


        });

        return objectReferences.cipherText;

    }


}
