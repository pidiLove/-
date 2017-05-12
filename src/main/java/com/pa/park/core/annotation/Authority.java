package com.pa.park.core.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.pa.park.core.enumtype.AuthorityType;

/** 
 * @author wangpei 
 * @version 创建时间：2017年5月12日 下午11:27:03 
 * 类说明 
 */
/*
 * Created by leeon on 2016/11/14
 */
@Documented
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Authority {
	AuthorityType authority() default AuthorityType.TOURIST;
}
