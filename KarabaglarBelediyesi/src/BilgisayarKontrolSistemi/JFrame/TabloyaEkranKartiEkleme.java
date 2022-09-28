package BilgisayarKontrolSistemi.JFrame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BilgisayarKontrolSistemi.ekranKarti;
import BilgisayarKontrolSistemi.baglanti;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TabloyaEkranKartiEkleme extends JFrame {

	private JPanel contentPane;
	private JTextField TypeField;
	private JTextField MemoryField;
	private JTextField BrandField;

	static baglanti bag = null ;
	static int type= 0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args , baglanti baglanti) {
		bag = baglanti;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TabloyaEkranKartiEkleme frame = new TabloyaEkranKartiEkleme();
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
	public TabloyaEkranKartiEkleme() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnEkranKartnEkle = new JButton("Ekran Kartı Ekle");
		btnEkranKartnEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String brand = BrandField.getText();
				String mem = MemoryField.getText();
				int memory= Integer.valueOf(mem);
				String ty = TypeField.getText();
				ty.toLowerCase();
				if(ty.equals("dahili")) {
					type = 1;
				}else {
					type = 0;
				}
				ekranKarti ekranKartı = new ekranKarti(brand , memory , type);
				bag.TabloyaEkranKartıEkle(ekranKartı);
				setVisible(false);
			}
		});
		btnEkranKartnEkle.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEkranKartnEkle.setBounds(214, 272, 157, 42);
		contentPane.add(btnEkranKartnEkle);
		
		TypeField = new JTextField();
		TypeField.setColumns(10);
		TypeField.setBounds(180, 212, 225, 26);
		contentPane.add(TypeField);
		
		JLabel lblNewLabel_3 = new JLabel("Harici / Dahili :");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(26, 208, 144, 28);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Hafıza :");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(26, 152, 144, 28);
		contentPane.add(lblNewLabel_2);
		
		MemoryField = new JTextField();
		MemoryField.setColumns(10);
		MemoryField.setBounds(180, 156, 225, 26);
		contentPane.add(MemoryField);
		
		BrandField = new JTextField();
		BrandField.setColumns(10);
		BrandField.setBounds(180, 99, 225, 26);
		contentPane.add(BrandField);
		
		JLabel lblNewLabel = new JLabel("Marka :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(26, 95, 144, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ekran Kartı");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(232, 21, 122, 37);
		contentPane.add(lblNewLabel_1);
	}

}
