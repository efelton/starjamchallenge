
# Code Breaker Assignment

This was a coding assignment in Java for my Fundamentals of Programming class. The project was to create a version of
the children's game of mastermind where the program would randomly determine a key of four colours and the user would 
have to guess at the key. Each time the user makes a guess the program responds with information about how accurate the guess was.

See link for the assignment definition.

## Notes

* Presentation of the user interface had to be accomplished using a specific library called Javabook.
* Used an enum to distinguish between the different colours Red, Orange, Yellow, Green, Blue, Indigo, and Violet. In retrospect it would have been simpler to just use characters and strings for the keys.

## Highlights 

* Use of the strategy pattern for presentation. I implemented a command line user interface as well as the Javabook interface. Switching between these was as easy as instantiating a different subclass of `GameInputOutput`.
* Use of test cases to test various aspects of the program. See `CodePatchTest`, `GuessRecordTest`, `ColourTest` and `InputCheckerTest`.
* Use of regular expressions to process the input, see the `InputChecker` class.

## Detailed Assignment Definition 

A variation on the mastermind game

The java OO Program assignment – code breaker

Write the code breaker program as per spec below with text based display using the Javabook class library
Following an introduction screen that explains the game. he game starts by choosing the code patch which is a sequence of four colours from the following available colours red(R), orange (O), yellow (Y), green (G), blue (B), Indigo (I), and violet (V). The code patch is not displayed to the user only 4 lines are displayed ( _ _ _ _ ) and lives = 8.

The user enters a string of four characters which is their guess at the sequence of 4 letters choosen by the computer.

The user input is compared to the code patch and the following feedback is provided:
* If the two code patches match, the game says **YOU WIN, do you want to play again (Y/N)?**
* If one or more colours between the two colour patches match, display the positions where the colours match. If the colour is correct but the position is wrong for one or more colours give the user a clue as to how many colours there are in the in the users patch that are not in the correct position. If the same colour is used twice in the users patch and twice in the computers patch but the positions are wrong the clue will have a value of 2. if the colour patch has not been guessed then a life is lost and the user is asked : **Enter a sequence a 4 character sequence from ROYGBIV or 0 to exit:**
* If the number of lives is zero following this guess and the user has not won, then display, the code patch and. **YOU LOOSE, do you want to play again (Y/N)?**
* If instead of entering in a code sequence the user enters 0, or there are 0 in the code patch entered, exit the game (boss kill switch)
* If the same sequence is entered twice or more, inform the user that duplicate patches are not allowed and ask then to re enter a new code patch. No life is lose for a duplicate entry. Display the game as per the example screens below.

### Example Screens

#### Intro Screen
Introduction

The fate of the world rests on your shoulders. A lethal virus is about to be on leashed on the web. You can stop the viruses release if you can guess the sequence of 4 colors that delete the virus.

The possible colors are
* R - Red
* O - Orange
* Y - Yellow
* G - Green
* B - Blue
* I - Indigo
* V - Violet

You have only 8 chances to guess the code. Are you ready to save the world (Y/N)?

#### Start the Game

```
Lives: 8
Code: _ _ _ _ Guessed : _ _ _ _ Clues:
Enter a sequence a 4 character sequence from the following values ROYGBIV or 0 to exit:
```

#### Win the Game
```
Lives: 4
Code: _ _ _ _ Guessed : _ _ _ _ Clues:
Code: R _ _ _ Guessed : R O Y G Clues: 1
Code: R _ _ _ Guessed : R B G I Clues: 2
Code: R G _ _ Guessed : R G V I Clues: 2
Code: R G I V Guessed : R G I V Clues: 0
YOU WIN !!
Play again Y/N:
```

#### Lose the Game
```
Lives: 0
:
:
Code: R _ _ _ Guessed : R V V V Clues: 0
YOU LOOSE, the code was : R G I V
Play again Y/N:
```
