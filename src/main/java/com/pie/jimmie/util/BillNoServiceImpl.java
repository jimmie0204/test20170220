package com.pie.jimmie.util;

import java.util.Date;
import java.util.UUID;


public class BillNoServiceImpl {

	private final static String[] chars = new String[] { "a", "b", "c", "d",
		"e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q",
		"r", "s", "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3",
		"4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G",
		"H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
		"U", "V", "W", "X", "Y", "Z" };
	
	private final static String[] charsNum = new String[] {"0", "1", "2", "3",
		"4", "5", "6", "7", "8", "9"};
	
	/**
	 * 调整账单前缀
	 */
	private final static String PRE_ADJUSTBILL = "TZ";

	/**
	 * 采购结算账单前缀
	 */
	private final static String PRE_DUEBILL = "JS";
	

	public String getBillNo(int type) {

		String billno = null;
		switch (type) {
		case 1:
			billno=getSuffix(PRE_ADJUSTBILL);
			break;
		case 2:
			billno=getSuffix(PRE_DUEBILL);
			break;
		default:
			break;
		}
		return billno;
	}

	private String getSuffix(String prefix) {
		StringBuffer shortBuffer = new StringBuffer(prefix);
		shortBuffer.append(DateUtil.date2Str(new Date(), DateUtil.YMDHMS));
		String uuid = UUID.randomUUID().toString().replace("-", "");
		String str;
		int x;
/*		for (int i = 0; i < 8; i++) {
			str = uuid.substring(i * 4, i * 4 + 4);
			x = Integer.parseInt(str, 16);
			shortBuffer.append(chars[x % 0x3E]);
		}*/
		for (int i = 0; i < 8; i++) {
			str = uuid.substring(i * 4, i * 4 + 4);
			x = Integer.parseInt(str, 16);
			shortBuffer.append(charsNum[x % 10]);
		}
		
		return shortBuffer.toString();
	}


	public static void main(String[] args) {
		System.out.println(new BillNoServiceImpl().getBillNo(1));;
/*		System.out.println(chars[61 % 0x3E]);
		System.out.println(chars[61 % 62]);
		System.out.println(chars[61]);*/
	}
}
