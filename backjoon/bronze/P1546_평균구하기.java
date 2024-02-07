package backjoon.bronze;

import java.util.Scanner;

/*
문제
자기 점수 중 최댓값을 고른다. 최댓값을 M이라 할 때 모든 점수를 점수 / M * 100으로 고쳤다.
ex) 최고점 70, 수학 50점 => 50/70*100 => 71.43

이 방법으로 계산했을 때 새로운 평균을 구하는 프로그램을 작성

입력
1번째 줄에 시험을 본 과목의 개수 N이 주어진다. N은 1000보다 작거나 같다.
2번째 줄에 현재 성적이 주어진다. 해당 값은 100보다 작거나 같은, 음이 아닌 정수이고, 적어도 1개의 값은 0보다 크다.

츨력
새로운 평균을 출력한다.

슈도코드
변수 N에 과목의 수 입력받기
길이 N인 1차원 배열 A[] 선언
for (A[].length) {
A[] 각 점수 저장
}

최고 점수 기록에 필요한 int형 변수 max 선언
점수 누적에 필요한 int형 변수 sum 선언 및 초기화

for (A[].length) {
점수를 비교해 최고점을 max에 입력
각 점수를 sum에 누적하여 더한다.
}

sum * 100 / max / N 출력하기
 */
public class P1546_평균구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];

        for (int i = 0; i < A.length; i++) {
            A[i] = sc.nextInt();
        }

        int max = 0;
        int sum = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] > max) max = A[i];
            sum += A[i];
        }

        System.out.println(sum * 100.0 / max / N);
    }
}
