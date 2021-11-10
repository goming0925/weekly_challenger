package codingTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class networkSearching {

	public static int solution(int n, int[][] computers) {
        int answer = 0;
        
        boolean[] check = new boolean[n];	// 초기값 false
        
        for (int i = 0; i < n; i++) {
        	if (check[i] == false) {	// check 배열을 돌면서 탐색하지 않은 노드가 있을 경우 해당 노드로 탐색 -> 새로운 네트워크 형성 -> 네트워크 내의 컴퓨터들은 check값이 true
        		
        		dfs(computers, answer, check);
        		answer++;
        	}
        }
        
        return answer;
    }
	
	public static void dfs(int[][] computers, int i, boolean[] check) {
		// 재귀함수를 쓰면 stack 자료형과 같은 효과를 본다.
		check[i] = true;	// 기준이 되는 컴퓨터는 탐색완료
		for (int j = 0; j < computers.length; j++) {	// 컴퓨터 전체 반복
			if (i != j 	// i는 기준이 되는 컴퓨터의 위치 != j는 현재 찾은 컴퓨터의 위치 : 기준이 되는 컴퓨터가 아닐경우
					&& computers[i][j] == 1 	// 기준이 되는 컴퓨터와 연결(1)이 되어있다.
					&& check[j] == false) {		// 탐색되지 않은 컴퓨터이다.
				dfs(computers, j, check);	// 탐색되지 않은 컴퓨터를 기준으로 다시 재귀
			}
		}
		
//		return check;
	}
	
	public static void main(String[] args) {
		int[][] computers = {{1,1,0},{1,1,0},{0,0,1}};
		int n = 3;
		
		solution(n, computers);
	}
}
