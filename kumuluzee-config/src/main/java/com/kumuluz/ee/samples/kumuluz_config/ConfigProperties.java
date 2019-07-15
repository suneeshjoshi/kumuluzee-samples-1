/*
 *  Copyright (c) 2014-2019 Kumuluz and/or its affiliates
 *  and other contributors as indicated by the @author tags and
 *  the contributor list.
 *
 *  Licensed under the MIT License (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  https://opensource.org/licenses/MIT
 *
 *  The software is provided "AS IS", WITHOUT WARRANTY OF ANY KIND, express or
 *  implied, including but not limited to the warranties of merchantability,
 *  fitness for a particular purpose and noninfringement. in no event shall the
 *  authors or copyright holders be liable for any claim, damages or other
 *  liability, whether in an action of contract, tort or otherwise, arising from,
 *  out of or in connection with the software or the use or other dealings in the
 *  software. See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.kumuluz.ee.samples.kumuluz_config;

import javax.enterprise.context.ApplicationScoped;

import org.jboss.logging.Logger;

import com.kumuluz.ee.configuration.cdi.ConfigBundle;

/**
 * @author Benjamin Kastelic
 * @since 2.3.0
 */
@ApplicationScoped
@ConfigBundle("rest-config")
public class ConfigProperties {

	private static final Logger log = Logger.getLogger(ConfigProperties.class);

	public ConfigProperties() {
		log.info("CTOR");
	}

	private String stringProperty;

	private Boolean booleanProperty;

	private Integer integerProperty;

	private String encodedProperty;

	public String getStringProperty() {
		return stringProperty;
	}

	public void setStringProperty(String stringProperty) {
		this.stringProperty = stringProperty;
	}

	public Boolean getBooleanProperty() {
		return booleanProperty;
	}

	public void setBooleanProperty(Boolean booleanPropertysomeBoolean) {
		this.booleanProperty = booleanPropertysomeBoolean;
	}

	public Integer getIntegerProperty() {
		return integerProperty;
	}

	public void setIntegerProperty(Integer integerProperty) {
		this.integerProperty = integerProperty;
	}

	public String getEncodedProperty() {
		return encodedProperty;
	}

	public void setEncodedProperty(String encodedProperty) {
		this.encodedProperty = encodedProperty;
	}
}
