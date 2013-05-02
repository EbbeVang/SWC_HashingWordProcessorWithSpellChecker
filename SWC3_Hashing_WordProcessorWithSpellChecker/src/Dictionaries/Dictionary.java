package Dictionaries;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import HashSet.MyHashSet;

public class Dictionary {
	public static final int DANISH_LANGUAGE = 1;
	public static final int ENGLISH_LANGUAGE = 2;
	
	MyHashSet<String> dictionary = new MyHashSet<String>();
	InputStream dicFile;
	
	public Dictionary(int language) {
		//select language
		switch (language) {
		case DANISH_LANGUAGE:
			dicFile = getClass().getResourceAsStream("/Dictionaries/da_DK.dic");
			break;
		case ENGLISH_LANGUAGE:
			dicFile = getClass().getResourceAsStream("/Dictionaries/eng_com.dic");
			break;
		}
	
		//fill hashmap
		BufferedReader bufReader = null;
		try {
			bufReader = new BufferedReader(new InputStreamReader(dicFile, "UTF-8"));
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String line;
		try {
			while ((line = bufReader.readLine())  != null){
				//ignore all lines beginnig with '%'
				if (!line.startsWith("%")){
					//remove everything after '/'
					if (line.contains("/")){
						line = line.substring(0, line.indexOf('/'));
					}
					dictionary.add(line);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public boolean contains(String word) {
		return dictionary.contains(word);

	}
	public String toString(){
		return dictionary.toString();
	}
}
