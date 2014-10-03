package com.ofg.client.controller

import com.ofg.client.model.Client
import com.ofg.client.reporting.ReportingServiceNotifier
import com.wordnik.swagger.annotations.Api
import com.wordnik.swagger.annotations.ApiOperation
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import javax.validation.constraints.NotNull

import static org.springframework.web.bind.annotation.RequestMethod.POST

@Slf4j
@RestController
@RequestMapping('/client')
@Api(value = 'client', description = 'Operations on clients')
class ClientController {

	@Autowired
	ReportingServiceNotifier reportingServiceNotifier

	@RequestMapping(
			method = POST,
			consumes = 'application/json',
			produces = 'application/json')
	@ApiOperation('Stores a client')
	Client store(@ModelAttribute @NotNull Client client) {
		reportingServiceNotifier.notifyAboutNewClient(client)
		client
	}
}
