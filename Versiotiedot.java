import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JEditorPane;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.Component;

public class Versiotiedot extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Versiotiedot frame = new Versiotiedot();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Versiotiedot() {
		
		setTitle("Juoma-automaatti GUI v. 1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setPreferredSize(new Dimension(20, 10));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTextArea txtrJuomaautomaattiV = new JTextArea();
		txtrJuomaautomaattiV.setLineWrap(true);
		txtrJuomaautomaattiV.setFont(new Font("Times New Roman", Font.BOLD, 28));
		txtrJuomaautomaattiV.setText("\r\n    JUOMA-AUTOMAATTI V.1.0 \r\n           \r\n                TEKIJ\u00C4: EK");
		contentPane.add(txtrJuomaautomaattiV, BorderLayout.CENTER);
		
	
	}

}
