package jp.mixefy.poc.spring.envs

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class PocSpringEnvVarApplication

fun main(args: Array<String>) {
    runApplication<PocSpringEnvVarApplication>(*args)
}


@RestController
class ApiController(
    @Value("\${env.name}") val envName: String,
    @Value("\${env.network}") val envNetwork: String,
    @Value("\${poc.db-instance}") val dbInstance: String,
    @Value("\${poc.my-service.address}") val myServiceAddress: String,
) {

    @GetMapping("/env/name")
    fun envName() = "env.name: $envName"

    @GetMapping("/env/network")
    fun envNetwork() = "env.network: $envNetwork"

    @GetMapping("/poc/db-instance")
    fun pocDbInstance() = "poc.db-instance: $dbInstance"

    @GetMapping("/poc/my-service/address")
    fun pocMyServiceAddress() = "poc.my-service.address: $myServiceAddress"
}
