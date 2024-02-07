package backjoon.silver;

/*
N x N 개의 수가 크기에 맞게 표로 채워져 있다. 표 안의 수 중 Xn, Yn ~ Xy Yy 까지의 합을 구하려 한다.

입력
1번째 줄에 표의 크기 N과 합을 구해야하는 횟수 M이 주어진다. (1 <= N <= 1024, 1 <= M <= 100,0000
2번째 줄부터 N개의 줄에 표에 채워질 수가 1행부터 차례대로 주어진다.
다음 M개의 줄에는 4개의 정수 X1, X2, Y1, Y2가 주어진다.

출력
각 M에 입력된 (X1, Y1) ~ (X2, Y2)의 합을 구해 출력해야 한다.

슈도코드

int형 변수 N, M을 선언 후 입력 받는다.
int형 2차원 배열 A[N + 1][N + 1] 선언

for (1 ~ N) {
for (1 ~ N) {
각 입력을 A[i][j]에 입력하기
}
}

int형 2차원 배열 D[N+1][N+1] 선언
for (1 ~ N) {
for (1 ~ N) {
D[i][j] = D[i][j-1] + D[i-1][j] - D[i-1][j-1] + A[i][j]
}
}

for (0 ~ M) {
각 x1, y1, x2, y2 변수에 입력
int sum 에 D[x2][x2] - D[x1 - 1][y2] - D[x2][y1 - 1] + D[x1 - 1][y1 - 1];
sum 출력
}
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11660_구간합구하기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] A = new int[N + 1][N + 1];
        int[][] D = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 1; j <= N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                D[i][j] = D[i-1][j] + D[i][j-1] - D[i-1][j-1] + A[i][j];
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int sum = D[x2][y2] - D[x1 - 1][y2] - D[x2][y1 - 1] + D[x1 - 1][y1 - 1];
            System.out.println("sum = " + sum);
        }
    }
}
