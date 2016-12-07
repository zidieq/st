package Action;

import java.util.Date;

public class DateAction {
	private Date date;
	/**
	 * 处理页面过来的请求
	 * @return
	 */
	public String execute() {
		if (date != null) {
			return "showdate";
		} else {
			return "success";
		}
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
