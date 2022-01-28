# cs1302-hw09 Tic-Tac-Toe Solver

![Approved for: Spring 2021](https://img.shields.io/badge/Approved%20for-Spring%202021-success)

This homework futher explores the concept of [recursion](https://github.com/cs1302uga/cs1302-hw09).

You will write a method to print all possible Tic-Tac-Toe boards from a given starting point. Some helpful
utility methods are provided for you in the starter code contained in the provided Maven project.

## Course-Specific Learning Outcomes
* **LO2.c:** Use recursion to solve a non-trivial problem in a software solution.

## References and Prerequisites

* [`CSCI 1302 Recursion Tutorial`](https://github.com/cs1302uga/cs1302-tutorials/blob/master/recursion.md)

## Questions

In your notes, clearly answer the following questions. These instructions assume that you are 
logged into the Odin server. 

**NOTE:** For each step, please provide in your notes the full command that you typed to make the related 
action happen along with an explanation of why that command worked. Some commands require multiple options. 
It is important to not only recall what you typed but also why you typed each of them. If context is necessary 
(e.g., the command depends on your present working directory), then please note that context as well.
You won't need to submit your notes in your final submission. However, if done properly, your exercise notes 
will serve as a helpful study guide for the exam.

### Intro / Demo Video

If you'd like to see a quick walkthrough of each checkpoint in this homework, check out the intro video found
[here](https://www.youtube.com/watch?v=9QF9EDT7B14&t=1s). Please note that this video was made using a different
writeup but the program works the same way and all of the checkpoints still line up. Just don't be shocked if you
notice that the GitHub page in the video looks slightly different from this one.

### Getting Started

1. The [`CSCI 1302 Recursion Tutorial`](https://github.com/cs1302uga/cs1302-tutorials/blob/master/recursion.md) is
   a prerequisite. **If you have not completed the tutorial, you are not prepared to complete this homework assignment**.
   Please complete the tutorial first and ask any questions you have.
   
1. After completing the tutorial, use Git to clone the repository for this exercise onto Odin into a subdirectory called 
   `cs1302-hw09`:

   ```
   $ git clone --depth 1 https://github.com/cs1302uga/cs1302-hw09.git
   ```

1. Change into the `cs1302-hw09` directory that was just created and look around. There should be
   multiple Java files contained within the directory structure. To see a listing of all of the 
   files under the `src` subdirectory, use the `find` command as follows:
   
   ```
   $ find src
   ```
   
## Exercise Steps

### Checkpoint 1 Steps

1. While looking in the `src` directory, you likely saw a file called `TTTUtility.java`. 
   This file contains a Tic-Tac-Toe utility class with some helpful methods.
   Take a few minutes to familiarize yourselves with the documentation for these methods 
   using the documentation found here: 
   [TTT Utility](http://csweb.cs.uga.edu/~barnes/cs1302-ttt/)

1. Take a few more minutes to read through `TTTSolver.java`. This file contains a `main` method
   which takes in an encoding for a game board. It then passes this game board to `printAllBoards`. 
   We will implement `printAllBoards` soon. For now, it simply prints the current game board.

1. **Next, use Maven to compile and run the code.**. Please use the `exec:java` phase with
   the `-Dexec.mainClass` option to run. The program should ask you to enter a game board. Make sure
   you read the documentation for `TTTUtility` to fully understand the board layout.
      * Enter a valid game board (try `XOX---OXO` to start) and make sure the board is printed to the 
        screen before moving on.
      * Enter an invalid game board (try `XOX---XOX`). Can you see why this is invalid?
        Hint: If `'X'` has gone 4 times, how many times should `'O'` have gone?
   * Once you get the code to compile and run, please write down the command you used
     in your notes along with your chosen board configuration.
   
1. Open the `TTTUtility.java` file and implement the `isCat` method. The method takes a `String` 
   reference to the current game board. 
   * **Note:** a game is a _cat game_ (or tie) if all spaces are full and neither `'X'`
     nor `'O'` has won the game. To simplify your implementation, use the methods already 
     present in `TTTUtility`.

1. Add a line to the `main` method in `TTTSolver.java` to print `true` if the
   specified game board is a tie and `false` otherwise. You should use the `isCat` method
   that you wrote in the previous step.
   * Here's an valid example cat game (you should also test with others): `XOXXOXOXO`.
   
1. Ensure you pass `checkstyle`, recommit if needed, **and tag as `checkpoint-1`**.

<hr/>

![CP](https://img.shields.io/badge/Just%20Finished%20Checkpoint-1-success?style=for-the-badge)

<hr/>

### Checkpoint 2 Steps

1. Consider a recursive implementation for the `printAllBoards` method in `TTTSolver`. Make sure you read the Javadoc
   comment for the method before attempting implementation.

   * Identify the base case(s). Give an example. **Hint:** A base case for tic-tac-toe would be any
     configuration resulting in the game being over.
   
   * Identify the recursive case(s).
   
   * Draw the recursion tree for `printAllBoards("XOXOXO---")`.

   * Check your recursion tree again the solution found here: [Recursion Tree](rec_tree.txt).

1. Implement the `printAllBoards` method in `TTTSolver`. Remember to make local variables for any data you want to be preserved
   across recursive calls.

1. Use Maven to compile and run the code. Run the code with a blank board (`---------`) and watch it go! It's printing all possible
   tic-tac-toe boards!
   
1. After you've confirmed that it compiles and runs, ensure you pass `checkstyle`, recommit if needed, **and tag as `checkpoint-2`**.

<hr/>

![CP](https://img.shields.io/badge/Just%20Finished%20Checkpoint-2-success?style=for-the-badge)

<hr/>

### Checkpoint 3 Steps

1. Implement a new method in `TTTSolver` called `countAllWinningBoards`
   that, given an initial board state and a player, returns a count of all winning board states
   for that player that can be reached via a valid sequence of moves by each player. Here is
   the signature for the method to help you get started:
   
   ```java
   int countAllWinningBoards(String board, char player)
   ```
   
1. In the `main` method of `TTTSolver`, add code to test your `countAllWinningBoards` method by reading
   input from the user. Since we already have the user entering a board, you will just need to add a 
   prompt for the user to type which player to evaluate (`X` or `O`). Then, output the result of calling
   `countAllWinningBoards(board, player)` to the console.

1. Now, if you run your code on a provided board, you can count the number of ways each player can win! So, in a
   way, it tells you who has the advantage at this stage of the game! Who do you think has the advantage when
   the game begins (i.e. when the board is blank)? Run your program to find out!
   * Note: with a blank board, `'X'` can win 131184 different ways and `'O'` can win 77904 ways. If you guessed
     that `'X'` has the advantage, you were correct!
   
1. Use Maven to compile and run the code. Use initial board configurations that you can compute manually to further
   test your code.
   
1. Ensure you pass `checkstyle`, recommit if needed, **and tag as `checkpoint-3`**.

<hr/>

![CP](https://img.shields.io/badge/Just%20Finished%20Checkpoint-3-success?style=for-the-badge)

<hr/>

### Submission Steps

**Each student needs to individually submit their own work.**

1. Create a plain text file called `SUBMISSION.md` directly inside the `cs1302-hw09`
   directory with the following information:

   1. Your name and UGA ID number
  
   Here is an example of the contents of `SUBMISSION.md`.
   
   ```
   Sally Smith (811-000-999)
   ```

1. Change directories to the parent of `cs1302-hw09` (e.g., `cd ..` from `cs1302-hw09`). If you would like
   to make a backup tar file, the instructions are in the submissions steps for [hw01](https://github.com/cs1302uga/cs1302-hw01).
   We won't repeat those steps here and you can view them as optional.
   
1. Use the `submit` command to submit this exercise to `csci-1302`:
   
   ```
   $ submit cs1302-hw09 csci-1302
   ```
   
   Read the output of the submit command very carefully. If there is an error while submitting, then it will displayed 
   in that output. Additionally, if successful, the `submit` command creates a new receipt file in the directory you 
   submitted. The receipt file begins with rec and contains a detailed list of all files that were successfully submitted. 
   Look through the contents of the rec file and always remember to keep that file in case there is an issue with your submission.

   **Note:** You must be on Odin to submit.

<hr/>

![CP](https://img.shields.io/badge/Just%20Finished-Submission-success?style=for-the-badge)

<hr/>

[![License: CC BY-NC-ND 4.0](https://img.shields.io/badge/License-CC%20BY--NC--ND%204.0-lightgrey.svg)](http://creativecommons.org/licenses/by-nc-nd/4.0/)

<small>
Copyright &copy; Michael E. Cotterell, Brad Barnes, and the University of Georgia.
This work is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/">Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License</a> to students and the public.
The content and opinions expressed on this Web page do not necessarily reflect the views of nor are they endorsed by the University of Georgia or the University System of Georgia.
</small>
