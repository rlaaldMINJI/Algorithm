package 정렬;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

//나이순 정렬
//arrays sort -> 배열 정렬하기

//설명참고 - https://st-lab.tistory.com/243
//comparable,comparator은 모두 interface -> 객체 비교 인터페이스
//->즉 interface내 선언된 메소드를 '반드시 구현'
//comparable -> compareTo(T o) 메소드 선언 -> 매개변수 하나 왜? 자기자신과 매개변수 객체를 비교(파라미터로 들어오는 객체를 자기자신과 비교)
//comparator -> compare(T o1,T o2) 메소드 선언 -> 두 매개변수 객체를 비교

public class no10814 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String [][]a = new String[n][2];

        for(int i=0;i<n;i++){
            a[i][0] = sc.next();
            a[i][1] = sc.next();
        }

        //양수면 체인지
        //음수거나 0이면 그대로
        Arrays.sort(a, new Comparator<String[]>() {
            @Override
            public int compare(String o1[], String o2[]) {
                return Integer.parseInt(o1[0])-Integer.parseInt(o2[0]);
            }
        });

        for(int i =0;i<n;i++){
            System.out.println(a[i][0]+ " "+a[i][1]);
        }
    }
}



