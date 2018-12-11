package com.cg.json.pojo;

public class Employee {

	private int empId;
	private String fname;
	private String mname;
	private String lname;
	private String timestamp;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("***** Employee Details *****\n");
		sb.append("ID=" + getEmpId() + "\n");
		sb.append("FName=" + getFname() + "\n");
		sb.append("MName=" + getMname() + "\n");
		sb.append("LName=" + getLname() + "\n");
		sb.append("Timestamp=" + getTimestamp() + "\n");
		sb.append("\n*****************************");

		return sb.toString();
	}
}
