package jp.mixefy.poc.spring.envs

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

/**
 * This test class is to check if the environment variables are propagated correctly.
 */
@SpringBootTest
class SystemPropEnvTests(
    @Autowired val apiController: ApiController
) {

    @Test
    fun `environment setting propagation works correctly`() {
        apiController.envName() shouldBe "env.name: tokyo"
        apiController.envNetwork() shouldBe "env.network: corp"
        apiController.pocDbInstance() shouldBe "poc.db-instance: tokyo-instance"
        apiController.pocMyServiceAddress() shouldBe
                "poc.my-service.address: my-service.tokyo.gw.corp-poc-main-k8s01.cluster.tokyo.mixefy.local:9090"
    }

    private companion object {
        @JvmStatic
        @BeforeAll
        fun setup() {
            System.setProperty("env.name", "tokyo")
            System.setProperty("env.network", "corp")
        }
    }
}
