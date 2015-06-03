package com.http;

import java.io.StringWriter;
import java.net.URL;

import org.apache.commons.io.IOUtils;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import com.log.Loggers;


public class HttpAPI
{	

	private CredentialsProvider credentials = new BasicCredentialsProvider();
	
	public HttpAPIResponse makeGetHttpCall( String urlEndpoint, int timeOut, String userName, String password )
	{
		HttpAPIResponse response = new HttpAPIResponse();
		String responseString = "";
		credentials.setCredentials( AuthScope.ANY, new UsernamePasswordCredentials( userName, password));
		
		try( CloseableHttpClient client = HttpClientBuilder.create().setDefaultCredentialsProvider( credentials ).build() )
		{

			URL url = new URL( urlEndpoint );
			
			RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(timeOut*1000)
					.setConnectTimeout(timeOut*1000)
					.setSocketTimeout(timeOut*1000)
					.build();
			
			HttpGet get = new HttpGet( url.toString( ) );
			get.setConfig( requestConfig );
			
			
			try( CloseableHttpResponse httpResponse = client.execute( get ); )
			{
				StringWriter writer = new StringWriter();
				
				if( ( httpResponse.getEntity() != null ) && ( httpResponse.getEntity().getContent() != null ))
				{
					IOUtils.copy( httpResponse.getEntity().getContent(), writer,"UTF-8");
					responseString = writer.toString();
				}
				response.setResponse( responseString );
				response.setResponseStatusCode( httpResponse.getStatusLine().getStatusCode() );
			}
			Loggers.Service.Info( "Got status:" + " - " + response.getResponseStatusCode() );
			Loggers.Service.Info( "Got response from web service: " + response.getResponse() );

			
		} catch ( Exception e)
		{
			Loggers.Service.errorWithTrace("Failed to make http call to[" + urlEndpoint + "]", e);
		}
		return response;
	}
	

	
}
