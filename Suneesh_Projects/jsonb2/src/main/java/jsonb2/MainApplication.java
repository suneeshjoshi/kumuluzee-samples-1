package jsonb2;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.jboss.logging.Logger;

import processor.PersonProcessor;

@ApplicationPath("jsonb")
public class MainApplication extends Application {

	private static final Logger log = Logger.getLogger(MainApplication.class);

	public MainApplication() {
		super();
		log.info("START");
		startApp();
	}

	private void startApp() {
		PersonProcessor p = new PersonProcessor();
		p.startProcess();
	}

}
