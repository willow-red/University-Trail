package trail;

import java.util.ArrayList;
import java.util.HashMap;

public class ClassSchedule {
	
	private ArrayList<String> classListNames;
	private ArrayList<ClassOnSchedule> classList;
	private double gpa;
	private Helper help;
	
	
	public ClassSchedule(ArrayList<String> classListNames,
			ArrayList<ClassOnSchedule> classList, double gpa) {
		super();
		this.classListNames = classListNames;
		this.classList = classList;
		this.gpa = gpa;
		help = new Helper();
	}
	//default gpa is 4.0
	public ClassSchedule(ArrayList<String> classListNames, ArrayList<ClassOnSchedule> classList) {
		this(classListNames, classList, 4.0);
	}
	
	public ArrayList<String> getClassListNames() {
		return classListNames;
	}
	public void setClassListNames(ArrayList<String> classListNames) {
		this.classListNames = classListNames;
	}
	public ArrayList<ClassOnSchedule> getClassList() {
		return classList;
	}
	public void setClassList(ArrayList<ClassOnSchedule> classList) {
		this.classList = classList;
	}
	public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	@Override
	public String toString() {
		return "ClassSchedule [classListNames=" + classListNames + ", classList=" + classList + ", gpa=" + gpa + "]";
	}
	
	//print all the classes and grade for each, with gpa at the bottom
	public void printReportCard() {
		help.printFancy("\tReport Card");
		for(ClassOnSchedule c: this.classList) {
			help.print(c.getClassName().toUpperCase());
			help.print("\tGrade Total: " + c.getClassGradeNum() + "/100");
			help.print("\tLetter Grade: " + c.getClassGradeLetter());
			help.printLine();
		}
		help.print("Total GPA: " + this.gpa + "\n");
		help.printLine();
	}
	//print all class names nicely
	public void printClassSchedule() {
		help.print("\nYour class schedule is: \n");
		for(String c: this.classListNames) {
			help.print(c);
		}
		help.print("\n");
	}
	
}
