public class List<T> implements MyCollectionInterface<T> {

   private Node firstNode;
   private int numberOfEntries; 
   
   public List() {
      initializeDataFields();
   } // End of List constructor.

//*****************************************************************************************

   public void initializeDataFields() {
      firstNode = null;
      numberOfEntries = 0;
   } // End of initializeDataFields.
   

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
            currentNode = currentNode.getNext();
         }
            currentNode.next = newNode;
            return true;
      }
   } // End of add.
   
//*****************************************************************************************
   
   public void addAtFirst(T data) {
      Node newNode = new Node(data);
      if (firstNode == null) {
         firstNode = newNode;
      }
      else {
         firstNode.next = newNode;
      }
   } // End of addAtFirst.

//*****************************************************************************************

   public boolean remove(T anEntry) {
      Node currentNode = firstNode;
      Node previousNode = firstNode;
      boolean matchFound = false;
      
      while (currentNode != null) {
         if (currentNode.getData().equals(anEntry)) {
            matchFound = true;
            break;
         }
         else {
            previousNode = currentNode;
            currentNode = currentNode.getNext();
         }
      }
      
      if (matchFound) {
         if(currentNode == firstNode) {
            firstNode = firstNode.getNext();
            return matchFound;
         }
         else {
            previousNode.next = currentNode.getNext();
            return matchFound;
         }
      }
      return matchFound;
   } // End of remove.
   
//*****************************************************************************************

   public void clear() {
      if(!isEmpty()) {
         System.out.println("The List is already empty.");
      }
      firstNode.next = null;
      firstNode = null;
   } // End of clear.

//*****************************************************************************************

   public int getCurrentSize() {
      int counter = 0;
      Node currentNode = firstNode;
      
      if (firstNode == null) {
         return counter;
      }
      if (firstNode.getNext() == null) {
         return 1;
      }
      
      while (currentNode != null) {
         counter++;
         currentNode = currentNode.getNext();
      }
      
      return counter;
   } // End of getCurrentSize.

//*****************************************************************************************

   public boolean isEmpty() {
      return getCurrentSize() == 0;      
   } // End of isEmpty.

//*****************************************************************************************

   public int getFrequencyOf(T anEntry) {
      int counter = 0;
      Node currentNode = firstNode;
      
      while(currentNode != null) {
         if(currentNode.getData().equals(anEntry)) {
            counter++;
         }
         currentNode = currentNode.getNext();
      }
      
      return counter;
   } // End of getFrequencyOf.
   
//*****************************************************************************************   

   public boolean contains (T data) {
      Node currentNode = firstNode;
      
       do {
         if (currentNode.getData().equals(data)) {
            return true;
         }
         else {
            currentNode = currentNode.getNext();
         }       
       } while (currentNode.getNext() != null);
       
       return false;   
   } // End of contains.

//*****************************************************************************************

   public Object[] toArray () {
   
      @SuppressWarnings("unchecked")
      int size = getCurrentSize();
      Object[] result = new Object[size];
      int index = 0;
      
      Node currentNode = firstNode;
      while (currentNode != null) {
         result[index] = currentNode.getData();
         currentNode = currentNode.getNext();
         index++;
      }
      
      return result;
   } // End of toArray.
   
//*****************************************************************************************
//*****************************************************************************************

   private class Node<T> {
      private T    data;
      private Node<T> next; // Reference to next node in the List.
   
      private Node(T dataPortion) {
         this(dataPortion, null);
      } // End of first Node constructor.
      
      private Node(T dataPortion, Node<T> nextNode) {
         data = dataPortion;
         next = nextNode;
      } // End of second Node constructor.   
      
//*****************************************************************************************
      
      private T getData() {
         return data;
      } // End of getData.
      
//*****************************************************************************************

      private void setData(T newData) {
         data = newData;
      } // End of setData.
      
//*****************************************************************************************

      private Node getNext() {
         return next;
      } // End of getNext.
      
//*****************************************************************************************

      private void setNext(Node<T> nextNode) {
         next = nextNode;
      } // End of setNext.
      
   } // End of Node class.

} // End of List class.