import java.io.*;
import java.util.*;
import cs1.*;

public class postfix {
    public static void main(String[] args) {
	String k=Keyboard.readString();
	dopf x = new dopf(k);
	System.out.println(x.calc());
    }

}

class dopf {
    double[] a;
    StringTokenizer st;
    int p = 0;
    String token;

    public dopf(String k) {
	a = new double[100];
	st = new StringTokenizer(k); 
   }
    public double calc() {
	while (st.hasMoreTokens()) {
	    token = st.nextToken();
	    try {
		push(Double.parseDouble(token));
	    }
	    catch(NumberFormatException e) {
		double x = pop();
		double y = pop();

		if (token.equals("+")) {
		    push(x+y);
		}
		else if (token.equals("-")) {
		    push(x-y);
		}
		else if (token.equals("*")) {
		    push(x*y);
		}
		else {
		    push(x/y);
		}
	    }
	}
	return pop();
    }
    public void push(double d) {
	a[p] = d;
	p++;
    }
    public double pop() {
	double d = a[p-1];
	a[p-1]=0;
	p--;
	return d;
    }
}
