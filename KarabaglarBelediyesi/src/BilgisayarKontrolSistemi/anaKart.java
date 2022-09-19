package BilgisayarKontrolSistemi;

import java.util.Scanner;

public class anaKart extends parcalar{
	int ramSoketSayisi , driverSoketSayisi;

	public anaKart() {
		
	}
	public anaKart(int degisimAyi, int degisimYili, String marka, int ramSoketSayisi, int driverSoketSayisi) {
		super(degisimAyi, degisimYili, marka);
		this.ramSoketSayisi = ramSoketSayisi;
		this.driverSoketSayisi = driverSoketSayisi;
	}

	public int getRamSoketSayisi() {
		return ramSoketSayisi;
	}

	public void setRamSoketSayisi(int ramSoketSayisi) {
			try {
					if(ramSoketSayisi < 0) {
						throw new Exception("Ram soket sayısı 0 dan küçük olamaz");
					}else {
						this.ramSoketSayisi = ramSoketSayisi;
					}			
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Tekrar bir ram soket sayısı giriniz");
			ramSoketSayisi = scan.nextInt();
			setRamSoketSayisi(ramSoketSayisi);
		}
	}

	public int getDriverSoketSayisi() {
		return driverSoketSayisi;
	}

	public void setDriverSoketSayisi(int driverSoketSayisi) {
		try {
			if(driverSoketSayisi < 0) {
				throw new Exception("Driver soket sayısı 0 dan küçük olamaz");
			}else {
				this.driverSoketSayisi = driverSoketSayisi;	
			}
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Tekrar bir driver soket sayısı giriniz");
			driverSoketSayisi = scan.nextInt();
			setDriverSoketSayisi(driverSoketSayisi);
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
		System.out.println("Ram soket sayısı : " + ramSoketSayisi + "\nDriver soket sayısı : " + driverSoketSayisi);
	}
	
	

	
}