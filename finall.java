 class demo 
{
  int a=0; 
   void getdata(){
  System.out.println("a is "+a);
  }
  
}
final class demo2 extends demo{
  int b=10;
  void display(){
    System.out.println("the value of b is "+b);

  }
  class finall extends demo{
  int b=10;
  void display(){
    System.out.println("the value of b is "+b);

  }}
  public static void main(String[] args) {
      
  finall a=new finall();
  a.getdata();
  a.display();
  }
}