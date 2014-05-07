//
//
// Exit - represents an exit to a location
// 
// Last modification date : November 13, 1997
//
    public class Exit implements java.io.Serializable
   {
   // Numerical codes
      public static final int UNDEFINED = 0;
      public static final int NORTH = 1;
      public static final int SOUTH = 2;
      public static final int EAST  = 3;
      public static final int WEST  = 4;
      public static final int UP    = 5;
      public static final int DOWN  = 6;
      public static final int NORTHEAST = 7;
      public static final int NORTHWEST = 8;
      public static final int SOUTHEAST = 9;
      public static final int SOUTHWEST = 10;
      public static final int IN = 11;
      public static final int OUT = 12;
   
   // String codes	
      public static final String[] dirName = 
      { 
         "UNDEFINED",
         "NORTH",
         "SOUTH",
         "EAST",
         "WEST",
         "UP",
         "DOWN",
         "NORTHEAST",
         "NORTHWEST",
         "SOUTHEAST",
         "SOUTHWEST",
         "IN",
         "OUT"
         };
   
      public static final String[] shortDirName = 
      {
         "NULL",
         "N",
         "S",
         "E",
         "W",
         "U",
         "D",
         "NE",
         "NW",
         "SE",
         "SW",
         "I",
         "O"		
         };
   
   // Member variables
      private Location m_leadsTo = null;
      private String leadsTo_Title;
      private int m_direction;
   
   // Full name of direction eg SOUTHEAST
      private String m_directionName;
   
   // Shortened version of direction eg SE
      private String m_shortDirectionName;
   
   // Default constructor
       public Exit()
      {
         m_direction = Exit.UNDEFINED;
         m_leadsTo = null;
         m_directionName = dirName[UNDEFINED];
         m_shortDirectionName = shortDirName[UNDEFINED];
      }
   
   // Full constructor
       public Exit( int direction, Location leadsTo )
      {
         m_direction = direction;
      
      // Assign direction names
         if (direction <= dirName.length )
            m_directionName = dirName[m_direction];
         if (direction <= shortDirName.length )
            m_shortDirectionName = shortDirName[m_direction];
      
      // Assign location
         m_leadsTo = leadsTo;
      }
      
   	//other constructor
       public Exit( int direction, String title )
      {
         m_direction = direction;
         leadsTo_Title = title;
         m_leadsTo = null;
      
      // Assign direction names
         if (direction <= dirName.length )
            m_directionName = dirName[m_direction];
         if (direction <= shortDirName.length )
            m_shortDirectionName = shortDirName[m_direction];
      }
   
   // toString method
       public String toString()
      {
         return m_directionName;
      }
   
   // Assigns direction name
       public void setDirectionName( String dirName )
      {
         m_directionName = dirName;
      }
   
   // Returns direction name
       public String getDirectionName()
      {
         return m_directionName;
      }
   
   // Assigns short direction name
       public void setShortDirectionName ( String shortName )
      {
         m_shortDirectionName = shortName;
      }
   
   // Returns short direction name
       public String getShortDirectionName ()
      {
         return m_shortDirectionName;
      }
   
   // Assigns location
       public void setLeadsTo ( Location leadsTo )
      {
         m_leadsTo = leadsTo;
      }
      
       public void setLeadsTo_Title(String title)
      {
         leadsTo_Title = title;
      }
      
       public String getLeadsTo_Title()
      {
         return leadsTo_Title;
      }
   
   // Returns location
       public Location getLeadsTo (  )
      {
         return m_leadsTo;
      }
      
   	//Sets m_direction to what is given in the string
   	//returns m_direction
       public int assignDirection(String dir)
      {
         if(dir.compareTo("UNDEFINED")==0 || dir.compareTo("NULL")==0)
            m_direction = UNDEFINED;
            
         if(dir.compareTo("NORTH")==0 || dir.compareTo("N")==0)
            m_direction = NORTH;
            
         if(dir.compareTo("SOUTH")==0 || dir.compareTo("S")==0)
            m_direction = SOUTH;
            
         if(dir.compareTo("EAST")==0 || dir.compareTo("E")==0)
            m_direction = EAST;
        
         if(dir.compareTo("WEST")==0 || dir.compareTo("W")==0)
            m_direction = WEST;
            
         if(dir.compareTo("UP")==0 || dir.compareTo("U")==0)
            m_direction = UP; 
            
         if(dir.compareTo("DOWN")==0 || dir.compareTo("D")==0)
            m_direction = DOWN;
            
         if(dir.compareTo("NORTHEAST")==0 || dir.compareTo("NE")==0)
            m_direction = NORTHEAST;
            
         if(dir.compareTo("NORTHWEST")==0 || dir.compareTo("NW")==0)
            m_direction = NORTH;
            
         if(dir.compareTo("SOUTHEAST")==0 || dir.compareTo("SE")==0)
            m_direction = NORTH;
            
         if(dir.compareTo("SOUTHWEST")==0 || dir.compareTo("SW")==0)
            m_direction = SOUTHWEST;
            
         if(dir.compareTo("IN")==0 || dir.compareTo("I")==0)
            m_direction = IN;
            
         if(dir.compareTo("OUT")==0 || dir.compareTo("0")==0)
            m_direction = OUT;
         
         return m_direction;
      }
   
   }

