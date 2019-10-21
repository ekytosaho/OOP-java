import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.HyperlinkEvent;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.awt.event.InputEvent;
import javax.swing.JMenu;
import java.util.Scanner;

public class Editori extends JFrame {
	

	private JPanel contentPane;
	JEditorPane editorPane = new JEditorPane();

	public static void main(String[] args) throws Exception{
	
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Editori frame = new Editori();
					frame.setVisible(true);
					frame.setTitle("Oma Editori");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Editori() {
	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnTiedosto = new JMenu("Tiedosto");
		menuBar.add(mnTiedosto);
		
		JMenuItem mntmAvaa = new JMenuItem("Avaa");
		mntmAvaa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				JFileChooser valintaikkuna = new JFileChooser();
				valintaikkuna.setApproveButtonText("Avaa tiedosto");
				valintaikkuna.setDialogTitle("Tiedoston valinta");
				valintaikkuna.showOpenDialog(null);
				
				String rivi = "";
				
				try {
										
					String uusiTiedosto = valintaikkuna.getSelectedFile().getAbsolutePath();
											
					Scanner lukija = null;
					File tiedosto = new File(uusiTiedosto);
					
					lukija = new Scanner(tiedosto);
					
					while (lukija.hasNextLine()) {
						rivi += lukija.nextLine() + "\n";
						System.out.println(rivi);
					}
				} catch (FileNotFoundException p) {
					System.out.println("Tiedostoa ei löydy.");
				}
			
				editorPane.setText(rivi);
				
			}
		});
		mntmAvaa.setIcon(new ImageIcon(Editori.class.getResource("/com/sun/java/swing/plaf/windows/icons/File.gif")));
		mntmAvaa.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		mnTiedosto.add(mntmAvaa);
		
		JMenuItem mntmTallenna = new JMenuItem("Tallenna");
		mntmTallenna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser valintaikkuna = new JFileChooser();
				valintaikkuna.showSaveDialog(null);
				String uusiTiedosto = valintaikkuna.getSelectedFile().getAbsolutePath();
				System.out.println("Kirjoitettava tiedosto " +uusiTiedosto);
				
				try {
				PrintWriter writer = new PrintWriter(uusiTiedosto);
				String sisalto = editorPane.getText();
	
				writer.println(sisalto);
				writer.flush();
				writer.close();
				
			} catch (Exception e1) {
				System.out.println("Tiedoston tallennuksessa tapahtui virhe!");
				e1.printStackTrace();
			}
			
			}	
		});
		mntmTallenna.setIcon(new ImageIcon(Editori.class.getResource("/javax/swing/plaf/metal/icons/ocean/floppy.gif")));
		mntmTallenna.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mnTiedosto.add(mntmTallenna);
		
		JMenuItem mntmLopeta = new JMenuItem("Lopeta");
		mntmLopeta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		mnTiedosto.add(mntmLopeta);
		
		JMenu mnMuokkaa = new JMenu("Muokkaa");
		menuBar.add(mnMuokkaa);
		
		JMenuItem mntmEtsi = new JMenuItem("Etsi");
		mntmEtsi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sisalto = editorPane.getText();
				sisalto = sisalto.toLowerCase();
				
				String haettava = "auto";
				int indeksi = sisalto.indexOf(haettava);
				System.out.println("Indeksi: "+ indeksi);
				
				editorPane.setSelectionColor(Color.YELLOW);
				
				editorPane.setSelectionStart(indeksi);
				editorPane.setSelectionEnd(indeksi + haettava.length());
				
			}
		});
		mnMuokkaa.add(mntmEtsi);
		
		JMenuItem mntmKorvaa = new JMenuItem("Korvaa");
		mntmKorvaa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			String sisalto = editorPane.getText();
			
			String korvaavaSana = " ";
			String korvattavaSana = " ";
			int indeksi = sisalto.indexOf(korvaavaSana);
		
			System.out.println(sisalto.replaceAll(korvattavaSana, korvaavaSana));
		
			
			editorPane.setSelectionColor(Color.YELLOW);
			
			}
		});
		mnMuokkaa.add(mntmKorvaa);
		
		JMenu mnTietoja = new JMenu("Tietoja");
		menuBar.add(mnTietoja);
		
		JMenuItem mntmTietojaOhjelmasta = new JMenuItem("Tietoja ohjelmasta");
		mntmTietojaOhjelmasta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.out.print("This program is created by Erica Kytösaho.");

				
			}
		});
		mnTietoja.add(mntmTietojaOhjelmasta);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JToolBar toolBar = new JToolBar();
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		JButton button_3 = new JButton("");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser valintaikkuna = new JFileChooser();
				valintaikkuna.showOpenDialog(null);
				String rivi = "";
				
				try {
										
					String uusiTiedosto = valintaikkuna.getSelectedFile().getAbsolutePath();
										
					Scanner lukija = null;
					File tiedosto = new File(uusiTiedosto);
					
					lukija = new Scanner(tiedosto);
					
					while (lukija.hasNextLine()) {
						rivi += lukija.nextLine() + "\n";
						System.out.println(rivi);
					}
				} catch (FileNotFoundException p) {
					System.out.println("Tiedostoa ei löydy.");
				}
			
				editorPane.setText(rivi);
				
			}
				
		});
		button_3.setIcon(new ImageIcon(Editori.class.getResource("/javax/swing/plaf/metal/icons/ocean/file.gif")));
		toolBar.add(button_3);
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser valintaikkuna = new JFileChooser();
				valintaikkuna.showSaveDialog(null);
				String uusiTiedosto = valintaikkuna.getSelectedFile().getAbsolutePath();
				System.out.println("Kirjoitettava tiedosto " +uusiTiedosto);
				
				try {
				PrintWriter writer = new PrintWriter(uusiTiedosto);
				String sisalto = editorPane.getText();
	
				writer.println(sisalto);
				writer.flush();
				writer.close();
				
			} catch (Exception e1) {
				System.out.println("Tiedoston tallennuksessa tapahtui virhe!");
				e1.printStackTrace();
			}
				
			}
		});
		button_1.setIcon(new ImageIcon(Editori.class.getResource("/javax/swing/plaf/metal/icons/ocean/floppy.gif")));
		toolBar.add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String sisalto = editorPane.getText();
				editorPane.cut();
			}
		});
		button_2.setIcon(new ImageIcon(Editori.class.getResource("/com/sun/javafx/scene/web/skin/Cut_16x16_JFX.png")));
		toolBar.add(button_2);
		
		
		contentPane.add(editorPane, BorderLayout.CENTER);
		
	}

}
