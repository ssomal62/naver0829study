package io.namoosori.graphiceditor.Exam;

public class Emoticon extends Items{
	
	public void openItem () {
		String[] prize = {"😎", "🤗", "💕", "👌", "😶‍🌫️", "🎶"};
		System.out.println("[" + prize[ran_number(prize.length)] + "] 스탬프 획득!" );

}
	
}
