# Design Patterns

A design pattern is a well known and tested solution for a common problem.

The idea of Design Patterns in Software Engineering comes from one the most known book in computer science, by GoF (Gang of Four: E. Gamma, R. Helm, R. Johnson, J. Vlissides): "Design Patterns Elements of Reusable Object-Oriented Software" (1995). The main idea came from Architecture, and specifically, from the book by Christopher Alexander "The Timeless Way of Building" (Author:Christopher Alexander,Subject:Architecture,Publisher: Oxford University Press, Publication date:1979, Pages:552). The idea of Christopher Alexander was finding a "timeless way of building" or design patterns in architectures addressing a recurring design problem that arises in specific design situations and presents a solution to it. 

There are three types of *Design Patterns*.

N | Pattern name | Description 
------------ | ------------- | -------------
1 | Creational Patterns | Creational Design Patterns are providing a suitable solution for creating objects. 
2 | Structural Patterns | Structural patterns explain how to create flexible and efficient infrastructure.
3 | Behavioral Patterns | Behavioral patterns are assigning responsibilities between objects and defining the encapsulation behavior of the object.

# Creational patterns
  * Singltone
  * Factory Method 
  * Prototype 
  * Abstract Factory 
  * Builder 
  
  ## Singleton
  We are using Singleton classes when we need only one instance and that instance should be globally accessible.
  There are several cases when we can use this pattern but mostly for small applications. For example, making a Cache, creating a Logger or reading some configuration files. There are some disadvantages of using this pattern especially if you are using mutable Singleton. Here are some of them 
  * Tricky bugs
  * Poor testability 
  * Inflexibility
  * Code comprehension
  * Concurrency issues
  * Performance

In conclusion, we can say that whenever we create a singleton we need to make sure that it is an Immutable. Singleton design pattern is used in core java classes also, for example, java.lang.Runtime, java.awt.Desktop
## Factory Method Pattern (Virtual Constructor)
Define an interface for creating an object, but let subclasses decide which class to instantiate.
Factory Method lets a class defer instantiation to subclasses.
This pattern allows allows the consumer to create new objects without having to know the details of how they're created, 
or what their dependencies are - they only have to give the information they actually want.

## Builder Pattern
The builder pattern is used when we have an complex object with too many fields.
The intent of the Builder design pattern is to separate the construction of a complex object from its
representation. This is mostly helpful when we need to create an immutable state of object. 

Pros
1) Code is more maintainable if number of fields required to create object is more than 4 or 5.
2) Object Creation code less error-prone as user will know what they are passing because of explicit method call.
3) Builder pattern increase robustness, as only fully constructed object will be available to client.
4) You can force immutability to the object once its created.

Cons
1) Builder pattern is verbose and requires code duplication as Builder needs to copy all fields from Original or Item class.

## Prototype Pattern
This pattern is used when the cost of creating a new object is expensive and resource intensive.
Prototype pattern suggest to crate a copy of object instead of creating a new one.
1) If the class has only primitive data type members then a completely new copy of the object will be created and the reference to the new object copy will be returned.
2) If the class contains members of any class type then only the object references to those members are copied and hence the member references in both the original object as well as the cloned object refer to the same object. 
To implement this pattern we need to create an interface which has clone method and implement it in our class.

# Behavioral
This patterns provide solutions for better interactions between objects
and how to provide lose coupling and flexibility to extend easily.
There are eleven Behavioral design patterns:

1) Strategy Pattern
2) Chain of Responsibility
3) Command Pattern
4) Interpreter Pattern
5) Iterator Pattern
6) Mediator Pattern
7) Memento Pattern
8) Observer Pattern
9) State Pattern
10) Template Method Pattern
11) Visitor Pattern

