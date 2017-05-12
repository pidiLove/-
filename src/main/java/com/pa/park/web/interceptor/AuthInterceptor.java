package com.pa.park.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.pa.park.core.annotation.Authority;
import com.pa.park.core.enumtype.AuthorityType;

/** 
 * @author wangpei 
 * @version 创建时间：2017年5月12日 下午11:07:50 
 * 拦截器类
 */
public class AuthInterceptor  extends HandlerInterceptorAdapter  {@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    
    if(handler.getClass().isAssignableFrom(HandlerMethod.class)){
    	String token=request.getParameter("token");//获得其验证的token
    	//将token与缓存中的token进行对比，
    	//token相同
    	
        Authority authority = ((HandlerMethod) handler).getMethodAnnotation(Authority.class); 
        //没有声明需要权限,或者声明不验证权限
        if(authority == null || authority.authority() == AuthorityType.TOURIST)//如果是游客或者方法上面没有添加注解则直接让其过。
            return true;
        else{ 
        	int index = authority.authority().getIndex();
            int authIndex = (Integer)request.getSession().getAttribute("authority");//将token与缓存中的token,authority进行对比，
            if(authIndex >= index)//有权限且用户处于登录状态，则让其通行
                return true;
            else
            {
               // response.sendRedirect("/tccp/page/noauth");
                return false;
            }       
        }
    }
    else
        return true;   
 }}
