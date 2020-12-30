package day1228;

/**
 * VO(value Object
 * @author owner
 */
public class CPDeptVO {

	//instance variable ¼±¾ð 
	private int deptno;
	private String dname;
	private String loc;
	
	public CPDeptVO() {
		super();
	}

	public CPDeptVO(int deptno, String dname, String loc) {
		super();
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	
}//class
