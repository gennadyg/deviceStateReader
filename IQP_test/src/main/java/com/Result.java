package com;


import java.util.ArrayList;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;


@Root(name = "result", strict=false)
public class Result 
{

	
 protected byte resultSize;
 protected short requestedSize;
 @Element(required = true)
 protected String pageCursor;
 @ElementList( inline=true )
 protected List<Result.DataStream> list;

 public static Result fromString( String xmlString )
 {
	Result response = new Result(); // to prevent null response
 	try
 	{
 		Serializer serializer = new Persister();
 		// System.out.println( resultsText );
 		response = serializer.read( Result.class, xmlString );
 		
	} catch ( Exception e )
	{
			e.printStackTrace();
	}
 	
 	return response;
 }
 
 /**
  * Gets the value of the resultSize property.
  * 
  */
 public byte getResultSize() 
 {
     return resultSize;
 }

 /**
  * Sets the value of the resultSize property.
  * 
  */
 public void setResultSize(byte value) {
     this.resultSize = value;
 }

 /**
  * Gets the value of the requestedSize property.
  * 
  */
 public short getRequestedSize() 
 {
     return requestedSize;
 }

 /**
  * Sets the value of the requestedSize property.
  * 
  */
 public void setRequestedSize(short value) {
     this.requestedSize = value;
 }

 /**
  * Gets the value of the pageCursor property.
  * 
  * @return
  *     possible object is
  *     {@link String }
  *     
  */
 public String getPageCursor() {
     return pageCursor;
 }

 /**
  * Sets the value of the pageCursor property.
  * 
  * @param value
  *     allowed object is
  *     {@link String }
  *     
  */
 public void setPageCursor(String value) {
     this.pageCursor = value;
 }

 /**
  * Gets the value of the dataStream property.
  * 
  * <p>
  * This accessor method returns a reference to the live list,
  * not a snapshot. Therefore any modification you make to the
  * returned list will be present inside the JAXB object.
  * This is why there is not a <CODE>set</CODE> method for the dataStream property.
  * 
  * <p>
  * For example, to add a new item, do as follows:
  * <pre>
  *    getDataStream().add(newItem);
  * </pre>
  * 
  * 
  * <p>
  * Objects of the following type(s) are allowed in the list
  * {@link Result.DataStream }
  * 
  * 
  */
 public List<Result.DataStream> getDataStream() 
 {
     if ( list == null) 
     {
         list = new ArrayList<Result.DataStream>();
     }
     return this.list;
 }


 @Root(name = "DataStream", strict=false)
 public static class DataStream 
 {
	 @Element(required = false)
     protected int cstId;
     @Element(required = false)
     protected String streamId;
     @Element(required = false)
     protected String dataType;
     @Element(required = false)
     protected String forwardTo;
     @Element(required = false)
     protected Result.DataStream.CurrentValue currentValue;
     @Element(required = false)
     protected String description;
     @Element(required = false)
     protected String units;
     protected int dataTtl;
     protected int rollupTtl;

     /**
      * Gets the value of the cstId property.
      * 
      */
     public int getCstId() 
     {
         return cstId;
     }

     /**
      * Sets the value of the cstId property.
      * 
      */
     public void setCstId(int value) 
     {
         this.cstId = value;
     }

     /**
      * Gets the value of the streamId property.
      * 
      * @return
      *     possible object is
      *     {@link String }
      *     
      */
     public String getStreamId() {
         return streamId;
     }

     /**
      * Sets the value of the streamId property.
      * 
      * @param value
      *     allowed object is
      *     {@link String }
      *     
      */
     public void setStreamId(String value) {
         this.streamId = value;
     }

     /**
      * Gets the value of the dataType property.
      * 
      * @return
      *     possible object is
      *     {@link String }
      *     
      */
     public String getDataType() {
         return dataType;
     }

     /**
      * Sets the value of the dataType property.
      * 
      * @param value
      *     allowed object is
      *     {@link String }
      *     
      */
     public void setDataType(String value) {
         this.dataType = value;
     }

     /**
      * Gets the value of the forwardTo property.
      * 
      * @return
      *     possible object is
      *     {@link String }
      *     
      */
     public String getForwardTo() {
         return forwardTo;
     }

     /**
      * Sets the value of the forwardTo property.
      * 
      * @param value
      *     allowed object is
      *     {@link String }
      *     
      */
     public void setForwardTo(String value) {
         this.forwardTo = value;
     }

     /**
      * Gets the value of the currentValue property.
      * 
      * @return
      *     possible object is
      *     {@link Result.DataStream.CurrentValue }
      *     
      */
     public Result.DataStream.CurrentValue getCurrentValue() {
         return currentValue;
     }

