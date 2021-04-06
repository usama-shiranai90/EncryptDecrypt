package Taqveem;

import java.util.Scanner;

public class taqMain {

    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);
        System.out.println("Enter the text to be encrypted and decrypt : ");
        String text = Input.nextLine().toUpperCase();

        Enc encyrption = new Enc();
        String encryptedMessage = encyrption.encryptionMessage(text);
        Dic dic = new Dic();

        String decryptionMessage = dic.decryptionMessage(encryptedMessage);

        System.out.println("encryptedMessage = " + encryptedMessage);
        System.out.println("decryptionMessage = " + decryptionMessage);
    }
}
