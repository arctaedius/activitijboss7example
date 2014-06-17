package se.hulot.activitijboss7example.ejb;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.Singleton;
import javax.ejb.Startup;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;

@Singleton
@Startup
public class BpmService {

	private ProcessEngine processEngine;
	
	public BpmService() {
		processEngine = ProcessEngines.getDefaultProcessEngine();
		RepositoryService repositoryService = processEngine.getRepositoryService();
		repositoryService.createDeployment()
		  .addClasspathResource("example.bpmn20.xml")
		  .deploy();
	}

	public void startProcess() {
		Map<String, Object> variables = new HashMap<String, Object>();
		      
		RuntimeService runtimeService = processEngine.getRuntimeService();
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("process", variables);
	}
}
