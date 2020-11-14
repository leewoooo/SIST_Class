package day1112.homework;

//1~45번 사이의 임의의 숫자 6개를 배열에 저장하여 반환하는 method를 만들고
//숫자 6개를 출력해 보세요. ( 중복숫자가 나오면 안됩니다. )




public class HomeWork2 {

	int random=0; // 1~45의 난수를 받을 변수
	
	public int[] lotto() {
	
	// 1. 6개의 번호를 저장할 배열 생성.
	int[] num = new int[6];
	
	for(int i = 0; i < num.length ; i++) { //모든 방에 값을 넣을 반복문.
		random = (int)((Math.random()*45)+1);
		num[i]=random;
		//현재 방의 값이 이전방들의 값과 같다면 현재번째 방의 난수를 다시 생성
		for(int j = 0 ; j < i ; j++) {
			//현재방의 값을 다시 생성
			if(num[i]==num[j]) {
				i--;
				break; //안쪽 for를 빠져나간다.
			}//if
		}//for
	}//for
	return num;	
	}//rotto
	
	
	public void printlotto(int [] arr) {
		
		for(int i = 0; i < arr.length; i++) {
			System.out.printf("%-4d",arr[i]);
		}//for 
	}//printlotto
	
	public static void main(String[] args) {
		HomeWork2 hw = new HomeWork2();
		int[] temp = hw.lotto();
		hw.printlotto(temp);
		
	}//main
}//class
