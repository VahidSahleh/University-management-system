import java.util.ArrayList;

public class HiredProf extends Teacher{
	private int Sanavat;
	ArrayList<Bachelor> Lessons = new ArrayList<>();
	ArrayList<MasterLessone> Lessons1 = new ArrayList<>();
	public int getSanavat() {
		return Sanavat;
	}
	public void setSanavat(int sanavat) {
		Sanavat = sanavat;
	}
	public HiredProf(String username, String password) {
		super(username, password);
		// TODO Auto-generated constructor stub
	}

}
