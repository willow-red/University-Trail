package trail;

import java.util.ArrayList;

public class ScienceStudent extends Student{
	
	//default (new player) constructor:
		public ScienceStudent(String name) {
			super(name, 1000, "Freshman", 1, 0, 100, 100, 100, makeSupplyList(), makeSchedule(), "Lab Club", makeActivity(), makeStringSupplyList(makeSupplyList()));
			super.setMajorName("ScienceStudent");
		}
		//constructor for loading data:
		//String typeOfStudent, String name, double funds, String year, int week, 
		//int mealSwipes, int happiness, int health, int grades
		public ScienceStudent(String name, double funds, String year, int week, int mealSwipes, int happiness, int health, int grades) {
			super(name, funds, year, week, mealSwipes, happiness, health, grades, makeSupplyList(), makeSchedule(), "Lab Club", 
					makeActivity(), makeStringSupplyList(makeSupplyList()));
			super.setMajorName("ScienceStudent");
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
			classNames.add("SCI101 - Intro to Science");
			ClassOnSchedule a = new ClassOnSchedule("SCI101 - Intro to Science", 1);
			classes.add(a);
			classNames.add("CHEM101 - Intro to Chemistry");
			ClassOnSchedule b = new ClassOnSchedule("CHEM101 - Intro to Chemistry", 2);
			classes.add(b);
			classNames.add("SCI103 - Anatomy");
			ClassOnSchedule c = new ClassOnSchedule("SCI103 - Anatomy", 1);
			classes.add(c);
			classNames.add("BIO101 - Intro to Biology");
			ClassOnSchedule d = new ClassOnSchedule("BIO101 - Intro to Biology", 2);
			classes.add(d);

			ClassSchedule schedule = new ClassSchedule(classNames, classes);
			return schedule;
		}
		//TODO make menu event
		private static MenuEvent makeActivity() {
			MenuEvent activity = new MenuEvent(10, 0, 0, "Participate in Lab Study", 0);
			return activity;
		}



}
