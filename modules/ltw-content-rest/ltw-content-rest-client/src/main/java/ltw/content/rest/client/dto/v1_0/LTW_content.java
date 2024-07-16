package ltw.content.rest.client.dto.v1_0;

import java.io.Serializable;

import java.util.Date;
import java.util.Objects;

import javax.annotation.Generated;

import ltw.content.rest.client.function.UnsafeSupplier;
import ltw.content.rest.client.serdes.v1_0.LTW_contentSerDes;

/**
 * @author Henrique Pereira
 * @generated
 */
@Generated("")
public class LTW_content implements Cloneable, Serializable {

	public static LTW_content toDTO(String json) {
		return LTW_contentSerDes.toDTO(json);
	}

	public Long getContentId() {
		return contentId;
	}

	public void setContentId(Long contentId) {
		this.contentId = contentId;
	}

	public void setContentId(
		UnsafeSupplier<Long, Exception> contentIdUnsafeSupplier) {

		try {
			contentId = contentIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long contentId;

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public void setCreateDate(
		UnsafeSupplier<Date, Exception> createDateUnsafeSupplier) {

		try {
			createDate = createDateUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Date createDate;

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public void setModifiedDate(
		UnsafeSupplier<Date, Exception> modifiedDateUnsafeSupplier) {

		try {
			modifiedDate = modifiedDateUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Date modifiedDate;

	public String getMotorcycleManufacturing() {
		return motorcycleManufacturing;
	}

	public void setMotorcycleManufacturing(String motorcycleManufacturing) {
		this.motorcycleManufacturing = motorcycleManufacturing;
	}

	public void setMotorcycleManufacturing(
		UnsafeSupplier<String, Exception>
			motorcycleManufacturingUnsafeSupplier) {

		try {
			motorcycleManufacturing =
				motorcycleManufacturingUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String motorcycleManufacturing;

	public String getMotorcycleName() {
		return motorcycleName;
	}

	public void setMotorcycleName(String motorcycleName) {
		this.motorcycleName = motorcycleName;
	}

	public void setMotorcycleName(
		UnsafeSupplier<String, Exception> motorcycleNameUnsafeSupplier) {

		try {
			motorcycleName = motorcycleNameUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String motorcycleName;

	public Integer getMotorcycleYear() {
		return motorcycleYear;
	}

	public void setMotorcycleYear(Integer motorcycleYear) {
		this.motorcycleYear = motorcycleYear;
	}

	public void setMotorcycleYear(
		UnsafeSupplier<Integer, Exception> motorcycleYearUnsafeSupplier) {

		try {
			motorcycleYear = motorcycleYearUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Integer motorcycleYear;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setUserId(
		UnsafeSupplier<Long, Exception> userIdUnsafeSupplier) {

		try {
			userId = userIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long userId;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setUserName(
		UnsafeSupplier<String, Exception> userNameUnsafeSupplier) {

		try {
			userName = userNameUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String userName;

	@Override
	public LTW_content clone() throws CloneNotSupportedException {
		return (LTW_content)super.clone();
	}

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
		return LTW_contentSerDes.toJSON(this);
	}

}