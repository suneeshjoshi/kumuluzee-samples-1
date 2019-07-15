package main.java.com.suneesh.kumuluzee.latest_microprofile;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

import org.jboss.logging.Logger;

public class TradeFile {
	private static final Logger log = Logger.getLogger(TradeFile.class);

	private String fileName;
	private String URL;
	private boolean processed;

	List<String> content;

	public TradeFile(Path path, boolean processed, List<String> content) {
		super();
		this.fileName = path.getFileName().toString();
		URL = path.toAbsolutePath().toString();
		this.processed = processed;
		Path fileName2 = path.getFileName();
		try (BufferedReader br = Files.newBufferedReader(path)) {
			this.content = br.lines().collect(Collectors.toList());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public boolean isProcessed() {
		return processed;
	}

	public void setProcessed(boolean processed) {
		this.processed = processed;
	}

	public List<String> getContent() {
		return content;
	}

	public void setContent(List<String> content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "TradeFile [fileName=" + fileName + ", URL=" + URL + ", processed=" + processed + ", content=" + content
				+ "]";
	}

}
