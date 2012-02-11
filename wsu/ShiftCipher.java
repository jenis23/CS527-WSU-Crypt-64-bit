package wsu;

public class ShiftCipher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String cipherString = "pryffzjgcreezexfetfdsrkzexjgrdspivhlzizexvdrzckfsvrlkyvekztrkv"
				+ "ukyvgifscvdkyvptcrzdzjkyrkkyvivjefnrpfwbefnzexnyfkyvjveuviivrccpzjzkjvv"
				+ "djfsmzfljkfdvkyrkkyzjnfekjkfgjgrdrkrccjgrddvijrivrcivrupsivrbz"
				+ "exzekftfdglkvijreuyzartbzexcvxzkzdrkvljvijvdrzcjpjkvdjjgrddvijrivr"
				+ "civrupjveuzexdrzcflkfwireufdtflekizvjreujkfcverttflekjyfnvortkcpnzcckyzj"
				+ "drbvkyzexjsvkkvi";
		System.out.println("Before Decryption:" + cipherString.toUpperCase());

		String message = "";
		message = cipherString.toUpperCase();
		int k = 17;
		int key = 26 - k;
		encryptMessage(message, key);

	}

	private static void encryptMessage(String msg, int k) {
		String result = "";

		for (int i = 0; i < msg.length(); i++)
			result += encryptChar(msg.charAt(i), k);

		System.out.println("After Decryption:" + result);

	}

	private static char encryptChar(char c, int k) {
		if (Character.isLetter(c)) {
			return (char) ('A' + (c - 'A' + k) % 26);
		} else
			return c;
	}

}
