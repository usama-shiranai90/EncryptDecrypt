package Taqveem;

import java.util.ArrayList;
import java.util.Locale;
import java.util.stream.IntStream;

public class Dic {


    public String decryptionMessage(String ciphertext) {
        int[] key = {6, 5, 1, 4, 3, 2, 1, 11, 4, 9, 8, 5};
        String alphabet = "abcdefghijklmnopqrstuvwxyz".toUpperCase(Locale.ROOT);

        char[] charList = ciphertext.toCharArray();  //
        ArrayList<Character> characterArrayList = new ArrayList<>();  // alphabet set.
        ArrayList<Integer> integerArrayList = new ArrayList<>();  // alphabet value.

        var secondlyReference = new Object() {
            String objectDecrypted = "";
        };


        for (int i = 0; i < alphabet.length(); i++) {
            characterArrayList.add(alphabet.charAt(i));
            integerArrayList.add(i + 1);
        }

        System.out.println("integerArrayList = " + integerArrayList);
        System.out.println("characterArrayList = " + characterArrayList);
        for (int i = 0; i < charList.length; i++) {
            char c = charList[i];
            final int[] encryptedIndex = new int[1];
//            Taqveem.Enc.InnerClass innerClass = new Taqveem.Enc.InnerClass();
            ReferenceClass referenceClass1 = new ReferenceClass();
            referenceClass1.setFinalI(i);


//            integerArrayList.stream().limit(integerArrayList.size() - 1).forEach(integer -> {

            IntStream.iterate(0, v -> v + 1).limit(integerArrayList.size()).forEach(integer -> {

                if (characterArrayList.get(integer) == c) {

                    encryptedIndex[0] = Math.floorMod((integerArrayList.get(integer) - key[referenceClass1.getFinalI()]), 26) -2;
                    System.out.println("key = " + key[referenceClass1.getFinalI()] + "           characterArrayList = " + characterArrayList.get(integer) + "     encryptedIndex[o] = " + encryptedIndex[0] + " , Index = " + integer);

                    if (encryptedIndex[0] == -1){
                        encryptedIndex[0] = 25 ;
                    }

                }

                if (referenceClass1.finalI == key.length - 1) {
                    referenceClass1.finalI = 0;
                }

            });


            IntStream.iterate(0, ix -> ix + 1).limit(integerArrayList.size()).forEach(integer -> {

                if (encryptedIndex[0] == integer) {
                    char character = characterArrayList.get(integer);
//                    System.out.println("characterArrayList = " + characterArrayList.get(integer));
                    referenceClass1.setDecrypted(referenceClass1.getDecrypted().concat(String.valueOf(character)));
                    secondlyReference.objectDecrypted = secondlyReference.objectDecrypted + referenceClass1.getDecrypted();
                }
            });

        }
        return secondlyReference.objectDecrypted;

    }


    private class ReferenceClass {
        int finalI;
        int index;
        String decrypted;

        public String getDecrypted() {
            return decrypted;
        }

        public void setDecrypted(String decrypted) {
            this.decrypted = decrypted;
        }

        public ReferenceClass() {
            decrypted = "";
        }

        public int getFinalI() {
            return finalI;
        }

        public void setFinalI(int finalI) {
            this.finalI = finalI;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }
    }
}
