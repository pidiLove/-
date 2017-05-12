package parking;
/** 
 * @author wangpei 
 * @version 
 *创建时间：2016年12月18日 下午5:20:42 
 * 类说明 
 */
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pa.park.core.entity.Parkinglot;
import com.pa.park.web.dao.CheckDao;
import com.pa.park.web.dao.ParkingDao;

  

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/spring-application.xml")
public class TestMybatis {
	
	@Autowired
 	public CheckDao  parkDao;

	
	@org.junit.Test
	public void testInsert(){
		//Play(int play_id,int play_type_id,String play_name,String play_introduction,String play_image,int play_length,float play_ticket_price,int play_status)
		 
	 Parkinglot p=new Parkinglot();
	//System.out.println(parkDao.login("18209183861","123456"));  
		 
		System.out.println(parkDao.getCheckByStatus("18209183861", "1"));
		
	}
	
	
	
	
//	@org.junit.Test
//	public void testFind(){
//		System.out.println(test.find("04131004").toString());
//	}
//	
//	@org.junit.Test
//	public void testUpdate(){
//		Test test1 = new Test("04131004", "updateName");
//		System.out.println(test.update(test1));
//	}
//	
//	@org.junit.Test
//	public void testFindAll(){
//		List<Test> list = test.findAll();
//		for (Test test : list) {
//			System.out.println(test.toString());
//		}
//	}
//	
//	@org.junit.Test
//	public void testDelete(){
//		System.out.println(parkDao.getCheckByStatus("18209183861", "0").get(0).getParking_id());
//	}
//	
//	
}

 