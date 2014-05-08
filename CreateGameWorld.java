   import java.io.*;
   import java.util.Vector;
   import java.util.Iterator;
   import java.io.Serializable;
//
//
// CreateGameWorld
//
//
    public final class CreateGameWorld 
   {
      public static String filename = "gameworld.dat";
      
   	//reads in info for all rooms from info.txt
   	//parses text to create needed objects, text must be in certain format
   	//This method makes intitializing objects automated
       public static void readInfo(GameWorld game) throws IOException
      {
         int numLines = filesScanner.getFileSize("info.txt");
         String[] lines = new String[numLines];
         filesScanner.readFile(lines, "info.txt");
         String words;
         Location locTemp = new Location();
         Vector<Location> locList = new Vector<Location>();
         Vector<Exit> exitList = new Vector<Exit>();
         Item itemTemp = new Item();
         Exit exitTemp = new Exit();
      	
      	//traverses through all lines in info.txt
         for(int i=0; i<numLines; i++)
         {
            while(lines[i].compareTo("%%")!=0)
            {
               words = lines[i];
               String delim = "[:]", delim2 = "[,]", delim3 = "[|]";
               String[] token = words.split(delim);
            	
            	//Find and set the title of the location
               if(token[0].compareTo("Title")==0)
                  locTemp.setTitle(token[1]);
               
            	//Find and set the description of the location
               if(token[0].compareTo("Desc")==0)
                  locTemp.setDescription(token[1]);
            	
            	//Finds and sets Items in the location
               if(token[0].compareTo("Items")==0)
               {
                  String[] itemList = token[1].split(delim3);
                  for(int j=0; j<itemList.length; j++)
                  {
                     String[] itemInfo = itemList[j].split(delim2);
                     itemTemp.setItemName(itemInfo[0]);
                     itemTemp.setItemDesc(itemInfo[1]);
                     Integer x = Integer.parseInt(itemInfo[2]);
                     itemTemp.setInteractsWith(x);
                     locTemp.addItem(itemTemp);
                     itemTemp = new Item();
                  }
               }      	
            
            	//Finds and sets exits for the location
               if(token[0].compareTo("Exits")==0)
               {
                  String[] tempList = token[1].split(delim3);
                  for(int j=0; j<tempList.length; j++)//loops for # of exits in tempList
                  {
                     String[] exitInfo = tempList[j].split(delim2);
                     int dir = exitTemp.assignDirection(exitInfo[0]);
                     exitTemp = new Exit(dir, exitInfo[1]);
                     locTemp.addExit(exitTemp);
                     exitList.addElement(exitTemp);
                  }
                  exitTemp = new Exit();
               }
               i++;
            }
            
            //adds to the list of locations
            if(lines[i].compareTo("%%")==0)
               locList.addElement(locTemp);
               
         	//reset location values	
            locTemp = new Location();	
         }
         
      	//update the location each exit leads to
         String name, locTitle;
         for(int i=0; i<exitList.size(); i++)//traverse through exits
         {
            exitTemp = (Exit) exitList.elementAt(i);
            name = exitTemp.getLeadsTo_Title();
            for(int j=0; j<locList.size(); j++)//travers through locations
            {
               locTemp = (Location) locList.elementAt(j);
               locTitle = locTemp.getTitle();
               if(name.compareTo(locTitle)==0)//compares exit to location title
               {
                  exitTemp.setLeadsTo(locTemp);
                  game.addExit(exitTemp);
               }
               game.addLocation(locTemp);
            }
         }
      }
      
       public static void main(String args[]) throws IOException
      {
      // GameWorld
         GameWorld game;
      
      // Create a new instance of a GameWorld
         game = new GameWorld();
         
      /* Create room objects
         Location l1 = new Location ("Bottom of the well", "You have reached the bottom of a deep and rather smelly well. Less than a foot of water remains, and it looks undrinkable.");
         Location l2 = new Location ("Courtyard", "At the centre of the courtyard is an old stone well. A strong and sturdy rope is attached to the well, and descends into the darkness. The only other items of interest is the farmhouse to the north, and a path to the east.");
         Location l3 = new Location ("Farmhouse entrance", "The door to the farmhouse hangs crooked, and is slightly ajar. Obviously no-one has lived here for some time, and you can only guess at what lies within.");
         Location l4 = new Location ("Blood-stained room", "Dried blood stains can be seen on the walls and stone floor of the farmhouse. Whatever massacre occured here long ago, you can only guess. With the abscence of bodies, however, you may never know.");
         Location l5 = new Location ("Long windy path", "You are standing on a long, windy path, leading from the mountains in the far east, to a small farm that lies to the west.");
         Location l6 = new Location ("Base of the mountain", "At the base of the mountain is a path that leads westward beyond a large boulder. Climbing such a mountain would be difficult - if not impossible.");
         Location l7 = new Location ("Top of the mountain", "From this vantage point, you can see all that lies on the plains below. Large boulders dot the landscape, and just within view to the west you make out some sort of a building - though its details are too hard to make out from this distance.");
      
      // Create exit objects
         Exit e1 = new Exit ( Exit.UP, l2 );
         Exit e2 = new Exit ( Exit.DOWN, l1 );
         Exit e3 = new Exit ( Exit.NORTH, l3 );
         Exit e4 = new Exit ( Exit.SOUTH, l2 );
         Exit e5 = new Exit ( Exit.NORTH, l4 );
         Exit e6 = new Exit ( Exit.SOUTH, l3 );
         Exit e7 = new Exit ( Exit.EAST, l5 );
         Exit e8 = new Exit ( Exit.WEST, l2 );
         Exit e9 = new Exit ( Exit.EAST, l6 );
         Exit e10 = new Exit ( Exit.WEST, l5 );
         Exit e11 = new Exit ( Exit.UP, l7 );
         Exit e12 = new Exit ( Exit.DOWN, l6 );
      
         l1.addExit ( e1 );
         l2.addExit ( e2 );
         l2.addExit ( e3 );
         l2.addExit ( e7 );
         l3.addExit ( e4 );
         l3.addExit ( e5 );
         l4.addExit ( e6 );
         l5.addExit ( e8 );
         l5.addExit ( e9 );
         l6.addExit ( e10 );
         l6.addExit ( e11 );
         l7.addExit ( e12 );
      
      // Add locations/exits to our game lists
         game.addLocation (l1);
         game.addLocation (l2);
         game.addLocation (l3);
         game.addLocation (l4);
      
         game.addExit( e1 );
         game.addExit( e2 );
         game.addExit( e3 );
         game.addExit( e4 );
         game.addExit( e5 );
         game.addExit( e6 );
      
      // Set current location
         game.setCurrentLocation ( l2 );*/
      	
         readInfo(game);
         Location currLoc = (Location) game.getLocations().firstElement();
         game.setCurrentLocation(currLoc);
      
         try
         {
         // Create a file to write game system
            FileOutputStream out = new FileOutputStream (filename);
         
         // Create an object output stream, linked to out
            ObjectOutputStream objectOut = new ObjectOutputStream (out);
         
         // Write game system to object store
            objectOut.writeObject (game);
         
         // Close object output stream
            objectOut.close();
         
            System.out.println ("Game data created as " + filename );
         }
             catch (Exception e)
            {
               System.err.println ("Unable to create game data");
            }
      
      
      
      }
   
   }