     /**
      * Sets the value of the currentValue property.
      * 
      * @param value
      *     allowed object is
      *     {@link Result.DataStream.CurrentValue }
      *     
      */
     public void setCurrentValue(Result.DataStream.CurrentValue value) {
         this.currentValue = value;
     }

     /**
      * Gets the value of the description property.
      * 
      * @return
      *     possible object is
      *     {@link String }
      *     
      */
     public String getDescription() {
         return description;
     }

     /**
      * Sets the value of the description property.
      * 
      * @param value
      *     allowed object is
      *     {@link String }
      *     
      */
     public void setDescription(String value) {
         this.description = value;
     }

     /**
      * Gets the value of the units property.
      * 
      * @return
      *     possible object is
      *     {@link String }
      *     
      */
     public String getUnits() {
         return units;
     }

     /**
      * Sets the value of the units property.
      * 
      * @param value
      *     allowed object is
      *     {@link String }
      *     
      */
     public void setUnits(String value) {
         this.units = value;
     }

     /**
      * Gets the value of the dataTtl property.
      * 
      */
     public int getDataTtl() {
         return dataTtl;
     }

     /**
      * Sets the value of the dataTtl property.
      * 
      */
     public void setDataTtl(int value) {
         this.dataTtl = value;
     }

     /**
      * Gets the value of the rollupTtl property.
      * 
      */
     public int getRollupTtl() {
         return rollupTtl;
     }

     /**
      * Sets the value of the rollupTtl property.
      * 
      */
     public void setRollupTtl(int value) {
         this.rollupTtl = value;
     }
     @Root( name="currentValue", strict=false)
     public static class CurrentValue {

         @Element(required = false)
         protected String id;
         protected String timestamp;
         @Element(required = false)
         protected String timestampISO;
         protected long serverTimestamp;
         @Element(required = false)
         protected String serverTimestampISO;
         @Element(required = false)
         protected String data;
         @Element(required = false)
         protected String description;
         protected byte quality;

         /**
          * Gets the value of the id property.
          * 
          * @return
          *     possible object is
          *     {@link String }
          *     
          */
         public String getId() {
             return id;
         }

         /**
          * Sets the value of the id property.
          * 
          * @param value
          *     allowed object is
          *     {@link String }
          *     
          */
         public void setId(String value) {
             this.id = value;
         }

         /**
          * Gets the value of the timestamp property.
          * 
          */
         public String getTimestamp() 
         {
             return timestamp;
         }

         /**
          * Sets the value of the timestamp property.
          * 
          */
         public void setTimestamp( String value) 
         {
             this.timestamp = value;
         }

         /**
          * Gets the value of the timestampISO property.
          * 
          * @return
          *     possible object is
          *     {@link XMLGregorianCalendar }
          *     
          */
         public String getTimestampISO() 
         {
             return timestampISO;
         }

         /**
          * Sets the value of the timestampISO property.
          * 
          * @param value
          *     allowed object is
          *     {@link XMLGregorianCalendar }
          *     
          */
         public void setTimestampISO( String value) 
         {
             this.timestampISO = value;
         }

         /**
          * Gets the value of the serverTimestamp property.
          * 
          */
         public long getServerTimestamp() {
             return serverTimestamp;
         }

         /**
          * Sets the value of the serverTimestamp property.
          * 
          */
         public void setServerTimestamp(long value) {
             this.serverTimestamp = value;
         }

         /**
          * Gets the value of the serverTimestampISO property.
          * 
          * @return
          *     possible object is
          *     {@link XMLGregorianCalendar }
          *     
          */
         public String getServerTimestampISO() 
         {
             return serverTimestampISO;
         }

         /**
          * Sets the value of the serverTimestampISO property.
          * 
          * @param value
          *     allowed object is
          *     {@link XMLGregorianCalendar }
          *     
          */
         public void setServerTimestampISO( String value ) 
         {
             this.serverTimestampISO = value;
         }

         /**
          * Gets the value of the data property.
          * 
          * @return
          *     possible object is
          *     {@link String }
          *     
          */
         public String getData() {
             return data;
         }

         /**
          * Sets the value of the data property.
          * 
          * @param value
          *     allowed object is
          *     {@link String }
          *     
          */
         public void setData(String value) {
             this.data = value;
         }

         /**
          * Gets the value of the description property.
          * 
          * @return
          *     possible object is
          *     {@link String }
          *     
          */
         public String getDescription() {
             return description;
         }

         /**
          * Sets the value of the description property.
          * 
          * @param value
          *     allowed object is
          *     {@link String }
          *     
          */
         public void setDescription(String value) {
             this.description = value;
         }

         /**
          * Gets the value of the quality property.
          * 
          */
         public byte getQuality() {
             return quality;
         }

         /**
          * Sets the value of the quality property.
          * 
          */
         public void setQuality(byte value) {
             this.quality = value;
         }

     }

 }

}
