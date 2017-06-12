package tsmykTools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
	
	public static void main(String[] args){
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("a");
		list.add("b");
		list.add("b");
		list.add("c");
		
		System.out.println("======去重之前=======");
		for(String s : list){
			System.out.print(s + " ");
		}
		
		Map<String, String> map = new HashMap<>();
		if(list != null && list.size() > 0){
			for(String s : list){
				map.put(s, s);
			}
		}
		list.clear();
		Object[] o = map.keySet().toArray();
		for (int i = 0; i < map.size(); i++) {
			list.add(map.get(o[i]));
		}
		
		
		System.out.println();
		System.out.println("======去重之后=======");
		for(String s : list){
			System.out.print(s + " ");
		}
	}
	
}
