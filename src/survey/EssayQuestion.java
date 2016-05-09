package survey;

import com.google.gson.JsonObject;

public class EssayQuestion extends ShortQuestion {

	public EssayQuestion(String prompt) {
		super(prompt);
	}

	public EssayQuestion() {
	}

	@Override
	public String pprint() {
		return prompt;
	}

	@Override
	public String jsonPrint() {
		return "{ type: \"Essay\", prompt: \""+getPrompt()+"\"}";
	}

	@Override
	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}

	@Override
	public String getPrompt() {
		return prompt;
	}
	public void load(JsonObject jo)
	{
		super.load(jo);
	}

}
