package BilgisayarKontrolSistemi.JFrame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BilgisayarKontrolSistemi.saklamaAlani;
import BilgisayarKontrolSistemi.baglanti;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TabloyaSaklamaAlaniEkle extends JFrame {

	private JPanel contentPane;
	private JTextField writeField;
	private JTextField capacityField;
	private JTextField brandField;
	private JTextField readField;
	private JTextField typeField;

	/**
	 * Launch the application.
	 */
	static baglanti bag = null;
	public static void main(String[] args , baglanti baglanti) {
		bag = baglanti;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TabloyaSaklamaAlaniEkle frame = new TabloyaSaklamaAlaniEkle();
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
	public TabloyaSaklamaAlaniEkle() {
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
		
		JButton btnRamEkle = new JButton("Saklama Alanı Ekle");
		btnRamEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String brand = brandField.getText();
				String cp = capacityField.getText();
				int capacity= Integer.valueOf(cp);
				String wr = writeField.getText();
				int write= Integer.valueOf(wr);
				String re = readField.getText();
				int read= Integer.valueOf(re);
				String type = typeField.getText();
				saklamaAlani saklamaAlanı = new saklamaAlani(brand , capacity , write , read , type);
				bag.TabloyaSaklamaAlanıEkle(saklamaAlanı);
				setVisible(false);
			}
		});
		btnRamEkle.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRamEkle.setBounds(197, 300, 191, 42);
		contentPane_1.add(btnRamEkle);
		 
		writeField = new JTextField();
		writeField.setColumns(10);
		writeField.setBounds(180, 165, 225, 26);
		contentPane_1.add(writeField);
		
		JLabel lblNewLabel_3 = new JLabel("Yazma Hızı :");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(26, 164, 144, 28);
		contentPane_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Depolama Alanı :");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(26, 119, 144, 28);
		contentPane_1.add(lblNewLabel_2);
		
		capacityField = new JTextField();
		capacityField.setColumns(10);
		capacityField.setBounds(180, 120, 225, 26);
		contentPane_1.add(capacityField);
		
		brandField = new JTextField();
		brandField.setColumns(10);
		brandField.setBounds(180, 75, 225, 26);
		contentPane_1.add(brandField);
		
		JLabel lblNewLabel = new JLabel("Marka :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(26, 74, 144, 28);
		contentPane_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Saklama Alanı");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(226, 19, 134, 37);
		contentPane_1.add(lblNewLabel_1);
		
		readField = new JTextField();
		readField.setColumns(10);
		readField.setBounds(180, 210, 225, 26);
		contentPane_1.add(readField);
		
		JLabel lblNewLabel_2_1 = new JLabel("Okuma Hızı :");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(26, 209, 144, 28);
		contentPane_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Saklama Alanı Tipi");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_1.setBounds(26, 254, 144, 28);
		contentPane_1.add(lblNewLabel_3_1);
		
		typeField = new JTextField();
		typeField.setColumns(10);
		typeField.setBounds(180, 255, 225, 26);
		contentPane_1.add(typeField);
	}

}
