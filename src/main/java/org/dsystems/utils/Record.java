package org.dsystems.utils;

import java.io.Serializable;
//import java.util.HashMap;
//import java.util.Map;

import java.util.HashMap;

import org.dsystems.evaluator.AbstractVariableSet;

import com.google.gson.internal.LinkedTreeMap;

public class Record extends HashMap<String, Object> implements AbstractVariableSet<Object>,Serializable{
//public class Record implements AbstractVariableSet<Object>,Serializable{
	
	//LinkedTreeMap<String, Object> record;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Record() {
		//record = new LinkedTreeMap<String, Object>();
		//record.
	}
	public LinkedTreeMap<String, Object> getRecord() {
		//return record;
		return new LinkedTreeMap<String, Object>();
	}
	
	/*public Map<String, Object> getHashMap() {
		return record;
	}*/
	///@Override
	@SuppressWarnings("unchecked")
	public Object get(String key) {
		if (key.contains(".")) {
			String keys[] = key.split("\\.");
			//LinkedTreeMap p = (LinkedTreeMap) this.get(keys[0]);
			//Object value = record;
			Object value = this;
			for (String k: keys) {
				value = ((LinkedTreeMap<String, Object>)value).get(k);
			}
			return value;
		} else {
			//return record.get(key);
			return super.get(key);
		}
	}
	
	//@Override
	public Object put(String key, Object value) {
		if (value != null) {
			if (Utils.isNumeric(value.toString())){
				value = Double.parseDouble(value.toString());
			}
		}
		//record.put(key, value);
		super.put(key, value);
		return value;
	}
	@Override
	public String toString() {
		//return "Record [record=" + record.toString() + "]";
		return "Record [record=" + super.toString() + "]";
	}
	public Record getSubRecord(String[] keys) {
		Record record = new Record();
		for (String key: keys) {
			record.put(key, this.get(key));
		}
		return record;
	}

}
