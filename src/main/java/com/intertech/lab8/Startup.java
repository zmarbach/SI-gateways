package com.intertech.lab8;

import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.integration.support.MessageBuilder;
//import org.springframework.messaging.Message;
//import org.springframework.messaging.MessageChannel;

public class Startup {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"/META-INF/spring/si-components.xml");

		//TODO - use Gateway instead of having to TIGHTLY couple this app with SI specific implementation classes (Message, MessageChannel, etc)
		//TODO - gets rid of lots of imports above
			// MessageChannel channel = context.getBean("requestChannel", MessageChannel.class);
			// Message<String> message = MessageBuilder.withPayload("Hello brave new world").build();
			// channel.send(message);

		PigLatinService service = context.getBean("latinService",
				PigLatinService.class);
		System.out.println(service.translate("Hello brave new world"));

		context.close();
	}
}
