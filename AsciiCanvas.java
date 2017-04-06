//Gavin Franklin
//AsciiAnimation

//May be rundundent import but protection is in place so we're good
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

//Begins the class definition
public class AsciiCanvas extends JTextArea{
   
   private node head;//This will never change to keep track of the first node
   private node a;
   private node currentnode;//This will change constantly as the frames shift
   private JTextArea jtext;//This is the actual fram and the data in the fram will change from time to time
   String data;//Holds a blank value

   public AsciiCanvas(){//Consturctor
      data = "";//blank
      head = new node(null,null,data);//The very first node 
      currentnode = head;
      a = head;
      jtext = new JTextArea();//Sets deminsions of the text box area
      this.setText(data);
   }//End Constructor
   //save meathod to save all the odes
   public void save(){
      try{//Exception handling for io exceptions
         FileOutputStream fileout = new FileOutputStream("/tmp/animation.ser");
         ObjectOutputStream out = new ObjectOutputStream(fileout);
         out.writeObject(head);//This will go through every node because java
         out.close();
         fileout.close();
      }catch(IOException i){
         i.printStackTrace();//Just prints the error
      }
    }//End Method
   //Load meathod
   public void load(){
      try{//Error handling
         FileInputStream filein = new FileInputStream("/tmp/animation.ser");
         ObjectInputStream in = new ObjectInputStream(filein);

         head = (node) in.readObject();
         in.close();
         filein.close();
      }catch(IOException i){//IO exeplions
         i.printStackTrace();
         return;
      }catch(ClassNotFoundException c){
         System.out.println("no animation found");//Catches the possibility that there is no file
         c.printStackTrace();
         return;
      }
      currentnode = head;
      this.setText(currentnode.getInfo());//This is needed because whenever the fframes(nodes) are reloaded the animation needs to start at the begining
   }//End Method
   //Previou Frame meathos
   public void prevFrame(){
      if(currentnode.getPrev() == null){//This is going to check to make sure the user is not on the head if they are the the program does nothing
      //If they'r enot on the head
      }else{
        currentnode.setInfo(this.getText());//Current node gets the info in the box
        currentnode = currentnode.getPrev();//Current node switches to prev node
        this.setText(currentnode.getInfo());//Info in the box becomes what is held in prev node
      }
   }//End Meathod
  //nextFrame meathod
   public void nextFrame(){
      currentnode.setInfo(this.getText());//Sets the current nodes info to whatever is in the box
      if(currentnode.getNext() == null){//Checks to see if th enode is the tail if so a new node needs to be created
         a = new node(currentnode, null, data);//New node is created with blank info and a pointer to the prevoes tail
         currentnode.setNext(a);
         currentnode = a;
      }else{//This is for when the previous node was either the head or any other node that's not the tail
       currentnode = currentnode.getNext();//Change node
      }
      this.setText(currentnode.getInfo());//Change info in the box
   }//End Meathod
   //Begin Animation meathod
   public void anim(){
      if (currentnode.getNext()== null){//If  at the tail
         currentnode = head;//Go to the head node
      }else{//if not at the tail
         currentnode = currentnode.getNext();//Go to the next node
      }
      this.setText(currentnode.getInfo());//Display what's in that node   
   }//End animation meathod
}//End class








