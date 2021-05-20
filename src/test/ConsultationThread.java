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
		LocalDate date = LocalDate.of(2021, 5, 26); 
		try {
			Thread.sleep((long) (Math.random() * 1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		wasExecuted = dietConsultationController.createDietConsultation(date, "I need to get slim");
		consultationId = dietConsultationController.getLastInsertedId();
		
	}
	
	public void stop() {
		//Delete consultation from Database
		dietConsultationController.deleteConsultation(consultationId);
	}
	
	public boolean getExecuted() {
		return this.wasExecuted;
	}

}
