package test;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ext.campus.bo.SceneryBo;
import com.ext.campus.bo.SchoolBo;
import com.ext.campus.po.Scenery;
import com.ext.campus.po.School;


public class UserTest {
	private String msg = " ";
	/*@Test
	public void savePubmed() {

		try {
			ApplicationContext appCxt = new ClassPathXmlApplicationContext("beans.xml");		
			UserInformationBo bo = (UserInformationBo)(appCxt.getBean("userInformationBo"));	
			UserInformation userInformation=new UserInformation();
			userInformation.setId(1);
			userInformation.setlSchoolId(2);
			userInformation.setgSchoolId(1);
			bo.saveUserInformation(userInformation);
			System.out.println("保存成功......");		
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	/*@Test
	public void addShareGal() {

		try {
		
			ApplicationContext appCxt = new ClassPathXmlApplicationContext("beans.xml");		
			ShareBo bo = (ShareBo)(appCxt.getBean("shareBo"));	
			Share share=new Share();
			share.setId(5);
			share.setClickNumber(3);
	         msg =  bo.updateGaL(5,3);
			System.out.println(msg);		
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	/*@Test
	public void listAllByShareId() {

		try {
			
			ApplicationContext appCxt = new ClassPathXmlApplicationContext("beans.xml");		
			ShareFirstCommentViewBo bo = (ShareFirstCommentViewBo)(appCxt.getBean("shareFirstCommentViewBo"));	
			ShareFirstCommentView shareFirstComment=new ShareFirstCommentView();
			shareFirstComment.setShareId(5);			
			List<ShareFirstCommentView> list = bo.listAllById(5);
			System.out.println(list);		
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	/*@Test
	public void listAllFCById() {

		try {
			
			ApplicationContext appCxt = new ClassPathXmlApplicationContext("beans.xml");		
			ShareViewBo bo = (ShareViewBo)(appCxt.getBean("shareViewBo"));	
			ShareView shareView=new ShareView();
			shareView.setId(5);			
			List<ShareView> list = bo.findAllShareView();
			System.out.println(list);		
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
	/*@Test
	public void listActivitiesById() {

		try {
			
			ApplicationContext appCxt = new ClassPathXmlApplicationContext("beans.xml");		
			ActivitiesBo bo = (ActivitiesBo)(appCxt.getBean("activitiesBo"));	
			Activities activities=new Activities();		
			activities = bo.findById(3);
			System.out.println(activities);		
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
	/*@Test
	public void findUserById() {

		try {
			
			ApplicationContext appCxt = new ClassPathXmlApplicationContext("beans.xml");		
			UserInformationBo bo = (UserInformationBo)(appCxt.getBean("userInformationBo"));	
			UserInformation userInformation=new UserInformation();		
			userInformation = bo.findUserInformationById(2);
			System.out.println(userInformation);		
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	/*@Test
	public void listGoodsView() {

		try {
			
			ApplicationContext appCxt = new ClassPathXmlApplicationContext("beans.xml");		
			GoodsViewBo bo = (GoodsViewBo)(appCxt.getBean("goodsViewBo"));	
			List<GoodsView> goodsView= new ArrayList<GoodsView>();		
			goodsView = bo.getAllGoodsView();
			System.out.println(goodsView);		
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	/*@Test
	public void listScenery() {

		try {
			
			ApplicationContext appCxt = new ClassPathXmlApplicationContext("beans.xml");		
			SceneryBo bo = (SceneryBo)(appCxt.getBean("sceneryBo"));	
			List<Scenery> goodsView= new ArrayList<Scenery>();		
			goodsView = bo.getAllScenery();
			System.out.println(goodsView);		
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	@Test
	public void listScenery() {

		try {
			
			ApplicationContext appCxt = new ClassPathXmlApplicationContext("beans.xml");		
			SchoolBo bo = (SchoolBo)(appCxt.getBean("schoolBo"));	
			List<School> goodsView= new ArrayList<School>();		
			goodsView = bo.getAllSchool();
			System.out.println(goodsView);		
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*@Test
	public void deletePubmed() {

		try {
			ApplicationContext appCxt = new ClassPathXmlApplicationContext("beans.xml");		
			PubmedBo bo = (PubmedBo)(appCxt.getBean("pubmedBo"));	
			//Employment employment=new Employment();
			bo.deletePubmed("559c7816-af03-4521-8fb4-f5ccb820ff32");
			System.out.println("删除成功......");
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void getPubmedView() {

		try {
			ApplicationContext appCxt = new ClassPathXmlApplicationContext("beans.xml");		
			PubmedBo bo = (PubmedBo)(appCxt.getBean("pubmedBo"));	
		//	EmploymentView employmentView=new EmploymentView();
        	bo.getPubmedView("ac4b8c09-7bd9-4592-9783-6dbbc52f9bfe");
			System.out.println("查询成功......");
				
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void savePubmedClassify() {

		try {
			ApplicationContext appCxt = new ClassPathXmlApplicationContext("beans.xml");		
			PubmedBo bo = (PubmedBo)(appCxt.getBean("pubmedBo"));	
			PubmedClassify pubmedClassify=new PubmedClassify();
			pubmedClassify.setName("211");
			pubmedClassify.setNotes("名牌大学");
			bo.savePubmedClassify(pubmedClassify);
			System.out.println("保存成功......"+pubmedClassify);		
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void deletePubmedClassify() {

		try {
			ApplicationContext appCxt = new ClassPathXmlApplicationContext("beans.xml");		
			PubmedBo bo = (PubmedBo)(appCxt.getBean("pubmedBo"));	
			bo.deletePubmedClassify("0b803052-7647-485d-af54-35827908779a");
			System.out.println("删除成功......");
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void getPubmedClassify() {

		try {
			ApplicationContext appCxt = new ClassPathXmlApplicationContext("beans.xml");		
			PubmedBo bo = (PubmedBo)(appCxt.getBean("pubmedBo"));	
			//EmploymentClassify employmentClassify=new EmploymentClassify();
			List<PubmedClassify> list = new ArrayList<PubmedClassify>();
			list = bo.getPubmedClassify();
			System.out.println("查询成功......"+list.toString());
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void listPubmedView() {

		try {
			ApplicationContext appCxt = new ClassPathXmlApplicationContext("beans.xml");		
			PubmedBo bo = (PubmedBo)(appCxt.getBean("pubmedBo"));	
			PubMedView pubMedView = new PubMedView();
			int flag=1;
			Page<PubMedView> page = new Page<PubMedView>();
			page.setPageSize(3);
			page.setPageNo(1);
			page = bo.listPubmedView(page, pubMedView, flag);
			System.out.println("查询成功......"+page.getResult().toString());
			//System.out.println(page.getPageSize());
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
}
