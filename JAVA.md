public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    }
}

# 자바 IO
---
### System.out
- System.out.println();
- System.out.printf("%d", n);
    - 실수형, 문자형 자료 출력 가능

### Scanner
- next[자료형]을 이용해서 입력 받을 수 있고,
- hasNext[자료형]을 이용해서 입력 받을 수 있는 자료형이 있는지 구할 수 있다.

### ex) 두 수 입력
```
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, b;
        a = sc.nextInt();
        b = sc.nextInt();
        System.out.println(a + b);
    }
}
```
- 입력에서 정수가 주어지는 동안 계속 입력 받음
```
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        while(sc.hasNextInt()) {
            sum += sc.nextInt();
        }
        System.out.println(sum);
    }
}
```
- 정수와 문자열 동시 처리
    - 숫자 뒤에 줄바꿈 \n이 존재하기 때문에, 줄바꿈 때문에 글자를 읽지 못한다.
    - nextLine()으로 줄바꿈을 입력받는 코드가 필요하다.
```
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        System.out.println(n + "\n" + s);
    }
}
```

### BufferedReader
- Scanner는 편리하지만 속도가 느리다. 입력을 많이 받아야 하는 경우에는 `BufferedReader` 사용하는 것이 훨씬 좋다.
- bufferedReader에서는 `read와 readLine`만 있기 때문에 정수는 파싱해야한다.
```
input -> 10 20 30 40
result -> 4060

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] line = bf.readLine().split(" ");
        String a = line[0] + line[1];
        String b = line[2] + line[3];
        long result = Long.valueOf(a) + Long.valueOf(b);
        System.out.println(result);
    }
}
```

### StringTokenizer
- 문자열을 토큰으로 잘라야 할 때 사용하면 편함.
- 수 N개의 합을 구하는 문제.
    - 입력받은 수 N개의 합을 출력.
```
input -> 1 2 3 4 5

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line = bf.readLine();
        StringTokenizer st = new StringTokenizer(line, " ");
        int sum = 0;
        while(st.hasMoreTokens())
            sum += Integer.valueOf(st.nextToken());
        System.out.println(sum);
    }
}
```

### StringBuilder
- 출력해야 하는 것이 많은 경우에 매번 출력보다는 `StringBuilder`를 이용해 문자열을 만들고, 한번에 출력하는 것이 속도면에서 좋다.
```
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        for (int i = 1; i <= a; i++)
            System.out.println(i);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= a; a++)
            sb.append(i + "\n");
        System.out.println(sb);
    }
}
```

### String <-> 숫자형 (int, double, float, long, short)
``` java
// String → 숫자형(int, double, float, long, short)

String sNum = "1234";

/*
	방법 1 : 자료형 변수 이름 = 자료형.parse자료형(변수);
	방법 2 : 자료형 변수 이름 = 자료형.valueOf(변수);
*/

// ex
Long l = Long.parseLong(sNum); // or Long.valueOf(sNum);

---

// 숫자형 -> String

int i = 1234;

/*
	방법 1 : String 변수 이름 = String.valueOf(숫자형 변수);
	방법 2 : String 변수 이름 = 숫자형.toString(숫자형 변수);
*/

// ex
float f = (float) 1.23;
String f1 = String.valueOf(f);
String f2 = Float.toString(f);
```