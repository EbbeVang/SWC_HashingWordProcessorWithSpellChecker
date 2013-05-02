package HashSet;

import java.util.Arrays;

public class TestHashSet {
	public static void main(String[] args) {
	
		// testing collision
		MyHashSet<String> set = new MyHashSet<String>();
		set.add ("FB");
		System.out.println(set);
		set.add ("eA");
		System.out.println(set);
		set.add ("Ebbe");
		System.out.println(set);
		set.add("Liv");
		System.out.println(set);
	}
}
