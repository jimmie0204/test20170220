package com.jimmie.test.akka.dispatcherAndRouter;

import java.io.Serializable;

public class StartCommand implements Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 8843929858821193014L;
	private int actorCount =0;

    public StartCommand() {
    }

    public StartCommand(int actorCount) {
        this.actorCount = actorCount;
    }

    public int getActorCount() {
        return actorCount;
    }

    public void setActorCount(int actorCount) {
        this.actorCount = actorCount;
    }
}