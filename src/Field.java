import java.io.Serializable;
import java.util.ArrayList;

public class Field implements Serializable{
private String Field,College√Name,Id;
public String getId() {
	return Id;
}
public void setId(String id) {
	Id = id;
}
ArrayList<Class> dars = new ArrayList<>();
ArrayList<BachelorSt> Bstudents = new ArrayList<>();
ArrayList<BachelorStT> BTstudents = new ArrayList<>();
ArrayList<MasterLessoneSt> MSstudents = new ArrayList<>();
ArrayList<Class> Odars = new ArrayList<>();
public String getCollege√Name() {
	return College√Name;
}
public void setCollege√Name(String college√Name) {
	this.College√Name = college√Name;
}

private int Grade;
public String getField() {
	return Field;
}
public void setField(String field) {
	this.Field = field;
}
public int getGrade() {
	return Grade;
}
public void setGrade(int grade) {
	this.Grade = grade;
}
public void addLesson(Class class1) {
	dars.add(class1);
}
public void addOLesson(Class class2) {
	Odars.add(class2);
}
public void ShowLesson() {
	for(int i=0; i<dars.size(); i++) {
		System.out.println(dars.get(i).getName());
	}
}
public void ShowOLesson() {
	for(int i=0; i<Odars.size(); i++) {
		System.out.println(Odars.get(i).getName());
	}
}

}
