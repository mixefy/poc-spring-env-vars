package jp.mixefy.poc.spring.envs

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@ActiveProfiles("prod")
@SpringBootTest
class ProdEnvTests(
    @Autowired val apiController: ApiController
) {

    @Test
    fun `environment setting propagation works correctly`() {
        apiController.envName() shouldBe "env.name: prod"
        apiController.envNetwork() shouldBe "env.network: prod"
        apiController.pocDbInstance() shouldBe "poc.db-instance: prod-instance"
        apiController.pocMyServiceAddress() shouldBe
                "poc.my-service.address: my-service.prod.gw.prod-poc-main-k8s01.cluster.prod.mixefy.local:9090"
    }

}
