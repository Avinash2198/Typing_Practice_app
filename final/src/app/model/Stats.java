package app.model;

// all time in deciseconds
// lesson = current at the end of lesson therefore the same thing
public class Stats {
	private int overallTime = 1;
	public int lessonTime = 1;
	
	private int lessonCharRight = 0;
	private int overallCharRight = 0;
	
	private int lessonCharWrong = 0;
	private int overallCharWrong = 0;
	
	public Double lessonAccuracyPercentage;
	public Double overallAccuracyPercentage;
	
	public Double lessonGrossWPM = 0.0;
	public Double overallGrossWPM;
	
	public Double lessonNetWPM = 0.0;
	public Double overallNetWPM;
//	
	public Stats() {
	}
	
	public void increaseCharWrong() {
		lessonCharWrong ++;
	}
	
	public void increaseCharRight() {
		lessonCharRight ++;
	}
	
	public void updateLessonStats() {
		int lessonCharTotal = lessonCharRight + lessonCharWrong;
		double timeInMinutes = (double)lessonTime/600;
		this.lessonAccuracyPercentage = 100 * (double)lessonCharRight/(lessonCharTotal);
		this.lessonGrossWPM = ((double)lessonCharTotal/5)/timeInMinutes;
		this.lessonNetWPM = ((double)lessonCharRight/5)/timeInMinutes;
	}
	
	public void flushResetLessonStats() {
		// flush current lesson values to overall
		overallCharRight += lessonCharRight;
		overallCharWrong += lessonCharWrong;
		overallTime += lessonTime;
		// reset lesson stats 
		lessonCharRight = 0;
		lessonCharWrong = 0;
		lessonTime = 1;
	}
	
	public void updateOverallStats() { // call only after both flush and reset have been done (or both not been done), else wrong values calculated
		int overallCharRightTemp = overallCharRight + lessonCharRight ;
		int overallCharWrongTemp = overallCharWrong + lessonCharWrong;
		int overallCharTotalTemp = overallCharRightTemp + overallCharWrongTemp;
		int overallTimeTemp = overallTime + lessonTime;
		double timeInMinutesTemp = (double)overallTimeTemp/600;
		this.overallAccuracyPercentage = 100 * (double)overallCharRightTemp/(overallCharTotalTemp);
		this.overallGrossWPM = ((double)overallCharTotalTemp/5)/timeInMinutesTemp;
		this.overallNetWPM = ((double)overallCharRightTemp/5)/timeInMinutesTemp;
	}	
}
