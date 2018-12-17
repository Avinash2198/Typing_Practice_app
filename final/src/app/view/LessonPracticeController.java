package app.view;

import app.MainApp;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;


public class LessonPracticeController {
	
	@FXML
	private TextArea lessonContentView;
	
	@FXML
	private Label inputCurrentLabel;
	
	@FXML
	private Label lessonCurrentLabel;
	
	@FXML
	private Label resultLabel;
	
	@FXML
	private Label timeLabel;
	
	@FXML
	private Label inputTotalView;
	
	@FXML
	private Button startButton;
	
	// stats labels
	
	@FXML
	private Label lesNetLabel1;
	
	@FXML
	private Label lesAccLabel1;
	
	@FXML
	private Label lesNetLabel2;
	
	@FXML
	private Label lesGroLabel;
	
	@FXML
	private Label lesAccLabel2;
	
	@FXML
	private Label oveNetLabel;
	
	@FXML
	private Label oveGroLabel;
	
	@FXML
	private Label oveAccLabel;
	
	@FXML
	private GridPane statGrid ;
	
	@FXML
	private ImageView hands;
	
	@FXML
	private ImageView homeRow;
	
	@FXML
	private Button nextButton;
	
    MainApp mainApp;
	
    public LessonPracticeController() {
    }
    
    @FXML
    private void initialize() {
    }
    
    private void loadLessonContent() {
    	lessonContentView.setText("");
    	lessonContentView.setText(mainApp.getLessonData().getLessonContent());
    }
 
    @FXML
    private void startTyping() {
    	isLessonOver = false;
    	
    	startCount();
    	keyListener();
    	
    	lessonContentView.setDisable(false);
    	inputTotalView.setDisable(false);
    	
    	lessonContentView.requestFocus();
    	
    	startButton.setVisible(false);
    	
    }
    
	private Integer deciSeconds = 0;
	private Double deciSecondsDouble;
	private Timeline time = new Timeline(); 
	
	private void increaseTimer() {
		deciSeconds ++;
	}
    
