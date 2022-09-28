package BilgisayarKontrolSistemi.JFrame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BilgisayarKontrolSistemi.baglanti;
import BilgisayarKontrolSistemi.ekranKarti;
import BilgisayarKontrolSistemi.ram;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TabloyaRAMEkle extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	static baglanti bag = null;
	private JTextField DDRField;
	private JTextField speedField;
	private JTextField brandField;
	public static void main(String[] args , baglanti baglanti) {
		bag = baglanti;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TabloyaRAMEkle frame = new TabloyaRAMEkle();
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
	public TabloyaRAMEkle() {
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
		
		JButton btnRamEkle = new JButton("Ram Ekle");
		btnRamEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String brand = brandField.getText();
				String sp = speedField.getText();
				int speed= Integer.valueOf(sp);
				String dd = DDRField.getText();
				int ddr= Integer.valueOf(dd);
				ram RAM = new ram(brand , speed , ddr);
				bag.TabloyaRamEkle(RAM);
				setVisible(false);
			}
		});
		btnRamEkle.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRamEkle.setBounds(214, 272, 157, 42);
		contentPane_1.add(btnRamEkle);
		
		DDRField = new JTextField();
		DDRField.setColumns(10);
		DDRField.setBounds(180, 212, 225, 26);
		contentPane_1.add(DDRField);
		
		JLabel lblNewLabel_3 = new JLabel("DDR :");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(26, 208, 144, 28);
		contentPane_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Hız :");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(26, 152, 144, 28);
		contentPane_1.add(lblNewLabel_2);
		
		speedField = new JTextField();
		speedField.setColumns(10);
		speedField.setBounds(180, 156, 225, 26);
		contentPane_1.add(speedField);
		
		brandField = new JTextField();
		brandField.setColumns(10);
		brandField.setBounds(180, 99, 225, 26);
		contentPane_1.add(brandField);
		
		JLabel lblNewLabel = new JLabel("Marka :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(26, 95, 144, 28);
		contentPane_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("RAM");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(271, 21, 43, 37);
		contentPane_1.add(lblNewLabel_1);
	}

}
