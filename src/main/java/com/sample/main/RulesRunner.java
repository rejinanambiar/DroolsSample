package com.sample.main;


import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.sample.model.Message;

/**
 * This is a sample class to launch a rule.
 */
public class RulesRunner {

    public static final void main(String[] args) {
        try {
            // load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-rules");

            // check with a valid value
            Message message = new Message();
            message.setPrice(300);
            kSession.insert(message);
            kSession.fireAllRules();            
            System.out.println(message.getStatus());
            
            // check with an invalid value
            Message anotherMessage = new Message();
            anotherMessage.setPrice(10);
            kSession.insert(anotherMessage);
            kSession.fireAllRules();            
            System.out.println(anotherMessage.getStatus());
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

 

}
