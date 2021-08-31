package codingTest;

public class convertNewId {
	
	/**
	 * 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
	 * 2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
	 * 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
	 * 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
	 * 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
	 * 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다. 만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
	 * 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
	 * 
	 * 
	 * 예1	"...!@BaT#*..y.abcdefghijklm"	"bat.y.abcdefghi"
	 * 예2	"z-+.^."						"z--"
	 * 예3	"=.="							"aaa"
	 * 예4	"123_.def"						"123_.def"
	 * 예5	"abcdefghijklmn.p"				"abcdefghijklmn"
	 */
	
	public static String solution(String new_id) {
		String answer = "";
		
		String temp = new_id.toLowerCase();
		
		temp = temp.replaceAll("[^a-z0-9\\-_.]", "");
		
		temp = temp.replaceAll("\\.{2,}", ".");
		
		temp = temp.replaceAll("^[.]|[.]$", "");
		
		if (temp.isEmpty())
			temp += "a";
		
		if (temp.length() >= 16) {
			temp = temp.substring(0, 15);
			temp = temp.replaceAll("^[.]|[.]$", "");
		}
		
		if (temp.length() <= 2)
			while (temp.length() < 3)
				temp += temp.charAt(temp.length() - 1);
		
		answer = temp;
		
		return answer;
	}
	
	public static void main(String[] args) {
		String[] exampleList = {"...!@BaT#*..y.abcdefghijklm", "z-+.^.", "=.=", "123_.def", "abcdefghijklmn.p"};
		
		for(String t : exampleList)
			System.out.println(solution(t));
		
	}
	
}
