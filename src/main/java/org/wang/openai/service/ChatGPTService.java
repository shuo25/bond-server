package org.wang.openai.service;

import com.unfbx.chatgpt.OpenAiClient;
import com.unfbx.chatgpt.entity.chat.ChatCompletion;
import com.unfbx.chatgpt.entity.chat.ChatCompletionResponse;
import com.unfbx.chatgpt.entity.chat.Message;
import com.unfbx.chatgpt.interceptor.OpenAILogger;
import com.unfbx.chatgpt.interceptor.OpenAiResponseInterceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.wang.openai.dto.TalkDto;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

/**
 * Author: 18615
 * Date: 2024/4/13 8:15
 */
@Service
public class ChatGPTService {
    @Value("${openai.apiKey}")
    private String apiKey; // 从配置文件中获取API密钥

    public String talk(TalkDto talkDto) throws Exception{
        //国内访问需要做代理，国外服务器不需要
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", 10809));
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new OpenAILogger());
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().proxy(proxy)//自定义代理
                .addInterceptor(httpLoggingInterceptor)//自定义日志输出
                .addInterceptor(new OpenAiResponseInterceptor())//自定义返回值拦截
                .connectTimeout(10, TimeUnit.SECONDS)//自定义超时时间
                .writeTimeout(3000, TimeUnit.SECONDS)//自定义超时时间
                .readTimeout(3000, TimeUnit.SECONDS)//自定义超时时间
                .build();
        //构建客户端
        OpenAiClient openAiClient = OpenAiClient.builder()//构建
                .apiKey(Collections.singletonList(apiKey))//token
                .okHttpClient(okHttpClient)//注入okhttp
                .build();
        Message message = Message.builder().role(Message.Role.USER).content(talkDto.getContent()).build();
        ChatCompletion.ChatCompletionBuilder builder = ChatCompletion.builder();
        //聊天模型：gpt-3.5
        builder.model("gpt-3.5-turbo");
        builder.messages(Arrays.asList(message));
        ChatCompletion chatCompletion = builder.build();

        ChatCompletionResponse chatCompletionResponse = openAiClient.chatCompletion(chatCompletion);
        return chatCompletionResponse.getChoices().get(0).getMessage().getContent();
    }

}
