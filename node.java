import java.io.*;
//Begin Class Definition
public class node implements java.io.Serializable{//These nodes need to be serializable so the user can save their animation
   public node prev;//pointer to the prevous node
   public node next;//pointer to the next node
   private String info;//The info the node holds

   public node(){//Basic constuctor
   }
   //Overloaded construcor that will always be used
   public node(node prev, node next, String info){
      this.info = info;//Sets the info
      this.next = next;//Sets the pointer to the next node
      this.prev = prev;//Sets the pointer to the pervous node
   }//End Overloaded constructor
   //Setters
   public void setNext(node next){
      this.next = next;
   }
 
   public void setPrev(node prev){
      this.prev = prev;
   }
   
   public void setInfo(String info){
      this.info = info;//This is really the only setter that is useful because we will be changing the nodes info but rarely the position
   }
   //Begin getters
   public node getNext(){
      return this.next;//These two getter are useful for moving along the node linked list as the user moves boxes
   }
   
   public node getPrev(){
      return this.prev;
   }
   //The get info is useful for displaying text within the box from the node
   public String getInfo(){
      return this.info;
   }
}//End node
