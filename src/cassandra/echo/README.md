# Echo the parrot
In this exercise we are going to create a parrot named echo, why echo? Because it's just going to repeat what we 
want it to.

## Purpose
This exercise is meant to teach you how to create a basic terminal program that can accept user input.

## Learning goals
- Reading from the terminal
- Writing to the terminal
- Keeping a program running until we want to close it
  - Control flow - how we act upon user input

# Exercise
This exercise has two files, Main.java and Parrot.java. Splitting your program up between multiple files can, 
depending on the scope of the project, be a good idea. The main program should be written in Main.java file while 
parrot specific code should go in the Parrot.java file. The different sections will specify the recommended file to 
write in.

**Contents**
1. Creating the program
2. Terminating the program
3. Creating the Parrot class
4. Core program loop
   1. Creating a parrot
   2. Make the parrot repeat a word

## Creating the program
This sections should be written in Main.java.

For the program to continue running we will need something to keep the program from terminating.
Can you think of any tools that would keep the program alive? We have an unspecified amount of time we need our 
program to run in. When we are dealing with unspecified numbers one set of tools in particular can be useful.

<details>
    <summary>Hint</summary>
    
    When we are unsure of how long we want something to run a loop is usually a good solution.
    A possible solution is to use a while loop, which is similar to a for loop. The main difference is that while loops
    simplifies checking for a single condition
```java
public void example() {
    boolean keepAlive = true;
    
    // this will never stop running, normally one should change the variable inside the loop
    // So the program does not run indefinitely
    while (keepAlive) {
        System.out.println("Keeping alive");
    }
}
```
</details>

## Terminating the program
This sections should be written in Main.java.

No program runs indefinitely, therefore we want to add an option to exit the program.
Since we are working in the terminal our options are limited to accepting user input from the Java Scanner.
Question is how we use that input to terminate the program?

<details>
    <summary>Hint</summary>

    When we want to act based on a user input a solid choice is an if statement, it allows us to control the flow of the program
```java
public void example() {
    Scanner scanner = new Scanner(System.in);
    boolean keepAlive = true;
    
    while (keepAlive) {
        System.out.println("Keeping alive");

        String input = scanner.nextLine();
        // remember to use .equals() when dealing with Strings
        if (input.equals("exit")) {
            keepAlive = false;
        }
    }
}
```
</details>

## Creating the Parrot class
This sections should be written in Parrot.java.

Now we move away from running the program and over to some more application specific logic.
The exercise comes with the Parrot class, now I want you to fill it out. What should a parrot have?

- A name
- A way to repeat what is said from the user input
- Extra
  - A way to retrieve the parrots name from outside the Parrot class, in case you want to display that

The two requested parrot features require different tools. Think of the name as data for a specific parrot, whereas 
the repeat feature is logic. We cannot always use a loop when we need repeatable logic, and that is the case here. How 
can we add a feature so that a parrot can repeat a given word?

<details>feature
    <summary>Name hint</summary>
    
    When we need to store data we use attributes.
```java
public class Person {
    // the name is data, also known as state, we store it using attributes
    private String name;
    
    // Here we set the name, this is done when we create a person which we will get to later
    public Person(String name) {
        this.name = name;
    }
}
```
</details>

<details>
    <summary>Repeat hint</summary>

    The repeat feature is logic that we want to be able to, well, repeat...  Creating a method for it allow us to 
    call in whatever scenario where we would want a parrot to repeat a word. The example below is similar to what 
    we need in our Parrot class
```java
    // sayHello is logic that can be repeated, specifically for a Person class, similar to Parrot it has a name
    // This method is very similar to what we need from the parrots repeat method
    public void sayHello(String name) {
        System.out.print("Hello ");
        System.out.print(name);
        System.out.print(" my name is ");
        System.out.println(this.name);
    }
```
</details>

As for the extra part, how can and should we retrieve the parrots name? If you already solved the other two 
requirements then this should be easy enough. 

<details>
    <summary>Hint</summary>

    When we want to expose private data we need public methods that return that data. This specific type of method 
    is called a getter.
```java
public class Person {
    // the name is data, also known as state, we store it using attributes
    private String name;
    
    public Person(String name) {
        this.name = name;
    }

    // we use methods to expose private data, also known as getters
    public String getName() {
        return this.name;
    }
}
```
</details>

## Core program loop
This sections and it's subsections should be written in Main.java.Parrot

In this section we will be finishing the program. To do so we need to create our parrot and make it repeat what we 
say.

### Creating a parrot
This section covers part of a slightly more advanced topic that we will be skipping over for the most part. We are 
going to create a parrot using our parrot class.

In the example below we see how to create a new parrot, using the "new" keyword. Dont think too much about it for now, 
all you need to know is that we are bringing a new parrot into the world.
```java
public void example() {
    // The String inside the () is the name we give our parrot
    // You can name the parrot whatever you want, this exercise will stick with the theme though
    Parrot parrot = new Parrot("Echo");
}
```

We will be using this parrot to repeat what the user writes in the terminal. Where should you create the parrot. 
Inside the loop or outside of it? Remember that there are no right or wrong answers, but some solutions are better 
in regard to performance, structure etc.

### Make the parrot repeat
Now we need to take the user input and make our parrot repeat it. You should already have the input from 
"Terminating the program" section. Now you just need to feed it to the parrot trough it's repeat method.

#### Extra
How do we prevent the parrot from repeating the input when we want to exit the program? When the input is not the 
word for exiting the program, we want to terminate the program

<details>
    <summary>Hint</summary>
    
    We can use an else statement to have a seperate branch of logic for every other word than, in this case, "exit".
    The example below is similar to what we want for our echo program.
```java
public void example() {
    Scanner scanner = new Scanner(System.in);

    while (keepAlive) {
        String input = scanner.nextLine();
        if (input.equals("exit")) {
            keepAlive = false;
        } else {
            System.out.println("Not exit");
        }
    }
}
```
</details>