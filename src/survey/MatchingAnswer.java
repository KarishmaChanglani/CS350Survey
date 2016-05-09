package survey;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class MatchingAnswer implements Answer {

	Map<String, String> choice = new HashMap<String, String>();
	public MatchingAnswer(List<String> column1, List<String> column2)
	{
		try
		{
		for (int i = 0; i < column1.size(); i++)
		{
			choice.put(column1.get(i), column2.get(i));
		}
		}
		catch(java.lang.NullPointerException e)
		{
			System.out.println(e.getMessage());
		}
	}
	@Override
	public String pprint() {
		String output = "\n"+ String.format("%26s", "Column 1") + String.format("%20s", "Column 2");
		for (Map.Entry<String, String> entry : choice.entrySet()) {
		    String key = entry.getKey();
		    String value = entry.getValue();
		    output += "\n"+ String.format("%26s", key) + String.format("%20s", value);
		}
		return output;
	}

	@Override
	public String jsonPrint() {
		String output = "{ columns: [";
		int i = 0;
		for (Map.Entry<String, String> entry : choice.entrySet()) {
		    if (i != 0)
		    {
		    	output += ",";
		    }
		    else 
		    {
		    	i++;
		    }
			String key = entry.getKey();
		    String value = entry.getValue();
		    output += "{ column1: "+ key + "," ;
			output += "  column2: "+ value + "}";
		}
		output += "]";
		output += "}";
		return output;
	}
	@Override
	public void load(JsonObject asJsonObject) {
		Map<String, String> choice = new HashMap<String, String>();
		JsonArray ja = (JsonArray)asJsonObject.get("columns");
		for(JsonElement e: ja)
		{
			JsonObject jo = e.getAsJsonObject();
			choice.put(jo.get("column1").toString(), jo.get("column2").toString());
		}
		this.choice = choice;
	}
	
}
