package codingTest;

import java.util.Arrays;
import java.util.Random;

public class kthNumber2 {
	/**
	 * 주어진 배열에서 k번째로 큰 수를 찾아 반환
	 * 1 <= k <= nums.length <= 10^4
	 * -10^4 <= nums[i] <= 10^4
	 */
	public static int findKthLargest(int[] nums, int k) {

		int result = 10001;
		
		//랜덤 피벗 설정
//		Random random = new Random();
//		int p = random.nextInt(nums.length);	// 0이상 배열의 길이값 미만의 랜덤값을 초기 피벗값으로 설정
		
		quickSort(nums, 0, nums.length-1);
		
		System.out.println(Arrays.toString(nums));
		
		int realCount = 0;
		int temp = 10001;
//		for (int i = nums.length - 1; i >= 0; i--) {	// 중복 제외인줄 알았네...
//			if (temp == nums[i]) {
//				continue;
//			} else {
//				realCount++;
//				temp = nums[i];
//			}
//			
//			if (realCount == k) {
//				return temp;
//			}
//		}
		
		return nums[nums.length - k];
    }
	
	private static void quickSort(int[] intArray, int leftSite, int rightSite) {
		
		if (leftSite < rightSite) {
			int p = partition(intArray, leftSite, rightSite);
			
			quickSort(intArray, leftSite, p - 1);	// 반환된 피벗값을 기준으로 앞부분의 배열을 퀵소트
			quickSort(intArray, p + 1, rightSite);	// 
		}
		
	}
	
	private static int partition(int[] intArray, int leftSite, int rightSite) {
		int pValue = intArray[rightSite];	// 비교 기준 피벗값
		int currentSite = leftSite - 1;		// 피벗값보다 작거나 같은값의 위치
		
		for (int i = leftSite; i < rightSite; i++) {	// 시작위치부터 끝위치까지
			
			if (intArray[i] <= pValue) {	// 피벗값보다 작거나 같으면
				swap(intArray, i, ++currentSite);	// 배열의 왼쪽으로 간다. (현재 '작은값 모음' 다음 자리의 값과 교환
			}
		}
		swap(intArray, ++currentSite, rightSite);	// 최종적으로 '작은값 모음' 다음 자리와 피벗값을 교체
		// [ [피벗값보다 작거나 같은 값], 피벗값, [피벗값보다 큰 값] ]
		
		return currentSite;	// 피벗값을 반환
	}
	
	private static void swap(int[] intArray, int leftSite, int rightSite) {
		int temp = intArray[leftSite];
		intArray[leftSite] = intArray[rightSite];
		intArray[rightSite] = temp;
	}
	
	public static void main(String[] args) {
//		// 예상 return 값 5
//		int[] input = {3, 2, 1, 5, 6, 4};
//		int k = 2;
		
		// 예상 return 값 4
		int[] input = {3, 2, 3, 1, 2, 4, 5, 5, 6};
		int k = 4;
		
		System.out.println("=====결과값=====");
		System.out.println(findKthLargest(input, k));
		System.out.println("================");
	}
}
