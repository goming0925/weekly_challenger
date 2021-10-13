package codingTest;

import java.util.Arrays;

public class kthNumber {
	/**
	 * 배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구함
	 * 배열 array, 커맨드[i, j, k] 부여
	 * 2차원 배열의 커맨드가 주어질때 순차적 연산 적용
	 * 
	 * ==============정렬 구현하기==============
	 * 
	 * 제한사항
	 * 1. array의 길이는 1 이상 100 이하입니다.
	 * 2. array의 각 원소는 1 이상 100 이하입니다.
	 * 3. commands의 길이는 1 이상 50 이하입니다.
	 * 4. commands의 각 원소는 길이가 3입니다.
	 * 
	 * 예시)
	 * array						commands								return
	 * [1, 5, 2, 6, 3, 7, 4]		[[2, 5, 3], [4, 4, 1], [1, 7, 3]]		[5, 6, 3]
	 * 커맨드의 각 항목당 연산 수행을 통해 배열 [5, 6, 3] 반환
	 */
	
	public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int index = 0;
        
        for (int[] command : commands) {
        	int tempArrayStart = command[0] - 1;	// 배열 시작점 i
        	int tempArrayEnd = command[1] - 1;		// 배열 종료점 j
        	int tempArrayLength = command[1] - command[0] + 1; 	// 배열의 길이
        	int kthNumber = command[2]-1;				// 정렬된 배열의 지정 주소값
        	int[] tempArray = new int[tempArrayLength];	// 계산용 배열의 길이만큼 생성
        	
        	int j = 0;
        	for (int i = tempArrayStart; i <= tempArrayEnd; i++) {
        		tempArray[j++] = array[i];
        	}
        	System.out.println(Arrays.toString(tempArray));
        	
        	//sort 함수실행 후 kthNumber 번째 숫자 반환
        	System.out.println("sort -> " + Arrays.toString(sort(tempArray)));
        	tempArray = sort(tempArray);
        	answer[index++] = tempArray[kthNumber];
        }
        
        
        return answer;
    }
	
	public static int[] sort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int baseValue = array[i];
			int j;
			for (j = i-1; j >= 0 && array[j] > baseValue; j--) {
				array[j+1] = array[j];
			}
			array[j+1] = baseValue;
		}
		
		
		return array;
	}
	
	public static void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
		System.out.println(Arrays.toString(array));
	}
	
	public static void main(String[] args) {
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		
		int[] answer = solution(array, commands);
		System.out.println(Arrays.toString(answer));
	}
}
