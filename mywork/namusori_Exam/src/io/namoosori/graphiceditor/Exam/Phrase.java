package io.namoosori.graphiceditor.Exam;

public class Phrase extends Items{
	
	public void openItem() {

	String[] prize =  {"맥주!" , "작년에 왔던~" ,"나와 겨뤄볼텐가!","망치 나가신다!","독일의 기술은 세계제일!"};	
	System.out.println("[" + prize[ran_number(prize.length)] + "] 보이스 획득!");

}
}
