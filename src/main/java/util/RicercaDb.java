package util;

import java.io.Serializable;

public class RicercaDb implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5454365728467231148L;
	private String key;
	private String value;

	public RicercaDb(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}

	public RicercaDb() {

	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
