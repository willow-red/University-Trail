package trail;

import java.util.ArrayList;

public class EconStudent extends Student{
	
	//default (new player) constructor:
			public EconStudent(String name) {
				super(name, 1000, "Freshman", 1, 0, 100, 100, 100, makeSupplyList(), makeSchedule(), "Investment Club", makeActivity(), makeStringSupplyList(makeSupplyList()));
				super.setMajorName("EconStudent");
			}
			//constructor for loading data:
			//String typeOfStudent, String name, double funds, String year, int week, 
			//int mealSwipes, int happiness, int health, int grades
			public EconStudent(String name, double funds, String year, int week, int mealSwipes, int happiness, int health, int grades) {
				super(name, funds, year, week, mealSwipes, happiness, health, grades, makeSupplyList(), makeSchedule(), "Investment Club", 
						makeActivity(), makeStringSupplyList(makeSupplyList()));
				super.setMajorName("EconStudent");
			}

			private static ArrayList<Shop> makeSupplyList(){
				ArrayList<Shop> supplies = new ArrayList<>();
				//hardcode some supplies for each major:
				//paint set:
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
				classNames.add("ECON101 - Intro to Economics");
				ClassOnSchedule a = new ClassOnSchedule("ECON101 - Intro to Economics", 1);
				classes.add(a);
				classNames.add("ECON102 - Microeconomics");
				ClassOnSchedule b = new ClassOnSchedule("ECON102 - Microeconomics", 1);
				classes.add(b);
				classNames.add("ECON103 - Macroeconomics");
				ClassOnSchedule c = new ClassOnSchedule("ECON103 - Macroeconomics", 1);
				classes.add(c);
				classNames.add("PSYCH101 - Intro to Psychology");
				ClassOnSchedule d = new ClassOnSchedule("PSYCH101 - Intro to Psychology", 3);
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
