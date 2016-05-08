package survey;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Survey {
	
	List<Question> questions = new ArrayList<Question>();
	String name;
	public Survey()
	{
		name = "";
	}
	public Survey(String name)
	{
		this.name = name;
	}
	public void save(String path)
	{
		BufferedWriter out = null;
		try  
		{
		    FileWriter fstream = new FileWriter("out.txt", false); //true tells to append data.
		    out = new BufferedWriter(fstream);
		    String writeText = "{ type : survey; name: "+name+"questions: ["; 
		    if(questions != null)	{
		    	for(Question q: questions)
		    	{
		    		writeText += q.jsonPrint();
		    	}
			}
		    writeText += "]}";
		    out.write(writeText);
		}
		catch (IOException e)
		{
		    System.err.println("Error: " + e.getMessage());
		}
		finally
		{
		    if(out != null) {
		        try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		    }
		}
		return;
	}
	@SuppressWarnings("resource")
	public void addQuestion(String type)
	{
		Scanner reader = new Scanner(System.in);
		Question q = null;
		Answer correctAnswer = null;
		switch(type)
		{
		case "MCQ": 	
		{ 
						List<Answer> choices = new ArrayList<Answer>();
						System.out.println("Please enter prompt");
						String prompt = reader.nextLine();
						boolean exitChoices = true;
						do 
						{	System.out.println("Please enter a choice and choice index");
							System.out.println("Choice Text: ");
							String cText = reader.nextLine();
							System.out.println("Choice Int: ");
							int cIndex = reader.nextInt();
							System.out.println("Enter Y to add more choices, Enter N to finish this question");
							String toContinue = reader.nextLine();
							choices.add(new MCQAnswer(cIndex, cText));
							if(toContinue == "Y")
							{
								exitChoices = false;
							}
						}while(exitChoices == false);
						q = new MCQQuestion(prompt, choices, correctAnswer);
		}break;
		case "Ranking": 
			{			List<String> column2 = new ArrayList<String>();
						System.out.println("Please enter prompt");
						String prompt = reader.nextLine();
						boolean exitChoices = true;
						do 
						{	System.out.println("Please enter a next column 2 value");
							System.out.println("Column2 Text: ");
							column2.add(reader.nextLine());
							System.out.println("Enter Y to add more choices, Enter N to finish this question");
							String toContinue = reader.nextLine();
							if(toContinue == "Y")
							{
								exitChoices = false;
							}
						}while(exitChoices == false);	
						q = new RankingQuestion(prompt, column2, correctAnswer);
			}break;
		case "Matching":
			{			List<String> column1 = new ArrayList<String>();
						List<String> column2 = new ArrayList<String>();
						System.out.println("Please enter prompt");
						String prompt = reader.nextLine();
						boolean exitChoices = true;
						do 
						{
							System.out.println("Please enter a next column 1 and column 2 value");
							System.out.println("Column1 Text: ");
							column1.add(reader.nextLine());
							System.out.println("Column2 Text: ");
							column2.add(reader.nextLine());
							System.out.println("Enter Y to add more choices, Enter N to finish this question");
							String toContinue = reader.next();
							if(toContinue.equals("Y"))
							{
								exitChoices = false;
							}
							else
							{
								exitChoices = true;
							}
						}while(exitChoices == false);
						q = new MatchingQuestion(prompt, column1, column2, correctAnswer);
			}break;
		
		case "T/F":
		{
						System.out.println("Please enter prompt");
						String prompt = reader.nextLine();
						q = new TAndFQuestion(prompt, correctAnswer);
		}break;
		case "Short": 	
		{				System.out.println("Please enter prompt");
						String prompt = reader.nextLine();
						q = new ShortQuestion(prompt, correctAnswer);
		}break;
		
		case "Essay": 	
		{				System.out.println("Please enter prompt");
						String prompt = reader.nextLine();
						q = new EssayQuestion(prompt);
		}break;
		}
		questions.add(q);
	}
	
	public String pprint()
	{
		String output = "Name: "+name;
		if(questions == null)
		{
			output+="\n";
			return output;
		}
		for (Question q : questions) {
			output+= "\nQuestion "+questions.indexOf(q);
			output+= "\n"+q.pprint();
		}
		output+="\n";
		return output;
	}
}
