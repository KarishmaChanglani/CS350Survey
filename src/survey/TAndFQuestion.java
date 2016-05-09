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
	}

	@Override
	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}

	@Override
	public String getPrompt() {
		return prompt;
	}
	@Override
	public String jsonPrint() {
		String output = "{ type: \"T/F\","
				+ "prompt : \"";
		output += getPrompt()+"\"\n"; 
		output += ", choices : [";
		int i = 0; 
		for(Answer a: choices)
		{
			if (i != 0)
			{
				output += ",";
			}
			else 
			{
				i++;
			}
			output += a.jsonPrint() +"\n";
		}

		output += "]";
		if (correctAnswer != null)
		{
			output += ", correctAnswer: ";
			output += correctAnswer.jsonPrint() ;
		}
		output += "}";
		return output;
	}

}