## Strategy(Policy Pattern) in Java. 
Strategy is a behavioral design pattern that turns a set of behaviors into objects and makes them interchangeable inside original context object. The original object, called context, holds a reference to a strategy object and delegates it executing the behavior.
In other words we use Strategy pattern when we have multiple algorithms for single task and allow user code
to decide which algorithm to use. As an example we can see sort method in Collections class. Method takes a Comparator as
a parameter and based on its implementation collection items will be sorted in different way.
**Basic** implementation requires that each Strategy implements an interface and provides a concrete implementation for an execute method. The strategy is selected and the execute method called via an interface reference.
There is also **Enum Strategy** implementation where we can implement your business rule in each constant.
The context class receives the strategy from the client and executes the algorithm in the selected strategy.

## Chain of Responsibility

Chain of responsibility pattern defines structure por passing object along handlers chain 
until one of that handlers handles that request. All handlers 
1) are child of the same abstract class or implementing the same interface.
2) have a link to next handler.
###### One of the real life example of this pattern is in Java Servlet filters flow. 
As we know we can have multiple filters to process an HTTP request. To use this filters we are implementing Filter interface
and overriding doFilter method <br/>
#####doFilter(
      ServletRequest request,
      ServletResponse response,
      FilterChain chain
      )
In our doFilter method we can call
#####
      chain.doFilter(request, response); 
 to pass request to the next FilterChain.
      
The main disadvantage is that this pattern can create deep stack traces, which can affect performance

## Command pattern (Action or Transaction)

With command pattern we are wrapping a request to the single object and passing it to invoker.
Invoker looks at the object and pass it to corresponding handler. In this pattern client just 
gives instructions to invoke without knowing how it is going to be executed. 
It supports decoupling between a client object which request a
task and the receiver object which actually performs the task.
This pattern is not focused on the sequence of the tasks stored,
but on hiding the details/implementation of the actions performed.
To implement this pattern we need to
1) Define a Command interface with method execute(). This interface will be used by client to create all variety of commands.
2) An invoker class which will receive an object and perform any specific task 
requested by command.
FileSystem manager can be an example. This will do same tasks for different OS versions.
#### Usage in java
1) java.lang.Runnable 
2) javax.swing.Action

## Interpreter

This patter is used for defining grammatical representation of given language and give an interpreter
to interpret that language. The best example of interpreter design pattern is 
java compiler that interprets the java source code into byte code that is
understandable by JVM. Google Translator is also an example of interpreter
pattern where the input can be in any language and we can get the output
interpreted in another language. In short we can use this pattern 
when we need to do same thing in different languages or in different way.
Like in translator application or SQL language parser.
##### Usage in JDK
1) java.util.Pattern 
2) its subclasses java.text.Format

###### To implement this pattern we need
1) Interpreter engine which will interpret our expression or language
2) Expressions that will consume  the functionality provided by the interpreter context.
3) Client that will take the input from user and decide which Expression to use and then generate output for the user.

## Iterator
This design pattern is one of most used pattern in JDK especially in Collections framework.
Iterator Design Pattern provides an Iterator object to traverse a collection/container and access its member objects.

## Mediator

Mediator design pattern is one of the well known and used Behavioral pattern in Java.
This pattern is a great choice in case when you have a complicated communication between
objects and possible coupling. In such cases this pattern suggest as to keep our objects 
independent and use middleware moderator class which will manage communication between that objects.
The one of examples of this pattern is Controller class in MVC pattern. We can use this pattern 
for example in GUI applications to connect front and back parts. 

## Memento 
Memento design pattern is design which gives ability to restore object to its previous state.
To have Memento design we need to have 3 object.
1) **Originator** - this is an object which's original state we want to store. It keeps Memento object,
has setters and getters for that object. So in a nutshell Originator knows how to save its own state.
2) **Caretaker**  class which knows when and which state we need to store. It operates Originator object
and keeps Originator states before operating.
3) **Memento** The POJO object which contains storage of state and methods to interact with it.
This is mostly an immutable object .   
Real life example of Memento pattern is Git stash logic.
Another use case of this pattern is TextEditor or any kind of editor where Undo functionality is expected.
