package com.jimmie.test.akka.scheduler;

import java.io.Serializable;

/**
 * 打招呼的人
 * @author SUN
 * @version 1.0
 * @Date 16/1/6 21:41
 */
public class WhoToGreet implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -7390290762732791181L;
	public final String who;
    public WhoToGreet(String who) {
        this.who = who;
    }
}