package org.wang.openai.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wang.common.response.Result;
import org.wang.openai.dto.TalkDto;
import org.wang.openai.service.ChatGPTService;


/**
 * chatgpt接口
 * Author: 18615
 * Date: 2024/4/13 8:44
 */
@RestController
@RequestMapping("/chat-gpt")
public class ChatGPTController {
    @Resource
    private ChatGPTService chatGPTService;

    @PostMapping("/talk")
    public Result<String> talkByService(@RequestBody TalkDto talkDto) throws Exception {
        String result = chatGPTService.talk(talkDto);
        return Result.ok(result);
    }

}
