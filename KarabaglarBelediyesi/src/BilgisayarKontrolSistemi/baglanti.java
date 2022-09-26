package BilgisayarKontrolSistemi;

import java.math.BigDecimal;
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
//Tabloya veri ekleme işlemleri
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
//Tablodan veri alma işlemleri
	public ArrayList TablodaBulunanBilgisayarlarınIDleri() {
		sorgu = "SELECT ID FROM `computers` ";
		ArrayList array = new ArrayList();
		try {
			statement = con.createStatement();
			ResultSet result = statement.executeQuery(sorgu);
			while(result.next()) {
				int bilgisayarID = result.getInt("ID");
				array.add(bilgisayarID);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return array;
	}
	
	public ArrayList TablodakiBilgisayarlarıGetir() {
		sorgu = "SELECT * FROM `computers`" ;
		ArrayList array = new ArrayList();
		try {
			statement = con.createStatement(); // SQL üzerinde sorgu yapabilmek için statement oluşturuyoruz
			ResultSet result = statement.executeQuery(sorgu); // oluşturduğumuz statement ile tabloya bir querry yolluyoruz geri dönütü resultSet olarak kaydediyoruz
			while(result.next()) { // result set de dolaşmak için 
				int bilgisayarID = result.getInt("ID"); // result set içindeki istenilen çekmek için tipini get ile alıp içine hangi sütun olduğunu yazıyoruz
				BigDecimal bilgisayarSeriNo = result.getBigDecimal("SerialNumber");
				System.out.println("Bilgisayarın ID si: " + bilgisayarID + ". Bilgisayarın seri numarası: " + bilgisayarSeriNo);
				kasa kasa = new kasa(bilgisayarID);
				array.add(kasa);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return array;
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
				int tip = result.getInt("Type");
				String sTip;
				if(tip == 0) {
					sTip = "Harici";
				}else {
					sTip = "Dahili";
				}
				String marka = result.getString("Brand");
				System.out.println(counter + ". Marka: " + marka + " /Ekran Kartı Boyutu: " + boyut + " /Ekran kartı tipi: " + sTip);
				counter++;
				ekranKarti ekranKartı = new ekranKarti(marka, boyut , tip);
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
				double hiz= result.getDouble("Speed"); // result set içindeki istenilen çekmek için tipini get ile alıp içine hangi sütun olduğunu yazıyoruz	
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
//Boş bilgisayar oluşturma/kaldırma
	public kasa BilgisayarOluştur() {
		try {
			System.out.println("Sisteme eklenicek bilgisayarın Seri Numarasını giriniz.");
			BigDecimal serialNo = scan.nextBigDecimal();
			PreparedStatement statement = con.prepareStatement("Insert into computers () Values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			statement.setBigDecimal(1, null);
			statement.setInt(2, 0);
			statement.setInt(3, 0);
			statement.setString(4, "");
			statement.setInt(5, 0);
			statement.setInt(6, 0);
			statement.setInt(7, 0);
			statement.setInt(8, 0);
			statement.setString(9, "");
			statement.setDouble(10, 0);
			statement.setInt(11, 0);
			statement.setInt(12, 0);
			statement.setString(13, "");
			statement.setInt(14, 0);
			statement.setInt(15, 0);
			statement.setInt(16, 0);
			statement.setInt(17, 0);
			statement.setString(18, "");
			statement.setInt(19, 0);
			statement.setInt(20, 0);
			statement.setInt(21, 0);
			statement.setString(22, "");
			statement.setInt(23, 0);
			statement.setInt(24, 0);
			statement.setString(25, "");
			statement.setInt(26, 0);
			statement.setBoolean(27, false);
			statement.setInt(28, 0);
			statement.setInt(29, 0);
			statement.setString(30, "");
			statement.setDouble(31, 0);	
			statement.setBigDecimal(32, serialNo);
			statement.executeUpdate();
			System.out.println("Kasa başarı ile sisteme eklendi");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int id = 0;
		sorgu = "SELECT ID FROM `computers`" ;
		try {
			statement = con.createStatement();
			ResultSet result = statement.executeQuery(sorgu); 
			while(result.next()) {
				id = result.getInt("ID");
			}
			//id yi burda çekersen zaten en sonda eklenmiş olan id gelicek 
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		kasa kasa = new kasa(id);
		return kasa;
	}

	public void BilgisayarKaldır() {
		TablodakiBilgisayarlarıGetir();
		System.out.println("****************************************************************************************************");
		System.out.println("Kaldırmak istediğiniz bilgisayarın ID sini giriniz");
		int id = scan.nextInt();
		try {
			String sorgu = "DELETE FROM `computers` WHERE ID="+id;
			statement = con.createStatement();
			statement.executeUpdate(sorgu);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
//Bilgisayarın içini doldurma
	public void BilgisayaraAnaKartEkle (int kasaID,anaKart anaKart ,int ay , int yıl) {
		try{
			PreparedStatement statement = con.prepareStatement("UPDATE `computers` SET `MotherBoardBrand`=? , `MotherBoardChangeMonth`=? , `MotherBoardChangeYear`=? , `MotherBoardRamSocketCount`=? , `MotherBoardDriverSocketCount`=? WHERE ID="+kasaID);
			statement.setString(1, anaKart.getMarka());
			statement.setInt(2, ay);
			statement.setInt(3, yıl);
			statement.setInt(4, anaKart.getRamSoketSayisi());
			statement.setInt(5, anaKart.getDriverSoketSayisi());
			statement.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void BilgisayaraRamEkle (int kasaID , ram Ram , int ay , int yıl) {
		try {
			PreparedStatement statement = con.prepareStatement("UPDATE `computers` SET `RAMBrand`=? , `RAMChangeMonth`=? , `RAMChangeYear`=? , `RAMSpeed`=? , `RAMDDR`=? WHERE ID="+kasaID);
			statement.setString(1, Ram.getMarka());
			statement.setInt(2, ay);
			statement.setInt(3, yıl);
			statement.setInt(4, Ram.getHiz());
			statement.setInt(5, Ram.getDdr());
			statement.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public void  BilgisayaraİşlemciEkle(int kasaID,islemci işlemci,int ay , int yıl) {
		try {
			PreparedStatement statement = con.prepareStatement("UPDATE `computers` SET `ProcessorBrand`=? , `ProcessorChangeMonth`=? , `ProcessorChangeYear`=? , `ProcessorSpeed`=? WHERE ID="+kasaID);
			statement.setString(1, işlemci.getMarka());
			statement.setInt(2, ay);
			statement.setInt(3, yıl);
			statement.setDouble(4, işlemci.getHiz());
			statement.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public void BilgisayaraGüçÜnitesiEkle (int kasaID , gucUnitesi güçÜnitesi ,int ay ,int yıl) {
		try {
			PreparedStatement statement = con.prepareStatement("UPDATE `computers` SET `PowerUnitBrand`=? , `PowerUnitChangeMonth`=? , `PowerUnitChangeYear`=? , `PowerUnitWatt`=? WHERE ID="+kasaID);
			statement.setString(1, güçÜnitesi.getMarka());
			statement.setInt(2, ay);
			statement.setInt(3, yıl);
			statement.setDouble(4, güçÜnitesi.getWatt());
			statement.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public void BilgisayaraEkranKartıEkle (int kasaID , ekranKarti ekranKartı , int ay , int yıl) {
		try {
			PreparedStatement statement = con.prepareStatement("UPDATE `computers` SET `GPUBrand`=? , `GPUChangeMonth`=? , `GPUChangeYear`=? , `GPUMemory`=? ,  `GPUType`=? WHERE ID="+kasaID);
			statement.setString(1, ekranKartı.getMarka());
			statement.setInt(2, ay);
			statement.setInt(3, yıl);
			statement.setInt(4, ekranKartı.getBellekBoyutu());
			statement.setInt(5, ekranKartı.getBellekTipi());
			statement.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public void BilgisayaraSaklamaAlanıEkle (int kasaID , saklamaAlani saklamaAlanı,int ay ,int yıl) {
		try {
			PreparedStatement statement = con.prepareStatement("UPDATE `computers` SET `MemoryBrand`=? , `MemoryChangeMonth`=? , `MemoryChangeYear`=? , `MemoryCapacity`=? , `MemoryReadSpeed`=? , `MemoryWriteSpeed`=? , `MemoryType`=? WHERE ID="+kasaID);
			statement.setString(1, saklamaAlanı.getMarka());
			statement.setInt(2, ay);
			statement.setInt(3, yıl);
			statement.setInt(4, saklamaAlanı.getDepolamaAlani());
			statement.setInt(5, saklamaAlanı.getOkumaHizi());
			statement.setInt(6, saklamaAlanı.getYazmaHizi());
			statement.setString(7, saklamaAlanı.getTip());
			statement.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
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
 