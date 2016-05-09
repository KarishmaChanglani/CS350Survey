Author: Karishma Changlani

HW 2 CS 350 
Comments: 
So the save and load works as expected. While pretty bad input safe putting string values instead of int
will crash the program. Also when entering the correct answer put them in right pairing the order doesn't matter. 
I wasn't able to add check functionality for if the answer for correctAnswer is actually present in the options 
available for each of the questions. Also if the answer has more or less column matches for ranking or matching 
the program won't know. Also putting bad file names will also crash the program. 

File format used for saving is json and com.google.gson library was used to read these objects. 
A dummy example is in survey.txt

Thank you