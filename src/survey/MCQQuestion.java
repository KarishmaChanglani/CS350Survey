package survey;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class MCQQuestion implements Question {

	String prompt;
	List<Answer> choices;
	Answer correctAnswer;
	public MCQQuestion(String prompt, Answer correctAnswer)
	{
		this.prompt = prompt;
		this.correctAnswer = correctAnswer;
	}
	public MCQQuestion(String prompt, List<Answer> choices, Answer correctAnswer) {
		this.prompt = prompt;
		this.correctAnswer = correctAnswer;
		this.choices = choices;
	}

	public MCQQuestion() {
	}
	@Override
	public String pprint() {
		String output = "";
		output += this.prompt+"\n"; 
		for(Answer a: choices)
		{
			output += a.pprint() +"\n";
		}
		if (correctAnswer != null)
		{
			output += "This correct Answer: \n";
			output += correctAnswer.pprint() + "\n";
		}
		return output; 		
	}

	@Override
	public String jsonPrint() {
		String output = "{ type: \"MCQ\""
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
	@Override
	public void setPrompt(String prompt) {
		this.prompt = prompt;
		
	}
	@Override
	public String getPrompt() {
		return this.prompt;
	}
	@Override
	public void load(JsonObject jo) {
		prompt = jo.get("prompt").toString();
		JsonArray ja = (JsonArray)jo.get("choices");
		List<Answer> choices = new ArrayList<Answer>();
		for(JsonElement e: ja)
		{
			Answer a = new MCQAnswer();
			a.load(e.getAsJsonObject());
		}
		this.choices = choices;
		Answer correctAnswer = new MCQAnswer();
		correctAnswer.load((JsonObject)jo.get("correctAnswer"));
		this.correctAnswer = correctAnswer;
		
	}

}
