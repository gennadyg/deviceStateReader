package com.log;

import org.apache.log4j.PropertyConfigurator;


public class Loggers 
{
    public static BaseLogger Service = null;

    public static void errorWithTrace( String error, Exception e )
    {
    	if ( Service != null )
        {
    		Service.errorWithTrace( error, e );
        }
    }

    /**
     * 
     * @param info 
     */
    public static void Info( String info )
    {
        if (Service != null)
        {
            Service.Info(info);
        }

    }
 

    /**
     * 
     * @param debug 
     */
    public static void Debug(String debug)
    {
        if ( Service != null ) 
        {
            Service.Debug(debug);
        }
    }

    /**
     * 
     * @param config
     * @return 
     */
    public static boolean Init(String config)
    {
        try
        {
            PropertyConfigurator.configure(config);
            
            Service = new BaseLogger("Service");
        
        }catch ( Exception e )
        {
            return false;
        }

        return true;
    }

}
