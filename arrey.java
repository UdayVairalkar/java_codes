
import java.util.Scanner;

class arrey {
    Scanner sc = new Scanner(System.in);
    int a[] = new int[5];

    void getdata() {
        for (int i = 0; i < 5; i++)
         {
            System.out.print("Enter number ");
            a[i] = sc.nextInt();
        }
    }

    void display() {
        System.out.println("You entered:");
        for (int j = 0; j < 5; j++) {
            System.out.println("Number " + a[j]);
        }
    }

    void motha() {
        int max = a[0];
        for (int i = 1; i < 5; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        System.out.println("The greatest number is: " + max);
    }

    public static void main(String args[]) {
        arrey a = new arrey();
        a.getdata();
        a.display();
        a.motha(); 
}
}