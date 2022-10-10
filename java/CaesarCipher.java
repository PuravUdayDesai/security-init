import java.util.Scanner;
class CaesarCipher {

    private String encrypt(String plainText, int key)
    {
        if(plainText == "" || key <= 0)
        {
            return plainText;
        }
        String cipherText = "";
        for(int i = 0; i < plainText.length(); i++)
        {
            char encryptedChar = plainText.charAt(i);
            encryptedChar -= (Character.isUpperCase(plainText.charAt(i)) ? 'A' : 'a');
            encryptedChar += key;
            encryptedChar %= 26;
            encryptedChar += (Character.isUpperCase(plainText.charAt(i)) ? 'A' : 'a');
            cipherText += "" + encryptedChar;
        }

        return cipherText;
    }

    private String decrypt(String cipherText, int key)
    {
        if(cipherText == "" || key <= 0)
        {
            return cipherText;
        }

        String plainText = "";
        for(int i = 0; i < cipherText.length(); i++)
        {
            char decryptedChar = cipherText.charAt(i);
            decryptedChar -= (Character.isUpperCase(cipherText.charAt(i)) ? 'A' : 'a');
            while(decryptedChar < key)
            {
                decryptedChar += 26;
            }
            decryptedChar -= key;
            decryptedChar %= 26;
            decryptedChar += (Character.isUpperCase(cipherText.charAt(i)) ? 'A' : 'a');
            plainText += "" + decryptedChar;
        }

        return plainText;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Plain Text: ");
        String plainText = scan.next();
        System.out.print("Key: ");
        int key = scan.nextInt();

        CaesarCipher logic = new CaesarCipher();
        String cipherText = logic.encrypt(plainText, key);
        System.out.println("Cipher Text: " + cipherText);
        String decryptedText = logic.decrypt(cipherText, key);
        System.out.println("Decrypted Text: " + decryptedText);

        scan.close();
    }
}