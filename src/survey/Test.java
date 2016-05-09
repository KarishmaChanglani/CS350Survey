package survey;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Load and save functions weren't added but are in fact inherited from Survey
public class Test extends Survey {
	@Override
	public void addQuestion(String type)
	{
		@SuppressWarnings("resource")
		Scanner reader = new Scanner(System.in);
		Question q = null;
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
							reader.nextLine();
							System.out.println("Enter Y to add more choices, Enter N to finish this question");
							String toContinue = reader.nextLine();
							choices.add(new MCQAnswer(cIndex, cText));
							if(toContinue.equals("Y"))
							{
								exitChoices = false;
							}
							else
							{
								exitChoices = true;
							}
						}while(exitChoices == false);
						System.out.println("Please the correct choice and choice index");
						System.out.println("Choice Text: ");
						String cText = reader.nextLine();
						System.out.println("Choice Int: ");
						int cIndex = reader.nextInt();
						Answer correctAnswer = new MCQAnswer(cIndex, cText);
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
							if(toContinue.equals("Y"))
							{
								exitChoices = false;
							}
							else 
							{
								exitChoices = true;
							}
						}while(exitChoices == false);
						List<String> c1 = new ArrayList<String>();
						List<String> c2 = new ArrayList<String>();
						int i =1;
						do
						{
							String correctc1 = ""+i;
							System.out.println("Please enter the correct column2 value");
							System.out.println("Column2 Text: ");
							String correctc2 = reader.nextLine();
							System.out.println("Enter Y to add more choices, Enter N to finish this question");
							String toContinue = reader.nextLine();
							c1.add(correctc1);
							c2.add(correctc2);
							if(toContinue.equals("Y"))
							{
								exitChoices = false;
							}
							else 
							{
								exitChoices = true;
							}
							i++;
						}while(exitChoices == false);
						Answer correctAnswer = new MatchingAnswer(c1, c2);
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
							String toContinue = reader.nextLine();
							if(toContinue.equals("Y"))
							{
								exitChoices = false;
							}
							else
							{
								exitChoices = true;
							}
						}while(exitChoices == false);
						List<String> c1 = new ArrayList<String>();
						List<String> c2 = new ArrayList<String>();
						do
						{
							System.out.println("Please enter the correct column1 and column2 value");
							System.out.println("Column1 Text: ");
							String correctc1 = reader.nextLine();
							System.out.println("Column2 Text: ");
							String correctc2 = reader.nextLine();
							System.out.println("Enter Y to add more choices, Enter N to finish this question");
							String toContinue = reader.nextLine();
							c1.add(correctc1);
							c2.add(correctc2);
							if(toContinue.equals("Y"))
							{
								exitChoices = false;
							}
							else
							{
								exitChoices = true;
							}
						}while(exitChoices == false);
						Answer correctAnswer = new MatchingAnswer(c1, c2);
						q = new MatchingQuestion(prompt, column1, column2, correctAnswer);
			}break;
		
		case "T/F":
		{
						System.out.println("Please enter prompt");
						String prompt = reader.nextLine();
						System.out.println("Please enter the correct choice and choice index");
						System.out.println("Choice Text: ");
						String cText = reader.nextLine();
						System.out.println("Choice Int: ");
						int cIndex = reader.nextInt();
						reader.nextLine();
						Answer correctAnswer = new MCQAnswer(cIndex, cText);
						q = new TAndFQuestion(prompt, correctAnswer);
		}break;
		case "Short": 	
		{				System.out.println("Please enter prompt");
						String prompt = reader.nextLine();
						System.out.println("Please enter the correctAnswer");
						System.out.println("Answer Text: ");
						Answer correctAnswer = new WrittenAnswer(reader.nextLine(), 100);
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

}
