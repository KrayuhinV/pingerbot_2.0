package ru.krayuhin.pingerbot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class PingerClass {
	private long timeResult;
	private long timeStart;
	private long timeEnd;
	private ScheduledExecutorService service;
	private IModel list;
	private String url;
	
	PingerClass(IModel list){
		this.list = list;
		service = Executors.newScheduledThreadPool(list.getThreadCount());
	}
	
	public void timeStart()
    {
        this.timeStart=System.currentTimeMillis();
    }
	
	public void timeEnd()
    {
        this.timeStart=System.currentTimeMillis();
    }
	
	public void timeResult()
    {
        this.timeStart=this.timeEnd - this.timeStart;
    }
	
	public void connection(int index) throws IOException{
		try{
			this.url =  this.list.getUrl(index);
			URL taskURL = new URL(this.url);
			URLConnection con = taskURL.openConnection();
			con.setConnectTimeout(1000);
			this.timeStart();
			try(BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));)
            {
                this.timeEnd();
            }
            this.timeResult();
            this.list.setOkAttempts(index, this.list.getOkAttempts(index)+1);
		}
		catch (java.net.SocketTimeoutException | java.net.ConnectException ex)
        {
            this.list.setOkAttempts(index, this.list.getOkAttempts(index));
        }
		finally
        {
            this.list.setTime(index,this.timeResult);
            this.list.setAttempts(index,this.list.getAttempts(index)+1);
        }		
	}
	
	public void connetionStart()
    {
        for(int i=0; i<list.getTaskList().size(); i++)
            service.scheduleWithFixedDelay(new ConnectionThread(i), 0, 5, TimeUnit.SECONDS);
    }
    
    public void connectionStop()
    {
        service.shutdown();
    }
    
    public class ConnectionThread implements Runnable{
    	
    	private int index;
    	
    	public ConnectionThread(int index){
    		this.index = index;
    	}

    	@Override
    	public void run() {
    		try {
				connection(index);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    	}

    }

}
