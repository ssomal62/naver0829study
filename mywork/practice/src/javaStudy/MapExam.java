package javaStudy;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapExam {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		
		Map<String,String> map = new HashMap<>();
		map.put("001", "kim");
		map.put("002", "lee");
		map.put("003", "choi");
		
		
		map.put("001", "kang"); //기존에 값에 덮어쓰기함.
		System.out.println(map.size());
		System.out.println(map.toString());
		System.out.println(map.get("001"));
		
		Set<String> keys = map.keySet();
		System.out.println(keys);
		
		Iterator<String> iter = keys.iterator();
		
		while (iter.hasNext()) {			
			String key = iter.next();
			String value = map.get(key);
			System.out.println(key + ":" + value);			
		}
		

	}

}
