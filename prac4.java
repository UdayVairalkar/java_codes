class demo {
    int n;

    void demoo(int n) {
        this.n = n;
    }
}

class prac4 extends demo
 {
   

    void display() {
        System.out.println("number is: " + this.n);
    }

    public static void main(String[] args) {
        prac4 obj = new prac4(); 
        obj.demoo(10);
        obj.display();
        
    }
}
