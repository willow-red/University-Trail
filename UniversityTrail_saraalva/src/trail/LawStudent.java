package trail;

import java.util.ArrayList;

public class LawStudent extends Student{
	
	//default (new player) constructor:
			public LawStudent(String name) {
				super(name, 1000, "Freshman", 1, 0, 100, 100, 100, makeSupplyList(), makeSchedule(), "Debate Club", makeActivity(), makeStringSupplyList(makeSupplyList()));
				super.setMajorName("LawStudent");
			}
			//constructor for loading data:
			//String typeOfStudent, String name, double funds, String year, int week, 
			//int mealSwipes, int happiness, int health, int grades
			public LawStudent(String name, double funds, String year, int week, int mealSwipes, int happiness, int health, int grades) {
				super(name, funds, year, week, mealSwipes, happiness, health, grades, makeSupplyList(), makeSchedule(), "Debate Club", 
						makeActivity(), makeStringSupplyList(makeSupplyList()));
				super.setMajorName("LawStudent");
			}

			private static ArrayList<Shop> makeSupplyList(){
				ArrayList<Shop> supplies = new ArrayList<>();
				//hardcode some supplies for each major:
				//paint set:
				supplies.add(Shop.values()[1]);
				supplies.add(Shop.values()[0]);
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
				classNames.add("LAW101 - Intro to Law");
				ClassOnSchedule a = new ClassOnSchedule("LAW101 - Intro to Law", 1);
				classes.add(a);
				classNames.add("LAW102 - Contracts and Sales");
				ClassOnSchedule b = new ClassOnSchedule("LAW102 - Contracts and Sales", 2);
				classes.add(b);
				classNames.add("LAW103 - Evidence");
				ClassOnSchedule c = new ClassOnSchedule("LAW103 - Evidence", 2);
				classes.add(c);
				classNames.add("ECON101 - Intro to Economics");
				ClassOnSchedule d = new ClassOnSchedule("ECON101 - Intro to Economics", 1);
				classes.add(d);

				ClassSchedule schedule = new ClassSchedule(classNames, classes);
				return schedule;
			}
			//TODO make menu event
			private static MenuEvent makeActivity() {
				MenuEvent activity = new MenuEvent(10, 0, 0, "Participate in Mock Trial", 0);
				return activity;
			}


}
