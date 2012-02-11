package wsu;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class WSUCryptHelper {

	public static String[] Enc_KeySched_KX(String binaryKeyTxt) {
		String keyPrime[] = new String[192];
		String splitKeyPrime[] = new String[64];
		String subKeyPrime[] = new String[192];
		
		/**
		 * replace the first and last character of string
		 */

		keyPrime[0] = binaryKeyTxt;
		
		for (int i = 0; i < 192; i++) {
			
			keyPrime[i] = (keyPrime[i].concat(Character.toString(keyPrime[i].charAt(0))));
			keyPrime[i] = removeCharAt(keyPrime[i], 0);
	
			splitKeyPrime = keyPrime[i].split("(?<=\\G.{8})");
			int range = (4*((i)/12)+((i)%4))%8;
	
			subKeyPrime[i] = splitKeyPrime[range];
	
			if (i+1!=192){
			keyPrime[i+1] = keyPrime[i];
			}
		}
	/*	System.out.println("*******************");
		System.out.println("Encryption Subkeys:");
		System.out.println("*******************"); */
		for(int i=0;i<192;i++){		
			String subkey1 = stringToHex(subKeyPrime[i]);
		//	System.out.println(subkey1);
		}
		
		return subKeyPrime;

	}
	
	public static String[] Dec_KeySched_KX(String binaryKeyTxt) {
		String keyPrime[] = new String[192];
		String splitKeyPrime[] = new String[64];
		String subKeyPrime[] = new String[192];

		
		keyPrime[0] = binaryKeyTxt;

		for (int i = 0; i < 192; i++) {
			splitKeyPrime = keyPrime[i].split("(?<=\\G.{8})");
			String temp1 = splitKeyPrime[0];
			String temp2 = splitKeyPrime[1];
			String temp3 = splitKeyPrime[2];
			String temp4 = splitKeyPrime[3];
			String temp5 = splitKeyPrime[4];
			String temp6 = splitKeyPrime[5];
			String temp7 = splitKeyPrime[6];
			String temp8 = splitKeyPrime[7];			
			
			splitKeyPrime[7] = temp1;
			splitKeyPrime[6] = temp2;
			splitKeyPrime[5] = temp3;
			splitKeyPrime[4] = temp4;
			splitKeyPrime[3] = temp5;
			splitKeyPrime[2] = temp6;
			splitKeyPrime[1] = temp7;
			splitKeyPrime[0] = temp8;
			
			

			int range = (4 * (i / 12) + ((i) % 4)) % 8;
			int key_range = ((12 * (i / 12 + 1) - 1) - i % 12);
			
			subKeyPrime[key_range] = splitKeyPrime[range];
			keyPrime[i] = (Character.toString(keyPrime[i].charAt(63)))
					.concat(keyPrime[i]);
			keyPrime[i] = removeCharAt(keyPrime[i], 64);
			if (i + 1 != 192) {
				keyPrime[i + 1] = keyPrime[i];
			}
		}
		
	/*	System.out.println("*******************");
		System.out.println("Decryption Subkeys:");
		System.out.println("*******************"); */
		
		for (int i = 0; i < 192; i++) {
			String subkey = stringToHex(subKeyPrime[i]);
	//		System.out.println(subkey);
		}

		return subKeyPrime;

	}


	public static String removeCharAt(String text, int position) {
		return text.substring(0, position) + text.substring(position + 1);
	}

	

	public static int[] Whitening(String wVal[], String kVal[]) {
		int wIntVal[] = new int[4];
		int kIntVal[] = new int[4];
		int rIntVal[] = new int[4];
		for (int i = 0; i < 4; i++) {
			wIntVal[i] = Integer.parseInt(wVal[i], 2);
		}
		for (int j = 0; j < 4; j++) {
			kIntVal[j] = Integer.parseInt(kVal[j], 2);
		}
		for (int l = 0; l < 4; l++) {
			rIntVal[l] = wIntVal[l] ^ kIntVal[l];
		}
		return rIntVal;
	}

	public static String HexToBinary(String hexString) {
		hexString = hexString.toUpperCase();
		String[] hexArray = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
				"A", "B", "C", "D", "E", "F" };
		String[] binaryArray = { "0000", "0001", "0010", "0011", "0100",
				"0101", "0110", "0111", "1000", "1001", "1010", "1011", "1100",
				"1101", "1110", "1111" };
		String binaryString = "";
		for (int i = 0; i < hexString.length(); i++) {
			char hexChar = hexString.charAt(i);
			String hexCharVer = "" + hexChar + "";
			for (int j = 0; j < hexArray.length; j++) {
				if (hexCharVer.equalsIgnoreCase(hexArray[j])) {
					binaryString = binaryString + binaryArray[j];
				}
			}
		}
		return binaryString;
	}

	public static String BinaryToHex(String binaryString) {
		String[] hexArray1 = { "0", "1", "2", "3", "4", "5", "6", "7", "8",
				"9", "A", "B", "C", "D", "E", "F" };
		String[] binaryArray1 = { "0000", "0001", "0010", "0011", "0100",
				"0101", "0110", "0111", "1000", "1001", "1010", "1011", "1100",
				"1101", "1110", "1111" };
		String HexString = "";

		String[] binArray = binaryString.split("(?<=\\G.{4})");

		for (int i = 0; i < binArray.length; i++) {
			String binChar = binArray[i];
			String binCharVer = "" + binChar + "";
			for (int j = 0; j < binaryArray1.length; j++) {
				if (binCharVer.equalsIgnoreCase(binaryArray1[j])) {
					HexString = HexString + hexArray1[j];
				}
			}

		}
		return HexString;
	}
	
	public static String AsciiToBinary(String asciiString){
		
		  byte[] bytes = asciiString.getBytes();
		  StringBuilder binary = new StringBuilder();
		  for (byte b : bytes)
		  {
		     int tempVal = b;
		     for (int i = 0; i < 8; i++)
		     {
		        binary.append((tempVal & 128) == 0 ? 0 : 1);
		        tempVal <<= 1;
		     }
		    
		  }
		  return binary.toString();
	}
	
	public static String stringToHex(String s1) {
		int length = s1.length();
		int s1_int = Integer.parseInt(s1, 2);	
		
		String s1_hex = Integer.toHexString(s1_int);
		for(int i=0;i<length;i++){
			if(s1_hex.length()!=length/4){
				s1_hex = "0".concat(s1_hex);
			}	
		}
		
		return s1_hex;		
	}
	
	public static String XOR_STRINGS(String s1, String s2) {
		StringBuilder sb1 = new StringBuilder();
		for (int i = 0; i < s1.length() && i < s2.length(); i++) {
			sb1.append(Integer.toString((int) (s1.charAt(i) ^ s2.charAt(i))));
		}
		String xorResult = sb1.toString();	
		return xorResult;
	}
	
	public static String[] READ_FILES() {
		String s[] = null;
		try {

			FileInputStream plainTextFile = new FileInputStream("plaintext.txt");
			FileInputStream keyFile = new FileInputStream("key.txt");

			DataInputStream in1 = new DataInputStream(plainTextFile);
			DataInputStream in2 = new DataInputStream(keyFile);
			BufferedReader br1 = new BufferedReader(new InputStreamReader(in1));
			BufferedReader br2 = new BufferedReader(new InputStreamReader(in2));
			String strLine1;
			String strLine2;
			StringBuilder sb1 = new StringBuilder();
			StringBuilder sb2 = new StringBuilder();

			while ((strLine1 = br1.readLine()) != null) {
				sb1.append(strLine1);				
			}
			while ((strLine2 = br2.readLine()) != null) {
				sb2.append(strLine2);
			}
			s = new String[2];
			s[0] = sb1.toString();
			s[1] = sb2.toString();
			
			in1.close();
			in2.close();
			
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e);
		}
		return s;
		

	}
	
}
