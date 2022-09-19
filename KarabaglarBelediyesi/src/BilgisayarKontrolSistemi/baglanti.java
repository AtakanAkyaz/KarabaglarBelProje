package BilgisayarKontrolSistemi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
		sorgu = "Insert into motherboard (brand , month , year , ramSocketCount , driverSocketCount) Values ("+"'"+eklenicekAnakart.getMarka()+"',"+"'"+eklenicekAnakart.getAy()+"',"+"'"+eklenicekAnakart.getYıl()+"',"+"'"+eklenicekAnakart.getRamSoketSayisi()+"',"+"'"+eklenicekAnakart.getDriverSoketSayisi()+"')";
		try {
			statement = con.createStatement();
			statement.executeUpdate(sorgu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void TabloyaRamEkle(ram eklenicekRam) {
		sorgu = "Insert into ram (brand , month , year , speed , ddr) Values ("+"'"+eklenicekRam.getMarka()+"',"+"'"+eklenicekRam.getAy()+"',"+"'"+eklenicekRam.getYıl()+"',"+"'"+eklenicekRam.getHiz()+"',"+"'"+eklenicekRam.getDdr()+"')";
		try {
			statement = con.createStatement();
			statement.executeUpdate(sorgu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
				System.out.println("Ad " + ad + "\nSifre " + sifre + "\nID " + id + "\nPozisyon " + pozisyon);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
 