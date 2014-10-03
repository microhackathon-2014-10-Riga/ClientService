package com.ofg.client.config

import com.ofg.infrastructure.config.WebAppConfiguration
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Configuration
@Import(WebAppConfiguration)
class WebApplicationConfiguration {


}
