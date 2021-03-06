package trail;

import java.util.Objects;

// contains info on the grades
public class ClassOnSchedule {
	
	private String className;
	private String classGradeLetter;
	private int classGradeNum;
	//for adding to total the grade status for student(each class is 25 since only 4 classes can be taken at once - totals 100)
	private int classGradeStatus;
	//num studying per week:
	private int numStudyingRequired;
	private boolean hasFinalExam;
	private boolean hasFinalProject;
	private boolean hasMidterm;
	private boolean studied;
	
	

	public ClassOnSchedule(String className, String classGradeLetter, int classGradeNum, int classGradeStatus, int numStudyingRequired,
			boolean hasFinalExam, boolean hasFinalProject, boolean hasMidterm, boolean studied) {
		super();
		this.className = className;
		this.classGradeLetter = classGradeLetter;
		this.classGradeNum = classGradeNum;
		this.classGradeStatus = classGradeStatus;
		this.numStudyingRequired = numStudyingRequired;
		this.hasFinalExam = hasFinalExam;
		this.hasFinalProject = hasFinalProject;
		this.hasMidterm = hasMidterm;
		this.studied = studied;
	}

	//when making a schedule, use default values:
	public ClassOnSchedule(String className, int numStudyingRequired, boolean hasFinalExam, boolean hasFinalProject, boolean hasMidterm) {
		this(className, "A", 100, 25, numStudyingRequired, hasFinalExam, hasFinalProject, hasMidterm, false);
	}
	public ClassOnSchedule(String className, int numStudyingRequired) {
		this(className, "A", 100, 25, numStudyingRequired, true, false, true, false);
	}
	
	//calc grade letter:
	public void setClassGradeLetter() {
		if(this.classGradeNum > 93) {
			this.classGradeLetter = "A";
		}
		else if(this.classGradeNum < 93 && this.classGradeNum >= 90) {
			this.classGradeLetter = "A-";
		}
		else if(this.classGradeNum < 90 && this.classGradeNum >= 87) {
			this.classGradeLetter = "B+";
		}
		else if(this.classGradeNum < 87 && this.classGradeNum >= 83) {
			this.classGradeLetter = "B";
		}
		else if(this.classGradeNum < 83 && this.classGradeNum >= 80) {
			this.classGradeLetter = "B-";
		}
		else if(this.classGradeNum < 80 && this.classGradeNum >= 77) {
			this.classGradeLetter = "C+";
		}
		else if(this.classGradeNum < 77 && this.classGradeNum >= 73) {
			this.classGradeLetter = "C";
		}
		else if(this.classGradeNum < 73 && this.classGradeNum >= 70) {
			this.classGradeLetter = "C-";
		}
		else if(this.classGradeNum < 70 && this.classGradeNum >= 67) {
			this.classGradeLetter = "D+";
		}
		else if(this.classGradeNum < 67 && this.classGradeNum >= 65) {
			this.classGradeLetter = "D";
		}
		else {
			this.classGradeLetter = "F";
		}
	
	}
	public void study() {
		this.classGradeNum += 5*this.numStudyingRequired;
		if(this.classGradeNum > 100) {
			this.classGradeNum = 100;
		}
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getClassGradeLetter() {
		return classGradeLetter;
	}

	public void setClassGradeLetter(String classGradeLetter) {
		this.classGradeLetter = classGradeLetter;
	}

	public int getClassGradeNum() {
		return classGradeNum;
	}

	public void setClassGradeNum(int classGradeNum) {
		this.classGradeNum = classGradeNum;
	}

	public int getClassGradeStatus() {
		return classGradeStatus;
	}

	public void setClassGradeStatus(int classGradeStatus) {
		this.classGradeStatus = classGradeStatus;
	}

	public int getNumStudyingRequired() {
		return numStudyingRequired;
	}

	public void setNumStudyingRequired(int numStudyingRequired) {
		this.numStudyingRequired = numStudyingRequired;
	}

	public boolean isHasFinalExam() {
		return hasFinalExam;
	}

	public void setHasFinalExam(boolean hasFinalExam) {
		this.hasFinalExam = hasFinalExam;
	}

	public boolean isHasFinalProject() {
		return hasFinalProject;
	}

	public void setHasFinalProject(boolean hasFinalProject) {
		this.hasFinalProject = hasFinalProject;
	}

	public boolean isHasMidterm() {
		return hasMidterm;
	}

	public void setHasMidterm(boolean hasMidterm) {
		this.hasMidterm = hasMidterm;
	}

	public boolean isStudied() {
		return studied;
	}

	public void setStudied(boolean studied) {
		this.studied = studied;
	}

	@Override
	public int hashCode() {
		return Objects.hash(classGradeLetter, classGradeNum, classGradeStatus, className, hasFinalExam, hasFinalProject,
				hasMidterm, numStudyingRequired, studied);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClassOnSchedule other = (ClassOnSchedule) obj;
		return Objects.equals(classGradeLetter, other.classGradeLetter) && classGradeNum == other.classGradeNum
				&& classGradeStatus == other.classGradeStatus && Objects.equals(className, other.className)
				&& hasFinalExam == other.hasFinalExam && hasFinalProject == other.hasFinalProject
				&& hasMidterm == other.hasMidterm && numStudyingRequired == other.numStudyingRequired
				&& studied == other.studied;
	}

	@Override
	public String toString() {
		return "ClassOnSchedule [className=" + className + ", classGradeLetter=" + classGradeLetter + ", classGradeNum="
				+ classGradeNum + ", classGradeStatus=" + classGradeStatus + ", numStudyingRequired="
				+ numStudyingRequired + ", hasFinalExam=" + hasFinalExam + ", hasFinalProject=" + hasFinalProject
				+ ", hasMidterm=" + hasMidterm + ", studied=" + studied + "]";
	}

	
	

}
