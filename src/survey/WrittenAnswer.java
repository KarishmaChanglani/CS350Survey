package survey;

import com.google.gson.JsonObject;

public class WrittenAnswer implements Answer {

	String Text; 
	int characterLength;
	
	public WrittenAnswer(String Text, int length) {
		this.characterLength = length;
		this.Text = Text;
	}

	public WrittenAnswer() {
	}

	@Override
	public String pprint() {
		return getText();
	}

	public String getText() {
		return this.Text;
	}
	private int getLength() {
		return this.characterLength;
	}

	@Override
	public String jsonPrint() {
		String output = "{ text: \""+getText()+"\"";
			   output += ", characterLength: "+ getLength();
			   output += "}";
		return output;
	}

	@Override
	public void load(JsonObject JsonObject) {
		Text = JsonObject.get("text").toString();
		characterLength = Integer.parseInt(JsonObject.get("characterLength").toString());
	}
}
