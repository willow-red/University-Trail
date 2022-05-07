package trail;

import java.util.ArrayList;

public class CSStudent extends Student{
	//default (new player) constructor:
			public CSStudent(String name) {
				super(name, 1000, "Freshman", 1, 0, 100, 100, 100, makeSupplyList(), makeSchedule(), "Computer Science Society", makeActivity(), makeStringSupplyList(makeSupplyList()));
				super.setMajorName("CSStudent");
			}
			//constructor for loading data:
			//String typeOfStudent, String name, double funds, String year, int week, 
			//int mealSwipes, int happiness, int health, int grades
			public CSStudent(String name, double funds, String year, int week, int mealSwipes, int happiness, int health, int grades) {
				super(name, funds, year, week, mealSwipes, happiness, health, grades, makeSupplyList(), makeSchedule(), "Computer Science Society", 
						makeActivity(), makeStringSupplyList(makeSupplyList()));
				super.setMajorName("CSStudent");
			}

			private static ArrayList<Shop> makeSupplyList(){
				ArrayList<Shop> supplies = new ArrayList<>();
				//hardcode some supplies for each major:
				supplies.add(Shop.values()[6]);
				supplies.add(Shop.values()[1]);
				supplies.add(Shop.values()[5]);
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
				classNames.add("CSCI101 - Intro to Computing");
				ClassOnSchedule a = new ClassOnSchedule("CSCI101 - Intro to Computing", 2);
				classes.add(a);
				classNames.add("CSCI102 - Data Structures");
				ClassOnSchedule b = new ClassOnSchedule("CSCI102 - Data Structures", 3);
				classes.add(b);
				classNames.add("CSCI103 - Discrete Methods");
				ClassOnSchedule c = new ClassOnSchedule("CSCI103 - Discrete Methods", 3);
				classes.add(c);
				classNames.add("BIO101 - Intro to Biology");
				ClassOnSchedule d = new ClassOnSchedule("BIO101 - Intro to Biology", 1);
				classes.add(d);

				ClassSchedule schedule = new ClassSchedule(classNames, classes);
				return schedule;
			}
			//TODO make menu event
			private static MenuEvent makeActivity() {
				MenuEvent activity = new MenuEvent(10, 0, 0, "Work on Personal Game Dev", 0);
				return activity;
			}


}
