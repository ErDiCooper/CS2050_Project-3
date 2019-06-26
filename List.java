public class List<T> implements MyCollectionInterface<T> {

   public Node firstNode; 
   
   public List() {
      firstNode = null;
   } // End of List constructor.

//*****************************************************************************************
   
   public boolean add(T newItem) {
      Node newNode = new Node(newItem);
      Node currentNode = firstNode;
      if (firstNode == null) {
         addAtFirst(newItem);
         return true;
      }
      else {
         while (currentNode.next != null) {
            currentNode = currentNode.next;
         }
            currentNode.next = newNode;
            return true;
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

   public boolean remove(T anEntry) {
      Node currentNode = firstNode;
      Node previousNode = firstNode;
      boolean matchFound = false;
      
      while (currentNode.next != null) {
         if (currentNode.getData().equals(anEntry)) {
            matchFound = true;
            break;
         }
         else {
            previousNode = currentNode;
            currentNode = currentNode.next;
         }
      }
      
      if (matchFound) {
         if(currentNode == firstNode) {
            firstNode = firstNode.next;
            return matchFound;
         }
         else {
            previousNode.next = currentNode.next;
            return matchFound;
         }
      }
      return matchFound;
   }
   
//*****************************************************************************************

   public void clear() {
      if(!isEmpty()) {
         System.out.println("The List is already empty.");
      }
      firstNode.next = null;
      firstNode = null;
   }

//*****************************************************************************************

   public int getCurrentSize() {
      int counter = 0;
      Node currentNode = firstNode;
      
      if (firstNode == null) {
         return counter;
      }
      if (firstNode.next == null) {
         return 1;
      }
      
      while (currentNode.next != null) {
         counter++;
         currentNode = currentNode.next;
      }
      
      return counter;
   }

//*****************************************************************************************

   public boolean isEmpty() {
      return getCurrentSize() == 0;      
   }

//*****************************************************************************************

   public int getFrequencyOf(T anEntry) {
      int counter = 0;
      Node currentNode = firstNode;
      
      while(currentNode.next != null) {
         if(currentNode.getData().equals(anEntry)) {
            counter++;
         }
         currentNode = currentNode.next;
      }
      
      return counter;
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

   public Object[] toArray () {
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