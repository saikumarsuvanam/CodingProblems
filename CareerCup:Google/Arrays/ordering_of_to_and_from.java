import java.util.*;

//https://www.careercup.com/question?id=5079989210841088
/* Given an bunch of airline tickets with [from, to], for example [MUC, LHR], [CDG, MUC], [SFO, SJC], [LHR, SFO], please reconstruct the itinerary in order,
for example: [ CDG, MUC, LHR, SFO, SJC ].
//tickets can be represented as nodes

 */
public class ordering_of_to_and_from {

	class Ticket{
		String from;
		String to;
		Ticket (String from, String to){
			this.from=from;
			this.to=to;
		}
		
	}
		
	void ordering_of_tickets(ArrayList<Ticket> t){
		HashMap<String,String> h=new HashMap<String,String>();
		HashSet destinationset=new HashSet();
		ArrayList order=new ArrayList();
		String from="";
		String to="";
		//Add ticekts to hashmap
		//also Add destinaitons to destinationset
		for(int i=0; i<t.size();i++){
			from=t.get(i).from;
			to=t.get(i).to;
		    h.put(from,to);
		    destinationset.add(to);
	   }
	//find start point
		String start="";
		for(int i=0; i<t.size();i++){
			if(!destinationset.contains(t.get(i).from))
			{  start=from;
				break;
		}
		}
		while(h.containsKey(start)){
			  order.add(start);
		     start=	h.remove(start);
		
		  }
		  order.add(start);//add last element
		  
		  //print
		  for(int i=0; i<order.size();i++){
			  System.out.println(order.get(i));
		  }
		  
		  
	
	 }
	
	
	 
	
	
	


	
	public static void main(String[] args){
		ordering_of_to_and_from f=new ordering_of_to_and_from();
		ArrayList<Ticket> ticekts=new ArrayList<Ticket>();
		
		
		
	
		ticekts.add(f.new Ticket("LHR", "SFO"));
		ticekts.add(f.new Ticket("SFO", "SJC"));
		Ticket t=f.new Ticket("MUC","LHR");
		ticekts.add(t);
		ticekts.add(f.new Ticket("CDG", "MUC"));
		f.ordering_of_tickets(ticekts);
		
		
		
	}
		
		
}
