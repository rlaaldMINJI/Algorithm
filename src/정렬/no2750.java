package 정렬;

import java.util.Scanner;

//n개의 수가 주어졌을 때 오름차순으로 정렬하는 프로그램
//버블소팅 n^2 <-버블정렬
//자바에서는 sort()함수를 이용해 쉽게 정렬할 수 있지만 직접 구현해보기
public class no2750 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   //몇개의 숫자를 받을건지
        int a[] = new int[n];
        for(int i=0 ; i<n;i++){//배열자리수
                a[i] = sc.nextInt(); //배열에 들어갈 값
        }
        //버블 정렬을 구현하는 영역
        for(int i = 0;i<n-1;i++){
            for(int j=0;j<n-1-i;j++){//아직정렬안된 값(이미 정렬된 값들은 돌지않도록)
                if(a[j]>a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
        for(int i=0;i<n;i++){
            System.out.println(a[i]);
        }
    }
}











