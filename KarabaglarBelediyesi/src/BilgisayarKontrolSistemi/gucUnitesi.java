package BilgisayarKontrolSistemi;

public class gucUnitesi extends parcalar{
	double watt ;
	

	public double getWatt() {
		return watt;
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
	
}
