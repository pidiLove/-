package com.pa.park.web.service.serviceImp; 

 
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.pa.park.core.entity.Check;
import com.pa.park.core.vo.ParkingCheckInfo;
import com.pa.park.web.dao.CheckDao;
import com.pa.park.web.dao.ParkingDao;
import com.pa.park.web.service.CheckService;

/** 
 * @author wangpei 
 * @version 
 *创建时间：2016年12月25日 上午9:32:48 
 * 订单模型层的实现类
 */
@Service
@Transactional(rollbackForClassName={"RuntimeException","Exception"})
public class CheckServiceImp implements CheckService {
	 
   

	@Autowired
	CheckDao checkDao;
	

	@Autowired
	ParkingDao parkingDao;
	
	@Override
	public boolean addCheck(Check ck) {
		try{
			return checkDao.addCheck(ck);
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
			
		}
	}
	
	//@ReadThroughSingleCache(namespace="com.pa.park.core.entity.Check") 
//	public List<ParkingCheckInfo> getAllCheck(@ParameterValueKeyProvider String phonenumber) {
//		/*List<Parkinglot> parkinglot=parkingDao.getLocalPark(longitude, latitude);
//		List<ParkinglotInfo> ParkinglotInfo=new ArrayList<ParkinglotInfo >();
//		ParkinglotInfo pf=null; 
//		for(Parkinglot pl:parkinglot){
//			int collect_number=parkingDao.getCollectUser(pl.getParking_id());
//			int emptyCarSpace=parkingDao.getEmptyCarSpace(pl.getParking_id());
//			pf=new ParkinglotInfo(pl.getParking_id(),pl.getParking_name(),pl.getParking_image(),pl.getParking_location(),pl.getCar_number(),pl.getFreight_basis(),pl.getReserve_time(),pl.getLongitude(),pl.getLatitude(),collect_number,emptyCarSpace);
//			ParkinglotInfo.add(pf);
//	
//		}*/
//		try{
//			List<Check> Park=checkDao.getAllCheck(phonenumber);
//			List<ParkinglotInfo> ParkinglotInfo=new ArrayList<ParkinglotInfo >();
//			for(Parkinglot pl:parkinglot){
//				int collect_number=parkingDao.getCollectUser(pl.getParking_id());
//				int emptyCarSpace=parkingDao.getEmptyCarSpace(pl.getParking_id());
//				pf=new ParkinglotInfo(pl.getParking_id(),pl.getParking_name(),pl.getParking_image(),pl.getParking_location(),pl.getCar_number(),pl.getFreight_basis(),pl.getReserve_time(),pl.getLongitude(),pl.getLatitude(),collect_number,emptyCarSpace);
//				ParkinglotInfo.add(pf);
//		
//			}
//			return checkDao.getAllCheck(phonenumber);
//			
//		}catch(Exception e){
//			e.printStackTrace();
//			return null;
//			
//		}
//	}

	@Override
	//@ReadThroughSingleCache(namespace="com.pa.park.core.entity.Check")
	public List<ParkingCheckInfo> getCheckByStatus( String phonenumber,  String checkStatus) {
		//先不考虑用户对应的停车场信息
 		 try{
 			return checkDao.getCheckByStatus(phonenumber, checkStatus);			
		}catch(Exception e){
			e.printStackTrace();
			return null;
			
		}
		 
	}

 
 

	

}
 