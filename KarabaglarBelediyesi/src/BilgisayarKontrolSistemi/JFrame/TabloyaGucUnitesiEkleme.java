package BilgisayarKontrolSistemi.JFrame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BilgisayarKontrolSistemi.baglanti;
import BilgisayarKontrolSistemi.ekranKarti;
import BilgisayarKontrolSistemi.gucUnitesi;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.beans.Visibility;
import java.awt.event.ActionEvent;

public class TabloyaGucUnitesiEkleme extends JFrame {

	private JPanel contentPane;
	private JTextField wattField;
	private JTextField brandField;

	/**
	 * Launch the application.
	 */
	static baglanti bag = null;
	public static void main(String[] args, baglanti baglanti) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bag = baglanti;
					TabloyaGucUnitesiEkleme frame = new TabloyaGucUnitesiEkleme();
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
	public TabloyaGucUnitesiEkleme() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBounds(0, 0, 586, 363);
		contentPane.add(contentPane_1);
		
		JButton btnGnitesiEkle = new JButton("Güç ünitesi Ekle");
		btnGnitesiEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String brand = brandField.getText();
				String Wa = wattField.getText();
				int Watt= Integer.valueOf(Wa);
				gucUnitesi güçÜnitesi = new gucUnitesi(brand , Watt);
				bag.TabloyaGüçUnitesiEkle(güçÜnitesi);
				setVisible(false);
			}
		});
		btnGnitesiEkle.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGnitesiEkle.setBounds(214, 272, 157, 42);
		contentPane_1.add(btnGnitesiEkle);
		
		JLabel label2 = new JLabel("Watt :");
		label2.setHorizontalAlignment(SwingConstants.TRAILING);
		label2.setFont(new Font("Tahoma", Font.BOLD, 14));
		label2.setBounds(26, 152, 144, 28);
		contentPane_1.add(label2);
		
		wattField = new JTextField();
		wattField.setColumns(10);
		wattField.setBounds(180, 156, 225, 26);
		contentPane_1.add(wattField);
		
		brandField = new JTextField();
		brandField.setColumns(10);
		brandField.setBounds(180, 99, 225, 26);
		contentPane_1.add(brandField);
		
		JLabel label = new JLabel("Marka :");
		label.setHorizontalAlignment(SwingConstants.TRAILING);
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(26, 95, 144, 28);
		contentPane_1.add(label);
		
		JLabel lblNewLabel_1 = new JLabel("Güç Ünitesi");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(232, 21, 122, 37);
		contentPane_1.add(lblNewLabel_1);
	}

}
