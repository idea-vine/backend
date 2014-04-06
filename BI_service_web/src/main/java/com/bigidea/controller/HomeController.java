package com.bigidea.controller;



import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bigidea.entity.Greeting;
import com.bigidea.entity.Ideas;
import com.bigidea.entity.Scores;
import com.bigidea.entity.Users;
import com.bigidea.service.IdeaService;
import com.bigidea.service.UserService;

@Controller
public class HomeController extends RestServiceController{

	

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    
    @Autowired
    private IdeaService ideaService; 
    
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/greeting", method = RequestMethod.GET, headers = "content-type=application/*")
    public @ResponseBody Greeting greeting(
            @RequestParam(value="name", required=false, defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    
    
    
    @RequestMapping(value = "/idea/save", method = RequestMethod.POST, headers = "content-type=application/*")
    public  @ResponseBody ServiceResponse<String,Ideas> save(@RequestBody Ideas i) {
    	
    	i = ideaService.saveIdeas(i);
    	ServiceResponse<String, Ideas> response = new ServiceResponse<String, Ideas>(null, i, false);
    	return response;
    	
    }
    
    @RequestMapping(value = "/idea/all", method = RequestMethod.GET, headers = "content-type=application/*")
    public @ResponseBody ServiceResponse<String, List<Ideas>> getAllIdeas(){
    	List<Ideas> ideList = ideaService.getAllIdeas();
    	ServiceResponse<String , List<Ideas>> response = new ServiceResponse<String, List<Ideas>>(null, ideList, false);
    	return response;
    	
    
    }
    
    @RequestMapping(value = "/idea/id", method = RequestMethod.GET, headers = "content-type=application/*")
    public @ResponseBody ServiceResponse<String, Ideas> getIdeasById(@PathVariable long id){
    	ServiceResponse<String , Ideas> response;
    	if (id > 0 ){
    		
    		Ideas ide = ideaService.getIdea(new Long(id).intValue());
        	response = new ServiceResponse<String, Ideas>(null, ide, false);
    	}else{
    		//Ideas ideas = new Ideas();
    		response = new ServiceResponse<String, Ideas>("NOIDEA", null, true);
    	}
    	return response;
    	
    
    }
    
    @RequestMapping(value = "/idea/id", method = RequestMethod.DELETE, headers = "content-type=application/*")
    public void deleteIdeasById(@PathVariable long id){
    	
    	if (id > 0 ){
    		Ideas ide = ideaService.getIdea(new Long(id).intValue());
    		if (ide != null && ide.getId() > 0 ){
    		    ideaService.deleteIdea(ide);
    		}
    	}
    	
   }
    
    // Get Idea by User
    @RequestMapping(value = "/idea/user/id", method = RequestMethod.GET, headers = "content-type=application/*")
    public @ResponseBody ServiceResponse<String, List<Ideas>> getIdeasForUser(@PathVariable long id){
    	if (id > 0 ){
    	Users users = new Users(new Long(id).intValue());
    	List<Ideas> ideList = ideaService.getIdeasByUser(users);
    	ServiceResponse<String , List<Ideas>> response = new ServiceResponse<String, List<Ideas>>(null, ideList, false);
    	return response;
    	}else{
    		ServiceResponse<String , List<Ideas>> response = new ServiceResponse<String, List<Ideas>>("NOIDEA", null, true);
    		return response;
    	}
    	
    
    }
    
    //Users
    @RequestMapping(value = "/user/save", method = RequestMethod.POST, headers = "content-type=application/*")
    public  @ResponseBody ServiceResponse<String,Users> save(@RequestBody Users users) {
    	ServiceResponse<String , Users> response;
    	Users users2 = userService.save(users);
    	response = new ServiceResponse<String, Users>(null, users2, false);
    	return response;
    }
    
    @RequestMapping(value = "/user/id", method = RequestMethod.GET, headers = "content-type=application/*")
    public @ResponseBody ServiceResponse<String, Users> getUsersById(@PathVariable long id){
    	ServiceResponse<String , Users> response;
    	if (id > 0 ){
    		
    		Users users = userService.get(new Long(id).intValue());
        	response = new ServiceResponse<String, Users>(null, users, false);
    	}else{
    	//	Users users = new Users(0);
    		response = new ServiceResponse<String, Users>("NOIDEA", null, true);
    	}
    	return response;
    	
    
    }
    
    @RequestMapping(value = "/user/email", method = RequestMethod.GET, headers = "content-type=application/*")
    public @ResponseBody ServiceResponse<String, Users> getUsersById(@PathVariable String email){
    	ServiceResponse<String , Users> response;
    	if (email != null ){
    		
    		Users users = userService.getUserByEmail(email);
        	response = new ServiceResponse<String, Users>(null, users, false);
    	}else{
    		//Users users = new Users(0);
    		response = new ServiceResponse<String, Users>("NOIDEA", null, true);
    	}
    	return response;
    }
    
    @RequestMapping(value = "/user/id", method = RequestMethod.DELETE, headers = "content-type=application/*")
    public void deleteUserById(@PathVariable long id){
    	
    	if (id > 0 ){
    		Users users = userService.get(new Long(id).intValue());
    		if (users != null && users.getId() > 0 ){
    			userService.deleteUser(users);
    		}
    	}
    	
   }
    
    @RequestMapping(value="/setup/user", method=RequestMethod.GET)
    public void setUp(){
    	Users users1 = new Users("Rama", "Ganesan","test@test.com");
    	userService.save(users1);
    	Users users2 = new Users("Partha", "Chandramohan","test1@test.com");
    	userService.save(users2);
    	Users users3 = new Users("Chris", "Wachtman","test3@test.com");
    	userService.save(users3);
    	Users users4 = new Users("Srijay", "Kasturi","test4@test.com");
    	userService.save(users4);
    	Users users5 = new Users("Justin", "Doody","test5@test.com");
    	userService.save(users5);
    	Users users6 = new Users("Diane", "Concentria","test6@test.com");
    	userService.save(users6);
    	
    }
    
    @RequestMapping(value="/setup/idea", method=RequestMethod.GET)
    public void setUpIdea(){
    	Scores scores = new Scores( new Integer(50),  new Integer(50),  new Integer(100),  new Integer(200));
    	Ideas ideas = new Ideas(1, "Big Idea", "Big Idea", "Big Idea", scores);
    	ideaService.saveIdeas(ideas);
    	Scores scores1 = new Scores( new Integer(50),  new Integer(50),  new Integer(100),  new Integer(200));
    	Ideas ideas1 = new Ideas(1, "Small Idea", "Small Idea", "Small Idea", scores1);
    	ideaService.saveIdeas(ideas1);
    	
    	
    	
    }
    
    
    
}
