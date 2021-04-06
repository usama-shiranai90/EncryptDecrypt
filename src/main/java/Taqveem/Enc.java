package Taqveem;

import java.util.ArrayList;
import java.util.Locale;
import java.util.stream.IntStream;

public class Enc {

    public Enc() {

    }
    public String encryptionMessage(String Plaintext) {
        int[] key = {6, 5, 1, 4, 3, 2, 1, 11, 4, 9, 8, 5};
        String setalphabet = "abcdefghijklmnopqrstuvwxyz".toUpperCase(Locale.ROOT);

        char[] charList = Plaintext.toUpperCase().toCharArray();  // a, ,t,ta,ck
        ArrayList<Character> characterArrayList = new ArrayList<Character>();  // alphabet set.
        ArrayList<Integer> integerArrayList = new ArrayList<Integer>();  // alphabet value.
        var ObjectRef = new Object() {
            String objectEncrypted = "";
        };


        for (int i = 0; i < setalphabet.length(); i++) {
            characterArrayList.add(setalphabet.charAt(i));
            integerArrayList.add(i + 1);
        }


        for (int i = 0; i < charList.length; i++) {
            char c = charList[i];
            final int[] encryptedIndex = new int[1];
            InnerClass innerClass = new InnerClass();
            innerClass.setIndex(i);


//            integerArrayList.stream().limit(integerArrayList.size() - 1).forEach(integer -> {

            IntStream.iterate(0, v -> v + 1).limit(integerArrayList.size()).forEach(integer -> {
//                System.out.println("integer = " + integer);
                if (characterArrayList.get(integer) == c) {

                    encryptedIndex[0] = (integerArrayList.get(integer) + key[innerClass.getIndex()]) % 26;
//                    System.out.println();
//                    System.out.print("key = " + key[innerClass.getFinalI()] + "           characterArrayList = " + characterArrayList.get(integer) + "     encryptedIndex[o] = " + encryptedIndex[0] + " , Index = " + integer);

                }

                if (innerClass.Index == key.length - 1) {
                    innerClass.Index = 0;
                }

            });


            IntStream.iterate(0, ix -> ix + 1).limit(integerArrayList.size()).forEach(integer -> {

                if (encryptedIndex[0] == integer) {
                    char character = characterArrayList.get(integer);

//                    System.out.println("characterArrayList = " + characterArrayList.get(integer));
                    innerClass.setEncrypted(innerClass.getEncrypted().concat(String.valueOf(character)));
                    ObjectRef.objectEncrypted = ObjectRef.objectEncrypted + innerClass.getEncrypted();
                }
            });

        }
        return ObjectRef.objectEncrypted;

    }


    private class InnerClass {
        int Index;
        String encrypted;

        public String getEncrypted() {
            return encrypted;
        }

        public void setEncrypted(String encrypted) {
            this.encrypted = encrypted;
        }

        public InnerClass() {
            encrypted = "";
        }

        public int getIndex() {
            return Index;
        }

        public void setIndex(int index) {
            this.Index = index;
        }


    }

}
