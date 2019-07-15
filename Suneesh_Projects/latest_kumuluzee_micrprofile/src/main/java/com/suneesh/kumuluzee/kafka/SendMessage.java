package main.java.com.suneesh.kumuluzee.kafka;

import java.util.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import com.kumuluz.ee.streaming.common.annotations.StreamProducer;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SendMessage {

	private static final Logger log = Logger.getLogger(SendMessage.class.getName());

	@Inject
	@StreamProducer
	private static Producer producer;

	public static Response produceMessage(KafkaMessage msg) {

		ProducerRecord<String, String> record = new ProducerRecord<String, String>(msg.getTopic(), msg.getKey(),
				msg.getContent());

		producer.send(record, (metadata, e) -> {
			if (e != null) {
				e.printStackTrace();
			} else {
				log.info("The offset of the produced message record is: " + metadata.offset());
			}
		});

		return Response.ok().build();

	}

}
