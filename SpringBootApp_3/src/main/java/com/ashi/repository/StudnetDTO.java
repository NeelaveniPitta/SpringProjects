package com.ashi.repository;


public class StudnetDTO {
    public Integer getsId() {
		return sId;
	}
	public void setsId(Integer sId) {
		this.sId = sId;
	}
	public String getSname() {
		return sname;
	}
	
	
	
	
	@Override
	public String toString() {
		return "StudnetDTO [sId=" + sId + ", sname=" + sname + ", smars=" + smars + "]";
	}
	public StudnetDTO(Integer sId, String sname, Double smars) {
		super();
		this.sId = sId;
		this.sname = sname;
		this.smars = smars;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public Double getSmars() {
		return smars;
	}
	public void setSmars(Double smars) {
		this.smars = smars;
	}
	private Integer sId;
    private String sname;
    private Double smars;
    
    
}
