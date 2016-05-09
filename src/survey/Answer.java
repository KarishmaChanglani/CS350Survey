package survey;

import com.google.gson.JsonObject;

public interface Answer {
	String pprint();
	String jsonPrint();
	void load(JsonObject asJsonObject);
}
