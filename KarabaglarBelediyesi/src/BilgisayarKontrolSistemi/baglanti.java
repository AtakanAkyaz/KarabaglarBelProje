package BilgisayarKontrolSistemi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.mysql.cj.xdevapi.Statement;

public class baglanti {


	private String kullanıcıAdı = "root"; //varsayılan kullanıcı adı
	private String parola = ""; //varsayılan şifre
	private String db_ismi = "deneme"; //Data Base e verdiğimiz isim
	private String host = "localhost"; 
	String sorgu;
	private int port = 3306; //XAMPP control panelinde mysql in port u 
	private Connection con = null ;
	private java.sql.Statement statement = null;
	
	private java.sql.PreparedStatement preparedStatement = null;
	Scanner scan = new Scanner(System.in);
	
	
	public baglanti() {
		String url = "jdbc:mysql://" + host + ":" + port + "/" + db_ismi + "?useUniceode=true&characterEncoding=utf8";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			con = DriverManager.getConnection(url, kullanıcıAdı, parola);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void TabloyaAnaKartEkle(anaKart eklenicekAnakart) {
		sorgu = "Insert into motherboard (brand , ramSocketCount , driverSocketCount) Values ("+"'"+eklenicekAnakart.getMarka()	+"',"+"'"+eklenicekAnakart.getRamSoketSayisi()+"',"+"'"+eklenicekAnakart.getDriverSoketSayisi()+"')";
		try {
			statement = con.createStatement();
			statement.executeUpdate(sorgu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void TabloyaRamEkle(ram eklenicekRam) {
		sorgu = "Insert into ram (brand , speed , ddr) Values ("+"'"+eklenicekRam.getMarka()+"',"+"'"+eklenicekRam.getHiz()+"',"+"'"+eklenicekRam.getDdr()+"')";
		try {
			statement = con.createStatement();
			statement.executeUpdate(sorgu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void TabloyaEkranKartıEkle(ekranKarti eklenicekEkranKarti) {
		sorgu = "Insert into GPU (brand , memory , type) Values ("+"'"+eklenicekEkranKarti.getMarka()+"',"+"'"+eklenicekEkranKarti.getBellekBoyutu()+"',"+"'"+eklenicekEkranKarti.isBellekTipi()+"')";
		try {
			statement = con.createStatement();
			statement.executeUpdate(sorgu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void TabloyaGüçUnitesiEkle(gucUnitesi eklenicekGucUnitesi) {
		sorgu = "Insert into powerUnit (brand , watt) Values ("+"'"+eklenicekGucUnitesi.getMarka()+"',"+"'"+eklenicekGucUnitesi.getWatt()+"')";
		try {
			statement = con.createStatement();
			statement.executeUpdate(sorgu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void TabloyaİşlemciEkle(islemci eklenicekIslemci) {
		sorgu = "Insert into processor (brand , speed) Values ("+"'"+eklenicekIslemci.getMarka()+"',"+"'"+eklenicekIslemci.getHiz()+"')";
		try {
			statement = con.createStatement();
			statement.executeUpdate(sorgu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void TabloyaSaklamaAlanıEkle(saklamaAlani eklenicekSaklamaAlani) {
		sorgu = "Insert into memory (brand , Memory , readSpeed , writeSpeed ,  type) Values ("+"'"+eklenicekSaklamaAlani.getMarka()+"',"+"'"+eklenicekSaklamaAlani.getDepolamaAlani()+"',"+"'"+eklenicekSaklamaAlani.getOkumaHizi()+"',"+"'"+eklenicekSaklamaAlani.getYazmaHizi()+"',"+"'"+eklenicekSaklamaAlani.getTip()+"')";
		try {
			statement = con.createStatement();
			statement.executeUpdate(sorgu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public ArrayList TablodakiAnakartlarıGöster() {
		sorgu = "SELECT * FROM `motherboard`" ;
		ArrayList array = new ArrayList();
		try {
			statement = con.createStatement(); // SQL üzerinde sorgu yapabilmek için statement oluşturuyoruz
			ResultSet result = statement.executeQuery(sorgu); // oluşturduğumuz statement ile tabloya bir querry yolluyoruz geri dönütü resultSet olarak kaydediyoruz
			int counter = 1 ;
			while(result.next()) { // result set de dolaşmak için 
				int ramSoketSayisi = result.getInt("RamSocketCount"); // result set içindeki istenilen çekmek için tipini get ile alıp içine hangi sütun olduğunu yazıyoruz
				int driverSoketSayisi = result.getInt("DriverSocketCount");
				String marka = result.getString("Brand");
				System.out.println(counter + ". Marka: " + marka + " /Ram Soket Sayısı: " + ramSoketSayisi + " /Driver Soket Sayısı: " + driverSoketSayisi);
				counter++;
				anaKart anaKart = new anaKart(marka, ramSoketSayisi, driverSoketSayisi);
				array.add(anaKart);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return array;
	}
	
	public ArrayList TablodakiRamleriGöster() {
		sorgu = "SELECT * FROM `ram`" ;
		ArrayList array = new ArrayList();
		try {
			statement = con.createStatement(); // SQL üzerinde sorgu yapabilmek için statement oluşturuyoruz
			ResultSet result = statement.executeQuery(sorgu); // oluşturduğumuz statement ile tabloya bir querry yolluyoruz geri dönütü resultSet olarak kaydediyoruz
			int counter = 1;
			while(result.next()) { // result set de dolaşmak için 
				int hiz = result.getInt("Speed"); // result set içindeki istenilen çekmek için tipini get ile alıp içine hangi sütun olduğunu yazıyoruz
				int ddr = result.getInt("DDR");
				String marka = result.getString("Brand");
				System.out.println(counter + ". Marka: " + marka + " /Ram hızı: " + hiz + " /DDR: " + ddr);
				counter++;
				ram ram = new ram(marka, ddr, hiz);
				array.add(ram);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return array;
	}
	
	public ArrayList TablodakiEkranKartlarınıGöster() {
		sorgu = "SELECT * FROM `gpu`" ;
		ArrayList array = new ArrayList();
		try {
			statement = con.createStatement(); // SQL üzerinde sorgu yapabilmek için statement oluşturuyoruz
			ResultSet result = statement.executeQuery(sorgu); // oluşturduğumuz statement ile tabloya bir querry yolluyoruz geri dönütü resultSet olarak kaydediyoruz
			int counter = 1;
			while(result.next()) { // result set de dolaşmak için 
				int boyut = result.getInt("Memory"); // result set içindeki istenilen çekmek için tipini get ile alıp içine hangi sütun olduğunu yazıyoruz
				boolean tip = result.getBoolean("Type");
				String sTip;
				if(tip == false) {
					sTip = "Harici";
				}else {
					sTip = "Dahili";
				}
				String marka = result.getString("Brand");
				System.out.println(counter + ". Marka: " + marka + " /Ekran Kartı Boyutu: " + boyut + " /Ekran kartı tipi: " + sTip);
				counter++;
				ekranKarti ekranKartı = new ekranKarti(marka, tip, boyut);
				array.add(ekranKartı);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return array;
	}
	
	public ArrayList TablodakiGüçÜniteleriniGöster() {
		sorgu = "SELECT * FROM `powerunit`" ;
		ArrayList array = new ArrayList();
		try {
			statement = con.createStatement(); // SQL üzerinde sorgu yapabilmek için statement oluşturuyoruz
			ResultSet result = statement.executeQuery(sorgu); // oluşturduğumuz statement ile tabloya bir querry yolluyoruz geri dönütü resultSet olarak kaydediyoruz
			int counter = 1;
			while(result.next()) { // result set de dolaşmak için 
				double watt= result.getInt("watt"); // result set içindeki istenilen çekmek için tipini get ile alıp içine hangi sütun olduğunu yazıyoruz	
				String marka = result.getString("Brand");
				System.out.println(counter + ". Marka: " + marka + " /Watt: " + watt);
				counter++;
				gucUnitesi güçÜnitesi = new gucUnitesi(marka, watt);
				array.add(güçÜnitesi);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return array;
	}

	public ArrayList TablodakiİşlemcileriGetir() {
		sorgu = "SELECT * FROM `processor`" ;
		ArrayList array = new ArrayList();
		try {
			statement = con.createStatement(); // SQL üzerinde sorgu yapabilmek için statement oluşturuyoruz
			ResultSet result = statement.executeQuery(sorgu); // oluşturduğumuz statement ile tabloya bir querry yolluyoruz geri dönütü resultSet olarak kaydediyoruz
			int counter = 1;
			while(result.next()) { // result set de dolaşmak için 
				double hiz= result.getInt("Speed"); // result set içindeki istenilen çekmek için tipini get ile alıp içine hangi sütun olduğunu yazıyoruz	
				String marka = result.getString("Brand");
				System.out.println(counter + ". Marka: " + marka + " /İşlemci hızı: " + hiz);
				counter++;
				islemci işlemci = new islemci(marka, hiz);
				array.add(işlemci);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return array;
	}
	
	public ArrayList TablodakiSaklamaAlanlarınıGetir() {
		sorgu = "SELECT * FROM `memory`" ;
		ArrayList array = new ArrayList();
		try {
			statement = con.createStatement(); // SQL üzerinde sorgu yapabilmek için statement oluşturuyoruz
			ResultSet result = statement.executeQuery(sorgu); // oluşturduğumuz statement ile tabloya bir querry yolluyoruz geri dönütü resultSet olarak kaydediyoruz
			int counter = 1;
			while(result.next()) { // result set de dolaşmak için 
				int boyut = result.getInt("Memory"); // result set içindeki istenilen çekmek için tipini get ile alıp içine hangi sütun olduğunu yazıyoruz	
				int okumaHizi= result.getInt("ReadSpeed");
				int yazmaHizi= result.getInt("WriteSpeed");
				String marka = result.getString("Brand");
				String tip= result.getString("Type");
				System.out.println(counter + ". Marka: " + marka + " /Boyut: " + boyut + " /Okuma hızı: " + okumaHizi + " /Yazma hızı: " + yazmaHizi + " /Saklama alani tipi: " + tip);
				counter++;
				saklamaAlani sakalamaAlanı = new saklamaAlani(marka, boyut, yazmaHizi, okumaHizi, tip) ;
				array.add(sakalamaAlanı);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return array;
	}
	
	
	public void calisanlariGetir() {
		sorgu = "SELECT * FROM `users`" ;
		try {
			statement = con.createStatement(); // SQL üzerinde sorgu yapabilmek için statement oluşturuyoruz
			ResultSet result = statement.executeQuery(sorgu); // oluşturduğumuz statement ile tabloya bir querry yolluyoruz geri dönütü resultSet olarak kaydediyoruz
			while(result.next()) { // result set de dolaşmak için 
				int id = result.getInt("id"); // result set içindeki istenilen çekmek için tipini get ile alıp içine hangi sütun olduğunu yazıyoruz
				String ad = result.getString("name");
				String sifre = result.getString("password");
				String pozisyon = result.getString("flag");
				System.out.println("Ad " + ad + " Sifre " + sifre + " ID " + id + " Pozisyon " + pozisyon);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
 