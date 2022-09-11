package BilgisayarKontrolSistemi;

public class parcalar {

	int seriNo , ay , yıl;
	String marka;
	public String getMarka() {
		return marka;
	}

	public void setMarka(String marka) {
		try {
			if(marka ==  null) {
				throw new Exception("Marka kısmı boş olamaz");
			}
			else {
				this.marka = marka;
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}

	public int getSeriNo() {
		return seriNo;
	}

	public void setSeriNo(int seriNo) {
		try{
			if (seriNo < 0 ) {
				throw new Exception("Seri Numarası 0 dan küçük olamaz ! ");
			}
			else {
				this.seriNo = seriNo;	
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

	public int getAy() {
		return ay;
	}

	public void setAy(int ay) {
		try {
			if(ay < 1) {
				throw new Exception("Ay 0 dan küçük olamaz");
			}
			else if(ay > 12) {
				throw new Exception("Ay 12 den fazla olamaz");
			}
			else {
				this.ay = ay;
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}

	public int getYıl() {
		return yıl;
	}

	public void setYıl(int yıl) {
		try{
			if(yıl < 1990) {
				throw new Exception("Yıl 1990 den küçük olamaz");
			}
			else if(yıl > 2100) {
				throw new Exception("Yıl 2100 den fazla olamaz");
			}
			else {
				this.yıl = yıl;
			}
		}catch(Exception e){
			System.out.println(e);
		}
	}
}