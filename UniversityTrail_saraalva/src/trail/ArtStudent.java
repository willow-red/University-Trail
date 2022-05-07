package trail;

import java.util.ArrayList;

public class ArtStudent extends Student{

	//default (new player) constructor:
	public ArtStudent(String name) {
		super(name, 1000, "Freshman", 1, 0, 100, 100, 100, makeSupplyList(), makeSchedule(), "Figure Drawing Club", makeActivity(), makeStringSupplyList(makeSupplyList()));
		super.setMajorName("ArtStudent");
	}
	//constructor for loading data:
	//String typeOfStudent, String name, double funds, String year, int week, 
	//int mealSwipes, int happiness, int health, int grades
	public ArtStudent(String name, double funds, String year, int week, int mealSwipes, int happiness, int health, int grades) {
		super(name, funds, year, week, mealSwipes, happiness, health, grades, makeSupplyList(), makeSchedule(), "Figure Drawing Club", 
				makeActivity(), makeStringSupplyList(makeSupplyList()));
		super.setMajorName("ArtStudent");
	}

	private static ArrayList<Shop> makeSupplyList(){
		ArrayList<Shop> supplies = new ArrayList<>();
		//hardcode some supplies for each major:
		//paint set:
		supplies.add(Shop.values()[3]);
		supplies.add(Shop.values()[0]);
		supplies.add(Shop.values()[0]);	
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
		classNames.add("ART101 - Drawing 1");
		ClassOnSchedule a = new ClassOnSchedule("ART101 - Drawing 1", 0);
		classes.add(a);
		classNames.add("ART102 - Intro to Art History");
		ClassOnSchedule b = new ClassOnSchedule("ART102 - Intro to Art History", 2);
		classes.add(b);
		classNames.add("ART103 - Painting 1");
		ClassOnSchedule c = new ClassOnSchedule("ART103 - Painting 1", 0);
		classes.add(c);
		classNames.add("PSYCH101 - Intro to Psychology");
		ClassOnSchedule d = new ClassOnSchedule("PSYCH101 - Intro to Psychology", 3);
		classes.add(d);

		ClassSchedule schedule = new ClassSchedule(classNames, classes);
		return schedule;
	}
	//TODO make menu event
	private static MenuEvent makeActivity() {
		MenuEvent activity = new MenuEvent(10, 0, 0, "Draw in Sketchbook", 0);
		return activity;
	}



}
