package trail;

import java.util.ArrayList;

public class HistoryStudent extends Student{
	
	//default (new player) constructor:
		public HistoryStudent(String name) {
			super(name, 1000, "Freshman", 1, 0, 100, 100, 100, makeSupplyList(), makeSchedule(), "Archeology Club", makeActivity(), makeStringSupplyList(makeSupplyList()));
			super.setMajorName("HistoryStudent");
		}
		//constructor for loading data:
		//String typeOfStudent, String name, double funds, String year, int week, 
		//int mealSwipes, int happiness, int health, int grades
		public HistoryStudent(String name, double funds, String year, int week, int mealSwipes, int happiness, int health, int grades) {
			super(name, funds, year, week, mealSwipes, happiness, health, grades, makeSupplyList(), makeSchedule(), "Archeology Club", 
					makeActivity(), makeStringSupplyList(makeSupplyList()));
			super.setMajorName("HistoryStudent");
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
			classNames.add("HIST101 - American History");
			ClassOnSchedule a = new ClassOnSchedule("HIST101 - American History", 1);
			classes.add(a);
			classNames.add("HIST102 - European History");
			ClassOnSchedule b = new ClassOnSchedule("HIST102 - European History", 1);
			classes.add(b);
			classNames.add("HIST103 - Contemporary Histories");
			ClassOnSchedule c = new ClassOnSchedule("HIST103 - Contemporary Histories", 1);
			classes.add(c);
			classNames.add("CHEM101 - Intro to Chemistry");
			ClassOnSchedule d = new ClassOnSchedule("CHEM101 - Intro to Chemistry", 2);
			classes.add(d);

			ClassSchedule schedule = new ClassSchedule(classNames, classes);
			return schedule;
		}
		//TODO make menu event
		private static MenuEvent makeActivity() {
			MenuEvent activity = new MenuEvent(10, 0, 0, "Visit Museum", 0);
			return activity;
		}

}
