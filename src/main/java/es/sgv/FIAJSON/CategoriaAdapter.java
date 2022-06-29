package es.sgv.FIAJSON;

import java.io.IOException;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import es.sgv.FIA.model.Categoria;

public class CategoriaAdapter extends TypeAdapter<Categoria>{

	@Override
	public void write(JsonWriter out, Categoria value) throws IOException {

		out.value(value.toString());
	}

	@Override
	public Categoria read(JsonReader in) throws IOException {
		
		Categoria categoria = Categoria.FORMULA1;
		
		String cat = in.nextString();
		
		switch (cat) {
		case "FORMULA2":
			categoria = Categoria.FORMULA2;
			break;
			
		case "FORMULA3":
			categoria = Categoria.FORMULA3;
			break;
			
		case "RESISTENCIA_FIA":
			categoria = Categoria.RESISTENCIA_FIA;
			break;
			
		case "DAYTONA_24H":
			categoria = Categoria.DAYTONA_24H;
			break;
			
		case "LEMANS_24H":
			categoria = Categoria.LEMANS_24H;
			break;
		
		}

		return categoria;
	}

}
