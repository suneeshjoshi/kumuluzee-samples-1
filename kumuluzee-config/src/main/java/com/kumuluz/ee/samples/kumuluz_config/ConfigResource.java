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

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.logging.Logger;

/**
 * @author Benjamin Kastelic
 * @since 2.3.0
 */
@RequestScoped
@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ConfigResource {

	private static final Logger log = Logger.getLogger(ConfigResource.class);

	public ConfigResource() {
		log.info("CTOR");
	}

	@Inject
	private ConfigProperties properties;

	@GET
	@Path("/config")
	public Response test() {
		String response = "{" + "\"stringProperty\": \"%s\"," + "\"booleanProperty\": %b," + "\"integerProperty\": %d,"
				+ "\"encodedProperty\": \"%s\"" + "}";

		response = String.format(response, properties.getStringProperty(), properties.getBooleanProperty(),
				properties.getIntegerProperty(), properties.getEncodedProperty());

		return Response.ok(response).build();
	}
}
