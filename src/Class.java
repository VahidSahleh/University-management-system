import java.io.Serializable;
import java.util.ArrayList;

public class Class implements Serializable {
	private String ID, LessonName ,Pish ;
	private int Grade;
	public int getGrade() {
		return Grade;
	}

	public void setGrade(int grade) {
		Grade = grade;
	}

	private Teacher Prof;
	private Field Field;
	public Field getField() {
		return Field;
	}

	public void setField(Field field) {
		Field = field;
	}

	private int Cap, maxCap, UnitNumber, time, Vahed;
	ArrayList<Student> Students = new ArrayList<>();
	ArrayList<Class> pishniaz = new ArrayList<>();
	
	
	public Class(String id, String name) {
		this.ID = id;
		this.LessonName = name;

	}

	public Teacher getProf() {
		return Prof;
	}

	public void setProf(Teacher prof) {
		Prof = prof;
	}
	
	public void setTime(int tm) {
		this.time = tm;
	}

	public void setPish(String ps) {
		this.Pish = ps;
	}

	public String getPish() {
		return Pish;
	}

	public void setCap(int cap) {
		this.Cap = cap;
	}

	public int getTime() {
		return time;
	}

	public int getCap() {
		return Cap;
	}

	public String getID() {
		return ID;
	}

	public void setId(String id) {
		this.ID = id;
	}

	public void setName(String name) {
		this.LessonName = name;
	}

	public String getName() {
		return LessonName;
	}

	public void StudentsName() {

		for (int i = 0; i < Students.size(); i++) {
			System.out.println("Student id:"+Students.get(i).getId()+" Student first name and last name:"+Students.get(i).getFirstName()+" "+Students.get(i).getLastName());
		}

	}

	public void setVahed(int vahed) {
		this.Vahed = vahed;
	}

	public int getVahed() {
		return Vahed;
	}
	public void addCap(int mCap) {
		this.maxCap = mCap;
		int a;
		
	}
	
}
