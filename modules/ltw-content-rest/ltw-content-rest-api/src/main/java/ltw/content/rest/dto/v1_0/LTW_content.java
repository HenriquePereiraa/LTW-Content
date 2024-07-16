package ltw.content.rest.dto.v1_0;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.liferay.petra.function.UnsafeSupplier;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.util.ObjectMapperUtil;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Supplier;

import javax.annotation.Generated;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Henrique Pereira
 * @generated
 */
@Generated("")
@GraphQLName("LTW_content")
@JsonFilter("Liferay.Vulcan")
@Schema(
	requiredProperties = {
		"motorcycleName", "motorcycleManufacturing", "motorcycleYear"
	}
)
@XmlRootElement(name = "LTW_content")
public class LTW_content implements Serializable {

	public static LTW_content toDTO(String json) {
		return ObjectMapperUtil.readValue(LTW_content.class, json);
	}

	public static LTW_content unsafeToDTO(String json) {
		return ObjectMapperUtil.unsafeReadValue(LTW_content.class, json);
	}

	@Schema
	public Long getContentId() {
		if (_contentIdSupplier != null) {
			contentId = _contentIdSupplier.get();

			_contentIdSupplier = null;
		}

		return contentId;
	}

	public void setContentId(Long contentId) {
		this.contentId = contentId;

		_contentIdSupplier = null;
	}

