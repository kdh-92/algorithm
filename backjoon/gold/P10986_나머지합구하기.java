package backjoon.gold;

/* 시간제한 1초
N개의 수가 주어졌을 때 연속된 부분의 합이 M으로 나누어떨어지는 구간의 개수를 구하는 프로그램을 작성
Ai ~ Aj (i <= j)의 합이 M으로 나누어떨어지는 (i, j) 쌍의 개수 구하기

입력
1번째 줄에 N과 M(1 <= N <= 10^6, 2 <= M <= 10^3)
2번째 줄에 N개의 수 A1, A2, ~ , AN이 주어진다. (0 <= A <= 10^9)

출력
1번째 줄에 연속된 부분의 합이 M으로 나누어떨어지는 구간의 개수를 출력한다.

핵심
경우의 수
1. 구간합이 M으로 0으로 나눠 떨어진다.
2. M[i] = M[j] (M = 구간합을 M으로 나눈 나머지 저장 배열)
2_1. 나머지가 같은 개수끼리의 구간합은 M으로 나누면 0으로 떨어진다.
2_2. 2번의 경우의 수 구하는 공식은 nC2가 된다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10986_나머지합구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());

        long[] S = new long[N];
        long[] T = new long[M];
        long cnt = 0;

        S[0] = Integer.parseInt(st.nextToken());
        // 배열 A 값 채우기
        for (int i = 1; i < N; i++) {
            S[i] = S[i - 1] + Integer.parseInt(st.nextToken());;
        }

        for (int i = 0; i < N; i++) {
            int remainder = (int) (S[i] % M);

            if (remainder == 0) cnt++;
            T[remainder]++;
        }

        for (int i = 0; i < M; i++) {
            if (T[i] > 1) {
                cnt += T[i] * (T[i] - 1) / 2;
            }
        }

        System.out.println(cnt);
    }
}
