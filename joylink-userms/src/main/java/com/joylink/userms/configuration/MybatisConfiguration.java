package com.joylink.userms.configuration;

import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageHelper;
import com.joylink.userms.configuration.configProp.DataSourceConfig;
import com.joylink.userms.configuration.configProp.MybatisConfig;

@Configuration
@EnableTransactionManagement
@EnableConfigurationProperties(value= {DataSourceConfig.class, MybatisConfig.class})
public class MybatisConfiguration {
	
    @Autowired
	private DataSourceConfig dataSourceConfig;
    
    @Autowired
    private MybatisConfig mybatisConfig;

    @Bean
    public DataSource druidDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(this.dataSourceConfig.getUrl());
        druidDataSource.setUsername(this.dataSourceConfig.getUsername());
        druidDataSource.setPassword(this.dataSourceConfig.getPassword());
        druidDataSource.setDriverClassName(this.dataSourceConfig.getDriverClassName());
        druidDataSource.setMaxActive(this.dataSourceConfig.getMaxActive());
        druidDataSource.setInitialSize(this.dataSourceConfig.getInitialSize());
        druidDataSource.setMaxWait(this.dataSourceConfig.getMaxWait());
        druidDataSource.setMinIdle(this.dataSourceConfig.getMinIdle());
        druidDataSource.setTimeBetweenEvictionRunsMillis(this.dataSourceConfig.getTimeBetweenEvictionRunsMillis());
        druidDataSource.setMinEvictableIdleTimeMillis(this.dataSourceConfig.getMinEvictableIdleTimeMillis());
        druidDataSource.setValidationQuery(this.dataSourceConfig.getValidationQuery());
        druidDataSource.setTestWhileIdle(this.dataSourceConfig.getTestWhileIdle());
        druidDataSource.setTestOnBorrow(this.dataSourceConfig.getTestOnBorrow());
        druidDataSource.setTestOnReturn(this.dataSourceConfig.getTestOnReturn());
        druidDataSource.setPoolPreparedStatements(this.dataSourceConfig.getPoolPreparedStatements());
        druidDataSource.setMaxOpenPreparedStatements(this.dataSourceConfig.getMaxOpenPreparedStatements());

        try {
            druidDataSource.setFilters(this.dataSourceConfig.getFilters());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return druidDataSource;
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean(DataSource dataSource) {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
//        if(StringUtils.isNotBlank(typeAliasesPackage)){
//            bean.setTypeAliasesPackage(typeAliasesPackage);
//        }
        //分页插件
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("reasonable", "true");
        properties.setProperty("supportMethodsArguments", "true");
        properties.setProperty("returnPageInfo", "check");
        properties.setProperty("params", "count=countSql");
        pageHelper.setProperties(properties);
        //添加XML目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Interceptor[] plugins =  new Interceptor[]{pageHelper};
        bean.setPlugins(plugins);
        try {
            bean.setMapperLocations(resolver.getResources(this.mybatisConfig.getMapperLocations()));
            return bean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean
    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

}