	@JsonIgnore
	public void setContentId(
		UnsafeSupplier<Long, Exception> contentIdUnsafeSupplier) {

		_contentIdSupplier = () -> {
			try {
				return contentIdUnsafeSupplier.get();
			}
			catch (RuntimeException runtimeException) {
				throw runtimeException;
			}
			catch (Exception exception) {
				throw new RuntimeException(exception);
			}
		};
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long contentId;

	@JsonIgnore
	private Supplier<Long> _contentIdSupplier;

	@Schema
	public Date getCreateDate() {
		if (_createDateSupplier != null) {
			createDate = _createDateSupplier.get();

			_createDateSupplier = null;
		}

		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;

		_createDateSupplier = null;
	}

	@JsonIgnore
	public void setCreateDate(
		UnsafeSupplier<Date, Exception> createDateUnsafeSupplier) {

		_createDateSupplier = () -> {
			try {
				return createDateUnsafeSupplier.get();
			}
			catch (RuntimeException runtimeException) {
				throw runtimeException;
			}
			catch (Exception exception) {
				throw new RuntimeException(exception);
			}
		};
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Date createDate;

	@JsonIgnore
	private Supplier<Date> _createDateSupplier;

	@Schema
	public Date getModifiedDate() {
		if (_modifiedDateSupplier != null) {
			modifiedDate = _modifiedDateSupplier.get();

			_modifiedDateSupplier = null;
		}

		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;

		_modifiedDateSupplier = null;
	}

	@JsonIgnore
	public void setModifiedDate(
		UnsafeSupplier<Date, Exception> modifiedDateUnsafeSupplier) {

		_modifiedDateSupplier = () -> {
			try {
				return modifiedDateUnsafeSupplier.get();
			}
			catch (RuntimeException runtimeException) {
				throw runtimeException;
			}
			catch (Exception exception) {
				throw new RuntimeException(exception);
			}
		};
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Date modifiedDate;

	@JsonIgnore
	private Supplier<Date> _modifiedDateSupplier;

	@Schema
	public String getMotorcycleManufacturing() {
		if (_motorcycleManufacturingSupplier != null) {
			motorcycleManufacturing = _motorcycleManufacturingSupplier.get();

			_motorcycleManufacturingSupplier = null;
		}

		return motorcycleManufacturing;
	}

	public void setMotorcycleManufacturing(String motorcycleManufacturing) {
		this.motorcycleManufacturing = motorcycleManufacturing;

		_motorcycleManufacturingSupplier = null;
	}

	@JsonIgnore
	public void setMotorcycleManufacturing(
		UnsafeSupplier<String, Exception>
			motorcycleManufacturingUnsafeSupplier) {

		_motorcycleManufacturingSupplier = () -> {
			try {
				return motorcycleManufacturingUnsafeSupplier.get();
			}
			catch (RuntimeException runtimeException) {
				throw runtimeException;
			}
			catch (Exception exception) {
				throw new RuntimeException(exception);
			}
		};
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	@NotEmpty
	protected String motorcycleManufacturing;

	@JsonIgnore
	private Supplier<String> _motorcycleManufacturingSupplier;

	@Schema
	public String getMotorcycleName() {
		if (_motorcycleNameSupplier != null) {
			motorcycleName = _motorcycleNameSupplier.get();

			_motorcycleNameSupplier = null;
		}

		return motorcycleName;
	}

	public void setMotorcycleName(String motorcycleName) {
		this.motorcycleName = motorcycleName;

		_motorcycleNameSupplier = null;
	}

	@JsonIgnore
	public void setMotorcycleName(
		UnsafeSupplier<String, Exception> motorcycleNameUnsafeSupplier) {

		_motorcycleNameSupplier = () -> {
			try {
				return motorcycleNameUnsafeSupplier.get();
			}
			catch (RuntimeException runtimeException) {
				throw runtimeException;
			}
			catch (Exception exception) {
				throw new RuntimeException(exception);
			}
		};
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	@NotEmpty
	protected String motorcycleName;

	@JsonIgnore
	private Supplier<String> _motorcycleNameSupplier;

	@Schema
	public Integer getMotorcycleYear() {
		if (_motorcycleYearSupplier != null) {
			motorcycleYear = _motorcycleYearSupplier.get();

			_motorcycleYearSupplier = null;
		}

		return motorcycleYear;
	}

	public void setMotorcycleYear(Integer motorcycleYear) {
		this.motorcycleYear = motorcycleYear;

		_motorcycleYearSupplier = null;
	}

	@JsonIgnore
	public void setMotorcycleYear(
		UnsafeSupplier<Integer, Exception> motorcycleYearUnsafeSupplier) {

		_motorcycleYearSupplier = () -> {
			try {
				return motorcycleYearUnsafeSupplier.get();
			}
			catch (RuntimeException runtimeException) {
				throw runtimeException;
			}
			catch (Exception exception) {
				throw new RuntimeException(exception);
			}
		};
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	@NotNull
	protected Integer motorcycleYear;

	@JsonIgnore
	private Supplier<Integer> _motorcycleYearSupplier;

	@Schema
	public Long getUserId() {
		if (_userIdSupplier != null) {
			userId = _userIdSupplier.get();

			_userIdSupplier = null;
		}

		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;

		_userIdSupplier = null;
	}

	@JsonIgnore
	public void setUserId(
		UnsafeSupplier<Long, Exception> userIdUnsafeSupplier) {

		_userIdSupplier = () -> {
			try {
				return userIdUnsafeSupplier.get();
			}
			catch (RuntimeException runtimeException) {
				throw runtimeException;
			}
			catch (Exception exception) {
				throw new RuntimeException(exception);
			}
		};
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long userId;

	@JsonIgnore
	private Supplier<Long> _userIdSupplier;

	@Schema
	public String getUserName() {
		if (_userNameSupplier != null) {
			userName = _userNameSupplier.get();

			_userNameSupplier = null;
		}

		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;

		_userNameSupplier = null;
	}

	@JsonIgnore
	public void setUserName(
		UnsafeSupplier<String, Exception> userNameUnsafeSupplier) {

		_userNameSupplier = () -> {
			try {
				return userNameUnsafeSupplier.get();
			}
			catch (RuntimeException runtimeException) {
				throw runtimeException;
			}
			catch (Exception exception) {
				throw new RuntimeException(exception);
			}
		};
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String userName;

	@JsonIgnore
	private Supplier<String> _userNameSupplier;

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof LTW_content)) {
			return false;
		}

		LTW_content ltw_content = (LTW_content)object;

		return Objects.equals(toString(), ltw_content.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		StringBundler sb = new StringBundler();

		sb.append("{");

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		Long contentId = getContentId();

		if (contentId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"contentId\": ");

			sb.append(contentId);
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"createDate\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(createDate));

			sb.append("\"");
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"modifiedDate\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(modifiedDate));

			sb.append("\"");
		}

		String motorcycleManufacturing = getMotorcycleManufacturing();

		if (motorcycleManufacturing != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"motorcycleManufacturing\": ");

			sb.append("\"");

			sb.append(_escape(motorcycleManufacturing));

			sb.append("\"");
		}

		String motorcycleName = getMotorcycleName();

		if (motorcycleName != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"motorcycleName\": ");

			sb.append("\"");

			sb.append(_escape(motorcycleName));

			sb.append("\"");
		}

		Integer motorcycleYear = getMotorcycleYear();

		if (motorcycleYear != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"motorcycleYear\": ");

			sb.append(motorcycleYear);
		}

		Long userId = getUserId();

		if (userId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"userId\": ");

			sb.append(userId);
		}

		String userName = getUserName();

		if (userName != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"userName\": ");

			sb.append("\"");

			sb.append(_escape(userName));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	@Schema(
		accessMode = Schema.AccessMode.READ_ONLY,
		defaultValue = "ltw.content.rest.dto.v1_0.LTW_content",
		name = "x-class-name"
	)
	public String xClassName;

	private static String _escape(Object object) {
		return StringUtil.replace(
			String.valueOf(object), _JSON_ESCAPE_STRINGS[0],
			_JSON_ESCAPE_STRINGS[1]);
	}

	private static boolean _isArray(Object value) {
		if (value == null) {
			return false;
		}

		Class<?> clazz = value.getClass();

		return clazz.isArray();
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
			sb.append(_escape(entry.getKey()));
			sb.append("\": ");

			Object value = entry.getValue();

			if (_isArray(value)) {
				sb.append("[");

				Object[] valueArray = (Object[])value;

				for (int i = 0; i < valueArray.length; i++) {
					if (valueArray[i] instanceof String) {
						sb.append("\"");
						sb.append(valueArray[i]);
						sb.append("\"");
					}
					else {
						sb.append(valueArray[i]);
					}

					if ((i + 1) < valueArray.length) {
						sb.append(", ");
					}
				}

				sb.append("]");
			}
			else if (value instanceof Map) {
				sb.append(_toJSON((Map<String, ?>)value));
			}
			else if (value instanceof String) {
				sb.append("\"");
				sb.append(_escape(value));
				sb.append("\"");
			}
			else {
				sb.append(value);
			}

			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}

		sb.append("}");

		return sb.toString();
	}

	private static final String[][] _JSON_ESCAPE_STRINGS = {
		{"\\", "\"", "\b", "\f", "\n", "\r", "\t"},
		{"\\\\", "\\\"", "\\b", "\\f", "\\n", "\\r", "\\t"}
	};

	private Map<String, Serializable> _extendedProperties;

}