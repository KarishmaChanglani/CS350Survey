package survey;

public class TAndFQuestion extends MCQQuestion  {

	String prompt;
	Answer[] choices = {new MCQAnswer(1, "T"), new MCQAnswer(2, "F")};
	
	public TAndFQuestion(String prompt, Answer correctAnswer) {
		this.prompt = prompt;
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
		return "";
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
