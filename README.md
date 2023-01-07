# for vladislav

https://stackoverflow.com/questions/74983278/thymeleaf-iterator-theach-does-not-view-information/74983621?noredirect=1#comment132400761_74983621

It seems like you're having some trouble, so I thought I'd help you out with a working repo.

Clone the repository and run

<code>./gradlew bootRun</code>

It will download all the dependencies for you.

Once it's done, go to

http://localhost:8080

You can see that there are many ways to do this, but in general please pay attention to your IDE and where it is showing you errors, and resolve them before proceeding.  And write as little code as possible while still having it make logical sense for the next person reading your code.  (E.g., name it <code>description</code> instead of <code>courseDescription</code>.

You can structure the codebase differently depending on how complex your requirements are.  For example, you can create a service for each repository.  In a small test application, this is likely not necessary.

Lombok is a very useful dependency and while not required, when useed correctly it can save you from a lot of typos and just give you less to read and debug.

For Thymeleaf, always provide a default value (in brackets in the HTML file in this repository).  Then it allows you to open up the HTML file and inspect the design without having to start up Spring or anything else.  Make sure the HTML is well-formed, or you will have issues that are otherwise hard to understand.

There is one sample test written for this repository, and testing is a critical part of any changing project.  You will have slow progress in any complicated project without it.
