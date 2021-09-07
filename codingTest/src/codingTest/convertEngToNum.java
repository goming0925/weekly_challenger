package codingTest;

public class convertEngToNum {
	/**
	 * 다음은 숫자의 일부 자릿수를 영단어로 바꾸는 예시입니다.
	 * 1478 → "one4seveneight"
	 * 234567 → "23four5six7"
	 * 10203 → "1zerotwozero3"
	 * 이렇게 숫자의 일부 자릿수가 영단어로 바뀌어졌거나, 혹은 바뀌지 않고 그대로인 문자열 s가 매개변수로 주어집니다. s가 의미하는 원래 숫자를 return 하도록 solution 함수를 완성해주세요.
	 * 참고로 각 숫자에 대응되는 영단어는 다음 표와 같습니다.
	 * 
	 * 숫자	영단어
	 * 0	zero	z o
	 * 1	one		o e
	 * 2	two		t o
	 * 3	three	t e
	 * 4	four	f r
	 * 5	five	f e
	 * 6	six		s x
	 * 7	seven	s n
	 * 8	eight	e t
	 * 9	nine	n e
	 * 
	 * 제한사항1 ≤ s의 길이 ≤ 50
	 * 
	 * s가 "zero" 또는 "0"으로 시작하는 경우는 주어지지 않습니다.
	 * return 값이 1 이상 2,000,000,000 이하의 정수가 되는 올바른 입력만 s로 주어집니다.
	 * 
	 *  입출력 예
	 *  s					result
	 *  "one4seveneight"	1478
	 *  "23four5six7"		234567
	 *  "2three45sixseven"	234567
	 *  "123"				123
	 */
	public static int solution(String s) {
        int answer = 0;
        String tempAnswer = "";	// 계산용 문자열
        
        int i = 0;	//문자열 위치정보
        while (s.length() > 0) {
        	char c = s.charAt(0);	// 현재 문자열 첫자리
        	switch (c) {
        	case 'z':
        		tempAnswer += '0';
        		s = s.substring(4);
        		break;
        	case 'o':
        		tempAnswer += '1';
        		s = s.substring(3);
        		break;
        	case 't':
        		if (s.charAt(1) == 'w') {	// 현재 문자열 두번째 자리
        			tempAnswer += '2';
        			s = s.substring(3);        			
        		} else if (s.charAt(1) == 'h') {	// 현재 문자열 두번째 자리
        			tempAnswer += '3';
        			s = s.substring(5);
        		}
        		break;
        	case 'f':
        		if (s.charAt(1) == 'o') {	// 현재 문자열 두번째 자리
        			tempAnswer += '4';
        			s = s.substring(4);        			
        		} else if (s.charAt(1) == 'i') {	// 현재 문자열 두번째 자리
        			tempAnswer += '5';
        			s = s.substring(4);
        		}
        		break;
        	case 's':
        		if (s.charAt(1) == 'i') {	// 현재 문자열 두번째 자리
        			tempAnswer += '6';
        			s = s.substring(3);        			
        		} else if (s.charAt(1) == 'e') {	// 현재 문자열 두번째 자리
        			tempAnswer += '7';
        			s = s.substring(5);
        		}
        		break;
        	case 'e':
        		tempAnswer += '8';
        		s = s.substring(5);
        		break;
        	case 'n':
        		tempAnswer += '9';
        		s = s.substring(4);
        		break;
        	default:
        		tempAnswer += c;
        		s = s.substring(1);
        		break;
        	}
        	i++;
        }
        answer = Integer.parseInt(tempAnswer);
        
        return answer;
    }
	
	
	public static void main(String[] args) {
		String example[] = {"one4seveneight", "23four5six7", "2three45sixseven", "123"};
		
		int answer = solution(example[3]);
		System.out.println(answer);
	}
}
