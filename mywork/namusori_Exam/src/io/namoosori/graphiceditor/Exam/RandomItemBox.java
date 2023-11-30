package io.namoosori.graphiceditor.Exam;

public class RandomItemBox {

	private final static int NUMBER_OF_ITEMS = 7;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Items[] itemBox = new Items[NUMBER_OF_ITEMS];


		for (int i = 0; i < NUMBER_OF_ITEMS; i++) {
			int ran_num = (int)(Math.random() * 4);
			if (ran_num == 0) {
				itemBox[i] = new Charactor_Skin();
			} else if (ran_num == 1) {
				itemBox[i] = new Credit();
			} else if (ran_num == 2) {
				itemBox[i] = new Phrase();
			} else {
				itemBox[i] = new Emoticon();
			}

		}

		for (Items item : itemBox) {
			item.openItem();
		}

	}

}
