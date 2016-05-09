package survey;

import com.google.gson.JsonObject;

public class ShortQuestion implements Question {

	String prompt;
	Answer correctAnswer;
	public ShortQuestion(String prompt)
	{
		this.prompt = prompt;
		correctAnswer = null;
	}
	public ShortQuestion(String prompt, Answer correctAnswer) {
		this.prompt = prompt;
		this.correctAnswer = correctAnswer;
	}
	public ShortQuestion() {
	}
	@Override
	public String pprint() {
		String output = getPrompt();
		if(correctAnswer != null)
		{
			output+="\n";
			output += correctAnswer.pprint();
		}
		return output;
	}

	@Override
	public String jsonPrint() {
		String output = "{ type: \"Short\", prompt: "+getPrompt();
		if(correctAnswer != null)
		{
			output += ", correctAnswer:" + correctAnswer.jsonPrint(); 
		}
		output += "}";
		return output;
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
	public void load(JsonObject jo) {
		prompt = jo.get("prompt").toString();
		Answer correctAnswer = new WrittenAnswer();
		correctAnswer.load((JsonObject)jo.get("correctAnswer"));
		this.correctAnswer = correctAnswer;		
	}

}
