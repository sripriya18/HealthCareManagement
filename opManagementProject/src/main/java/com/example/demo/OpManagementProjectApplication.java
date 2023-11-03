package com.example.demo;

import java.util.logging.Logger;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.demo.service.PersonalDetailsService;

@SpringBootApplication
@EnableJpaAuditing
@ComponentScan("com.demo")
@EntityScan(basePackages = {"com.demo.entity"})

@EnableJpaRepositories("com.demo.dao")

public class OpManagementProjectApplication {
	static Logger log = Logger.getLogger(OpManagementProjectApplication.class.getName());


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		log.info("project has started successfully...");
		ApplicationContext ctx =SpringApplication.run(OpManagementProjectApplication.class, args);
		
		//insertOp(task2)
		/*OpService ser=ctx.getBean(OpService.class);
				OpEntity obj=new OpEntity();
				obj.setOpName("hari");
				obj.setContactNumber(6785497834l);
			    PdEntity en=new PdEntity();
				en.setPdId(1);
				obj.setEnt(en);
				ser.insertOp(obj);
				
				//insertPd(task 1)
				PdService pd=ctx.getBean(PdService.class);
			PdEntity obj1=new PdEntity();
				obj1.setName("janaki");
				obj1.setPdId(1);
				obj1.setEmail("janaki@gmail.com");
				obj1.setStreet("devika street");
			    pd.insertPd(obj1);*/
		
		
		/* OpEntity p1 = new OpEntity();
		p1.setOpName("sri");
		p1.setContactNumber(6785434675l);
		
		OpEntity p2 = new OpEntity();
		p2.setOpName("priya");
		p2.setContactNumber(2345174675l);
		
		//insert Pd(task 3)
		PdEntity cu1 = new PdEntity();
		cu1.setName("sri");
		cu1.setEmail("sri@gmail.com");
		cu1.setStreet("SR street");
		
		//Associating Claim to Customer
		p1.setEnt(cu1);
		p2.setEnt(cu1);
		
		//Associating Customer with Claim
		List<OpEntity> cu2 = new ArrayList<OpEntity>();
		cu2.add(p1);
		cu2.add(p2);
		cu1.setOp(cu2);
		
		System.out.println("Adding patients.......");
		PdService service = ctx.getBean(PdService.class);
		service.insertPd(cu1);*/
		
		//------------------------------------------------------------------(crud)
		
		//PersonalDetailsService pd=ctx.getBean(PersonalDetailsService.class); 
		//PdEntity cu1 = new PdEntity();
		 
		
		//fetch
		//System.out.println(pd.findById(1));
		
		//fetchAll
		//System.out.println(pd.findAll());
		
		
		//update
		/*
		 * cu1.setPdId(1); cu1.setEmail("aishuu@gmail.com"); cu1.setName("aishu");
		 * cu1.setStreet("mullai street"); pd.updateOp(cu1);
		 */
		
		//transaction
		
		 //PdService svc = ctx.getBean(PdService.class);
			/*OpEntity pt = new OpEntity();
		pt.setOpName("krishna");
		pt.setContactNumber(5668753782l);
		
		
		
		PdEntity cust1 = new PdEntity();
		
		cust1.setPdId(7);
		
		pt.setEnt(cust1);
		
		PdEntity cust2 = new PdEntity();
		
		cust2.setName("madhu");
		cust2.setEmail("madhu@gmail.com");
		cust2.setStreet("nayak Street");
		
		
		svc.transactionDemo(cust2, pt);*/
		
		//filterById(@query)
		
		/*List<PdEntity> list=svc.filterById(1);
		System.out.println("Patient based on id"+list);*/
		
		//substring by @query
		/*List<PdEntity> list1=svc.filterByName("s");
		System.out.println("Patient based on id"+list1);*/
		
		/*
		 * List<customized> list2=svc.filterByCustomized("sri"); for(customized a:
		 * list2) { System.out.println("Customized Details: "+a.getStreet()); }
		 */
		//named query
		//System.out.println("output is:" + svc.findAllByDesc() );
		
		//left join
		/*List<PdEntity> list3 = svc.leftJoin();
		System.out.println("Applicant with left Join: " + list3);*/
		
		//inner join
		/*List<PdEntity> list4 = svc.innerJoin();
		System.out.println("Applicant with inner Join: " + list4);*/  
		
		/*List<customized> list5 = svc.customizedJoin();
		for(customized lst : list5) {
			System.out.println("customized join:" +lst.getName()+"-"+lst.getStreet()+"-"+lst.getEmail());
		}*/
		
		
		}
}


