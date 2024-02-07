package backjoon.bronze;

import java.util.Scanner;

/*
입력
1번째 줄에 숫자의 개수 N(1 <= N <= 100), 2번째 줄에 숫자 N개가 공백 없이 주어진다.

출력
입력으로 주어진 숫자 N개의 합을 출력한다.

슈도코드
N값 입력받기
길의 N의 숫자를 입력 받아 String형 변수 sNum에 저장하기
char[] 배열 cNum에 sNum 변수 변환하여 저장
int형 변수 sum 선언 및 초기화
for (cNum.lenght) {
배열 각 자릿값을 정수형으로 변환하여 sum에 누적으로 더하기
}
sum 출력
 */
class P11720_숫자의합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String sNum = sc.next();
        char[] cNum = sNum.toCharArray();
        int sum = 0;

        for (int i = 0; i < cNum.length; i++) {
            sum += cNum[i] - '0';
        }

        System.out.println(sum);
    }
}