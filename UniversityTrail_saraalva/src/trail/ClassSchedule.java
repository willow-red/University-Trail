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
	public void setGpa() {
		double total = 0;
		for(ClassOnSchedule c: this.classList) {
			total+= c.getClassGradeNum();
		}
		total /= 4;
		if(total > 93) {
			this.gpa = 4.0;
		}
		else if(total >= 90 && total < 93) {
			this.gpa = 3.7;
		}
		else if(total >= 87 && total < 90) {
			this.gpa = 3.3;
		}
		else if(total >= 83 && total < 87) {
			this.gpa = 3.0;
		}
		else if(total >= 80 && total < 83) {
			this.gpa = 2.7;
		}
		else if(total >= 77 && total < 80) {
			this.gpa = 2.3;
		}
		else if(total >= 73 && total < 77) {
			this.gpa = 2.0;
		}
		else if(total >= 70 && total < 73) {
			this.gpa = 1.7;
		}
		else if(total >= 67 && total < 70) {
			this.gpa = 1.3;
		}
		else if(total >= 65 && total < 67) {
			this.gpa = 1.0;
		}
		else {
			this.gpa = 0.0;
		}
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
