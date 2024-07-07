/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package ltw.content.service.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LTW_content}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LTW_content
 * @generated
 */
public class LTW_contentWrapper
	extends BaseModelWrapper<LTW_content>
	implements LTW_content, ModelWrapper<LTW_content> {

	public LTW_contentWrapper(LTW_content ltw_content) {
		super(ltw_content);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("ltwId", getLtwId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("motorcycleName", getMotorcycleName());
		attributes.put("motorcycleManufacturing", getMotorcycleManufacturing());
		attributes.put("motorcycleYear", getMotorcycleYear());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long ltwId = (Long)attributes.get("ltwId");

		if (ltwId != null) {
			setLtwId(ltwId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String motorcycleName = (String)attributes.get("motorcycleName");

		if (motorcycleName != null) {
			setMotorcycleName(motorcycleName);
		}

		String motorcycleManufacturing = (String)attributes.get(
			"motorcycleManufacturing");

		if (motorcycleManufacturing != null) {
			setMotorcycleManufacturing(motorcycleManufacturing);
		}

		Integer motorcycleYear = (Integer)attributes.get("motorcycleYear");

		if (motorcycleYear != null) {
			setMotorcycleYear(motorcycleYear);
		}
	}

	@Override
	public LTW_content cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this ltw_content.
	 *
	 * @return the company ID of this ltw_content
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this ltw_content.
	 *
	 * @return the create date of this ltw_content
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this ltw_content.
	 *
	 * @return the group ID of this ltw_content
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the ltw ID of this ltw_content.
	 *
	 * @return the ltw ID of this ltw_content
	 */
	@Override
	public long getLtwId() {
		return model.getLtwId();
	}

	/**
	 * Returns the modified date of this ltw_content.
	 *
	 * @return the modified date of this ltw_content
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the motorcycle manufacturing of this ltw_content.
	 *
	 * @return the motorcycle manufacturing of this ltw_content
	 */
	@Override
	public String getMotorcycleManufacturing() {
		return model.getMotorcycleManufacturing();
	}

	/**
	 * Returns the motorcycle name of this ltw_content.
	 *
	 * @return the motorcycle name of this ltw_content
	 */
	@Override
	public String getMotorcycleName() {
		return model.getMotorcycleName();
	}

	/**
	 * Returns the motorcycle year of this ltw_content.
	 *
	 * @return the motorcycle year of this ltw_content
	 */
	@Override
	public int getMotorcycleYear() {
		return model.getMotorcycleYear();
	}

	/**
	 * Returns the primary key of this ltw_content.
	 *
	 * @return the primary key of this ltw_content
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this ltw_content.
	 *
	 * @return the user ID of this ltw_content
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this ltw_content.
	 *
	 * @return the user name of this ltw_content
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this ltw_content.
	 *
	 * @return the user uuid of this ltw_content
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this ltw_content.
	 *
	 * @return the uuid of this ltw_content
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this ltw_content.
	 *
	 * @param companyId the company ID of this ltw_content
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this ltw_content.
	 *
	 * @param createDate the create date of this ltw_content
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this ltw_content.
	 *
	 * @param groupId the group ID of this ltw_content
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the ltw ID of this ltw_content.
	 *
	 * @param ltwId the ltw ID of this ltw_content
	 */
	@Override
	public void setLtwId(long ltwId) {
		model.setLtwId(ltwId);
	}

	/**
	 * Sets the modified date of this ltw_content.
	 *
	 * @param modifiedDate the modified date of this ltw_content
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the motorcycle manufacturing of this ltw_content.
	 *
	 * @param motorcycleManufacturing the motorcycle manufacturing of this ltw_content
	 */
	@Override
	public void setMotorcycleManufacturing(String motorcycleManufacturing) {
		model.setMotorcycleManufacturing(motorcycleManufacturing);
	}

	/**
	 * Sets the motorcycle name of this ltw_content.
	 *
	 * @param motorcycleName the motorcycle name of this ltw_content
	 */
	@Override
	public void setMotorcycleName(String motorcycleName) {
		model.setMotorcycleName(motorcycleName);
	}

	/**
	 * Sets the motorcycle year of this ltw_content.
	 *
	 * @param motorcycleYear the motorcycle year of this ltw_content
	 */
	@Override
	public void setMotorcycleYear(int motorcycleYear) {
		model.setMotorcycleYear(motorcycleYear);
	}

	/**
	 * Sets the primary key of this ltw_content.
	 *
	 * @param primaryKey the primary key of this ltw_content
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this ltw_content.
	 *
	 * @param userId the user ID of this ltw_content
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this ltw_content.
	 *
	 * @param userName the user name of this ltw_content
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this ltw_content.
	 *
	 * @param userUuid the user uuid of this ltw_content
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this ltw_content.
	 *
	 * @param uuid the uuid of this ltw_content
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected LTW_contentWrapper wrap(LTW_content ltw_content) {
		return new LTW_contentWrapper(ltw_content);
	}

}