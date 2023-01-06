# forvladislav

https://stackoverflow.com/questions/74983278/thymeleaf-iterator-theach-does-not-view-information/74983621?noredirect=1#comment132400761_74983621

It seems like you're having some trouble, so I thought I'd help you out with a working repo.

Clone the repository and run

<code>./gradlew bootRun</code>

It will download all the dependencies for you.

Once it's done, go to

http://localhost:8080

You can see that there are many ways to do this, but in general please pay attention to your IDE and where it is showing you errors, and resolve them before proceeding.  And write as little code as possible while still having it make logical sense for the next person reading your code.  (E.g., name it <code>description</code> instead of <code>courseDescription</code>.

You can structure the codebase different depending on how complex your requirements are.  For example, you can create a service for each repository.  In a small test application, this is likely not necessary.

Lombok is a very useful dependency and while not required, it can save you from a lot of typos.
