import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

public class GUI_Automaatti extends JFrame {

	// Luokkamuuttujat
	// Esitell‰‰n t‰‰ll‰ jotta komponentteihin voidaan viitata mist‰ tahansa luokan
	// sis‰lt‰

	JPanel contentPane;
	private JMenuItem mntmTallennaAutomaatinTila;
	private JMenuItem mntmLataaAutomaatti;

	/**
	 * Main-metodi, joka k‰ynnist‰‰ sovelluksen
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// Luodaan ensmin uusi JuomaAutomaatti-olio
					JuomaAutomaatti ja = new JuomaAutomaatti();

					// K‰yttˆliittym‰ saa parametrina olion, jonka tiedot se n‰ytt‰‰
					GUI_Automaatti frame = new GUI_Automaatti(ja);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Konstruktorissa rakennetaan k‰yttˆliittym‰. Huomaa, ett‰ otetaan parametrina
	 * vastaan alussa luotu juoma-automaatti. T‰m‰ siksi, ett‰ voidaan n‰ytt‰‰ sen
	 * tiedot GUI:ssa
	 */
	public GUI_Automaatti(JuomaAutomaatti ja) {

		// Ikkunan otsikko ja koko

		setTitle("Kahviautomaatti GUI v. 1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 465, 705);

	 
		contentPane = new JPanel();
		contentPane.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		
		JButton Kahvipainike = new JButton("");
		Kahvipainike.addActionListener(new ActionListener() {
			
			public JuomaAutomaatti valmistaKahvia = new JuomaAutomaatti();
		
			public void actionPerformed(ActionEvent e) {
				
				valmistaKahvia.valmistaKahvi();
				JuomaAutomaatti uusiKahvi = new JuomaAutomaatti();
				int kahvi = uusiKahvi.getKahvi();
	
			}
		});
		Kahvipainike.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		Kahvipainike.setIcon(new ImageIcon("C:\\Users\\Erica Kyt\u00F6saho\\eclipse-workspace\\GUI_JuomaAutomaatti\\src\\kahvi.PNG"));
		Kahvipainike.setBounds(12, 70, 173, 97);
		contentPane.add(Kahvipainike);
		
		JLabel lblKahvi = new JLabel("Kahvi");
		lblKahvi.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblKahvi.setBounds(78, 178, 56, 16);
		contentPane.add(lblKahvi);
		
		int kahvinMaara= 0;
		JuomaAutomaatti kahviaJaljella = new JuomaAutomaatti();
		kahvinMaara = kahviaJaljella.getKahvi();
		JLabel lblKahviaJljell = new JLabel("Kahvia j\u00E4ljell\u00E4: " + kahvinMaara);
		lblKahviaJljell.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblKahviaJljell.setBounds(230, 99, 191, 35);
		contentPane.add(lblKahviaJljell);
		
		
		int TeenMaara = 0;
		JuomaAutomaatti TeetaJaljella = new JuomaAutomaatti();
		TeenMaara = TeetaJaljella.getTee();
		JLabel lblNewLabel = new JLabel("Teet\u00E4 j\u00E4ljell\u00E4: " + TeenMaara);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel.setBounds(230, 262, 191, 42);
		contentPane.add(lblNewLabel);
		
		JButton TeePainike = new JButton("");
		TeePainike.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		TeePainike.setIcon(new ImageIcon("C:\\Users\\Erica Kyt\u00F6saho\\eclipse-workspace\\GUI_JuomaAutomaatti\\src\\tee.PNG"));
		TeePainike.addActionListener(new ActionListener() {
			
			public JuomaAutomaatti valmistaTeeta = new JuomaAutomaatti();
			
			public void actionPerformed(ActionEvent arg0) {
				
				valmistaTeeta.valmistaTee();
				JuomaAutomaatti uusiTee = new JuomaAutomaatti();
				int tee = uusiTee.getTee();
			
			}
		});
		TeePainike.setBounds(12, 233, 173, 97);
		contentPane.add(TeePainike);
		
		JLabel lblTee = new JLabel("Tee");
		lblTee.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTee.setBounds(78, 343, 56, 16);
		contentPane.add(lblTee);
		
		
		int KaakaonMaara = 0;
		JuomaAutomaatti KaakaotaJaljella = new JuomaAutomaatti();
		KaakaonMaara = KaakaotaJaljella.getKaakao();
		JLabel lblKaakaotaJljell = new JLabel("Kaakaota j\u00E4ljell\u00E4: " + KaakaonMaara);
		lblKaakaotaJljell.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblKaakaotaJljell.setBounds(230, 427, 191, 42);
		contentPane.add(lblKaakaotaJljell);
	
		JButton KaakaoPainike = new JButton("");
		KaakaoPainike.addActionListener(new ActionListener() {
			
			public JuomaAutomaatti valmistaKaakaota = new JuomaAutomaatti();
			
			public void actionPerformed(ActionEvent arg0) {
				
				valmistaKaakaota.valmistaKaakao();
				JuomaAutomaatti uusiKaakao = new JuomaAutomaatti();
				int kaakao = uusiKaakao.getTee();
				
			}
		});
		KaakaoPainike.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		KaakaoPainike.setIcon(new ImageIcon("C:\\Users\\Erica Kyt\u00F6saho\\eclipse-workspace\\GUI_JuomaAutomaatti\\src\\kaakao.PNG"));
		KaakaoPainike.setBounds(12, 397, 173, 99);
		contentPane.add(KaakaoPainike);
		
		JLabel lblKaakao = new JLabel("Kaakao");
		lblKaakao.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblKaakao.setBounds(78, 509, 56, 16);
		contentPane.add(lblKaakao);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		menuBar.setBounds(0, 0, 447, 26);
		contentPane.add(menuBar);
		
		JMenu mnYllpito = new JMenu("Yll\u00E4pito");
		mnYllpito.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		menuBar.add(mnYllpito);
		
		JMenuItem mntmAsetaKahvinMr = new JMenuItem("Aseta kahvin m\u00E4\u00E4r\u00E4");
		mntmAsetaKahvinMr.addActionListener(new ActionListener() {
			
			public JuomaAutomaatti KahvinMaara = new JuomaAutomaatti();
			
			public void actionPerformed(ActionEvent e) {
				
				int kahvi = 0;
				
				KahvinMaara.getKahvi();
				
				String uusiArvo = JOptionPane.showInputDialog(null, "Anna uusi arvo: ");
				int uusiKahvi = Integer.parseInt(uusiArvo);
				
				KahvinMaara.setKahvi(uusiKahvi);
			

			}
		});
		mntmAsetaKahvinMr.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		mnYllpito.add(mntmAsetaKahvinMr);
		
		JMenuItem mntmAsetaTeenMr = new JMenuItem("Aseta teen m\u00E4\u00E4r\u00E4");
		mntmAsetaTeenMr.addActionListener(new ActionListener() {
			
			public JuomaAutomaatti teenMaara = new JuomaAutomaatti();
			
			public void actionPerformed(ActionEvent e) {
				
				int tee = 0;
				teenMaara.getTee();
				
				String uusiArvo = JOptionPane.showInputDialog(null, "Anna uusi arvo: ");
				int uusiTee = Integer.parseInt(uusiArvo);
				
				teenMaara.setTee(uusiTee);
			}
		});
		mntmAsetaTeenMr.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		mnYllpito.add(mntmAsetaTeenMr);
		
		JMenuItem mntmAsetaKaakaonMr = new JMenuItem("Aseta kaakaon m\u00E4\u00E4r\u00E4");
		mntmAsetaKaakaonMr.addActionListener(new ActionListener() {
			
			public JuomaAutomaatti KaakaonMaara = new JuomaAutomaatti();
			
			public void actionPerformed(ActionEvent e) {
				
				int kaakao = 0;
				KaakaonMaara.getKaakao();
				
				String uusiArvo = JOptionPane.showInputDialog(null, "Anna uusi arvo: ");
				int uusiKaakao = Integer.parseInt(uusiArvo);
				
				KaakaonMaara.setKaakao(uusiKaakao);
			}
		});
		mntmAsetaKaakaonMr.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		mnYllpito.add(mntmAsetaKaakaonMr);
		
		JMenuItem mntmTallennaAutomaatinTila_1 = new JMenuItem("Tallenna automaatin tila");
		mntmTallennaAutomaatinTila_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Sarjallistamista.kirjoitaTiedostoon(ja);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		mntmTallennaAutomaatinTila_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		mnYllpito.add(mntmTallennaAutomaatinTila_1);
		
		JMenuItem mntmLataaAutomaatti_1 = new JMenuItem("Lataa automaatti");
		mntmLataaAutomaatti_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					JuomaAutomaatti uusi = Sarjallistamista.lueTiedostosta();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		mntmLataaAutomaatti_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		mnYllpito.add(mntmLataaAutomaatti_1);
		
		JMenuItem mntmLopeta = new JMenuItem("Lopeta");
		mntmLopeta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		mntmLopeta.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		mnYllpito.add(mntmLopeta);
		
		JMenu mnTietojaOhjelmasta = new JMenu("Tietoja ohjelmasta");
		mnTietojaOhjelmasta.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		menuBar.add(mnTietojaOhjelmasta);
		
		JMenuItem mntmVersiotiedot = new JMenuItem("Versiotiedot");
		mntmVersiotiedot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Versiotiedot uusiIkkuna = new Versiotiedot();
				uusiIkkuna.main(null);
			}
		});
		mntmVersiotiedot.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		mnTietojaOhjelmasta.add(mntmVersiotiedot);
		
		JMenuItem mntmOhje = new JMenuItem("Ohje");
		mntmOhje.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		mnTietojaOhjelmasta.add(mntmOhje);
	}
}
