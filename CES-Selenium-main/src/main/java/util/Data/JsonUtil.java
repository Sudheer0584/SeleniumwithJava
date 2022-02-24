package util.Data;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import util.Common.BaseUtil;

public class JsonUtil extends BaseUtil{
	
	Object obj;
	public JsonUtil(String JsonLocation) {
		JSONParser parser = new JSONParser();
		try {
			obj = parser.parse(new FileReader(JsonLocation));
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		
	}
	
	public JSONObject getObject() {
		return (JSONObject) obj;
	}
	
	public String getValue(JSONObject jsonObject,String JsonKey) {
		return jsonObject.get(JsonKey).toString();
	}
	
	public Object[] getKeySet(JSONObject jsonObject) {
		return jsonObject.keySet().toArray();
		
	}
	
	public JSONArray getArray(JSONObject jsonObject,String ArrayKey) {
		return (JSONArray) jsonObject.get(ArrayKey);
	}
	
	public JSONObject getObjFromArray(JSONArray jsonArray, int index) {
		return (JSONObject) jsonArray.get(index);
	}
	
}
