package zebra.zyber.kotlinjpaplayground

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication(scanBasePackages = ["zebra"])
@EnableJpaRepositories(basePackages = ["zebra"])
class KotlinJpaPlaygroundApplication

fun main(args: Array<String>) {
    runApplication<KotlinJpaPlaygroundApplication>(*args)
}
