// class Car {
//     private int seats;
//     private int speed;

//     public Car() {
//     System.out.print("This Is Car ");
//     }
// }

// class Audi extends Car {
//     Audi() {
//     super();
//     System.out.print("This Is Audi ");
//     }
// } 

// class test {
//     public static void main(String args[]) {
//     Audi a = new Audi();
//     }         
// }

class test{
    public static void main(String[] args){

    try{
       int a = 5/0;
    }
    catch(Exception e){
        System.out.print("Exception caught ");
    }
    catch(ArithmeticException e){
        System.out.print("Arithmetic Exception caught ");
   }
   finally{
       System.out.print("finally block");
   } 
 }
}