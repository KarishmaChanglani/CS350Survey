package survey;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatchingAnswer implements Answer {

	Map<String, String> choice = new HashMap<String, String>();
	public MatchingAnswer(List<String> column1, List<String> column2)
	{
		for (int i = 0; i < column1.size(); i++)
		{
			choice.put(column1.get(i), column2.get(1)); //Assuming good input
		}
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
