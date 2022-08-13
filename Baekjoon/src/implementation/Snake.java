// 풀이: snake는 deque로 쌓는다. 이동시 위치를 추가하고 사과 안먹었을 때 선입선출로 하나씩 빼줌.
//		초 되면 이동함. 이동시키는 건 dx, dy 정의해놓고 차이를 추가해줌. 
// 		회전 시에는 rotate함수를 이용해서 방향을 바꿔줌. 
//어려웠던 점: 1. snake에서 좌표를 array로 넣다보니 비교하기가 어려웠음(파이썬은 쉬운뎅 ㅠ)
//			2. 중첩 반복문에서 안쪽 반복문에서 전체반복문을 나가는 법: Loop1:이런식으로 이름 지정해주고 break Loop1;으로 나가기.
//			3. 다음에 다시 짠다면 snake에서 point를 class로 만들 것 같다. 


package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Snake {
	
	static int rotate(String rotation, int direction) {
		if (rotation.equals("L")) direction -= 1;
		else direction += 1;
		
		if (direction == -1) direction = 3;
		else if (direction == 4) direction = 0;
		
		return direction;
	}

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		
		int[][] apples = new int[N][N];
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			
			apples[row-1][col-1] = 1;
		}
		
		int L = Integer.parseInt(br.readLine());
		
		int x = 0;
		int y = 0;
		
//		LURD
		int[] dx = {0, -1, 0, 1};
		int[] dy = {-1, 0, 1, 0};
		
		Deque<int[]> snake = new ArrayDeque<>();
		Queue<Integer> second = new LinkedList<>();
		Queue<String> rotation = new LinkedList<>();
		snake.add(new int[] {1, 1});
		
		int direction = 2;
		int totalTime = 0;
		
		for (int i = 0; i < L; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			second.add(Integer.parseInt(st.nextToken()));
			rotation.add(st.nextToken());
		}
		
		int sec = second.remove();
		Loop1:
		while (true) {
			totalTime++;
			
			x += dx[direction];
			y += dy[direction];
			
			if ((x < 0) | (N <= x) | (y < 0) | (N <= y)) {
				break;
			}
			for (int[] s : snake) {
				if ((s[0] == x) && (s[1] == y)) {
					break Loop1;
				}
			}
			
			
			snake.add(new int[] {x, y});
			if (apples[x][y] == 0) {
				snake.remove();
			} else {
				apples[x][y] = 0;
			}
			
			if (totalTime == sec) {
				String rot = rotation.remove();
				direction = rotate(rot, direction);
				if (second.size() > 0) {
					sec = second.remove();
				}
			}
		}
		
		System.out.println(totalTime);
		
	}

}
