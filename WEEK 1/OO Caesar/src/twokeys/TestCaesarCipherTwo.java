package twokeys;

import edu.duke.FileResource;

public class TestCaesarCipherTwo {
    public static void main(String[] args) {
        simpleTest();
    }
    public static void simpleTest(){
        //FileResource fr = new FileResource();
        String frAsString = "Can you imagine life WITHOUT the internet AND computers in your pocket?";
        CaesarCipherTwo cc = new CaesarCipherTwo(21, 8);

        String fEncrypted = cc.encrypt(frAsString);
        System.out.println("The encrypted message = " + fEncrypted);

        String fDecrypted = cc.decrypt(fEncrypted);
        System.out.println("The decrypted message = " + fDecrypted);
    }

}
