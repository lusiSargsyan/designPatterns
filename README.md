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

#Behavioral
##Strategy(Policy Pattern) in Java. 
Strategy is a behavioral design pattern that turns a set of behaviors into objects and makes them interchangeable inside original context object. The original object, called context, holds a reference to a strategy object and delegates it executing the behavior.
In other words we use Strategy pattern when we have multiple algorithms for single task and allow user code
to decide which algorithm to use. As an example we can see sort method in Collections class. Method takes a Comparator as
a parameter and based on its implementation collection items will be sorted in different way.
**Basic** implementation requires that each Strategy implements an interface and provides a concrete implementation for an execute method. The strategy is selected and the execute method called via an interface reference.
There is also **Enum Strategy** implementation where we can implement your business rule in each constant.
The context class receives the strategy from the client and executes the algorithm in the selected strategy.
