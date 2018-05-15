/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bt.pre.prob.ncs.challenge.logger;

import java.lang.reflect.Field;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

/**
 *
 * @author tuvshuu
 */
@Component
public class MyLoggerInjector implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessBeforeInitialization(final Object bean, String name) throws BeansException {
        ReflectionUtils.doWithFields(bean.getClass(), (Field field) -> {
            ReflectionUtils.makeAccessible(field);// make sure the field accessible if defined private
            if (field.getAnnotation(MyLogger.class) != null) {
                System.out.println("*** Injecting Logger " + name);
                Logger log = LogManager.getLogger(bean.getClass());
                field.set(bean, log);
            }
        });
        return bean;
    }
}
