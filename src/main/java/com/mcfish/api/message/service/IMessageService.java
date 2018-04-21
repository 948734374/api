package com.mcfish.api.message.service;

public interface IMessageService {

    /**
     * 1，获取我的聊天室
     * @param uid
     * @return
     */
    Object getMyChatGroup(int uid);

    /**
     * 2，获取我的消息
     * @param uid
     * @return
     */
    Object myMessage(int uid);

    /**
     * 3，创建聊天室
     * @param uid
     * @param uids
     * @return
     */
    Object newChat(int uid, String uids);

}
