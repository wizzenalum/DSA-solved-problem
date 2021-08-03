import java.io.*;
import java.util.*;
class Deck{
    int[] cardarr = new int[13];
    public Deck(){
        for(int i=0;i<13;i++){
            this.cardarr[i] = 4;
        }
    }
    public void remove(int card,char c)
    {
        this.cardarr[card-1]--;        
    }
    public int probability(int num)
    {
      	int total_cards = 0;
         for(int i=0;i<13;i++){
            total_cards+=this.cardarr[i];
        }
    	return this.cardarr[num-1]*1000/total_cards;  
    }
}
public class ProbabilityOfCards {
	public static void main (String[] args) {
		Scanner s=new Scanner(System.in);
		Deck d=new Deck();
		int x=s.nextInt();
		while(x!=-1)
		{
		    if(x==1)
		    {
		        int card=s.nextInt();
		        char suite=s.next().charAt(0);
		        d.remove(card,suite);
		    }
		    else 
		    {
		        int card=s.nextInt();
		        System.out.println(d.probability(card));
		    }
		    x=s.nextInt();
		}
	}
}