package com.ofg.client.controller

import com.ofg.client.model.Client
import com.ofg.client.persistence.ClientRepository
import com.ofg.client.reporting.ReportingServiceNotifier
import com.wordnik.swagger.annotations.Api
import com.wordnik.swagger.annotations.ApiOperation
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import javax.validation.constraints.NotNull

import static org.springframework.web.bind.annotation.RequestMethod.GET
import static org.springframework.web.bind.annotation.RequestMethod.POST

@Slf4j
@RestController
@RequestMapping('/api/client')
@Api(value = 'clients', description = 'Operations on clients')
class ClientController {

	@Autowired
	ReportingServiceNotifier reportingServiceNotifier

	@Autowired
	ClientRepository clientRepository

	@RequestMapping(
			method = POST,
			consumes = 'application/json',
			produces = 'application/json')
	@ApiOperation('Stores a client')
	ResponseEntity<String> store(@RequestBody @NotNull Client client) {
		def savedClient = clientRepository.save(client)
		reportingServiceNotifier.notifyAboutNewClient(savedClient)
		new ResponseEntity<String>(HttpStatus.CREATED)
	}

	@RequestMapping(
			method = GET,
			produces = 'application/json')
	@ApiOperation('List clients')
	Iterable<Client> list() {
		clientRepository.findAll()
	}
}
