import java.io.Serializable;
import java.util.ArrayList;
//implements Serializable
public class Student  implements Serializable{
	private String FirstName, LastName, Pass, ID, StudentId;
	public int lessCap ,Vahed=20 ,moadel ;
	public int getMoadel() {
		return moadel;
	}

	public void setMoadel(int moadel) {
		this.moadel = moadel;
	}

	public int getVahed() {
		return Vahed;
	}

	public void setVahed(int vahed) {
		Vahed = vahed;
	}

	ArrayList<Class> Lessons = new ArrayList<>();

	public Student(String username, String password) {
		this.StudentId = username;
		this.Pass = password;
		
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String Fname) {
		this.FirstName = Fname;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String Lname) {
		this.LastName = Lname;
	}

	public void StLess(Class less) {
		this.Lessons.add(less);
	}

	public void ShowLess() {
		for (int i = 0; i < Lessons.size(); i++) {
			System.out.println(Lessons.get(i));
		}

	}

	public String getStId() {
		return StudentId;
	}

	public void setStId(String ii) {
		this.StudentId = ii;
	}

	public void setStPass(String pp) {
		this.Pass = pp;
	}

	public String getId() {
		return StudentId;
	}

	public void setId(String ii) {
		this.StudentId = ii;
	}

	public String getPass() {
		return Pass;
	}

	public void setLCap(int cap) {
		this.lessCap = cap;
	}

	public int getLCap() {
		return lessCap;
	}
	
	
}
