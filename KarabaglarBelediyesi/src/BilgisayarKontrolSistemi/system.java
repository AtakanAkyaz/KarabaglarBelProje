package BilgisayarKontrolSistemi;

import java.sql.Connection;
import java.util.Scanner;

public class system { 

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		//baglanti bag = new baglanti();
		
 //Exception atması durumunda işlemi tekrarlamak için anaKart.java 22-36 bak. Yukarda scanner da eklendi
//		anaKart an = new anaKart();
//		System.out.println("marka");
//		String marka = scan.nextLine();
//		an.setMarka(marka);
//		System.out.println("Bir sayı giriniz");
//		int girdi = scan.nextInt();
//		an.setSeriNo(girdi);
//		System.out.println("Bir sayı giriniz");
//		int gird1 = scan.nextInt();
//		an.setAy(gird1);
//		System.out.println("Bir sayı giriniz");
//		int gird2 = scan.nextInt();
//		an.setYıl(gird2);
//		System.out.println("Bir sayı giriniz");
//		int gird3 = scan.nextInt();
//		an.setRamSoketSayisi(gird3);
//		System.out.println("Bir sayı giriniz");
//		int girdi4 = scan.nextInt();
//		an.setDriverSoketSayisi(girdi4);
//
//		an.printInformation();
//		scan.nextLine(); // 30. satırdaki scan.nextInt() den sonra gelen .nextLine() java üzerinde çalışmadığı için 1 tane boş .nextLine() atılı
//		System.out.println("Bir marka giriniz");
//		String mark = scan.nextLine();
//		an.setMarka(mark);
		
		
		parcalar par = new parcalar();
		int a = scan.nextInt();
		par.setSeriNo(a);
		String b = scan.next();
		par.setMarka(b);
		par.printInformation();

// 41- 52 ileride kalkıcak ve database den kontrol edilicek
// Buradan
		kullanici kullanici1 = new kullanici();
		kullanici1.setFlag(false);
		kullanici kullanici2 = new kullanici();
		kullanici2.setFlag(true);
		
		
		String adminDepoKullanıcıAdi = "kBel";
		String adminDepoSifre = "@dm!N123";
		
		String depoKullanıcıAdi = "Atakan";
		String depoSifre = "123";
// Buraya Kadar
		boolean flag = true ;
		while (flag) {
			System.out.println("Karabağlar Belediyesi Bilgi İşlem Yazılımına Hoş Geldiniz ...\n"
					+ "Kullanıcı Adınızı Giriniz : ");
			String kullanıcıAdi = scan.next();
			System.out.println("Şifrenizi Giriniz : ");
			String sifre = scan.next();
//Normal kullanıcı girişi
			if(depoKullanıcıAdi.equals(kullanıcıAdi) && depoSifre.equals(sifre)) {
				System.out.println("Sisteme Hoş geldiniz");
				KullaniciPaneli(kullanici1);
				break;
			}
//Admin girişi
			else if(adminDepoKullanıcıAdi.equals(kullanıcıAdi) && adminDepoSifre.equals(sifre)) {
				KullaniciPaneli(kullanici2);
				
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
		
		System.out.println("1- program ekle kaldır\n"
				+ "2- parça ekle kaldır");
// Admin olarak girildiği takdirde kasa ekleme ve kaldırma seçenekleri de kullanıcıya sunuluyor
		if(kullanici.isFlag()) {
			System.out.println("3- kasa ekle veya kaldır");
		}
		int input = scan.nextInt();
		switch(input) {
		
		case 1:
			
		}
		
	}

}
