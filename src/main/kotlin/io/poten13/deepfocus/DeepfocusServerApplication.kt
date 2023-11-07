package io.poten13.deepfocus

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@EnableFeignClients
@SpringBootApplication
class DeepfocusServerApplication

fun main(args: Array<String>) {
    runApplication<DeepfocusServerApplication>(*args)
}
