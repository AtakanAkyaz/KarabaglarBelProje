package BilgisayarKontrolSistemi;

public class saklamaAlani extends parcalar{

	int depolamaAlani , yazmaHizi , okumaHizi;
	String tip;

	
	public saklamaAlani() {
		
	}
	public saklamaAlani(String marka, int depolamaAlani, int yazmaHizi, int okumaHizi , String tip) {
		super(marka);
		this.depolamaAlani = depolamaAlani;
		this.yazmaHizi = yazmaHizi;
		this.okumaHizi = okumaHizi;
		this.tip=tip;
	}
	public saklamaAlani(int degisimAyi, int degisimYili, String marka, int depolamaAlani, int yazmaHizi, int okumaHizi , String tip) {
		super(degisimAyi, degisimYili, marka);
		this.depolamaAlani = depolamaAlani;
		this.yazmaHizi = yazmaHizi;
		this.okumaHizi = okumaHizi;
		this.tip=tip;
	}
	
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}

	public int getYazmaHizi() {
		return yazmaHizi;
	}

	public void setYazmaHizi(int yazmaHizi) {
		try {
			if(yazmaHizi < 0) {
				throw new Exception("Yazma hızı 0 dan küçük olamaz // yazma hızını kb üzerinden hesapla");
			}else {
				this.yazmaHizi = yazmaHizi;
			}
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Tekrar bir yazma hızı giriniz // kb üzerinden hesaplanıcak");
			yazmaHizi = scan.nextInt();
			setYazmaHizi(yazmaHizi);
		}
	}

	public int getOkumaHizi() {
		return okumaHizi;
	}

	public void setOkumaHizi(int okumaHizi) {
		try {
			if(okumaHizi < 0) {
				throw new Exception("Okuma hızı 0 dan küçük olamaz // okuma hızını kb üzerinden hesapla");
			}else {
				this.okumaHizi = okumaHizi;
			}
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Tekrar bir okuma hızı giriniz // kb üzerinden hesaplanıcak");
			okumaHizi = scan.nextInt();
			setYazmaHizi(okumaHizi);
		}
	}

	public int getDepolamaAlani() {
		return depolamaAlani;
	}

	public void setDepolamaAlani(int depolamaAlani) {
		try {
			if(depolamaAlani < 0) {
				throw new Exception("Depolama alanı 0 dan küçük olamaz // depolama hızını mb üzerinden hesapla");
			}else {
				this.depolamaAlani = depolamaAlani;
			}
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Tekrar bir depolama alanı giriniz // mb üzerinden hesaplanıcak");
			depolamaAlani = scan.nextInt();
			setYazmaHizi(depolamaAlani);
		}
	}


	@Override
	public String getMarka() {
		// TODO Auto-generated method stub
		return super.getMarka();
	}

	@Override
	public void setMarka(String marka) {
		// TODO Auto-generated method stub
		super.setMarka(marka);
	}
	@Override
	public int getAy() {
		// TODO Auto-generated method stub
		return super.getAy();
	}

	@Override
	public void setAy(int degisimAyi) {
		// TODO Auto-generated method stub
		super.setAy(degisimAyi);
	}

	@Override
	public int getYıl() {
		// TODO Auto-generated method stub
		return super.getYıl();
	}

	@Override
	public void setYıl(int degisimYili) {
		// TODO Auto-generated method stub
		super.setYıl(degisimYili);
	}

	@Override
	public void printInformation() {
		// TODO Auto-generated method stub
		super.printInformation();
		System.out.println("Depolama alanı : " + depolamaAlani + "\nYazma Hızı : " + yazmaHizi + "\nOkuma Hızı : " + okumaHizi);
	}


}
