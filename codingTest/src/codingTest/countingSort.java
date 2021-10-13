package codingTest;

import java.util.Arrays;

import javax.management.openmbean.OpenMBeanAttributeInfo;

public class countingSort {

	/***
	 * 1051. Height Checker
	 * 
	 * A school is trying to take an annual photo of all the students. The students are asked to stand in a single file line in non-decreasing order by height. 
	 * Let this ordering be represented by the integer array expected where expected[i] is the expected height of the ith student in line.
	 * You are given an integer array heights representing the current order that the students are standing in. Each heights[i] is the height of the ith student in line (0-indexed).
	 * Return the number of indices where heights[i] != expected[i].
	 * 
	 * 요약 : input 값으로 들어오는 배열 height가 정렬된 배열 expected랑 비교하였을때 일치하지 않는 항목의 갯수는?
	 */
	
	public static void main(String[] args) {
		int[][] examples = {{1,1,4,2,1,3}, {5,1,2,3,4}, {1,2,3,4,5}};
		int[] example = examples[1];
		
		System.out.println(Arrays.toString(example));
		int result = compareValue(example, countingSort(example));
		System.out.println("result : " + result);
//		int [] test = {31,81,41,78,48,2,83,48,21,20,43,15,26,78,96,55,5,46,35,89,85,54,76,64,71,36,98,94,100,7,88,92,80,43,24,89,50,61,59,20,94,57,99,62,82,46,28,57,66,62,56,15,12,63,19,35,12,26,15,59,8,44,46,45,33,20,27,31,85,15,92,63,63,40,35,95,91,1,4,57,55,68,53,28,15,94,74,89,77,7,25,63,77,24,76,44};
//		System.out.println("길이는" + test.length);
	}
	
	private static int[] countingSort(int[] height) {
		int[] c = new int [101];
		
		for (int value : height) {	// count배열 c 생성
			int temp = c[value];
			c[value] = ++temp;
		}
		
		System.out.println("c배열 : " + Arrays.toString(c));
		
		// c배열의 빈공간 제거
		for (int i = c.length - 1; i > 0; i--) {
			if (c[i] == 0) {
				int[] tempC = new int[i];
				tempC = Arrays.copyOfRange(c, 0, i);
				c = tempC;
			} else {
				break;
			}
		}
		System.out.println("정리 c배열 : " + Arrays.toString(c));
		
		int[] cPrime = new int[c.length];
		int temp = 0;
		for (int i = 0; i < cPrime.length; i++) {
			temp += c[i];
			cPrime[i] = temp;
		}
		System.out.println("c' 배열 : " + Arrays.toString(cPrime));
		
		int[] expected = new int [height.length];
		for (int i = height.length - 1; i >= 0; i--) {
//			System.out.println("test=" + cPrime[height[i]]);
			expected[cPrime[height[i]] - 1] = height[i];
			cPrime[height[i]] = --cPrime[height[i]];
			System.out.println("expected 배열 : " + Arrays.toString(expected));
		}
			
		return expected;
	}
	
	// 정수배열의 같은 위치 값 비교 -> 일치하지 않는 배열 항목의 수를 반환한다.
	private static int compareValue(int[] heights, int[] expected) {
		int cnt = 0;
		for (int i = 0; i < heights.length; i++) {
			if (heights[i] != expected[i]) {
				cnt++;
			}
		}
		
		return cnt;
	}
	
}
