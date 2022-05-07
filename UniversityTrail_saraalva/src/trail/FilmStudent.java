package trail;

import java.util.ArrayList;

public class FilmStudent extends Student{
	
	//default (new player) constructor:
		public FilmStudent(String name) {
			super(name, 1000, "Freshman", 1, 0, 100, 100, 100, makeSupplyList(), makeSchedule(), "Film Club", makeActivity(), makeStringSupplyList(makeSupplyList()));
			super.setMajorName("FilmStudent");
		}
		//constructor for loading data:
		//String typeOfStudent, String name, double funds, String year, int week, 
		//int mealSwipes, int happiness, int health, int grades
		public FilmStudent(String name, double funds, String year, int week, int mealSwipes, int happiness, int health, int grades) {
			super(name, funds, year, week, mealSwipes, happiness, health, grades, makeSupplyList(), makeSchedule(), "Film Club", 
					makeActivity(), makeStringSupplyList(makeSupplyList()));
			super.setMajorName("FilmStudent");
		}

		private static ArrayList<Shop> makeSupplyList(){
			ArrayList<Shop> supplies = new ArrayList<>();
			//hardcode some supplies for each major:
			//paint set:
			supplies.add(Shop.values()[1]);
			supplies.add(Shop.values()[2]);
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
			classNames.add("FILM101 - Intro to Film");
			ClassOnSchedule a = new ClassOnSchedule("FILM101 - Intro to Film", 0);
			classes.add(a);
			classNames.add("FILM102 - Intro to Cinematography");
			ClassOnSchedule b = new ClassOnSchedule("FILM102 - Intro to Cinematography", 0);
			classes.add(b);
			classNames.add("FILM103 - History of Film");
			ClassOnSchedule c = new ClassOnSchedule("FILM103 - History of Film", 2);
			classes.add(c);
			classNames.add("LIT101 - Intro to Literature");
			ClassOnSchedule d = new ClassOnSchedule("LIT101 - Intro to Literature", 1);
			classes.add(d);

			ClassSchedule schedule = new ClassSchedule(classNames, classes);
			return schedule;
		}
		//TODO make menu event
		private static MenuEvent makeActivity() {
			MenuEvent activity = new MenuEvent(10, 0, 0, "Go to Movie Theater", 0);
			return activity;
		}

}
