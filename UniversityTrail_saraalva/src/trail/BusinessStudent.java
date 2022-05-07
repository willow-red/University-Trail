package trail;

import java.util.ArrayList;

public class BusinessStudent extends Student{
	//default (new player) constructor:
		public BusinessStudent(String name) {
			super(name, 1000, "Freshman", 1, 0, 100, 100, 100, makeSupplyList(), makeSchedule(), "Entrepreneurship Club", makeActivity(), makeStringSupplyList(makeSupplyList()));
			super.setMajorName("BusinessStudent");
		}
		//constructor for loading data:
		//String typeOfStudent, String name, double funds, String year, int week, 
		//int mealSwipes, int happiness, int health, int grades
		public BusinessStudent(String name, double funds, String year, int week, int mealSwipes, int happiness, int health, int grades) {
			super(name, funds, year, week, mealSwipes, happiness, health, grades, makeSupplyList(), makeSchedule(), "Entrepreneurship Club", 
					makeActivity(), makeStringSupplyList(makeSupplyList()));
			super.setMajorName("BusinessStudent");
		}

		private static ArrayList<Shop> makeSupplyList(){
			ArrayList<Shop> supplies = new ArrayList<>();
			//hardcode some supplies for each major:
			//paint set:
			supplies.add(Shop.values()[6]);
			supplies.add(Shop.values()[1]);
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
			classNames.add("BUSINESS101 - Management");
			ClassOnSchedule a = new ClassOnSchedule("BUSINESS101 - Management", 0);
			classes.add(a);
			classNames.add("BUSINESS102 - Intro to Business");
			ClassOnSchedule b = new ClassOnSchedule("BUSINESS102 - Intro to Business", 0);
			classes.add(b);
			classNames.add("BUSINESS103 - Accounting");
			ClassOnSchedule c = new ClassOnSchedule("BUSINESS103 - Accounting", 1);
			classes.add(c);
			classNames.add("CALC101 - Intro to Calculus");
			ClassOnSchedule d = new ClassOnSchedule("CALC101 - Intro to Calculus", 3);
			classes.add(d);

			ClassSchedule schedule = new ClassSchedule(classNames, classes);
			return schedule;
		}
		//TODO make menu event
		private static MenuEvent makeActivity() {
			MenuEvent activity = new MenuEvent(10, 0, 0, "Invest in Stocks", 0);
			return activity;
		}


}
