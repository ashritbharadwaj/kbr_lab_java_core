package day1.q1;

/*
Q1. Write a program called Fibonacci to display the first 20 Fibonacci numbers F(n), where
F(n)=F(n–1)+F(n–2) and F(1)=F(2)=1. Also compute their average. The output shall look like:
The first 20 Fibonacci numbers are:
1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584 4181 6765
The average is 885.5
 */

public class q1_fibonacci {

    double avg=0.0;

    void fib(int m){
        int p=0,q=1;
        System.out.print(p+" "+q+" ");
        int n=m;
        n-=2;
        int sum=1;
        while(n-->=0){
            int t=p;
            p=q;
            q=t+q;
            sum+=q;
            System.out.print(q+" ");
        }
        avg = sum*1.0/m;
    }

    public static void main(String[] args) {
        System.out.println("The first 20 Fibonacci numbers are:");
        q1_fibonacci obj = new q1_fibonacci();
        obj.fib(20);
        System.out.println();
        System.out.print("The average is "+obj.avg);
    }
}
