package survey;

import java.util.List;

public class RankingQuestion extends MatchingQuestion {

	String prompt;
	public RankingQuestion(String prompt, List<String> column2, Answer correctAnswer) {
		this.prompt = prompt;
		this.correctAnswer = correctAnswer;
		this.column2 = column2; 
		for(int i = 1; i <= column2.size(); i++)
		{
			column1.add(""+i);
		}
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
		return prompt;
	}

}
