package BilgisayarKontrolSistemi.JFrame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BilgisayarKontrolSistemi.baglanti;
import BilgisayarKontrolSistemi.kullanici;

import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class KullaniciGirisi extends JFrame {

	private JPanel contentPane;

	static String girdi = null;
	static baglanti bag = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args , kullanici kullanici , baglanti baglanti) {
		bag = baglanti;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KullaniciGirisi frame = new KullaniciGirisi();
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
	public KullaniciGirisi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton ÇıkışButonu = new JButton("Çıkış");
		ÇıkışButonu.setBackground(Color.RED);
		ÇıkışButonu.setFont(new Font("Tahoma", Font.BOLD, 13));
		ÇıkışButonu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Giris.main(null);
			}
		});
		ÇıkışButonu.setBounds(193, 281, 200, 35);
		contentPane.add(ÇıkışButonu);
		
		JButton SistemeParcaEklemeButonu = new JButton("Sisteme Parça Ekle");
		SistemeParcaEklemeButonu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(girdi.equals("Anakart")) {
					TabloyaAnakartEkleme.main(null, bag);
				}
				else if(girdi.equals("Ekran Kartı")) {
					TabloyaEkranKartiEkleme.main(null, bag);
				}
				else if(girdi.equals("Güç Ünitesi")) {
					TabloyaGucUnitesiEkleme.main(null, bag);
				}
				else if(girdi.equals("İşlemci")) {
					TabloyaIslemciEkle.main(null, bag);
				}
				else if(girdi.equals("RAM")) {
					
				}
				else if(girdi.equals("Saklama Alanı")) {
					
				}
			}
		});
		SistemeParcaEklemeButonu.setFont(new Font("Tahoma", Font.BOLD, 13));
		SistemeParcaEklemeButonu.setBackground(Color.WHITE);
		SistemeParcaEklemeButonu.setBounds(193, 202, 200, 35);
		contentPane.add(SistemeParcaEklemeButonu);
		
		JButton KasaIslemleriButonu = new JButton("Kasa İşlemleri");
		KasaIslemleriButonu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		KasaIslemleriButonu.setFont(new Font("Tahoma", Font.BOLD, 13));
		KasaIslemleriButonu.setBackground(Color.WHITE);
		KasaIslemleriButonu.setBounds(193, 123, 200, 35);
		contentPane.add(KasaIslemleriButonu);
		
		JButton ProgromalarıKontrolEtButonu = new JButton("Progromaları Kontrol Et");
		ProgromalarıKontrolEtButonu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ProgromalarıKontrolEtButonu.setFont(new Font("Tahoma", Font.BOLD, 13));
		ProgromalarıKontrolEtButonu.setBackground(Color.WHITE);
		ProgromalarıKontrolEtButonu.setBounds(193, 44, 200, 35);
		contentPane.add(ProgromalarıKontrolEtButonu);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				girdi = (String) comboBox.getSelectedItem();
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Anakart", "Ekran Kartı", "Güç Ünitesi", "İşlemci", "RAM", "Saklama Alanı"}));
		comboBox.setToolTipText("Eklenicek parçayı seçin");
		comboBox.setBounds(26, 204, 149, 33);
		contentPane.add(comboBox);
	}
}
