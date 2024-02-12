package backjoon.gold;

/*
N개의 수에서 다른 두 수의 합으로 표현되는 수가 있다면 그 수를 '좋은 수'라고 한다.
N개의 수 중 좋은 수가 총 몇 개인지 출력

입력
1번째 줄에 수의 개수 N (1 <= N <= 2,000)
2번째 줄에 N개의 수 값이 주어진다. (|Ai| <= 10^9, A는 정수)

출력
좋은 수의 개수 출력

슈도 코드
int 변수 N 선언 후 입력 받기
int 배열 A[N] 선언

for (0 ~ N) A[N] 값 입력

A 배열 정렬
int 변수 count 선언 후 0으로 초기화

for (x = 0 ~ N) {
    int 정수 i = 0, j = N - 1, find = A[x] 선언 후 각 값으로 초기화
    while (i < j) {
        if (A[i] + A[j] == find)
            두 포인터 i, j가 k가 아니면 결과 증가 후 while 문 종료
            i가 k와 같으면 i 증가, j가 k와 같으면 j 감소 후 반복 문 진행
        else if (A[i] + A[j] > find) j 감소
        else i 증가
    }
}
count 출력
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1253_좋은수구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int count = 0;

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        for (int x = 0; x < N; x++) {
            int i = 0, j = N - 1, find = A[x];

            while (i < j) {
                if (A[i] + A[j] == find) {
                    if (i != x && j != x) {
                        count++;
                        break;
                    } else if (i == x) i++;
                    else j--;
                }
                else if (A[i] + A[j] > find) j--;
                else i++;
            }
        }
        System.out.println(count);
        bf.close();
    }
}
