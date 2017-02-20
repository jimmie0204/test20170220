package com.jimmie.test.nio.obj;

import java.io.Serializable;

public class Student implements Serializable{

        /**
	 * 
	 */
	private static final long serialVersionUID = 2027251985507261160L;
		public int getId() {
                return id;
        }
        public void setId(int id) {
                this.id = id;
        }
        public String getName() {
                return name;
        }
        public void setName(String name) {
                this.name = name;
        }

        private int id;
        private String name;

}