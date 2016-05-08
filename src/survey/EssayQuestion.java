package survey;

public class EssayQuestion extends ShortQuestion {

	String prompt;
	public EssayQuestion(String prompt) {
		// TODO Auto-generated constructor stub
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
		return prompt;
	}

}
