public class CeasarCipher {
    public String encrypt (String input, int key){
    StringBuilder encrypted = new StringBuilder (input);
    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ":
    String shiftedAlphabet = alphabet.subString(key) + alphabet;
    
    for(int i = 0; i < encrypted.length(); i++) {
        char currChar = encrypted.charAt(i) ;
        int index = alphabet.indexOF(currChar);
        if(index > 0){
            char newChar = shiftedAlphabet.charAt(index);
            encrypted.setCharAt(i, newChar); 
            }    
        }
    return encrypted.toString();
    }
    public void testCipher () {
        int key = 17;
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = encrypt(message, key);
        System.out.printIn(encrypted);
        String decrypted = encrypt(encrypted, 26-key);
        System.out.printIn(decrypted);
    }
}