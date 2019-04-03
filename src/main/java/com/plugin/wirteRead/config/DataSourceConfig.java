package com.plugin.wirteRead.config;



import com.plugin.wirteRead.bean.MyRoutingDataSource;
import com.plugin.wirteRead.enums.DBTypeEnum;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.apache.tomcat.jdbc.pool.DataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 关于数据源配置，参考SpringBoot官方文档第79章《Data Access》
 * 79. Data Access
 * 79.1 Configure a Custom DataSource
 * 79.2 Configure Two DataSources
 */

@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
public class DataSourceConfig {

   public static List<DataSource> slave = new ArrayList<>();
   private DataSource master;

    public DataSource getMaster() {
        return master;
    }

    public void setMaster(DataSource master) {
        this.master = master;
    }

    public List<DataSource> getSlave() {
        return slave;
    }

    public void setSlave(List<DataSource> slave) {
        this.slave = slave;
    }

    /*@Bean
    @ConfigurationProperties("spring.datasource.master")
    public DataSource masterDataSource() {
        return DataSourceBuilder.create().build();
    }*/

   /* @Bean
    @ConfigurationProperties("spring.datasource.slave1")
    public DataSource slave1DataSource() {

        return DataSourceBuilder.create().build();
    }*/



    /*@Bean
    @ConfigurationProperties("spring.datasource.slave2")
    public DataSource slave2DataSource() {
        return DataSourceBuilder.create().build();
    }*/

    @Bean
    public MyRoutingDataSource myRoutingDataSource(){
                                         // @Qualifier("slave1DataSource") DataSource slave1DataSource,
                                          //@Qualifier("slave2DataSource") DataSource slave2DataSource) {

        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DBTypeEnum.MASTER+"master", master);
        for (int i=0;i<slave.size();i++){
            targetDataSources.put(DBTypeEnum.SLAVE+String.valueOf(i), slave.get(i));
        }
        //targetDataSources.put(DBTypeEnum.SLAVE1, slave.get(0));
     //   targetDataSources.put(DBTypeEnum.SLAVE2,  slave.get(1));
        MyRoutingDataSource myRoutingDataSource = new MyRoutingDataSource();
        myRoutingDataSource.setDefaultTargetDataSource(master);
        myRoutingDataSource.setTargetDataSources(targetDataSources);
        return myRoutingDataSource;
    }

}