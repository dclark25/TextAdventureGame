TextAdventureGame
=================

READ ME FILE

So this is still a work in progress, but basically the base of this code was given via 
a tutorial online. It contained the basic components of a text adventure game, 
specifically the location object, exit object, GameWorld object, WidthLimitedOutput Stream,
CreateGameWorld and GameDemo. These files were edited to incorporate items and other features.
For instance, I've added items that can interact with each other, although to an extent.

I also added a method to read in a text file so that instead of having to 
manually initialize every location, exit and item, all that needs to be done is a
quick change of the file info.txt. The text is in a specific format to make parsing the
text easier. Items are still a work in progress

==============================================================================================

Game play:

Just write and enter the name of the exit or item you wish to use.
Each exit also has a shorthand name for its direction, so instead of 
typing "north" you can just put "n".

If you want to pick up an item just type in the name of the item. Also, if you want to
use an item in your inventory on another item, type the name of the item you wish to use.
You can check your inventory by entering "Inventory"

To quit, type in "quit".

==============================================================================================

The reason Java was chosen was because of many reasons. It is object oriented and I wanted to
strengthen my Java skills, especially since it has been a while since I have used Java,
so this has been a great refresher. I also plan on working on this project out of class and 
eventually include some GUI as well.
