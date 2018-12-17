package app;

import java.io.IOException;

import app.model.Lesson;
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
	
	private Lesson[] lesson;
	private int currentLessonNumber = 0;
	
	public MainApp() {
		lesson = new Lesson[] {new Lesson("as df"), new Lesson("ghjk"), new Lesson("qwer")};
	}
	
	public Lesson getLessonData() {
        return lesson[currentLessonNumber];
    }
	
	public boolean nextLesson() {
		if (currentLessonNumber == 2)
			return false;
		else {
			currentLessonNumber ++;
			return true;
		}
	}
	
//	public void printHello() {
//		System.out.println("Hello");
//	}
	
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
            
//            scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
//            	@Override
//                public void handle(KeyEvent event) {
//            		// controller.keyDown(event);
//            		
//            		if(event.getCode() != KeyCode.SHIFT && event.getCode() != KeyCode.CONTROL && event.getCode() != KeyCode.META) {
//            			controller.keyDown(event);
//            		}
//                	else {
//                		System.out.println(event.getCode());
//                		event.consume();
//                	}
//            	}
//            });

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
