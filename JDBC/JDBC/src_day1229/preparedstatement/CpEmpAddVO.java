package day1229.preparedstatement;

public class CpEmpAddVO {

	private int empno;
	private String ename;
	private String job;
	private int sal;
	private int comm;
	
	public CpEmpAddVO() {
		super();
	}

	public CpEmpAddVO(int empno, String ename, String job, int sal, int comm) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.sal = sal;
		this.comm = comm;
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

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
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

	@Override
	public String toString() {
		return "CpEmpAddVO [empno=" + empno + ", ename=" + ename + ", job=" + job + ", sal=" + sal + ", comm=" + comm
				+ "]";
	}
	
	
	
}// CpEmpAddVO
