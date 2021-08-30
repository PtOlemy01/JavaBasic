package ch7;

class AA{
    void autoPlay(I i){
        i.play();
    }
}

interface I{
    public abstract void play();
}

class BB implements I{

    @Override
    public void play() {
        System.out.println("Play in B class");
    }
}

class CC implements I{

    @Override
    public void play() {
        System.out.println("Play in C class");
    }
}

public class InterfaceTest2 {
    public static void main(String[] args) {
        AA a = new AA();
        a.autoPlay(new BB());
        a.autoPlay(new CC());
    }
}
