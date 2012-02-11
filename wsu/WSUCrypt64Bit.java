package wsu;

public class WSUCrypt64Bit {

	/**
	 * @param args
	 */

	
	static int Ftable[][] = {{0xa3, 0xd7, 0x09, 0x83, 0xf8, 0x48, 0xf6, 0xf4,0xb3, 0x21, 0x15, 0x78, 0x99, 0xb1, 0xaf, 0xf9},
							{0xe7, 0x2d, 0x4d,0x8a, 0xce, 0x4c, 0xca, 0x2e, 0x52, 0x95, 0xd9, 0x1e, 0x4e, 0x38,0x44, 0x28},
							{0x0a, 0xdf, 0x02, 0xa0, 0x17, 0xf1, 0x60, 0x68, 0x12,0xb7, 0x7a, 0xc3, 0xe9, 0xfa, 0x3d, 0x53},
							{0x96, 0x84, 0x6b, 0xba,0xf2, 0x63, 0x9a, 0x19, 0x7c, 0xae, 0xe5, 0xf5, 0xf7, 0x16, 0x6a,0xa2},
							{0x39, 0xb6, 0x7b, 0x0f, 0xc1, 0x93, 0x81, 0x1b, 0xee, 0xb4,0x1a, 0xea, 0xd0, 0x91, 0x2f, 0xb8},
							{0x55, 0xb9, 0xda, 0x85, 0x3f,0x41, 0xbf, 0xe0, 0x5a, 0x58, 0x80, 0x5f, 0x66, 0x0b, 0xd8, 0x90},
							{0x35, 0xd5, 0xc0, 0xa7, 0x33, 0x06, 0x65, 0x69, 0x45, 0x00, 0x94,0x56, 0x6d, 0x98, 0x9b, 0x76},
							{0x97, 0xfc, 0xb2, 0xc2, 0xb0, 0xfe,0xdb, 0x20, 0xe1, 0xeb, 0xd6, 0xe4, 0xdd, 0x47, 0x4a, 0x1d},
							{0x42,0xed, 0x9e, 0x6e, 0x49, 0x3c, 0xcd, 0x43, 0x27, 0xd2, 0x07, 0xd4,	0xde, 0xc7, 0x67, 0x18},
							{0x89, 0xcb, 0x30, 0x1f, 0x8d, 0xc6, 0x8f,0xaa, 0xc8, 0x74, 0xdc, 0xc9, 0x5d, 0x5c, 0x31, 0xa4},
							{0x70, 0x88,0x61, 0x2c, 0x9f, 0x0d, 0x2b, 0x87, 0x50, 0x82, 0x54, 0x64, 0x26,0x7d, 0x03, 0x40},
							{0x34, 0x4b, 0x1c, 0x73, 0xd1, 0xc4, 0xfd, 0x3b,0xcc, 0xfb, 0x7f, 0xab, 0xe6, 0x3e, 0x5b, 0xa5},
							{0xad, 0x04, 0x23,0x9c, 0x14, 0x51, 0x22, 0xf0, 0x29, 0x79, 0x71, 0x7e, 0xff, 0x8c,	0x0e, 0xe2},
							{0x0c, 0xef, 0xbc, 0x72, 0x75, 0x6f, 0x37, 0xa1, 0xec,0xd3, 0x8e, 0x62, 0x8b, 0x86, 0x10, 0xe8},
							{0x08, 0x77, 0x11, 0xbe,0x92, 0x4f, 0x24, 0xc5, 0x32, 0x36, 0x9d, 0xcf, 0xf3, 0xa6, 0xbb, 0xac},
							{0x5e, 0x6c, 0xa9, 0x13, 0x57, 0x25, 0xb5, 0xe3, 0xbd, 0xa8,0x3a, 0x01, 0x05, 0x59, 0x2a, 0x46}};

