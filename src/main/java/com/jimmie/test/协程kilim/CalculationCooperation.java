package com.jimmie.test.协程kilim;

/*import kilim.Mailbox;

public class KilimMain {

	public static void main(String[] args) {
		Mailbox<Calculation> mailbox = new Mailbox<>(8);
		new DeferredDivision(mailbox).start();
		new Calculator(mailbox).start();
	}
}*/

import kilim.Mailbox;
import kilim.Task;
 
public class CalculationCooperation {
 public static void main(String[] args) {
  Mailbox<Calculation> sharedMailbox = new Mailbox<Calculation>();
 
  Task deffered = new DeferredDivision(sharedMailbox);
  Task calculator = new Calculator(sharedMailbox);
 
  deffered.start();
  calculator.start();
 
 }
}
