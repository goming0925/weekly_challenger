package codingTest;

import java.util.Arrays;

class myHashSet {
	
	/**
	 * Your MyHashSet object will be instantiated and called as such:
	 * MyHashSet obj = new MyHashSet();
	 * obj.add(key);
	 * obj.remove(key);
	 * boolean param_3 = obj.contains(key);
	 * 
	 * void add(key) 는 hashSet의 key 값에 value를 저장한다.
	 * bool contain(key) 는 key가 hashSet에 포함되어있는지 여부를 반환한다.
	 * void remove(key) 는 key를 hashSet에서 삭제한다 만약 hashSet에 존재하지 않으면 아무것도 하지 않는다.
	 * 
	 * 조건
	 * 1. 0 <= key <= 10^8
	 * 2. add, remove, contain을 위해 최대 10^4 만큼 호출됨 -- hashSet내의 충돌 방지인가?
	 * 
	 * 선형프로빙 -- 한군데에 뭉침
	 * 이차식 프로빙 -- 여러군데에 분산되서 뭉침
	 * 더블 해싱 -- 뭉치지 않으려고 용씀
	 */
	static int[] hashSet;
	static final int modValue1 = 49999;
	static final int modValue2 = 49993;
//	static final int modValue1 = 99999989;
//	static final int modValue2 = 99999971 ;
    public myHashSet() {
    	hashSet = new int[50001];
//        hashSet = new int[100000001];
        Arrays.fill(hashSet, -1);
    }
    
    public void add(int key) {
    	
    	int count = 0;
    	int hashSetKey = hashFunction(key, count);
    	
    	while (hashSet[hashSetKey] != -1 && hashSet[hashSetKey] != key) {
    		hashSetKey = hashFunction(key, ++count);
    	}
    	
    	hashSet[hashSetKey] = key;
    	
    }
    
    public void remove(int key) {
    	int count = 0;
    	int hashSetKey = hashFunction(key, count);
    	
    	while (hashSet[hashSetKey] != key) {
    		hashSetKey = hashFunction(key, ++count);
    		if (hashSetKey < 0 || hashSetKey > 100000000) {
    			break;
    		}
    	}
    	
    	if (0 <= hashSetKey && hashSetKey <= 100000000) {
    		if (hashSet[hashSetKey] == key) {
    			hashSet[hashSetKey] = -1;
    		}    		
    	}
    }
    
    public boolean contains(int key) {
    	boolean flag = false;
    	int count = 0;
    	int hashSetKey = hashFunction(key, count);
    	
    	while (hashSet[hashSetKey] != key) {
    		hashSetKey = hashFunction(key, ++count);
//    		System.out.println("count : " + count);
//    		System.out.println("hasgSetKey : " + hashSetKey);
//    		if (count == 46339) {
//    			System.out.println("잡아");
//    		}
    		if (hashSetKey < 0 || hashSetKey > 100000000) {
    			break;
    		}
    	}
    	
    	if (0 <= hashSetKey && hashSetKey <= 100000000) {
    		if (hashSet[hashSetKey] == key) {
    			flag = true;
    		}    		
    	}
        
    	return flag;
    }
    
    private int hashFunction(int key, int count) {
    	// 99999989 - 5761455번째 소수 -- 출처 : http://khgkjg12.blogspot.com/2016/07/1-c.html
    	// h(k, i) = (h1(k) + i*h2(k)) mod modValue;
    	int h1 = key % modValue1;
    	int h2 = count + (key % modValue2);
    	
    	int hashSetKey = (h1 + (count * h2)) % modValue1;
    	
    	return hashSetKey;
    }
    
}

public class doubleHashing {
	
	/**
	 * Input
	 * ["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
	 * [[], [1], [2], [1], [3], [2], [2], [2], [2]]
	 * 
	 * Output
	 * [null, null, null, true, false, null, true, null, false]
	 */
	public static void main(String[] args) {
		
		myHashSet myHashSet = new myHashSet();
		myHashSet.add(1);      // set = [1]
		myHashSet.add(2);      // set = [1, 2]
		System.out.println(myHashSet.contains(1)); // return True
		System.out.println(myHashSet.contains(3)); // return False, (not found)
		myHashSet.add(2);      // set = [1, 2]
		System.out.println(myHashSet.contains(2)); // return True
		myHashSet.remove(2);   // set = [1]
		System.out.println(myHashSet.contains(2)); // return False, (already removed)
	}
}
