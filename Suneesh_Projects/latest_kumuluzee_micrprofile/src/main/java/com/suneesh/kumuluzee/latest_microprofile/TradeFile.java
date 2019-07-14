package com.suneesh.kumuluzee.latest_microprofile;

import java.util.List;

import org.jboss.logging.Logger;

public class TradeFile {
	private static final Logger log = Logger.getLogger(TradeFile.class);

	private String fileName;
	private String URL;
	private boolean processed;

	List<String> content;

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
