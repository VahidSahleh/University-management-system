import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.Scanner;

public class Managr {
	private String Pass = "1234", Id = "Admin" ,field2;
	ArrayList<Student> StudentList = new ArrayList<>();
	ArrayList<BachelorStT> StudentList1 = new ArrayList<>();
	ArrayList<BachelorSt> StudentList2 = new ArrayList<>();
	ArrayList<MasterLessoneSt> StudentList3 = new ArrayList<>();
	ArrayList<HiredProf> ProfList = new ArrayList<>();
	ArrayList<TemporaryProf> ProfList1 = new ArrayList<>();
	ArrayList<Bachelor> ClassList = new ArrayList<>();
	ArrayList<MasterLessone> ClassList2 = new ArrayList<>();
	ArrayList<Field> field = new ArrayList<>();

	public Managr() throws ClassNotFoundException, FileNotFoundException {
		
		
		
		
		
		
	}

	// method for adding student to Student List.
	public void AddStudent(String StId, String StPass, String Fname, String Lname, String field1)
			throws ClassNotFoundException, FileNotFoundException ,StreamCorruptedException{
		BachelorSt bs;
		BachelorStT bs1;
		MasterLessoneSt ms;
		String field2 = null;
	
		if (StId.charAt(4) == '1') {
			bs = new BachelorSt(StId, StPass);
			bs.setFirstName(Fname);
			bs.setLastName(Lname);
			for(int i=0; i<field.size(); i++) {
				if(field1==field.get(i).getId()) {
				field.get(i).Bstudents.add(bs);
				}
			}

			try {
				File myObj = new File("StudentList2.sav");

				if (myObj.createNewFile()) {
					System.out.println("File created: " + myObj.getName());
				} else {
					System.out.println("File already exists.");
				}
			} catch (IOException e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
			}
			try {
				FileOutputStream myWriter = new FileOutputStream("StudentList2.sav", true);
				ObjectOutputStream o = new ObjectOutputStream(myWriter);
				o.writeObject(bs);
				StudentList2.add(bs);
				myWriter.close();
				System.out.println("Successfully wrote to the file.");
			} catch (IOException e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
			}
		} else if (StId.charAt(4) == '0') {
			ms = new MasterLessoneSt(StId, StPass);
			ms.setFirstName(Fname);
			ms.setLastName(Lname);
			for(int i=0; i<field.size(); i++) {
				if(field1==field.get(i).getId()) {
				field.get(i).MSstudents.add(ms);
				}
			}

			try {
				File myObj = new File("StudentList3.sav");

				if (myObj.createNewFile()) {
					System.out.println("File created: " + myObj.getName());
				} else {
					System.out.println("File already exists.");
				}
			} catch (IOException e) {
				System.out.println("An error occurred.");
				
			}
			try {
				FileOutputStream myWriter = new FileOutputStream("StudentList3.sav", true);
				ObjectOutputStream o = new ObjectOutputStream(myWriter);
				o.writeObject(ms);
				StudentList3.add(ms);
				o.flush();
				myWriter.close();
				System.out.println("Successfully wrote to the file.");
			} catch (IOException e) {
				System.out.println("An error occurred.");
				
			}
		}
		
		else if (StId.charAt(4) == '2') {
			
			bs1 = new BachelorStT(StId, StPass);
			bs1.setFirstName(Fname);
			bs1.setLastName(Lname);
			for(int i=0; i<field.size(); i++) {
				if(field1==field.get(i).getId()) {
				field.get(i).BTstudents.add(bs1);
				}
			}

			try {
				File myObj = new File("StudentList.sav");

				if (myObj.createNewFile()) {
					System.out.println("File created: " + myObj.getName());
				} else {
					System.out.println("File already exists.");
				}
			} catch (IOException e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
			}
			try {
				FileOutputStream myWriter = new FileOutputStream("StudentList.sav", true);
				ObjectOutputStream o = new ObjectOutputStream(myWriter);
				o.writeObject(bs1);
				StudentList1.add(bs1);
				myWriter.close();
				System.out.println("Successfully wrote to the file.");
			} catch (IOException e) {
				System.out.println("An error occurred.");
			
			}
		} 
	

	}

	public void AddProf(String tId, String tPass, String Fname, String Lname ,int sanavat)
			throws ClassNotFoundException, FileNotFoundException {
		if (tId.charAt(4) == '1') {
			HiredProf hp = new HiredProf(tId, tPass);
			hp.setFirstName(Fname);
			hp.setLastName(Lname);
			hp.setSanavat(sanavat);
			ProfList.add(hp);
			try {
				File myObj = new File("ProfList.sav");

				if (myObj.createNewFile()) {
					System.out.println("File created: " + myObj.getName());
				} else {
					System.out.println("File already exists.");
				}
			} catch (IOException e) {
				System.out.println("An error occurred.");
			
			}
			try {
				FileOutputStream myWriter = new FileOutputStream("ProfList.sav", true);
				ObjectOutputStream o = new ObjectOutputStream(myWriter);
				o.writeObject(hp);

				myWriter.close();
				System.out.println("Successfully wrote to the file.");
			} catch (IOException e) {
				System.out.println("An error occurred.");
				
			}
		} else if (tId.charAt(4) == '0') {

			TemporaryProf tp = new TemporaryProf(tId, tPass);
			Teacher th = new Teacher(tId, tPass);
			th.setFirstName(Fname);
			th.setLastName(Lname);
			ProfList1.add(tp);
			try {
				File myObj = new File("ProfList1.sav");

				if (myObj.createNewFile()) {
					System.out.println("File created: " + myObj.getName());
				} else {
					System.out.println("File already exists.");
				}
			} catch (IOException e) {
				System.out.println("An error occurred.");
				
			}
			try {
				FileOutputStream myWriter = new FileOutputStream("ProfList1.sav", true);
				ObjectOutputStream o = new ObjectOutputStream(myWriter);
				o.writeObject(tp);

				myWriter.close();
				System.out.println("Successfully wrote to the file.");
			} catch (IOException e) {
				System.out.println("An error occurred.");
				
			}
		}

	}
	public void setMoadel(String id)  throws ClassNotFoundException, FileNotFoundException {
		int a=0;
		int b=0;
		try {

			File myObj = new File("StudentList2.sav");
			FileInputStream fi = new FileInputStream(myObj);
			ObjectInputStream oi = new ObjectInputStream(fi);

			while (true) {
				try {

					BachelorSt hp = (BachelorSt) oi.readObject();
					StudentList2.add(hp);
					if (hp == null) {
						break;
					}

				} catch (EOFException exc) {
					// TODO Auto-generated catch block
					break;
				}

			}
		} catch (IOException e) {
			
		}
		try {

			File myObj = new File("StudentList3.sav");
			FileInputStream fi = new FileInputStream(myObj);
			ObjectInputStream oi = new ObjectInputStream(fi);

			while (true) {
				try {

					MasterLessoneSt hp = (MasterLessoneSt) oi.readObject();
					StudentList3.add(hp);
					if (hp == null) {
						break;
					}

				} catch (EOFException exc) {
					// TODO Auto-generated catch block
					break;
				}

			}
		} catch (IOException e) {
			
		}
		try {

			File myObj = new File("StudentList.sav");
			FileInputStream fi = new FileInputStream(myObj);
			ObjectInputStream oi = new ObjectInputStream(fi);

			while (true) {
				try {

					BachelorStT hp = (BachelorStT) oi.readObject();
					StudentList1.add(hp);
					if (hp == null) {
						break;
					}

				} catch (EOFException exc) {
					// TODO Auto-generated catch block
					break;
				}

			}
		} catch (IOException e) {
			
		}
		if(id.charAt(4)=='0') {
			for(int i=0; i<StudentList2.size(); i++) {
				if(id==StudentList2.get(i).getId()) {
					for(int j=0; j<StudentList2.get(i).LessonsPassed.size(); j++) {
						a=a+StudentList2.get(i).LessonsPassed.get(j).getGrade()*StudentList2.get(i).LessonsPassed.get(j).getVahed();
						b=b+StudentList2.get(i).LessonsPassed.get(j).getVahed();
						
					}
				}
			}
			for(int i=0; i<StudentList2.size(); i++) {
				if(id==StudentList2.get(i).getId()) {
					StudentList2.get(i).setMoadel(a/b);
				}
				}
			System.out.println("moadel Student: "+a/b);
		}
		else if(id.charAt(4)=='1') {
			for(int i=0; i<StudentList3.size(); i++) {
				if(id==StudentList3.get(i).getId()) {
					for(int j=0; j<StudentList3.get(i).LessonsPassed.size(); j++) {
						a=a+StudentList3.get(i).LessonsPassed.get(j).getGrade()*StudentList3.get(i).LessonsPassed.get(j).getVahed();
						b=b+StudentList3.get(i).LessonsPassed.get(j).getVahed();
						
					}
				}
			}
			for(int i=0; i<StudentList3.size(); i++) {
				if(id==StudentList3.get(i).getId()) {
					StudentList3.get(i).setMoadel(a/b);
				}
				}
			System.out.println("moadel Student: "+a/b);	
		}
		else if(id.charAt(4)=='2') {
			for(int i=0; i<StudentList1.size(); i++) {
				if(id==StudentList1.get(i).getId()) {
					for(int j=0; j<StudentList1.get(i).LessonsPassed.size(); j++) {
						a=a+StudentList1.get(i).LessonsPassed.get(j).getGrade()*StudentList1.get(i).LessonsPassed.get(j).getVahed();
						b=b+StudentList1.get(i).LessonsPassed.get(j).getVahed();
						
					}
				}
			}
			for(int i=0; i<StudentList1.size(); i++) {
				if(id==StudentList1.get(i).getId()) {
					StudentList1.get(i).setMoadel(a/b);
				}
				}
			System.out.println("moadel Student: "+a/b);
}
		try {
			File myObj = new File("StudentList.sav");
			myObj.delete();
			File myObj1 = new File("StudentList.sav");
			FileOutputStream myWriter = new FileOutputStream(myObj1, true);
			ObjectOutputStream o = new ObjectOutputStream(myWriter);
			for (int i = 0; i < StudentList1.size(); i++) {
				o.writeObject(StudentList1.get(i));

			}
			
		} catch (IOException e) {
		
		}
		try {
			File myObj = new File("StudentList2.sav");
			myObj.delete();
			File myObj1 = new File("StudentList2.sav");
			FileOutputStream myWriter = new FileOutputStream(myObj1, true);
			ObjectOutputStream o = new ObjectOutputStream(myWriter);
			for (int i = 0; i < StudentList2.size(); i++) {
				o.writeObject(StudentList2.get(i));

			}
			
		} catch (IOException e) {
			
		}
		try {
			File myObj = new File("StudentList3.sav");
			myObj.delete();
			File myObj1 = new File("StudentList3.sav");
			FileOutputStream myWriter = new FileOutputStream(myObj1, true);
			ObjectOutputStream o = new ObjectOutputStream(myWriter);
			for (int i = 0; i < StudentList3.size(); i++) {
				o.writeObject(StudentList3.get(i));

			}
			
		} catch (IOException e) {
			
		}
	}

