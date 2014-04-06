package com.bigidea.controller;



import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bigidea.entity.Greeting;
import com.bigidea.entity.Ideas;
import com.bigidea.hibernate.IdeaHibernate;
import com.bigidea.service.IdeaService;

@Controller
public class HomeController extends RestServiceController{

	

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    
    @Autowired
    private IdeaService ideaService; 

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
    
}
