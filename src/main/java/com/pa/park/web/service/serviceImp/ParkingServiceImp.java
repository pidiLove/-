package com.pa.park.web.service.serviceImp; 


import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.pa.park.core.entity.Parkinglot;
import com.pa.park.core.vo.ParkinglotInfo;
import com.pa.park.web.dao.ParkingDao;
import com.pa.park.web.service.ParkingService;

 

/** 
 * @author wangpei 
 * @version 
 *创建时间：2016年12月25日 上午9:30:13 
 * 类说明 
 */

@Service
@Transactional(rollbackForClassName={"RuntimeException","Exception"})
public class ParkingServiceImp implements ParkingService {
	
	@Autowired
	ParkingDao parkingDao;
 
	@Override
 	public List<ParkinglotInfo> getLocalPark(double longitude,double latitude) {
		List<Parkinglot> parkinglot=parkingDao.getLocalPark(longitude, latitude);
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
	public int getEmptyCarSpace(String parking_id) {
 		return 0;
	}

	@Override
	public int getCollectUser(String parking_id) {
 		return 0;
	}

	@Override
	//@ReadThroughSingleCache(namespace="com.pa.park.core.entity.Parkinglot")
	public String getParking_id(double longitude, double latitude) {
		try{
		return parkingDao.getParking_id(longitude, latitude);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String selectIn(Parkinglot pl) {
		try{
			return parkingDao.selectIn(pl);
				 
			}
		catch(Exception e){
			return null;
		}
	}
	

	@Override
	//@ReadThroughSingleCache(namespace="com.pa.park.core.entity.Parkinglot")
	public Parkinglot getParking_Information(String parking_id) {
		
		try{
			return parkingDao.getParking_Information(parking_id);
				 
			}
		catch(Exception e){
			return null;
		}
	}

	@Override
 	public List<ParkinglotInfo> searchParkByName(String parking_name) {

		List<Parkinglot> parkinglot=parkingDao.searchParkByName(parking_name);
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
  }
 