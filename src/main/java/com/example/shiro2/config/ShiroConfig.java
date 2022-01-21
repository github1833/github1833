package com.example.shiro2.config;


import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Bean 
    public IniRealm getIniRealm(){
        IniRealm iniRealm = new IniRealm("classpath:shiro.ini");
        return iniRealm;
    }


    @Bean
    public DefaultWebSecurityManager getDefaultSecurityManager(IniRealm iniRealm){
        // 这里不是 DefaultSecurityManager 而是 DefaultWebSecurityManager
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(iniRealm);
        return defaultWebSecurityManager;

    }

    @Bean
    public ShiroFilterFactoryBean shiroFilter(DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean filter = new ShiroFilterFactoryBean();

        /**
         * 添加 Shiro 内置过滤器
         * Shiro 内置过滤器， 可以实现权限相关的拦截器
         * 常用的过滤器：
         *      anon: 无需认证(登录)即可访问   anonomy 匿名用户
         *      authc: 必须认证才可访问
         *      user: 如果使用 rememberMe
         *      perms: 该资源必须得到资源权限才能访问
         *      role: 该资源必须得到角色权限才可访问
         */

        // 过滤器进行校验是需要 security Manager
        filter.setSecurityManager(defaultWebSecurityManager);

        // 设置shiro的拦截规则
        Map<String,String> filterMap = new HashMap<>();
        filterMap.put("/","anon");
        filterMap.put("/login.html","anon");
//        filterMap.put("/register.html","anon");
        filterMap.put("/user/login","anon");
//        filterMap.put("/user/register","anon");
        filterMap.put("/static/**","anon");
        filterMap.put("/**","authc");

        filter.setFilterChainDefinitionMap(filterMap);

        // 设置默认的登录页
        filter.setLoginUrl("/login.html");

        // 设置未授权访问的URl
        filter.setUnauthorizedUrl("/login.html");

        return filter;
    }
}
