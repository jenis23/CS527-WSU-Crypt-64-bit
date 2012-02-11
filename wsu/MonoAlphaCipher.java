package wsu;

import java.util.Arrays;
import java.util.Hashtable;

public class MonoAlphaCipher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
/*		String cipherString = "qhhpqicrhnajcshihqqrhvgmosfqfmebnozhoevgkcibceokbnhebct"
				+ "obcmenhshcqoqbmsvogmkbmehahsqmeqrhvgmosfboircedbmoembnhsahsqmeqtmpakbhsbn"
				+ "smkdnjoiiqmehnkefshfoefucubvphbhsqojovjncihoqbozoedhspoebvahfojovobncqfhqrbm"
				+ "atmpakbhsncqbhybjoqoiqmqbshopcedcemencqehcdngmsqpotncehceogkcifcedmehnkefshfoe"
				+ "fucubvphbhsqojovnhjihbbaotrosfnozhehzhsshthczhfotmpaiocebicrhcbahshscrnhiihdmboxmi"
				+ "bjnhencqnmphtmpakbhsqkffheivqhhphfbmfhzhimaoicuhmucbqmjeogmkbbheapcjoqqcbbced"
				+ "oefjobtncedbzjnhebnhtmpakbhsjnctnjoqceqihhapmfhqkffheivghdoebmgkllcimmrhfmzhso"
				+ "efembcthfcbjoqjorcedkacoiqmqojoshficdnbmebnhhvgmosfqshthczhsgmygicercedoqcucjoq"
				+ "jscbcedqmphbncednhiihqocfodophjnctnnhtmkifembshphpghskqcedbnobfovoaahoshfme"
				+ "bnhqtshhejnhenhiihjhebmzhsbmqnkbcbmuubnhqtshhefcqaiovhfophqqodhoqrcedncpcu"
				+ "nhshoiivjoebhfbmfhihbhbncqucihembremjcedjnobcbphoebnhoeqjhshfembmaiovcbqou"
				+ "hbnhpotncehjoqembucecqnhfoqhschqmughhaqoeftictrqbnobncebhfobhssmsphqqodhqt"
				+ "ophqmwkctrivbnobnhiihodocedmbbnhcpashqqcmeqmphmehjoqjscbcedqmnhbksehfm"
				+ "encqjmsfasmthqqmsnhqojbhybbctrcedceiczhoeftmkifbhiiusmpbnhphqqodhbnobcbjoqnc"
				+ "qehcdngmsahsoscifhzxhghsdoiqmncqgmqqobqbozoedhsoubhegiofjnmjoqjscbcedoanm"
				+ "ehtoiiwkctrivtmeucsphfbnobnhiihjoqjobtncedhzxhghsdbvahiczhcunatoebucefofhthebhyai"
				+ "oeobcmeumsbncqcfmebfoshkqhbncqrhvgmosfctnoedhfbnhqcdeoitnoeehioefemjahshscrf"
				+ "mhqebdhbcbgkbemjcfmebremjjnmpcdnbghshofcedjnobcjscbhoqcjscbhcbhzxhghsdqocfhzxhghsdo"
				+ "efnhiihnofshthczhfehjnapotncehqusmpbnhqophtmpaoevoefnhiihnofmehbcphhhosichsembcthfo"
				+ "shdcqbsobcmeumspoaahosjcbnncqehcdngmsqceumspobcmececbnaasmfktbpoeodhsbmshoqshicefghich"
				+ "zhqbnobmeivotmpgceobcmemukekqkoitcstkpqboethqtmkifshqkibcebnhrhvgmosfqcdeoibsozhicedme"
				+ "hnkefshfoefucbuvphbhsqoefbnsmkdnmehjmmfheoefmehtmetshbhjoiijcbnbnhtmefcbcmeqoeffcqboethfhqts"
				+ "cghfjhnozhemimdctoimsbhtnectoihyaioeobcmeumsnmjbncqcqamqqcgihbnhrhvgmosfqnmkifnozhobnhms"
				+ "hbctoisofckqmuogmkbbjhebvphbhsqoqqkpcedotihosaobnusmprhvgmosfbmshthczhs";
*/
		String cipherString = "abbcabadbcadabefab";
		Hashtable<String, Double> freq = new Hashtable<String, Double>();
		Hashtable<String, Double> doubleFreq = new Hashtable<String, Double>();
		Hashtable<String, Double> tripleFreq = new Hashtable<String, Double>();
		String set = "abcdefghijklmnopqrstuvwxyz";
		String tmpString = "abbcdeab";
		int count = 0;

		// initialize our character counts to 0
		for (int i = 0; i < set.length(); i++) {
			freq.put(set.substring(i, i + 1), 0.0);
		}
		// initialize our double character counts to 1
		for (int i = 0; i < cipherString.length() / 2; i++) {
			doubleFreq.put(cipherString.substring(i, i + 2), 1.0);
		}
