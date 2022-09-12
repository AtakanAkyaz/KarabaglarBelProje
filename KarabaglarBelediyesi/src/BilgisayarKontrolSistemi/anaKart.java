package BilgisayarKontrolSistemi;


public class anaKart extends parcalar{
	int ramSoketSayisi , driverSoketSayisi;

	public anaKart(int seriNo, int degisimAyi, int degisimYili, String marka, int ramSoketSayisi,
			int driverSoketSayisi) {
		super(seriNo, degisimAyi, degisimYili, marka);
		this.ramSoketSayisi = ramSoketSayisi;
		this.driverSoketSayisi = driverSoketSayisi;
	}

	public int getRamSoketSayisi() {
		return ramSoketSayisi;
	}

	public void setRamSoketSayisi(int ramSoketSayisi) {
		this.ramSoketSayisi = ramSoketSayisi;
	}

	public int getDriverSoketSayisi() {
		return driverSoketSayisi;
	}

	public void setDriverSoketSayisi(int driverSoketSayisi) {
		this.driverSoketSayisi = driverSoketSayisi;
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