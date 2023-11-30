package io.namoosori.graphiceditor.Exam;

public class Charactor_Skin extends Items{
	
	
	public void openItem() {
		String[] prize = {"R등급", "SR등급", "SSR등급","STAR등급"};
		System.out.println("[" + prize[ran_number(prize.length)] + "] 캐릭터 스킨 획득!");
	}
}
