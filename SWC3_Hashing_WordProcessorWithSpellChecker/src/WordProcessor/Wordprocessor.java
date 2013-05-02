package WordProcessor;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;

import Dictionaries.Dictionary;
import HashSet.MyHashSet;


public class Wordprocessor extends JFrame implements KeyListener{
	
	Dictionary dictionary;
	
	WordProcessorPanel panel = new WordProcessorPanel();
	private JTextPane textPane;
	
	public static void main(String[] args) {
		new Wordprocessor();
	}
	
	public Wordprocessor() {
		setTitle("Wordprocessor");
		setSize(400, 600);
		add(panel);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		//set eventlistener
		textPane = panel.getTextPane();
		textPane.addKeyListener(this);
		
		//load dictionary
		 dictionary = new Dictionary(Dictionary.ENGLISH_LANGUAGE);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (e.getKeyChar() == ' '){	
			System.out.println("you pressed space");
			String allText = textPane.getText();
			String lastWord = allText.substring(allText.lastIndexOf(" ")+1);
			System.out.println("last word: "+lastWord);
			if (!dictionary.contains(lastWord)){
				highlightWord(textPane);
			}		
		}
	}

	public void highlightWord(JTextPane textPane) {
		// highlight last word
		String allText = textPane.getText();
		String lastWord = allText.substring(allText.lastIndexOf(" ")+1);
		//System.out.println("LastWord:\"" + lastWord + "\"")
		int highlightStart = allText.length()-lastWord.length();
		int highlightEnd = allText.length()-1;
		
		//System.out.println(""+highlightStart+"-"+highlightEnd);
		Highlighter h = textPane.getHighlighter();
		try {
			h.addHighlight(highlightStart, highlightEnd, new DefaultHighlighter.DefaultHighlightPainter(
					Color.red));
		} catch (BadLocationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
	
	
}
