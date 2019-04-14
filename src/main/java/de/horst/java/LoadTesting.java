package de.horst.java;

public class LoadTesting {

	public void init(int terminalId) {
		System.out.println(terminalId);
		//Pause for 4 seconds
        try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
