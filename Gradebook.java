package cs1;

public class Gradebook {

	private  String name;
	private int quizOne;
	private int quizTwo;
	private int quizThree;

	public Gradebook(String name,int quizOne,int quizTwo) {
		this.name=name;
		this.quizOne=quizOne;
		this.quizTwo=quizTwo;
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public int getQuizOne() {
		return quizOne;
	}
	public void setQuizOne(int quizOne) {
		this.quizOne=quizOne;
	}
	public int getQuizTwo() {
		return quizTwo;
	}
	public void setQuizTwo(int quizTwo) {
		this.quizTwo=quizTwo;
	}
	
	public int avg() {
		return(quizOne+quizTwo)/2;
	}
	public String toString() {
		return name+"\t"+quizOne+" \t"+quizTwo+"\t"+avg();
	}
}

