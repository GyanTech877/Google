/*
Implement pow(x, n) % d.

In other words, given x, n and d,

find (xn % d)

Note that remainders on division cannot be negative.
In other words, make sure the answer you return is non negative.

Input : x = 2, n = 3, d = 3
Output : 2

2^3 % 3 = 8 % 3 = 2.
*/

public class Solution {
	public int pow(int x, int n, int d) {
	    if(x==0) return 0;
	    if(n==0) return 1;
	    if(n==1) return (x%d +d)%d;
	    if(n==2) return (x*x)%d;
	    if(n>0){
	        if(n%2==0) return (pow(x,n/2,d) * pow(x,n/2,d))%d;
	        else return (x*pow(x,n/2,d) * pow(x,n/2,d))%d;
	    }
	    else{
	         n = -n;
	         if(n%2==0) return 1/(pow(x,n/2,d) * pow(x,n/2,d))%d;
            else return 1/(x*pow(x,n/2,d) * pow(x,n/2,d))%d;
	    }
	}
  
  public int pow2(int x, int n, int d) {
	if(x==0) return 0;
	if(n==0) return 1;
        long result = 1;
        long square = x;
        while(n != 0){
            if(n % 2 != 0)result = result *  square;
            square = (square * square) % d;
            n = n/2;
            result = result % d;
        }
        return (int)(result+d)%d;
    }
}
