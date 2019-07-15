package main.java.com.suneesh.kumuluzee.latest_microprofile;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.ArrayList;
import java.util.List;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import org.jboss.logging.Logger;

import main.java.com.suneesh.kumuluzee.kafka.KafkaMessage;
import main.java.com.suneesh.kumuluzee.kafka.SendMessage;

public class EventProcessor {
	private static final Logger log = Logger.getLogger(EventProcessor.class);

	public EventProcessor() {
		super();
		log.info("CTOR:START");
	}

	private void createJSONToSend(Path path) {
		TradeFile t = new TradeFile(path, false, new ArrayList<String>());
		List<String> content = t.getContent();
		Jsonb b = JsonbBuilder.create();
		String json = b.toJson(content);
		log.info(json);

		SendMessage.produceMessage(new KafkaMessage("message-key", json, "test"));
	}

	public void processTradeFile() {
		try {
			WatchService watcher = FileSystems.getDefault().newWatchService();

			Path dir = FileSystems.getDefault().getPath("tradeFileDirectory");
			File file = dir.toFile();

			log.info("Going to monitor location = " + file.getAbsolutePath());
			if (file.exists()) {
				WatchKey watchKey = dir.register(watcher, StandardWatchEventKinds.ENTRY_CREATE,
						StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);

				while ((watchKey = watcher.take()) != null) {

					for (WatchEvent<?> event : watchKey.pollEvents()) {
						log.info("Event kind:" + event.kind() + ". File affected: " + event.context() + ".");
						Path completeURL = Paths.get(dir.toAbsolutePath().toString(), event.context().toString());
						createJSONToSend(completeURL);
					}
					watchKey.reset();
				}

			} else {
				log.error("Trade File Directory not existing. Exiting.");
			}

		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
