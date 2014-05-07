    public class Item  implements java.io.Serializable
   {
      private String name;
      private String desc;
      private int interactsWith;
   
       public Item()
      {
         name = null;
         desc = null;
         interactsWith = 0;
      }
      
       public Item(String n)
      {
         name = n;
         desc = null;
      }
   
       public Item(String n, String d, int i)
      {
         name = n;
         desc = d;
         interactsWith = i;
      }
      
       public String getItemName()
      {
         return name;
      }
      
       public String getItemDesc()
      {
         return desc;
      }
   	
       public int getInteractsWith()
      {
         return interactsWith;
      }
      
       public void setItemName(String n)
      {
         name = n;
      }
      
       public void setItemDesc(String d)
      {
         desc = d;
      }
      
       public void setInteractsWith(int i)
      {
         interactsWith = i;
      }
      
       public String toString()
      {
         return name;
      }
   }