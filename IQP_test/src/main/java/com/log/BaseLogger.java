package com.log;

import org.apache.log4j.Logger;

public class BaseLogger 
{

    public Logger Log = null;
    
    /**
     * 
     * @param name 
     */
    public BaseLogger(String name)
    {
        Log = Logger.getLogger(name);
    }

    /**
     * 
     * @param debug 
     */
    public void Debug(String debug)
    {
        if (Log != null && debug != null)
            Log.debug(debug);
    }

    /**
     * 
     * @param info 
     */
    public void Info(String info)
    {
        if (Log != null && info != null)
            Log.info(info);
    }
    public void errorWithTrace( String error, Exception e )
    {
    	if ( Log != null && e != null)
        {
    		Log.error( error, e );
        }
    }
    

    /**
     * 
     * @param error 
     */
    public void Error(String error)
    {
        if ( Log != null && error != null )
            Log.error(error);
    }
}
