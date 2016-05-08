package survey;

public interface Question {

String pprint();
String jsonPrint();
void setPrompt(String prompt);
String getPrompt();
}
