package app.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Lesson {
	private final StringProperty lessonContent;
	
	public Lesson(String lessonContent) {
		this.lessonContent = new SimpleStringProperty(lessonContent);
	}
	
	public String getLessonContent() {
		return lessonContent.get();
	}
	
	public void setLessonContent(String lessonContent) {
		this.lessonContent.set(lessonContent);
	}
	
	public StringProperty lessonContentProperty() {
        return lessonContent;
    }
}
