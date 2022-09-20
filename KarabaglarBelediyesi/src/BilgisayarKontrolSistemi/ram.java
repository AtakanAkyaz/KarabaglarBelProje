package BilgisayarKontrolSistemi;

public class ram extends parcalar{

	int ddr , hiz;
	
	public ram() {
		
	}
	public ram(String marka, int ddr, int hiz) {
		super(marka);
		this.ddr = ddr;
		this.hiz = hiz;
	}
	public ram(int degisimAyi, int degisimYili, String marka, int ddr, int hiz) {
		super(degisimAyi, degisimYili, marka);
		this.ddr = ddr;
		this.hiz = hiz;
	}

	public int getDdr() {
		return ddr;
	}

	public void setDdr(int ddr) {
		try {
			if(ddr < 0) {
				throw new Exception("DDR 0 dan küçük olamaz");
			}
		}catch(Exception e){
			System.out.println(e);
			System.out.println("Tekrar bir DDR değeri giriniz");
			ddr = scan.nextInt();
			setDdr(ddr);
		}
	}

	public int getHiz() {
		return hiz;
	}

	public void setHiz(int hiz) {
		try {
			if(hiz < 0) {
				System.out.println("Ram hız 0 dan küçük olamaz");
			}
			else {
				this.hiz = hiz;
			}
		}catch(Exception e){
			System.out.println(e);
			System.out.println("Tekrar bir ram hızı giriniz");
			hiz = scan.nextInt();
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
		System.out.println("DDR tipi : DDR" + ddr + "\nRam hızı : " + hiz);
	}
	
	
	
}
