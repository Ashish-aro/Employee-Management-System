package beans;

public class Employee {
	private int eId;
	private String eName,eemail,ecntry;
	int epass;
	
	public Employee() {}
	public Employee(int eId, String eName, int epass, String eemail, String ecntry) {
		super();
		this.eId = eId;
		this.eName = eName;
		this.epass = epass;
		this.eemail = eemail;
		this.ecntry = ecntry;
	}
	public int geteId() {
		return eId;
	}
	public void seteId(int eId) {
		this.eId = eId;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public int getEpass() {
		return epass;
	}
	public void setEpass(int epass) {
		this.epass = epass;
	}
	public String getEemail() {
		return eemail;
	}
	public void setEemail(String eemail) {
		this.eemail = eemail;
	}
	public String getEcntry() {
		return ecntry;
	}
	public void setEcntry(String ecntry) {
		this.ecntry = ecntry;
	}
	@Override
	public String toString() {
		return "Employee [eId=" + eId + ", eName=" + eName + ", epass=" + epass + ", eemail=" + eemail + ", ecntry="
				+ ecntry + "]";
	}
	
}
