package BilgisayarKontrolSistemi;

import java.util.Scanner;

public class system {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		/*System.out.println("Karabağlar Belediyesi Bilgi İşlem Yazılımına Hoş Geldiniz .../n"
				+ "Kullanıcı Adınızı Giriniz : ");
		String name = scan.nextLine();
		System.out.println("Şifrenizi Giriniz : ");
		int Şifre = scan.nextInt();
		*/
		
//		//***Anakart Deneme***
//		anaKart örnek = new anaKart();
//		System.out.println(örnek.getNumara());
//		örnek.setNumara(-2);
//		System.out.println(örnek.getNumara());
		
		
//		//***Güç Ünitesi Deneme***
//		gucUnitesi örnek = new gucUnitesi();
//		System.out.println(örnek.getWatt());
//		örnek.setWatt(200);
//		System.out.println(örnek.getWatt());
		
//		//***RAM Deneme***
//		ram örnek = new ram();
//		System.out.println(örnek.getWatt());
//		örnek.setWatt(200);
//		System.out.println(örnek.getWatt());
		
		kullanici kullanici1 = new kullanici();
		kullanici1.setFlag(false);
		kullanici kullanici2 = new kullanici();
		kullanici2.setFlag(true);
		
		 
		String adminDepoKullanıcıAdi = "kBel";
		String adminDepoSifre = "@dm!N123";
		
		String depoKullanıcıAdi = "Atakan";
		String depoSifre = "123";
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
				System.out.println("Girdiğiniz kullanıcı adı veya şifre yanlış \n"
						+ "Tekrar denemek için 1 e \n"
						+ "Çıkış yapmak için 2 ye basınız.");
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
						System.out.println("Lütfen geçerli bir sayı kullanınız");
					}
					
				}
				
			}
		}
				
	}
	
	public static void AdminPaneli() {
		System.err.println("Admin paneline hoş geldiniz");
	}
	
	public static void KullaniciPaneli(kullanici kull) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Kullanıcı paneline hoş geldiniz\n"
				+ "Programları kontrol etmek için 1 e basınız\n"
				+ "Kasa ile ilgili işlemler için 2 ye basınız");
		int input = scan.nextInt();
		switch(input) {
		case 1:
//programları kontrol etme
			break;
		case 2:
//Kasa işlemleri
			KasaIslemleri(kull);
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
		if(kullanici.isFlag()) {
			System.out.println("kasa ekle veya kaldır");
		}
		System.out.println("program ekle kaldır\n"
				+ "parça ekle kaldır");
		int input = scan.nextInt();
		
	}

}
