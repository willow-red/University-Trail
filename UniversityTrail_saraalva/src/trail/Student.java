/**
 * 
 */
package trail;

import java.util.Objects;

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
	
	public String getName() {
		return name;
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
	}
	public int getHealthStatus() {
		return healthStatus;
	}
	public void setHealthStatus(int healthStatus) {
		this.healthStatus = healthStatus;
	}
	public int getGradesStatus() {
		return gradesStatus;
	}
	public void setGradesStatus(int gradesStatus) {
		this.gradesStatus = gradesStatus;
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

	
}
