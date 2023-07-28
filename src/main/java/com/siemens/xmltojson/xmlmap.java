package com.siemens.xmltojson;

import org.json.JSONObject;

import org.json.XML;

import org.json.simple.JSONArray;

import com.fasterxml.jackson.core.JsonProcessingException;

import com.fasterxml.jackson.databind.JsonMappingException;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.xmldoc.xmlDocobj;

import java.io.FileWriter;

import java.io.IOException;

import org.json.JSONException;

public class xmlmap {

	public static int PRETTY_PRINT_INDENT_FACTOR = 4;

	static xmlDocobj s = new xmlDocobj();

	public static String TEST_XML_STRING = s.finstring();

	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {

		try {

			JSONObject json = XML.toJSONObject(TEST_XML_STRING);

			validatejson val = new validatejson();
			val.valjson(json);


			String jsonPrettyPrintString = json.toString(PRETTY_PRINT_INDENT_FACTOR);

			System.out.println(jsonPrettyPrintString);

			ObjectMapper mapper = new ObjectMapper();

			User u = mapper.readValue(json.getJSONObject("user").toString(), User.class);

			int a = u.getAge();
			a = a + 2;

			u.setAge(a);

			json.getJSONObject("user").put("age", a);

			json.getJSONObject("user").getJSONObject("address").getInt("pincode");

			// System.out.println(u);

			
			// Write JSON file

			try (FileWriter file = new FileWriter("output/sample.json")) {

				// We can write any JSONArray or JSONObject instance to the file
				String jsonPrettyPrintString2 = json.toString(PRETTY_PRINT_INDENT_FACTOR);

				System.out.println(jsonPrettyPrintString2);

				file.write(jsonPrettyPrintString2);

				file.flush();

			} catch (IOException e) {

				e.printStackTrace();

			}
		}

		catch (JSONException je) {

			System.out.println(je.toString());

		}

	}

}