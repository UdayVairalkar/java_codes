public class person {
    double num;
    String name;
int age;
person(String n,int a,double na)
{
    name=n;
    age=a;
num=na;

}
    void putdata()
    {
        System.out.println("name of ther person is "+name);
        System.out.println("age of the person s "+age);
        System.out.println("number oof thhis person is "+num);


    }
    public static void main (String args[])
    {
        person p = new person("uday",20,9699242375l);

p.putdata();
    }
}
