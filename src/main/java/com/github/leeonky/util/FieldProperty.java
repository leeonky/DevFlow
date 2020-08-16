package com.github.leeonky.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Type;

abstract class FieldProperty<T> extends AbstractProperty<T> {
    final Field field;

    FieldProperty(BeanClass<T> beanClass, Field field) {
        super(beanClass);
        this.field = field;
    }

    @Override
    public String getName() {
        return field.getName();
    }

    @Override
    public <A extends Annotation> A getAnnotation(Class<A> annotationClass) {
        return AnnotationGetter.getInstance().getAnnotation(field, annotationClass);
    }

    @Override
    protected Type provideGenericType() {
        return field.getGenericType();
    }
}
