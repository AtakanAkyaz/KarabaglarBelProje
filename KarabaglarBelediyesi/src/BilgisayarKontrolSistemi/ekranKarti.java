package BilgisayarKontrolSistemi;

public class ekranKarti extends parcalar{

// bellek tipi (false = harici ) / (true = dahili) 
	boolean bellekTipi;
	int bellekBoyutu;
	public ekranKarti( int degisimAyi, int degisimYili, String marka, boolean bellekTipi, int bellekBoyutu) {
		super(degisimAyi, degisimYili, marka);
		this.bellekTipi = bellekTipi;
		this.bellekBoyutu = bellekBoyutu;
	}

	public boolean isBellekTipi() {
		return bellekTipi;
	}

	public void setBellekTipi(boolean bellekTipi) {
		System.out.println("Burayı siliceksin // bellek tipi için true veya false al ekrankartı.java 5 ");
		this.bellekTipi = bellekTipi;
	}

	public int getBellekBoyutu() {
		return bellekBoyutu;
	}

	public void setBellekBoyutu(int bellekBoyutu) {
		try {
			if(bellekBoyutu < 0) {
				throw new Exception("Bellke boyutunuz 0 dan küçük olamaz");
			}else {
				this.bellekBoyutu = bellekBoyutu;
			}
		}catch(Exception e){
			System.out.println(e);
			System.out.println("Tekrar bir bellek boyutu giriniz");
			bellekBoyutu = scan.nextInt();
			setBellekBoyutu(bellekBoyutu);
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
		String bellekTipiPrint;
		if(bellekTipi == false) {
			bellekTipiPrint = "Harici";
		}else {
			bellekTipiPrint = "Dahili";
		}
		System.out.println("Bellek tipi : " + bellekTipiPrint + "\nBellek boyutu : " + bellekBoyutu);
	}
	
	

	
}
