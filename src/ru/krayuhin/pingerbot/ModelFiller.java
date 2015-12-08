package ru.krayuhin.pingerbot;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


public class ModelFiller {
	
	private List<Task> listTask = new ArrayList<Task>();

	public List<Task> getListTask() {
		return listTask;
	}

	public void setListTask(List<Task> listTask) {
		this.listTask = listTask;
	}

	public void fillList(){
		try {
			File file = new File("task_list.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Model.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Model tasklist = (Model) jaxbUnmarshaller.unmarshal(file);

		  } catch (JAXBException e) {
			e.printStackTrace();
		  }
	}
	
	/*public void readTaskList() { // extract to separate class
		SAXBuilder parser = new SAXBuilder(); //jaxb
		Document xmlDoc;
		
		try {
			xmlDoc = parser.build(new File("task_list.xml"));
			
			List elements = xmlDoc.getRootElement().getContent(new ElementFilter("Task"));
			Iterator iterator = elements.iterator();
			
			while(iterator.hasNext()){
				Element task = (Element)iterator.next();
				taskList.add(new Task(Integer.parseInt(task.getAttributeValue("id")), task.getChildText("Name"), task.getChildText("Url"), Integer.parseInt(task.getAttributeValue("Attempts")), Integer.parseInt(task.getAttributeValue("OkAttempts")), Integer.parseInt(task.getAttributeValue("Time"))));
			}
		}catch (JDOMException e){
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}
	}*/

}
