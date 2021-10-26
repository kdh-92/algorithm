// 10828 Stack
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        
        Stack s = new Stack(N);
        
        while(N-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");

            switch(st.nextToken()) {
                case "push":
                    s.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(s.pop()).append('\n');
                    break;
                case "size":
                    sb.append(s.size()).append('\n');
                    break;
                case "empty":
                    sb.append(s.empty()).append('\n');
                    break;
                case "top":
                    sb.append(s.top()).append('\n');
                    break;
            }
        }
        System.out.println(sb);
    }
}

class Stack {
    int size = 0;
    int stack[];
    public Stack(int size) {
        this.stack = new int[size];
    }
    

    void push(int item) {
        this.stack[size] = item;
        size++;
    }

    int pop() {
        if (size == 0) return -1;
        else {
            int res = this.stack[size - 1];
            this.stack[size - 1] = 0;
            size--;
            return res;
        }
    }

    int size() {
        return size;
    }

    int empty() {
        if (size == 0) return 1;
        else return 0;
    }

    int top() {
        if (size == 0) return -1;
        else return this.stack[size - 1];
    }
}

