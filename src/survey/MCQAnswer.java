package survey;

import com.google.gson.JsonObject;

public class MCQAnswer implements Answer {

	String choiceText;
	int choiceIndex;
	
	public MCQAnswer(int choiceIndex, String choiceText)
	{
		this.choiceIndex = choiceIndex; 
		this.choiceText  = choiceText;
	}
	
	public MCQAnswer() {
	}

	@Override
	public String pprint() {
		String output = "";
		output+= this.choiceIndex+" "+this.choiceText;
		return output;
	}

	@Override
	public String jsonPrint() {
		return "{ choiceText : \""+getChoiceText()+"\","+"choiceIndex : "+ getChoiceIndex() +"}";
	}
	public String getChoiceText()
	{
		return choiceText;
	}
	
	public void setChoiceText(String choiceText)
	{
		this.choiceText = choiceText;
	}
	
	public int getChoiceIndex()
	{
		return choiceIndex;
	}
	
	public void setChoiceText(int choiceIndex)
	{
		this.choiceIndex = choiceIndex;
	}

	@Override
	public void load(JsonObject asJsonObject) {
		choiceText = asJsonObject.get("choiceText").getAsString();
		choiceIndex = Integer.parseInt(asJsonObject.get("choiceIndex").getAsString());
	}
	
	
}
