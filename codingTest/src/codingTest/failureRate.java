package codingTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class failureRate {
	
	/**
	 * 실패율 = (스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수) / (스테이지에 도달한 플레이어 수)
	 * 
	 * 
	 * 전체 스테이지의 개수 N, 게임을 이용하는 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열 stages가 매개변수로 주어질 때, 실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 배열을 return 하도록 solution 함수를 완성
	 * 
	 * 제한사항
	 * 1. 스테이지의 개수 N은 1 이상 500 이하의 자연수이다.
	 * 2. stages의 길이는 1 이상 200,000 이하이다.
	 * 3. stages에는 1 이상 N + 1 이하의 자연수가 담겨있다.
	 * 	3-1. 각 자연수는 사용자가 현재 도전 중인 스테이지의 번호를 나타낸다.
	 * 	3-2. 단, N + 1 은 마지막 스테이지(N 번째 스테이지) 까지 클리어 한 사용자를 나타낸다.
	 * 4. 만약 실패율이 같은 스테이지가 있다면 작은 번호의 스테이지가 먼저 오도록 하면 된다.
	 * 5. 스테이지에 도달한 유저가 없는 경우 해당 스테이지의 실패율은 0 으로 정의한다.
	 * 
	 */

	public static int[] solution(int N, int[] stages) {
		int[] answer = new int[N]; // 배열의 길이는 N
		
		double tryCnt = 0;
		double failureCnt = 0;
		double failureRate;
		Map<Integer,Double> map = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < stages.length; j++) {
				if (stages[j] == (i+1)) {
					failureCnt++;
				}
				if (stages[j] >= (i+1)) {
					tryCnt++;			
				}
			}
			
			// 실패율
			if (tryCnt == 0) {
				// 스테이지에 도달한 유저가 없는 경우 실패율은 0
				failureRate = 0;
			} else {
				failureRate = failureCnt / tryCnt;
				System.out.println("failureCnt = " + failureCnt + ", tryCnt = " + tryCnt);
				System.out.println("stageNbr = " + (i + 1) + ", failureRate = " + failureRate);				
			}
			
			map.put(i+1, failureRate);
			
			// 초기화
			tryCnt = 0;
			failureCnt = 0;
			failureRate = 0;
		}
		
		System.out.println("map = " + map);
		
		for (int i = 0; i < N; i++) {
			// 키값은 1이상이므로 1 미만의 값을 기본으로 가지면 최저로 시작
			int 	tempMaxKey = 0;
			// 밸류값은 0이상이므로 0 미만의 값을 기본으로 가지면 최저로 시작
			double tempMaxValue = -1;
			for (int key : map.keySet()) {
				if (map.get(key) > tempMaxValue) {
					tempMaxValue = map.get(key);
					tempMaxKey = key;
				}
			}
			answer[i] = tempMaxKey;	// map의 value 값이 제일 높거나 (같을 경우 작은 번호인) stage 값을 배열에 저장
			map.remove(tempMaxKey);
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		int N = 5;
		int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
//		int[] stages = {4, 4, 4, 4, 4};
		
		int[] answer = solution(N, stages);
		System.out.println("result : " + Arrays.toString(answer));
	}
}
