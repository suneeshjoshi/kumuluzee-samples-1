package processor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import org.jboss.logging.Logger;

import model.Person;

public class PersonProcessor {

	private static final Logger log = Logger.getLogger(PersonProcessor.class);

	public PersonProcessor() {
		log.info("START");
	}

	public void startProcess() {
		Person p1 = new Person("Suneesh", 35, "15 Sep 1983", 100.00);
		List<Person> list1 = new ArrayList<>(Arrays.asList((new Person("Suneesh 2", 36, "16 Sep 1983", 200.00)),
				(new Person("Suneesh 3", 37, "17 Sep 1983", 300.00)),
				(new Person("Suneesh 4", 38, "18 Sep 1983", 400.00))));

		log.info(list1);

		Jsonb b = JsonbBuilder.create();
		String json = b.toJson(list1);

		log.info(json);
	}

}
