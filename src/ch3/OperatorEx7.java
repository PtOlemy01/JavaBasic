package ch3;

public class OperatorEx7 {
    public static void main(String[] args) {
        byte a = 10;
        byte b = 30;
        byte c = (byte)(a * b); // 자료형이 너무 작아 손실 발생. 300이 나오지 않음.
        System.out.println(c);
    }
}
