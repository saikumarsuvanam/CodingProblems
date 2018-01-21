package graphKind;

import java.util.*;
import java.util.Map.Entry;

/*You visited a list of places recently, but you do not remember the
order in which you visited them. You have with you the airplane
tickets that you used for travelling. Each ticket contains just the
start location and the end location. Can you reconstruct your journey?*/
//http://www.geeksforgeeks.org/find-itinerary-from-a-given-list-of-tickets/
//It may be assumed that the input list of tickets is not cyclic and 
//there is one ticket from every city except final destination. other wise we may found multiple jounerys/paths.
// geeks for geeks method is 
/*1) Create a HashMap of given pair of tickets.  Let the created 
HashMap be 'dataset'. Every entry of 'dataset' is of the form 
"from->to" like "Chennai" -> "Banglore"

2) Find the starting point of itinerary.
  a) Create a reverse HashMap.  Let the reverse be 'reverseMap'
     Entries of 'reverseMap' are of the form "to->form". 
     Following is 'reverseMap' for above example.
     "Banglore"-> "Chennai" 
     "Delhi"   -> "Bombay" 
     "Chennai" -> "Goa"
     "Goa"     ->  "Delhi"

  b) Traverse 'dataset'.  For every key of dataset, check if it
     is there in 'reverseMap'.  If a key is not present, then we 
     found the starting point. In the above example, "Bombay" is
     starting point.

3) Start from above found starting point and traverse the 'dataset' 
to print itinerary.
*/
public class find_journey_from_itenary {
	
   public static void main(String[] args){
	find_journey_from_itenary  f=new find_journey_from_itenary(); 
	HashMap <String, String> map=new HashMap<String,String>();
	 map.put("4", "5");
	    map.put("9", "4");
    map.put("5", "1");
    map.put("11", "9");
    map.put("6", "11");
   // map.put("11", "9");
   
   f.findjourney(map);
    
}
 
   class Ticket{
	  String Source;
	  String destination;
	  Ticket(String Source,String destination){
		  this.Source=Source;
		  this.destination=destination;
		  
	  }
	  public String toString(){
		  return Source+"="+destination;
	  }
   }
  
   // my method complex- but worst space complexity and  efficient in time  in 0(n) but use the method in geeks from geeks 
   //which is easy to understood in interviews.
    void findjourney(HashMap<String, String> map ){
	 String source;
	 String destination;
	 ArrayList<Ticket> journey=new ArrayList<Ticket>();
	 HashSet<String> set=new HashSet<String>();
	   for(Entry<String, String> entry:map.entrySet()){
		 source=entry.getKey();
	     destination=entry.getValue();
	     ArrayList<Ticket> temp=new ArrayList<Ticket>();
	     if(!set.contains(source)){
	    	 temp.add(new Ticket(source,destination));
	    	 set.add(source);
	    while(map.containsKey(destination)&& !set.contains(destination)){
	     String des=map.get(destination);
	     temp.add(new Ticket(destination,des));
	     set.add(destination);
	     destination=des;
	    }
	    journey.addAll(0, temp); 
	    if(journey.size()==map.size())break;
	     }
	     } 
	     
	   
	 System.out.println(journey);
	   
   }
   
}
