package com.mcfish.api.message.controller;

import com.mcfish.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@SuppressWarnings("unchecked")
public class MessageController extends BaseController{

    /**
     * 1，获取我的聊天室
     * @param req
     * @return
     * @throws Exception
     */
    @RequestMapping(
            value = "/getMyChatGroup",
            method = RequestMethod.GET,
            produces = "text/json;charset=UTF-8")
    public Object getMyChatGroupRoot (
            HttpServletRequest req) throws Exception{
        return messageService.getMyChatGroup(req.getIntHeader("uid"));
    }


    /**
     * 2，获取我的消息
     * @param req
     * @return
     * @throws Exception
     */
    @RequestMapping(
            value = "/myMessage",
            method = RequestMethod.GET,
            produces = "text/json;charset=UTF-8")
    public Object myMessageRoot (
            HttpServletRequest req) throws Exception{
        return messageService.myMessage(req.getIntHeader("uid"));
    }


    /**
     * 3，创建聊天室
     * @param uids
     * @param req
     * @return
     * @throws Exception
     */
    @RequestMapping(
            value = "/newChat",
            method = RequestMethod.POST,
            produces = "text/json;charset=UTF-8")
    public Object newChatRoot (
            @RequestParam(required = true) String uids,
            HttpServletRequest req) throws Exception{
        return messageService.newChat(req.getIntHeader("uid"), uids);
    }
}
