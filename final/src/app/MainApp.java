package app;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import app.model.Lesson;
import app.model.Stats;
import app.view.LessonPracticeController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class MainApp extends Application {
	private Stage primaryStage;
	private BorderPane rootLayout;
	private AnchorPane lessonPractice;
	private Scene scene;
	
	private List<Lesson> lesson = new ArrayList<Lesson>();
	private int currentLessonNumber = 0;
	public Stats stats = new Stats();
	
	public MainApp() {
		readLessonFromFile();
	}
	
	private int noOfLessons;
	
	public void readLessonFromFile() {
		String line;

	    try {
	    	int i;
	    	InputStream is = MainApp.class.getClassLoader().getResourceAsStream("lesson.txt");
	    	BufferedReader bufferreader = new BufferedReader(new InputStreamReader(is));
	        // BufferedReader bufferreader = new BufferedReader(new FileReader("lesson.txt"));
	        line = bufferreader.readLine();
	        for (i = 0; line!=null; i ++) {
	        	lesson.add(new Lesson(line));
	        	line = bufferreader.readLine();
	        }
	        this.noOfLessons = i + 1;
	        bufferreader.close();

	    } catch (FileNotFoundException ex) {
	        ex.printStackTrace();
	    } catch (IOException ex) {
	        ex.printStackTrace();
	    }
	}
	
	public Lesson getLessonData() {
        return lesson.get(currentLessonNumber);
    }
	
	
	public boolean nextLesson() {
		if (currentLessonNumber == noOfLessons - 1)
			return false;
		else {
			currentLessonNumber ++;
			return true;
		}
	}
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Typing Practice App");

        initRootLayout();

        showLessonPractice();
	}

	public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            this.scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public void showLessonPractice() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/LessonPractice.fxml"));
            lessonPractice = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(lessonPractice);

            // Give the controller access to the main app.
            LessonPracticeController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public Stage getPrimaryStage() {
        return primaryStage;
    }

	
	public static void main(String[] args) {
		launch(args);
	}
}
