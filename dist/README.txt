+-------+
| About |
+-------+

MC Toe is a server plugin for allowing members to play each other in tic tac toe. Players may either directly request another player to start a game or join a pool of players and let the gods of randomness decide the matchup pairing.

(Note: all commands begin with /ttt- as to protect against namespace clashing with other plugins.)


+---------------------+
| Starting a new game |
+---------------------+

To start a game with another player, type /ttt-ask <other player's name>. If you are too shy to ask or you just want to play a random player, join the pool by typing /ttt-pool_join. Then you may start a new game by typing /ttt-pool_play and the system will randomly pair you up with anybody else chilling in the pool.
Should somebody ask you to play, you can either accept the challenge with /ttt-accept or not with /ttt-deny. Note that if you have a pending challenge (ie somebody sent you a game request), the plugin will automatically deny any new challenges until you accept or deny your old one.


+----------------+
| Playing a game |
+----------------+

Now that a game has been started, a player is randomly chosen to go first. Each square on the board has a number, starting with 1 at the top left corner, 2 at the top middle, . . . like this:

 1 | 2 | 3
---+---+---
 4 | 5 | 6   <-------- A Tic Tac Toe board
---+---+---
 7 | 8 | 9

To move, type /ttt-move <loc> to make your mark on the board, where loc is the number of the square. Don't worry, no memorization of this board is needed. After every move, the updated board is printed. Should something grab your attention for a while or should verbose jerks lay siege to the other wise pristine chat logs, you can always redraw the board with /ttt-board . x marks will mark the first player's moves, o marks will for the second player, and numbers show the left over moves. If at any time you wish to quit, you may do so with /ttt-quit.