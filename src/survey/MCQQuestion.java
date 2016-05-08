package survey;

import java.util.List;

public class MCQQuestion implements Question {

	String prompt;
	List<Answer> choices;
	Answer correctAnswer;
	public MCQQuestion()
	{
		//TODO Fill default values
	}
	public MCQQuestion(String prompt, List<Answer> choices, Answer correctAnswer) {
		this.prompt = prompt;
		this.correctAnswer = correctAnswer;
		this.choices = choices;
	}

	@Override
	public String pprint() {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public String jsonPrint() {
		// TODO Auto-generated method stub
		return "";
	}
	@Override
	public void setPrompt(String prompt) {
		this.prompt = prompt;
		
	}
	@Override
	public String getPrompt() {
		// TODO Auto-generated method stub
		return this.prompt;
	}

}
