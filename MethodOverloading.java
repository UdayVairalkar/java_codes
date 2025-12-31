class MethodOverloading {
    double area(double radius) {
        return Math.PI * radius * radius;
    }

    int area(int side) {
        return side * side;
    }

    
    int area(int length, int width) {
        return length * width;
    }

    public static void main(String[] args) {
        MethodOverloading obj = new MethodOverloading();


       
        System.out.println("Area of circle : "  + obj.area(3.0));
        System.out.println("Area of square : " + obj.area(4));
        System.out.println("Area of rectangle : " + obj.area(5, 3));
    }
}