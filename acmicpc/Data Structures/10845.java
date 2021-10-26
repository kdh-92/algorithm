/* 

"back" 명령어 구현 방법 관련

Queue<Integer> queue = new LinkedList<Integer>();
위에 방법 사용 시에는 back 변수를 사용하여 구현 가능하다.

LinkedList<Integer> queue = new LinkedList<Integer>();
위에 방법 사용 시에는 getLast() 값을 이용하면 구현 가능하다.

*/

import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<Integer>();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int back = -1;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            switch(st.nextToken()) {
                case "push":
                    back = Integer.parseInt(st.nextToken());
                    queue.offer(back);
                    break;
                case "pop":
                    sb.append(queue.isEmpty() ? "-1" : queue.poll()).append("\n");
                    break;
                case "size":
                    sb.append(queue.size() + "\n");
                    break;
                case "empty":
                    sb.append(queue.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "front":
                    sb.append(queue.isEmpty() ? -1 : queue.peek()).append("\n");
                    break;
                case "back":
                    sb.append(queue.isEmpty() ? -1 : back).append("\n");
                    break;
            }
        }
        System.out.print(sb);
   }
}