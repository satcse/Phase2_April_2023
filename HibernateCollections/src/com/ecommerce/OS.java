package com.ecommerce;

public class OS {
	 private long OSID;
     private String name;

     public OS()
     {}

	public OS(long oSID, String name) {	
		OSID = oSID;
		this.name = name;
	}

	public long getOSID() {
		return OSID;
	}

	public void setOSID(long oSID) {
		OSID = oSID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
     
     
}
