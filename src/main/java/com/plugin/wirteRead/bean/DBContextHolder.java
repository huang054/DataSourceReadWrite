package com.plugin.wirteRead.bean;


import com.plugin.wirteRead.config.DataSourceConfig;
import com.plugin.wirteRead.enums.DBTypeEnum;

import java.util.concurrent.atomic.AtomicInteger;

public class DBContextHolder {

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    private static final AtomicInteger counter = new AtomicInteger(0);

    public static void set(String dbType) {
        contextHolder.set(dbType);
    }

    public static String get() {
        return contextHolder.get();
    }

    public static void master() {
        set(DBTypeEnum.MASTER+"master");
        System.out.println("切换到master");
    }

    public static void slave() {
        //  轮询
        int index = counter.getAndIncrement() % DataSourceConfig.slave.size();
        if (counter.get() > 9999) {
            counter.set(0);
        }

            set(DBTypeEnum.SLAVE+String.valueOf(index));
            System.out.println("切换到slave"+index);

    }

}