package BilgisayarKontrolSistemi.JFrame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BilgisayarKontrolSistemi.baglanti;
import BilgisayarKontrolSistemi.kullanici;
import BilgisayarKontrolSistemi.system;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Giris extends JFrame {

	private JPanel contentPane;
	private JTextField KullaniciAdi;
	private JLabel lblifre;
	private JPasswordField Sifre;

	/**
	 * Launch the application.
	 */
	
	static baglanti bag = new baglanti();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String kullaniciAdi = null;
					String kullaniciSifresi = null;
					Giris frame = new Giris();
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
	public Giris() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JButton GirisButonu = new JButton("Giriş Yap");
		GirisButonu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String kullaniciAdi = KullaniciAdi.getText();
				String kullaniciSifresi = Sifre.getText();
				kullanici kullanici = system.GirisIslemi(kullaniciAdi , kullaniciSifresi);
				if(kullanici!=null) {
					setVisible(false);
					if(kullanici.getFlag() == true) {
						AdminGirisi.main(null,kullanici);
					}else {
						KullaniciGirisi.main(null,kullanici,bag);
					}
					
				}
				else {
					System.out.println("Yanlış Giriş");
				}
				
				
			}
		});
		
		
		GirisButonu.setFont(new Font("Tahoma", Font.BOLD, 13));
		GirisButonu.setBounds(210, 274, 168, 37);
		contentPane.add(GirisButonu);
		
		KullaniciAdi = new JTextField();
		KullaniciAdi.setBounds(144, 71, 300, 37);
		contentPane.add(KullaniciAdi);
		KullaniciAdi.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Kullanıcı Adı :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(36, 75, 98, 25);
		contentPane.add(lblNewLabel);
		
		lblifre = new JLabel("             Şifre :");
		lblifre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblifre.setBounds(36, 176, 98, 25);
		contentPane.add(lblifre);
		
		Sifre = new JPasswordField();
		Sifre.setBounds(144, 172, 300, 37);
		contentPane.add(Sifre);
	}
}
