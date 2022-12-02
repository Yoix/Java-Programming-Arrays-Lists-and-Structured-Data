package onekey;

public class CaesarCipher {
    public static void main(String[] args) {
        CaesarCipher cc = new CaesarCipher(20);
        cc.testEncrypt();
    }
    private String alphabet;
    private String shiftedAlphabet;
    private int mainKey;
    public CaesarCipher(int key){
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
        mainKey = key;

    }
    public String encrypt(String input){
        StringBuilder sb = new StringBuilder(input);
        String alphaLower = alphabet.toLowerCase();
        String shiftLower = shiftedAlphabet.toLowerCase();
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            int index = alphabet.indexOf(c);
            int indexLower = alphaLower.indexOf(c);
            if(Character.isLowerCase(c)){
                if(indexLower != -1) {
                    c = shiftLower.charAt(indexLower);
                    sb.setCharAt(i, c);
                }
            }
            else {
                if (index != -1){
                    c = shiftedAlphabet.charAt(index);
                    sb.setCharAt(i, c);
                }
            }
        }
        return sb.toString();
    }
    public String decrypt(String input){
        CaesarCipher cc = new CaesarCipher(26 - mainKey);
        return cc.encrypt(input);
    }
    public void testEncrypt(){
        String message = "Can you imagine life WITHOUT the internet AND computers in your pocket?";
        String encryptedMessage = encrypt(message);
        System.out.println("The encrypted message is:\n" + encryptedMessage);
        System.out.println("The decrypted message is:\n" + decrypt(encryptedMessage));

    }

}
