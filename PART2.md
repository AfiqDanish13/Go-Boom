# Part 2

## A. Member Contributions
| ID         | Name                             | Task Descriptions                                                                  | Contribution % |
| ---------- | -------------------------------- | --------------------------------------------------------------------------------- | -------------- |
| 1211103094 | Muhammad Irfan Bin Zulkifli      | - Added save and load function.<br>- Added several get and set methods in Game.java file | 33.33%         |
| 1211103424 | Muhammad Afiq Danish Bin Sunardi | - Implemented the logic for determining the winner of the round<br>- Created a scoring system for each card<br>- Modified the loop and interface of the system  | 33.33%         |
| 1211103147 | Ahmad Haikal Bin Emran           | - Helped in detecting and fixing bugs.<br>- Conducted test runs of the program to fix bugs                           | 33.33%         |

## B. Part 1 Feature Completion (Latest)

Mark Y for Complete, P for Partial done, N for Not implemented.

No | Feature                                                                         | Completed (Y/P/N)
-- | ------------------------------------------------------------------------------- | -----------------
1  | All cards should be faced up to facilitate checking.                            |        Y
2  | Start a new game with randomized 52 cards.                                      |        Y
3  | The first card in the deck is the first lead card and is placed at the center.  |        Y
4  | The first lead card determines the first player.                                |        Y
5  | Deal 7 cards to each of the 4 players.                                          |       Y
6  | All players must follow the suit or rank of the lead card.                      |       Y
7  | The highest-rank card with the same suit as the lead card wins the trick.       |       Y
8  | The winner of a trick leads the next card.                                      |       Y


## C. Part 2 Feature Completion

Mark Y for Complete, P for Partial done, N for Not implemented.

No | Feature                                                                          | Completed (Y/P/N)
-- | -------------------------------------------------------------------------------- | -----------------
1  | If a player cannot follow suit or rank, the player must draw from the deck       |         Y
   | until a card can be played.                                                      |         
2  | When the remaining deck is exhausted and the player cannot play,                 |         P
   | the player does not play in the trick.                                           |
3  | Finish a round of game correctly. Display the score of each player.              |         Y
4  | Can exit and save the game (use file or database).                               |         Y
5  | Can resume the game. The state of the game is restored when resuming a game      |         Y   
   | (use file or database).                                                          |         
6  | Reset the game. All scores become zero. Round and trick number restart from 1.   |         Y
7  | Support GUI playing mode (cards should be faced up or down as in the real game). |         N
   | The GUI can be in JavaFX, Swing, Spring, or Android.                             |
8  | Keep the console output to facilitate checking.                                  |         N
   | The data in console output and the GUI must tally.                               |


## D. Link to Part 2 GitHub Repo

https://github.com/AfiqDanish13/AssignmentTCP
