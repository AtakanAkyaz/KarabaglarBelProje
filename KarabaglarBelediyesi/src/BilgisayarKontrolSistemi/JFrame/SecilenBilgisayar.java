package BilgisayarKontrolSistemi.JFrame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;  

import BilgisayarKontrolSistemi.anaKart;
import BilgisayarKontrolSistemi.baglanti;
import BilgisayarKontrolSistemi.ekranKarti;
import BilgisayarKontrolSistemi.gucUnitesi;
import BilgisayarKontrolSistemi.islemci;
import BilgisayarKontrolSistemi.kasa;
import BilgisayarKontrolSistemi.ram;
import BilgisayarKontrolSistemi.saklamaAlani;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SecilenBilgisayar extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	static String girdi = null;
	static baglanti bag = null;
	static kasa kasa = null;
	static int id = 0;
	static anaKart eklenicekAnakart= null;
	static ekranKarti eklenicekEkranKarti= null;
	static gucUnitesi eklenicekGüçÜnitesi= null;
	static islemci eklenicekİşlemci= null;
	static ram eklenicekRAM= null;
	static saklamaAlani eklenicekSaklamaAlanı= null;
	static int year , month ;
	private JTable table;
	private JButton btnNewButton;
	public static void main(String[] args ,int gelenid ,  baglanti baglanti , String parçaİsmi , ArrayList<kasa> array) {
		bag=baglanti;
		girdi = parçaİsmi;
		bag = baglanti;
		id = gelenid ;
		for(int i = 0 ; i < array.size() ; i++) {
		if (id == array.get(i).getID()) {
			kasa = array.get(i);
			break;
		}
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Date date = new Date();
					LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
					year  = localDate.getYear();
					month = localDate.getMonthValue();
					SecilenBilgisayar frame = new SecilenBilgisayar();
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
	public SecilenBilgisayar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		scrollPane.setBounds(20, 53, 406, 300);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(girdi.equals("Anakart")) {
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					int seçiliSatır = table.getSelectedRow();
					String anakartMarka = (String) model.getValueAt(seçiliSatır, 0);
					int anakartDriver = (int) model.getValueAt(seçiliSatır, 1);
					int anakartRam = (int) model.getValueAt(seçiliSatır, 2);
					eklenicekAnakart = new anaKart(anakartMarka , anakartRam , anakartDriver);
					
					}
				else if(girdi.equals("Ekran Kartı")) {
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					int seçiliSatır = table.getSelectedRow();
					String ekranKartiMarka = (String) model.getValueAt(seçiliSatır, 0);
					int ekranKartiBellek= (int) model.getValueAt(seçiliSatır, 1);
					String ekranKartiTip = (String) model.getValueAt(seçiliSatır, 2);
					ekranKartiTip = ekranKartiTip.toLowerCase();
					int intEkranKartiTip =0 ;
					if(ekranKartiTip.equals("harici")) {
						intEkranKartiTip=1;
					}
					eklenicekEkranKarti = new ekranKarti(ekranKartiMarka , ekranKartiBellek , intEkranKartiTip);
				}
				else if(girdi.equals("Güç Ünitesi")) {
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					int seçiliSatır = table.getSelectedRow();
					String güçÜnitesiMarka = (String) model.getValueAt(seçiliSatır, 0);
					int güçÜnitesiWatt= (int) model.getValueAt(seçiliSatır, 1);
					eklenicekGüçÜnitesi = new gucUnitesi(güçÜnitesiMarka , güçÜnitesiWatt );
				}
				else if(girdi.equals("İşlemci")) {
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					int seçiliSatır = table.getSelectedRow();
					String islemciMarka = (String) model.getValueAt(seçiliSatır, 0);
					int islemciHiz= (int) model.getValueAt(seçiliSatır, 1);
					eklenicekİşlemci = new islemci(islemciMarka , islemciHiz );
				}
				else if(girdi.equals("RAM")) {
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					int seçiliSatır = table.getSelectedRow();
					String ramMarka = (String) model.getValueAt(seçiliSatır, 0);
					int ramHiz= (int) model.getValueAt(seçiliSatır, 1);
					int ramDDR= (int) model.getValueAt(seçiliSatır, 2);
					eklenicekRAM = new ram(ramMarka , ramHiz , ramDDR );
				}
				else if(girdi.equals("Saklama Alanı")) {
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					int seçiliSatır = table.getSelectedRow();
					String saklamaAlaniMarka = (String) model.getValueAt(seçiliSatır, 0);
					int sakalamAlaniKapasite = (int) model.getValueAt(seçiliSatır, 1);
					int yazmaHizi= (int) model.getValueAt(seçiliSatır, 2);
					int okumaHizi= (int) model.getValueAt(seçiliSatır, 3);
					String DDR= (String) model.getValueAt(seçiliSatır, 4);
					eklenicekSaklamaAlanı = new saklamaAlani(saklamaAlaniMarka , sakalamAlaniKapasite , yazmaHizi ,okumaHizi , DDR );
				}
			}
		});
		scrollPane.setViewportView(table);
		
		btnNewButton = new JButton("Ekle");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(girdi.equals("Anakart")) {
					bag.BilgisayaraAnaKartEkle(id, eklenicekAnakart, month, year);
					setVisible(false);
				}
				else if(girdi.equals("Ekran Kartı")) {
					bag.BilgisayaraEkranKartıEkle(id, eklenicekEkranKarti, month, year);
					setVisible(false);
				}
				else if(girdi.equals("Güç Ünitesi")) {
					bag.BilgisayaraGüçÜnitesiEkle(id, eklenicekGüçÜnitesi, month, year);
					setVisible(false);
				}
				else if(girdi.equals("İşlemci")) {
					bag.BilgisayaraİşlemciEkle(id, eklenicekİşlemci, month, year);
					setVisible(false);
				}
				else if(girdi.equals("RAM")) {
					bag.BilgisayaraRamEkle(id, eklenicekRAM, month, year);
					setVisible(false);
				}
				else if(girdi.equals("Saklama Alanı")) {
					bag.BilgisayaraSaklamaAlanıEkle(id, eklenicekSaklamaAlanı, month, year);
					setVisible(false);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(436, 274, 140, 68);
		contentPane.add(btnNewButton);
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.addColumn("Marka");
		if(girdi.equals("Anakart")) {
			ArrayList<anaKart> anakartArray = bag.TablodakiAnakartlarıGöster();
			model.addColumn("Driver Soket Sayısı");
			model.addColumn("RAM Soket Sayısı");
			for(int i= 0 ; i < anakartArray.size() ; i++) {
				Object[] eklenicekSatır = {anakartArray.get(i).getMarka(), anakartArray.get(i).getDriverSoketSayisi(), anakartArray.get(i).getRamSoketSayisi() };
				model.addRow(eklenicekSatır);
			}
		}
		else if(girdi.equals("Ekran Kartı")) {
			ArrayList<ekranKarti> ekranKartiArray = bag.TablodakiEkranKartlarınıGöster();
			model.addColumn("Ekran Kartı Boyutu");
			model.addColumn("Ekran Kartı Tipi");
			String tip = null;
			for(int i= 0 ; i < ekranKartiArray.size() ; i++) {
				if(ekranKartiArray.get(i).getBellekTipi() == 0) {
					tip = "Harici";
				}else {
					tip = "Dahili";
				}
				Object[] eklenicekSatır = {ekranKartiArray.get(i).getMarka(), ekranKartiArray.get(i).getBellekBoyutu(), tip };
				model.addRow(eklenicekSatır);
			}
		}
		else if(girdi.equals("Güç Ünitesi")) {
			ArrayList<gucUnitesi> gücÜnitesiArray = bag.TablodakiGüçÜniteleriniGöster();
			model.addColumn("Watt");
			for(int i= 0 ; i < gücÜnitesiArray.size() ; i++) {
				
				Object[] eklenicekSatır = {gücÜnitesiArray.get(i).getMarka(), gücÜnitesiArray.get(i).getWatt()};
				model.addRow(eklenicekSatır);
			}
		}
		else if(girdi.equals("İşlemci")) {
			ArrayList<islemci> islemciArray = bag.TablodakiİşlemcileriGetir();
			model.addColumn("Speed");
			for(int i= 0 ; i < islemciArray.size() ; i++) {
				Object[] eklenicekSatır = {islemciArray.get(i).getMarka(), islemciArray.get(i).getHiz()};
				model.addRow(eklenicekSatır);
			}
		}
		else if(girdi.equals("RAM")) {
			ArrayList<ram> RamArray = bag.TablodakiRamleriGöster();
			model.addColumn("Speed");
			model.addColumn("DDR");
			for(int i= 0 ; i < RamArray.size() ; i++) {
				Object[] eklenicekSatır = {RamArray.get(i).getMarka(), RamArray.get(i).getHiz(), RamArray.get(i).getDdr()};
				model.addRow(eklenicekSatır);
			}
		}
		else if(girdi.equals("Saklama Alanı")) {
			ArrayList<saklamaAlani> saklamaAlaniArray = bag.TablodakiSaklamaAlanlarınıGetir();
			model.addColumn("Sakalama Alanı");
			model.addColumn("Yazma Hızı");
			model.addColumn("Okuma Hızı");
			model.addColumn("Saklama Alanı Tipi");
			for(int i= 0 ; i < saklamaAlaniArray.size() ; i++) {
				Object[] eklenicekSatır = {saklamaAlaniArray.get(i).getMarka(), saklamaAlaniArray.get(i).getDepolamaAlani(), saklamaAlaniArray.get(i).getYazmaHizi(), saklamaAlaniArray.get(i).getOkumaHizi(), saklamaAlaniArray.get(i).getTip()};
				model.addRow(eklenicekSatır);
			}
		}
	}
}
