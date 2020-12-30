package day1229.work;

public class WorkEmpAllVO {

	private int empno;
	private String Ename;
	private int deptno;
	private int sal;
	private int comm;
	private String job;
	
	public WorkEmpAllVO() {
		super();
	}
	
	public WorkEmpAllVO(int empno, String ename, int deptno, int sal, int comm, String job) {
		super();
		this.empno = empno;
		Ename = ename;
		this.deptno = deptno;
		this.sal = sal;
		this.comm = comm;
		this.job = job;
	}
	
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return Ename;
	}
	public void setEname(String ename) {
		Ename = ename;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public int getComm() {
		return comm;
	}
	public void setComm(int comm) {
		this.comm = comm;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	
	@Override
	public String toString() {
		return "WorkEmpAllVO [empno=" + empno + ", Ename=" + Ename + ", deptno=" + deptno + ", sal=" + sal + ", comm="
				+ comm + ", job=" + job + "]";
	}
	
	
	
	
	
}
