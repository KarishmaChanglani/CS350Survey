package survey;

import java.util.List;

public class MatchingQuestion implements Question {

	String prompt;
	List<String> column1; 
	List<String> column2;
	Answer correctAnswer;
	public MatchingQuestion()
	{
		
	}
	public MatchingQuestion(String prompt,  List<String> column1,	List<String> column2, Answer correctAnswer) {
		this.prompt = prompt;
		this.column1 = column1;
		this.column2 = column2;
		this.correctAnswer = correctAnswer; 
	}

	@Override
	public String pprint() {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public String jsonPrint() {
		// TODO Auto-generated method stub
		return ""
				;
	}

	@Override
	public void setPrompt(String prompt) {
		this.prompt = prompt;
		
	}

	@Override
	public String getPrompt() {
		return prompt;
	}

}
