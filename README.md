# JPaint
JPaint Application for SE450:
Paint application that supports all required functionality for the first, second, and third check-in. In regards to the fuctionality for the fourth check-in, the grouping of shapes appears to work as intended. Grouped shapes are also
able to be copied, moved, pasted, and deleted with the expected outcome. Grouped shapes also correctly work with undo and redo methods of the group command, and also undo and redo methods of the ungroup command. To ungroup and group group shapes, selecting the group shape beforehand, which creates an outline around the shape, is not needed and causes errors. Simply press the undo and redo buttons after grouping or ungrouping. The fuctionality of groups of group shapes has very limited functionality. Other than just grouping grouped shapes together, every other functionality does not work. The design pattern I have implemented for this check-in is the builder design pattern. Using my JPaintController class as the target. I created a JPaintControllerBuilder class in order to access and create the builder in the main method. Then call on the builder to get my JPaintController.

GitHub Repo Link:
https://github.com/mabdelSE450/JPaint

# Program Interface
![Screenshot (184)](https://github.com/mabdelsPROJECTS/JPaint/assets/137844707/a081165c-743e-4ab8-b31d-9c8b42396dda)
