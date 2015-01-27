package com.blogspot.toomuchcoding
import com.ofg.config.BasicProfiles
import com.ofg.infrastructure.environment.EnvironmentSetupVerifier
import groovy.transform.CompileStatic
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.EnableAspectJAutoProxy

@CompileStatic
@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
class Application {

    static void main(String[] args) {
        SpringApplication application = new SpringApplication(Application)
        application.addListeners(new EnvironmentSetupVerifier(BasicProfiles.all()))
        application.run(args)
    }

}
