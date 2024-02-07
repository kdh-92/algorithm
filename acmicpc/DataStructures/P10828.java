package acmicpc.DataStructures;/*

- url: https://www.acmicpc.net/source/11772249 문제 풀이
- BufferedWriter 사용
- br.readLine() 후에 StringTokenizer 대신 contains(), substring()으로 글자 체크

*/

import java.io.*;
class P10828 {
    // 출력을 바꿔서 속도 비교
    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		String[] stack = new String[n];
		int size=0;
		for(int i=0;i<n;i++){
			String command = br.readLine();
			if(command.contains("push")){
				stack[size] = command.substring(5);
				size++;
			}
			else if(command.contains("pop")){
				if(size==0){
					bw.write("-1\n");
				}else{
					bw.write(stack[size-1]);
					bw.newLine();
					size--;
				}
			}
			else if(command.contains("size")){
				bw.write(String.valueOf(size));
                bw.newLine();
			}
			else if(command.contains("empty")){
				if(size==0){
					bw.write("1\n");
				}else{
					bw.write("0\n");
				}
			}
			else if(command.contains("top")){
				if(size==0){
					bw.write("-1\n");
				}else{
					bw.write(stack[size-1]);
					bw.newLine();
				}
			}
		}
		bw.flush();
		bw.close();
	}
}