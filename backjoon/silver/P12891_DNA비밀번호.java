package backjoon.silver;

/*
DNA 문자열 - 모든 문자열에 등장하는 문자가 {'A','C','G','T'}인 문자열
부분 문자열을 뽑을 때 "AAAA" 같이 보안에 취약할 수 있기 때문에 부분 문자열에서 등장하는 문자의 개수가 특정 개수 이상이어야 한다.

입력
1번째 줄에 민호가 임의로 만든 DNA 문자열의 길이 |S|와 비밀번호로 사용할 부분 문자열 길이 |P|가 주어진다. (1 <= |P| <= |S| <= 10^6)
2번째 줄에는 임의로 만든 DNA 문자열이 주어진다.
3번재 줄에 부분 문자열에 포함돼야 할 {'A','C','G','T'}의 최소 개수가 공백 문자를 사이에 두고 주어진다.
각가의 수는 |S|보다 작거나 같은 음이 아닌 정수로 총합은 |S|보다 작거나 같다는 것이 보장된다.

출력
좋은 수의 개수 출력

해결 방법
슬라이딩 윈도우 (2개의 포인터로 범위를 지정한 다음 범위를 유지한 채 이동하며 문제 해결)

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P12891_DNA비밀번호 {
    static int[] checkArr;
    static int[] nowArr;
    static int checkSecret;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        char[] A = bf.readLine().toCharArray();
        int count = 0;
        checkSecret = 0;
        checkArr = new int[4];
        nowArr = new int[4];
        st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
            if (checkArr[i] == 0) checkSecret++;
        }

        for (int i = 0; i < P; i++) {
            Add(A[i]);
        }

        if (checkSecret == 4) count++;

        for (int i = P; i < S; i++) {
            Add(A[i]);
            Remove(A[i - P]);
            if (checkSecret == 4) count++;
        }

        System.out.println(count);
    }

    public static void Add(char c) {
        switch (c) {
            case 'A':
                nowArr[0]++;
                if (checkArr[0] == nowArr[0]) checkSecret++;
                break;
            case 'C':
                nowArr[1]++;
                if (checkArr[1] == nowArr[1]) checkSecret++;
                break;
            case 'G':
                nowArr[2]++;
                if (checkArr[2] == nowArr[2]) checkSecret++;
                break;
            case 'T':
                nowArr[3]++;
                if (checkArr[3] == nowArr[3]) checkSecret++;
                break;
        }
    }

    public static void Remove(char c) {
        switch (c) {
            case 'A':
                if (checkArr[0] == nowArr[0]) checkSecret--;
                nowArr[0]--;
                break;
            case 'C':
                if (checkArr[1] == nowArr[1]) checkSecret--;
                nowArr[1]--;
                break;
            case 'G':
                if (checkArr[2] == nowArr[2]) checkSecret--;
                nowArr[2]--;
                break;
            case 'T':
                if (checkArr[3] == nowArr[3]) checkSecret--;
                nowArr[3]--;
                break;
        }
    }
}


