public class List<T> implements MyCollectionInterface<T> {

   public Node firstNode; // 
   
   public List() {
      firstNode = null;
   } // End of List constructor.

//*****************************************************************************************

   public boolean isEmpty() {
      return(firstNode == null);
   }
   
//*****************************************************************************************
   
   public void add(T data) {
      Node newNode = new Node(data);
      Node currentNode = firstNode;
      if (firstNode == null) {
         addAtFirst(data);
      }
      else {
         while(currentNode.next != null) {
            currentNode = currentNode.next;
         }
         currentNode.next = newNode;
      }
   }
   
//*****************************************************************************************
   
   public void addAtFirst(T data) {
      Node newNode = new Node(data);
      if (firstNode == null) {
         firstNode = newNode;
      }
      else {
         firstNode.next = newNode;
      }
   }

//*****************************************************************************************



   public void remove(T data) {
      Node currentNode = firstNode;
      Node previousNode = firstNode;
      
      while(!currentNode.getData().equals(data)) {
         if(currentNode.next == null) {
            break;
         }
         else {
            previousNode = currentNode;
            currentNode = currentNode.next;
         }
      }
      
      if(currentNode == firstNode) {
         firstNode = firstNode.next;
      }
      else {
         previousNode.next = currentNode.next;
      }
   }
   
//*****************************************************************************************

   public boolean contains (T data) {
      Node currentNode = firstNode;
      
       do {
         if (currentNode.getData().equals(data)) {
            return true;
         }
         else {
            currentNode = currentNode.next;
         }       
       } while (currentNode.next != null);
       
       return false;   
   }

//*****************************************************************************************

   public void toArray () {
      // STUB STUB STUB
   }
//*****************************************************************************************
//*****************************************************************************************

   private class Node<T> {
      private T    data;
      private Node<T> next; // Reference to next node in the List.
   
      private Node(T dataPortion) {
         this(dataPortion, null);
      } // End of constructor
      private Node(T dataPortion, Node<T> nextNode) {
         data = dataPortion;
         next = nextNode;
      }   
      
//*****************************************************************************************
      private T getData() {
         return data;
      }
   } // End of Node class.

} // End of List class.