package Action;

import java.util.Date;

public class DateAction {
	private Date date;
	/**
	 * ����ҳ�����������
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
