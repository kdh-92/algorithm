package backjoon.silver;

/*
갑옷을 만들기 위한 재료들에 각각 고유한 번호가 있고, 갑옷 1개 만드는데 2개의 재료로 만들어진다.
2개의 재료의 고유 번호를 합쳐 M(1 <= M <= 10^7)이 되면 갑옷이 만들어질 수 있다.
자신이 가진 재료로 갑옷을 몇 개를 만들 수 있는지 궁금해졌다.
N(1 <= N <= 15,000)개의 재료와 M이 주어졌을 때 몇 개의 값옷을 만들 수 있는지를 구하는 프로그램을 작성

입력
1번째 줄에 재료의 개수 N(1 <= N <= 15,000)
2번째 줄에 갑옷을 만드는데 필요한 수 M(1 <= M <= 10^7)이 주어진다.
3번째 줄에는 N개의 재료들이 가진 고유한 번호들이 공백을 사이에 두고 주어진다. (고유 번호는 10^5보다 작거나 같은 자연수다.)

출력
갑옷을 만들 수 있는 개수를 출력한다.

문제 분석
시간 복잡도 : 두 재료의 번호 합 (M)을 비교하므로 값을 정렬하면 쉽게 풀 수 있다.
N의 최대 범위가 15,000이므로 O(nlogn) 시간 복잡도라면 괜찮다. (일반 정렬 알고리즘 시간 복잡도는 O(nlogn)이다.)
N 개의 재룟값을 정렬 후 양쪽 끝의 투 포인터를 지정해 풀 수 있다.

슈도 코드
int 정수 N 입력 받기
int 정수 M 입력 받기
int 배열 A[N] 선언
for (0 ~ N) {
    배열 A[N] 입력 받기
}
A 배열 정렬하기
int 정수 i 선언 후 0으로 초기화
int 정수 j 선언 후 N - 1로 초기화
int 정수 count 선언 후 0으로 초기화
while (i < j) {
    if (A[i] + A[j] == M) {
        count++;
        i++;
        j--;
    }
    else if (A[i] + A[j] > M) j--;
    else i++;
}
count 출력
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1940_주몽의명령 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);
        int i = 0, j = N - 1, count = 0;

        while (i < j) {
            if (A[i] + A[j] == M) {
                count++;
                i++;
                j--;
            }
            else if (A[i] + A[j] > M) j--;
            else i++;
        }

        System.out.println(count);
        bf.close();
    }
}
