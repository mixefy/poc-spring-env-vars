package jp.mixefy.poc.spring.envs

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@ActiveProfiles("gamma")
@SpringBootTest
class GammaEnvTests(
    @Autowired val apiController: ApiController
) {

    @Test
    fun `environment setting propagation works correctly`() {
        apiController.envName() shouldBe "env.name: gamma"
        apiController.envNetwork() shouldBe "env.network: prod"
        apiController.pocDbInstance() shouldBe "poc.db-instance: gamma-instance"
        apiController.pocMyServiceAddress() shouldBe
                "poc.my-service.address: my-service.gamma.gw.prod-poc-main-k8s01.cluster.gamma.mixefy.local:9090"
    }

}
