package ch13;

public class ThreadEx4 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 500; i++) {
            System.out.printf("%s", new String("-"));
        }

        System.out.print("소요시간1: " + (System.currentTimeMillis() - startTime));

        for (int j = 0; j < 500; j++) {
            System.out.printf("%s", new String("|"));
        }

        System.out.print("소요시간 2: " + (System.currentTimeMillis() - startTime));
    }
}
