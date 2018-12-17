package app.model;
import javafx.scene.input.KeyCode;

// read about collections, hashmaps, arrays etc. in Java

public class UserCharDist {
	
	private KeyCode key;
	private int freqCorrect;
	private int freqWrong;
	
	public UserCharDist(KeyCode key, int freqCorrect, int freqWrong) {
		this.key = key;
		this.freqCorrect = freqCorrect;
		this.freqWrong = freqWrong;
	}
}
