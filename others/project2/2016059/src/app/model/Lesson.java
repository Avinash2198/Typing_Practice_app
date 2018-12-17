package app.model;

public class Lesson {
	private String lessonContent;
	private int currentPosition;
	
	public Lesson(String lessonContent) {
		this.lessonContent = lessonContent;
		this.currentPosition = 0;
	}
	
	public String getLessonContent() {
		return lessonContent;
	}
	
	public void setLessonContent(String lessonContent) {
		this.lessonContent = lessonContent;
	}
	
	public void goToNextChar() {
		currentPosition ++;
	}
	
	public String getCurrentStr() {
		if (currentPosition < lessonContent.length())
			return lessonContent.substring(currentPosition, currentPosition + 1);
		else
			return null;
	}
}
