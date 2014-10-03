package com.ofg.client.controller
import com.wordnik.swagger.annotations.Api
import com.wordnik.swagger.annotations.ApiOperation
import groovy.util.logging.Slf4j
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import static org.springframework.web.bind.annotation.RequestMethod.POST

@Slf4j
@RestController
@RequestMapping('/client')
@Api(value = 'client', description = 'Operations on clients')
class ClientController {

	@RequestMapping(
			method = POST,
			consumes = 'application/json',
			produces = 'application/json')
	@ApiOperation('Stores a client')
	Client store(@RequestBody Client client) {
		client
	}
}
