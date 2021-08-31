import java.util.ArrayList;

public class MasterLessoneSt extends Student {
	ArrayList<MasterLessone> LessonsPassed = new ArrayList<>();
	ArrayList<MasterLessone> Lessons = new ArrayList<>();
	public MasterLessoneSt(String username, String password) {
		super(username, password);
	this.lessCap=20;
		// TODO Auto-generated constructor stub
	}
	public void setG(String lessId ,int grade) {
		for(int i=0; i<Lessons.size(); i++) {
			if(lessId==Lessons.get(i).getID() ) {
				Lessons.get(i).setGrade(grade);
			}
		}
	}
}
