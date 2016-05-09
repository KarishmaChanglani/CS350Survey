package survey;

import com.google.gson.JsonObject;

public interface Question {

String pprint();
String jsonPrint();
void setPrompt(String prompt);
String getPrompt();
void load(JsonObject jo);
}
