package com.demo.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.demo.dao.Customized;
import com.demo.dao.UserRepository;
import com.demo.dto.LoginRequest;
import com.demo.dto.PersonalDetailsDto;
import com.demo.entity.OutPatientEntity;
import com.demo.entity.PersonalDetailsEntity;
import com.demo.entity.User;
import com.demo.exception.NullException;
import com.demo.response.PatientResponse;
import com.demo.service.OutPatientService;
import com.demo.service.PersonalDetailsService;
@CrossOrigin
@RestController
public class MyPatients {
	static Logger log = Logger.getLogger(MyPatients.class.getName());

	@Autowired
	PersonalDetailsService bo1;

	@Autowired
	OutPatientService bo2;
	
    @Autowired
    private UserRepository userRepository;

	@RequestMapping("/sayHello")
	public String sayHello() {
		return "Say Hello";

	}

	@RequestMapping(value = "/createPatient", method = RequestMethod.POST)
	public PatientResponse<PersonalDetailsDto> insertPd(@RequestBody PersonalDetailsDto msg) {
		
		System.out.println("name:" + msg.getName());
		System.out.println("email:" + msg.getEmail());
		System.out.println("street:" + msg.getStreet());

		PersonalDetailsEntity p = new PersonalDetailsEntity();
		p.setName(msg.getName());
		p.setEmail(msg.getEmail());
		p.setStreet(msg.getStreet());

		PersonalDetailsEntity p1 = bo1.insertPd(p);
		msg.setPdId(p1.getPdId());
		msg.setCreatedAt(p1.getCreatedAt());
		msg.setUpdatedAt(p1.getUpdatedAt());
		

		return new PatientResponse<>(true, "Patient created successfully", msg);

	}

	@RequestMapping(value = "/findPatient", method = RequestMethod.GET)
	public PatientResponse<PersonalDetailsDto> findById(@RequestParam int pdId) {
		

		System.out.println("id" + pdId);
		PersonalDetailsEntity a = bo1.findById(pdId);
		PersonalDetailsDto dto = new PersonalDetailsDto();
		dto.setPdId(a.getPdId());
		dto.setName(a.getName());
		dto.setEmail(a.getEmail());
		dto.setStreet(a.getStreet());
		dto.setCreatedAt(a.getCreatedAt());
		dto.setUpdatedAt(a.getUpdatedAt());
		

		return new PatientResponse<>(true, "Patient found successfully", dto);

	}

	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public PatientResponse<List<PersonalDetailsEntity>> findAll() {
		

		List<PersonalDetailsEntity> fetchAll = bo1.findAll();
		

		return new PatientResponse<>(true, "Patients fetched successfully", fetchAll);
	}

	@RequestMapping(value = "/updatePatient/{pdId}", method = RequestMethod.POST)
	public PatientResponse<PersonalDetailsDto> updateOp(@PathVariable("pdId") int pdId,
			@RequestBody PersonalDetailsDto msg) {
		

		System.out.println("name:" + msg.getName());
		System.out.println("email:" + msg.getEmail());
		System.out.println("street:" + msg.getStreet());

		PersonalDetailsEntity q = bo1.findById(pdId);
		q.setName(msg.getName());
		q.setEmail(msg.getEmail());
		q.setStreet(msg.getStreet());

		PersonalDetailsEntity q1 = bo1.updateOp(q);
		PersonalDetailsDto q2 = new PersonalDetailsDto();
		q2.setPdId(q1.getPdId());
		q2.setName(q1.getName());
		q2.setEmail(q1.getEmail());
		q2.setStreet(q1.getStreet());
		q2.setCreatedAt(q1.getCreatedAt());
		q2.setUpdatedAt(q1.getUpdatedAt());
		

		return new PatientResponse<>(true, "Patient updated successfully", q2);
	}

	@RequestMapping(value = "/findByNameCustomized", method = RequestMethod.GET)
	public PatientResponse<List<Customized>> findByCustomized(@RequestParam String name) {
		
		List<Customized> list = bo1.filterByCustomized(name);
		return new PatientResponse<>(true, "found successfully", list);
	}

	// child cred

