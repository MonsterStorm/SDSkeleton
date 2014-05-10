package com.cst.skeleton.api.adapter;

import java.io.IOException;
import java.util.Date;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

public class TimestampTypeAdapter extends TypeAdapter<Date>{

	@Override
	public void write(JsonWriter out, Date value) throws IOException {
		if (value == null){
			out.nullValue();
		}else{
			out.value(value.getTime());
		}
	}

	@Override
	public Date read(JsonReader in) throws IOException {
		if (in.peek() == JsonToken.NULL){
			in.nextNull();
			return null;
		}
		long ts = in.nextLong();
		if (ts == 0){
			return null;
		}else{
			return new Date(ts);
		}
	}

}
