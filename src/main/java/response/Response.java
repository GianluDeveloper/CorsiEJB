package response;

import java.io.Serializable;

public class Response  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1819577657666809227L;
	boolean successo = false;
	int errorCode = 0;
	String description = "";

	public Response() {
		// TODO Auto-generated constructor stub
	}

	public boolean isSuccesso() {
		return successo;
	}

	public void setSuccesso(boolean successo) {
		this.successo = successo;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
