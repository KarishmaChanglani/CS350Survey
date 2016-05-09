package survey;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class MatchingQuestion implements Question {

	String prompt;
	List<String> column1; 
	List<String> column2;
	Answer correctAnswer;
	public MatchingQuestion(String prompt, List<String> column2, Answer correctAnswer)
	{
		this.prompt = prompt;
		this.correctAnswer = correctAnswer;
		this.column2 = column2; 
		this.column1 = new ArrayList<String>();
		for(int i = 1; i <= column2.size(); i++)
		{
			try
			{
			column1.add(""+i);
			}
			catch(java.lang.NullPointerException e)
			{
				System.out.println("There is an extra input in column 2 correct Answer:"+ e.getMessage());
			}
		}
	}
	public MatchingQuestion(String prompt,  List<String> column1,	List<String> column2, Answer correctAnswer) {
		this.prompt = prompt;
		this.column1 = column1;
		this.column2 = column2;
		this.correctAnswer = correctAnswer; 
	}

	public MatchingQuestion() {
	}
	@Override
	public String pprint() {
		String output = getPrompt();
		output += "\n"+ String.format("%26s", "Column 1") + String.format("%20s", "Column 2");
		for (int i =0; i < column1.size(); i++)
		{
			output += "\n"+ String.format("%26s", this.column1.get(i)) + String.format("%20s", this.column2.get(i));
		}
		if (correctAnswer != null)
		{
			correctAnswer.pprint();
		}
		return output;
	}

	@Override
	public String jsonPrint() {
		String output = "{ type: \"Matching\", prompt: \""+getPrompt()+"\""; //type is purely added for using json in order to distinguish between question types
		output += ", columns: [";
		for (int i =0; i < column1.size(); i++)
		{
			
			output += "{ column1: \""+ this.column1.get(i) + "\"," ;
			output += "  column2: \""+ this.column2.get(i) + "\"}";
			if (i < column1.size() - 1) //to make sure we don't have a trailing , at the end
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
		prompt = jo.get("prompt").getAsString();
		JsonArray ja = (JsonArray)jo.get("columns");
		List<String> column1 = new ArrayList<String>(); 
		List<String> column2 = new ArrayList<String>();
		for(JsonElement e: ja)
		{
			JsonObject json = e.getAsJsonObject();
			column1.add(json.get("column1").getAsString());
			column2.add(json.get("column2").getAsString());
		}
		this.column1 = column1;
		this.column2 = column2;
		try{
		Answer correctAnswer = new MCQAnswer();
		correctAnswer.load((JsonObject)jo.get("correctAnswer"));
		this.correctAnswer = correctAnswer;
		}
		catch(java.lang.NullPointerException e)
		{
			correctAnswer = null;
		}
	}

}