	public static void main(String[] args) {
		String files[] = WSUCryptHelper.READ_FILES();
		
		String PLAIN_TEXT_FILE = files[0];
		String KEY_TEXT = files[1];		
		String PLAIN_TEXT[] = PLAIN_TEXT_FILE.split("(?<=\\G.{8})");
		String CIPHER_TEXT[] = new String[PLAIN_TEXT.length];
		String DECIPHER_TEXT[] = new String[PLAIN_TEXT.length];
		
		
		for(int i=0;i<PLAIN_TEXT.length;i++){
		CIPHER_TEXT[i] = WSU_ENCRYPTION(PLAIN_TEXT[i], KEY_TEXT);		
				
		
		DECIPHER_TEXT[i] = WSU_DECRYPTION(CIPHER_TEXT[i], KEY_TEXT);		
		
		}
	//	System.out.println("***************");
	//	System.out.println("Cipher Text:");
	//	System.out.println("***************");
		for(int i=0;i<PLAIN_TEXT.length;i++){
		//	System.out.print(CIPHER_TEXT[i]);				
		}
		System.out.println("");
		System.out.println("***************");
		System.out.println("Decipher Text:");
		System.out.println("***************");
		for(int i=0;i<PLAIN_TEXT.length;i++){
			System.out.print(DECIPHER_TEXT[i]);				
		}
		
		
		
		
	}

	

