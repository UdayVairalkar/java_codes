
public class employee{
    int empid;
    String name,dept;
    float salary;

    public employee() {
        empid=991;
        name="uday";
        dept="it";
        salary=99000;

    }
    void print()
    {
        System.out.println("the name of employee is "+name);
        System.out.println("the salary of an employee is "+salary);
System.out.println("the department off an emplyee is "+dept);
    }
public static void main (String args[])
{
    employee e1=new employee();
    e1.print();
}
}