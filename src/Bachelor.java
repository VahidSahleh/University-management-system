import java.io.Serializable;
import java.util.ArrayList;

public class Bachelor extends Class {
	ArrayList<Bachelor> pishNiaz = new ArrayList<>();
	private int maxCap;
	public Bachelor(String id, String name) {
		super(id, name);
		// TODO Auto-generated constructor stub
	}
	public void addCap() {
		int a  = maxCap-this.getCap()-this.Students.size();
		this.setCap(this.getCap()+a);
	}
}
