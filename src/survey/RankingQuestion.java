package survey;

import java.util.List;

public class RankingQuestion extends MatchingQuestion {

	public RankingQuestion(String prompt, List<String> column2, Answer correctAnswer) 
	{
		super(prompt, column2, correctAnswer);
	}

	public RankingQuestion() {
	}

	@Override
	public void setPrompt(String prompt) {
		this.prompt = prompt;
		
	}

	@Override
	public String getPrompt() {
		return this.prompt;
	}
	
	@Override
	public String jsonPrint()
	{
		return "";
	}
		
}
