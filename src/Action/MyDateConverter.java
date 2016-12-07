package Action;

import java.lang.reflect.Member;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.opensymphony.xwork2.conversion.impl.DefaultTypeConverter;

public class MyDateConverter extends DefaultTypeConverter {
	public Object convertValue(Map context, Object value, Class toType) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String[] paras = (String[]) value;
		try {
			if (toType == Date.class) {
				return sdf.parse(paras[0]);
			} else if (toType == Date.class) {
				Date date = (Date) value;
				return sdf.format(date);
			}
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
		return null;

	}
}
