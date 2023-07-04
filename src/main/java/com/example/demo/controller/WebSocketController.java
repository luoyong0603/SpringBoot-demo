package com.example.demo.controller;

import com.example.demo.component.WebSocket.WebSocketServer;
import com.example.demo.vo.ResultResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

/**
 * @author luoYong
 * @version 1.0
 * @date 2023/1/4 14:53
 */
@RestController
@RequestMapping("/websocket")
@Api(tags = "WebSocket模块", description = "WebSocket模块")
public class WebSocketController {

    @GetMapping("/page")
    @ApiOperation(value = "跳转WebSocket微聊天室页面", notes = "跳转WebSocket微聊天室页面")
    public ModelAndView page() {
        return new ModelAndView("webSocket");
    }

    @GetMapping("/push/{toUID}")
    @ApiOperation(value = "指定用户进行消息推送", notes = "指定用户进行消息推送")
    public ResultResponse<String> pushToClient(String message, @PathVariable String toUID) throws IOException {
        WebSocketServer.sendInfo(message, toUID);
        return new ResultResponse<>("send ok!");
    }

}
