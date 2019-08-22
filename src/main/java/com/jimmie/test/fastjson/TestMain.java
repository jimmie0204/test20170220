package com.jimmie.test.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jimmie.test.bean操作.Student;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class TestMain {

	@Test
	public void test1(){
		List<Student> list = new ArrayList<Student>();
		list.add(new Student(11, "aa"));
		list.add(new Student(22, "bb"));
		String jsonArrayText = JSON.toJSONString(list);
		System.out.println(jsonArrayText);;
		List<Student> list2 = JSONArray.parseArray(jsonArrayText,Student.class);
		System.out.println(list2.get(0).getName());
		Object parse = JSON.parse(jsonArrayText);
		System.out.println(parse);

	}
	
	@Test
	public void test2(){//Exception
		String ch = JSONArray.toJSONString(new Student(1, "fff"));
		System.out.println(ch);;
		List<Student> list2 = JSONArray.parseArray(ch,Student.class);
		System.out.println(list2.get(0).getName());
	}
	
	@Test
	public void test3(){
		List<String> list = new ArrayList<String>();
		list.add("aa");
		list.add("bb");
		String jsonArrayText = JSON.toJSONString(list);
		System.out.println(jsonArrayText);;
		List<String> list2 = JSONArray.parseArray(jsonArrayText,String.class);
		System.out.println(list2);
	}
	
	@Test
	public void test4(){
		Bear bear = new Bear();
		String jsonArrayText = JSON.toJSONString(bear);
		System.out.println(jsonArrayText);
		
		Bear parseObject = JSONObject.parseObject(jsonArrayText, Bear.class);
		System.out.println(parseObject.getT());
		System.out.println(parseObject.getT2());
	}
	
	static class Bear{
		private BigDecimal t  = new BigDecimal(12.1);
		private Double t2 = 12.23;

		public BigDecimal getT() {
			return t;
		}

		public void setT(BigDecimal t) {
			this.t = t;
		}

		public Double getT2() {
			return t2;
		}

		public void setT2(Double t2) {
			this.t2 = t2;
		}
		
	}

	//枚举类型的json
	@Test
	public void test5(){

		Wolf wolf = new Wolf();
		wolf.setAge(12);
		wolf.setName("ssdgdd");
		wolf.setAniType(AniType.DONGWU);

		System.out.println(JSON.toJSONString(wolf));

	}

	enum AniType{
		DONGWU(1),ZHIWU(2);

		private AniType(Integer code){
			this.code = code;
		}

		private Integer code;

		public Integer getCode() {
			return code;
		}

		public void setCode(Integer code) {
			this.code = code;
		}
	}

	class Wolf{
		Integer age;

		String name;

		AniType aniType;

		public Integer getAge() {
			return age;
		}

		public void setAge(Integer age) {
			this.age = age;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public AniType getAniType() {
			return aniType;
		}

		public void setAniType(AniType aniType) {
			this.aniType = aniType;
		}
	}
	
}
