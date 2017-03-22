package Various;

import java.util.Random;

public class RandomString {

	private static final Random r = new Random(System.currentTimeMillis());
	public static String randomAlphanumericString(int l){
		StringBuilder sb = new StringBuilder();
		for (int j = 0; j < l; j++) {
			sb.append((char)('a'+r.nextInt('z'-'a')));

		}
		return sb.toString();
	}
	
}
