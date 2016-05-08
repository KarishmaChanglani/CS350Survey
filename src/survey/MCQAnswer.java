package survey;

public class MCQAnswer implements Answer {

	String choiceText;
	int choiceIndex;
	
	public MCQAnswer(int choiceIndex, String choiceText)
	{
		this.choiceIndex = choiceIndex; 
		this.choiceText  = choiceText;
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
	
	
}
