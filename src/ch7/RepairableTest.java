package ch7;

public class RepairableTest {
    public static void main(String[] args) {
        Tank tank = new Tank();
        Dropship dropship = new Dropship();

        Marine marine = new Marine();
        SCV scv = new SCV();

        scv.repair(tank);
        scv.repair(dropship);
        // scv.repair(marine); 에러!!
    }
}

interface Repairable{}
class GroundUnit extends Unit5{
    GroundUnit(int hp){
        super(hp);
    }
}

class AirUnit extends Unit5{
    AirUnit(int hp){
        super(hp);
    }
}

class Unit5{
    int hitpoint;
    final int MAX_HP;
    Unit5(int hp){
        MAX_HP = hp;
    }
    // ...
}

class Tank extends GroundUnit implements Repairable{
    Tank(){
        super(150);     // Tank의 HP는 150이다.
        hitpoint = MAX_HP;
    }

    public String toString(){
        return "Tank";
    }
    // ...
}

class Dropship extends AirUnit implements Repairable{
    Dropship(){
        super(125);
        hitpoint = MAX_HP;
    }

    public String toString(){
        return "Dropship";
    }
    // ...
}

class Marine extends GroundUnit{
    Marine(){
        super(40);
        hitpoint = MAX_HP;
    }
    // ...
}

class SCV extends GroundUnit implements Repairable{
    SCV(){
        super(60);
        hitpoint = MAX_HP;
    }

    void repair(Repairable r){
        if(r instanceof Unit5){
            Unit5 u = (Unit5)r;
            while(u.hitpoint != u.MAX_HP){
                /* Unit의 HP를 증가시킨다. */
                u.hitpoint++;
            }
            System.out.println(u.toString() + "의 수리가 끝났습니다.");
        }
    }
}