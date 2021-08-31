import java.io.Serializable;
import java.util.ArrayList;

public class Teacher implements Serializable {
	private String FirstName , LastName, ProfId,ProfPass;
	private int Grade , Vahed;
	ArrayList<Class> Lessons = new ArrayList<>();
	public Teacher(String username, String password) {
		this.ProfId = username;
		this.ProfPass = password;
		
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getProfId() {
		return ProfId;
	}
	public void setProfId(String profId) {
		ProfId = profId;
	}
	public String getProfPass() {
		return ProfPass;
	}
	public void setProfPass(String profPass) {
		ProfPass = profPass;
	}
	public int getCap() {
		return cap;
	}
	public void setCap(int cap) {
		this.cap = cap;
	}
	private int cap;
	
	public void ShowLess() {
		for (int i = 0; i < Lessons.size(); i++) {
			System.out.println(Lessons.get(i));
		}

	}
	public void vahed() {
		int S=0;
		for(int i=0; i<Lessons.size(); i++) {
			
			this.Vahed = Lessons.get(i).getVahed();
			S=Vahed+S;
			}
	}
}

