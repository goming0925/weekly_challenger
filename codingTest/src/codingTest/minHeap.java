package codingTest;

import java.util.Scanner;

public class minHeap {

	/**
	 * 널리 잘 알려진 자료구조 중 최소 힙이 있다. 최소 힙을 이용하여 다음과 같은 연산을 지원하는 프로그램을 작성하시오.
	 * 1.배열에 자연수 x를 넣는다.
	 * 2.배열에서 가장 작은 값을 출력하고, 그 값을 배열에서 제거한다.
	 * 프로그램은 처음에 비어있는 배열에서 시작하게 된다.
	 * 
	 * 입력
	 * 첫째 줄에 연산의 개수 N(1 ≤ N ≤ 100,000)이 주어진다. 
	 * 다음 N개의 줄에는 연산에 대한 정보를 나타내는 정수 x가 주어진다. 
	 * 만약 x가 자연수라면 배열에 x라는 값을 넣는(추가하는) 연산이고, x가 0이라면 배열에서 가장 작은 값을 출력하고 그 값을 배열에서 제거하는 경우이다. 
	 * x는 2^31보다 작은 자연수 또는 0이고, 음의 정수는 입력으로 주어지지 않는다.
	 * 
	 * 출력
	 * 입력에서 0이 주어진 횟수만큼 답을 출력한다. 만약 배열이 비어 있는 경우인데 가장 작은 값을 출력하라고 한 경우에는 0을 출력하면 된다.
	 * 
	 * 
	 * 예제					예제출력					해석
	 * 9												연산의 개수는 9
	 * 0					0							최소힙 추출	-> 배열이 비어있음
	 * 12345678											12345678을 추가
	 * 1												1을 추가
	 * 2												2를 추가
	 * 0					1							최소힙 추출 -> [1, 2, 12345678] 중 1을 출력 후 1 삭제
	 * 0					2							최소힙 추출 -> [2, 12345678] 중 2를 출력 후 2 삭제
	 * 0					12345678					최소힙 추출 -> [12345678] 중 12345678 출력 후 12345678 삭제
	 * 0					0							최소힙 추출 -> 배열이 비어있음
	 * 32												32를 추가
	 * 
	 * 부모노드의 위치 = 자식노드의 위치/2
	 * 최소 힙이므로 부모노드가 자식노드보다 작아야함
	 */
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		sortHeap heap = new sortHeap(100001);	// 100,000의 배열을 생성하는게 아닌 이유는? -> insert시 root 노드의 위치가 1이기 때문
		int processNumber = scanner.nextInt();
		
		for (int i = 0; i < processNumber; i++) {
			int input = scanner.nextInt();
			if (input > 0) {			// 자연수 입력시
				heap.insert(input);		// 배열에 값 추가 후 최소힙정렬
			} else if (input == 0) {				// 0 입력시
				System.out.println(heap.delete());	// 최소값 추출 후 값 삭제 후 최소힙정렬						
			}
		}
		scanner.close();
	}

}

class sortHeap {
	
	int heap[];
	int size;
	
	public sortHeap(int size) {
		heap = new int[size];
	}
	
	public void insert(int inputNumber) {
		heap[++size] = inputNumber;
		for (int i = size; i > 1; i /= 2) {
			if (heap[i/2] > heap[i]) {
				swap(i/2, i);
			}
			else {
				break;
			}
		}
	}
	
	public int delete() {
		if (size == 0) {
			return 0;	// heap배열 내의 사이즈가 0
		}
		
		int rootValue = heap[1];	// insert를 할때 i/2의 최소값이 1이며 root 노드의 위치값
		heap[1] = heap[size];		// Extract-Min 수행을 위해 마지막노드와 root 노드 변경
		size--;						// 기존 root 노드를 제외하였으므로 사이즈 감소
		
		for (int i = 1; i*2 <= size;) {								// root노드에서 leaf노드로 진행
			if (heap[i] < heap[i*2] && heap[i] < heap[i*2+1]) {		// 부모노드와 자식노드를 비교하여 부모노드가 더 작을때 (최소힙 만족)
				break;												// 최소힙 만족 조건이므로 멈춤
			} else if (heap[i*2] < heap[i*2+1]) {					// 자식노드가 더 작고 -> 자식 노드 중 좌측 자식 노드가 더 작다면 
				swap(i, i*2);										// 좌측 자식노드를 부모노드와 변경
				i = i*2;											// 기준이 되는 부모노드를 자식노드로 변경 (트리 구조상 레벨이 증가함)
			} else {												// 자식노드가 더 작고 -> 자식 노드 중 우측 자식 노드가 더 작다면
				swap(i, i*2+1);										// 우측 자식노드를 부모노드와 변경	
                i = i*2+1;											// 기준이 되는 부모노드를 자식노드로 변경 (트리 구조상 레벨이 증가함)
			}
		}
		
		return rootValue;
	}
	
	public void swap(int a, int b) {
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }
	
//	public static int[] minHeapCreater(int input) {
//		System.out.println("minHeapCreater = " + input);
//		int[] heapArray = new int[input];
//		return heapArray;
//	}
	
//	public static void minHeapInserter(int[] heapArray, int input) {
//		System.out.println("minHeapInserter = {heapArray : " + Arrays.toString(heapArray) + ", input : " + input);
//		
//		// input값을 넣는 node 위치는 heapArray의 마지막
//		int leafNodeNumber = heapArray.length;
//		
//		// parentNode의 위치는 leafNode/2
//		int parentNodeNumber = leafNodeNumber/2;
//		
//		for (int i = leafNodeNumber; i > 1; i /= 2) {
//			
//		}
//		
//		System.out.println("minHeapInserter = {heapArray : " + Arrays.toString(heapArray) + ", input : " + input);
//	}
	
//	public static int minHeapExtractor(int[] heapArray, int input) {
//		System.out.println("minHeapExtractor = " + input);
//		
//		return 0;
//	}
}
