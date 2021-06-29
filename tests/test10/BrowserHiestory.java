/* ***************          Implement the Browser History          *************
	You allowed to open a single tab in the browser. All the activities have to 
	be done on that particular tab. You will start with the given homepage. You 
	can visit a particular url. You can get back x steps in history and get forward 
	x steps in the history.
	Implement the BrowserHistory class:

	1. BrowserHistory(string homepage): Initializes the object with the homepage 
		of the browser. 
	2. void visit(string url): Visits url from the current page. It clears up all 
		the forward history.
	3. string back(int steps): Move steps back in history. If you can only return 
		x steps in the history and steps > x, you will return only x steps. Return 
		the current url, after moving back in history.
	4. string forward(int steps): Move steps forward in history. If you can only 
		forward x steps in the history and steps > x, you will forward only x steps. 
		Return the current url after forwarding in history.

		Input Format:
			There is only one line of input. The first word in the input denotes 
			the homepage. The following line of input contain function calls made 
			using following choices:
			1. If the choice is 1, then visit function is called. First the choice 
				and then a string is given to us as input, which is passed as an 
				input url to visit function.
			2. If the choice is 2, then back function is called. First the choice 
				and then a integer is given to us as input, which is passed as an 
				input integer to back function.
			3. If the choice is 3, then forward function is called. First the choice 
				and then a integer is given to us as input, which is passed as an input 
				integer to forward function.

		Output format:
			For each call, made to back or forward function, we have to print the url, 
			which will be opened after moving back or forward in history. Each url 
			needs to be printed on a newline. 

		Sample Input 1:
			gfg.com 1 google.com 1 codingninjas.com 1 youtube.com 2 1 2 1 3 1 1 
			linkedin.com 3 2 2 2 2 7 1 facebook.com  3 2 2 2 2 4 0

		Sample Output 1:
			codingninjas.com
			google.com
			codingninjas.com
			linkedin.com
			google.com
			gfg.com
			facebook.com
			gfg.com
			gfg.com

 */

package test10;

class Node{
	public String data;
	public Node next;
	public Node prev;
	public Node(String data) {
		this.data=data;
	}
}
class BrowserHistory {
	Node home;
    Node current;
    public BrowserHistory(String homepage) {
        this.home = new Node(homepage);
        this.current = new Node(homepage);

    }

    public void visit(String url) {
        current.next = new Node(url);
        current.next.prev = current;
        current = current.next;
    }

    public String back(int steps) {
        int i =0 ;
        while(current.prev!=null){
            i++;
            current = current.prev;
            if(i==steps) break;
        }
        return current.data;
    }

    public String forward(int steps) {
        int i =0 ;
        while(current.next!=null){
            i++;
            current = current.next;
            if(i==steps) break;
        }
        return current.data;
    }
}

public class BrowserHiestory {
    public static void main(String[] args) {
        
    }
}