    private void startCount(){
        time.setCycleCount(Timeline.INDEFINITE);
        KeyFrame frame;
        frame = new KeyFrame(Duration.millis(100),new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    increaseTimer();
                    mainApp.stats.lessonTime ++;
                    timeLabel.setText(((Integer)(deciSeconds/10)).toString() + " sec");
                }
            });
        time.getKeyFrames().add(frame);
        time.playFromStart();
    }
    
    boolean isLessonOver = true;
    
    public void keyListener() {
    	lessonContentView.setOnKeyPressed(new EventHandler<KeyEvent>() {
    		
        	@Override
            public void handle(KeyEvent event) {
        		if(!isLessonOver)
        			keyDown(event);
        		else
        			event.consume();
        	}
        });
    }
    
    public void buttonKeyListener(Button b) {
    	b.setOnKeyPressed(new EventHandler<KeyEvent>() {
    		
        	@Override
            public void handle(KeyEvent event) {
        		if(isLessonOver)
        			if (event.getCode() == KeyCode.ENTER)
        				b.fire();
        		else
        			event.consume();
        	}
        });
    }
    
    public void keyDown(KeyEvent key) {
    	String lessonCurrentStr = mainApp.getLessonData().getCurrentStr();
    	KeyCode inputCurrentKC = key.getCode();
    	String inputCurrentStr = key.getText();
    	
    	if (inputCurrentKC != KeyCode.SPACE && inputCurrentKC != KeyCode.SHIFT && inputCurrentKC != KeyCode.CONTROL && key.getCode() != KeyCode.META) {
    		inputLabelChange(inputCurrentStr);
    		checkInput(lessonCurrentStr, inputCurrentStr);
    	}
    		
    	else if (key.getCode() == KeyCode.SPACE) {
    		inputLabelChange("SPC");
    		checkInput(lessonCurrentStr, inputCurrentStr);
    	}
    	else key.consume();
    }
    
    public void inputLabelChange(String labelText) {
    	inputCurrentLabel.setText(labelText);
    }
    
    public void endLesson() {
    	time.stop();
		isLessonOver = true;
		
    	lessonContentView.setText("Click on NEXT or press Enter to go to next lesson ...");
    	Double deciSecondsDouble = (double)deciSeconds / 10;
    	timeLabel.setText(deciSecondsDouble.toString() + " sec");
    	
    	nextButton.setVisible(true);
    	
		inputTotalView.setDisable(true);
		lessonContentView.setDisable(true);
		
		nextButton.requestFocus();
		buttonKeyListener(nextButton);
		
		statGrid.setVisible(true);
		hands.setVisible(false);
		homeRow.setVisible(false);
		
		mainApp.stats.updateOverallStats();
		showUpdatedOverallStats();
    }
    
    public void showUpdatedOverallStats() {
    	statGrid.setVisible(true);
    	lesNetLabel2.setText(mainApp.stats.lessonNetWPM.toString());
    	lesGroLabel.setText(mainApp.stats.lessonGrossWPM.toString());
    	lesAccLabel2.setText(mainApp.stats.lessonAccuracyPercentage.toString());
    	oveNetLabel.setText(mainApp.stats.overallNetWPM.toString());
    	oveGroLabel.setText(mainApp.stats.overallGrossWPM.toString());
    	oveAccLabel.setText(mainApp.stats.overallAccuracyPercentage.toString());
    }
    
    public void lessonLabelChange() {
    	String str = mainApp.getLessonData().getCurrentStr();
    	if (str == null) {
			endLesson();
		}
		else if (str.equals(" ")){
			lessonCurrentLabel.setText("SPC");
		}
		else lessonCurrentLabel.setText(str);
    }
       
    public void checkInput(String lesson, String input) {
    	if (lesson.equals(input)) {
    		inputTotalView.setText(inputTotalView.getText() + input);
    		mainApp.getLessonData().goToNextChar();
    		resultLabel.setText("RIGHT");
    		lessonLabelChange();
    		
    		mainApp.stats.increaseCharRight();
    		mainApp.stats.updateLessonStats();
    		showUpdatedLessonStats();
    	}
    	else {
    		resultLabel.setText("WRONG");
    		
    		mainApp.stats.increaseCharWrong();
    		mainApp.stats.updateLessonStats();
    		showUpdatedLessonStats();
    	}
    }
    
    public void showUpdatedLessonStats() {
    	lesNetLabel1.setText(mainApp.stats.lessonNetWPM.toString());
    	lesAccLabel1.setText(mainApp.stats.lessonAccuracyPercentage.toString());
    }
    
    public void loadNextLesson() {
    	
    	if (mainApp.nextLesson()) {
    		loadLessonContent();
    		inputTotalView.setText("");
    		timeLabel.setText("Press START");
    		inputLabelChange("");
    		lessonLabelChange();
    		resultLabel.setText("");
    		lesNetLabel1.setText("0");
            lesAccLabel1.setText("0");
    		
    		nextButton.setVisible(false);
        	startButton.setVisible(true);
        	startButton.requestFocus();
        	buttonKeyListener(startButton);
        	
        	statGrid.setVisible(false);
        	hands.setVisible(true);
    		homeRow.setVisible(true);

        	deciSeconds = 0;
        	time = new Timeline();
        	
        	mainApp.stats.flushResetLessonStats();
    	}
    	else {
    		nextButton.setVisible(false);
    		lessonContentView.setText("All lessons completed!");
    	}
    	
    }
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        
        firstLessonLoad();
    }
    
    public void firstLessonLoad() {
    	// setText
        loadLessonContent();
        inputTotalView.setText("");
        timeLabel.setText("Press START");
        inputLabelChange("");
        lessonLabelChange();
        resultLabel.setText("");
        lesNetLabel1.setText("0");
        lesAccLabel1.setText("0");
        
        // setDisable
        inputTotalView.setDisable(true);
        lessonContentView.setDisable(true);
        
        // buttons visibility, focus and KbdEvents
        nextButton.setVisible(false);
        startButton.requestFocus();
        buttonKeyListener(startButton);
        
        statGrid.setVisible(false);
    }
    
}
