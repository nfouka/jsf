package com.concretepage;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.concretepage.model.Nationality;
import com.concretepage.model.Student;



@ManagedBean(name = "dataScrollerBean", eager = true)
@RequestScoped
@Component

public class DataScrollerBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	public StudentImpDAO StudentImpDAO ; 
	
	

	@Autowired
	public Nationality nationality ; 
	private List<Student> students ;
	private List<Student> studentsList = new ArrayList<>();
	
	public List<Student> getStudentsList() {
		return studentsList;
	}
	public void setStudentsList(List<Student> studentsList) {
		this.studentsList = studentsList;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	
	@Transactional
	public List<Student> list(){
		return StudentImpDAO.list() ; 
	}
	
	
	@Transactional
	public List listStudent(){
		List<Student> l = StudentImpDAO.list() ; 
		return l ; 
		
	}
	
	@Autowired
	private blabla bla ; 
	


	public blabla getBla() {
		return bla;
	}
	public void setBla(blabla bla) {
		this.bla = bla;
	}

	public String disMoi() {
		return bla.sayHello() ; 
	}

	private String logger ; 
	
    public String getLogger() {
    	
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	String namePrincipalRol = null;
    	if (auth instanceof AnonymousAuthenticationToken) {
    	    namePrincipalRol = "ROLE_ANONYMOUS";
    	} else {
    	    namePrincipalRol = auth.getAuthorities().iterator().next().getAuthority();
    	}
    	
    	UserDetails userDetails =
    			 (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	
		return userDetails.getUsername() + " ROLE : " + namePrincipalRol ; 
	}
	public void setLogger(String logger) {
		this.logger = logger;
	}



	@PostConstruct
	public void init() {

		students = StudentImpDAO.list() ; 
		
		for(int i=0 ; i< 100  ; i++) {
			Student st2 = new Student("Nadir "+ Math.random(), "Fouka "+ Math.random(), "nadir.fouka@"+Math.random()+".com", "+213 85 96 7850 80") ; 
						// StudentImpDAO.persist(st2); 
			}
	
		
		students = StudentImpDAO.list() ; 
		
	}


}