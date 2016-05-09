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
		String output = "{ type: \"Ranking\", prompt: "+getPrompt();
		output += ", Columns: [";
		for (int i =0; i < column1.size(); i++)
		{
			
			output += "{ column1: \""+ this.column1.get(i) + "\"," ;
			output += "  column2: \""+ this.column2.get(i) + "\"}";
			if (i < column1.size() - 1)
			{
				output += ",";
			}
		}
		output += "]";
		if(correctAnswer != null)
		{
			output += ", correctAnswer:" + correctAnswer.jsonPrint(); 
		}
		output += "}";
		return output;
	}
		
}
