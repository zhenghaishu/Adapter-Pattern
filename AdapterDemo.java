
interface Target {
    void Request(); 
} 


class Adaptee { 
    void SpecificRequst() { 
        System.out.println("Adaptee's SpecificRequst"); 
    } 
} 


class Adapter implements Target {
    private Adaptee adaptee; 
    public Adapter() { 
        this.adaptee=new Adaptee(); 
    } 
     
    @Override 
    public void Request() { 
         System.out.println("Adapter's Request"); 
         adaptee.SpecificRequst(); 
    }
} 


public class AdapterDemo { 
    public static void main(String[] args) {
        Target t=new Adapter();
        t.Request(); 
    }
} 
