package BilgisayarKontrolSistemi;

public class saklamaAlani extends parcalar{

	int depolamaAlani , yazmaHizi , okumaHizi;

	public saklamaAlani(int seriNo, int degisimAyi, int degisimYili, String marka, int depolamaAlani, int yazmaHizi,
			int okumaHizi) {
		super(seriNo, degisimAyi, degisimYili, marka);
		this.depolamaAlani = depolamaAlani;
		this.yazmaHizi = yazmaHizi;
		this.okumaHizi = okumaHizi;
	}

	public int getYazmaHizi() {
		return yazmaHizi;
	}

	public void setYazmaHizi(int yazmaHizi) {
		this.yazmaHizi = yazmaHizi;
	}

	public int getOkumaHizi() {
		return okumaHizi;
	}

	public void setOkumaHizi(int okumaHizi) {
		this.okumaHizi = okumaHizi;
	}

	public int getDepolamaAlani() {
		return depolamaAlani;
	}

	public void setDepolamaAlani(int depolamaAlani) {
		this.depolamaAlani = depolamaAlani;
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
