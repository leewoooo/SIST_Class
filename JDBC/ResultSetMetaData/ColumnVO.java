package day210104;

public class ColumnVO {
	private String columnName;
	private String dataType;
	private int precision;
	private int nullFlag;
	
	public ColumnVO() {
		super();
	}

	public ColumnVO(String columnName, String dataType, int precision, int nullFlag) {
		super();
		this.columnName = columnName;
		this.dataType = dataType;
		this.precision = precision;
		this.nullFlag = nullFlag;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public int getPrecision() {
		return precision;
	}

	public void setPrecision(int precision) {
		this.precision = precision;
	}

	public int getNullFlag() {
		return nullFlag;
	}

	public void setNullFlag(int nullFlag) {
		this.nullFlag = nullFlag;
	}

	@Override
	public String toString() {
		return "ColumnVO [columnName=" + columnName + ", dataType=" + dataType + ", precision=" + precision
				+ ", nullFlag=" + nullFlag + "]";
	}

	
	
	
}
