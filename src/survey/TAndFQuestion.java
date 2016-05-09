package survey;

import java.util.ArrayList;

public class TAndFQuestion extends MCQQuestion  {
	
	public TAndFQuestion(String prompt, Answer correctAnswer) {
		super(prompt, correctAnswer);
		Answer TrueAnswer = new MCQAnswer(1, "True");
		Answer FalseAnswer = new MCQAnswer(2, "False");
		choices = new ArrayList<Answer>();
		this.choices.add(0, TrueAnswer);
		this.choices.add(1, FalseAnswer);
	}

	public TAndFQuestion() {
		// TODO Auto-generated constructor stub
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