	public static String WSU_ENCRYPTION(String PLAIN_TEXT,String KEY_TEXT) {
		
		System.out.println("**********************");
		System.out.println("Encryption Begins:");
		System.out.println("**********************");
		
		String binaryPlnTxt = WSUCryptHelper.AsciiToBinary(PLAIN_TEXT);
//		System.out.println("Binary Plaint String:"+binaryPlnTxt);
		
		for (int k = 0; k < 64; k++) {
			if (binaryPlnTxt.length() < 64) {
				binaryPlnTxt = "0".concat(binaryPlnTxt);
			}
		}
//		System.out.println("After padding:"+binaryPlnTxt);
		String binaryKeyTxt = WSUCryptHelper.AsciiToBinary(KEY_TEXT);
		for (int k = 0; k < 64; k++) {
			if (binaryKeyTxt.length() < 64) {
				binaryKeyTxt = "0".concat(binaryKeyTxt);
			}
		}
		
		String[] W = binaryPlnTxt.split("(?<=\\G.{16})");		
		String[] K = binaryKeyTxt.split("(?<=\\G.{16})");		
		/**
		 * Input Whitening step
		 */

		
		String[] R = new String[4];
		
		R[0] = WSUCryptHelper.XOR_STRINGS(W[0], K[0]);
		R[1] = WSUCryptHelper.XOR_STRINGS(W[1], K[1]);
		R[2] = WSUCryptHelper.XOR_STRINGS(W[2], K[2]);
		R[3] = WSUCryptHelper.XOR_STRINGS(W[3], K[3]);
		
		
		String r0 = WSUCryptHelper.stringToHex(R[0]);
		String r1 = WSUCryptHelper.stringToHex(R[1]);
		String r2 = WSUCryptHelper.stringToHex(R[2]);
		String r3 = WSUCryptHelper.stringToHex(R[3]);
//		System.out.println("***********************");
//		System.out.println("After Whitening:"+r0+r1+r2+r3);
//		System.out.println("***********************");

		/**
		 * Encryption
		 */
		
		String subKeys[] = WSUCryptHelper.Enc_KeySched_KX(binaryKeyTxt);

		int round = 0;
		for (int i = 0; i < 16; i++) {
			/**
			 * F Function method Input: R0, R1, round number Output: F0, F1
			 */
			
	//		  System.out.println("*****************");
	//		  System.out.println("RoundNo:"+round);
	//		  System.out.println("*****************");
			

			String tempR0 = null;
			String tempR1 = null;
			String R3_Prime = null;

			String F[] = F_Function(R[0], R[1], round, subKeys);

			for (int k = 0; k < 16; k++) {
				if (F[0].length() != 16) {
					F[0] = "0".concat(F[0]);
				}
			}
			for (int k = 0; k < 16; k++) {
				if (F[1].length() != 16) {
					F[1] = "0".concat(F[1]);
				}
			}
			
			tempR0 = WSUCryptHelper.XOR_STRINGS(R[2], F[0]);
			for (int k = 0; k < 16; k++) {
				if (tempR0.length() != 16) {
					tempR0 = "0".concat(tempR0);
				}
			}

			tempR0 = Character.toString(tempR0.charAt(tempR0.length() - 1))
					.concat(tempR0);
			tempR0 = WSUCryptHelper.removeCharAt(tempR0, tempR0.length() - 1);

			R3_Prime = R[3].concat(Character.toString(R[3].charAt(0)));
			R3_Prime = WSUCryptHelper.removeCharAt(R3_Prime, 0);
			tempR1 = WSUCryptHelper.XOR_STRINGS(R3_Prime, F[1]);
			for (int k = 0; k < 16; k++) {
				if (tempR1.length() != 16) {
					tempR1 = "0".concat(tempR1);
				}
			}

			R[2] = R[0];
			R[3] = R[1];
			R[0] = tempR0;
			R[1] = tempR1;

			round++;
		}
		String R_Concat = R[2].concat(R[3]).concat(R[0]).concat(R[1]);
		String[] Y = R_Concat.split("(?<=\\G.{16})");
		
		
		
		
		String[] Cipher_Text = new String[4];
		Cipher_Text[0] = WSUCryptHelper.XOR_STRINGS(R[2], K[0]);
		Cipher_Text[1] = WSUCryptHelper.XOR_STRINGS(R[3], K[1]);
		Cipher_Text[2] = WSUCryptHelper.XOR_STRINGS(R[0], K[2]);
		Cipher_Text[3] = WSUCryptHelper.XOR_STRINGS(R[1], K[3]);
		// Uncomment this line to see hex value of encryption
	//	System.out.println("Encryption Hex Value:"+WSUCryptHelper.stringToHex(Cipher_Text[0])+WSUCryptHelper.stringToHex(Cipher_Text[1])+
	//			WSUCryptHelper.stringToHex(Cipher_Text[2])+WSUCryptHelper.stringToHex(Cipher_Text[3]));
		
//		for(int i=0;i<Cipher_Text.length;i++){
//			System.out.println(Cipher_Text[i]);
//		}
		
		String[] Enc_Ascii_Value = new String[8];
		Enc_Ascii_Value[0] = Character.toString((char)Integer.parseInt(Cipher_Text[0].substring(0, 8),2));
		Enc_Ascii_Value[1] = Character.toString((char)Integer.parseInt(Cipher_Text[0].substring(8, 16),2));
		Enc_Ascii_Value[2] = Character.toString((char)Integer.parseInt(Cipher_Text[1].substring(0, 8),2));
		Enc_Ascii_Value[3] = Character.toString((char)Integer.parseInt(Cipher_Text[1].substring(8, 16),2));
		Enc_Ascii_Value[4] = Character.toString((char)Integer.parseInt(Cipher_Text[2].substring(0, 8),2));
		Enc_Ascii_Value[5] = Character.toString((char)Integer.parseInt(Cipher_Text[2].substring(8, 16),2));
		Enc_Ascii_Value[6] = Character.toString((char)Integer.parseInt(Cipher_Text[3].substring(0, 8),2));
		Enc_Ascii_Value[7] = Character.toString((char)Integer.parseInt(Cipher_Text[3].substring(8, 16),2));
	
		
		return Enc_Ascii_Value[0]+Enc_Ascii_Value[1]+Enc_Ascii_Value[2]+Enc_Ascii_Value[3]+
		Enc_Ascii_Value[4]+Enc_Ascii_Value[5]+Enc_Ascii_Value[6]+Enc_Ascii_Value[7];
				
		
		

	}