	public void ShowMoadel(String id) {
		if (id.charAt(4) == '0') {
			for (int i = 0; i < StudentList2.size(); i++) {
				if (id == StudentList2.get(i).getId()) {
					System.out.println("moadel Student: " + StudentList2.get(i).getMoadel());
				}
			}

		}
		else if (id.charAt(4) == '1') {
			for (int i = 0; i < StudentList3.size(); i++) {
				if (id == StudentList3.get(i).getId()) {
					System.out.println("moadel Student: " + StudentList3.get(i).getMoadel());
				}
			}

		}
		else if (id.charAt(4) == '2') {
			for (int i = 0; i < StudentList1.size(); i++) {
				if (id == StudentList1.get(i).getId()) {
					System.out.println("moadel Student: " + StudentList1.get(i).getMoadel());
				}
			}

		}

	}
	public void addLessonTost(String lessId, String Id) throws ClassNotFoundException, FileNotFoundException {
		
		try {

			File myObj = new File("StudentList2.sav");
			FileInputStream fi = new FileInputStream(myObj);
			ObjectInputStream oi = new ObjectInputStream(fi);

			while (true) {
				try {

					BachelorSt hp = (BachelorSt) oi.readObject();
					StudentList2.add(hp);
					if (hp == null) {
						break;
					}

				} catch (EOFException exc) {
					// TODO Auto-generated catch block
					break;
				}

			}
		} catch (IOException e) {
			
		}
		try {

			File myObj = new File("StudentList3.sav");
			FileInputStream fi = new FileInputStream(myObj);
			ObjectInputStream oi = new ObjectInputStream(fi);

			while (true) {
				try {

					MasterLessoneSt hp = (MasterLessoneSt) oi.readObject();
					StudentList3.add(hp);
					if (hp == null) {
						break;
					}

				} catch (EOFException exc) {
					// TODO Auto-generated catch block
					break;
				}

			}
		} catch (IOException e) {
			
		}
		try {

			File myObj = new File("StudentList.sav");
			FileInputStream fi = new FileInputStream(myObj);
			ObjectInputStream oi = new ObjectInputStream(fi);

			while (true) {
				try {

					BachelorStT hp = (BachelorStT) oi.readObject();
					StudentList1.add(hp);
					if (hp == null) {
						break;
					}

				} catch (EOFException exc) {
					// TODO Auto-generated catch block
					break;
				}

			}
		} catch (IOException e) {
			
		}
		try {

			File myObj = new File("ClassList1.sav");
			FileInputStream fi = new FileInputStream(myObj);
			ObjectInputStream oi = new ObjectInputStream(fi);

			while (true) {
				try {

					Bachelor hp = (Bachelor) oi.readObject();
					ClassList.add(hp);
					if (hp == null) {
						break;
					}

				} catch (EOFException exc) {
					// TODO Auto-generated catch block
					break;
				}

			}
		} catch (IOException e) {
			
		}

		try {

			File myObj = new File("ClassList2.sav");
			FileInputStream fi = new FileInputStream(myObj);
			ObjectInputStream oi = new ObjectInputStream(fi);

			while (true) {
				try {

					MasterLessone hp = (MasterLessone) oi.readObject();
					ClassList2.add(hp);
					if (hp == null) {
						break;
					}

				} catch (EOFException exc) {
					// TODO Auto-generated catch block
					break;
				}

			}
		} catch (IOException e) {
			
		}

		int k = 0;
		if (Id.charAt(4) == '0') {
			for (int i = 0; i < StudentList2.size(); i++) {
				if (StudentList2.get(i).getStId().equals(Id)) {
					for (int h = 0; h < ClassList.size(); h++) {
						if (StudentList2.get(i).Lessons.isEmpty() && StudentList2.get(i).getStId().charAt(4) == '0') {
							if (ClassList.get(h).getID().equals(lessId) && ClassList.get(h).getCap() != 0
									&& StudentList2.get(i).getLCap() != 0
									&& StudentList2.get(i).getStId().charAt(0) == ClassList.get(h).getID().charAt(0)
									&& StudentList2.get(i).getStId().charAt(1) == ClassList.get(h).getID().charAt(1)
									&& StudentList2.get(i).getStId().charAt(2) == ClassList.get(h).getID().charAt(2)
									&& StudentList2.get(i).getStId().charAt(3) == ClassList.get(h).getID().charAt(3)) {
								StudentList2.get(i).Lessons.add(ClassList.get(h));
								StudentList2.get(i).Lessons.add(ClassList.get(h));
								int vv = StudentList2.get(i).getVahed() - ClassList.get(h).getVahed();
								ClassList.get(h).Students.add(StudentList2.get(i));
								int a = ClassList.get(h).getCap();
								ClassList.get(h).setCap(a - 1);

							}

						} else if (StudentList2.get(i).getStId().charAt(4) == '0') {
							for (int j = 0; j < StudentList2.get(i).Lessons.size(); j++) {
								// conditions for adding student to class ,like time cap and...
								if (ClassList.get(h).getID().equals(lessId)
										&& (StudentList2.get(i).Lessons.get(j).getID()) != (ClassList.get(h).getID())
										&& (StudentList2.get(i).Lessons.get(j).getTime()) != (ClassList.get(h)
												.getTime())
										&& ClassList.get(h).getCap() != 0 && StudentList2.get(i).getLCap() != 0
										&& ClassList.get(h).getPish()
												.equals(StudentList2.get(i).Lessons.get(j).getName())
										&& StudentList2.get(i).getStId().charAt(0) == ClassList.get(h).getID().charAt(0)
										&& StudentList2.get(i).getStId().charAt(1) == ClassList.get(h).getID().charAt(1)
										&& StudentList2.get(i).getStId().charAt(2) == ClassList.get(h).getID().charAt(2)
										&& StudentList2.get(i).getStId().charAt(3) == ClassList.get(h).getID()
												.charAt(3)) {

									StudentList2.get(i).Lessons.add(ClassList.get(h));
									int vv = StudentList2.get(i).getVahed() - ClassList.get(h).getVahed();
									StudentList2.get(i).setVahed(vv);
									System.out.print(true);
									ClassList.get(h).Students.add(StudentList2.get(i));
									System.out.print(true);
									int a = ClassList.get(h).getCap();
									ClassList.get(h).setCap(a - 1);
									int b = StudentList2.get(i).getLCap();
									StudentList2.get(i).setLCap(b - ClassList.get(h).getVahed());
								}
							}
						}
					}
				}
			}

		}
		else if (Id.charAt(4) == '2') {
			for (int i = 0; i < StudentList1.size(); i++) {
				if (StudentList1.get(i).getStId().equals(Id)) {
					for (int h = 0; h < ClassList.size(); h++) {
						if (StudentList1.get(i).Lessons.isEmpty() && StudentList1.get(i).getStId().charAt(4) == '2') {
							if (ClassList.get(h).getID().equals(lessId) && ClassList.get(h).getCap() != 0
									&& StudentList1.get(i).getLCap() != 0
									&& StudentList1.get(i).getStId().charAt(0) == ClassList.get(h).getID().charAt(0)
									&& StudentList1.get(i).getStId().charAt(1) == ClassList.get(h).getID().charAt(1)
									&& StudentList1.get(i).getStId().charAt(2) == ClassList.get(h).getID().charAt(2)
									&& StudentList1.get(i).getStId().charAt(3) == ClassList.get(h).getID().charAt(3)) {
								StudentList1.get(i).Lessons.add(ClassList.get(h));
								StudentList1.get(i).Lessons.add(ClassList.get(h));
								int vv = StudentList1.get(i).getVahed() - ClassList.get(h).getVahed();
								ClassList.get(h).Students.add(StudentList1.get(i));
								int a = ClassList.get(h).getCap();
								ClassList.get(h).setCap(a - 1);

							}

						} else if (StudentList1.get(i).getStId().charAt(4) == '2') {
							for (int j = 0; j < StudentList1.get(i).Lessons.size(); j++) {
								// conditions for adding student to class ,like time cap and...
								if (ClassList.get(h).getID().equals(lessId)
										&& (StudentList1.get(i).Lessons.get(j).getID()) != (ClassList.get(h).getID())
										&& (StudentList1.get(i).Lessons.get(j).getTime()) != (ClassList.get(h)
												.getTime())
										&& ClassList.get(h).getCap() != 0 && StudentList1.get(i).getLCap() != 0
										&& ClassList.get(h).getPish()
												.equals(StudentList1.get(i).Lessons.get(j).getName())
										&& StudentList1.get(i).getStId().charAt(0) == ClassList.get(h).getID().charAt(0)
										&& StudentList1.get(i).getStId().charAt(1) == ClassList.get(h).getID().charAt(1)
										&& StudentList1.get(i).getStId().charAt(2) == ClassList.get(h).getID().charAt(2)
										&& StudentList1.get(i).getStId().charAt(3) == ClassList.get(h).getID()
												.charAt(3)) {

									StudentList1.get(i).Lessons.add(ClassList.get(h));
									int vv = StudentList1.get(i).getVahed() - ClassList.get(h).getVahed();
									StudentList1.get(i).setVahed(vv);
									System.out.print(true);
									ClassList.get(h).Students.add(StudentList1.get(i));
									System.out.print(true);
									int a = ClassList.get(h).getCap();
									ClassList.get(h).setCap(a - 1);
									int b = StudentList1.get(i).getLCap();
									StudentList1.get(i).setLCap(b - ClassList.get(h).getVahed());
								}
							}
						}
					}
				}
			}

		} 
		
		
		else if (Id.charAt(4) == '1') {
			for (int i = 0; i < StudentList3.size(); i++) {
				if (StudentList3.get(i).getStId().equals(Id)) {
					for (int h = 0; h < ClassList2.size(); h++) {
						if (StudentList3.get(i).Lessons.isEmpty() && StudentList3.get(i).getStId().charAt(4) == '1') {
							if (ClassList2.get(h).getID().equals(lessId) && ClassList2.get(h).getCap() != 0
									&& StudentList3.get(i).getLCap() != 0
									&& StudentList3.get(i).getStId().charAt(0) == ClassList2.get(h).getID().charAt(0)
									&& StudentList3.get(i).getStId().charAt(1) == ClassList2.get(h).getID().charAt(1)
									&& StudentList3.get(i).getStId().charAt(2) == ClassList2.get(h).getID().charAt(2)
									&& StudentList3.get(i).getStId().charAt(3) == ClassList2.get(h).getID().charAt(3)) {
								StudentList3.get(i).Lessons.add(ClassList2.get(h));
								int vv = StudentList3.get(i).getVahed() - ClassList2.get(h).getVahed();
								StudentList3.get(i).setVahed(vv);
								ClassList2.get(h).Students.add(StudentList3.get(i));
								int a = ClassList2.get(h).getCap();
								ClassList2.get(h).setCap(a - 1);

							}

						} else if (StudentList3.get(i).getStId().charAt(4) == '1') {
							for (int j = 0; j < StudentList3.get(i).Lessons.size(); j++) {
								// conditions for adding student to class ,like time cap and...
								if (ClassList2.get(h).getID().equals(lessId)
										&& (StudentList3.get(i).Lessons.get(j).getID()) != (ClassList2.get(h).getID())
										&& (StudentList3.get(i).Lessons.get(j).getTime()) != (ClassList2.get(h)
												.getTime())
										&& ClassList2.get(h).getCap() != 0 && StudentList3.get(i).getLCap() != 0
										&& ClassList2.get(h).getPish()
												.equals(StudentList3.get(i).Lessons.get(j).getName())
										&& StudentList3.get(i).getStId().charAt(0) == ClassList2.get(h).getID()
												.charAt(0)
										&& StudentList3.get(i).getStId().charAt(1) == ClassList2.get(h).getID()
												.charAt(1)
										&& StudentList3.get(i).getStId().charAt(2) == ClassList2.get(h).getID()
												.charAt(2)
										&& StudentList3.get(i).getStId().charAt(3) == ClassList2.get(h).getID()
												.charAt(3)) {

									StudentList3.get(i).Lessons.add(ClassList2.get(h));
									int vv = StudentList3.get(i).getVahed() - ClassList2.get(h).getVahed();
									StudentList3.get(i).setVahed(vv);
									System.out.print(true);
									ClassList2.get(h).Students.add(StudentList3.get(i));
									System.out.print(true);
									int a = ClassList2.get(h).getCap();
									ClassList2.get(h).setCap(a - 1);
									int b = StudentList3.get(i).getLCap();
									StudentList3.get(i).setLCap(b - ClassList2.get(h).getVahed());
								}
							}
						}

					}
				}
			}
		}
		try {
			File myObj = new File("ClassList1.sav");
			myObj.delete();
			File myObj1 = new File("ClassList1.sav");
			FileOutputStream myWriter = new FileOutputStream(myObj1, true);
			ObjectOutputStream o = new ObjectOutputStream(myWriter);
			for (int i = 0; i < ClassList.size(); i++) {
				o.writeObject(ClassList.get(i));

			}
		
		} catch (IOException e) {
			
		}
		try {
			File myObj = new File("ClassList2.sav");
			myObj.delete();
			File myObj1 = new File("ClassList2.sav");
			FileOutputStream myWriter = new FileOutputStream(myObj1, true);
			ObjectOutputStream o = new ObjectOutputStream(myWriter);
			for (int i = 0; i < ClassList2.size(); i++) {
				o.writeObject(ClassList2.get(i));

			}
			
		} catch (IOException e) {
			
		}
		try {
			File myObj = new File("StudentList.sav");
			myObj.delete();
			File myObj1 = new File("StudentList.sav");
			FileOutputStream myWriter = new FileOutputStream(myObj1, true);
			ObjectOutputStream o = new ObjectOutputStream(myWriter);
			for (int i = 0; i < StudentList1.size(); i++) {
				o.writeObject(StudentList1.get(i));

			}
			
		} catch (IOException e) {
			
		}
		try {
			File myObj = new File("StudentList2.sav");
			myObj.delete();
			File myObj1 = new File("StudentList2.sav");
			FileOutputStream myWriter = new FileOutputStream(myObj1, true);
			ObjectOutputStream o = new ObjectOutputStream(myWriter);
			for (int i = 0; i < StudentList2.size(); i++) {
				o.writeObject(StudentList2.get(i));

			}
			
		} catch (IOException e) {
			
		}
		try {
			File myObj = new File("StudentList3.sav");
			myObj.delete();
			File myObj1 = new File("StudentList3.sav");
			FileOutputStream myWriter = new FileOutputStream(myObj1, true);
			ObjectOutputStream o = new ObjectOutputStream(myWriter);
			for (int i = 0; i < StudentList3.size(); i++) {
				o.writeObject(StudentList3.get(i));

			}
		
		} catch (IOException e) {
			
		}
	}
	public void addLessonCap(String id) {
		if (id.charAt(4) == '1') {
			for(int i=0; i<ClassList.size(); i++) {
				if(id==ClassList.get(i).getID()) {
				ClassList.get(i).addCap();
				}
			}
		}
	}

//method for adding lesson to ClassList ArrayList
	public void addLesson(String id, String name, int time, String Pish, String prof, String field1, int vahed , int Cap)
			throws ClassNotFoundException, FileNotFoundException {

		try {

			File myObj = new File("ProfList.sav");
			FileInputStream fi = new FileInputStream(myObj);
			ObjectInputStream oi = new ObjectInputStream(fi);

			while (true) {
				try {

					HiredProf hp = (HiredProf) oi.readObject();
					ProfList.add(hp);
					if (hp == null) {
						break;
					}

				} catch (EOFException exc) {
					// TODO Auto-generated catch block
					break;
				}

			}
		} catch (IOException e) {
			
		}

		try {

			File myObj = new File("ProfList1.sav");
			Object line;

			FileInputStream fi = new FileInputStream(myObj);
			ObjectInputStream oi = new ObjectInputStream(fi);
			while (true) {
				try {

					TemporaryProf tp = (TemporaryProf) oi.readObject();
					ProfList1.add(tp);
					if (tp == null) {
						break;
					}

				} catch (EOFException exc) {
					// TODO Auto-generated catch block
					break;
				}

			}
		} catch (IOException e) {
			
		}
		try {
			File myObj = new File("Filed.sav");

			Object line;

			FileInputStream fi = new FileInputStream(myObj);
			ObjectInputStream oi = new ObjectInputStream(fi);
			while (true) {
				try {

					Field field2 = (Field) oi.readObject();
					field.add(field2);
					if (field == null) {
						break;
					}

				} catch (EOFException exc) {
					// TODO Auto-generated catch block
					break;
				}

			}
		} catch (IOException e) {
			
		}

		if (ClassList.isEmpty()) {
			// Class class1 = new Class(id, name);
			if (id.charAt(4) == '1') {
				String name11 = null;
				Bachelor class1 = new Bachelor(id, name);
				class1.setTime(time);
				class1.setCap(Cap);
				class1.setPish(Pish);
				class1.setVahed(vahed);
				if (prof.charAt(4) == '1') {
					for (int i = 0; i < ProfList.size(); i++) {
						if (prof.equals(ProfList.get(i).getProfId())) {
							ProfList.get(i).Lessons.add(class1);
							class1.setProf(ProfList.get(i));
						}
					}
				} else if (prof.charAt(4) == '0') {
					for (int i = 0; i < ProfList1.size(); i++) {
						if (prof.equals(ProfList1.get(i).getProfId())) {
							ProfList1.get(i).Lessons.add(class1);
							class1.setProf(ProfList1.get(i));
						}
					}
				}
				for (int i = 0; i < field.size(); i++) {
					if (field1.equals(field.get(i).getField())) {
						if (id.charAt(5) == '1') {
							field.get(i).dars.add(class1);
						} else if (id.charAt(5) == '0') {
							field.get(i).Odars.add(class1);
						}
					}
				}
				try {
					File myObj = new File("ClassList1.sav");

					if (myObj.createNewFile()) {
						System.out.println("File created: " + myObj.getName());
					} else {
						System.out.println("File already exists.");
					}
				} catch (IOException e) {
					System.out.println("An error occurred.");
					
				}
				try {

					FileOutputStream myWriter = new FileOutputStream("ClassList1.sav", true);
					ObjectOutputStream o = new ObjectOutputStream(myWriter);

					o.writeObject(class1);
					ClassList.add(class1);
					myWriter.close();
					System.out.println("Successfully wrote to the file.");
				} catch (IOException e) {
					System.out.println("An error occurred.");
					
				}

			} else if (id.charAt(4) == '0') {
				String name11 = null;

				MasterLessone class2 = new MasterLessone(id, name);
				class2.setTime(time);
				class2.setCap(Cap);
				class2.setPish(Pish);
				class2.setVahed(vahed);
				if (prof.charAt(4) == '1') {
					for (int i = 0; i < ProfList.size(); i++) {
						if (prof.equals(ProfList.get(i).getProfId())) {
							ProfList.get(i).Lessons1.add(class2);
							class2.setProf(ProfList.get(i));
						}
					}
				} else if (prof.charAt(4) == '0') {
					for (int i = 0; i < ProfList1.size(); i++) {
						if (prof.equals(ProfList1.get(i).getProfId())) {
							ProfList1.get(i).Lessons1.add(class2);
							class2.setProf(ProfList1.get(i));
						}
					}
				}
				for (int i = 0; i < field.size(); i++) {
					if (field1.equals(field.get(i).getField())) {
						if (id.charAt(5) == '1') {
							field.get(i).dars.add(class2);
						} else if (id.charAt(5) == '0') {
							field.get(i).Odars.add(class2);
						}
					}
				}
				ClassList2.add(class2);
				try {
					File myObj = new File("ClassList2.sav");

					if (myObj.createNewFile()) {
						System.out.println("File created: " + myObj.getName());
					} else {
						System.out.println("File already exists.");
					}
				} catch (IOException e) {
					System.out.println("An error occurred.");
					
				}
				try {

					FileOutputStream myWriter = new FileOutputStream("ClassList2.sav", true);
					ObjectOutputStream o = new ObjectOutputStream(myWriter);

					o.writeObject(class2);
					ClassList2.add(class2);
					myWriter.close();
					System.out.println("Successfully wrote to the file.");
				} catch (IOException e) {
					System.out.println("An error occurred.");
					
				}
			}
		} else {
			if (id.charAt(4) == '1') {

				for (int i = 0; i < ClassList.size(); i++) {
					// if the class that you want to add to ArrayList is not in it then it can add
					// ti to ArrayList
					if (ClassList.get(i).getID() != id) {
						String name11 = null;

						// System.out.print(true);
						Bachelor class1 = new Bachelor(id, name);
						class1.setTime(time);
						class1.setCap(Cap);
						class1.setPish(Pish);

						class1.setVahed(vahed);
						if (prof.charAt(4) == '1') {
							for (int i1 = 0; i1 < ProfList.size(); i1++) {
								if (prof.equals(ProfList.get(i).getProfId())) {
									ProfList.get(i).Lessons.add(class1);
									class1.setProf(ProfList.get(i));
								}
							}
						} else if (prof.charAt(4) == '0') {
							for (int i1 = 0; i1 < ProfList1.size(); i1++) {
								if (prof.equals(ProfList1.get(i1).getProfId())) {
									ProfList1.get(i1).Lessons.add(class1);
									class1.setProf(ProfList1.get(i1));
								}
							}
						}
						for (int i1 = 0; i1 < field.size(); i1++) {
							if (field1.equals(field.get(i1).getField())) {
								if (id.charAt(5) == '1') {
									field.get(i1).dars.add(class1);
								} else if (id.charAt(5) == '0') {
									field.get(i1).Odars.add(class1);
								}
							}
						}
						try {
							File myObj = new File("ClassList1.sav");

							if (myObj.createNewFile()) {
								System.out.println("File created: " + myObj.getName());
							} else {
								System.out.println("File already exists.");
							}
						} catch (IOException e) {
							System.out.println("An error occurred.");
							
						}
						try {

							FileOutputStream myWriter = new FileOutputStream("ClassList1.sav", true);
							ObjectOutputStream o = new ObjectOutputStream(myWriter);

							o.writeObject(class1);
							ClassList.add(class1);
							myWriter.close();
							System.out.println("Successfully wrote to the file.");
						} catch (IOException e) {
							System.out.println("An error occurred.");
							
						}

						// System.out.print(true);
					}
				}
			} else if (id.charAt(4) == '0') {
				for (int i = 0; i < ClassList2.size(); i++) {
					// if the class that you want to add to ArrayList is not in it then it can add
					// ti to ArrayList
					if (ClassList2.get(i).getID() != id) {
						// System.out.print(true);
						String name11 = null;

						MasterLessone class2 = new MasterLessone(id, name);
						class2.setTime(time);
						class2.setCap(Cap);
						class2.setPish(Pish);
						class2.setVahed(vahed);
						if (prof.charAt(4) == '1') {
							for (int i1 = 0; i1 < ProfList.size(); i1++) {
								if (prof.equals(ProfList.get(i1).getProfId())) {
									ProfList.get(i1).Lessons1.add(class2);
									class2.setProf(ProfList.get(i1));
								}
							}
						} else if (prof.charAt(4) == '0') {
							for (int i1 = 0; i1 < ProfList1.size(); i1++) {
								if (prof.equals(ProfList1.get(i).getProfId())) {
									ProfList1.get(i1).Lessons1.add(class2);
									class2.setProf(ProfList1.get(i1));
								}
							}
						}
						for (int i2 = 0; i2 < field.size(); i2++) {
							if (field1.equals(field.get(i).getField())) {
								if (id.charAt(5) == '1') {
									field.get(i2).dars.add(class2);
								} else if (id.charAt(5) == '0') {
									field.get(i2).Odars.add(class2);
								}
							}
						}
						try {
							File myObj = new File("ClassList2.sav");

							if (myObj.createNewFile()) {
								System.out.println("File created: " + myObj.getName());
							} else {
								System.out.println("File already exists.");
							}
						} catch (IOException e) {
							System.out.println("An error occurred.");
							
						}
						try {
							File myObj = new File("ClassList2.sav");
							FileOutputStream myWriter = new FileOutputStream(myObj, true);
							ObjectOutputStream o = new ObjectOutputStream(myWriter);

							o.writeObject(class2);
							ClassList2.add(class2);
							myWriter.close();
							System.out.println("Successfully wrote to the file.");
						} catch (IOException e) {
							System.out.println("An error occurred.");
							
						}

						// System.out.print(true);
					}
				}
			}
		}

		try {
			File myObj = new File("ProfList.sav");
			myObj.delete();
			File myObj1 = new File("ProfList.sav");
			FileOutputStream myWriter = new FileOutputStream(myObj1, true);
			ObjectOutputStream o = new ObjectOutputStream(myWriter);
			for (int i = 0; i < ProfList.size(); i++) {
				o.writeObject(ProfList.get(i));

			}
			
		} catch (IOException e) {
			
		}
		try {
			File myObj = new File("ProfList1.sav");
			myObj.delete();
			File myObj1 = new File("ProfList1.sav");
			FileOutputStream myWriter = new FileOutputStream(myObj1, true);
			ObjectOutputStream o = new ObjectOutputStream(myWriter);
			for (int i = 0; i < ProfList1.size(); i++) {
				o.writeObject(ProfList1.get(i));

			}
			
		} catch (IOException e) {
			
		}

		try {
			File myObj = new File("Field.sav");
			myObj.delete();
			File myObj1 = new File("Field.sav");
			FileOutputStream myWriter = new FileOutputStream(myObj1, true);
			ObjectOutputStream o = new ObjectOutputStream(myWriter);
			for (int i = 0; i < field.size(); i++) {
				o.writeObject(field.get(i));

			}
			//field.removeAll(field);
		} catch (IOException e) {
			
		}

	}

