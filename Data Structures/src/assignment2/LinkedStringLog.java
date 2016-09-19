//----------------------------------------------------------------------
// LinkedStringLog.java       by Dale/Joyce/Weems              Chapter 2
//
// Implements StringLogInterface using a linked list 
// of LLStringNode to hold the log strings.
//----------------------------------------------------------------------

package assignment2;

public class LinkedStringLog implements StringLogInterface
{
  protected LLStringNode log; // reference to first node of linked 
                              // list that holds the StringLog strings
  protected String name;      // name of this StringLog
  
  public LinkedStringLog(String name)
  // Instantiates and returns a reference to an empty StringLog object 
  // with name "name".
  {
    log = null;
    this.name = name;
  }

  public void insert(String element)
  // Precondition:   This StringLog is not full.
  //
  // Places element into this StringLog.
  {      
    LLStringNode newNode = new LLStringNode(element);
    newNode.setLink(log);
    log = newNode;
  }

  public boolean isFull()
  // Returns true if this StringLog is full, false otherwise.
  {              
    return false;
  }
  
  public int size()
  // Returns the number of Strings in this StringLog.
  {
    int count = 0;
    LLStringNode node;
    node = log;
    while (node != null)
    {
      count++;
      node = node.getLink();
    }
    return count;
  }
  
  public boolean contains(String element)
  // Returns true if element is in this StringLog,
  // otherwise returns false.
  // Ignores case difference when doing string comparison.
  {                 
    LLStringNode node;
    node = log;

    while (node != null) 
    {
      if (element.equalsIgnoreCase(node.getInfo()))  // if they match
        return true;
      else
        node = node.getLink();
    }

   return false;
  }
  
  public void clear()
  // Makes this StringLog empty.
  { 
    log = null;
  }

  public String getName()
  // Returns the name of this StringLog.
  {
    return name;
  }
  
  public void insertLast(String element) {
	  // Inserts element to the end of the list
	  if (log == null) {
		  insert(element);
		  return;
	  }
	  LLStringNode node = new LLStringNode(element);
	  LLStringNode temp = log;
	  while(temp.getLink() != null) {
		  temp = temp.getLink();
	  }
	  temp.setLink(node);
  }
  
  public boolean remove(String element) {
	  // Removes first node with info element from the list
	  // Returns true if element is found and false if not
	  	if (log == null) { 
	  		System.out.println(name + " is empty, proceeding to remove YOUR SOUL /n ..... ");
	  		System.out.println("Soul removal successfull");
	  		return false;
	  	}
	  	LLStringNode node;
	    node = log;

	    while (node.getLink() != null) 
	    {
	      if (element.equalsIgnoreCase(node.getLink().getInfo())) {  // if they match
	        node.setLink(node.getLink().getLink());
	        System.gc();
	        return true;
	      }
	      else
	        node = node.getLink();
	    }
	    return false;
  }
	    
  public LinkedStringLog copy() {
	  // returns a deep copy of the list
	  LinkedStringLog fresh = new LinkedStringLog(getName());
	  LLStringNode node = log;
	  while (node != null) {
		  fresh.insert(node.getInfo());
		  node = node.getLink();
	  }
	  return fresh;
  }
  
  public boolean equals(Object other) {
	  // checks if other has the same amount of elements with the same info
	  LinkedStringLog oth = (LinkedStringLog) other;
	  LinkedStringLog othCopy = oth.copy();
	  LLStringNode temp = log;
	  if (oth.size() != this.size()) return false;
	  while(temp.getLink() != null) {
		  if(othCopy.remove(temp.getInfo())) {
			  temp = temp.getLink();
			  continue;
		  }
		  return false;
	  }
	  return true;
  }

  public String toString()
  // Returns a nicely formatted string representing this StringLog.
  {
    String logString = "Log: " + name + "\n\n";
    LLStringNode node;
    node = log;
    int count = 0;
    
    while (node != null)
    {
      count++;
      logString = logString + count + ". " + node.getInfo() + "\n";
      node = node.getLink();
    }
      
    return logString;
  }
}