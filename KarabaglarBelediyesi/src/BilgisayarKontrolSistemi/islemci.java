package BilgisayarKontrolSistemi;

public class islemci extends parcalar{

	double hiz ;
	
	public islemci(int seriNo, int degisimAyi, int degisimYili, String marka, double hiz) {
		super(seriNo, degisimAyi, degisimYili, marka);
		this.hiz = hiz;
	}

	public double getHiz() {
		return hiz;
	}

	public void setHiz(double hiz) {
		this.hiz = hiz;
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
	}

}
