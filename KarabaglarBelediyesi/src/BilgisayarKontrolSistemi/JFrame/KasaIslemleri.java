package BilgisayarKontrolSistemi.JFrame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BilgisayarKontrolSistemi.baglanti;
import BilgisayarKontrolSistemi.kasa;

import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class KasaIslemleri extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	static int ID = 0;
	static String girdi = null;
	static baglanti bag = null;
	static ArrayList<kasa> array = new ArrayList();
	private JTable table;
	private JScrollPane scrollPane;
	private JTable table_1;
	private JComboBox comboBox;
	
	public static void main(String[] args , baglanti baglanti) {
		bag = baglanti;
		array = bag.TablodakiBilgisayarlarıGetir();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KasaIslemleri frame = new KasaIslemleri();
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
	public KasaIslemleri() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		int sizeOfArray = array.size();
		
		
		JButton secimNewButton = new JButton("Bilgisayarı Seç");
		secimNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				SecilenBilgisayar.main(null,ID , bag, girdi , array);
			}
		});
		
		secimNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		secimNewButton.setBounds(306, 246, 190, 88);
		contentPane.add(secimNewButton);
		
		JLabel lblNewLabel = new JLabel("Bilgisayarlar");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(234, 10, 116, 46);
		contentPane.add(lblNewLabel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 54, 225, 280);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel) table_1.getModel();
				int seçiliSatır = table_1.getSelectedRow();
				
				ID = (int) model.getValueAt(seçiliSatır, 0);
			}
		});
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Seri No"
			}
		));
		scrollPane.setViewportView(table_1);
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				girdi = (String) comboBox.getSelectedItem();
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Anakart", "Ekran Kartı", "Güç Ünitesi", "İşlemci", "RAM", "Saklama Alanı"}));
		comboBox.setToolTipText("Eklenicek parçayı seçin");
		comboBox.setBounds(306, 140, 190, 46);
		contentPane.add(comboBox);
		DefaultTableModel model = (DefaultTableModel) table_1.getModel();
		for(int i= 0 ; i < sizeOfArray ; i++) {
			Object[] eklenicekSatır = {array.get(i).getID(), array.get(i).getSeriNumarası()};
			model.addRow(eklenicekSatır);
		}
	}
}
