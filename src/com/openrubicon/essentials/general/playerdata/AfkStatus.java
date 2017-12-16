package com.openrubicon.essentials.general.playerdata;

import com.openrubicon.core.api.server.players.interfaces.PlayerData;

public class AfkStatus implements PlayerData {

    public static boolean isAfk = false;

    public AfkStatus(){

    }

    public AfkStatus(boolean status){
        this.isAfk = status;
    }

    public void toggleAfk(){
        this.isAfk = this.isAfk == true? false : true;
    }

}
