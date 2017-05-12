//package com.pa.park.core.shiro;
//
// 
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.authc.AuthenticationException;
//import org.apache.shiro.authc.AuthenticationInfo;
//import org.apache.shiro.authc.AuthenticationToken;
//import org.apache.shiro.authc.SimpleAuthenticationInfo;
//import org.apache.shiro.authc.UsernamePasswordToken;
//import org.apache.shiro.authz.AuthorizationInfo;
//import org.apache.shiro.authz.SimpleAuthorizationInfo;
//import org.apache.shiro.realm.AuthorizingRealm;
//import org.apache.shiro.subject.PrincipalCollection;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.pa.park.core.entity.User;
//import com.pa.park.web.dao.UserDao;
//
// 
//
//
///**
// * @author wangpei
// * @version  
// * 
// */
//public class MyRealm extends AuthorizingRealm {
//	
//	@Autowired
//	UserDao userService;
//
//	 
//	@Override
//	protected AuthorizationInfo doGetAuthorizationInfo(
//			PrincipalCollection principals) {
//		String username = String.valueOf(principals.getPrimaryPrincipal());
//		
//        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
//        System.out.println(userService.getRoleByUsername(username));
//        authorizationInfo.addRole(userService.getRoleByUsername(username));
//     //  authorizationInfo.addStringPermissions(userService.getPermissionByUsername(username));
//        return authorizationInfo;
//	}
//
//	 
//	@Override
//	protected AuthenticationInfo doGetAuthenticationInfo(
//			AuthenticationToken authcToken) throws AuthenticationException {
////
////		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
////		String username = (String) token.getPrincipal(); 
////		String password = new String((char[]) token.getCredentials());
////		System.out.println(username);
////		System.out.println(password);
////		Map<String, String> map = new HashMap<String, String>();
////		map.put("username", username);
////		map.put("password", password);
////
////		List<User> us = userService.getUserByUsername(username);  
////
////		if (us.get(0) != null) {
////			SecurityUtils.getSubject().getSession().setAttribute("user", us); 
////			SecurityUtils.getSubject().getSession().setTimeout(10000);  
////			AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(
////			us.get(0).getUsername(), us.get(0).getPassword(), "MyRealm");
////			return authcInfo;
////		} else {
////			return null;
////		}
//		return null;
//
//	}
//
//
//}