	public static String WSU_DECRYPTION(String CIPHER_TEXT,String KEY_TEXT) {
		
		/**
		 * Decryption
		 */
		
		String binaryKeyTxt = WSUCryptHelper.AsciiToBinary(KEY_TEXT);
		for (int k = 0; k < 64; k++) {
			if (binaryKeyTxt.length() != 64) {
				binaryKeyTxt = "0".concat(binaryKeyTxt);
			}
		}
		
		String binaryCprTxt = WSUCryptHelper.AsciiToBinary(CIPHER_TEXT);
		for (int k = 0; k < 64; k++) {
			if (binaryCprTxt.length() != 64) {
				binaryCprTxt = "0".concat(binaryCprTxt);
			}
		}
		
		

		System.out.println("**********************");
		System.out.println("Decryption Begins:");
		System.out.println("**********************");
		
		
		
		
		
		String[] W = binaryCprTxt.split("(?<=\\G.{16})");

		/**
		 * Convert Key hex value to Key Binary Number
		 */

		
		String[] K = binaryKeyTxt.split("(?<=\\G.{16})");

		

		/**
		 * Input Whitening step
		 */
		String R[] = new String[4];	
		R[0] = WSUCryptHelper.XOR_STRINGS(W[0], K[0]);
		R[1] = WSUCryptHelper.XOR_STRINGS(W[1], K[1]);
		R[2] = WSUCryptHelper.XOR_STRINGS(W[2], K[2]);
		R[3] = WSUCryptHelper.XOR_STRINGS(W[3], K[3]);

		String r0 = WSUCryptHelper.stringToHex(R[0]);
		String r1 = WSUCryptHelper.stringToHex(R[1]);
		String r2 = WSUCryptHelper.stringToHex(R[2]);
		String r3 = WSUCryptHelper.stringToHex(R[3]);
	//	System.out.println("After Whitening:"+r0+r1+r2+r3);

		
		String subKeys[] = WSUCryptHelper.Dec_KeySched_KX(binaryKeyTxt);

		int round = 0;
		for (int i = 0; i < 16; i++) {
			/**
			 * F Function method Input: R0, R1, round number Output: F0, F1
			 */
			
			/*  System.out.println("*****************");
			  System.out.println("RoundNo:"+round);
			  System.out.println("*****************"); */
			 

			String tempR0 = null;
			String tempR1 = null;
			String R3_Prime = null;

			String F[] = F_Function(R[0], R[1], round, subKeys);

			for (int k = 0; k < 16; k++) {
				if (F[0].length() != 16) {
					F[0] = "0".concat(F[0]);
				}
			}
			for (int k = 0; k < 16; k++) {
				if (F[1].length() != 16) {
					F[1] = "0".concat(F[1]);
				}
			}

			tempR0 = R[2].concat(Character.toString(R[2].charAt(0)));
			tempR0 = WSUCryptHelper.removeCharAt(tempR0, 0);
			tempR0 = WSUCryptHelper.XOR_STRINGS(tempR0, F[0]);
			for (int k = 0; k < 16; k++) {
				if (tempR0.length() != 16) {
					tempR0 = "0".concat(tempR0);
				}
			}

			tempR1 = WSUCryptHelper.XOR_STRINGS(R[3], F[1]);
			for (int k = 0; k < 16; k++) {
				if (tempR1.length() != 16) {
					tempR1 = "0".concat(tempR1);
				}
			}
			tempR1 = Character.toString(tempR1.charAt(tempR1.length() - 1))
					.concat(tempR1);
			tempR1 = WSUCryptHelper.removeCharAt(tempR1, tempR1.length() - 1);

			R[2] = R[0];
			R[3] = R[1];
			R[0] = tempR0;
			R[1] = tempR1;

			round++;
		}
	
		String[] Decipher_Text = new String[4];
		Decipher_Text[0] = WSUCryptHelper.XOR_STRINGS(R[2], K[0]);
		Decipher_Text[1] = WSUCryptHelper.XOR_STRINGS(R[3], K[1]);
		Decipher_Text[2] = WSUCryptHelper.XOR_STRINGS(R[0], K[2]);
		Decipher_Text[3] = WSUCryptHelper.XOR_STRINGS(R[1], K[3]);
		
	//	System.out.println("Decryption Hex Value:"+WSUCryptHelper.stringToHex(Decipher_Text[0])+WSUCryptHelper.stringToHex(Decipher_Text[1])+
	//			WSUCryptHelper.stringToHex(Decipher_Text[2])+WSUCryptHelper.stringToHex(Decipher_Text[3]));
		String[] Dec_Ascii_Value = new String[8];
		Dec_Ascii_Value[0] = Character.toString((char)Integer.parseInt(Decipher_Text[0].substring(0, 8),2));
		Dec_Ascii_Value[1] = Character.toString((char)Integer.parseInt(Decipher_Text[0].substring(8, 16),2));
		Dec_Ascii_Value[2] = Character.toString((char)Integer.parseInt(Decipher_Text[1].substring(0, 8),2));
		Dec_Ascii_Value[3] = Character.toString((char)Integer.parseInt(Decipher_Text[1].substring(8, 16),2));
		Dec_Ascii_Value[4] = Character.toString((char)Integer.parseInt(Decipher_Text[2].substring(0, 8),2));
		Dec_Ascii_Value[5] = Character.toString((char)Integer.parseInt(Decipher_Text[2].substring(8, 16),2));
		Dec_Ascii_Value[6] = Character.toString((char)Integer.parseInt(Decipher_Text[3].substring(0, 8),2));
		Dec_Ascii_Value[7] = Character.toString((char)Integer.parseInt(Decipher_Text[3].substring(8, 16),2));
	
		return WSUCryptHelper.stringToHex(Decipher_Text[0])+WSUCryptHelper.stringToHex(Decipher_Text[1])+
		WSUCryptHelper.stringToHex(Decipher_Text[2])+WSUCryptHelper.stringToHex(Decipher_Text[3]);		
	

	}
	public static String[] F_Function(String R0, String R1, int round,
			String[] subKeys) {

		String T[] = new String[2];
		String F[] = new String[2];

		T[0] = G_Permutation(R0, round, subKeys[((round) * 12)],
				subKeys[((round) * 12 + 1)], subKeys[((round) * 12 + 2)],
				subKeys[((round) * 12 + 3)]);
		T[1] = G_Permutation(R1, round, subKeys[((round) * 12 + 4)],
				subKeys[((round) * 12 + 5)], subKeys[((round) * 12 + 6)],
				subKeys[((round) * 12 + 7)]);

		String t0 = WSUCryptHelper.stringToHex(T[0]);
		String t1 = WSUCryptHelper.stringToHex(T[1]);
//		System.out.println("T[0]:"+t0);
//		System.out.println("T[1]:"+t1);

		int T0_Decimal = Integer.parseInt(T[0], 2);
		int T1_Decimal = Integer.parseInt(T[1], 2);
		int subK_Value1 = Integer.parseInt((subKeys[((round) * 12 + 8)]
				.concat(subKeys[((round) * 12 + 9)])), 2);
		int SUM_1 = T0_Decimal + (2 * T1_Decimal) + subK_Value1;
		int F0 = (int) (SUM_1 % (Math.pow(2, 16)));
		F[0] = Integer.toBinaryString(F0);
		for(int i=0;i<16;i++){
			if(F[0].length()<16){
				F[0] = "0".concat(F[0]);
			}
		}

		String f0 = WSUCryptHelper.stringToHex(F[0]);
//		 System.out.println("F[0]:"+f0);

		int subK_Value2 = Integer.parseInt((subKeys[((round) * 12 + 10)]
				.concat(subKeys[((round) * 12 + 11)])), 2);
		int SUM_2 = (2 * T0_Decimal) + T1_Decimal + subK_Value2;
		int F1 = (int) (SUM_2 % (Math.pow(2, 16)));
		F[1] = Integer.toBinaryString(F1);
		for(int i=0;i<16;i++){
			if(F[1].length()<16){
				F[1] = "0".concat(F[1]);
			}
		}
		
		String f1 = WSUCryptHelper.stringToHex(F[1]);
//		System.out.println("F[1]:"+f1);

		return F;

	}

	

