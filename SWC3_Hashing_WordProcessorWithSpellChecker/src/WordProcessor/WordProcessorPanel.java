package WordProcessor;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.JButton;


public class WordProcessorPanel extends JPanel {

	private JTextPane textPane = new JTextPane();
	
	public WordProcessorPanel() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		
		JComboBox comboBox = new JComboBox();
		panel.add(comboBox);
		
		JButton btnNewButton = new JButton("Check spelling");
		panel.add(btnNewButton);
			
		add(textPane, BorderLayout.CENTER);

	}

	public JTextPane getTextPane() {
		return textPane;
	}

}
