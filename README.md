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
2. In summary, it seems like my CI process is largely effective, especially with successful integrations and no issues in ci.yml. However, the issues in sonar.yml should be addressed to maintain high code quality, which is a crucial aspect of CI. For the CD part, the process remains effective due to the deployment to production is automatic and happens right after successful CI builds.
   
Reflection 3:

1. Principles I applied to my project:
   - Single Responsibility Principle: All classes that I made have a single responsibility, for instance, ProductController seems to have a single responsibility, it handles HTTP requests related to Product entities. Furthermore, I broke the inheritance relationship between ProductController and CarController since they didn't have any overlapping usage and are 2 different entities used for different purposes.
   - Liskov Substitution Principle (LSP): In the source code given in the tutorial, extending CarController to ProductController seems a little bias because they deal with different endpoints and potentially different business logic, this could lead to incorrect assumptions in the codebase about the interchangeability of these controllers. Due to tha, I removed the inheritance because CarController is not suitable for ProductController
   - Open/Closed Principle: I made all existing services private in the controller, but I didn't implement base controller.
   - ISP: I broke the services interface into several part which builds up CRUD, that is CreateService, ReadService, UpdateService, and DeleteService. Furthermore, I used generics so all this services could be accessed at once without having to implement seperate interfaces for Car and Product.
   - DIP: The source code given in the tutorial had already implemented this principle since all services are accessable from the high-level layer by an interface to access the lower parts. For instance, when we are adding a product in the controller, we accessed the product repository via services which are interfaces rather than accessing it directly to the class.

2. The main advantage that I felt is that the codes that I wrote after applying SOLID are generally shorter. Moreover, debugging seems easier since the services had been broken down, so if I found errors in a method, I could easily trace the source of it.
3. The disadvandates of not using SOLID prnciple might be a harder time in debugging the code. Notice that tasks in this tutorial are mostly similar to the ones in the tutorial 1. However, it took me over an hour to debug errors in tutorial 1. In this tutorial, it only took me less than 10 minutes due to the simplicity of code that this principle gave me.

Reflection 4:
 1. By following TDD, the tests were written before the actual implementation, ensuring that the code meets the specified requirements. This approach helps in designing modular, testable code and encourages incremental development. Moreover, using pre-defined test-cases made the development process more intuitive due to having already thought about the functionality of the program whilst writing the test. From my own POV, I really view TDD as one of the most effective way to develope a certain program functionality, since I myself really like the vibes of coding a program where test cases are available like DSA and CP.
 2. They are Fast because they run quickly, Independent because they can be run in any order without dependencies, Repeatable because they produce the same result each time they are run, and Self-Validating because they assert expected outcomes. However, I feel like there will always be a room for improvement to ensure that the tests are Timely. So in conclusion, it covers the FIRST principle.
