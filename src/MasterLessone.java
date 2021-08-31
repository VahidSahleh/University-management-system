
public class MasterLessone extends Class {
private int maxCap=20;
	public MasterLessone(String id, String name) {
		super(id, name);
		// TODO Auto-generated constructor stub
		
	}
	public void addCap(int mCap) {
		int a  = maxCap-this.getCap()-this.Students.size();
		this.setCap(this.getCap()+a);
	}

}
