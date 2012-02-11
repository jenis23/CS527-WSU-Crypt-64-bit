package wsu;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class TestProject1 {

	static int a[];
	static int Ftable[][] = {
			{ 0xa3, 0xd7, 0x09, 0x83, 0xf8, 0x48, 0xf6, 0xf4, 0xb3, 0x21, 0x15,
					0x78, 0x99, 0xb1, 0xaf, 0xf9 },
			{ 0xe7, 0x2d, 0x4d, 0x8a, 0xce, 0x4c, 0xca, 0x2e, 0x52, 0x95, 0xd9,
					0x1e, 0x4e, 0x38, 0x44, 0x28 },
			{ 0x0a, 0xdf, 0x02, 0xa0, 0x17, 0xf1, 0x60, 0x68, 0x12, 0xb7, 0x7a,
					0xc3, 0xe9, 0xfa, 0x3d, 0x53 },
			{ 0x96, 0x84, 0x6b, 0xba, 0xf2, 0x63, 0x9a, 0x19, 0x7c, 0xae, 0xe5,
					0xf5, 0xf7, 0x16, 0x6a, 0xa2 },
			{ 0x39, 0xb6, 0x7b, 0x0f, 0xc1, 0x93, 0x81, 0x1b, 0xee, 0xb4, 0x1a,
					0xea, 0xd0, 0x91, 0x2f, 0xb8 },
			{ 0x55, 0xb9, 0xda, 0x85, 0x3f, 0x41, 0xbf, 0xe0, 0x5a, 0x58, 0x80,
					0x5f, 0x66, 0x0b, 0xd8, 0x90 },
			{ 0x35, 0xd5, 0xc0, 0xa7, 0x33, 0x06, 0x65, 0x69, 0x45, 0x00, 0x94,
					0x56, 0x6d, 0x98, 0x9b, 0x76 },
			{ 0x97, 0xfc, 0xb2, 0xc2, 0xb0, 0xfe, 0xdb, 0x20, 0xe1, 0xeb, 0xd6,
					0xe4, 0xdd, 0x47, 0x4a, 0x1d },
			{ 0x42, 0xed, 0x9e, 0x6e, 0x49, 0x3c, 0xcd, 0x43, 0x27, 0xd2, 0x07,
					0xd4, 0xde, 0xc7, 0x67, 0x18 },
			{ 0x89, 0xcb, 0x30, 0x1f, 0x8d, 0xc6, 0x8f, 0xaa, 0xc8, 0x74, 0xdc,
					0xc9, 0x5d, 0x5c, 0x31, 0xa4 },
			{ 0x70, 0x88, 0x61, 0x2c, 0x9f, 0x0d, 0x2b, 0x87, 0x50, 0x82, 0x54,
					0x64, 0x26, 0x7d, 0x03, 0x40 },
			{ 0x34, 0x4b, 0x1c, 0x73, 0xd1, 0xc4, 0xfd, 0x3b, 0xcc, 0xfb, 0x7f,
					0xab, 0xe6, 0x3e, 0x5b, 0xa5 },
			{ 0xad, 0x04, 0x23, 0x9c, 0x14, 0x51, 0x22, 0xf0, 0x29, 0x79, 0x71,
					0x7e, 0xff, 0x8c, 0x0e, 0xe2 },
			{ 0x0c, 0xef, 0xbc, 0x72, 0x75, 0x6f, 0x37, 0xa1, 0xec, 0xd3, 0x8e,
					0x62, 0x8b, 0x86, 0x10, 0xe8 },
			{ 0x08, 0x77, 0x11, 0xbe, 0x92, 0x4f, 0x24, 0xc5, 0x32, 0x36, 0x9d,
					0xcf, 0xf3, 0xa6, 0xbb, 0xac },
			{ 0x5e, 0x6c, 0xa9, 0x13, 0x57, 0x25, 0xb5, 0xe3, 0xbd, 0xa8, 0x3a,
					0x01, 0x05, 0x59, 0x2a, 0x46 } };

	public static String encodeStringToHex(String sourceText) {
		byte[] rawData = sourceText.getBytes();
		StringBuffer hexText = new StringBuffer();
		String initialHex = null;
		int initHexLength = 0;

		for (int i = 0; i < rawData.length; i++) {
			int positiveValue = rawData[i] & 0x000000FF;
			initialHex = Integer.toHexString(positiveValue);
			initHexLength = initialHex.length();
			while (initHexLength++ < 2) {
				hexText.append("0");
			}
			hexText.append(initialHex);
		}
		return hexText.toString();
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

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/*
		 * String s1="1011", s2="1001"; String s = Integer.toString((int)
		 * (s1.charAt(0) ^ s1.charAt(2))); System.out.println(s); StringBuilder
		 * sb1 = new StringBuilder(); for(int i=0; i<s1.length() &&
		 * i<s2.length();i++){ sb1.append(Integer.toString((int) (s1.charAt(i) ^
		 * s2.charAt(i)))); } String result1 = sb1.toString();
		 * System.out.println("My result:"+result1); String tempR0 = "11000a";
		 * tempR0 =
		 * Character.toString(tempR0.charAt(tempR0.length()-1)).concat(tempR0);
		 * System.out.println(tempR0); tempR0 =
		 * WSUCryptHelper.removeCharAt(tempR0, tempR0.length()-1);
		 * System.out.println(tempR0);
		 * 
		 * String unsignedHex = Integer.toHexString(50); String signedHex =
		 * Integer.toString(15, 16); System.out.println("Hex:"+signedHex); int i
		 * = 0x01; String binary = Integer.toBinaryString(i); binary="00000101";
		 * int len = binary.length(); for(int k=0;k<8;k++){
		 * if(binary.length()!=8){ binary = "0".concat(binary); } }
		 * System.out.println("binary:"+Integer.parseInt(binary));
		 * System.out.println("binary to decimal:"+Integer.parseInt(binary,2));
		 * 
		 * int a[][] = {{0,1,2,3},{2,3,3,4},{3,4,4,5}};
		 * System.out.println(a[1][1]); int G2GK1_F =
		 * (Ftable[Integer.parseInt("0000",2)][Integer.parseInt("0000",2)]);
		 * System.out.println("Ftable Value:"+G2GK1_F);
		 * 
		 * 
		 * int ij = 50; int ijk = (int) (ij % Math.pow(2,16));
		 * System.out.println(ijk );
		 *//**
		 * 0123 00123 12334 23445
		 */
		// WSUCryptHelper.keyScheduleKX("110000011");

		String s = "dangi123";
		byte[] bytes = s.getBytes();
		StringBuilder binary = new StringBuilder();
		for (byte b : bytes) {
			int val = b;
			for (int i = 0; i < 8; i++) {
				binary.append((val & 128) == 0 ? 0 : 1);
				val <<= 1;
			}
			// binary.append(' ');
		}
		System.out.println("'" + s + "' to binary: " + binary);

		System.out.println("Hex to Ascii :::"
				+ convertHexToAscii("123456789abcdef"));

		String s1 = "jenis12345";
		try {
			byte[] utf8Bytes = s1.getBytes("UTF8");
			byte[] defaultBytes = s1.getBytes();

			String roundTrip = new String(utf8Bytes, "UTF8");
			System.out.println("roundTrip = " + roundTrip);
			System.out.println();
			printBytes(utf8Bytes, "utf8Bytes");
			System.out.println();
			printBytes(defaultBytes, "defaultBytes");

			String binString = "11111111";
			int tmp = Integer.parseInt(binString, 2);
			System.out.println("tm:"+tmp);

			String temp = "0110010001100001011011100110011101101001001100010011001000110011";
			String mysTr ="1010101111011001001101111100001111100010110101001110111111110111";
			

			System.out.println("L1:" + temp.length());
			System.out.println("L2:" + mysTr.length());
			System.out.println((char) tmp);
			double decString = toDecimal(binString);
			System.out.println(decString);
			
			// table to convert a nibble to a hex char.
			
			String jenis="01111110";
			System.out.println("Hex:"+encodeStringToHex(jenis));
			
			int s1_int = Integer.parseInt("00001111", 2);		
			String s1_hex = Integer.toHexString(s1_int);
			System.out.println(s1_hex);
			//System.out.println("Hex:"+hexJenis);
			for (int i = 0; i < 192; i++) {
				// int range = (4*((i/12+(i%4))))%8;
				// int range = (8 * (i / 24) + ((i) % 8)) % 16;
				// int key_range = ((24 * (i / 24 + 1) - 1) - i % 24);
				// int key_range = ((12 * (i / 12 + 1) - 1) - i % 12);
				// System.out.println(key_range);
			}
			
			String binary1 = AsciiToBinary("1");
			System.out.println("bin"+binary1);
			
			String[] tmpStr = "1234".split("(?<=\\G.{8})");
			for(int i=0;i<tmpStr.length;i++)
			System.out.println(tmpStr[i]);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

	}

	

	static double toDecimal(String s) {
		int l = s.length();
		double result = 0;

		for (int i = 0; i < l; i++) {
			result = result + s.charAt(i) * Math.pow(2, (s.length() - i - 1));
		}
		return result;
	}

	public String convertHexToString(String hex) {

		StringBuilder sb = new StringBuilder();
		StringBuilder temp = new StringBuilder();

		// 49204c6f7665204a617661 split into two characters 49, 20, 4c...
		for (int i = 0; i < hex.length() - 1; i += 2) {

			// grab the hex in pairs
			String output = hex.substring(i, (i + 2));
			// convert hex to decimal
			int decimal = Integer.parseInt(output, 16);
			// convert the decimal to character
			sb.append((char) decimal);

			temp.append(decimal);
		}
		System.out.println("Decimal : " + temp.toString());

		return sb.toString();
	}

	public static void printBytes(byte[] array, String name) {
		for (int k = 0; k < array.length; k++) {
			System.out.println(name + "[" + k + "] = " + "0x"
					+ UnicodeFormatter.byteToHex(array[k]));
		}
	}

	public static String convertHexToAscii(String hex) {

		StringBuilder sb = new StringBuilder();
		StringBuilder temp = new StringBuilder();

		// 49204c6f7665204a617661 split into two characters 49, 20, 4c...
		for (int i = 0; i < hex.length() - 1; i += 2) {

			// grab the hex in pairs
			String output = hex.substring(i, (i + 2));
			// convert hex to decimal
			int decimal = Integer.parseInt(output, 16);
			// convert the decimal to character
			sb.append((char) decimal);

			temp.append(decimal);
		}
		System.out.println("Decimal : " + temp.toString());

		return sb.toString();
	}

}
