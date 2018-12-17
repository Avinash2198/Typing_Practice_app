package app;
import java.io.IOException;

import app.model.Lesson;
import app.view.LessonPracticeController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class MainApp extends Application {
	private Stage primaryStage;
	private BorderPane rootLayout;
	
	private ObservableList<Lesson> lessonData = FXCollections.observableArrayList();
	
	public MainApp() {
		lessonData.add(new Lesson("ffjj"));
	}
	
	public ObservableList<Lesson> getLessonData() {
        return lessonData;
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
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
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
            AnchorPane lessonPractice = (AnchorPane) loader.load();

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