	public void setGrade(String stId, String stLesson, int grade) throws ClassNotFoundException, FileNotFoundException {
		try {

			File myObj = new File("StudentList.sav");
			Object line;

			FileInputStream fi = new FileInputStream(myObj);
			ObjectInputStream oi = new ObjectInputStream(fi);
			while (true) {
				try {

					BachelorStT tp = (BachelorStT) oi.readObject();
					StudentList1.add(tp);
					if (tp == null) {
						break;
					}

				} catch (EOFException exc) {
					// TODO Auto-generated catch block
					break;
				}

			}
		} catch (IOException e) {
		
		}
		try {

			File myObj = new File("StudentList2.sav");
			Object line;

			FileInputStream fi = new FileInputStream(myObj);
			ObjectInputStream oi = new ObjectInputStream(fi);
			while (true) {
				try {

					BachelorSt tp = (BachelorSt) oi.readObject();
					StudentList2.add(tp);
					if (tp == null) {
						break;
					}

				} catch (EOFException exc) {
					// TODO Auto-generated catch block
					break;
				}

			}
		} catch (IOException e) {
			
		}
		try {

			File myObj = new File("StudentList3.sav");
			Object line;

			FileInputStream fi = new FileInputStream(myObj);
			ObjectInputStream oi = new ObjectInputStream(fi);
			while (true) {
				try {

					MasterLessoneSt tp = (MasterLessoneSt) oi.readObject();
					StudentList3.add(tp);
					if (tp == null) {
						break;
					}

				} catch (EOFException exc) {
					// TODO Auto-generated catch block
					break;
				}

			}
		} catch (IOException e) {
			
		}
		if (stId.charAt(4) == '0') {
			for (int i = 0; i < StudentList2.size(); i++) {
				if (stId.equals(StudentList2.get(i).getId())) {
					for (int j = 0; j < StudentList2.get(i).Lessons.size(); j++) {
						if (stLesson.equals(StudentList2.get(i).Lessons.get(j).getID())) {
							StudentList2.get(i).Lessons.get(j).setGrade(grade);
							StudentList2.get(i).LessonsPassed.add(StudentList2.get(i).Lessons.get(j));
						}
					}
				}
			}
		} else if (stId.charAt(4) == '1') {
			for (int i = 0; i < StudentList3.size(); i++) {
				if (stId.equals(StudentList3.get(i).getId())) {
					for (int j = 0; j < StudentList3.get(i).Lessons.size(); j++) {
						if (stLesson.equals(StudentList3.get(i).Lessons.get(j).getID())) {
							StudentList3.get(i).Lessons.get(j).setGrade(grade);
							StudentList3.get(i).LessonsPassed.add(StudentList3.get(i).Lessons.get(j));
						}
					}
				}
			}
		}
		try {
			File myObj = new File("StudentList.sav");
			myObj.delete();
			File myObj1 = new File("StudentList.sav");
			FileOutputStream myWriter = new FileOutputStream(myObj1, true);
			ObjectOutputStream o = new ObjectOutputStream(myWriter);
			for (int i = 0; i < StudentList3.size(); i++) {
				o.writeObject(StudentList3.get(i));

			}
		
		} catch (IOException e) {
			
		}
		try {
			File myObj = new File("StudentList2.sav");
			myObj.delete();
			File myObj1 = new File("StudentList2.sav");
			FileOutputStream myWriter = new FileOutputStream(myObj1, true);
			ObjectOutputStream o = new ObjectOutputStream(myWriter);
			for (int i = 0; i < StudentList2.size(); i++) {
				o.writeObject(StudentList2.get(i));

			}
			
		} catch (IOException e) {
		
		}
		try {
			File myObj = new File("StudentList3.sav");
			myObj.delete();
			File myObj1 = new File("StudentList3.sav");
			FileOutputStream myWriter = new FileOutputStream(myObj1, true);
			ObjectOutputStream o = new ObjectOutputStream(myWriter);
			for (int i = 0; i < StudentList3.size(); i++) {
				o.writeObject(StudentList3.get(i));

			}
			
		} catch (IOException e) {
			
		}
	}

