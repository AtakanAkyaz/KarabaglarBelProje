package BilgisayarKontrolSistemi;

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
//		kullanici kullanici1 = new kullanici();
//		kullanici1.setFlag(false);
//		kullanici kullanici2 = new kullanici();
//		kullanici2.setFlag(true);
//		
//		
//		String adminDepoKullaniciAdi = "kBel";
//		String adminDepoSifre = "@dm!N123";
//		
//		String depoKullanıcıAdi = "Atakan";
//		String depoSifre = "123";
// Buraya Kadar
//		boolean flag = true ;
//		while (flag) {
//			System.out.println("Karabağlar Belediyesi Bilgi İşlem Yazılımına Hoş Geldiniz ...\n"
//					+ "Kullanıcı Adınızı Giriniz : ");
//			String kullaniciAdi = scan.next();
//			System.out.println("Şifrenizi Giriniz : ");
//			String sifre = scan.next();
//			System.out.println(kullaniciAdi + " " + sifre);
//			System.out.println(adminDepoKullaniciAdi + " " + adminDepoSifre);
////Normal kullanıcı girişi
//			if(depoKullanıcıAdi.equals(kullaniciAdi ) && depoSifre.equals(sifre)) {
//				System.out.println("Sisteme Hoş geldiniz");
//				KullaniciPaneli(kullanici1);
//			}
////Admin girişi
//			else if(adminDepoKullaniciAdi.equals(kullaniciAdi)  && adminDepoSifre.equals(sifre)) {
//				KullaniciPaneli(kullanici2);
//				
//			}
////Yanlış isim veya şifre kullanımı
//			else {
//				System.out.println("Girdiğiniz kullanıcı adı veya şifre yanlış\n"
//						+ "1- Tekrar denemek için\n"
//						+ "2- Çıkış yapmak için");
//				int input = scan.nextInt();
//				boolean tekrarFlag = true;
//				while (tekrarFlag) {
//					if(input == 2) {
//						System.out.println("Sistemden çıkış yapılıyor");
//						tekrarFlag = false;
//						flag = false;
//						break;
//					}
//					if (input == 1) {
//						tekrarFlag = false;
//						break;
//					}
//					if(input != 1 || input != 2) {
//						System.out.println("Lütfen geçerli bir seçeneği kullanınız");
//					}
//				}
//			}
//		}	
	}
	
	public static void KullaniciPaneli(kullanici kullanici) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Kullanıcı paneline hoş geldiniz\n"
				+ "1- Programları kontrol etmek için \n"
				+ "2- Kasa ile ilgili işlemler için ");
		int input = scan.nextInt();
		switch(input) {
		case 1:
//programları kontrol etme
			break;
		case 2:
//Kasa işlemleri , Bir kullanıcı alır kullanıcının admin olup olmamasına göre ileride kullanıcıya gösterilicek seçenekler şekillenir
			KasaIslemleri(kullanici);
			break;
		default:
			System.out.println("Lütfen geçerli olan seçimlerden birini kullanınız");
			break;
		}
	}
	
	public static void ProgramKontrolu() {
		
	}
	
	public static void KasaIslemleri(kullanici kullanici) {
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("İşlem yapıcağınız kasanın kodunu biliyorsanız lütfen yazınınız\nBilmiyorsanız 'ara' yazarak sistemdeki kasaları görüntüliyebilirsiniz");
			String girdi = scan.next();
//			if(girdi == kasaID database den çektiğimiz doğru ise){ kasa bilgileri gelicek
//				System.out.println("1- program ekle kaldır\n"
//						+ "2- parça ekle kaldır\n0- Kullanıcı paneline dönmek için");
//		// Admin olarak girildiği takdirde kasa ekleme ve kaldırma seçenekleri de kullanıcıya sunuluyor
//				if(kullanici.isFlag()) {
//					System.out.println("3- kasa ekle veya kaldır");
//				}
//				int input = scan.nextInt();
//				switch(input) {
//				case 1:
//					
//					break;
//				case 2:
//					
//					break;
//				case 3:
//					if(kullanici.isFlag()) {
//						
//					}else {
//						break;
//					}
//					break;
//				default :
//					System.out.println("Yanlış bir değer verdiniz");
//				}
//			}
			//else if(girdi == "ara" || girdi == "ARA" || girdi == "Ara") { databese de bulunan kasalar ve açıklamaları gelicek }
		}
	}
	
	public static void KasayaAnaKartEkle(baglanti bag) {
		anaKart kasayaEklenicekAnaKart = new anaKart();
		System.out.println("Ana kart markasısnı giriniz");
		String marka = scan.next();
		kasayaEklenicekAnaKart.setMarka(marka);
		System.out.println("Değişim ayını giriniz (1-12)");
		int ay = scan.nextInt();
		kasayaEklenicekAnaKart.setAy(ay);
		System.out.println("Değişim yılını giriniz (1900-2200)");
		int yıl = scan.nextInt();
		kasayaEklenicekAnaKart.setYıl(yıl);
		System.out.println("Ram soket sayısını giriniz");
		int ramSoketSayısı = scan.nextInt();
		kasayaEklenicekAnaKart.setRamSoketSayisi(ramSoketSayısı);;
		System.out.println("Driver soket sayısını giriniz");
		int driverSoketSayısı = scan.nextInt();
		kasayaEklenicekAnaKart.setDriverSoketSayisi(driverSoketSayısı);
		// kasaya eklenicek bag.TabloyaAnaKartEkle(kasayaEklenicekAnaKart);
	}
	
	public static void KasayaRamEkle(baglanti bag) {
		ram kasayaEklenicekRam = new ram();
		System.out.println("Ram markasısnı giriniz");
		String marka = scan.next();
		kasayaEklenicekRam.setMarka(marka);
		System.out.println("Değişim ayını giriniz (1-12)");
		int ay = scan.nextInt();
		kasayaEklenicekRam.setAy(ay);
		System.out.println("Değişim yılını giriniz (1900-2200)");
		int yıl = scan.nextInt();
		kasayaEklenicekRam.setYıl(yıl);
		System.out.println("Ram hızını giriniz");
		int hiz = scan.nextInt();
		kasayaEklenicekRam.setHiz(hiz);;
		System.out.println("Ram in DDR ını giriniz");
		int ddr = scan.nextInt();
		// kasaya eklenicek kasayaEklenicekRam.setDdr(ddr);
	}
	
}