	@RequestMapping(value = "/createOp", method = RequestMethod.POST)
	public PatientResponse<OutPatientEntity> addCred2(@RequestBody OutPatientEntity msg) {

		System.out.println("ID:" + msg.getEnt().getPdId());
		System.out.println("Name:" + msg.getOpName());
		System.out.println("contact Number:" + msg.getContactNumber());
		PersonalDetailsEntity c1 = bo1.findById(msg.getEnt().getPdId());

		System.out.println("Op Details response--->" + c1);
		OutPatientEntity p = new OutPatientEntity();
		p.setOpName(msg.getOpName());
		p.setContactNumber(msg.getContactNumber());
		OutPatientEntity q3 = bo2.insertOp(msg);
		System.out.println("op added successfully");
		return new PatientResponse<>(true, "inserted successfully", msg);

	}

	@RequestMapping(value = "/fetchOPId", method = RequestMethod.GET)
	public PatientResponse<OutPatientEntity> fetchPers(@RequestParam int id) {
		System.out.println("Id: " + id);
		OutPatientEntity p = bo2.findById(id);
		p.getOpName();
		p.getContactNumber();
		p.getOpId();
		p.getUpdatedAT();
		p.getUpdatedAT();

		System.out.println("OP fetched successfully...");
		return new PatientResponse<>(true, "fetched the child details successfully", p);
	}

	// fetchAll(child)
	@RequestMapping(value = "/fetchAllOP", method = RequestMethod.GET)
	public PatientResponse<List<OutPatientEntity>> fetchAllop() {
		List<OutPatientEntity> fetchAll = bo2.findAll();
		return new PatientResponse<>(true, "fetched all successfully", fetchAll);
	}

	@RequestMapping(value = "/updateOp/{OpId}", method = RequestMethod.POST)
	public PatientResponse<OutPatientEntity> updateOp(@PathVariable("opId") int opId, @RequestBody OutPatientEntity update) {
		System.out.println("name:" + update.getOpName());
		System.out.println("contact number:" + update.getContactNumber());
		OutPatientEntity p = bo2.findById(opId);

		p.setOpName(update.getOpName());
		p.setContactNumber(update.getContactNumber());

		OutPatientEntity result = bo2.updateOp(p);
		System.out.println("Op updated successfully...");
		return new PatientResponse<>(true, "updated successfully", result);
	}

	@RequestMapping(value = "/greaterThanId", method = RequestMethod.GET)
	public PatientResponse<List<PersonalDetailsEntity>> getPatientById(@RequestParam int pdId) {
		

		List<PersonalDetailsEntity> g = bo1.filterById(pdId);
		return new PatientResponse<>(true, "fetched the greater than id details successfully", g);
	}

	@RequestMapping(value = "/namedQueryFindAll", method = RequestMethod.GET)
	public PatientResponse<List<PersonalDetailsEntity>> findAllOrderByNameDescending() {
		
		List<PersonalDetailsEntity> list = bo1.findAllByDesc();
		return new PatientResponse<>(true, "fetched named query successfully", list);
	}

	@RequestMapping(value = "/InnerJoin", method = RequestMethod.GET)
	public PatientResponse<List<PersonalDetailsEntity>> innerJoin() {
		List<PersonalDetailsEntity> list = bo1.innerJoin();
		return new PatientResponse<>(true, "fetched inner join  query successfully", list);
	}

	@RequestMapping(value = "/LeftJoin", method = RequestMethod.GET)
	public PatientResponse<List<PersonalDetailsEntity>> leftJoin() {
		List<PersonalDetailsEntity> list = bo1.leftJoin();
		return new PatientResponse<>(true, "fetched left join  query successfully", list);
	}

	@RequestMapping(value = "/customizeQuery", method = RequestMethod.GET)
	public PatientResponse<List<Customized>> findPatientCustomized() {
		List<Customized> list = bo1.customizedJoin();
		return new PatientResponse<>(true, "fetched customized join query successfully", list);
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> login(@RequestBody LoginRequest request) {
        Map<String, Object> response = new HashMap<>();

        User user = userRepository.findByUsername(request.getUsername());

        if (user != null && user.getPassword().equals(request.getPassword())) {
            response.put("success", true);
            response.put("message", "Login successful");
            return ResponseEntity.ok(response);
        } else {
            response.put("success", false);
            response.put("message", "Invalid credentials");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }

	@RestControllerAdvice
	public class GlobalExceptionHandler {
		@ExceptionHandler(NullException.class)
		public ResponseEntity<String> handlePatientDataException(NullException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
		}
	}
}
