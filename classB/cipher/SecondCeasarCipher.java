package cipher;
import edu.duke.FileResource;

<<<<<<< HEAD
public class SecondCeasarCipher {
	
	private String alphabet;
	private String shiftedAlphabet1;
	private String shiftedAlphabet2;
	private int key1;
	private int key2;
	
	public CaesarCipherTwo(int key1, int key2){
		this.key1 = key1;
		this.key2 = key2;
		alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		shiftedAlphabet1 = alphabet.substring(key1)+alphabet.substring(0,key1);
		shiftedAlphabet2 = alphabet.substring(key2)+alphabet.substring(0,key2);
	}
	
	public String encrypt(String input){
		
		StringBuilder encrypted = new StringBuilder(input);
		
		for(int i = 0; i < encrypted.length(); i++) {	
			Character currChar = encrypted.charAt(i);
			boolean lowerCase = false;
			int idx = -1;
			if(Character.isLowerCase(currChar)){
				lowerCase = true;
				idx = alphabet.indexOf(Character.toUpperCase(currChar));
			} else {
				idx = alphabet.indexOf(currChar);
			}

			if(idx != -1){
				char newChar = 'a';
				if(i %2 == 0){
					newChar = shiftedAlphabet1.charAt(idx);
				} else {
					newChar = shiftedAlphabet2.charAt(idx);
				}
				if(lowerCase){
					newChar = Character.toLowerCase(newChar);
				}            	
				encrypted.setCharAt(i, newChar);
			}    
		}

		return encrypted.toString();
	}
	
	public String decrypt(String input){
		
		CaesarCipherTwo cc = new CaesarCipherTwo(26-key1, 26-key2);
		return cc.encrypt(input);
		
	}
	
=======

public class SecondCeasarCipher {
private int key;
	private String alphabetUp;
	private String alphabetLow;	
	private String shiftedAlphabetUp;
	private String shiftedAlphabetLow;
	
	public SecondCeasarCipher(int key){
		this.key = key;
		alphabetUp = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		alphabetLow = "abcdefghijklmnopqrstuvwxyz";	
		shiftedAlphabetUp = alphabetUp.substring(key) + alphabetUp.substring(0,key);
		shiftedAlphabetLow = alphabetLow.substring(key) + alphabetLow.substring(0,key);
	}
	
	public String encrypt(String input){
		StringBuilder encrypted =  new StringBuilder(input);
		
		for(int i = 0; i < encrypted.length(); i++){
			char currChar = encrypted.charAt(i);
			if(Character.isUpperCase(currChar)){
				int idx = alphabetUp.indexOf(currChar);
				if(idx != -1){
					char newChar = shiftedAlphabetUp.charAt(idx);
					encrypted.setCharAt(i, newChar);
				}
			}else{
				int idx = alphabetLow.indexOf(currChar);
				if(idx != -1){
					char newChar = shiftedAlphabetLow.charAt(idx);
					encrypted.setCharAt(i, newChar);
				}
			}
		}
		return encrypted.toString();
	}
	
	public int getKey(String s){
		int[] freqs = countLetters(s);
		int maxDex = maxIndex(freqs);
		int dkey = maxDex - 4;
		if(dkey < 0){
			dkey = 26 + dkey;
		}
		return dkey;
	}
	
	private int maxIndex(int[] vals) {
		int maxDex = 0;
		for(int k =0; k < vals.length; k++){
			if(vals[k] > vals[maxDex]){
				maxDex = k;
			}
		}
		return maxDex;
	}

	public int[] countLetters(String message){
		String alph = "abcdefghijklmnopqrstuvwxyz";
		int[] counts = new int[26];
		for(int k = 0; k < message.length();k++){
			char ch = Character.toLowerCase(message.charAt(k));
			int dex = alph.indexOf(ch);
			if(dex!=-1){
				counts[dex]+=1;
			}
		}
		return counts;
	}
	
	public String halfOfString(String message, int start){
		String subMsg = "";
		for(int i = start; i < message.length(); i+= 2){
			subMsg = subMsg + message.charAt(i);
		}
		return subMsg;
	}
	
	public String CombineString(String str1, String str2)
	{
		char[] ch = new char[str1.length() + str2.length()];
		for(int i = 0; i < str1.length(); i++){
			ch[i * 2] = str1.charAt(i);
		}
		for(int i = 0; i < str2.length(); i++){
			ch[i * 2 + 1] = str2.charAt(i);
		}
		String str = new String(ch);
		return str;

	}
		
	public static void main(String[] args){
		int key1 = 21;
		int key2 = 8;
		SecondCeasarCipher cc1 = new SecondCeasarCipher(key1);
		SecondCeasarCipher cc2 = new SecondCeasarCipher(key2);
		
		FileResource fr = new FileResource("data/mysteryTwoKeysQuiz.txt");
		String message = fr.asString();
		
		//String message = "Aal uttx hm aal Qtct Fhljha pl Wbdl. Pvxvxlx!.";
		//System.out.println("未处理的信息：" + message);
		//encryption
		String subStr1 = cc1.halfOfString(message, 0);
		String subStr2 = cc1.halfOfString(message, 1);
	
		String encrypted1 = cc1.encrypt(subStr1);
		String encrypted2 = cc2.encrypt(subStr2);
				
		String encrypted = cc1.CombineString(encrypted1,encrypted2);
		System.out.println("hello moto" + encrypted);
		//decryption
		int dKey1 = cc1.getKey(encrypted1);
		int dKey2 = cc2.getKey(encrypted2);
		System.out.println("timmy turner" + dKey1);
		System.out.println(" bobby boy：" + dKey2);

		
//		int dKey1 = 14;
//		int dKey2 = 24;

		SecondCeasarCipher dcc1 = new SecondCeasarCipher(26-dKey1);	
		SecondCeasarCipher dcc2 = new SecondCeasarCipher(26-dKey2);	
//		String encrypted1 = cc1.halfOfString(message, 0);
//		String encrypted2 = cc1.halfOfString(message, 1);

		
		String decrypted1 = dcc1.encrypt(encrypted1);
		String decrypted2 = dcc2.encrypt(encrypted2);
		String decrypted = cc1.CombineString(decrypted1,decrypted2);
		System.out.println("billybob jones:" + decrypted);
	}
>>>>>>> ef3157c5460090a72611074ba76e5f352715771a
}