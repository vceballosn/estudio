package estudio;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		Timer timer = new Timer();
		
		TimerTask timerTask = new TimerTask() {
			
			@Override
			public void run() {
				System.out.println("la tarea se realizo en "+ new Date());
				System.out.println("otra tarea "+ new Date());
				
			}
		};
		
		timer.schedule(timerTask,0 ,2000); //120000 2 minutos
		timerTask.wait(1000);;
		

	}

}
