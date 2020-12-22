import java.io.*;
import java.util.Scanner;

public class Main
{
	public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

	public static String encrypt(String plainText, int shiftKey)
	{
		plainText = plainText.toLowerCase();
		String cipherText = "";
		for (int i = 0; i < plainText.length(); i++)
		{
			int charPosition = ALPHABET.indexOf(plainText.charAt(i));
			int keyVal = (shiftKey + charPosition) % 26;
			char replaceVal = ALPHABET.charAt(keyVal);
			cipherText += replaceVal;
		}
		return cipherText;

	}

	public static String decrypt(String cipherText, int shiftKey)
	{
		cipherText = cipherText.toLowerCase();
		String plainText = "";
		for (int i = 0; i < cipherText.length(); i++)
		{
			int charPosition = ALPHABET.indexOf(cipherText.charAt(i));
			int keyVal = (charPosition - shiftKey) % 26;
			if (keyVal < 0)
			{
				keyVal = ALPHABET.length() + keyVal;
			}
			char replaceVal = ALPHABET.charAt(keyVal);
			plainText += replaceVal;
		}
		return plainText;
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the String for Encryption: ");
		String message = new String();
		message = sc.next();
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Enter the key length: ");
		int key=sc1.nextInt();
		int v = 10;
		
		while(v!=3){
			System.out.println("1.Encryption \n2.Decryption \n3.Quit");
			v = sc.nextInt();
			if(v==1){
				System.out.println(encrypt(message, key));
			}
			else if(v==2){
				System.out.println(decrypt(encrypt(message, key), key));
				
			}
			else if (v == 3){
				System.exit(0);
			}
		}
		
		
		sc.close();
	}
}
