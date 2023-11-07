package io.poten13.deepfocus.domain.user.client

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(name = "NicknameGenerator", url = "https://nickname.hwanmoo.kr")
interface NicknameGeneratorClient {
    @GetMapping("/", consumes = ["text/plain"])
    fun generateNickname(
        @RequestParam("format") format: String,
        @RequestParam("count") count: Int,
        @RequestParam("max_length") maxLength: Int
    ): String
}