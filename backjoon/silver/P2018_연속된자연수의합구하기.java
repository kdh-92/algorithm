package backjoon.silver;

/*
자연수 N은 몇 개의 연속된 자연수의 합으로 나타낼 수 있다. (1<= N <= 10^7)을 몇 개의 자연수의 합으로 나타내는 가짓수를 알고 싶다.
N을 입력받아 연속된 자연수의 합으로 나타내는 가짓수를 출력하는 프로그램 작성

입력
1번째 줄에 정수 N이 주어진다.

출력
가짓수 출력

슈도 코드
N 입력 받기
사용 변수 초기화 (count = 1, start_idx = 1, end_idx = 1, sum = 1)
while (end_idx != N)
    if (sum == N) count 증가 & start_idx 증가 & end_idx 감소
    else if (sum > N) end_idx 감소
    else start_idx 증가 (sum < N)
}
count 출력
 */

import java.util.Scanner;

public class P2018_연속된자연수의합구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 1, start_idx = 1, end_idx = 1, sum = 1;

        while (end_idx != N) {
            if (sum == N) {
                count++;
                sum += ++end_idx;
            } else if (sum < N) sum += ++end_idx;
            else sum -= start_idx++;
        }

        System.out.println(count);
    }
}
