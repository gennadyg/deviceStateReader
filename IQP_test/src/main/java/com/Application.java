package com;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;

import com.Result.DataStream;
import com.db.DbClient;
import com.http.HttpAPI;
import com.http.HttpAPIResponse;
import com.log.Loggers;

public class Application extends HttpAPI
{
	private static String logConfigFile = "log4j.properties";	
	public static Properties log4jconfig = new Properties();
	
    public static void loadProperties(Properties properties, String propertiesInput) throws IOException
    {
        InputStream inputStream = new ByteArrayInputStream(propertiesInput.getBytes());
        properties.load(inputStream);
        inputStream.close();
        
    }
	
	public static void initLog() 
    {
		Loggers.Init( logConfigFile );
				
        try
		{
			loadProperties( log4jconfig, "log4j.properties");
		
		}catch (IOException e)
		{
			e.printStackTrace();
		}
        
        PropertyConfigurator.configure( log4jconfig );
    }

	public static void main( String[] args )
	{
		Application service = new Application();
		
		try 
		{
			// initialize log4j configuration
			initLog();
			
			// get device data from the web api
			HttpAPIResponse  response = service.makeGetHttpCall("https://login.etherios.com/ws/DataStream", 10, "nanri-test", "!Nanri0118");
			
			// Parse XML response
			Result result = Result.fromString( response.getResponse() );
			
			//  Save all to database
			DbClient dbClient = new DbClient();
			dbClient.createConnection();				
			
			for( DataStream currentDataStream : result.list )
			{
				dbClient.insert( currentDataStream );
			}
			dbClient.closeConnection();

			
		} catch ( Exception e) 
		{
			Loggers.Service.errorWithTrace("Failed to execute IQP test", e);
		}
		
	}

}
