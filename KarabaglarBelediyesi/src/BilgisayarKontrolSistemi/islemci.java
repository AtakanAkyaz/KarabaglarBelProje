package BilgisayarKontrolSistemi;

public class islemci extends parcalar{

	double hiz ;
	
	public islemci() {
		
	}
	public islemci(String marka, double hiz) {
		super(marka);
		this.hiz = hiz;
	}
	public islemci(int degisimAyi, int degisimYili, String marka, double hiz) {
		super(degisimAyi, degisimYili, marka);
		this.hiz = hiz;
	}

	public double getHiz() {
		return hiz;
	}

	public void setHiz(double hiz) {
		try {
			if(hiz < 0) {
				throw new Exception("İşlemci hızı 0 dan küçük olamaz");
			}else {
				this.hiz = hiz;
			}
		}catch(Exception e) {
			System.out.println(e);
			System.out.println("Tekrar bir işlemci hızı giriniz");
			hiz = scan.nextDouble();
			setHiz(hiz);
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
		System.out.println("işlemcinin hızı : " + hiz);
	}

}
