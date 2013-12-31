
public class PowerAdapterDemo { 
    public static void main(String[] args) {  
        MobilePowerAdapter mpa=new MobilePowerAdapter(); 
        int power = mpa.GetPower10V();
        System.out.println("Current power is " + power + "V");
    } 
} 


interface ITarget { 
    int GetPower10V(); 
} 
 
 
class Power { 
    int GetPower220V() { 
         return 220; 
    } 
} 

 
class MobilePowerAdapter implements ITarget { 
    private Power power; 
    public MobilePowerAdapter() { 
        this.power = new Power(); 
    } 
     
    @Override
    public int GetPower10V() {
        int p = power.GetPower220V();
        System.out.println("Original power is " + p + "V");
        
        return change220To10(p);
    } 
	
	public int change220To10(final int p) {
		return p / 22;
	}
} 
