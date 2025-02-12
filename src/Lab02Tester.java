import java.util.Scanner;

public class Lab02Tester
{
	/**
	* Method which takes a reference to a node and a parameter which represents
	* the type of node that we need to check for. If all of the nodes in the list
	* are of the proper type of node or if the reference is to a null, then the
	* list is well-formed and the method will return true. It will return false
	* otherwise.
	*
	* @param  currentNode the head Node the linked list to be checked
	* @param  typeOfNode  the class of the type of node that should compose the list
	* @return             true if the list is well-formed of the type of node passed
	*				      in, false otherwise
	*/
	public static boolean listValid(Node<Comparable> currentNode, Class typeOfNode)
	{
		//I) While the current node is not null
		while(currentNode != null)
		{
			//A) If the type of the current node is not the specified type, return false
			if(!currentNode.getClass().equals(typeOfNode))
				return false;
			//System.out.println(currentNode.class.toString());

			//B) Move the currentNode to the next node
			currentNode = currentNode.getNext();
		}
		
		//II) If we are here, then we got through the entire linked list
		//       so return true
		return true;
	}

	
	/**
	* This method takes a reference to a node and determines if the elements in
	* the list are in order (either non-decreasing or non-increasing.
	* <p>
	* <b>NOTE:</b> We can effectively move through either a singly or doubly 
	* linked list using only the getNext method and because of the object
	* hierarchy, we can simply treat this list as singly linked for output
	* purposes.
	*
	* @param  currentNode the head node of a linked list
	* @return             true if the elements in the list are in order, false
	*					  otherwise
	*/
	@SuppressWarnings("unchecked")
	public static boolean listOrdered(Node<Comparable> currentNode)
	{
		//I) Set a variable that says if direction has been determined and another
		//       for the direction of movement
		boolean directionDetermined = false;
		boolean listIncreasing = false;

		//III) While the current Node and the current Node's next is not null
		while((currentNode != null) && (currentNode.getNext() != null))
		{
			//A) If the direction has not been determined and the elements in the
			//       current node and the next node are different
			if(!directionDetermined && !(currentNode.getElement().equals(currentNode.getNext().getElement())))
			{
				//1) Set the direction determined variable to true
				directionDetermined = true;

				//2) Set the listIncreasing variable appropriately
				listIncreasing = currentNode.getElement().compareTo(currentNode.getNext().getElement()) < 0;
			}

			//B) If the direction has been determined
			if(directionDetermined)
			{
				Node<Comparable> nextNode = (Node<Comparable>)currentNode.getNext();
				Comparable currentElement = currentNode.getElement();
				Comparable nextElement    = nextNode.getElement();
				
				//1) If the list is increasing and the element in the current node
				//       is greater than the element in the next, return False
				if(listIncreasing && (currentElement.compareTo(nextElement)) > 0)
					return false;

				//2) Else, if the list is not increasing and the element in the
				//       current node is less than the element in the next, return False
				else if(!listIncreasing && (currentElement.compareTo(nextElement)) < 0)
					return false;
			}
			
			//C) Move the currentNode to the next node
			currentNode = (Node<Comparable>)currentNode.getNext();
		}

		//II) If we are here, then we got through the entire linked list
		//       so return true
		return true;
	}

	
	/**
	* This method takes the head node of a linked list and returns the contents
	* of the list formatted for output.
	* <p>
	* <b>NOTE:</b> We can effectively move through either a singly or doubly 
	* linked list using only the getNext method and because of the object
	* hierarchy, we can simply treat this list as singly linked for output
	* purposes.
	*
	* @param  currentNode the head node of a linked list
	* @return             a String representing the contents of the linked list
	*					  formatted for output
	*/
	public static String listOutput(Node<Comparable> currentNode)
	{
		//I) Declare our output string as the header
		String outputString = "Linked List\n------------------\n";

		//II) For each index in the linked list and while the current node is not null
		for(int index = 0; currentNode != null; index++)
		{	
			//A) Add the index to the output string
			outputString += "[" + index + "] :\t";
			
			//B) Add the element to the output string followed by an arrow
			outputString += currentNode.getElement().toString() + " ->\n";

			//C) Update the current node to the current node's next node
			currentNode = currentNode.getNext();
		}

		//III) Add the done message and some formatting to the end
		outputString += "Done!\n";

		//IV) Return the output
		return outputString;
	}


