/*
 * Class for nodes which will construct a singly linked list. The nodes are
 *		declared generically, meaning that the underlying type of the data
 *		must be declared.
 */
public class Node<T>
{
	private T element;
	private Node<T> nextNode;

	// ----------------------------------- CONSTRUCTORS -----------------------------------
	/*
     * Constructor. Creates a node with an element and a next node.
	 */
	public Node(T element, Node<T> next)
	{
		this.element = element;
		this.nextNode = next;
	}
	
	/*
     * Constructor. Creates a node with an element but no next node specified.
	 */
	@SuppressWarnings("unchecked")
	public Node(T element)
	{
		this(element, null);
	}
	
	/*
     * Constructor. Creates a node with a next node but no element specified.
	 */
	@SuppressWarnings("unchecked")
	public Node(Node<T> next)
	{
		this(null, next);
	}
	
	/*
     * Constructor. Creates an empty node without an element or next node specified.
	 */
	public Node()
	{
		this(null, null);
	}
	
	
	// --------------------------------- ACCESSOR METHODS ---------------------------------
	/*
     * Returns the data element contained within this node as the type of the generic
	 *		specified at declaration time.
     */
	public T getElement()
	{
		return this.element;
	}
	
	/*
     * Returns a reference to the next node.
     */
	public Node<T> getNext()
	{
		return this.nextNode;
	}
	
	
	// ---------------------------------  MUTATOR METHODS ---------------------------------
	/*
	 * Sets the data element contained within this node IF the data element has not
	 *		previously been set/is current set to null. Otherwise, this method does nothing.
	 */
	public void setElement(T newElement)
	{
		if(this.element == null)
			this.element = newElement;
	}
	
	/*
	 * Sets the next node of this node to the parameter
	 */
	public void setNext(Node<T> newNext)
	{
		this.nextNode = newNext;
	}
	
	
	// -----------------------------------  TESTER CODE -----------------------------------
	public static void main(String[] args)
	{
		Node<String> n1 = new Node<String>("Hello", null);
		System.out.println(n1.getElement());
		System.out.println(n1.getNext());
		System.out.println("-----------------------------");
		
		Node<String> n2 = new Node<String>("Hello");
		System.out.println(n2.getElement());
		System.out.println(n2.getNext());
		System.out.println("-----------------------------");
		
		Node<String> n3 = new Node<String>(n1);
		System.out.println(n3.getElement());
		System.out.println(n3.getNext());
		System.out.println("-----------------------------");
		
		Node<String> n4 = new Node<String>();
		System.out.println(n4.getElement());
		System.out.println(n4.getNext());
		System.out.println("-----------------------------");
		
		n4.setElement("Poopity pewpity pants");
		n4.setNext(n1);
		System.out.println(n4.getElement());
		System.out.println(n4.getNext());
		System.out.println("-----------------------------");
		
		n4.setElement("Something pleasant");
		n4.setNext(n2);
		System.out.println(n4.getElement());
		System.out.println(n4.getNext());
		System.out.println("-----------------------------");
		
		Node<String> head = new Node<String>("1", new Node<String>("2", new Node<String>("3")));
		System.out.println(head.getElement());
		System.out.println(head.getNext().getElement());
		System.out.println(head.getNext().getNext().getElement());
		System.out.println(head.getNext().getNext().getNext());
		System.out.println(head.getNext().getNext().getNext().getElement());
	}
}