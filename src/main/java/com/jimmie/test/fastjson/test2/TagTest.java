package com.jimmie.test.fastjson.test2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.jimmie.test.fastjson.ReturnItemInfo;

public class TagTest {

	public static String print(InputStream i){
		StringBuffer sb = new StringBuffer();
		BufferedReader bf = null;
		String ch = null;
		try {
			bf = new BufferedReader(new InputStreamReader(i));
			while((ch=bf.readLine())!=null){
				sb.append(ch);
			}
		} catch (Exception e) {
			try {
				bf.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return sb.toString();
		
	}
	
	public static void main(String[] args) {
		InputStream ll = TagTest.class.getResourceAsStream("b.txt");
		if(ll==null)
			System.out.println("文件为空");
		String st = print(ll);
		System.out.println(st);
		Map<String, Object> map = JSON.parseObject(st, Map.class);
		System.out.println(map);
		System.out.println(map.get("code"));
		String data = map.get("data").toString();
		List<String> list2 = JSON.parseArray(data, String.class);
		System.out.println(list2);
		System.out.println(list2.get(0));
		
		List<String> list4 = JSON.parseObject(data, List.class);
		System.out.println(list4);
		System.out.println(list4.get(1));
		
		String k = JSON.toJSONString("[{unit=个, manufacturing_date=null, quantity=119, material_id=1000002, rkdh=RK-20161115-SH-1127}, "
				+ "{unit=个, manufacturing_date=null, quantity=42, material_id=1000002, rkdh=RK-20161115-SH-1127}, "
				+ "{unit=个, manufacturing_date=null, quantity=5, material_id=1000001, rkdh=RK-20161115-SH-1127}, "
				+ "{unit=个, manufacturing_date=null, quantity=68, material_id=1000001, rkdh=RK-20161115-SH-1127}, "
				+ "{unit=个, manufacturing_date=null, quantity=611, material_id=1000001, rkdh=RK-20161115-SH-1127}]");
		
		List<ReturnItemInfo> list3 = JSON.parseArray(k, ReturnItemInfo.class);
		
		System.out.println(k);
		System.out.println(list3);

	}

}
