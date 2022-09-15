package BilgisayarKontrolSistemi;

public class ssd extends saklamaAlani{

	String tip = "SSD";
	
	
	public ssd(int seriNo, int degisimAyi, int degisimYili, String marka, int depolamaAlani, int yazmaHizi,
			int okumaHizi) {
		super(seriNo, degisimAyi, degisimYili, marka, depolamaAlani, yazmaHizi, okumaHizi);
	}


	public String getTip() {
		return tip;
	}

	
	@Override
	public int getYazmaHizi() {
		// TODO Auto-generated method stub
		return super.getYazmaHizi();
	}

	@Override
	public void setYazmaHizi(int yazmaHizi) {
		// TODO Auto-generated method stub
		super.setYazmaHizi(yazmaHizi);
	}

	@Override
	public int getOkumaHizi() {
		// TODO Auto-generated method stub
		return super.getOkumaHizi();
	}

	@Override
	public void setOkumaHizi(int okumaHizi) {
		// TODO Auto-generated method stub
		super.setOkumaHizi(okumaHizi);
	}

	@Override
	public int getDepolamaAlani() {
		// TODO Auto-generated method stub
		return super.getDepolamaAlani();
	}

	@Override
	public void setDepolamaAlani(int depolamaAlani) {
		// TODO Auto-generated method stub
		super.setDepolamaAlani(depolamaAlani);
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
	public int getSeriNo() {
		// TODO Auto-generated method stub
		return super.getSeriNo();
	}

	@Override
	public void setSeriNo(int seriNo) {
		// TODO Auto-generated method stub
		super.setSeriNo(seriNo);
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
		System.out.println("Saklama alanı tipi : " + tip);
	}
	
	
	

}
