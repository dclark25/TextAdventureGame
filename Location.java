   import java.util.Vector;
   import java.util.Enumeration;
//
//
// Location - represents a gaming location
//
// Last modification date : November 13, 1997
//
    public class Location implements java.io.Serializable
   {
   
   // Member variables
      private String m_roomTitle;
      private String m_roomDescription;
      private Vector m_vecExits;
      private Vector m_vecItems;
   
   // Blank constructor
       public Location()
      {
      // Blank title + description
         m_roomTitle = new String ();
         m_roomDescription = new String();
         m_vecExits = new Vector();
         m_vecItems = new Vector();
      }
   
   // Partial constructor
       public Location( String title )
      {
      // Assign title
         m_roomTitle = title;
      
      // Blank description
         m_roomDescription = new String();
      
      // Blank exits
         m_vecExits = new Vector();
         
         m_vecItems = new Vector();
      }
   
   // Full constructor
       public Location( String title, String description )
      {
      // Assign title + description
         m_roomTitle = title;
         m_roomDescription = description;
      
      // Blank exits
         m_vecExits = new Vector();
         
         m_vecItems = new Vector();
      }
   
   // toString method
       public String toString()
      {
         return m_roomTitle;
      }
   
   // Adds an exit to this location
       public void addExit ( Exit exit )
      {
         m_vecExits.addElement (exit);
      }
   
   // Removes an exit from this location
       public void removeExit ( Exit exit )
      {
         if (m_vecExits.contains (exit))
         {
            m_vecExits.removeElement (exit);
         }
      }
      
   	 // Adds an item to this location
       public void addItem ( Item item )
      {
         m_vecItems.addElement (item);
      }
   
   // Removes an item from this location
       public void removeItem ( Item item )
      {
         if (m_vecItems.contains (item))
         {
            m_vecItems.removeElement (item);
         }
      }
   
   // Returns a vector of exits
       public Vector getExits ()
      {
      // Return a clone, as we don't want an external
      // object to modify our original vector
         return (Vector) m_vecExits.clone();
      }
   
   // Returns location title
       public String getTitle()
      {
         return m_roomTitle;
      }
   
   // Assigns location title
       public void setTitle( String roomTitle )
      {
         m_roomTitle = roomTitle;
      }
   
   // Returns location description
       public String getDescription()
      {
         return m_roomDescription;
      }
   
   // Assigns location description
       public void setDescription( String roomDescription )
      {
         m_roomDescription = roomDescription;
      }
   	
       public Vector getItems()
      {
         return (Vector) m_vecItems.clone();
      }
      
   	//finds the item in your inventory with matching name anItem_name and returns it
       public Item findItem(String an_itemName)
      {
         String itemName;
         Item itemTemp;
         an_itemName = an_itemName.toUpperCase();
      	
         for(int i=0; i<m_vecItems.size(); i++)
         {
            itemTemp = (Item) m_vecItems.get(i);
            itemName = itemTemp.getItemName().toUpperCase();
            if(itemName.compareTo(an_itemName)==0)
               return itemTemp;
         }
         return itemTemp = new Item();
      }
      
   	//Returns the interaction number of the matching item
       public Item findItem(int interactNum)
      {
         Item itemTemp;
      	
         for(int i=0; i<m_vecItems.size(); i++)
         {
            itemTemp = (Item) m_vecItems.get(i);
            
            if(itemTemp.getInteractsWith() == interactNum)
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
      	
         for(int i=0; i<m_vecItems.size(); i++)
         {
            itemTemp = (Item) m_vecItems.get(i);
            itemName = itemTemp.getItemName().toUpperCase();
            if(itemName.compareTo(an_itemName)==0)
               return true;
         }
         return false;
      }
   
   
     
   }

