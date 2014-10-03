package com.ofg.client.reporting

import com.ofg.client.model.Client
import com.ofg.infrastructure.web.resttemplate.fluent.ServiceRestClient
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
@Slf4j
class ReportingServiceNotifier {

	@Autowired
	ServiceRestClient serviceRestClient

	void notifyAboutNewClient(Client client) {
		log.info('Notifying about: {}', client)
		def res = serviceRestClient.forService('reporting-service')
				.post()
				.onUrl('/api/client')
				.body(client)
				.withHeaders()
					.contentTypeJson()
				.andExecuteFor()
					.anObject()
					.ofType(String)
		println(res)
	}
}
