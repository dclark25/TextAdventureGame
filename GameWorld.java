   import java.util.*;
   import java.io.*;
//
//
// GameWorld
//
// Last modification date : December 20, 1997
//
    public class GameWorld implements Serializable
   {
   // List of Location objects
      private Vector locations;
   
   // List of Exit objects
      private Vector exits;
   	
   // List of Item objects 
      private Vector items;
   
   // The current location of the player
      private Location currentLocation;
   
   // Character width for descriptions
      private int charWidth;
   
   // Output stream for gaming system
      transient private WidthLimitedOutputStream output;
   
   // GameWorld constructor
       public GameWorld()
      {
      // Instantiate vector lists for location/exits
         locations = new Vector();
         exits = new Vector();
         items = new Vector();
      // The default location of a player isn't known
         currentLocation = null;
      
      // By default, use standard output
         setOutputStream (System.out, 80);
      }
   
   // GameWorld constructor
       public GameWorld(int characterWidth )
      {
      // Call default constructor
         this();
      
         charWidth = characterWidth;		
      }
   
   /** Returns the current location of the player */
       public Location getCurrentLocation()
      {
         return currentLocation;
      }
   
   /** Assigns a new location to the current location of the player */
       public void setCurrentLocation(Location newLocation)
      {
         currentLocation = newLocation;
      }
   
   /** Adds a new exit to the gaming system */
       public void addExit( Exit exit )
      {
      // Check if exit vector already contains exit 
         if (! exits.contains ( exit ) )
         // Exit doesn't exist, and must be added
            exits.addElement ( exit);
      }
   
   /** Adds a new location to the gaming system */
       public void addLocation( Location location )
      {
      // Check if location vector already contains location 
         if (! locations.contains ( location ) )
         // Location doesn't exist, and must be added
            locations.addElement ( location );
      }
      
   	//adds item to the list of items
       public void addItem( Item item )
      { 	
         if (! items.contains ( item ) )
            items.addElement ( item );
      }
      
       public Vector getLocations ()
      {
         return (Vector) locations.clone();
      }
      
       public Vector getItems()
      {
         return (Vector) items.clone();
      }
   
   /** Sets the output stream for the gaming systewm */
       public void setOutputStream(OutputStream out, int width)
      {
         output = new WidthLimitedOutputStream(out, width) ;
      }
      
   	//displays the items stored in the gameworld object
       public void showInventory()
      {
         output.println("Inventory");
         for (Enumeration e = this.getItems().elements(); e.hasMoreElements();)
         {
            Item an_item = (Item) e.nextElement();
            output.println (an_item.toString());
         }	
      }
   
   	//finds the item in your inventory with matching name anItem_name
       public Item findItem(String an_itemName)
      {
         String itemName;
         Item itemTemp;
         an_itemName = an_itemName.toUpperCase();
      	
         for(int i=0; i<items.size(); i++)
         {
            itemTemp = (Item) items.get(i);
            itemName = itemTemp.getItemName().toUpperCase();
            if(itemName.compareTo(an_itemName)==0)
               return itemTemp;
         }
         return itemTemp = new Item();
      }
      
   	//Returns true if matching item is found
       public boolean itemMatch(String an_itemName)
      {
         String itemName;
         Item itemTemp;
         an_itemName = an_itemName.toUpperCase();
      	
         for(int i=0; i<items.size(); i++)
         {
            itemTemp = (Item) items.get(i);
            itemName = itemTemp.getItemName().toUpperCase();
            if(itemName.compareTo(an_itemName)==0)
               return true;
         }
         return false;
      }
   
      //Removes the given item from the list of items in the gameworld
       public void removeItem ( Item item )
      {
         if (items.contains (item))
         {
            items.removeElement (item);
         }
      }
   
   
   /** Shows the current game location */
       public void showLocation()
      {
      // Show title
         output.println ( currentLocation.getTitle() );
      
      // Show description
         output.println ( currentLocation.getDescription() );
      
         output.println();
         
         output.println("Items: ");
      	
         for (Enumeration e = currentLocation.getItems().elements(); e.hasMoreElements();)
         {
            Item an_item = (Item) e.nextElement();
            output.println (an_item.toString());
         }	
      
         output.println();
      	
      // Show available exits		
         output.println ( "Available exits:" );
      
      // Traverse elements of vector
         for (Enumeration e = currentLocation.getExits().elements(); e.hasMoreElements();)
         {
         // Get next exit
            Exit an_exit = (Exit) e.nextElement();
         
         // Print exit to our output stream
            output.println (an_exit.toString());
         }	
      }
   
   }