	public static void main(String[] args)
	{
		Node<Comparable> headNum, headString;
		Scanner keyboard = new Scanner(System.in);
		String input = "";
		
		boolean pause = false;

		//I) Test the elements from the insertSorted function for ints
		System.out.println("--------------------------------------------------------------------");
		System.out.println("I) Test the elements from the insertSorted function for ints");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("   3 -> 4 -> 5");
		System.out.println("--------------------------------------------------------------------");

		//Empty
		headNum = Sorted.insertSorted(null, Integer.valueOf(5));
		System.out.println(Lab02Tester.listOutput(headNum));

		//Front
		headNum = Sorted.insertSorted(headNum, Integer.valueOf(3));
		System.out.println(Lab02Tester.listOutput(headNum));

		//Middle
		headNum = Sorted.insertSorted(headNum, Integer.valueOf(4));
		System.out.println(Lab02Tester.listOutput(headNum));
		
		if(pause)
			input = keyboard.nextLine();
		else
			System.out.println();

		System.out.println("--------------------------------------------------------------------");
		System.out.println("   3 -> 4 -> 5 -> 10 -> 15 -> 15");
		System.out.println("--------------------------------------------------------------------");

		//End
		headNum = Sorted.insertSorted(headNum, Integer.valueOf(15));
		System.out.println(Lab02Tester.listOutput(headNum));

		headNum = Sorted.insertSorted(headNum, Integer.valueOf(15));
		System.out.println(Lab02Tester.listOutput(headNum));

		headNum = Sorted.insertSorted(headNum, Integer.valueOf(10));
		System.out.println(Lab02Tester.listOutput(headNum));
		
		if(pause)
			input = keyboard.nextLine();
		else
			System.out.println();

		System.out.println("--------------------------------------------------------------------");
		System.out.println("   3 -> 3 -> 4 -> 5 -> 6 -> 8 -> 10 -> 15 -> 15");
		System.out.println("--------------------------------------------------------------------");

		headNum = Sorted.insertSorted(headNum, Integer.valueOf(3));
		System.out.println(Lab02Tester.listOutput(headNum));

		headNum = Sorted.insertSorted(headNum, Integer.valueOf(8));
		System.out.println(Lab02Tester.listOutput(headNum));

		headNum = Sorted.insertSorted(headNum, Integer.valueOf(6));
		System.out.println(Lab02Tester.listOutput(headNum));
		
		if(pause)
			input = keyboard.nextLine();
		else
			System.out.println();


		//II) Ensure that the list is singly-linked and in order
		System.out.println("--------------------------------------------------------------------");
		System.out.println("//II) Ensure that the list is singly-linked and in order");
		System.out.println("--------------------------------------------------------------------");

		System.out.println("Singly-Linked:\t\t" + (Lab02Tester.listValid(headNum, Node.class)));
		System.out.println("Ordered Correctly:\t" + (Lab02Tester.listOrdered(headNum)));
		
		if(pause)
			input = keyboard.nextLine();
		else
			System.out.println();


		//III) Test the elements from the insertSorted function for strs
		System.out.println("--------------------------------------------------------------------");
		System.out.println("IIII) Test the elements from the insertSorted function for strs");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("   Elvis -> Superman -> Yoda");
		System.out.println("--------------------------------------------------------------------");

		//Empty
		headString = Sorted.insertSorted(null, "Elvis");
		System.out.println(Lab02Tester.listOutput(headString));

		//End
		headString = Sorted.insertSorted(headString, "Superman");
		System.out.println(Lab02Tester.listOutput(headString));

		//End
		headString = Sorted.insertSorted(headString, "Yoda");
		System.out.println(Lab02Tester.listOutput(headString));
		
		if(pause)
			input = keyboard.nextLine();
		else
			System.out.println();

		System.out.println("--------------------------------------------------------------------");
		System.out.println("   Alf -> Chewie -> E.T. -> Elvis -> Superman -> Xenomorph -> Yoda");
		System.out.println("--------------------------------------------------------------------");

		//Front
		headString = Sorted.insertSorted(headString, "E.T.");
		System.out.println(Lab02Tester.listOutput(headString));

		//Front
		headString = Sorted.insertSorted(headString, "Alf");
		System.out.println(Lab02Tester.listOutput(headString));

		//Middle
		headString = Sorted.insertSorted(headString, "Xenomorph");
		System.out.println(Lab02Tester.listOutput(headString));

		//Middle
		headString = Sorted.insertSorted(headString, "Chewie");
		System.out.println(Lab02Tester.listOutput(headString));
		
		if(pause)
			input = keyboard.nextLine();
		else
			System.out.println();


		//IV) Ensure that the list is singly-linked and in order
		System.out.println("--------------------------------------------------------------------");
		System.out.println("//IV) Ensure that the list is singly-linked and in order");
		System.out.println("--------------------------------------------------------------------");

		System.out.println("Singly-Linked:\t\t" + (Lab02Tester.listValid(headString, Node.class)));
		System.out.println("Ordered Correctly:\t" + (Lab02Tester.listOrdered(headString)));
		
		if(pause)
			input = keyboard.nextLine();
		else
			System.out.println();


		//V) Test the elements from the combineSorted function
		System.out.println("--------------------------------------------------------------------");
		System.out.println("V) Test the elements from the combineSorted function");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("   list1:\t3 -> 6 -> 7 -> 9 -> 10");
		System.out.println("   list2:\t1 -> 2 -> 5 -> 8 -> 9");
		System.out.println("--------------------------------------------------------------------");

		Node<Comparable> list01_1 = new Node<Comparable>(Integer.valueOf(3), new Node<Comparable>(Integer.valueOf(6), new Node<Comparable>(Integer.valueOf(7), new Node<Comparable>(Integer.valueOf(9), new Node<Comparable>(Integer.valueOf(10))))));
		Node<Comparable> list01_2 = new Node<Comparable>(Integer.valueOf(1), new Node<Comparable>(Integer.valueOf(2), new Node<Comparable>(Integer.valueOf(5), new Node<Comparable>(Integer.valueOf(8), new Node<Comparable>(Integer.valueOf(9))))));
		System.out.println("X");
		//Standard
		DoubleNode<Comparable> dlist01Num = Combined.combineSorted(list01_1, list01_2);
		System.out.println(Lab02Tester.listOutput(dlist01Num));
		System.out.println("Y");
		if(pause)
			input = keyboard.nextLine();
		else
			System.out.println();
			
		System.out.println("--------------------------------------------------------------------");

		//Reversed
		DoubleNode<Comparable> dlist02Num = Combined.combineSorted(list01_2, list01_1);
		System.out.println(Lab02Tester.listOutput(dlist02Num));
		
		if(pause)
			input = keyboard.nextLine();
		else
			System.out.println();
			
		System.out.println("--------------------------------------------------------------------");

		//List 2 empty
		DoubleNode<Comparable> dlist03Num = Combined.combineSorted(list01_1, null);
		System.out.println(Lab02Tester.listOutput(dlist03Num));
		
		if(pause)
			input = keyboard.nextLine();
		else
			System.out.println();
			
		System.out.println("--------------------------------------------------------------------");

		//List 1 empty
		DoubleNode<Comparable> dlist04Num = Combined.combineSorted(null, list01_2);
		System.out.println(Lab02Tester.listOutput(dlist04Num));
		
		if(pause)
			input = keyboard.nextLine();
		else
			System.out.println();
			
		System.out.println("--------------------------------------------------------------------\n");

		//Both lists empty
		DoubleNode<Comparable> dlist05Num = Combined.combineSorted(null, null);
		System.out.println(dlist05Num);
		
		if(pause)
			input = keyboard.nextLine();
		else
			System.out.println();


		//VI) Ensure that the lists is doubly-linked and in order
		System.out.println("--------------------------------------------------------------------");
		System.out.println("//VI) Ensure that the lists is doubly-linked and in order");
		System.out.println("--------------------------------------------------------------------");

		System.out.println("Doubly-Linked:\t" + Lab02Tester.listValid(dlist01Num, DoubleNode.class));
		System.out.println("\t\t" + Lab02Tester.listValid(dlist02Num, DoubleNode.class));
		System.out.println("\t\t" + Lab02Tester.listValid(dlist03Num, DoubleNode.class));
		System.out.println("\t\t" + Lab02Tester.listValid(dlist04Num, DoubleNode.class));
		System.out.println("\t\t" + Lab02Tester.listValid(dlist05Num, DoubleNode.class));

		System.out.println();

		System.out.println("Ordered Correctly:\t" + Lab02Tester.listOrdered(dlist01Num));
		System.out.println("\t\t\t" + Lab02Tester.listOrdered(dlist02Num));
		System.out.println("\t\t\t" + Lab02Tester.listOrdered(dlist03Num));
		System.out.println("\t\t\t" + Lab02Tester.listOrdered(dlist04Num));
		System.out.println("\t\t\t" + Lab02Tester.listOrdered(dlist05Num));
		
		if(pause)
			input = keyboard.nextLine();
		else
			System.out.println();


		//VII) Test the elements from the combineSorted function
		System.out.println("--------------------------------------------------------------------");
		System.out.println("VII) Test the elements from the combineSorted function");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("   list1:\tConnery -> Elba -> Moore -> Old Connery");
		System.out.println("   list2:\tAllen -> Brosnan -> Craig -> Dalton -> Lazenby");
		System.out.println("--------------------------------------------------------------------");

		Node<Comparable> list02_1 = new Node<Comparable>("Connery", new Node<Comparable>("Elba", new Node<Comparable>("Moore", new Node<Comparable>("Old Connery", null))));
		Node<Comparable> list02_2 = new Node<Comparable>("Allen", new Node<Comparable>("Brosnan", new Node<Comparable>("Craig", new Node<Comparable>("Dalton", new Node<Comparable>("Lazenby", null)))));

		//Standard
		DoubleNode<Comparable> dlist01Str = Combined.combineSorted(list02_1, list02_2);
		System.out.println(Lab02Tester.listOutput(dlist01Str));
		
		if(pause)
			input = keyboard.nextLine();
		else
			System.out.println();
			
		System.out.println("--------------------------------------------------------------------");

		//Reversed
		DoubleNode<Comparable> dlist02Str = Combined.combineSorted(list02_2, list02_1);
		System.out.println(Lab02Tester.listOutput(dlist02Str));
		
		if(pause)
			input = keyboard.nextLine();
		else
			System.out.println();
			
		System.out.println("--------------------------------------------------------------------");

		//List 2 empty
		DoubleNode<Comparable> dlist03Str = Combined.combineSorted(list02_1, null);
		System.out.println(Lab02Tester.listOutput(dlist03Str));
		
		if(pause)
			input = keyboard.nextLine();
		else
			System.out.println();
			
		System.out.println("--------------------------------------------------------------------");

		//List 1 empty
		DoubleNode<Comparable> dlist04Str = Combined.combineSorted(null, list02_2);
		System.out.println(Lab02Tester.listOutput(dlist04Str));
		
		if(pause)
			input = keyboard.nextLine();
		else
			System.out.println();


		//VIII) Ensure that the lists is doubly-linked and in order
		System.out.println("--------------------------------------------------------------------");
		System.out.println("//VIII) Ensure that the lists is doubly-linked and in order");
		System.out.println("--------------------------------------------------------------------");

		System.out.println("Doubly-Linked:\t" + Lab02Tester.listValid(dlist01Str, DoubleNode.class));
		System.out.println("\t\t" + Lab02Tester.listValid(dlist02Str, DoubleNode.class));
		System.out.println("\t\t" + Lab02Tester.listValid(dlist03Str, DoubleNode.class));
		System.out.println("\t\t" + Lab02Tester.listValid(dlist04Str, DoubleNode.class));

		System.out.println();

		System.out.println("Ordered Correctly:\t" + Lab02Tester.listOrdered(dlist01Str));
		System.out.println("\t\t\t" + Lab02Tester.listOrdered((Node<Comparable>)dlist02Str));
		System.out.println("\t\t\t" + Lab02Tester.listOrdered((Node<Comparable>)dlist03Str));
		System.out.println("\t\t\t" + Lab02Tester.listOrdered((Node<Comparable>)dlist04Str));
		
		if(pause)
			input = keyboard.nextLine();
		else
			System.out.println();


		//IX) Check that the previous links of the lists are populated
		System.out.println("--------------------------------------------------------------------");
		System.out.println("//IX) Check that the previous links of the lists are populated");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("   10 -> 9 -> 9 -> 8 -> 7 -> 6 -> 5 -> 3 -> 2 -> 1");
		System.out.println("--------------------------------------------------------------------");

		DoubleNode<Comparable> dlist01Num_tail = (DoubleNode<Comparable>)(dlist01Num.getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext());

		while(dlist01Num_tail != null)
		{
			System.out.println(dlist01Num_tail.getElement());
			dlist01Num_tail = dlist01Num_tail.getPrevious();
		}
		System.out.println("Done!\n");
		
		if(pause)
			input = keyboard.nextLine();
		else
			System.out.println();
			
		System.out.println("--------------------------------------------------------------------");
		System.out.println("   Old Connery -> Moore -> Lazenby -> Elba -> Dalton -> Craig ->");
		System.out.println("        Connery -> Brosnan -> Allen");
		System.out.println("--------------------------------------------------------------------");

		DoubleNode<Comparable> dlist01Str_tail = (DoubleNode<Comparable>)(dlist01Str.getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext());

		while(dlist01Str_tail != null)
		{
			System.out.println(dlist01Str_tail.getElement());
			dlist01Str_tail = dlist01Str_tail.getPrevious();
		}
		System.out.println("Done!\n");
	}
}