package day1.q3;

/*
Q3. Write a method called copyOf(), which accept an int array and returns a copy of the given array.
The method's signature is as follows:
public static int[] copyOf(int[] array)
*/

public class copyof {
    static int[] copyOf(int[] arr) {
        int[] copy = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            copy[i] = arr[i];
        }
        return copy;
    }

    public static void main(String[] args) {
        int [] arr = {1,3,6,8,5};
        int [] copy = copyOf(arr);
        for (int j : copy) {
            System.out.println(j);
        }
    }
}
