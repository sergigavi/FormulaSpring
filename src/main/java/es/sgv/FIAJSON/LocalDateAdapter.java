package es.sgv.FIAJSON;

import java.io.IOException;
import java.time.LocalDate;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class LocalDateAdapter extends TypeAdapter<LocalDate>{

	@Override
	public void write(JsonWriter out, LocalDate value) throws IOException {

		out.value(value.toString());
	}

	@Override
	public LocalDate read(JsonReader in) throws IOException {
		return LocalDate.parse(in.nextString());
	}

}
