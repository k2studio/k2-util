package in.k2s.util.hash;


public class HashSHA extends Hash {

	public static String SHA1(String value) {
		return stringHexa(digest(value, "SHA-1"));
	}
	
	public static String SHA256(String value) {
		return stringHexa(digest(value, "SHA-256"));
	}
	
	public static String SHA512(String value) {
		return stringHexa(digest(value, "SHA-512"));
	}
	
	
	
}
