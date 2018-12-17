package app.view;

import app.MainApp;
import app.model.Lesson;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class LessonPracticeController {
	@FXML
	private TextArea lessonContentView;
	
	@FXML
	private Label currentChar;
	
    private MainApp mainApp;
    
    public LessonPracticeController() {
    	
    }
    
    @FXML
    private void initialize() {
    	Lesson newLesson = new Lesson("ffjj");
    	showLessonContent(null);
    	showLessonContent(newLesson);
        
    }
    
    private void showLessonContent(Lesson lesson) {
    	if (lesson != null) {
    		lessonContentView.setText(lesson.getLessonContent());
    	}
    	else
    		lessonContentView.setText("");
    }
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        mainApp.getLessonData();
    }
}
