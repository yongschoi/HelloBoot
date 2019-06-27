package yongs.temp;

import yongs.temp.common.SecurityUtil;

public class Test {

	public static void main(String[] args) {

    	System.out.println("1:::"+SecurityUtil.encryptSHA256("test"));
    	System.out.println("2:::"+SecurityUtil.encryptSHA256("test"));
    	System.out.println("3:::"+SecurityUtil.encryptSHA256("test"));

	}

}
