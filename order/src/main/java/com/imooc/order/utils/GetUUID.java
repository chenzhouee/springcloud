package com.imooc.order.utils;

import java.util.UUID;

public class GetUUID {

    public static synchronized String getUuid() {
        UUID uuid = UUID.randomUUID();
        String id = (uuid.toString()).replaceAll("-","");
        return id;
    }
}
