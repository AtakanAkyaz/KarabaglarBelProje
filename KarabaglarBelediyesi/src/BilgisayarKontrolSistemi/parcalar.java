package BilgisayarKontrolSistemi;

public class parcalar {
	/*
	 anaKart , gucUnitesi , ram , ekranKarti , islemci , saklamaAlani parcalar ın child ı
	 hdd ve ssd saklama alanının child ı 
	*/
	String marka;
	int seriNo , degisimAyi , degisimYili;
	public parcalar() {
		
	}
	public parcalar(int seriNo, int degisimAyi, int degisimYili, String marka) {
		this.seriNo = seriNo;
		this.degisimAyi = degisimAyi;
		this.degisimYili = degisimYili;
		this.marka = marka;
	}

	public String getMarka() {
		return marka;
	}

	public void setMarka(String marka) {
		try {
			if(marka ==  null) {
				throw new Exception("Marka kısmı boş olamaz");
			}
			else {
				this.marka = marka;
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}

	public int getSeriNo() {
		return seriNo;
	}

	public void setSeriNo(int seriNo) {
		try{
			if (seriNo < 0 ) {
				throw new Exception("Seri Numarası 0 dan küçük olamaz ! ");
			}
			else {
				this.seriNo = seriNo;	
			}
		}
		catch(Exception e){
			System.out.println(e);
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
		}
	}
	
	public void printInformation() {
		System.out.println("Seri No : " + seriNo + "\nMarka : " + marka + "\nDeğişim yılı : " + degisimYili + "\nDeğişim ayı : " + degisimAyi);
		
	}
} 