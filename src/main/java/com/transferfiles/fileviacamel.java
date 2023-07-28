package com.transferfiles;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.log4j.BasicConfigurator;
public class fileviacamel {
	//ftp was crucial here
	 //camel ftp and jsch dependicies
    public static void main(String[] args) {
    	BasicConfigurator.configure();
    	final String destinationFolder = "sftp://root@192.168.225.167:/rs/?password=root";
        final String sourceFolder = "file:output";
    	final CamelContext camelContext = new DefaultCamelContext();
        try {
       	 camelContext.addRoutes(new RouteBuilder() {
            @Override
            public void configure()throws Exception {
                from(sourceFolder).to(destinationFolder);
            }
          });
       	 
       	    camelContext.start();
            Thread.sleep(2*60*1000);
            camelContext.stop();
        }
        catch(Exception e) {
       	    e.printStackTrace();
        }
    }
}

