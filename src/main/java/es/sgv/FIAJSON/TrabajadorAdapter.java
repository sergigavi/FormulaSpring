package es.sgv.FIAJSON;

import java.io.IOException;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import es.sgv.FIA.model.Trabajador;

public class TrabajadorAdapter extends TypeAdapter<Trabajador>{

	@Override
	public void write(JsonWriter out, Trabajador value) throws IOException {

		out.value(value.toString());
	}

	
	public Trabajador read(JsonReader in) throws IOException {
		
		Trabajador t = Trabajador.builder().build();
		
		//aqui tengo que recoger el string del trabajador y crear un trabajador pero no me corre prisa tampoco jiji
		in.nextString();
		return t;
	}


}
