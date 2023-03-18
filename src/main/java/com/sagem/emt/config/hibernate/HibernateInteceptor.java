package com.sagem.emt.config.hibernate;

import org.hibernate.CallbackException;
import org.hibernate.Interceptor;
import org.hibernate.type.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sagem.emt.dao.entity.Equipment;
import com.sagem.emt.service.NotificationService;

//@Component
public class HibernateInteceptor implements Interceptor {
    @Autowired
    private NotificationService	notificationService;

    @Override
    public boolean onSave(Object entity, Object id, Object[] state, String[] propertyNames, Type[] types)
	    throws CallbackException {
	System.out.println("hibernate inteceptor");
	notificationService.notification("save " + entity.getClass().getName(), entity.toString());
	if (entity instanceof Equipment) {
	    Equipment equipment = Equipment.class.cast(entity);
	    if (!equipment.isAvailable()) {
	    }
	}
	return Interceptor.super.onSave(entity, id, state, propertyNames, types);
    }
}
