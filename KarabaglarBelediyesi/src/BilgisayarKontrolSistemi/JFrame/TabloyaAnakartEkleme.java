package BilgisayarKontrolSistemi.JFrame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.result.IntegerValueFactory;

import BilgisayarKontrolSistemi.anaKart;
import BilgisayarKontrolSistemi.baglanti;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TabloyaAnakartEkleme extends JFrame {

	private JPanel contentPane;
	private JTextField BrandField;
	private JTextField RamField;
	private JTextField DriverField;

	static baglanti bag = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args , baglanti baglanti) {
		bag = baglanti;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TabloyaAnakartEkleme frame = new TabloyaAnakartEkleme();
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
	public TabloyaAnakartEkleme() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		BrandField = new JTextField();
		BrandField.setBounds(181, 112, 225, 26);
		contentPane.add(BrandField);
		BrandField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Marka :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(35, 108, 144, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Anakart");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(256, 34, 74, 37);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Ram Soket Sayısı :");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(35, 165, 144, 28);
		contentPane.add(lblNewLabel_2);
		
		RamField = new JTextField();
		RamField.setColumns(10);
		RamField.setBounds(181, 169, 225, 26);
		contentPane.add(RamField);
		
		JLabel lblNewLabel_3 = new JLabel("Driver Soket Sayısı :");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(35, 223, 144, 28);
		contentPane.add(lblNewLabel_3);
		
		DriverField = new JTextField();
		DriverField.setColumns(10);
		DriverField.setBounds(181, 225, 225, 26);
		contentPane.add(DriverField);
		
		JButton btnNewButton = new JButton("Anakartı Ekle");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String brand = BrandField.getText();
				String driverSocket = DriverField.getText();
				int driverSocketCount= Integer.valueOf(driverSocket);
				String RamSocket = RamField.getText();
				int RamSocketCount= Integer.valueOf(RamSocket);
				anaKart anakart = new anaKart(brand , RamSocketCount , driverSocketCount);
				bag.TabloyaAnaKartEkle(anakart);
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(221, 285, 144, 42);
		contentPane.add(btnNewButton);
	}
}
