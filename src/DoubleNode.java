/*
 * Class for nodes which will construct a doubly linked list. The nodes are
 *		declared generically, meaning that the underlying type of the data
 *		must be declared.
 */
public class DoubleNode<T> extends Node<T>
{
	private DoubleNode<T> prevNode;

	// ----------------------------------- CONSTRUCTORS -----------------------------------
	/*
     * Constructor. Creates a node with an element, a previous doubly-linked node, and
	 *		a next doubly-linked node.
	 */
	public DoubleNode(T element, DoubleNode<T> previous, DoubleNode<T> next)
	{
		super(element, next);
		this.prevNode = previous;
	}
	/*
     * Constructor. Creates a node with an element and a next doubly-linked node but
	 *		no previous doubly-linked node.
	 */
	public DoubleNode(T element, DoubleNode<T> next)
	{
		super(element, next);
		this.prevNode = null;
	}
	
	/*
     * Constructor. Creates a node with an element but no previous or next doubly-linked
	 *		node specified.
	 */
	public DoubleNode(T element)
	{
		this(element, null, null);
	}
	
	/*
     * Constructor. Creates a node with a next node but no element specified.
	 */
	public DoubleNode(DoubleNode<T> previous, DoubleNode<T> next)
	{
		this(null, previous, next);
	}
	
	/*
     * Constructor. Creates an empty node without an element or a next or previous
	 *		doubly-linked node specified.
	 */
	public DoubleNode()
	{
		this(null, null, null);
	}
	
	
	// --------------------------------- ACCESSOR METHODS ---------------------------------
	/*
     * Returns a reference to the next node as a doubly-linked node.
     */
	public DoubleNode<T> getNext()
	{
		return (DoubleNode<T>) super.getNext();
	}
	
	/*
     * Returns a reference to the previous node.
     */
	public DoubleNode<T> getPrevious()
	{
		return this.prevNode;
	}
	
	
	// ---------------------------------  MUTATOR METHODS ---------------------------------
	/*
	 * Sets the next node of this node to the parameter
	 */
	public void setNext(DoubleNode<T> newNext)
	{
		super.setNext(newNext);
	}
	
	/*
	 * Sets the previous node of this node to the parameter
	 */
	public void setPrevious(DoubleNode<T> newPrevious)
	{
		this.prevNode = newPrevious;
	}

}