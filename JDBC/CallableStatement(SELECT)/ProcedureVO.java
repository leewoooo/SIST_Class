package day210105;

public class ProcedureVO {

	private int deptno;
	private String dname;
	private String loc;
	private int empno;
	private String ename;
	private String hiredate;
	
	public ProcedureVO() {
		super();
	}

	public ProcedureVO(int deptno, String dname, String loc, int empno, String ename, String hiredate) {
		super();
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
		this.empno = empno;
		this.ename = ename;
		this.hiredate = hiredate;
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

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getHiredate() {
		return hiredate;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}

	@Override
	public String toString() {
		return "ProcedureVO [deptno=" + deptno + ", dname=" + dname + ", loc=" + loc + ", empno=" + empno + ", ename="
				+ ename + ", hiredate=" + hiredate + "]";
	}
	
}//class
