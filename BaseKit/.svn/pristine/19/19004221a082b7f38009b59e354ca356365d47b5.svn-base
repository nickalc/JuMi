package com.rogers.kit.net;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeTypeAdapter implements JsonSerializer<Date>, JsonDeserializer<Date>{
	private final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Override
	public Date deserialize(JsonElement json, Type t,
			JsonDeserializationContext arg2) throws JsonParseException {
		if (!(json instanceof JsonPrimitive)) {      
            throw new JsonParseException("The date should be a string value");      
        }
		try {      
            Date date = format.parse(json.getAsString());      
            return new Date(date.getTime());
        } catch (ParseException e) {      
            throw new JsonParseException(e);      
        }     
	}

	@Override
	public JsonElement serialize(Date ts, Type arg1,
			JsonSerializationContext arg2) {
		String dfString = format.format(ts);      
        return new JsonPrimitive(dfString); 
	}
	
}
