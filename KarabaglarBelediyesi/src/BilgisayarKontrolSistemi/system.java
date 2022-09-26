package BilgisayarKontrolSistemi;

import java.awt.TextField;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

import com.mysql.cj.xdevapi.Statement;

//scan.nextInt() den sonra gelen .nextLine() java üzerinde çalışmadığı için 1 tane boş .nextLine() atılır
public class system { 

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		
//SQL denemeleri buradan başlıyor ------------------------------------------------------------------------------------------------------------------------
		baglanti bag = new baglanti();
		ArrayList arr = new ArrayList();
//		arr = bag.TablodakiGüçÜniteleriniGöster();
		// gelen arraylist deki objelere bakma
//		for (int i = 0 ; i< arr.size() ; i++) {
//			gucUnitesi a = (gucUnitesi) arr.get(i);
//			System.out.println(a.getMarka());
//			System.out.println(a.getWatt());
//		}
		// gelen arraylist den obje seçme
//		System.out.println("Güç ünitesi seç");
//		int secim = scan.nextInt();
//		gucUnitesi güç = (gucUnitesi) arr.get(secim-1);
//		System.out.println(güç.getMarka());
//		System.out.println(güç.getWatt());
		
//SQL denemeleri burada biyiyor ------------------------------------------------------------------------------------------------------------------------
		

	

// 41- 52 ileride kalkıcak ve database den kontrol edilicek
// Buradan
		kullanici kullanici1 = new kullanici();
		kullanici1.setFlag(false);
		kullanici kullanici2 = new kullanici();
		kullanici2.setFlag(true);
		
		
		String adminDepoKullaniciAdi = "kBel";
		String adminDepoSifre = "@dm!N123";
		
