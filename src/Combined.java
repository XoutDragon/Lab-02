public class Combined
{
	/**
	* This method takes the head Node of two sorted singly-linked lists and
	* combines them into a single, sorted doubly-linked list. This method
	* should create the new, sorted doubly-linked list without destroying
	* the information within or the ordering of the two singly-linked lists
	* which were passed in.
	* <p>
	* The elements in the two singly-linked lists passed in are 
	* guaranteed to be congruent and comparable with the other
	* You may assume that you can use the Comparable interface between
	* the elements of the two singly-linked lists which has been passed
	* in with no conflicts.
	*
	* @param  list1 the head Node of one sorted singly-linked list
	* @param  list2 the head Node of the other sorted singly-linked list
	* @return       the DoubleNode at the head of the combined and sorted
	*				doubly-linked list
	* @see          Comparable
	*/
	@SuppressWarnings("unchecked")
	public static DoubleNode<Comparable> combineSorted(Node<Comparable> list1, Node<Comparable> list2)
	{
		Node<Comparable> temp1 = list1;
		Node<Comparable> temp2 = list2;

		DoubleNode<Comparable> head = null;
		DoubleNode<Comparable> currNode = head;

		while (temp1 != null || temp2 != null) {
			if (temp1 == null) {
				if (head == null) {
					head = new DoubleNode<>(temp2.getElement(), null);

					temp2 = temp2.getNext();

					currNode = head;
					continue;
				}
				DoubleNode<Comparable> nextNode = new DoubleNode<>(temp2.getElement(), currNode, null);

				temp2 = temp2.getNext();

				currNode.setNext(nextNode);
				currNode = currNode.getNext();
			} else if (temp2 == null) {
				if (head == null) {
					head = new DoubleNode<>(temp1.getElement(), null);

					temp1 = temp1.getNext();

					currNode = head;
					continue;
				}
				DoubleNode<Comparable> nextNode = new DoubleNode<>(temp1.getElement(), currNode, null);

				temp1 = temp1.getNext();

				currNode.setNext(nextNode);
				currNode = currNode.getNext();
			}
			else {
				int result = temp1.getElement().compareTo(temp2.getElement());

				if (result > 0) {
					if (head == null) {
						head = new DoubleNode<>(temp2.getElement(), null);

						temp2 = temp2.getNext();

						currNode = head;
						continue;
					}
					DoubleNode<Comparable> nextNode = new DoubleNode<>(temp2.getElement(), currNode, null);
					temp2 = temp2.getNext();

					currNode.setNext(nextNode);
					currNode = currNode.getNext();

				} else {
					if (head == null) {
						head = new DoubleNode<>(temp1.getElement(), null);

						temp1 = temp1.getNext();

						currNode = head;
						continue;
					}
					DoubleNode<Comparable> nextNode = new DoubleNode<>(temp1.getElement(), currNode, null);

					temp1 = temp1.getNext();

					currNode.setNext(nextNode);
					currNode = currNode.getNext();
				}
			}
		}

		return head;
	}


	public static void main(String[] args)
	{
		Node<Comparable> list01_1 = new Node<Comparable>(Integer.valueOf(3), new Node<Comparable>(Integer.valueOf(6), new Node<Comparable>(Integer.valueOf(7), new Node<Comparable>(Integer.valueOf(9), new Node<Comparable>(Integer.valueOf(10))))));
		Node<Comparable> list01_2 = new Node<Comparable>(Integer.valueOf(1), new Node<Comparable>(Integer.valueOf(2), new Node<Comparable>(Integer.valueOf(5), new Node<Comparable>(Integer.valueOf(8), new Node<Comparable>(Integer.valueOf(9))))));
		DoubleNode<Comparable> currNode = combineSorted(list01_1, list01_2);

		while (currNode != null) {
			System.out.println(currNode.getElement());
			currNode = currNode.getNext();
		}

		System.out.println("----------------------------------------------------------------");

		Node<Comparable> list02_1 = new Node<Comparable>("Connery", new Node<Comparable>("Elba", new Node<Comparable>("Moore", new Node<Comparable>("Old Connery", null))));
		Node<Comparable> list02_2 = new Node<Comparable>("Allen", new Node<Comparable>("Brosnan", new Node<Comparable>("Craig", new Node<Comparable>("Dalton", new Node<Comparable>("Lazenby", null)))));

		DoubleNode<Comparable> currNode1 = combineSorted(list02_1, list02_2);

		while (currNode1 != null) {
			System.out.println(currNode1.getElement());
			currNode1 = currNode1.getNext();
		}
	}
}