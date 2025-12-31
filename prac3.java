 class demo{

    void animal()
    {
        System.out.println("i am a dog");

    }
}
    class prac3 extends demo{
        
        void animal()
        {
            super.animal();
            System.err.println("i am a cat");
        }
            public static void main (String args[])
            {
prac3 a=new prac3();
a.animal();
            
        }
    }

