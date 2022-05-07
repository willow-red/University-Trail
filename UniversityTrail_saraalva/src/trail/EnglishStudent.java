package trail;

import java.util.ArrayList;

public class EnglishStudent extends Student{
	
	//default (new player) constructor:
	public EnglishStudent(String name) {
		super(name, 1000, "Freshman", 1, 0, 100, 100, 100, makeSupplyList(), makeSchedule(), "Book Club", makeActivity(), makeStringSupplyList(makeSupplyList()));
		super.setMajorName("EnglishStudent");
	}
	//constructor for loading data:
	//String typeOfStudent, String name, double funds, String year, int week, 
	//int mealSwipes, int happiness, int health, int grades
	public EnglishStudent(String name, double funds, String year, int week, int mealSwipes, int happiness, int health, int grades) {
		super(name, funds, year, week, mealSwipes, happiness, health, grades, makeSupplyList(), makeSchedule(), "Book Club", 
				makeActivity(), makeStringSupplyList(makeSupplyList()));
		super.setMajorName("EnglishStudent");
	}

	private static ArrayList<Shop> makeSupplyList(){
		ArrayList<Shop> supplies = new ArrayList<>();
		//hardcode some supplies for each major:
		//paint set:
		supplies.add(Shop.values()[1]);
		supplies.add(Shop.values()[2]);
		supplies.add(Shop.values()[2]);
		supplies.add(Shop.values()[3]);
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
		classNames.add("LIT101 - Intro to Literature");
		ClassOnSchedule a = new ClassOnSchedule("LIT101 - Intro to Literature", 1);
		classes.add(a);
		classNames.add("LIT102 - Classics");
		ClassOnSchedule b = new ClassOnSchedule("LIT102 - Classics", 1);
		classes.add(b);
		classNames.add("LIT103 - American Literature");
		ClassOnSchedule c = new ClassOnSchedule("LIT103 - American Literature", 1);
		classes.add(c);
		classNames.add("ART101 - Intro to Art");
		ClassOnSchedule d = new ClassOnSchedule("ART101 - Intro to Art", 0);
		classes.add(d);

		ClassSchedule schedule = new ClassSchedule(classNames, classes);
		return schedule;
	}
	//TODO make menu event
	private static MenuEvent makeActivity() {
		MenuEvent activity = new MenuEvent(10, 0, 0, "Read Fanfiction", 0);
		return activity;
	}

}