System.out.println(doubleFreq);
		for (int i = 0; i < cipherString.length() / 3; i++) {
			tripleFreq.put(cipherString.substring(i, i + 3), 1.0);

		}
		System.out.println(tripleFreq);
		// extract each character from the line
		for (int i = 0; i < cipherString.length(); i++) {
			String c = cipherString.substring(i, i + 1);

			// try and match our character to a lower or upper case letter
			if (c.matches("[a-zA-Z]")) {

				// increment the count of our character
				c = c.toLowerCase();
				freq.put(c, freq.get(c) + 1.0);
				count++;
			}
		}

			// calculate the frequency of each of our characters, printing the
		// result
		for (int i = 0; i < set.length(); i++) {
			String key = set.substring(i, i + 1);

			double perc = freq.get(key) / count * 100.0;

	//		System.out.println(key + ": " + String.format("%2.2f", perc)
		//			+ " And letter Freq:" + freq.get(key));
		}
		String newArr[] = new String[(cipherString.length()) ];
		System.out.println(newArr.length);
		for(int i=0;i<cipherString.length();i++){
			System.out.println(i);			
			String c = cipherString.substring(i,i+2);
			System.out.println(c);
			newArr[i]=c;
			i++;
			
		}
		
	//	String newArr[] = cipherString.split("(?<=\\G.{2})");
		// System.out.println(doubleFreq);
		double cnt = 0;

		 System.out.println("nwarr length:" + newArr.length);
		 
		 for(int i=0;i<newArr.length;i++)
			 System.out.print(newArr[i]);
		 
		for (int j = 0; j < newArr.length; j++) {
			if(doubleFreq.get(newArr[j]) != null && doubleFreq.get(newArr[j]).doubleValue()==1){
			for (int k = j + 1; k < newArr.length; k++) {
			//	if (doubleFreq.get(newArr[j]) != null) {
					if (newArr[j].equals(newArr[k])) {
						System.out.println("newArr["+j+"]="+newArr[j]);
						System.out.println("newArr["+k+"]="+newArr[k]);
						doubleFreq.put(newArr[j], (doubleFreq.get(newArr[j])
								.doubleValue() + 1.0));
						System.out.println("Freq:"+doubleFreq.get(newArr[j]).doubleValue());
					}
				//}
			}
		}
		}

		System.out.println(doubleFreq);
double total=0;
		String newArr2[] = cipherString.split("(?<=\\G.{3})");
		System.out.println("Original length:"+cipherString.length()+"divide by 3 length:"+newArr2.length);
		for (int j = 0; j < newArr2.length; j++) {
			for (int k = j + 1; k < newArr2.length; k++) {
				if (tripleFreq.get(newArr2[j]) != null) {
					if (newArr2[j].equals(newArr2[k])) {
						
						System.out.println(newArr2[j]);
						total+=tripleFreq.get(newArr2[j]).doubleValue();
						tripleFreq.put(newArr2[j], (tripleFreq.get(newArr2[j])
								.doubleValue() + 1.0));
					}
				}
			}
		}
		System.out.println(tripleFreq+ "cnt"+ cnt);
		System.out.println("Total:"+total); 
	}

}
