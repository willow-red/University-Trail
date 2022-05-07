package trail;

import java.util.ArrayList;

public class MedStudent extends Student{
	
	//default (new player) constructor:
	public MedStudent(String name) {
		super(name, 1000, "Freshman", 1, 0, 100, 100, 100, makeSupplyList(), makeSchedule(), "Pre-Med Society", makeActivity(), makeStringSupplyList(makeSupplyList()));
		super.setMajorName("MedStudent");
	}
	//constructor for loading data:
	//String typeOfStudent, String name, double funds, String year, int week, 
	//int mealSwipes, int happiness, int health, int grades
	public MedStudent(String name, double funds, String year, int week, int mealSwipes, int happiness, int health, int grades) {
		super(name, funds, year, week, mealSwipes, happiness, health, grades, makeSupplyList(), makeSchedule(), "Pre-Med Society", 
				makeActivity(), makeStringSupplyList(makeSupplyList()));
		super.setMajorName("MedStudent");
	}

	private static ArrayList<Shop> makeSupplyList(){
		ArrayList<Shop> supplies = new ArrayList<>();
		//hardcode some supplies for each major:
		//paint set:
		supplies.add(Shop.values()[1]);
		supplies.add(Shop.values()[0]);
		supplies.add(Shop.values()[0]);
		supplies.add(Shop.values()[4]);

		return supplies;
	}
	//string version of list for printing:
	private static ArrayList<String> makeStringSupplyList(ArrayList<Shop> items){
		ArrayList<String> supply = new ArrayList<>();
		for(Shop i: items) {
			supply.add(i.getItem());
		}
		return supply;
	}
	
	//TODO make class schedule
	private static ClassSchedule makeSchedule() {
		//make args for class schedule construction:
		ArrayList<String> classNames = new ArrayList<>();
		ArrayList<ClassOnSchedule> classes = new ArrayList<>();
		//hardcode class names:
		classNames.add("MED101 - Intro to Medicine");
		ClassOnSchedule a = new ClassOnSchedule("MED101 - Intro to Medicine", 2);
		classes.add(a);
		classNames.add("MED102 - Anatomy");
		ClassOnSchedule b = new ClassOnSchedule("MED102 - Anatomy", 2);
		classes.add(b);
		classNames.add("MED103 - Nutrition");
		ClassOnSchedule c = new ClassOnSchedule("MED103 - Nutrition", 1);
		classes.add(c);
		classNames.add("BIO101 - Intro to Biology");
		ClassOnSchedule d = new ClassOnSchedule("BIO101 - Intro to Biology", 2);
		classes.add(d);

		ClassSchedule schedule = new ClassSchedule(classNames, classes);
		return schedule;
	}
	//TODO make menu event
	private static MenuEvent makeActivity() {
		MenuEvent activity = new MenuEvent(10, 0, 0, "Shadow a Doctor", 0);
		return activity;
	}


	

}
