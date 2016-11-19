package tan.Demo.Bean;

public class cai {
	public int CaiNumber;
	public String Cainame;
	public String suger;
	public String oil;
	public String danbaizhi;
	public String weishengsu;
	public String wujiyan;
	public String miaoshu;
	
	public cai(){
		super();
	}
	
	
	
	public cai(int caiNumber, String cainame, String suger, String oil, String danbaizhi, String weishengsu,
			String wujiyan, String miaoshu) {
		super();
		CaiNumber = caiNumber;
		Cainame = cainame;
		this.suger = suger;
		this.oil = oil;
		this.danbaizhi = danbaizhi;
		this.weishengsu = weishengsu;
		this.wujiyan = wujiyan;
		this.miaoshu = miaoshu;
	}
	
	
	
	
	@Override
	public String toString() {
		return "cai [CaiNumber=" + CaiNumber + ", Cainame=" + Cainame + ", suger=" + suger + ", oil=" + oil
				+ ", danbaizhi=" + danbaizhi + ", weishengsu=" + weishengsu + ", wujiyan=" + wujiyan + ", miaoshu="
				+ miaoshu + "]";
	}



	public int getCaiNumber() {
		return CaiNumber;
	}
	public void setCaiNumber(int caiNumber) {
		CaiNumber = caiNumber;
	}
	public String getCainame() {
		return Cainame;
	}
	public void setCainame(String cainame) {
		Cainame = cainame;
	}
	public String getSuger() {
		return suger;
	}
	public void setSuger(String suger) {
		this.suger = suger;
	}
	public String getOil() {
		return oil;
	}
	public void setOil(String oil) {
		this.oil = oil;
	}
	public String getDanbaizhi() {
		return danbaizhi;
	}
	public void setDanbaizhi(String danbaizhi) {
		this.danbaizhi = danbaizhi;
	}
	public String getWeishengsu() {
		return weishengsu;
	}
	public void setWeishengsu(String weishengsu) {
		this.weishengsu = weishengsu;
	}
	public String getWujiyan() {
		return wujiyan;
	}
	public void setWujiyan(String wujiyan) {
		this.wujiyan = wujiyan;
	}
	public String getMiaoshu() {
		return miaoshu;
	}
	public void setMiaoshu(String miaoshu) {
		this.miaoshu = miaoshu;
	}
	
	
	
}
