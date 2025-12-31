

class demo {
     int n;

     demo(int n) {
        this.n = n; 
    }

     void display() {
        System.out.println("number  is: " + this.n);
    }

    public static void main(String[] args) {
        demo obj = new demo(10);

        obj.display();
    }
}
