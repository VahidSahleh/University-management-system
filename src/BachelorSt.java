import java.util.ArrayList;

public class BachelorSt extends Student {
	
	ArrayList<Bachelor> LessonsPassed = new ArrayList<>();
	ArrayList<Bachelor> Lessons = new ArrayList<>();
	public BachelorSt(String username, String password) {
		super(username, password);
		// TODO Auto-generated constructor stub
	}
	public void setG(String lessId ,int grade) {
		for(int i=0; i<Lessons.size(); i++) {
			if(lessId==Lessons.get(i).getID() ) {
				Lessons.get(i).setGrade(grade);
				LessonsPassed.add(Lessons.get(i));
			}
		}
	}

}
//set grade
//