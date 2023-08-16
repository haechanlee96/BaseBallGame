
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class BaseBallGame {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        // random 값 생성
        Set<Integer> randomNumber = new HashSet<>();

        while (randomNumber.size()<3){
            randomNumber.add(random.nextInt(10));
        }

        Integer[] numRan = new Integer[randomNumber.size()];
        randomNumber.toArray(numRan);



        int numCount = 1;
        int strikeIndex = 0;
        int ballIndex = 0;

        System.out.println("컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요");
        //확인용 로그
        System.out.println("" + numRan[0]+numRan[1]+numRan[2]);

        while(true) {
            System.out.print(numCount + "번째 시도 : ");
            int num = sc.nextInt();

            // arr[i]번째의 인덱스를 numStr의 char[i]번째로 변환, "1" -> 숫자 1
            // 사용자 입력값을 인덱스별로 추출 -> arr
            String numStr = Integer.toString(num);
            int[] arr = new int[numStr.length()];

            for (int i = 0; i < numStr.length(); i++) {
                arr[i] = Character.getNumericValue(numStr.charAt(i));
            }


            // 볼,스트라이크 카운트
            // numRan = 랜덤배열 숫자 , arr = 사용자 입력 배열
            for (int i = 0; i < numStr.length(); i++) {
                if(numRan[i] == arr[i]){
                    strikeIndex++;
                } else if(randomNumber.contains(arr[i])){
                    ballIndex++;
                }
            }

            if(strikeIndex == 3){
                System.out.println("3S");
            } else if(ballIndex == 3){
                System.out.println("3B");
            } else {
                System.out.println(ballIndex + "B" + strikeIndex + "S");
            }

            if(strikeIndex == 3){
                System.out.println(numCount + "번째 시도만에 맞췄습니다");
                System.out.println("게임을 종료합니다");
                break;
            }

            //반복을 위한 초기화
            strikeIndex = 0;
            ballIndex = 0;
            numCount ++;
        }

    }
}
