class add {
    int a, b;

    add() {
        a = 10;
        b = 10;
    }

    void putdata() {
        System.out.println("The number of addition of this number is " + (a + b));
    }

    public static void main(String[] args) {
        add obj = new add();     // constructor is called here
        obj.putdata();           // method is called here
    }
}