	public static String G_Permutation(String W, int round, String GK1,
			String GK2, String GK3, String GK4) {

		String[] G = new String[7];
		for (int k = 0; k < 16; k++) {
			if (W.length() != 16) {
				W = "0".concat(W);
			}
		}

	//	System.out.println("W's Length########:"+W.length());

		G[1] = W.substring(0, 8);
		G[2] = W.substring(8, 16);
	//	System.out.println("G[1]:"+WSUCryptHelper.WSUCryptHelper.stringToHex(G[1]));
	//	System.out.println("G[2]:"+WSUCryptHelper.WSUCryptHelper.stringToHex(G[2]));
		String G2GK1 = WSUCryptHelper.XOR_STRINGS(G[2], GK1);
		String G2GK1_F = Integer.toBinaryString(Ftable[Integer.parseInt(
				G2GK1.substring(0, 4), 2)][Integer.parseInt(
				G2GK1.substring(4, 8), 2)]);
		for (int k = 0; k < 8; k++) {
			if (G2GK1_F.length() != 8) {
				G2GK1_F = "0".concat(G2GK1_F);
			}
		}
		G[3] = WSUCryptHelper.XOR_STRINGS(G2GK1_F, G[1]);
	//	 System.out.println("G[3]:"+WSUCryptHelper.WSUCryptHelper.stringToHex(G[3]));

		String G3GK2 = WSUCryptHelper.XOR_STRINGS(G[3], GK2);
		String G3GK2_F = Integer.toBinaryString(Ftable[Integer.parseInt(
				G3GK2.substring(0, 4), 2)][Integer.parseInt(
				G3GK2.substring(4, 8), 2)]);
		for (int k = 0; k < 8; k++) {
			if (G3GK2_F.length() != 8) {
				G3GK2_F = "0".concat(G3GK2_F);
			}
		}
		G[4] = WSUCryptHelper.XOR_STRINGS(G3GK2_F, G[2]);
	//	System.out.println("G[4]:"+WSUCryptHelper.WSUCryptHelper.stringToHex(G[4]));

		String G4GK3 = WSUCryptHelper.XOR_STRINGS(G[4], GK3);
		String G4GK3_F = Integer.toBinaryString(Ftable[Integer.parseInt(
				G4GK3.substring(0, 4), 2)][Integer.parseInt(
				G4GK3.substring(4, 8), 2)]);
		for (int k = 0; k < 8; k++) {
			if (G4GK3_F.length() != 8) {
				G4GK3_F = "0".concat(G4GK3_F);
			}
		}
		G[5] = WSUCryptHelper.XOR_STRINGS(G4GK3_F, G[3]);
	//	System.out.println("G[5]:"+WSUCryptHelper.stringToHex(G[5]));

		String G5GK4 = WSUCryptHelper.XOR_STRINGS(G[5], GK4);
		String G5GK4_F = Integer.toBinaryString(Ftable[Integer.parseInt(
				G5GK4.substring(0, 4), 2)][Integer.parseInt(
				G5GK4.substring(4, 8), 2)]);
		for (int k = 0; k < 8; k++) {
			if (G5GK4_F.length() != 8) {
				G5GK4_F = "0".concat(G5GK4_F);
			}
		}
		G[6] = WSUCryptHelper.XOR_STRINGS(G5GK4_F, G[4]);
	//	 System.out.println("G[6]:"+WSUCryptHelper.stringToHex(G[6]));		

		return (G[5].concat(G[6]));
	}

}
