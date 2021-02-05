package response;

import java.util.ArrayList;
import java.util.List;

public class ResponseDao <T> extends Response {
	private List<T> list = new ArrayList<>();

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

}
