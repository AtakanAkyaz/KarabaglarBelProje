package BilgisayarKontrolSistemi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class baglanti {


	private String kullanıcıAdı = "root"; //varsayılan kullanıcı adı
	private String parola = ""; //varsayılan şifre
	private String db_ismi = "deneme"; //Data Base e verdiğimiz isim
	private String host = "localhost"; 
	private int port = 3306; //XAMPP control panelinde mysql in port u 
	private Connection con = null ;
	
	public baglanti() {
		String url = "jdbc:mysql://" + host + ":" + port + "/" + db_ismi;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			con = DriverManager.getConnection(url, kullanıcıAdı, parola);
			System.out.println("Bağlandı");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
 