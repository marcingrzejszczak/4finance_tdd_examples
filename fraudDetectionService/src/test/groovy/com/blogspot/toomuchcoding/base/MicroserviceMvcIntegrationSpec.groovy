package com.blogspot.toomuchcoding.base

import com.ofg.infrastructure.base.MvcIntegrationSpec
import com.blogspot.toomuchcoding.Application
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.test.context.ContextConfiguration

@ContextConfiguration(classes = [Application], loader = SpringApplicationContextLoader)
class MicroserviceMvcIntegrationSpec extends MvcIntegrationSpec {
}
