package com.suneesh.kumuluzee.latest_microprofile;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;

import org.jboss.logging.Logger;

@ApplicationScoped
@Resource
public class EventProcessor {
	private static final Logger log = Logger.getLogger(EventProcessor.class);

	public EventProcessor() {
		super();
		log.info("CTOR:START");
		processTradeFile();
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
