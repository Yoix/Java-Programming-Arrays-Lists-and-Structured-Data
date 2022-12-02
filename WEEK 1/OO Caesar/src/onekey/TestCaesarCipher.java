package onekey;
import edu.duke.*;
public class TestCaesarCipher {
    public static void main(String[] args) {
        simpleTest();
    }

     int[] countLetters(String message){
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
        for (int i = 0; i < message.length(); i++) {
            char ch = Character.toLowerCase(message.charAt(i));
            int index = alphabet.indexOf(ch);
            if (index != -1) {
                counts[index]++;
            }
        }
        return counts;
    }
    public int maxIndex(int[] vals){
        int maxIndex = 0;
        for (int i = 0; i < vals.length; i++) {
            maxIndex = i;
        }
        return maxIndex;
    }
    public static void simpleTest(){
        //FileResource fr = new FileResource();
        String frAsString = "Can you imagine life WITHOUT the internet AND computers in your pocket?";
        CaesarCipher cc = new CaesarCipher(15);

        String fEncrypted = cc.encrypt(frAsString);
        System.out.println("The encrypted message = \n" + fEncrypted);

        String fDecrypted = cc.decrypt(fEncrypted);
        System.out.println("The decrypted message = \n" + fDecrypted);
    }
}
