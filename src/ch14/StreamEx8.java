package ch14;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;

public class StreamEx8 {
    public static void main(String[] args) {
        StudentEx7[] stuArr = {
                new StudentEx7("나자바", true, 1, 1, 300),
                new StudentEx7("김지미", false, 1, 1, 250),
                new StudentEx7("김자바", true, 1, 1, 200),
                new StudentEx7("이지미", false, 1, 2, 150),
                new StudentEx7("남자바", true, 1, 2, 100),
                new StudentEx7("안지미", false, 1, 2, 50),
                new StudentEx7("황지미", false, 1, 3, 100),
                new StudentEx7("강지미", false, 1, 3, 150),
                new StudentEx7("이자바", true, 1, 3, 200),

                new StudentEx7("나자바", true, 2, 1, 300),
                new StudentEx7("김지미", false, 2, 1, 250),
                new StudentEx7("김자바", true, 2, 1, 200),
                new StudentEx7("이지미", false, 2, 2, 150),
                new StudentEx7("남자바", true, 2, 2, 100),
                new StudentEx7("안지미", false, 2, 2, 50),
                new StudentEx7("황지미", false, 2, 3, 100),
                new StudentEx7("강지미", false, 2, 3, 150),
                new StudentEx7("이자바", true, 2, 3, 200)
        };

        System.out.printf("1. 단순그룹화(반별로 그룹화) %n");
        Map<Integer, List<StudentEx7>> stuByBan = Stream.of(stuArr)
                .collect(groupingBy(StudentEx7::getBan));

        for(List<StudentEx7> ban : stuByBan.values()){
            for(StudentEx7 s : ban){
                System.out.println(s);
            }
        }

        System.out.println("%n2. 단순그룹화(성적별로 그룹화)%n");
        Map<StudentEx7.Level, List<StudentEx7>> stuByLevel = Stream.of(stuArr)
                .collect(groupingBy(s->{
                    if(s.getScore() >= 200) return StudentEx7.Level.HIGH;
                    else if(s.getScore() >= 100) return StudentEx7.Level.MID;
                    else return StudentEx7.Level.LOW;
                }));

        TreeSet<StudentEx7.Level> keySet = new TreeSet<>(stuByLevel.keySet());

        for(StudentEx7.Level key : keySet){
            System.out.println("[" + key + "]");

            for(StudentEx7 s : stuByLevel.get(key))
                System.out.println(s);
            System.out.println();
        }

        System.out.printf("%n3. 단순그룹화 + 통계(성적별 학생수)%n");
        Map<StudentEx7.Level, Long> stuCntByLevel = Stream.of(stuArr)
                .collect(groupingBy(s->{
                    if(s.getScore() >= 200) return StudentEx7.Level.HIGH;
                    else if(s.getScore() >= 100) return StudentEx7.Level.MID;
                    else return StudentEx7.Level.LOW;
                },counting()));

        for(StudentEx7.Level key : stuCntByLevel.keySet())
            System.out.printf("[%s] - %d명, ", key, stuCntByLevel.get(key));
        System.out.println();

        System.out.printf("%n4. 다중그룹화(학년별, 반별)%n");
        Map<Integer, Map<Integer, List<StudentEx7>>> stuByHakAndBan =
                Stream.of(stuArr)
                        .collect(groupingBy(StudentEx7::getHak,
                                groupingBy(StudentEx7::getBan)
                        ));

        for(Map<Integer, List<StudentEx7>> hak : stuByHakAndBan.values()){
            for(List<StudentEx7> ban : hak.values()){
                System.out.println();
                for(StudentEx7 s :ban)
                    System.out.println(s);
            }
        }

        System.out.printf("%n5. 다중그룹화 + 통계(학년별, 반 1등) %n");
        Map<Integer, Map<Integer, StudentEx7>> topStuByHakAndBan =
                Stream.of(stuArr)
                        .collect(groupingBy(StudentEx7::getHak,
                                groupingBy(StudentEx7::getBan,
                                        collectingAndThen(
                                                maxBy(comparingInt(StudentEx7::getScore)),
                                                Optional::get
                                        )
                                )
                        ));

        for(Map<Integer, StudentEx7> ban : topStuByHakAndBan.values()){
            for(StudentEx7 s: ban.values())
                System.out.println(s);
        }

        System.out.printf("%n6. 다중그룹화 + 통계(학년별, 반별 성적그룹)%n");
        Map<String, Set<StudentEx7.Level>> stuByScoreGroup = Stream.of(stuArr)
                .collect(groupingBy(s->s.getHak() + "-" + s.getBan(),
                        mapping(s ->{
                            if(s.getScore() >= 200) return StudentEx7.Level.HIGH;
                            else if(s.getScore() >= 100) return StudentEx7.Level.MID;
                            else return StudentEx7.Level.LOW;
                        },toSet())
                ));

        Set<String> keySet2 = stuByScoreGroup.keySet();

        for(String key : keySet2){
            System.out.println("[" + key + "]" + stuByScoreGroup.get(key));
        }


    }
}
