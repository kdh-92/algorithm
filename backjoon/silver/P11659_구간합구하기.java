package backjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
수 N개가 주어졌을 때 i 번째 수에서 j 번째 수까지의 합을 구하는 프로그램 작성

입력
1번째 줄에 수의 개수 N(1 <= N <= 100,000), 합을 구해야 하는 횟수 M(1 <= M <= 100,000)
2번째 줄에 N개의 수가 주어진다. 각 수는 1,000보다 작거나 같은 자연수다.
3번째 줄부터는 M개의 줄에 합을 구해야 하는 구간 i와 j가 주어진다.

출력
총 M개의 줄에 각 합을 출력한다.

수의 개수와 합을 구해야하는 횟수는 최대 100,000이다.
구간마다 합을 매번 계산하여 0.5초 안에 모든 구간 합 계산을 해야하는데 어렵다.
=> 구간 합 이용

슈도코드
nCnt(숫자 개수), quizCnt(질의 개수) 저장하기
합 배열 S[nCnt + 1] 선언
for (nCnt) {
합 배열 생성 S[i] = S[i - 1] + A[i])
}

for (quizCnt) {
질의 범위 각 i, j 변수에 저장
구간 합 출력 S[j] - S[i - 1]
}
 */
public class P11659_구간합구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int nCnt = Integer.parseInt(st.nextToken());
        int quizCnt = Integer.parseInt(st.nextToken());
        long[] S = new long[nCnt + 1];
        st = new StringTokenizer(bf.readLine());

        for (int i = 1; i <= nCnt; i++) {
            S[i] = S[i - 1] + Integer.parseInt(st.nextToken());
        }

        for (int x = 0; x < quizCnt; x++) {
            st = new StringTokenizer(bf.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            System.out.println(S[j] - S[i - 1]);
        }
    }
}
