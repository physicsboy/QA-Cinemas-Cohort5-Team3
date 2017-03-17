package com.qa.cinema.persistence;

public enum Classification {
	
	CLASS_U("http://www.bbfc.co.uk/sites/default/files/styles/40x40/public/certificate/BBFC_U_150px-height.png?itok=kr1fkIkE"),
	CLASS_PG("http://www.bbfc.co.uk/sites/default/files/styles/40x40/public/certificate/BBFC_PG_150px-height_0.png?itok=_cwpf5VM"),
	CLASS_12("http://www.bbfc.co.uk/sites/default/files/styles/40x40/public/certificate/BBFC_12_150px-height_0.png?itok=oDHH4wwO"),
	CLASS_12A("http://www.bbfc.co.uk/sites/default/files/styles/40x40/public/certificate/BBFC_12A_150px-height_0.png?itok=n-p_eO2h"),
	CLASS_15("http://www.bbfc.co.uk/sites/default/files/styles/40x40/public/certificate/BBFC_15_150px-height_0.png?itok=Xr2pSBTi"),
	CLASS_18("http://www.bbfc.co.uk/sites/default/files/styles/40x40/public/certificate/BBFC_18_150px-height_0.png?itok=LFdu5ZKf"),
	CLASS_TBC("https://www.myvue.com/-/media/system/certificates/certificates%20uk/tbc.png");
	
	private String url;
	private Classification(String url){
		this.url = url;
	}
	
	public String getUrl(){
		return url;
	}

}
