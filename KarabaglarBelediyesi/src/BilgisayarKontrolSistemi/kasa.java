package BilgisayarKontrolSistemi;

public class kasa {

	int ID , seriNumarası;
	parcalar anaKart , ekranKari , gucUnitesi , islemci , ram , saklamaAlani;
	
	public kasa(int ID) {
		this.ID=ID;
	}
	public kasa(int ID,int seriNo) {
		this.ID=ID;
		this.seriNumarası = seriNo;
	}
	
	public kasa(int ID , parcalar anaKart, parcalar ekranKari , parcalar gucUnitesi, parcalar islemci, parcalar ram, parcalar saklamaAlani , int seriNumarası) {
		this.ID = ID;
		this.anaKart = anaKart;
		this.ekranKari = ekranKari;
		this.gucUnitesi = gucUnitesi;
		this.islemci = islemci;
		this.ram = ram;
		this.saklamaAlani = saklamaAlani;
		this.seriNumarası = seriNumarası;
	}

	public int getID() {
		return ID;
	}

	public int getSeriNumarası() {
		return seriNumarası;
	}

	public void setSeriNumarası(int seriNumarası) {
		this.seriNumarası = seriNumarası;
	}

	public parcalar getAnaKart() {
		return anaKart;
	}

	public void setAnaKart(parcalar anaKart) {
		this.anaKart = anaKart;
	}

	public parcalar getEkranKari() {
		return ekranKari;
	}

	public void setEkranKari(parcalar ekranKari) {
		this.ekranKari = ekranKari;
	}

	public parcalar getGucUnitesi() {
		return gucUnitesi;
	}

	public void setGucUnitesi(parcalar gucUnitesi) {
		this.gucUnitesi = gucUnitesi;
	}

	public parcalar getIslemci() {
		return islemci;
	}

	public void setIslemci(parcalar islemci) {
		this.islemci = islemci;
	}

	public parcalar getRam() {
		return ram;
	}

	public void setRam(parcalar ram) {
		this.ram = ram;
	}

	public parcalar getSaklamaAlani() {
		return saklamaAlani;
	}

	public void setSaklamaAlani(parcalar saklamaAlani) {
		this.saklamaAlani = saklamaAlani;
	}
	
	
	

}
