package com.pa.park.web.service.serviceImp; 

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.pa.park.core.entity.Parkinglot;
import com.pa.park.core.entity.User;
import com.pa.park.core.vo.ParkinglotInfo;
import com.pa.park.web.dao.ParkingDao;
import com.pa.park.web.dao.UserDao;
import com.pa.park.web.service.UserService;

 
/** 
 * @author wangpei 
 * @version 
 *创建时间：2016年12月25日 上午9:29:32 
 * 类说明 
 */
@Service
@Transactional(rollbackForClassName={"RuntimeException","Exception"})
public class UserServiceImp implements UserService {
	@Autowired
	UserDao userDao;
	
	@Autowired
	ParkingDao parkingDao;
	
	@Override
	//@ReadThroughSingleCache(namespace="com.pa.park.core.entity.User") 
	public String getRoleByUsername(String phonenumber) {//通过用户电话号码，查找用户所拥有的角色信息
		try{
			return userDao.getRoleByUsername(phonenumber);
			
		}catch(Exception e){
			return null;
			
		}
		 
 		 
	}

@Override
//@ReadThroughSingleCache(namespace="com.pa.park.core.entity.User") 
public boolean login(String phonenumber, String password) {
	boolean b=userDao.login(phonenumber, password);
	
	 if(b==true){ 
		  //判断memcached中是否存在token,存在提醒用户不可重复登录
		  
		  //生成token，将token写入memcached,并将token返回给客户端
		  
		  
	  }
		try{
			return userDao.login(phonenumber, password);
			
		}catch(Exception e){
			
			return false;
			
		}
	}

	@Override
	public boolean regist(User us) {
		try{
			return userDao.regist(us);
			
		}catch(Exception e){
			System.out.println("主键已经存在了");
			return false;
			
		}
	}

	@Override
	public User getUserMessage(String phonenumber) {
		try{
			return userDao.getUserMessage(phonenumber);
			
		}catch(Exception e){
			
			return null;
			
		}
	}

	@Override
	public List<ParkinglotInfo> getUserCollect(String phonenumber) {
		
		List<Parkinglot> parkinglot=userDao.getUserCollect(phonenumber);
		List<ParkinglotInfo> ParkinglotInfo=new ArrayList<ParkinglotInfo >();
		ParkinglotInfo pf=null; 
		for(Parkinglot pl:parkinglot){
			int collect_number=parkingDao.getCollectUser(pl.getParking_id());
			int emptyCarSpace=parkingDao.getEmptyCarSpace(pl.getParking_id());
			pf=new ParkinglotInfo(pl.getParking_id(),pl.getParking_name(),pl.getParking_image(),pl.getParking_location(),pl.getCar_number(),pl.getFreight_basis(),pl.getReserve_time(),pl.getLongitude(),pl.getLatitude(),collect_number,emptyCarSpace);
			ParkinglotInfo.add(pf);
	
		}
		return ParkinglotInfo;
	}

	@Override
	public boolean updateNickname(String phonenumber, String newNickname) {
		try{
			return userDao.updateNickname(phonenumber, newNickname);
			
		}catch(Exception e){
			
			return false;
			
		}
	}

	@Override
	public boolean updatePhonenumber(String phonenumber, String newPhonenumber) {
		try{
			return userDao.updatePhonenumber(phonenumber, newPhonenumber);
			
		}catch(Exception e){
			
			return false;
			
		}
	}

	@Override
	public boolean updatePassword(String phonenumber, String newPassword) {
		try{
			return userDao.updatePassword(phonenumber, newPassword);
			
		}catch(Exception e){
			
			return false;
			
		}
	}
	

}
 