package bit701.day0901;

public class GroupExam2 {
	public static void main(String[] args) {

		String blank = " ";
		String star = "*";

		int blankCount = 6;
		int starCount = 1;
		int step = 2;

		boolean check_MaxStar = true;

		while (true) {
			System.out.print(blank.repeat(blankCount));
			System.out.println(star.repeat(starCount));
			
			if(check_MaxStar) {
				starCount+=step;
				blankCount--;
				if (blankCount==0)
					check_MaxStar = !check_MaxStar;

			}
			else{
				if (starCount==1)
					break;
				starCount-=step;
				blankCount++;
			}

		}

	}
}
