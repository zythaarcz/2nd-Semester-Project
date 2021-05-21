package test;
import java.time.LocalDate;

import controllayer.DietConsultationController;
public class ConsultationThread implements Runnable{

	private DietConsultationController dietConsultationController;
	private String name;
	private int consultationId = 0;
	private boolean wasExecuted = false;
	
	
	public ConsultationThread(String name){
		super();
		this.name = name;
		dietConsultationController = new DietConsultationController();
	}
	@Override
	public void run() {
		
		try {
			Thread.sleep((long) (Math.random() * 1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public boolean getExecuted() {
		return this.wasExecuted;
	}

}
