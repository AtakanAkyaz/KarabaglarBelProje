package BilgisayarKontrolSistemi;

public class kullanici {
	String isim , sifre;
	boolean flag;
	
	public kullanici(String isim, String sifre) {
		this.isim = isim;
		this.sifre = sifre;
	}
	
	public kullanici(String isim, String sifre , boolean flag) {
		this.isim = isim;
		this.sifre = sifre;
		this.flag = flag;
	}

	public boolean getFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = false;
	}

	public String getIsim() {
		return isim;
	}

	public void setIsim(String isim) {
		this.isim = isim;
	}

	public String getSifre() {
		return sifre;
	}

	public void setSifre(String sifre) {
		this.sifre = sifre;
	}
}
