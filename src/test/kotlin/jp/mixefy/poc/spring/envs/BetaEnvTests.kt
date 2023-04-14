package jp.mixefy.poc.spring.envs

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@ActiveProfiles("beta")
@SpringBootTest
class BetaEnvTests(
    @Autowired val apiController: ApiController
) {

    @Test
    fun `environment setting propagation works correctly`() {
        apiController.envName() shouldBe "env.name: beta"
        apiController.envNetwork() shouldBe "env.network: dev"
        apiController.pocDbInstance() shouldBe "poc.db-instance: beta-instance"
        apiController.pocMyServiceAddress() shouldBe
                "poc.my-service.address: my-service.beta.gw.dev-poc-main-k8s01.cluster.beta.mixefy.local:9090"
    }

}
