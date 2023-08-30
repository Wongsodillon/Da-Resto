
# Title and Description
'Da Resto' is a restaurant business simulation game. This game is made with threading implementation and is played in real-time. The game consists of restaurants, chefs, waiters and customers whose objects run in threads
## Design Patterns used

- Singleton for read-write highscore
- Singleton to save currently active restaurants
- State for restaurants, chefs, waiters and customers
- Factory for the recruitment of new chefs and waiters
- Mediator for communication between customers, chefs and waiters
- Observer to tell a customer generator class to start randomize
- Façade for all commands (user input) into game objects. For example: a class / thread that acts as a receiver for user input if you want to pause the game does not immediately loop game objects one by one to activate the isPause boolean. This functionality is hidden in a method, for example pauseGame in a Façade, Façade can be implemented in a Singleton that holds an active restaurant At the moment.
