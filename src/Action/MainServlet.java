package Action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import Entity.User;

public class MainServlet {
	private User user;

	public String parseDate() {
		return "success";
	}

	public String getpara() {
		Map map = ActionContext.getContext().getSession();
		map.put("ha", "This msg was put by a map");
		if (map.get("count") != null) {
			try {
				int count = Integer.parseInt(map.get("count").toString());
				count++;
				map.put("count", new Integer(count));
			} catch (Exception e) {
				// TODO: handle exception
			}
		} else {
			map.put("count", "1");
		}
		return "showparas";
	}

	public String load() {
		return "load";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String home() {
		return "success";
	}

	public String failed() {
		return "failed";
	}

	public String login() {
		return "login";
	}
}
