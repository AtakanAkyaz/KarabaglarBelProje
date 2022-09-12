package BilgisayarKontrolSistemi;

public class ekranKarti extends parcalar{

// bellek tipi (false = harici ) / (true = dahili) 
	boolean bellkeTipi;
	int bellkeBoyutu;
	public ekranKarti(int seriNo, int degisimAyi, int degisimYili, String marka, boolean bellkeTipi, int bellkeBoyutu) {
		super(seriNo, degisimAyi, degisimYili, marka);
		this.bellkeTipi = bellkeTipi;
		this.bellkeBoyutu = bellkeBoyutu;
	}
	
	@Override
	public void printInformation() {
		// TODO Auto-generated method stub
		super.printInformation();
		String bellekTipiPrint;
		if(bellkeTipi == false) {
			bellekTipiPrint = "Harici";
		}else {
			bellekTipiPrint = "Dahili";
		}
		System.out.println("Bellke tipi : " + bellekTipiPrint + "\nBellek boyutu : " + bellkeBoyutu);
	}

	public boolean isBellkeTipi() {
		return bellkeTipi;
	}

	public void setBellkeTipi(boolean bellkeTipi) {
		this.bellkeTipi = bellkeTipi;
	}

	public int getBellkeBoyutu() {
		return bellkeBoyutu;
	}

	public void setBellkeBoyutu(int bellkeBoyutu) {
		this.bellkeBoyutu = bellkeBoyutu;
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
	
	

	
}
