package ch7;

public class InterfaceTest3 {
    public static void main(String[] args) {
        AAA a = new AAA();
        a.methodA();
    }
}

class AAA{
    void methodA(){
        III i = InstanceManager.getInstance();
        i.methodB();
        System.out.println(i.toString());
    }
}

interface III {
    public abstract void methodB();
}

class BBB implements III{
    public void methodB(){
        System.out.println("methodB in B class");
    }

    public String toString() {return "class B";}
}

class InstanceManager{
    public static III getInstance(){
        return new BBB();
    }
}