	public void ShowGrade(String stId) throws ClassNotFoundException, FileNotFoundException {
		try {

			File myObj = new File("StudentList2.sav");
			Object line;

			FileInputStream fi = new FileInputStream(myObj);
			ObjectInputStream oi = new ObjectInputStream(fi);
			while (true) {
				try {

					BachelorSt tp = (BachelorSt) oi.readObject();
					StudentList2.add(tp);
					if (tp == null) {
						break;
					}

				} catch (EOFException exc) {
					// TODO Auto-generated catch block
					break;
				}

			}
		} catch (IOException e) {
		
		}
		try {

			File myObj = new File("StudentList3.sav");
			Object line;

			FileInputStream fi = new FileInputStream(myObj);
			ObjectInputStream oi = new ObjectInputStream(fi);
			while (true) {
				try {

					MasterLessoneSt tp = (MasterLessoneSt) oi.readObject();
					StudentList3.add(tp);
					if (tp == null) {
						break;
					}

				} catch (EOFException exc) {
					// TODO Auto-generated catch block
					break;
				}

			}
		} catch (IOException e) {
		
		}
		try {

			File myObj = new File("StudentList.sav");
			Object line;

			FileInputStream fi = new FileInputStream(myObj);
			ObjectInputStream oi = new ObjectInputStream(fi);
			while (true) {
				try {

					BachelorStT tp = (BachelorStT) oi.readObject();
					StudentList1.add(tp);
					if (tp == null) {
						break;
					}

				} catch (EOFException exc) {
					// TODO Auto-generated catch block
					break;
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (stId.charAt(4) == '0') {
			for (int i = 0; i < StudentList2.size(); i++) {
				if (stId.equals(StudentList2.get(i).getId())) {
					for (int j = 0; j < StudentList2.get(i).LessonsPassed.size(); j++) {
						System.out.println("lesson name: " + StudentList2.get(i).LessonsPassed.get(j).getName()
								+ " Grade:" + StudentList2.get(i).LessonsPassed.get(j).getGrade());
					}
				}
			}
		} else if (stId.charAt(4) == '1') {
			for (int i = 0; i < StudentList3.size(); i++) {
				if (stId.equals(StudentList3.get(i).getId())) {
					for (int j = 0; j < StudentList3.get(i).LessonsPassed.size(); j++) {
						System.out.println("lesson name: " + StudentList3.get(i).LessonsPassed.get(j).getName()
								+ " Grade:" + StudentList3.get(i).LessonsPassed.get(j).getGrade());
					}
				}
			}
		}
		if (stId.charAt(4) == '2') {
			for (int i = 0; i < StudentList1.size(); i++) {
				if (stId.equals(StudentList1.get(i).getId())) {
					for (int j = 0; j < StudentList1.get(i).LessonsPassed.size(); j++) {
						System.out.println("lesson name: " + StudentList1.get(i).LessonsPassed.get(j).getName()
								+ " Grade:" + StudentList1.get(i).LessonsPassed.get(j).getGrade());
					}
				}
			}
		}
		/*StudentList1.removeAll(StudentList1);
		StudentList2.removeAll(StudentList2);
		StudentList3.removeAll(StudentList3);*/
	}

	// for showing students of one class
	public void ShowClassSt(String id) throws ClassNotFoundException, FileNotFoundException {
		try {

			File myObj = new File("ClassList1.sav");
			Object line;

			FileInputStream fi = new FileInputStream(myObj);
			ObjectInputStream oi = new ObjectInputStream(fi);
			while (true) {
				try {

					Bachelor tp = (Bachelor) oi.readObject();
					ClassList.add(tp);
					if (tp == null) {
						break;
					}

				} catch (EOFException exc) {
					// TODO Auto-generated catch block
					break;
				}

			}
		} catch (IOException e) {
			
		}
		try {

			File myObj = new File("ClassList2.sav");
			Object line;

			FileInputStream fi = new FileInputStream(myObj);
			ObjectInputStream oi = new ObjectInputStream(fi);
			while (true) {
				try {

					MasterLessone tp = (MasterLessone) oi.readObject();
					ClassList2.add(tp);
					if (tp == null) {
						break;
					}

				} catch (EOFException exc) {
					// TODO Auto-generated catch block
					break;
				}

			}
		} catch (IOException e) {
			
		}
		// use the id to find class and show the students use for loop
		for (int i = 0; i < ClassList.size(); i++) {
			if (ClassList.get(i).getID().equals(id)) {
				for (int j = 0; j < ClassList.get(i).Students.size(); j++) {
					System.out.println("first name"+ClassList.get(i).Students.get(j).getFirstName()+"last name"+ClassList.get(i).Students.get(j).getLastName()+"Id"+ClassList.get(i).Students.get(j).getId());
				}
				
			
			}
		}
		for (int i = 0; i < ClassList2.size(); i++) {
			if (ClassList2.get(i).getID().equals(id)) {
				for (int j = 0; j < ClassList2.get(i).Students.size(); j++) {
					System.out.println("first name"+ClassList2.get(i).Students.get(j).getFirstName()+"last name"+ClassList2.get(i).Students.get(j).getLastName()+"Id"+ClassList2.get(i).Students.get(j).getId());
				}
			}
		}
		/*ClassList.removeAll(ClassList);
		ClassList2.removeAll(ClassList2);*/
	}

	public void ShowClassprof(String id) throws ClassNotFoundException, FileNotFoundException {
		try {

			File myObj = new File("ClassList1.sav");
			Object line;

			FileInputStream fi = new FileInputStream(myObj);
			ObjectInputStream oi = new ObjectInputStream(fi);
			while (true) {
				try {

					Bachelor tp = (Bachelor) oi.readObject();
					ClassList.add(tp);
					if (tp == null) {
						break;
					}

				} catch (EOFException exc) {
					// TODO Auto-generated catch block
					break;
				}

			}
		} catch (IOException e) {
		
		}
		try {

			File myObj = new File("ClassList2.sav");
			Object line;

			FileInputStream fi = new FileInputStream(myObj);
			ObjectInputStream oi = new ObjectInputStream(fi);
			while (true) {
				try {

					MasterLessone tp = (MasterLessone) oi.readObject();
					ClassList2.add(tp);
					if (tp == null) {
						break;
					}

				} catch (EOFException exc) {
					// TODO Auto-generated catch block
					break;
				}

			}
		} catch (IOException e) {
			
		}
		// use the id to find class and show the students use for loop
		
		for (int i = 0; i < ClassList.size(); i++) {
			if (ClassList.get(i).getID().equals(id)) {
				System.out.println("prof id: "+ClassList.get(i).getProf().getProfId()+"prof name:"+ClassList.get(i).getProf().getFirstName()+"prof LastName:"+ClassList.get(i).getProf().getLastName());
			}
		}
		for (int i = 0; i < ClassList2.size(); i++) {
			if (ClassList2.get(i).getID().equals(id)) {
				System.out.println("prof id: "+ClassList2.get(i).getProf().getProfId()+"prof name:"+ClassList2.get(i).getProf().getFirstName()+"prof LastName:"+ClassList2.get(i).getProf().getLastName());
				
			}
		}
	/*	ClassList.removeAll(ClassList);
		ClassList2.removeAll(ClassList2);*/
	}

//show all classes that we add to ClassList ArrayList 
	public void ShowAllClass() throws ClassNotFoundException, FileNotFoundException {
		try {
			File myObj = new File("ClassList1.sav");

			Object line;

			FileInputStream fi = new FileInputStream(myObj);
			ObjectInputStream oi = new ObjectInputStream(fi);
			while (true) {

				try {
					Bachelor field2 = (Bachelor) oi.readObject();
					ClassList.add(field2);
					if (field == null) {
						break;
					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					
				} catch (EOFException exc) {
					// TODO Auto-generated catch block
					break;
				}

			}
		} catch (IOException e) {
			
		}

		try {
			File myObj = new File("ClassList2.sav");

			Object line;

			FileInputStream fi = new FileInputStream(myObj);
			ObjectInputStream oi = new ObjectInputStream(fi);
			while (true) {

				try {
					MasterLessone field2 = (MasterLessone) oi.readObject();
					ClassList2.add(field2);
					if (field == null) {
						break;
					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					
				} catch (EOFException exc) {
					// TODO Auto-generated catch block
					break;
				}

			}
		} catch (IOException e) {
			
		}
		for (int i = 0; i < ClassList.size(); i++) {
			System.out.println("Class Id:" + ClassList.get(i).getID() + " Class name:" + ClassList.get(i).getName()
					+ " Class Pishniaz:" + ClassList.get(i).getPish() + " Class name:" + ClassList.get(i).getCap());

		}
		System.out.println(
				"//////////////////////////////////////////////////////////////////////////////////////////////////");
		for (int i = 0; i < ClassList2.size(); i++) {
			System.out.println("Class Id:" + ClassList2.get(i).getID() + " Class name:" + ClassList2.get(i).getName()
					+ " Class Pishniaz:" + ClassList2.get(i).getPish() + " Class name:" + ClassList2.get(i).getCap());
		}
		/*ClassList.removeAll(ClassList);
		ClassList2.removeAll(ClassList2);*/
	}

	// for showing classes of student
	public void ShowStClass(String Id) throws ClassNotFoundException, FileNotFoundException {
		try {
			File myObj = new File("StudentList2.sav");

			Object line;

			FileInputStream fi = new FileInputStream(myObj);
			ObjectInputStream oi = new ObjectInputStream(fi);
			while (true) {

				try {
					BachelorSt field2 = (BachelorSt) oi.readObject();
					StudentList2.add(field2);
					if (field == null) {
						break;
					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
				
				} catch (EOFException exc) {
					// TODO Auto-generated catch block
					break;
				}

			}
		} catch (IOException e) {
			
		}
		try {
			File myObj = new File("StudentList3.sav");

			Object line;

			FileInputStream fi = new FileInputStream(myObj);
			ObjectInputStream oi = new ObjectInputStream(fi);
			while (true) {

				try {
					MasterLessoneSt field2 = (MasterLessoneSt) oi.readObject();
					StudentList3.add(field2);
					if (field == null) {
						break;
					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					
				} catch (EOFException exc) {
					// TODO Auto-generated catch block
					break;
				}

			}
		} catch (IOException e) {
			
		}
		try {
			File myObj = new File("StudentList.sav");

			Object line;

			FileInputStream fi = new FileInputStream(myObj);
			ObjectInputStream oi = new ObjectInputStream(fi);
			while (true) {

				try {
					BachelorStT field2 = (BachelorStT) oi.readObject();
					StudentList1.add(field2);
					if (field == null) {
						break;
					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					
				} catch (EOFException exc) {
					// TODO Auto-generated catch block
					break;
				}

			}
		} catch (IOException e) {
			
		}
		if(Id.charAt(4)=='2') {
		for (int i = 0; i < StudentList1.size(); i++) {
			if (StudentList1.get(i).getId().equals(Id)) {
				for (int j = 0; j < StudentList1.get(i).Lessons.size(); j++) {
					System.out.println("Class id:" + StudentList1.get(i).Lessons.get(j).getID() + " Class name:"
							+ StudentList1.get(i).Lessons.get(j).getName());
				}

			}
		}
		}
		else if(Id.charAt(4)=='0') {
			for (int i = 0; i < StudentList2.size(); i++) {
				if (StudentList2.get(i).getId().equals(Id)) {
					for (int j = 0; j < StudentList2.get(i).Lessons.size(); j++) {
						System.out.println("Class id:" + StudentList2.get(i).Lessons.get(j).getID() + " Class name:"
								+ StudentList2.get(i).Lessons.get(j).getName());
					}

				}
			}
			}
		else if(Id.charAt(4)=='1') {
			for (int i = 0; i < StudentList3.size(); i++) {
				if (StudentList3.get(i).getId().equals(Id)) {
					for (int j = 0; j < StudentList3.get(i).Lessons.size(); j++) {
						System.out.println("Class id:" + StudentList3.get(i).Lessons.get(j).getID() + " Class name:"
								+ StudentList3.get(i).Lessons.get(j).getName());
					}

				}
			}
			}

		/*StudentList1.removeAll(StudentList1);
		StudentList2.removeAll(StudentList2);
		StudentList3.removeAll(StudentList3);*/
	}

	public void ShowAllProf() throws ClassNotFoundException, FileNotFoundException {
		try {
			File myObj = new File("ProfList.sav");

			Object line;

			FileInputStream fi = new FileInputStream(myObj);
			ObjectInputStream oi = new ObjectInputStream(fi);
			while (true) {

				try {
					HiredProf field2 = (HiredProf) oi.readObject();
					ProfList.add(field2);
					if (field == null) {
						break;
					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					
				} catch (EOFException exc) {
					// TODO Auto-generated catch block
					break;
				}

			}
		} catch (IOException e) {
			
		}
		try {
			File myObj = new File("ProfList1.sav");

			Object line;

			FileInputStream fi = new FileInputStream(myObj);
			ObjectInputStream oi = new ObjectInputStream(fi);
			while (true) {

				try {
					TemporaryProf field2 = (TemporaryProf) oi.readObject();
					ProfList1.add(field2);
					if (field == null) {
						break;
					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
				
				} catch (EOFException exc) {
					// TODO Auto-generated catch block
					break;
				}

			}
		} catch (IOException e) {
			
		}
		System.out.println("List1");
		for (int i = 0; i < ProfList.size(); i++) {
			System.out.println("Prof Id:" + ProfList.get(i).getProfId() + " Prof PassWord:"
					+ ProfList.get(i).getProfPass() + " Prof first name:" + ProfList.get(i).getFirstName()
					+ " Prof last name:" + ProfList.get(i).getLastName() + " Prof name:" + ProfList.get(i));

		}
		System.out.println(
				"//////////////////////////////////////////////////////////////////////////////////////////////////");
		System.out.println("List2");
		for (int j = 0; j < ProfList1.size(); j++) {
			System.out.println("Prof Id:" + ProfList1.get(j).getProfId() + " Prof PassWord:"
					+ ProfList1.get(j).getProfPass() + " Prof first name:" + ProfList1.get(j).getFirstName()
					+ " Prof last name:" + ProfList1.get(j).getLastName());
			}
		/*ProfList.removeAll(ProfList);
		ProfList1.removeAll(ProfList1);*/
	}

	public void showProfInfo(String profId) {
		try {
			File myObj = new File("ProfList.sav");

			Object line;

			FileInputStream fi = new FileInputStream(myObj);
			ObjectInputStream oi = new ObjectInputStream(fi);
			while (true) {

				try {
					HiredProf field2 = (HiredProf) oi.readObject();
					ProfList.add(field2);
					if (field == null) {
						break;
					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					
				} catch (EOFException exc) {
					// TODO Auto-generated catch block
					break;
				}

			}
		} catch (IOException e) {
		
		}
		try {
			File myObj = new File("ProfList1.sav");

			Object line;

			FileInputStream fi = new FileInputStream(myObj);
			ObjectInputStream oi = new ObjectInputStream(fi);
			while (true) {

				try {
					TemporaryProf field2 = (TemporaryProf) oi.readObject();
					ProfList1.add(field2);
					if (field == null) {
						break;
					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					
				} catch (EOFException exc) {
					// TODO Auto-generated catch block
					break;
				}

			}
		} catch (IOException e) {
			
		}
		if (profId.charAt(4) == '1') {
			for (int i = 0; i < ProfList.size(); i++) {
				if (profId.equals(ProfList.get(i).getProfId())) {
					System.out.println("Prof Id:" + ProfList.get(i).getProfId() + " Prof PassWord:"
							+ ProfList.get(i).getProfPass() + " Prof first name:" + ProfList.get(i).getFirstName()
							+ " Prof last name:" + ProfList.get(i).getLastName() + " Prof name:" + ProfList.get(i));
					System.out.println("BLesson:");
					for(int j=0; j<ProfList1.get(i).Lessons.size(); j++) {
						System.out.println("lesson name:"+ProfList1.get(i).Lessons.get(j).getName());
					}
					System.out.println("MLesson:");
					for(int k=0; k<ProfList1.get(i).Lessons.size(); k++) {
						System.out.println("lesson name:"+ProfList1.get(i).Lessons1.get(k).getName());
					}
				}
			}
		} else if (profId.charAt(4) == '0') {
			for (int i = 0; i < ProfList1.size(); i++) {
				if (profId.equals(ProfList1.get(i).getProfId())) {
					System.out.println("Prof Id:" + ProfList1.get(i).getProfId() + " Prof PassWord:"
							+ ProfList1.get(i).getProfPass() + " Prof first name:" + ProfList1.get(i).getFirstName()
							+ " Prof last name:" + ProfList1.get(i).getLastName() + " Prof name:" + ProfList1.get(i));
					System.out.println("BLesson:");
					for(int j=0; j<ProfList1.get(i).Lessons.size(); j++) {
						System.out.println("lesson name:"+ProfList1.get(i).Lessons.get(j).getName());
					}
					System.out.println("MLesson:");
					for(int k=0; k<ProfList1.get(i).Lessons.size(); k++) {
						System.out.println("lesson name:"+ProfList1.get(i).Lessons1.get(k).getName());
					}
				}
			}
		}
		/*ProfList.removeAll(ProfList);
		ProfList1.removeAll(ProfList1);*/
	}

	// method for leave a class by student using id of student and id of class
	public void LeaveClass(String ClassId, String StId) throws ClassNotFoundException, FileNotFoundException {
		try {
			File myObj = new File("StudentList.sav");

			Object line;

			FileInputStream fi = new FileInputStream(myObj);
			ObjectInputStream oi = new ObjectInputStream(fi);
			while (true) {

				try {
					BachelorStT field2 = (BachelorStT) oi.readObject();
					StudentList1.add(field2);
					if (field == null) {
						break;
					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					
				} catch (EOFException exc) {
					// TODO Auto-generated catch block
					break;
				}

			}
		} catch (IOException e) {
			
		}
		try {
			File myObj = new File("StudentList2.sav");

			Object line;

			FileInputStream fi = new FileInputStream(myObj);
			ObjectInputStream oi = new ObjectInputStream(fi);
			while (true) {

				try {
					BachelorSt field2 = (BachelorSt) oi.readObject();
					StudentList2.add(field2);
					if (field == null) {
						break;
					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
				
				} catch (EOFException exc) {
					// TODO Auto-generated catch block
					break;
				}

			}
		} catch (IOException e) {
			
		}
		try {
			File myObj = new File("StudentList3.sav");

			Object line;

			FileInputStream fi = new FileInputStream(myObj);
			ObjectInputStream oi = new ObjectInputStream(fi);
			while (true) {

				try {
					MasterLessoneSt field2 = (MasterLessoneSt) oi.readObject();
					StudentList3.add(field2);
					if (field == null) {
						break;
					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					
				} catch (EOFException exc) {
					// TODO Auto-generated catch block
					break;
				}

			}
		} catch (IOException e) {
			
		}

	
		if(StId.charAt(4)=='2') {
		for (int i = 0; i < StudentList1.size(); i++) {
			if (StudentList1.get(i).getStId().equals(StId)) {
				for (int j = 0; j < StudentList1.get(i).Lessons.size(); j++) {
					if (StudentList1.get(i).Lessons.get(j).getID().equals(ClassId)) {
						StudentList1.get(i).Lessons.remove(j);
						int a = StudentList1.get(i).Lessons.get(j).getCap();
						StudentList1.get(i).Lessons.get(j).setCap(a + 1);
						int b = StudentList1.get(i).getLCap();
						StudentList1.get(i).setLCap(b + 1);
						StudentList1.get(i).setVahed(StudentList1.get(i).getVahed()+StudentList1.get(i).Lessons.get(j).getVahed());
					}
				}

			}
		}
		}
		else if(StId.charAt(4)=='0') {
			for (int i = 0; i < StudentList2.size(); i++) {
				if (StudentList2.get(i).getStId().equals(StId)) {
					for (int j = 0; j < StudentList2.get(i).Lessons.size(); j++) {
						if (StudentList2.get(i).Lessons.get(j).getID().equals(ClassId)) {
							StudentList2.get(i).Lessons.remove(j);
							int a = StudentList2.get(i).Lessons.get(j).getCap();
							StudentList2.get(i).Lessons.get(j).setCap(a + 1);
							int b = StudentList2.get(i).getLCap();
							StudentList2.get(i).setLCap(b + 1);
							StudentList2.get(i).setVahed(StudentList2.get(i).getVahed()+StudentList2.get(i).Lessons.get(j).getVahed());
						}
					}

				}
			}
			}
		else if(StId.charAt(4)=='1') {
			for (int i = 0; i < StudentList3.size(); i++) {
				if (StudentList3.get(i).getStId().equals(StId)) {
					for (int j = 0; j < StudentList3.get(i).Lessons.size(); j++) {
						if (StudentList3.get(i).Lessons.get(j).getID().equals(ClassId)) {
							StudentList3.get(i).Lessons.remove(j);
							int a = StudentList3.get(i).Lessons.get(j).getCap();
							StudentList3.get(i).Lessons.get(j).setCap(a + 1);
							int b = StudentList3.get(i).getLCap();
							StudentList3.get(i).setLCap(b + 1);
							StudentList3.get(i).setVahed(StudentList3.get(i).getVahed()+StudentList3.get(i).Lessons.get(j).getVahed());
						}
					}

				}
			}
			}
		try {
			File myObj = new File("StudentList.sav");
			myObj.delete();
			File myObj1 = new File("StudentList.sav");
			FileOutputStream myWriter = new FileOutputStream(myObj1, true);
			ObjectOutputStream o = new ObjectOutputStream(myWriter);
			for (int i = 0; i < StudentList1.size(); i++) {
				o.writeObject(StudentList1.get(i));

			}
			
		} catch (IOException e) {
		
		}
		try {
			File myObj = new File("StudentList2.sav");
			myObj.delete();
			File myObj1 = new File("StudentList2.sav");
			FileOutputStream myWriter = new FileOutputStream(myObj1, true);
			ObjectOutputStream o = new ObjectOutputStream(myWriter);
			for (int i = 0; i < StudentList2.size(); i++) {
				o.writeObject(StudentList2.get(i));

			}
			
		} catch (IOException e) {
			
		}
		try {
			File myObj = new File("StudentList3.sav");
			myObj.delete();
			File myObj1 = new File("StudentList3.sav");
			FileOutputStream myWriter = new FileOutputStream(myObj1, true);
			ObjectOutputStream o = new ObjectOutputStream(myWriter);
			for (int i = 0; i < StudentList3.size(); i++) {
				o.writeObject(StudentList3.get(i));

			}
		
		} catch (IOException e) {
			
		}
	
	}

	public void editStPass(String stId, String pass) throws ClassNotFoundException, FileNotFoundException {
		try {
			File myObj = new File("StudentList.sav");

			Object line;

			FileInputStream fi = new FileInputStream(myObj);
			ObjectInputStream oi = new ObjectInputStream(fi);
			while (true) {

				try {
					BachelorStT field2 = (BachelorStT) oi.readObject();
					StudentList1.add(field2);
					if (field == null) {
						break;
					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
				
				} catch (EOFException exc) {
					// TODO Auto-generated catch block
					break;
				}

			}
		} catch (IOException e) {
			
		}
		try {
			File myObj = new File("StudentList2.sav");

			Object line;

			FileInputStream fi = new FileInputStream(myObj);
			ObjectInputStream oi = new ObjectInputStream(fi);
			while (true) {

				try {
					BachelorSt field2 = (BachelorSt) oi.readObject();
					StudentList2.add(field2);
					if (field == null) {
						break;
					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					
				} catch (EOFException exc) {
					// TODO Auto-generated catch block
					break;
				}

			}
		} catch (IOException e) {
			
		}
		try {
			File myObj = new File("StudentList3.sav");

			Object line;

			FileInputStream fi = new FileInputStream(myObj);
			ObjectInputStream oi = new ObjectInputStream(fi);
			while (true) {

				try {
					MasterLessoneSt field2 = (MasterLessoneSt) oi.readObject();
					StudentList3.add(field2);
					if (field == null) {
						break;
					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					
				} catch (EOFException exc) {
					// TODO Auto-generated catch block
					break;
				}

			}
		} catch (IOException e) {
			
		}

		if (stId.charAt(4) == '0') {
			for (int i = 0; i < StudentList2.size(); i++) {
				if (stId.equals(StudentList2.get(i).getId())) {
					StudentList2.get(i).setStPass(pass);
					System.out.println("student name" + StudentList2.get(i).getStId() + "new passwor:"
							+ StudentList2.get(i).getPass());
				}
			}
		} else if (stId.charAt(4) == '1') {
			for (int i = 0; i < StudentList3.size(); i++) {
				if (stId.equals(StudentList3.get(i).getId())) {
					StudentList3.get(i).setStPass(pass);
					System.out.println("student name" + StudentList3.get(i).getStId() + "new passwor:"
							+ StudentList3.get(i).getPass());
				}
			}
		}
		else if (stId.charAt(4) == '2') {
			for (int i = 0; i < StudentList1.size(); i++) {
				if (stId.equals(StudentList1.get(i).getId())) {
					StudentList1.get(i).setStPass(pass);
					System.out.println("student name" + StudentList1.get(i).getStId() + "new passwor:"
							+ StudentList1.get(i).getPass());
				}
			}
		}
		try {
			File myObj = new File("StudentList.sav");
			myObj.delete();
			File myObj1 = new File("StudentList.sav");
			FileOutputStream myWriter = new FileOutputStream(myObj1, true);
			ObjectOutputStream o = new ObjectOutputStream(myWriter);
			for (int i = 0; i < StudentList.size(); i++) {
				o.writeObject(StudentList.get(i));

			}
			
		} catch (IOException e) {
			
		}
		try {
			File myObj = new File("StudentList2.sav");
			myObj.delete();
			File myObj1 = new File("StudentList2.sav");
			FileOutputStream myWriter = new FileOutputStream(myObj1, true);
			ObjectOutputStream o = new ObjectOutputStream(myWriter);
			for (int i = 0; i < StudentList2.size(); i++) {
				o.writeObject(StudentList2.get(i));

			}
			
		} catch (IOException e) {
			
		}
		try {
			File myObj = new File("StudentList3.sav");
			myObj.delete();
			File myObj1 = new File("StudentList3.sav");
			FileOutputStream myWriter = new FileOutputStream(myObj1, true);
			ObjectOutputStream o = new ObjectOutputStream(myWriter);
			for (int i = 0; i < StudentList3.size(); i++) {
				o.writeObject(StudentList3.get(i));

			}
			
		} catch (IOException e) {
			
		}

	}

	public void addField(String CollegeName, String Field, String Id)
			throws ClassNotFoundException, FileNotFoundException {
		File myObj = new File("Field.sav");

		try {

			if (myObj.createNewFile()) {
				System.out.println("File created: " + myObj.getName());
			} else {
				System.out.println("File already exists.");
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
		
		}
		try {

			FileOutputStream myWriter = new FileOutputStream("Field.sav", true);
			ObjectOutputStream o = new ObjectOutputStream(myWriter);
			Field field = new Field();
			field.setCollegeÃName(CollegeName);
			field.setField(Field);
			field.setId(Id);

			o.writeObject(field);

			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			
		}

	}

	public void addLessonToField(String FieldId, String LessonId) throws ClassNotFoundException, FileNotFoundException {
		try {
			File myObj = new File("ClassList1.sav");

			Object line;

			FileInputStream fi = new FileInputStream(myObj);
			ObjectInputStream oi = new ObjectInputStream(fi);
			while (true) {

				try {
					Bachelor field2 = (Bachelor) oi.readObject();
					ClassList.add(field2);
					if (field == null) {
						break;
					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					
				} catch (EOFException exc) {
					// TODO Auto-generated catch block
					break;
				}

			}
		} catch (IOException e) {
			
		}

		try {
			File myObj = new File("ClassList2.sav");

			Object line;

			FileInputStream fi = new FileInputStream(myObj);
			ObjectInputStream oi = new ObjectInputStream(fi);
			while (true) {

				try {
					MasterLessone field2 = (MasterLessone) oi.readObject();
					ClassList2.add(field2);
					if (field == null) {
						break;
					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					
				} catch (EOFException exc) {
					// TODO Auto-generated catch block
					break;
				}

			}
		} catch (IOException e) {
			
		}
		try {
			File myObj = new File("Field.sav");

			Object line;

			FileInputStream fi = new FileInputStream(myObj);
			ObjectInputStream oi = new ObjectInputStream(fi);
			while (true) {

				try {
					Field field2 = (Field) oi.readObject();
					field.add(field2);
					if (field == null) {
						break;
					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					
				} catch (EOFException exc) {
					// TODO Auto-generated catch block
					break;
				}

			}
		} catch (IOException e) {
			
		}
		//// *******************************
		for (int i = 0; i < field.size(); i++) {
			if (FieldId.equals(field.get(i).getId())) {
				if (LessonId.charAt(4) == '1') {
					if (LessonId.charAt(5) == '1') {
						for (int j = 0; j < ClassList.size(); j++) {
							if (LessonId.equals(ClassList.get(j).getID())) {
								field.get(i).addLesson(ClassList.get(j));
							}
						}
					} else if (LessonId.charAt(5) == '0') {
						for (int j = 0; j < ClassList.size(); j++) {
							if (LessonId.equals(ClassList.get(j).getID())) {
								field.get(i).addOLesson(ClassList.get(j));
							}
						}
					}
				} else if (LessonId.charAt(4) == '0') {
					if (LessonId.charAt(5) == '1') {
						for (int j = 0; j < ClassList2.size(); j++) {
							if (LessonId.equals(ClassList2.get(j).getID())) {
								field.get(i).addLesson(ClassList2.get(j));
							}
						}
					} else if (LessonId.charAt(5) == '0') {
						for (int j = 0; j < ClassList2.size(); j++) {
							if (LessonId.equals(ClassList2.get(j).getID())) {
								field.get(i).addOLesson(ClassList2.get(j));
							}
						}
					}
				}
			}
		}
		try {
			File myObj = new File("ClassList1.sav");
			myObj.delete();
			File myObj1 = new File("ClassList1.sav");
			FileOutputStream myWriter = new FileOutputStream(myObj1, true);
			ObjectOutputStream o = new ObjectOutputStream(myWriter);
			for (int i = 0; i < ClassList.size(); i++) {
				o.writeObject(ClassList.get(i));

			}
			
		} catch (IOException e) {
		
		}
		try {
			File myObj = new File("ClassList2.sav");
			myObj.delete();
			File myObj1 = new File("ClassList2.sav");
			FileOutputStream myWriter = new FileOutputStream(myObj1, true);
			ObjectOutputStream o = new ObjectOutputStream(myWriter);
			for (int i = 0; i < ClassList2.size(); i++) {
				o.writeObject(ClassList2.get(i));

			}
			
		} catch (IOException e) {
			
		}
		try {
			File myObj = new File("Field.sav");
			myObj.delete();
			File myObj1 = new File("Field.sav");
			FileOutputStream myWriter = new FileOutputStream(myObj1, true);
			ObjectOutputStream o = new ObjectOutputStream(myWriter);
			for (int i = 0; i < field.size(); i++) {
				o.writeObject(field.get(i));

			}
			
		} catch (IOException e) {
			
		}

	}

	public void ShowAllField() throws ClassNotFoundException, FileNotFoundException {
		try {
			File myObj = new File("Field.sav");

			Object line;

			FileInputStream fi = new FileInputStream(myObj);
			ObjectInputStream oi = new ObjectInputStream(fi);
			while (true) {

				try {
					Field field2 = (Field) oi.readObject();
					field.add(field2);
					if (field == null) {
						break;
					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
				
				} catch (EOFException exc) {
					// TODO Auto-generated catch block
					break;
				}

			}
		} catch (IOException e) {
			
		}
		for (int i = 0; i < field.size(); i++) {
			System.out.println("College Name:" + field.get(i).getCollegeÃName() + " Field name:"
					+ ClassList.get(i).getField() + " Class Pishniaz:" + ClassList.get(i).getPish() + " Class name:"
					+ ClassList.get(i).getCap());
			System.out.println("dars");
			field.get(i).ShowLesson();
			System.out.println("dars ekhtiyare");
			field.get(i).ShowOLesson();

		}
	
	}

	public void ShowAllSt() throws ClassNotFoundException, FileNotFoundException {
		try {
			File myObj = new File("StudentList2.sav");

			Object line;

			FileInputStream fi = new FileInputStream(myObj);
			ObjectInputStream oi = new ObjectInputStream(fi);
			while (true) {

				try {
					BachelorSt field2 = (BachelorSt) oi.readObject();
					
					StudentList2.add(field2);
					
					if (field2 == null) {
						break;
					}
				} 
				catch (EOFException exc) {
					// TODO Auto-generated catch block
					break;
				}catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					
				} 
				
			}
		} catch (IOException e) {
			
		}
		try {
			File myObj = new File("StudentList3.sav");

			Object line;

			FileInputStream fi = new FileInputStream(myObj);
			ObjectInputStream oi = new ObjectInputStream(fi);
			while (true) {

				try {
					MasterLessoneSt field2 = (MasterLessoneSt) oi.readObject();
					StudentList3.add(field2);
					if (field2 == null) {
						break;
					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					
				} catch (EOFException exc) {
					// TODO Auto-generated catch block
					break;
				}

			}
		} catch (IOException e) {
			
		}
		try {
			File myObj = new File("StudentList.sav");

			Object line;

			FileInputStream fi = new FileInputStream(myObj);
			ObjectInputStream oi = new ObjectInputStream(fi);
			while (true) {

				try {
					BachelorStT field2 = (BachelorStT) oi.readObject();
					
					StudentList1.add(field2);
					
					if (field == null) {
						break;
					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				} catch (EOFException exc) {
					// TODO Auto-generated catch block
					break;
				}

			}
			fi.close();
		} catch (IOException e) {
			//e.printStackTrace();
		}
		for (int i = 0; i < StudentList2.size(); i++) {
			System.out.println("/////////////////////////// Bachelor Student//////////////////////////");
			System.out.println("Studnt first name:" + StudentList2.get(i).getFirstName() + " Studnt Last name:"
					+ StudentList2.get(i).getLastName() + " Studnt Id:" + StudentList2.get(i).getId());
		}
		System.out.println("/////////////////////////// Master Student//////////////////////////");
		for (int i = 0; i < StudentList3.size(); i++) {
			System.out.println("Studnt first name:" + StudentList3.get(i).getFirstName() + " Studnt Last name:"
					+ StudentList3.get(i).getLastName() + " Studnt Id:" + StudentList3.get(i).getId());
		}
		System.out.println("/////////////////////////Bachelor Student T////////////////////////////");
		for (int i = 0; i < StudentList1.size(); i++) {
			System.out.println("Studnt first name:" + StudentList1.get(i).getFirstName() + " Studnt Last name:"
					+ StudentList1.get(i).getLastName() + " Studnt Id:" + StudentList1.get(i).getId());
		}
		/*StudentList1.removeAll(StudentList1);
		StudentList2.removeAll(StudentList2);
		StudentList3.removeAll(StudentList3);*/
	}

//Admin user name is"Admin" and password is"1234"
	public boolean LoginAdmin() {

		boolean found = false;
		Scanner strInput = new Scanner(System.in);
		System.out.println("Enter the Username: ");
		String id = strInput.nextLine();
		System.out.println("Enter the password: ");
		String pass = strInput.nextLine();
		if (id.equals(Id) && pass.equals(Pass)) {
			found = true;

		}
		return found;
	}

	public boolean LoginStudent(String id, String pass) throws ClassNotFoundException, FileNotFoundException ,StreamCorruptedException{
		try {
			File myObj = new File("StudentList.sav");

			Object line;

			FileInputStream fi = new FileInputStream(myObj);
			ObjectInputStream oi = new ObjectInputStream(fi);
			while (true) {

				try {
					BachelorStT field2 = (BachelorStT) oi.readObject();
					StudentList1.add(field2);
					if (field2 == null) {
						break;
					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					
				} catch (EOFException exc) {
					// TODO Auto-generated catch block
					break;
				}

			}
		} catch (IOException e) {
			
		}
		try {
			File myObj = new File("StudentList2.sav");

			Object line;

			FileInputStream fi = new FileInputStream(myObj);
			ObjectInputStream oi = new ObjectInputStream(fi);
			while (true) {

				try {
					BachelorSt field2 = (BachelorSt) oi.readObject();
					
					if (field2 == null) {
					
						break;
					}else {
						
						StudentList2.add(field2);
					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					
				} catch (EOFException exc) {
					// TODO Auto-generated catch block
					

					break;
				}
				
			}
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			File myObj = new File("StudentList3.sav");

			Object line;

			FileInputStream fi = new FileInputStream(myObj);
			ObjectInputStream oi = new ObjectInputStream(fi);
			while (true) {

				try {
					MasterLessoneSt field2 = (MasterLessoneSt) oi.readObject();
					StudentList3.add(field2);
					
					if (field2 == null) {
						break;
					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					
					break;
				} catch (EOFException exc) {
					// TODO Auto-generated catch block
					break;
				}

			}
		} catch (IOException e) {
			
			
		}
		

		boolean found = false;
		// input id and pass if its in the Student List it let you go inside
		if (id.charAt(4) == '1') {
			for (int i = 0; i < StudentList2.size(); i++) {
				if (StudentList2.get(i).getStId().equals(id) && StudentList2.get(i).getPass().equals(pass)) {
					found = true;
				}
			}
		} else if (id.charAt(4) == '0') {
			for (int i = 0; i < StudentList3.size(); i++) {
				if (StudentList3.get(i).getStId().equals(id) && StudentList3.get(i).getPass().equals(pass)) {
					found = true;
				}
			}
			
		}
		else if (id.charAt(4) == '2') {
			for (int i = 0; i < StudentList1.size(); i++) {
				if (StudentList1.get(i).getStId().equals(id) && StudentList1.get(i).getPass().equals(pass)) {
					found = true;
				}
			}
			
		}
		/*StudentList1.removeAll(StudentList1);
		StudentList2.removeAll(StudentList2);
		StudentList3.removeAll(StudentList3);*/
		return found;
	}

	public boolean LoginProf(String id, String pass)
			throws ClassNotFoundException, FileNotFoundException {
		try {
			File myObj = new File("ProfList.sav");

			Object line;

			FileInputStream fi = new FileInputStream(myObj);
			ObjectInputStream oi = new ObjectInputStream(fi);
			while (true) {

				try {
					HiredProf field2 = (HiredProf) oi.readObject();
					ProfList.add(field2);
					oi.close();
					if (field2 == null) {
						break;
					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					
				} catch (EOFException exc) {
					// TODO Auto-generated catch block
					break;
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			File myObj = new File("ProfList1.sav");

			Object line;

			FileInputStream fi = new FileInputStream(myObj);
			ObjectInputStream oi = new ObjectInputStream(fi);
			while (true) {

				try {
					TemporaryProf field2 = (TemporaryProf) oi.readObject();
					ProfList1.add(field2);
					if (field2 == null) {
						break;
					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
				
				} catch (EOFException exc) {
					// TODO Auto-generated catch block
					break;
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		boolean found = false;
		// input id and pass if its in the Student List it let you go inside
		if (id.charAt(4) == '1') {
			for (int i = 0; i < ProfList.size(); i++) {
				if (ProfList.get(i).getProfId().equals(id) && ProfList.get(i).getProfPass().equals(pass)) {
					found = true;
				}
			}
		} else if (id.charAt(4) == '0') {
			for (int i = 0; i < ProfList1.size(); i++) {
				if (ProfList1.get(i).getProfId().equals(id) && ProfList1.get(i).getProfPass().equals(pass)) {
					found = true;
				}
			}
		}
	/*	ProfList.removeAll(ProfList);
		ProfList.removeAll(ProfList1);*/
		return found;
	}

	// give id of class and it remove it from ClassList ArrayList using for loop
	public void removeClass(String Id) {
		if (Id.charAt(4) == '1' && Id.charAt(5) == '0') {
			for (int i = 0; i < ClassList.size(); i++) {
				if (ClassList.get(i).getID().equals(Id)) {
					ClassList.remove(i);

				}

			}
		} else if (Id.charAt(4) == '0' && Id.charAt(5) == '1') {
			for (int i = 0; i < ClassList2.size(); i++) {
				if (ClassList2.get(i).getID().equals(Id)) {
					ClassList2.remove(i);
				}

			}
		}
	}
}
