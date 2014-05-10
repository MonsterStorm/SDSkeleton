package com.cst.skeleton.api.adapter;

import java.io.IOException;

import android.util.Base64;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

public class ByteArrayTypeAdapter extends TypeAdapter<byte[]> {

	@Override
	public void write(JsonWriter out, byte[] value) throws IOException {
		if (value == null){
			out.nullValue();
		}else{
			String base64_string = Base64.encodeToString(value, Base64.NO_WRAP);
			out.value(base64_string);
		}
	}

	@Override
	public byte[] read(JsonReader in) throws IOException {
		if (in.peek() == JsonToken.NULL){
			in.nextNull();
			return null;
		}else{
			String base64_string = in.nextString();
			return Base64.decode(base64_string, Base64.NO_WRAP);
		}
	}
}
