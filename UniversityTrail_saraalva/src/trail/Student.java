/**
 * 
 */
package trail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Set;


/**
 * @author saraalvarado
 *
 *Student info
 */
public abstract class Student implements HasStatus{
	
	private String name;
	private double funds;
	private String year;
	private int weekInSemester;
	private int mealSwipes;
	private int happinessStatus;
	private int healthStatus;
	private int gradesStatus;
	private ArrayList<Shop> supplyList;
	private ClassSchedule schedule;
	private String club;
	private MenuEvent activity;
	private ArrayList<String> supplyListStrings;
	private String majorName;
	
	
	//constructor with all fields:
	public Student(String name, double funds, String year, int weekInSemester, int mealSwipes, int happinessStatus,
			int healthStatus, int gradesStatus, ArrayList<Shop> supplyList, ClassSchedule schedule, String club,
			MenuEvent activity, ArrayList<String> supplyListStrings) {
		super();
		this.name = name;
		this.funds = funds;
		this.year = year;
		this.weekInSemester = weekInSemester;
		this.mealSwipes = mealSwipes;
		this.happinessStatus = happinessStatus;
		this.healthStatus = healthStatus;
		this.gradesStatus = gradesStatus;
		this.supplyList = supplyList;
		this.schedule = schedule;
		this.club = club;
		this.activity = activity;
		this.supplyListStrings = supplyListStrings;
		this.majorName = null;
	}
	
	public String getMajorName() {
		return majorName;
	}
	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public double getFunds() {
		return funds;
	}
	public void setFunds(double funds) {
		this.funds = funds;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public int getWeekInSemester() {
		return weekInSemester;
	}
	public void setWeekInSemester(int weekInSemester) {
		this.weekInSemester = weekInSemester;
	}
	public int getMealSwipes() {
		return mealSwipes;
	}
	public void setMealSwipes(int mealSwipes) {
		this.mealSwipes = mealSwipes;
	}
	public int getHappinessStatus() {
		return happinessStatus;
	}
	public void setHappinessStatus(int happinessStatus) {
		this.happinessStatus = happinessStatus;
		if(this.happinessStatus > 100) {
			this.happinessStatus = 100;
		}
	}
	public int getHealthStatus() {
		return healthStatus;
	}
	public void setHealthStatus(int healthStatus) {
		this.healthStatus = healthStatus;
		if(this.healthStatus > 100) {
			this.healthStatus = 100;
		}
	}
	public int getGradesStatus() {
		return gradesStatus;
	}
	public void setGradesStatus(int gradesStatus) {
		this.gradesStatus = gradesStatus;
		if(this.gradesStatus > 100) {
			this.gradesStatus = 100;
		}
	}
	public void setGradesStatus() {
		int total = 0;
		for(ClassOnSchedule c: schedule.getClassList()) {
			total += c.getClassGradeStatus();
		}
		this.gradesStatus = total;
	}
	
	public ArrayList<Shop> getSupplyList() {
		return supplyList;
	}
	public void setSupplyList(ArrayList<Shop> supplyList) {
		this.supplyList = supplyList;
	}
	public ClassSchedule getSchedule() {
		return schedule;
	}
	public void setSchedule(ClassSchedule schedule) {
		this.schedule = schedule;
	}
	public String getClub() {
		return club;
	}
	public void setClub(String club) {
		this.club = club;
	}
	public MenuEvent getActivity() {
		return activity;
	}
	public void setActivity(MenuEvent activity) {
		this.activity = activity;
	}
	public ArrayList<String> getSupplyListStrings() {
		return supplyListStrings;
	}
	public void setSupplyListStrings(ArrayList<String> supplyListStrings) {
		this.supplyListStrings = supplyListStrings;
	}


	@Override
	public int hashCode() {
		return Objects.hash(funds, gradesStatus, happinessStatus, healthStatus, mealSwipes, name, weekInSemester, year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Double.doubleToLongBits(funds) == Double.doubleToLongBits(other.funds)
				&& gradesStatus == other.gradesStatus && happinessStatus == other.happinessStatus
				&& healthStatus == other.healthStatus && mealSwipes == other.mealSwipes
				&& Objects.equals(name, other.name) && weekInSemester == other.weekInSemester
				&& Objects.equals(year, other.year);
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", funds=" + funds + ", year=" + year + ", weekInSemester=" + weekInSemester
				+ ", mealSwipes=" + mealSwipes + ", happinessStatus=" + happinessStatus + ", healthStatus="
				+ healthStatus + ", gradesStatus=" + gradesStatus + "]";
	}
	
	
	//print supply list
	public void printSupplyList(){
		//hashmap
		HashMap<String, Integer> supplies = new HashMap<>();
		//count dupes in supplylist:
		for(String s: this.getSupplyListStrings()) {
			int count = 0;
			for(String j: this.getSupplyListStrings()) {
				if(s.equalsIgnoreCase(j)) {
					count++;
					supplies.put(s, count);
				}
				else {
					supplies.put(s, count);
				}
			}
		}
		Set<String> keys = supplies.keySet();
		System.out.println("Here is your class supply list:");
		for(String key:keys) {
			System.out.println("\t" + supplies.get(key) + " " + key);
		}
	}
	//from interface
	public void printHappinessStatus() {
		System.out.println(this.happinessStatus + "/" + 100);
	}
	public void printHealthStatus() {
		System.out.println(this.healthStatus + "/" + 100);
	}
	public void printGradesStatus() {
		System.out.println(this.gradesStatus + "/" + 100);
	}

	
}
