package in.k2s.util.hash;


public class HashMD5 extends Hash {
	
	public static String hashMD5(String value) {
		return stringHexa(digest(value, "MD5"));
	}

}
