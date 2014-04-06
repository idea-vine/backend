package com.bigidea.controller;



import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bigidea.entity.Greeting;
import com.bigidea.entity.Ideas;
import com.bigidea.hibernate.IdeaHibernate;

@Controller
public class HomeController {

	

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    
    @Autowired
    private IdeaHibernate ideaHibernate; 

    @RequestMapping(value = "/greeting", method = RequestMethod.GET, headers = "content-type=application/*")
    public @ResponseBody Greeting greeting(
            @RequestParam(value="name", required=false, defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    
    
    
    @RequestMapping(value = "/save", method = RequestMethod.GET, headers = "content-type=application/*")
    @Transactional(propagation=Propagation.REQUIRED)
    public  void save(
            @RequestParam(value="title", required=true, defaultValue="FirstTitle") String title,
            @RequestParam(value="desc", required=true, defaultValue="DESCription") String desc,
            @RequestParam(value="longdesc", required=true, defaultValue="very long desc") String longdesc) {
    	
    	Ideas i = new Ideas();
    	i.setDesc(desc);
    	i.setFullText(longdesc);
    	i.setTitle(title);
    	
    	ideaHibernate.saveIdea(i);
    	
    }
    
}
