package Dictionaries;

public class TestDictionary {
	public static void main(String[] args) {
		Dictionary d = new Dictionary(Dictionary.ENGLISH_LANGUAGE);
		System.out.println(d.contains("man"));
		System.out.println(d);
	}
}
