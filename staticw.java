public class staticw {
    int a;
    static int b;
    static void show ()
    {
        int a=2;
        System.out.println(" b="+b);
        System.out.println(" a="+a);
    }
    void display()
    {
        System.out.println("a ="+a);
        System.out.println("b is "+b);

        
    }
    public static void main (String args[])
    {
        staticw a =new staticw();
        a.show();
        a.display();
    }

}
