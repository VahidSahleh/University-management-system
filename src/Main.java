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
import java.nio.file.*;
public class Main {
private static Field ss,ss1,ss2;
	public static void main(String[] args) throws ClassNotFoundException, FileNotFoundException, StreamCorruptedException {
		// TODO Auto-generated method stub
		Managr mg = new Managr();

			String stId = "";
			String ProfId = "";
		boolean f = false;
		while (f == false) {
			Scanner input = new Scanner(System.in);
			Scanner input2 = new Scanner(System.in);
			// Managr mg = new Managr();
			System.out.println("0)ADMIN   1)STUDENT  2)PROF");
			int i = input.nextInt();
			boolean k = false;
			while (k == false) {

				// int i=input.nextInt();
				if (i == 0) {
					System.out.println("ADMIN ");
					k = mg.LoginAdmin();
					if (k == true) {
						break;
					}
				}
				if (i == 1) {
					System.out.println("STUDENT");
					Scanner strInput = new Scanner(System.in);
					System.out.println("Enter the Username: ");
					String id = strInput.nextLine();
					System.out.println("Enter the password: ");
					String pass = strInput.nextLine();
					k = mg.LoginStudent(id, pass);
					if (k == true) {
						stId = id;
						break;
					}
				}
				if(i==2) {
					System.out.println("PROF");
					Scanner strInput = new Scanner(System.in);
					System.out.println("Enter the Username: ");
					String id = strInput.nextLine();
					System.out.println("Enter the password: ");
					String pass = strInput.nextLine();
					k = mg.LoginProf(id, pass);
					if (k == true) {
						ProfId = id;
						break;
					}
				}

			}
			boolean h = true;
			////
			if (i == 0) {
				while (h == true) {

				
					System.out.println("1)Professor 2)Course  3)Major 4)Student 5)Exit");

					int a = input.nextInt();
					if(a == 1) {
						System.out.println("1)Add 2)Show 3)Exit");
						int b = input.nextInt();
						if(b==1) {
						Scanner strInput = new Scanner(System.in);
						Scanner strInput1 = new Scanner(System.in);
						System.out.println("Enter the Username: ");
						String tId = strInput.nextLine();
						System.out.println("Enter the password: ");
						String tPass = strInput.nextLine();
						System.out.println("Enter first name: ");
						String Fname = strInput.nextLine();
						System.out.println("Enter last name: ");
						String Lname = strInput.nextLine();
						System.out.println("Enter sanavat: ");
						int sanavat = strInput1.nextInt();
						mg.AddProf(tId, tPass, Fname, Lname, sanavat);
						}
						else if(b==2) {
							mg.ShowAllProf();
						}
						else if(b==3) {
							break;
						}
					}
					else if(a==2) {
						System.out.println("1)Add 2)Show 3)class students 4)Edit Cap 5)Exit");
						int b = input.nextInt();
						if(b==1) {
							Scanner strInput = new Scanner(System.in);
							Scanner strInput1 = new Scanner(System.in);
							System.out.println("Enter the Username: ");
							String id = strInput.nextLine();
							System.out.println("Enter the name: ");
							String name = strInput.nextLine();
							System.out.println("Enter time: ");
							int time = strInput1.nextInt();
							System.out.println("Enter pish: ");
							String Pish = strInput.nextLine();
							System.out.println("Enter prof id: ");
							String prof = strInput.nextLine();
							System.out.println("Enter field: ");
							String field1 = strInput.nextLine();
							System.out.println("Enter vahed: ");
							int vahed = strInput.nextInt();
							System.out.println("Enter Cap: ");
							int cap = strInput1.nextInt();
							
							mg.addLesson(id, name, time, Pish, prof, field1, vahed,cap);
							
						}
						else if(b==2) {
							mg.ShowAllClass();
						}
						else if(b==3) {
							Scanner strInput = new Scanner(System.in);
							System.out.println("Enter Class Id: ");
							String id = strInput.nextLine();
							mg.ShowClassSt(id);
						}
						else if(b==4) {
							Scanner strInput = new Scanner(System.in);
							System.out.println("Enter Class Id: ");
							String id = strInput.nextLine();
							mg.addLessonCap(id);
						}
						else if(b==5) {
							break;
						}
					}
					else if(a==3) {
						System.out.println("1)Add 2)Show 3)Add Course  4)Exit");
						int b = input.nextInt();
						if(b==1) {
							Scanner strInput = new Scanner(System.in);
							System.out.println("Enter the College Name: ");
							String CollegeName = strInput.nextLine();
							System.out.println("Enter Field name: ");
							String Field = strInput.nextLine();
							System.out.println("Enter Field Id: ");
							String FieldId = strInput.nextLine();
						mg.addField(CollegeName, Field,FieldId);	
						}
						else if(b==2) {
							mg.ShowAllField();
						}
						else if(b==3) {
							Scanner strInput = new Scanner(System.in);
							System.out.println("Enter the College Name: ");
							String FieldId = strInput.nextLine();
							System.out.println("Enter Field name: ");
							String LessonId = strInput.nextLine();
							mg.addLessonToField(FieldId, LessonId);
						}
						else if(b==4) {
							break;
						}
						
					}
					else if(a==4) {
						System.out.println("1)Add 2)Show 3)Take Course" + "4)Add Student's Subject Score"+"5)set moadel"+"6)Exit");
						int b = input.nextInt();
						if(b==1) {
							Scanner strInput = new Scanner(System.in);
							System.out.println("Enter the Username: ");
							String StId = strInput.nextLine();
							System.out.println("Enter the password: ");
							String StPass = strInput.nextLine();
							System.out.println("Enter first name: ");
							String Fname = strInput.nextLine();
							System.out.println("Enter last name: ");
							String Lname = strInput.nextLine();
							System.out.println("Enter Field: ");
							String field1 = strInput.nextLine();
						 mg.AddStudent(StId, StPass, Fname, Lname, field1);
						}
						else if(b==2) {
							mg.ShowAllSt();
						}
						else if(b==3) {
							Scanner strInput = new Scanner(System.in);
							System.out.println("Enter Lesson id: ");
							String lessId = strInput.nextLine();
							System.out.println("Enter student id: ");
							String Id = strInput.nextLine();
							mg.addLessonTost(lessId, Id);
						}
						
						else if(b==4) {
							Scanner strInput = new Scanner(System.in);
							System.out.println("Enter the Username: ");
							String StId = strInput.nextLine();
							System.out.println("Enter the password: ");
							String StLesson = strInput.nextLine();
							System.out.println("Enter first name: ");
							int grade = strInput.nextInt();
							mg.setGrade(stId, StLesson, grade);
						}
						else if(b==5) {
							Scanner strInput = new Scanner(System.in);
							System.out.println("Enter the Username: ");
							String id = strInput.nextLine();
							mg.setMoadel(id);
						}
						else if(b==6) {
							break;
						}
						
					}else if(a==5) {
						break;
					}
					
				
				}
			}
			boolean kk = true;
			if (i == 1) {

				while (kk == true) {
					System.out.println("1)Leave Class  2)Show Student Classes And Grades 3)Show moadel 4)Edit pass 5)Exit");
					int a = input.nextInt();
					if (a == 1) {
						Scanner strInput = new Scanner(System.in);
						System.out.println("Enter the Username: ");
						String ClassId = strInput.nextLine();
						mg.LeaveClass(ClassId, stId);
					} else if (a == 2) {
						mg.ShowStClass(stId);
						System.out.println("////////////////////////////////");
						mg.ShowGrade(stId);
						System.out.println("////////////////////////////////");
						mg.ShowMoadel(stId);
					}
					else if (a == 3) {
						
						
					}
					else if (a == 4) {
						Scanner strInput = new Scanner(System.in);
						System.out.println("Enter the new password: ");
						String pass = strInput.nextLine();
						mg.editStPass(stId, pass);
					}
					else if (a == 5) {
						break;
					}

				}
			}
			///////////////////////////////////////////////////////////////////////////////////////
			boolean kkk = true;
			if (i == 2) {

				while (kkk == true) {
					System.out.println("1)Show My Info  2)Exit");
					int a = input.nextInt();
					if (a == 1) {
						mg.showProfInfo(ProfId);
					} 

					else if (a == 2) {
						kkk=false;
						
					}

				}
			}

		}

	}

}
