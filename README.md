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
