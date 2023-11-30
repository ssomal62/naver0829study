package io.namoosori.graphiceditor.Exam;

public class Credit extends Items{
	
	public void openItem() {
		int[] prize = {10, 50, 100, 500, 1000, 5000};
		System.out.println("[" + prize[ran_number(prize.length)] + "] 크레딧 획득!" );
		
	}

}
