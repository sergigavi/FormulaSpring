package es.sgv.FIAJSON;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashSet;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import es.sgv.FIA.model.Escuderia;

public class FormulaJSON {

	public static Set<Escuderia> leerJSON()
	{
		Set<Escuderia> escuderias = new HashSet<>();
		
		GsonBuilder gsonBuilder = new GsonBuilder();
		
		gsonBuilder.registerTypeAdapter(LocalDateAdapter.class, new LocalDateAdapter());
		gsonBuilder.registerTypeAdapter(CategoriaAdapter.class, new CategoriaAdapter());
		
		Gson gson = gsonBuilder.create();
		
		TypeToken<Set<Escuderia>> listaEscuderias = new TypeToken<Set<Escuderia>>(){};

		
		try {
			
			escuderias = gson.fromJson(new FileReader(new File("EscuderiasFormulaSpring.json")), listaEscuderias.getType());
			
		} catch (JsonIOException | JsonSyntaxException | FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return escuderias;
	}
	
	public static boolean escribirJSON(Set<Escuderia> escuderias)
	{
		boolean exito = false;
		
		GsonBuilder gsonBuilder = new GsonBuilder();
		
		gsonBuilder.setPrettyPrinting();
		
		gsonBuilder.registerTypeAdapter(LocalDateAdapter.class, new LocalDateAdapter());
		gsonBuilder.registerTypeAdapter(CategoriaAdapter.class, new CategoriaAdapter());
		
		Gson gson = gsonBuilder.create();
		
		try {
			Writer writer = new FileWriter(new File("EscuderiasFormulaSpring.json"));
			
			//writer.write(gson.toJson(escuderias));
			System.out.println(gson.toJson(escuderias));
			writer.flush();
			writer.close();
			
			exito = true;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return exito;
	}
	
	
}
