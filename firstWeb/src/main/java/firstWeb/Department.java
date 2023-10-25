package firstWeb;

import java.util.ArrayList;
import java.util.List;

public class Department{
	private int deptid;
	private String deptname;
	private String deptloc;
	private int listofemp;

	public Department () {}

	public Department(int deptid, String deptname, String deptloc, int listofemp) {
		this.deptid = deptid;
		this.deptname = deptname;
		this.deptloc = deptloc;
		this.listofemp = listofemp;
	}

	public Department(int id, int deptid, String deptname, String deptloc, int listofemp) {

		super();
		
		this.deptid = deptid;
		this.deptname = deptname;
		this.deptloc = deptloc;
		this.listofemp = listofemp;
	}

	public int getDeptid() {
		return deptid;
	}

	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public String getDeptloc() {
		return deptloc;
	}

	public void setDeptloc(String deptloc) {
		this.deptloc = deptloc;
	}

	public int getListofemp() {
		return listofemp;
	}

	public void setListofemp(int listofemp) {
		this.listofemp = listofemp;
	}

	@Override
	public String toString() {
		return "Department [deptid=" + deptid + ", deptname=" + deptname + ", deptloc=" + deptloc + ", listofemp="
				+ listofemp + "]";
	}

}
