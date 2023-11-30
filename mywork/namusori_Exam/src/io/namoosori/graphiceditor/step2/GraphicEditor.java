package io.namoosori.graphiceditor.step2;

public class GraphicEditor {
	
	private static final int ARRAY_LENGTH = 5;
	
	public static void main(String[] args) {
		

		Shape[] shapes = new Shape[ARRAY_LENGTH];
		
		
		for (int i = 0; i< ARRAY_LENGTH ; i++) {
			int randomNumber = (int)(Math.random()*3);
			
			if (randomNumber == 0) {
				shapes[i] = new Rectangle();			
			}else if(randomNumber == 1){
				shapes[i] = new Ellipse();			
			}else{
				shapes[i] = new Line();
			}
		}

		
		//Drawing Shapes
		for(Shape shape : shapes) {
			if(shape instanceof Rectangle) {
				//1번 입력방식
				//Rectangle rect = (Rectangle)shape;
				//rect.drawRectangle();
				
				//2번 입력방식
				((Rectangle)shape).drawRectangle();
			}else if(shape instanceof Ellipse) {
				((Ellipse)shape).drawEllipse();
			}else if(shape instanceof Line){
				((Line)shape).drawLine();		
			}
			
		}
	
		
	}
}

