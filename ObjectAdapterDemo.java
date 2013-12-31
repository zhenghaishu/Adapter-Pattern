/**
 * @功能 对象适配器演示
 * @作者 郑海树
 * @时间 2013-12-31
 */

// 已存在的、具有特殊功能、但不符合我们既有标准接口的类
class Adaptee {
    void SpecificRequst() {
        System.out.println("...被适配类...具有特殊功能...");
    }
}

// 目标接口（或标准接口）
interface Target {
    void Request();
} 

// 具体目标类，只提供普通功能
class ConcreteTarget implements Target {
    public void Request() {
        System.out.println("...普通类...具有普通功能...");
    }
}

// 适配器类，直接关联被适配类，同时实现标准接口
class Adapter implements Target {
    // 直接关联被适配类
    private Adaptee adaptee;
    
    // 可以通过构造函数传入具体需要适配的被适配类对象
    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }
    
    public void Request() {
        this.adaptee.SpecificRequst();
    }
} 

// 测试类，即Client
public class ObjectAdapterDemo {
    public static void main(String[] args) {
        // 使用普通功能类
        Target concreteTarget = new ConcreteTarget();
        concreteTarget.Request();
        
        // 使用特殊功能类，即适配类
        // 需要先创建一个被适配类的对象作为参数
        Target adapter = new Adapter(new Adaptee());
        adapter.Request();
    }
} 
