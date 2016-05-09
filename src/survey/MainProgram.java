package survey;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MainProgram {

	public static Survey createSurvey(String choice)
	{
		if (choice.equals("Test"))
		{
			return new Test();
		}
		else if(choice.equals("Survey"))
		{
			return new Survey();
		}
		return null;
	}
	
	public static Survey loadSurvey(String choice, String path) throws IOException
	{ 
		System.out.println("Entered this");
		Survey surv = createSurvey(choice);
		BufferedReader in; 
		in = new BufferedReader(new FileReader(path));
		String jsonString = "";
		String line = in.readLine();
		while(line != null)
		{
			jsonString += line;
			line = in.readLine();
		}		
		JsonParser jsonParser = new JsonParser();
		JsonObject jo = (JsonObject)jsonParser.parse(jsonString);
		surv.load(jo);
		in.close();
		return surv;
	}
	
	public static void displaySurvey(Survey surv)
	{
		System.out.print(surv.pprint());
	}
	
	public static void saveSurvey(Survey surv, String path)
	{
		surv.save(path);
	}
	
	public static void displayMenu1()
	{
		System.out.println("What type of Questionnaire do you want to use?");
		System.out.println("1. Survey"); 
		System.out.println("2. Test");
	}
	
	public static void displayMenu2(String option)
	{
		System.out.println("Do you want to");
		System.out.println("1. Create a/an "+option); 
		System.out.println("2. Load "+option);
		System.out.println("3. Display "+option);
		System.out.println("4. Save "+option);
		System.out.println("5. Quit");
	}
	
	public static void displayMenu3()
	{
		System.out.println("Do you want to");
		System.out.println("1. Add a new T/F question"); 
		System.out.println("2. Add a new multiple choice question");
		System.out.println("3. Add a new short answer question");
		System.out.println("4. Add a new essay question");
		System.out.println("5. Add a new ranking question");
		System.out.println("6. Add a new matching question");
		System.out.println("7. Quit");
		System.out.println("8. Go back to previous menu");
	}
	public static void main(String args[]) throws IOException
	{

		Scanner reader = new Scanner(System.in);
		boolean cont = true;
		String menu1Choice = "";
		Survey s = null;
		do
		{
			displayMenu1();
			int choice = reader.nextInt();
			if(choice == 1)
			{
				menu1Choice = "Survey";
				cont = false;
			}
			else if(choice == 2)
			{
				menu1Choice = "Test";
				cont = false;
			}
			else
			{
				System.out.println("Bad option please try again");
			}
		}while(cont);
		cont = true;
		do
		{
			displayMenu2(menu1Choice);
			int choice = reader.nextInt();
			switch(choice)
			{
			case 1:  s = createSurvey(menu1Choice);
					 boolean contMenu3 = true;
					 do
					 {
						displayMenu3();
					 	int menu3choice = reader.nextInt();
						switch(menu3choice) {
						case 1: s.addQuestion("T/F");
								break;
						case 2: s.addQuestion("MCQ");
								break;
						case 3: s.addQuestion("Short");
								break;
						case 4: s.addQuestion("Essay"); 
								break;
						case 5: s.addQuestion("Ranking");
								break;
						case 6: s.addQuestion("Matching");
								break;
						case 7: System.exit(0);
								break;
						case 8: contMenu3 = false;
								break;
					 	default: System.out.println("Bad option, try again");
					 	}	
					 }while(contMenu3);
					 break;
			case 2:  System.out.println("Please enter the path of the file from which to load the survey");
					 String pathLoad = reader.next();
					 s = loadSurvey(menu1Choice, pathLoad); 
					 break; 
			case 3:  displaySurvey(s);
					 break; 
			case 4:  System.out.println("Please enter the path where you want to save the survey");
					 String pathSave = reader.next();
					 saveSurvey(s, pathSave);
					 break;
			case 5:  System.exit(0);
					 break;
			default: System.out.println("Bad option, Please try again");
					 cont = true;
			}	
		}while(cont);
		reader.close();		
	}
}
