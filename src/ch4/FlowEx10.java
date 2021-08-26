package ch4;

import java.util.Scanner;

public class FlowEx10 {
    public static void main(String[] args) {
        int score = 0; // 점수를 저장하기 위한 변수
        char grade = ' ' ; // 학점을 저장하기 위한 변수. 공백으로 초기화한다.

        System.out.print("접수를 입력하세요.(1-100)>");

        Scanner scanner = new Scanner(System.in);
        String tmp = scanner.nextLine();
        score = Integer.parseInt(tmp);

        switch (score / 10){
            case 10 :
            case 9:
                grade = 'A';
                break;
            case 8:
                grade = 'B';
                break;
            case 7 :
                grade = 'C';
                break;
            default:
                grade = 'F';
        } // end of switch

        System.out.println("당신의 학점은 " + grade + "입니다.");
    } // main 의 끝
}
