public class Sorted
{
	/**
	* This method takes the head Node of a sorted singly-linked list
	* and a Comparable element. This method finds where in the linked
	* list that the element should be inserted so that the linked list
	* stays in order.
	* <p>
	* The Comparable element passed in is gauranteed to be congruent 
	* and comparable with the elements of the linked list which is 
	* passed in. You may assume that you can use the Comparable
	* interface between the new element and the elements of the linked
	* list which has been passed in with no conflicts.
	*
	* @param  headNode   the head Node of a sorted singly-linked list
	* @param  newElement an element which is compatible with the linked
	*				     list and is to be inserted into the list in order
	* @return            the Node at the head of the linked list
	* @see               Comparable
	*/
	@SuppressWarnings("unchecked")
	public static Node<Comparable> insertSorted(Node<Comparable> headNode, Comparable newElement)
	{
		if (headNode == null) return new Node<>(newElement);

		Node<Comparable> prevNode = null;
		Node<Comparable> currNode = headNode;
		while (currNode != null) {
			if (prevNode == null && currNode.getElement().compareTo(newElement) >= 0) {
                return new Node<>(newElement, currNode);
			} else if (prevNode != null && currNode.getElement().compareTo(newElement) >= 0) {
				Node<Comparable> newNode = new Node(newElement, currNode);
				prevNode.setNext(newNode);
				return headNode;
			}
			prevNode = currNode;
			currNode = currNode.getNext();
		}
		Node<Comparable> newNode = new Node(newElement, null);
        prevNode.setNext(newNode);

		return headNode;
	}
	
	
	public static void main(String[] args)
	{
		Node<Comparable> head = new Node(1, new Node(2, new Node(3, new Node(5))));
		head = insertSorted(head, 4);
		head = insertSorted(head, -1);
		head = insertSorted(head, 6);

		Node currNode = head;
		while (currNode != null) {
			System.out.println(currNode.getElement());
			currNode = currNode.getNext();
		}
	}
}