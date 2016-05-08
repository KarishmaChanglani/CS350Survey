package survey;

public class WrittenAnswer implements Answer {

	String Text; 
	int characterLength;
	
	public WrittenAnswer(String Text, int length) {
		this.characterLength = length;
		this.Text = Text;
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

}