		String depoKullanıcıAdi = "Atakan";
		String depoSifre = "123";
// Buraya Kadar
		boolean flag = true ;
		while (flag) {
			System.out.println("Karabağlar Belediyesi Bilgi İşlem Yazılımına Hoş Geldiniz ...\n"
					+ "Kullanıcı Adınızı Giriniz : ");
			String kullaniciAdi = scan.next();
			System.out.println("Şifrenizi Giriniz : ");
			String sifre = scan.next();
//Normal kullanıcı girişi
			if(depoKullanıcıAdi.equals(kullaniciAdi ) && depoSifre.equals(sifre)) {
				System.out.println("Sisteme Hoş geldiniz");
//Giriş yapan kullanıcıya göre çıktı farklı olacağı için kullanıcı objesini "KullaniciPaneli" ne yolluyoruz
				KullaniciPaneli(kullanici1,bag);
			}
//Admin girişi
			else if(adminDepoKullaniciAdi.equals(kullaniciAdi)  && adminDepoSifre.equals(sifre)) {
				System.out.println("Sisteme Hoş geldiniz");
//Giriş yapan kullanıcıya göre çıktı farklı olacağı için kullanıcı objesini "KullaniciPaneli" ne yolluyoruz
				KullaniciPaneli(kullanici2,bag);
				
			}
//Yanlış isim veya şifre kullanımı
			else {
				System.out.println("Girdiğiniz kullanıcı adı veya şifre yanlış\n"
						+ "1- Tekrar denemek için\n"
						+ "2- Çıkış yapmak için");
				int input = scan.nextInt();
				boolean tekrarFlag = true;
				while (tekrarFlag) {
					if(input == 2) {
						System.out.println("Sistemden çıkış yapılıyor");
						tekrarFlag = false;
						flag = false;
						break;
					}
					if (input == 1) {
						tekrarFlag = false;
						break;
					}
					if(input != 1 || input != 2) {
						System.out.println("Lütfen geçerli bir seçeneği kullanınız");
					}
				}
			}
		}	
	}
	
	public static void KullaniciPaneli(kullanici kullanici, baglanti bag) {
		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		while(flag) {
		System.out.println("Kullanıcı paneline hoş geldiniz\n"
				+ "1- Programları kontrol etmek için \n"
				+ "2- Kasa ile ilgili işlemler için \n"
				+ "3- Sisteme parça eklemek için\n"
				+ "0- Kullanıcı çıkışı yapmak için");
		int input = scan.nextInt();
		switch(input) {
		case 1:
//programları kontrol etme
			ProgramKontrolu();
			break;
		case 2:
//Kasa işlemleri , Bir kullanıcı alır kullanıcının admin olup olmamasına göre ileride kullanıcıya gösterilicek seçenekler şekillenir
			KasaIslemleri(kullanici , bag);
			break;
		case 3:
			DataBaseEParcaEkleme(bag);
			break;
		case 0:
			flag = false ;
			break;
		default:
			System.out.println("Lütfen geçerli olan seçimlerden birini kullanınız");
			break;
			}
		}
	}

	public static void ProgramKontrolu() {
		// kontrol ederken program ekliyip çıkarmayı manuel yapmasın kontrol edip baktığında bulduklarını sisteme eklesin bulamadıklarını sistemden çıkartsın
	}
	
	public static void KasaIslemleri(kullanici kullanici , baglanti bag) {
		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		while(flag) {
			System.out.println("İşlem yapıcağınız kasanın kodunu biliyorsanız lütfen yazınınız\nBilmiyorsanız 'ara' yazarak sistemdeki kasaları görüntüliyebilirsiniz");
			if(kullanici.isFlag()) {
				System.out.println("Kasa eklemek için 'ekle'\nKasa kaldırmak için 'kaldır' yazınız");
			}
			System.out.println("Çıkış yapmak için 'çıkış' yazınız");
// Tablodaki bilgisayar ID lerini array e kaydetme
			ArrayList array = bag.TablodaBulunanBilgisayarlarınIDleri();
			String girdi = scan.next();
			if(girdi.equals("ara")|| girdi.equals("ARA")|| girdi.equals("Ara")){ 
				bag.TablodakiBilgisayarlarıGetir();
				break;
			}
			else if(girdi.equals("çıkış")|| girdi.equals("ÇIKIŞ")|| girdi.equals("Çıkış")){ 
				flag = false;
				break;
			}
			else if(kullanici.isFlag() && girdi.equals("ekle")||girdi.equals("EKLE")||girdi.equals("Ekle")) {
				bag.BilgisayarOluştur();
				break;
			}
			else if(kullanici.isFlag() && girdi.equals("kaldır")||girdi.equals("KALDIR")||girdi.equals("Kaldır")) {
				bag.BilgisayarKaldır();
				break;
			}
			
			int kasaID = -1;
			try {
				kasaID = Integer.valueOf(girdi);
			}catch(Exception e) {
				System.out.println(e);
			}
			
// Tablodan alınan ID lerin kaydedildiği array in içinde girilen değerin olup olmadığı sorgulanıyor
			if(array.contains(kasaID)){ 
				System.out.println("1- program ekle kaldır\n"
						+ "2- parça ekle kaldır");
				System.out.println("0- Çıkış yapıp giriş paneline dönmek için");
				int input = scan.nextInt();
				switch(input) {
				case 1:
					
					break;
				case 2:
					KasayaParcaEkle(bag , kasaID);
					break;
				case 0 :
					System.out.println("Kullanıcı paneline dönülüyor");
					flag = false;
					break;
				default :
					System.out.println("Yanlış bir değer verdiniz");
					break;
				}
			}
//Giriş yapan kullanıcı admin statüsüne sahip ise ve "ara" veya "ekle" veya "kaldır" gibi 
//bir giriş yaptıysa uygulanıcak komutlar
			
			else {
				System.out.println("Yanlış bir değer verdiniz");
			}
		}
	}
