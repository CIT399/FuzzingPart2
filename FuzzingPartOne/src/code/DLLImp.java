package code;
/**  
* @author Eric Germiller
*
*/

/**  Class Double Linked List Implementation  */
public class DLLImp {
	/** Class Node  */
	class Node{
		String data;
		Node next;
		Node previous;
		/**
		 * Constructor for the node class
		 * 
		 */
		public Node(){
			this.data = null;
			next = null;
			previous = null;
		}
		/**
		 * Constructor for the node class
		 * 
		 * @param data	string data in node
		 */
		public Node(String data){
			this.data = data;
			next = null;
			previous = null;
		}
		/**
		 * Constructor for the node class
		 * 
		 * @param d		string data in node
		 * @param n 	next node
		 * @param p 	previous node
		 */
		public Node(String d, Node n, Node p){
		    data = d;
		    next = n;
		    previous = p;
		}
		/**
		 * Method to set link of next node
		 * 
		 * @param n 	next node
		 */
		public void setLinkNext(Node n){
			next = n;
		}
		/**
		 * Method to set link of previous node
		 * 
		 * @param p 	previous node
		 */
		public void setLinkPrev(Node p){
			previous = p;
		}
		/**
		 * Method to get link of next node
		 * 
		 * @param n 	next node
		 * 
		 * @return next		next node
		 */
		public Node getLinkNext(){
			return next;
		}
		/**
		 * Method to get link of previous node
		 * 
		 * @param p 	previous node
		 * 
		 * @return previous		previous node
		 */
		public Node getLinkPrev(){
		    return previous;
		}
		/**
		 * Method to set data in node
		 * 
		 * @param d 	string data to be set
		 */
		public void setData(String d){
		    data = d;
		}
		/**
		 * Method to set link of next node
		 * 
		 * @return data		data in node
		 */
		public String getData(){
		   return data;
		}
	}
	
	int size = 0;
	Node head = null;
	Node tail = null;
	
	/**
	 * Method to add new node to start of list
	 * 
	 * @param data 		string data to be set
	 * 
	 * @return Node		return node added
	 */
	public Node addAtStart(String data){
		Node n = new Node(data);
        if(size==0){
            head = n;
            tail = n;
        }else{
            n.next = head;
            head.previous = n;
            head = n;
        }
        size++;
        return n;

	}
	/**
	 * Method to add new node to end of list
	 * 
	 * @param data		string data to be set
	 * 
	 * @return Node		return node added
	 */
	public Node addAtEnd(String data){
		Node n = new Node(data);
        if(size==0){
            head = n;
            tail = n;
        }else{
            tail.next = n;
            n.previous = tail;
            tail =n;
        }
        size++;
        return n;
	}
	/**
	 * Method to insert a new node at a position
	 * 
	 * @param val		string data to be set
	 * @param pos		position in list (1 to listSize)
	 */
	public void insert(String val , int pos)
    {
        Node nptr = new Node(val, null, null);    
        if (pos == 1)
        {
            addAtStart(val);
            return;
        }            
        Node ptr = head;
        for (int i = 2; i <= size; i++)
        {
            if (i == pos)
            {
                Node tmp = ptr.getLinkNext();
                ptr.setLinkNext(nptr);
                nptr.setLinkPrev(ptr);
                nptr.setLinkNext(tmp);
                tmp.setLinkPrev(nptr);
            }
            ptr = ptr.getLinkNext();            
        }
        size++ ;
    }
	/**
	 * Method to delete an existing node at a position
	 * 
	 * @param pos		position in list (1 to listSize)
	 */
    public void delete(int pos)
    {        
        if (pos == 1) 
        {
            if (size == 1)
            {
                head = null;
                tail = null;
                size = 0;
                return; 
            }
            head = head.getLinkNext();
            head.setLinkPrev(null);
            size--; 
            return ;
        }
        if (pos == size)
        {
            tail = tail.getLinkPrev();
            tail.setLinkNext(null);
            size-- ;
        }
        Node ptr = head.getLinkNext();
        for (int i = 2; i <= size; i++)
        {
            if (i == pos)
            {
                Node p = ptr.getLinkPrev();
                Node n = ptr.getLinkNext();
 
                p.setLinkNext(n);
                n.setLinkPrev(p);
                size-- ;
                return;
            }
            ptr = ptr.getLinkNext();
        }        
    }    
    /**
	 * Method to replace an existing node's data
	 * 
	 * @param val		string data to be set
	 * @param index		position in list (1 to listSize)
	 * 
	 */
	public void replace(String data, int index){
		if(index<=size){
			Node n = head;
	        while(index-1!=0){
	            n=n.next;
	            index--;
	        }
	        n.setData(data);
        }else{
        	System.out.println("Error: Index Out of Bounds");
        }
         
	}
	/**
	 * Method to get Node at position
	 * 
	 * @param index		position in list (1 to listSize)
	 * 
	 * @return n 	Node at position "index"
	 */
	public Node get(int index){
		 if(index>size){
	            return null;
	        }
	        Node n = head;
	        while(index-1!=0){
	            n=n.next;
	            index--;
	        }
	        return n;
	}
	/**
	 * Method to get data element at position
	 * 
	 * @param index		position in list (1 to listSize)
	 * 
	 * @return n.data 	Node data at position "index"
	 */
	public String elementAt(int index){
        if(index>size){
            return null;
        }
        Node n = head;
        while(index-1!=0){
            n=n.next;
            index--;
        }
        return n.data;
    }
	/**
	 * Method to print list
	 */
	public void printList(){
		Node temp = head;

        while(temp!=null){
            System.out.print(" " + temp.data);
            temp = temp.next;
        }
        System.out.println();
	}
	/**
	 * Method to get size of list
	 * 
	 * @return size 	size of list
	 */
	public int getSize(){
        return size;
    }

}
