package survey;

public class EssayQuestion extends ShortQuestion {

	String prompt;
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
		return "{ type: \"Essay\", prompt: "+getPrompt()+"}";
	}

	@Override
	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}

	@Override
	public String getPrompt() {
		return prompt;
	}

}
