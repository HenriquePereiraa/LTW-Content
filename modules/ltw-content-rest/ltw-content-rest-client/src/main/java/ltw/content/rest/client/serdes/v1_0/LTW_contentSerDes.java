package ltw.content.rest.client.serdes.v1_0;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Generated;

import ltw.content.rest.client.dto.v1_0.LTW_content;
import ltw.content.rest.client.json.BaseJSONParser;

/**
 * @author Henrique Pereira
 * @generated
 */
@Generated("")
public class LTW_contentSerDes {

	public static LTW_content toDTO(String json) {
		LTW_contentJSONParser ltw_contentJSONParser =
			new LTW_contentJSONParser();

		return ltw_contentJSONParser.parseToDTO(json);
	}

	public static LTW_content[] toDTOs(String json) {
		LTW_contentJSONParser ltw_contentJSONParser =
			new LTW_contentJSONParser();

		return ltw_contentJSONParser.parseToDTOs(json);
	}

	public static String toJSON(LTW_content ltw_content) {
		if (ltw_content == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ssXX");

		if (ltw_content.getContentId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"contentId\": ");

			sb.append(ltw_content.getContentId());
		}

		if (ltw_content.getCreateDate() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"createDate\": ");

			sb.append("\"");

			sb.append(
				liferayToJSONDateFormat.format(ltw_content.getCreateDate()));

			sb.append("\"");
		}

		if (ltw_content.getModifiedDate() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"modifiedDate\": ");

			sb.append("\"");

			sb.append(
				liferayToJSONDateFormat.format(ltw_content.getModifiedDate()));

			sb.append("\"");
		}

		if (ltw_content.getMotorcycleManufacturing() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"motorcycleManufacturing\": ");

			sb.append("\"");

			sb.append(_escape(ltw_content.getMotorcycleManufacturing()));

			sb.append("\"");
		}

		if (ltw_content.getMotorcycleName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"motorcycleName\": ");

			sb.append("\"");

			sb.append(_escape(ltw_content.getMotorcycleName()));

			sb.append("\"");
		}

		if (ltw_content.getMotorcycleYear() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"motorcycleYear\": ");

			sb.append(ltw_content.getMotorcycleYear());
		}

		if (ltw_content.getUserId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"userId\": ");

			sb.append(ltw_content.getUserId());
		}

		if (ltw_content.getUserName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"userName\": ");

			sb.append("\"");

			sb.append(_escape(ltw_content.getUserName()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		LTW_contentJSONParser ltw_contentJSONParser =
			new LTW_contentJSONParser();

		return ltw_contentJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(LTW_content ltw_content) {
		if (ltw_content == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ssXX");

		if (ltw_content.getContentId() == null) {
			map.put("contentId", null);
		}
		else {
			map.put("contentId", String.valueOf(ltw_content.getContentId()));
		}

		if (ltw_content.getCreateDate() == null) {
			map.put("createDate", null);
		}
		else {
			map.put(
				"createDate",
				liferayToJSONDateFormat.format(ltw_content.getCreateDate()));
		}

		if (ltw_content.getModifiedDate() == null) {
			map.put("modifiedDate", null);
		}
		else {
			map.put(
				"modifiedDate",
				liferayToJSONDateFormat.format(ltw_content.getModifiedDate()));
		}

		if (ltw_content.getMotorcycleManufacturing() == null) {
			map.put("motorcycleManufacturing", null);
		}
		else {
			map.put(
				"motorcycleManufacturing",
				String.valueOf(ltw_content.getMotorcycleManufacturing()));
		}

		if (ltw_content.getMotorcycleName() == null) {
			map.put("motorcycleName", null);
		}
		else {
			map.put(
				"motorcycleName",
				String.valueOf(ltw_content.getMotorcycleName()));
		}

		if (ltw_content.getMotorcycleYear() == null) {
			map.put("motorcycleYear", null);
		}
		else {
			map.put(
				"motorcycleYear",
				String.valueOf(ltw_content.getMotorcycleYear()));
		}

		if (ltw_content.getUserId() == null) {
			map.put("userId", null);
		}
		else {
			map.put("userId", String.valueOf(ltw_content.getUserId()));
		}

		if (ltw_content.getUserName() == null) {
			map.put("userName", null);
		}
		else {
			map.put("userName", String.valueOf(ltw_content.getUserName()));
		}

		return map;
	}

	public static class LTW_contentJSONParser
		extends BaseJSONParser<LTW_content> {

		@Override
		protected LTW_content createDTO() {
			return new LTW_content();
		}

		@Override
		protected LTW_content[] createDTOArray(int size) {
			return new LTW_content[size];
		}

		@Override
		protected void setField(
			LTW_content ltw_content, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "contentId")) {
				if (jsonParserFieldValue != null) {
					ltw_content.setContentId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "createDate")) {
				if (jsonParserFieldValue != null) {
					ltw_content.setCreateDate(
						toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "modifiedDate")) {
				if (jsonParserFieldValue != null) {
					ltw_content.setModifiedDate(
						toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "motorcycleManufacturing")) {

				if (jsonParserFieldValue != null) {
					ltw_content.setMotorcycleManufacturing(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "motorcycleName")) {
				if (jsonParserFieldValue != null) {
					ltw_content.setMotorcycleName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "motorcycleYear")) {
				if (jsonParserFieldValue != null) {
					ltw_content.setMotorcycleYear(
						Integer.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "userId")) {
				if (jsonParserFieldValue != null) {
					ltw_content.setUserId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "userName")) {
				if (jsonParserFieldValue != null) {
					ltw_content.setUserName((String)jsonParserFieldValue);
				}
			}
		}

	}

	private static String _escape(Object object) {
		String string = String.valueOf(object);

		for (String[] strings : BaseJSONParser.JSON_ESCAPE_STRINGS) {
			string = string.replace(strings[0], strings[1]);
		}

		return string;
	}

	private static String _toJSON(Map<String, ?> map) {
		StringBuilder sb = new StringBuilder("{");

		@SuppressWarnings("unchecked")
		Set set = map.entrySet();

		@SuppressWarnings("unchecked")
		Iterator<Map.Entry<String, ?>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, ?> entry = iterator.next();

			sb.append("\"");
			sb.append(entry.getKey());
			sb.append("\": ");

			Object value = entry.getValue();

			Class<?> valueClass = value.getClass();

			if (value instanceof Map) {
				sb.append(_toJSON((Map)value));
			}
			else if (valueClass.isArray()) {
				Object[] values = (Object[])value;

				sb.append("[");

				for (int i = 0; i < values.length; i++) {
					sb.append("\"");
					sb.append(_escape(values[i]));
					sb.append("\"");

					if ((i + 1) < values.length) {
						sb.append(", ");
					}
				}

				sb.append("]");
			}
			else if (value instanceof String) {
				sb.append("\"");
				sb.append(_escape(entry.getValue()));
				sb.append("\"");
			}
			else {
				sb.append(String.valueOf(entry.getValue()));
			}

			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}

		sb.append("}");

		return sb.toString();
	}

}