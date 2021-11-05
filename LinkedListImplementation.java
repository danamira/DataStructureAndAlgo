class LinkedListImplementation {
	public static void main(String[] args) {

		System.out.println("Alright. These are some of my friends:");

		// Implement a list with an initial value for the first node.
		LinkedList x=new LinkedList("Armin");

		/* Add some random names to check whether the list functions properly or not.*/

		x.append("Kian");		
		x.append("Arman");		
		x.prepend("Babak");
		x.append("Mamad");
		x.push("Erfan",2);
		x.push("Mehdi",2);
		x.pop(2);
		x=x.reverse();

		/// Babak-->Dana-->Erfan-->Kian-->Arman-->Mamad

		System.out.println("- "+x.getNth(0));
		System.out.println("- "+x.getNth(1));
		System.out.println("- "+x.getNth(2));
		System.out.println("- "+x.getNth(3));
		System.out.println("- "+x.getNth(4));
		System.out.println("- "+x.getNth(5));
		System.out.println("");
		System.out.println("I have "+x.size()+" friends.");

	}
}

class LinkedList {
	protected ListNode start= new ListNode();

	// Adds a new node to the beginning of the chain.
	public void prepend(String value) {
		ListNode j= new ListNode();
		j.content=value;
		j.next=this.start;
		this.start=j;
	}

	public LinkedList(String value) {
		this.start.content=value;
	}

	public String getFirst() {
		return this.start.content;
	}

	private ListNode getLastNode() {
		ListNode current= this.start;
		// The loop below follows the links between nodes to reach the final node(which doesn't refer to any other node as it's next neighbour).
		while(true){
			if(current.next==null) {
				break;
			}
			current=current.next;
		}
		return current;
	}

	public void pop(Integer index) {
		ListNode x=this.getNthNode(index-1);
		x.next=x.next.next;
	}

	public Integer size() {
		Integer count=0;
		ListNode current= this.start;
		while(true){
			count=count+1;
			if(current.next==null) {
				break;
			}
			current=current.next;
		}
		return count;
	}

	// Returns the n-th elemtns of chain as a ListNode object.
	private ListNode getNthNode(Integer n) {
		Integer index=0;
		ListNode current= this.start;
		while(index<n){
			if(current.next==null) {
				return current;
			}
			current=current.next;
			index=index+1;
		}
		return current;
	}


	// Returns the value stored in the last node of the chain.
	public String getLast() {
		return this.getLastNode().content;
	}

	// Returns the value stored in the n-th element of list.
	public String getNth(Integer index){
		return this.getNthNode(index).content;
	}

	// Adds a note to the end of the chain. 
	public void append(String value) {
		ListNode j= new ListNode();
		j.content=value;
		this.getLastNode().next=j;
	}

	public void push(String value,Integer location) {
		ListNode j = new ListNode();
		j.content=value;
		j.next=this.getNthNode(location);
		this.getNthNode(location-1).next=j;
	}
	public LinkedList reverse() {
		LinkedList result = new LinkedList(this.start.content);
		ListNode current= this.start.next;
		while(true){
			result.prepend(current.content);
			if(current.next==null) {
				break;
			}
			current=current.next;
		}
		return result;
	}

}

class ListNode {

	/*Represents single nodes in the chain.*/

	protected String content;
	protected ListNode next;
}