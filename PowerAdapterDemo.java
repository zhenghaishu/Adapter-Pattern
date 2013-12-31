/**
 * @功能 对象适配器模式的具体例子演示
 * @作者 郑海树
 * @时间 2013-12-31
 */

public class PowerAdapterDemo {
    public static void main(String[] args) {
        MobilePowerAdapter adpter = new MobilePowerAdapter();
        int voltage = adpter.GetPower10V();
        System.out.println("Voltage from adpater is " + voltage + "V");
    }
}

interface ITarget {
    int GetPower10V();
}

// 电源，被适配者（Adaptee）
class Power {
    int GetPower220V() {
        return 220;
    }
}

// 移动电源适配器
class MobilePowerAdapter implements ITarget {
    private Power power;
    public MobilePowerAdapter() {
        this.power = new Power();
    }
    
    @Override
    public int GetPower10V() {
        int v = power.GetPower220V();
        System.out.println("Voltage from outlet is " + v + "V");
        
        return change220To10(v);
    }
	
	public int change220To10(final int voltage) {
		return voltage / 22;
	}
} 
