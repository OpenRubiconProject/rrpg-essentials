package com.openrubicon.essentials.chat.playerdata;

import com.openrubicon.core.api.server.players.interfaces.PlayerData;

/**
 * Created by Quinn on 12/17/2017.
 */
public class NickName implements PlayerData {

    private String nickName;

    public NickName(String nick){
        this.nickName = nick;
    }

    public String getNickName(){
        return this.nickName;
    }

    public void setNickName(String nick){
        this.nickName = nick;
    }

}
