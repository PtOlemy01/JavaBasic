package ch14;

@FunctionalInterface
interface MyFunction2{
    void myMethod();
}

public class LambdaEx2 {
    public static void main(String[] args) {
        MyFunction f = ()->{};      // MyFunction f = (MyFunction) (()->{});
        Object obj = (MyFunction2)(() -> {});
        String str = ((Object)(MyFunction2)(() -> {})).toString();

        System.out.println(f);
        System.out.println(obj);
        System.out.println(str);

        //System.out.println(()->{}); // 에러. 람다식은 Object 타입으로 형변환 안됨.
        System.out.println((MyFunction2)(() -> {}));
        System.out.println(((Object)(MyFunction2)(() -> {})).toString());
    }
}
