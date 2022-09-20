package BilgisayarKontrolSistemi;

import java.util.Scanner;

public class parcalar {
	Scanner scan = new Scanner(System.in);
	/*
	 anaKart , gucUnitesi , ram , ekranKarti , islemci , saklamaAlani parcalar ın child ı
	 hdd ve ssd saklama alanının child ı 
	*/
	String marka;
	int degisimAyi , degisimYili;
	public parcalar() {
		
	}
	
	public parcalar(String marka) {
		this.marka = marka;
	}
	
	public parcalar(int degisimAyi, int degisimYili, String marka) {
		this.degisimAyi = degisimAyi;
		this.degisimYili = degisimYili;
		this.marka = marka;
	}

	public String getMarka() {
		return marka;
	}

	public void setMarka(String marka) {
		try {
			if(marka ==  "") {
				throw new Exception("Marka kısmı boş olamaz");
			}
			else {
				this.marka = marka;
			}
		}catch(Exception e) {
			System.out.println(e);
			System.out.println("Tekrar bir marka giriniz");
			marka = scan.next();
			setMarka(marka);
		}
	}

	public int getAy() {
		return degisimAyi;
	}

	public void setAy(int degisimAyi) {
		try {
			if(degisimAyi < 1) {
				throw new Exception("Ay 0 dan küçük olamaz");
			}
			else if(degisimAyi > 12) {
				throw new Exception("Ay 12 den fazla olamaz");
			}
			else {
				this.degisimAyi = degisimAyi;
			}
		}catch(Exception e) {
			System.out.println(e);
			System.out.println("Tekrar bir ay giriniz");
			int ay = scan.nextInt();
			setAy(ay);
		}
		
	}

	public int getYıl() {
		return degisimYili;
	}

	public void setYıl(int degisimYili) {
		try{
			if(degisimYili < 1990) {
				throw new Exception("Yıl 1990 den küçük olamaz");
			}
			else if(degisimYili > 2100) {
				throw new Exception("Yıl 2100 den fazla olamaz");
			}
			else {
				this.degisimYili = degisimYili;
			}
		}catch(Exception e){
			System.out.println(e);
			System.out.println("Tekrar bir yıl giriniz");
			int yıl = scan.nextInt();
			setYıl(yıl);
		}
	}
	
	public void printInformation() {
		System.out.println("Marka : " + marka + "\nDeğişim ayı : " + degisimAyi + "\nDeğişim yılı : " + degisimYili);
		
	}
} 