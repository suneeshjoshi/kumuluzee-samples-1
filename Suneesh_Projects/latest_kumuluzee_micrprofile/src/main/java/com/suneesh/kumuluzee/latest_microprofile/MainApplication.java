package main.java.com.suneesh.kumuluzee.latest_microprofile;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.jboss.logging.Logger;

@ApplicationPath("sj")
public class MainApplication extends Application {

	private static final Logger log = Logger.getLogger(MainApplication.class);

//	@Inject
//	@Named

	public MainApplication() {
		log.info("STARTING Main Application...");
		startEventProcessor();
//		processor = new EventProcessor();
//		processor.processTradeFile();
	}

	private void startEventProcessor() {
		ExecutorService es = Executors.newSingleThreadExecutor();

		es.execute(new Runnable() {

			@Override
			public void run() {
				log.info("Going to event processor...");
				new EventProcessor().processTradeFile();
			}
		});
	}

}
