package BilgisayarKontrolSistemi;

public class gucUnitesi extends parcalar{
	double watt ;

	public double getWatt() {
		return watt;
	}

	public gucUnitesi(int seriNo, int degisimAyi, int degisimYili, String marka, double watt) {
		super(seriNo, degisimAyi, degisimYili, marka);
		this.watt = watt;
	}

	public void setWatt(double watt) {
		try {
			if(watt < 0 ) {
				throw new Exception("Watt 0 dan küçük olamaz");
			}
			else {
				this.watt = watt;
			}
		}
		catch(Exception e){
			System.out.println(e);
			System.out.println("Tekrar güç ünitesi için watt giriniz");
			watt = scan.nextDouble();
			setWatt(watt);
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
	public void setAy(int ay) {
		// TODO Auto-generated method stub
		super.setAy(ay);
	}

	@Override
	public int getYıl() {
		// TODO Auto-generated method stub
		return super.getYıl();
	}

	@Override
	public void setYıl(int yıl) {
		// TODO Auto-generated method stub
		super.setYıl(yıl);
	}
	

	@Override
	public void printInformation() {
		// TODO Auto-generated method stub
		super.printInformation();
		System.out.println("Güç ünitesinin watt'ı : " + watt);
	}
	
}
