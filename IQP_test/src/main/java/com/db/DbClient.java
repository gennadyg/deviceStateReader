package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.Result.DataStream;
import com.log.Loggers;

public class DbClient 
{
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://api-integration.cortica.com/test";

   //  Database credentials
   static final String USER = "cortica";
   static final String PASS = "cor2993";
   
   Connection conn = null;
   
   public void createConnection()
   {
	   try 
	   {
		 //STEP 2: Register JDBC driver
         Class.forName("com.mysql.jdbc.Driver");
  
		 //STEP 3: Open a connection
		 System.out.println("Connecting to a selected database...");
		 conn = DriverManager.getConnection( DB_URL, USER, PASS);
		 System.out.println("Connected database successfully...");
	   
	   } catch (Exception e) 
	   {
		 e.printStackTrace();
	   }
   }
   
   public void insert( DataStream dataStream )
   {
	   Statement stmt = null;
	   try
	   { 
	      //STEP 4: Execute a query
	      Loggers.Service.Info("Inserting records into the table...");
	      stmt = conn.createStatement();

	      
	      String sql = "INSERT INTO DeviceData( CustomerID,ClientTimestamp,StreamID,DataType,Units,Data,ServerTimeStamp) VALUES ( %s, %s, %s, %s, %s, %s, %s )";
	      sql = String.format( sql, dataStream.getCstId(), 
	    		  			  "'" + dataStream.getCurrentValue().getTimestampISO().replace("Z", "") + "'", 	
	    		  			  "'" + dataStream.getStreamId() + "'", 
	    		  			  "'" + dataStream.getDataType() + "'", 
	    		  			  "'" + dataStream.getUnits() + "'", 
	    		  			  "'" +  dataStream.getCurrentValue().getData() + "'",
	    		  			  "'" +  dataStream.getCurrentValue().getServerTimestampISO().replace("Z", "")  + "'");
	      
	      Loggers.Service.Info( "Going to execute SQL: " + sql );
	      stmt.executeUpdate(sql);
	      
	      Loggers.Service.Info("Succesfully inserted records into the table !!!");
	
	   }catch(SQLException se)
	   {
	      //Handle errors for JDBC
	      Loggers.Service.errorWithTrace("Failed to execute SQL", se);
	      
	   }catch(Exception e)
	   {
		   Loggers.Service.errorWithTrace("Failed to execute SQL", e );
	   }
   }
   
   public void closeConnection()
   {
	   try
	      {
	         if(conn!=null)
	         {
	        	 conn.close();
	         }
	      
	      }catch( SQLException se )
	      {
	         se.printStackTrace();
	      }//end fi
   }
}