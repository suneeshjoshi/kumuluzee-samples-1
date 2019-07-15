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

import javax.xml.bind.DatatypeConverter;

import org.jboss.logging.Logger;

import com.kumuluz.ee.configuration.ConfigurationDecoder;

/**
 * @author Jan Meznarič
 * @since 3.2.1
 */
public class CustomConfigurationDecoder implements ConfigurationDecoder {
	private static final Logger log = Logger.getLogger(CustomConfigurationDecoder.class);

	public CustomConfigurationDecoder() {
		log.info("CTOR");
	}

	@Override
	public boolean shouldDecode(String key) {
		if ("rest-config.encoded-property".equals(key)) {
			return true;
		}
		return false;
	}

	@Override
	public String decode(String key, String value) {
		return new String(DatatypeConverter.parseBase64Binary(value));
	}
}