//SQL "computers" tablosuna ekleme işlemleri
	public static void KasayaParcaEkle(baglanti bag , int kasaID) {
		boolean flag = true;
		while(flag) {
		System.out.println("Kasaya eklemek istediğiniz parçayı seçiniz\n"
				+ "1- Anakart ekle\n"
				+ "2- Ram ekle\n"
				+ "3- Ekran kartı ekle\n"
				+ "4- Güç ünitesi ekle\n"
				+ "5- İşlemci ekle\n"
				+ "6- Saklama alanı ekle\n"
				+ "0- Çıkış için ");
		int girdi = scan.nextInt();
		switch (girdi) {
		case 1:
			KasayaAnaKartEkle(bag , kasaID);
			break;
		case 2:
			KasayaRamEkle(bag , kasaID);
			break;
		case 3:
			KasayaEkranKartiEkle(bag , kasaID);
			break;
		case 4:
			KasayaGucUnitesiEkle(bag , kasaID);
			break;
		case 5:
			KasayaIslemciEkle(bag , kasaID);
			break;
		case 6:
			KasayaSaklamaAlaniEkle(bag , kasaID);
			break;
		case 0:
			flag = false;
			break;
		default:
			System.out.println("Yanlış bir değer girdiniz");
			break;
			}
		}
	}
	
	public static void KasayaAnaKartEkle(baglanti bag , int kasaID) {

		System.out.println("Değişim ayını giriniz (1-12)");
		int ay = scan.nextInt();
		System.out.println("Değişim yılını giriniz (1900-2200)");
		int yıl = scan.nextInt();
		ArrayList ar = bag.TablodakiAnakartlarıGöster();
		System.out.println("Eklemek istediğiniz anakartı seçin");
		int input = scan.nextInt();
		anaKart eklenicekAnaKart = (anaKart) ar.get(input-1);
		bag.BilgisayaraAnaKartEkle(kasaID, eklenicekAnaKart , ay , yıl);
	}
	
	public static void KasayaEkranKartiEkle(baglanti bag , int kasaID) {
		System.out.println("Değişim ayını giriniz (1-12)");
		int ay = scan.nextInt();
		System.out.println("Değişim yılını giriniz (1900-2200)");
		int yıl = scan.nextInt();
		ArrayList ar = bag.TablodakiEkranKartlarınıGöster();
		System.out.println("Eklemek istediğiniz ekran kartını seçin");
		int input = scan.nextInt();
		ekranKarti eklenicekEkranKartı = (ekranKarti) ar.get(input-1);
		bag.BilgisayaraEkranKartıEkle(kasaID, eklenicekEkranKartı , ay , yıl);
	}
	
	public static void KasayaIslemciEkle(baglanti bag , int kasaID) {
		System.out.println("Değişim ayını giriniz (1-12)");
		int ay = scan.nextInt();
		System.out.println("Değişim yılını giriniz (1900-2200)");
		int yıl = scan.nextInt();
		ArrayList ar = bag.TablodakiİşlemcileriGetir();
		System.out.println("Eklemek istediğiniz işlemciyi seçin");
		int input = scan.nextInt();
		islemci eklenicekİşlemci= (islemci) ar.get(input-1);
		bag.BilgisayaraİşlemciEkle(kasaID, eklenicekİşlemci, ay , yıl);
	}
	
	public static void KasayaRamEkle(baglanti bag , int kasaID) {
		System.out.println("Değişim ayını giriniz (1-12)");
		int ay = scan.nextInt();
		System.out.println("Değişim yılını giriniz (1900-2200)");
		int yıl = scan.nextInt();
		ArrayList ar = bag.TablodakiRamleriGöster();
		System.out.println("Eklemek istediğiniz Ram i seçin");
		int input = scan.nextInt();
		ram eklenicekRam= (ram) ar.get(input-1);
		bag.BilgisayaraRamEkle(kasaID, eklenicekRam, ay , yıl);
	}

	public static void KasayaGucUnitesiEkle(baglanti bag , int kasaID) {
		System.out.println("Değişim ayını giriniz (1-12)");
		int ay = scan.nextInt();
		System.out.println("Değişim yılını giriniz (1900-2200)");
		int yıl = scan.nextInt();
		ArrayList ar = bag.TablodakiGüçÜniteleriniGöster();
		System.out.println("Eklemek istediğiniz güç ünitesini seçin");
		int input = scan.nextInt();
		gucUnitesi eklenicekGüçÜnitesi= (gucUnitesi) ar.get(input-1);
		bag.BilgisayaraGüçÜnitesiEkle(kasaID, eklenicekGüçÜnitesi, ay , yıl);
	}
	
	public static void KasayaSaklamaAlaniEkle(baglanti bag , int kasaID) {
		System.out.println("Değişim ayını giriniz (1-12)");
		int ay = scan.nextInt();
		System.out.println("Değişim yılını giriniz (1900-2200)");
		int yıl = scan.nextInt();
		ArrayList ar = bag.TablodakiSaklamaAlanlarınıGetir();
		System.out.println("Eklemek istediğiniz saklama alanını seçin");
		int input = scan.nextInt();
		saklamaAlani eklenicekSaklamaAlanı= (saklamaAlani) ar.get(input-1);
		bag.BilgisayaraSaklamaAlanıEkle(kasaID, eklenicekSaklamaAlanı, ay , yıl);
	}
