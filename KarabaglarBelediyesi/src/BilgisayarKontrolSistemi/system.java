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
		/*
		parcalar pan = new anaKart();
		System.out.println(pan.getNumara());
		pan.setNumara(-2);
		System.out.println(pan.getNumara());
		*/
		/*
		String marka = null ;
		parcalar par = new parcalar();
		par.setMarka(marka);
		System.out.println();
		*/
		String depoKullanıcıAdi = "Atakan";
		String depoSifre = "123";
		boolean flag = true ;
		while (flag) {
			System.out.println("Karabağlar Belediyesi Bilgi İşlem Yazılımına Hoş Geldiniz ...\n"
					+ "Kullanıcı Adınızı Giriniz : ");
			String kullanıcıAdi = scan.next();
			System.out.println("Şifrenizi Giriniz : ");
			String sifre = scan.next();
			if(depoKullanıcıAdi.equals(kullanıcıAdi) && depoSifre.equals(sifre)) {
				System.out.println("Sisteme Hoş geldiniz");
				KullaniciPaneli();
				break;
			}
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
	
	public static void KullaniciPaneli() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Kullanıcı paneline hoş geldiniz ");
		int input = scan.nextInt();
		switch(input) {
		case 1:
		}
				
	}

}