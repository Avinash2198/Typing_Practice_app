package app.model;

public class Stats {
	private Integer totalTime;
	private Integer lessonTime;
	
	private Integer charRight;
	private Integer charWrong;
	
	private Double accuracyPercentage;
	
	private Double lessonGrossWPM;
	private Double lessonNetWPM;
	
	private Double overallGrossWPM;
	private Double overallNetWPM;
	
	public Stats() {
		this.totalTime = 0;
		this.charRight = 0;
		this.charWrong = 0;
	}
	
	
}
