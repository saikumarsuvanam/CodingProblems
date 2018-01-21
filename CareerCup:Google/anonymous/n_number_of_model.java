import java.util.HashMap;

public class n_number_of_model {

    public static void main(String[] args) {
        int N=610;
        System.out.println(count_ways(N));
       
       
    }
   
    static HashMap<Integer,Long> h=new HashMap<Integer,Long>();
    static Long  count_ways(int N){
        if(h.containsKey(N)){
        return h.get(N);
    }
   
       
        if(N==1){
       return           1L;
        }
        if(N==2){
            return 2L;
        }
        if(N==3){
            return 4L;
        }
        if(N==4)
            return 8L;
        if(N==5)
            return 16L;
       
        if(N==6){
            return 31L;
        }
       
        Long res= count_ways(N-1)+count_ways(N-2)+count_ways(N-3)+count_ways(N-4)+count_ways(N-5)+count_ways(N-6);
    if(!h.containsKey(N)){
        h.put(N,res);
    }
        return res;
     
   
    }
}