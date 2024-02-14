Reflection 1
You already implemented two new features using Spring Boot. Check again your source code and evaluate the coding standards that you have learned in this module. 
Write clean code principles and secure coding practices that have been applied to your code.  If you find any mistake in your source code, please explain how to improve your code. 
Please write your reflection inside the repository's README.md file.

Answer:
Whilst checking my code, I've found some mistakes, generally related to clean code principles and coding standards. That is on the update and delete method on the ProductRepository method. While I was working on
the delete method, I directly linear searched the arralist to find the Id of the referenced product. Then, I did the same thing while working with the udpate method, resulting in a repeated code in the class. While 
this repeated code doesn't affect the programming logic, it does however boke the rules of clean code principles which is DRY (Do Not Repeat Yourself). Later on, fixed this issue by creating a seperate method of linear
seacrhing the arraylist that could be accessed by any other methods in the class.


Reflection 2:

1. List of code quality issues I fixed:
   As far as this project goes, I haven't met another code quality issues ever since Tutorial 1. But another issue that I encountered is an error that occurs in ci.yml. That is an issue regarding an error that
   occur due to not having an execution permission to gradlew. To dix this, I added the following script:

        name: Grant execute permission to Gradlew
        run: chmod +x ./gradlew
   
   
