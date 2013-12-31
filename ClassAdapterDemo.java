/**
 * @功能 类适配器演示
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

// 适配器类，继承了被适配类，同时实现标准接口
class Adapter extends Adaptee implements Target {
    public void Request() {
        super.SpecificRequst();
    }
} 

// 测试类，即Client
public class ClassAdapterDemo {
    public static void main(String[] args) {
        // 使用普通功能类
        Target concreteTarget = new ConcreteTarget();
        concreteTarget.Request();
        
        // 使用特殊功能类，即适配类
        Target adapter = new Adapter();
        adapter.Request();
    }
} 
