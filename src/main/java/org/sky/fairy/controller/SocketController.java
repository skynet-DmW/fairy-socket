package org.sky.fairy.controller;

import org.sky.fairy.scoket.WebSocketServer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
/**
 * created albert on 2022/12/05
 */
@RestController()
@RequestMapping("socket")
public class SocketController {


    @GetMapping("/index")
    public ModelAndView index() {
        return new ModelAndView("index");
    }


    @RequestMapping("/push/{toUID}")
    public ResponseEntity<String> pushToClient(String message, @PathVariable String toUID) throws IOException {
        WebSocketServer.sendInfo(message, toUID);
        return ResponseEntity.ok("Send Success!");
    }

}