//SQL Tablosuna ekleme işlemleri
	//Data Base e parça eklemek için bir tablo ile ne eklemek istediklerinin sorulduğu kısım
	public static void DataBaseEParcaEkleme(baglanti bag) {
		boolean flag = true;
		while(flag) {
		System.out.println("Databese e eklemek istediğiniz parçayı seçiniz\n"
				+ "1- Anakart ekle\n"
				+ "2- Ram ekle\n"
				+ "3- Ekran kartı ekle\n"
				+ "4- Güç ünitesi ekle\n"
				+ "5- İşlemci ekle\n"
				+ "6- Saklama alanı ekle\n"
				+ "0- Çıkış için ");
		int girdi = scan.nextInt();
		switch(girdi) {
		case 1:
			TabloyaAnaKartEkle(bag);
			break;
		case 2: 
			TabloyaRamEkle(bag);
			break;
		case 3:
			TabloyaEkranKartiEkleme(bag);
			break;
		case 4:
			TabloyaGucUnitesiEkleme(bag);
			break;
		case 5:
			TabloyaIslemciEkleme(bag);
			break;
		case 6:
			TabloyaSaklamaAlaniEkleme(bag);
			break;
		case 0:
			flag = false;
			break;
		default:
			System.out.println("Geçerli olmayan bir değer girdiniz");
		break;
			}
		}
	}
	
	public static void TabloyaAnaKartEkle(baglanti bag) {
		anaKart tabloyaEklenicekAnaKart = new anaKart();
		System.out.println("Ana kart markasısını giriniz");
		String marka = scan.next();
		tabloyaEklenicekAnaKart.setMarka(marka);
		System.out.println("Ana kartın ram soket sayısınız");
		int ramSoketSayısı= scan.nextInt();
		tabloyaEklenicekAnaKart.setRamSoketSayisi(ramSoketSayısı);
		System.out.println("Ana kartın driver soket sayısınız");
		int driverSoketSayısı= scan.nextInt();
		tabloyaEklenicekAnaKart.setDriverSoketSayisi(driverSoketSayısı);
		bag.TabloyaAnaKartEkle(tabloyaEklenicekAnaKart);
	}
	
	public static void TabloyaRamEkle(baglanti bag) {
		ram tabloyaEklenicekRam = new ram();
		System.out.println("RAM markasısını giriniz");
		String marka = scan.next();
		tabloyaEklenicekRam.setMarka(marka);
		System.out.println("RAM in DDR ını giriniz");
		int ddr = scan.nextInt();
		tabloyaEklenicekRam.setDdr(ddr);
		System.out.println("RAM in hızını giriniz");
		int hiz = scan.nextInt();
		tabloyaEklenicekRam.setHiz(hiz);
		bag.TabloyaRamEkle(tabloyaEklenicekRam);
	}
	
	public static void TabloyaEkranKartiEkleme(baglanti bag) {
		ekranKarti tabloyaEklenicekEkranKartı = new ekranKarti();
		System.out.println("Ekran kartı markasısını giriniz");
		String marka = scan.next();
		tabloyaEklenicekEkranKartı.setMarka(marka);
		System.out.println("Ekran kartının bellek boyutunu yazınız");
		int bellekBoyutu = scan.nextInt();
		tabloyaEklenicekEkranKartı.setBellekBoyutu(bellekBoyutu);
		int bellekTipiBoolean= 0;
		boolean flag = true;
		while(flag) {
			System.out.println("Ekran kartı harici ise 'harici', dahili ise 'dahili' yazınız");
			String bellekTipi = scan.next();
			
			if(bellekTipi.equals("harici")) {
				bellekTipiBoolean = 0;
				flag = false;
			}
			else if(bellekTipi.equals("dahili")) {
				bellekTipiBoolean = 1;
				flag = false;
			}
			else {
				System.out.println("Yanlış bir giriş yaptınız");
			}
		}
		tabloyaEklenicekEkranKartı.setBellekTipi(bellekTipiBoolean);
		bag.TabloyaEkranKartıEkle(tabloyaEklenicekEkranKartı);
	}

	public static void TabloyaGucUnitesiEkleme(baglanti bag) {
		gucUnitesi tabloyaEklenicekGüçÜnitesi = new gucUnitesi();
		System.out.println("Güç ünitesinin markasısını giriniz");
		String marka = scan.next();
		tabloyaEklenicekGüçÜnitesi.setMarka(marka);
		System.out.println("Güç ünitesinin enerji seviyesini watt cinsinden giriniz");
		int watt = scan.nextInt();
		tabloyaEklenicekGüçÜnitesi.setWatt(watt);
		bag.TabloyaGüçUnitesiEkle(tabloyaEklenicekGüçÜnitesi);
	}
	
	public static void TabloyaIslemciEkleme(baglanti bag) {
		islemci tabloyaEklenicekİşlemci = new islemci();
		System.out.println("İşlmecinin markasısını giriniz");
		String marka = scan.next();
		tabloyaEklenicekİşlemci.setMarka(marka);
		System.out.println("İşlemcinin hızını giriniz");
		double hiz = scan.nextDouble();
		tabloyaEklenicekİşlemci.setHiz(hiz);
		bag.TabloyaİşlemciEkle(tabloyaEklenicekİşlemci);
	}
	
	public static void TabloyaSaklamaAlaniEkleme(baglanti bag) {
		saklamaAlani tabloyaEklenicekSakalmaAlanı = new saklamaAlani();
		System.out.println("Sakalma alanının markasısını giriniz");
		String marka = scan.next();
		tabloyaEklenicekSakalmaAlanı.setMarka(marka);
		System.out.println("Saklama alanının depo kapasitesini yazınız");
		int depolamaAlani = scan.nextInt();
		tabloyaEklenicekSakalmaAlanı.setDepolamaAlani(depolamaAlani);
		System.out.println("Saklama alanının yazma hızını giriniz");
		int yazmaHizi = scan.nextInt();
		tabloyaEklenicekSakalmaAlanı.setYazmaHizi(yazmaHizi);
		System.out.println("Saklama alanının okuma hızını giriniz");
		int okumaHizi = scan.nextInt();
		tabloyaEklenicekSakalmaAlanı.setOkumaHizi(okumaHizi);
		String saklamaAlaniTipi = null;
		boolean flag = true;
		while(flag) {
			System.out.println("Saklama alanı tipi hdd ise 'hdd' ssd ise 'ssd' yazınız ");
			saklamaAlaniTipi = scan.next();
			
			if(saklamaAlaniTipi.equals("hdd")) {
				flag = false;
			}
			else if(saklamaAlaniTipi.equals("ssd")) {
				flag = false;
			}
			else {
				System.out.println("Yanlış bir giriş yaptınız");
			}
		}
		tabloyaEklenicekSakalmaAlanı.setTip(saklamaAlaniTipi);
		bag.TabloyaSaklamaAlanıEkle(tabloyaEklenicekSakalmaAlanı);
	}
}

	
