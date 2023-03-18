package com.sagem.emt.config.hibernate;

import java.util.Map;

import org.hibernate.Interceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class HibernateInterceptorRegistration implements HibernatePropertiesCustomizer {
    @Autowired
    private Interceptor hibernateInteceptor;

    @Override
    public void customize(Map<String, Object> hibernateProperties) {
	hibernateProperties.put("hibernate.session_factory.interceptor", hibernateInteceptor);
    }
}
