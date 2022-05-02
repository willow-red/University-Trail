package trail;

public enum Majors {
	ART("Art"),
	HISTORY("History"),
	SCIENCE("Science"),
	LAW("Law"),
	BUSINESS("Business"),
	ECON("Economics"),
	CS("Computer Science"),
	ENGLISH("English"),
	MEDICINE("Medicine"),
	FILM("Film");
	
	private final String title;
	
	Majors(String title){
		this.title = title;
	}
	
	public static String getMajorsMenu() {
		String menu = "\n";
		menu+= "Select a Major\n";
		for(int i = 0; i<32; i++) {
			menu+="-";
		}
		menu+= "\n\n";
		for(Majors op: Majors.values()) {

			menu += op.ordinal() + ". " + op.title + "\n";

		}
		menu += "\n";
		for(int i = 0; i<32; i++) {
			menu+="-";
		}
		return menu;
	}
	public String getTitle() {
		return title;
	}

}
