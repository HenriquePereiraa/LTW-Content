/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package ltw.content.service.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import ltw.content.service.model.LTW_content;

/**
 * The cache model class for representing LTW_content in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class LTW_contentCacheModel
	implements CacheModel<LTW_content>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof LTW_contentCacheModel)) {
			return false;
		}

		LTW_contentCacheModel ltw_contentCacheModel =
			(LTW_contentCacheModel)object;

		if (ltwId == ltw_contentCacheModel.ltwId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, ltwId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", ltwId=");
		sb.append(ltwId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", motorcycleName=");
		sb.append(motorcycleName);
		sb.append(", motorcycleManufacturing=");
		sb.append(motorcycleManufacturing);
		sb.append(", motorcycleYear=");
		sb.append(motorcycleYear);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LTW_content toEntityModel() {
		LTW_contentImpl ltw_contentImpl = new LTW_contentImpl();

		if (uuid == null) {
			ltw_contentImpl.setUuid("");
		}
		else {
			ltw_contentImpl.setUuid(uuid);
		}

		ltw_contentImpl.setLtwId(ltwId);
		ltw_contentImpl.setGroupId(groupId);
		ltw_contentImpl.setCompanyId(companyId);
		ltw_contentImpl.setUserId(userId);

		if (userName == null) {
			ltw_contentImpl.setUserName("");
		}
		else {
			ltw_contentImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			ltw_contentImpl.setCreateDate(null);
		}
		else {
			ltw_contentImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			ltw_contentImpl.setModifiedDate(null);
		}
		else {
			ltw_contentImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (motorcycleName == null) {
			ltw_contentImpl.setMotorcycleName("");
		}
		else {
			ltw_contentImpl.setMotorcycleName(motorcycleName);
		}

		if (motorcycleManufacturing == null) {
			ltw_contentImpl.setMotorcycleManufacturing("");
		}
		else {
			ltw_contentImpl.setMotorcycleManufacturing(motorcycleManufacturing);
		}

		ltw_contentImpl.setMotorcycleYear(motorcycleYear);

		ltw_contentImpl.resetOriginalValues();

		return ltw_contentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		ltwId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		motorcycleName = objectInput.readUTF();
		motorcycleManufacturing = objectInput.readUTF();

		motorcycleYear = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(ltwId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (motorcycleName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(motorcycleName);
		}

		if (motorcycleManufacturing == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(motorcycleManufacturing);
		}

		objectOutput.writeInt(motorcycleYear);
	}

	public String uuid;
	public long ltwId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String motorcycleName;
	public String motorcycleManufacturing;
	public int motorcycleYear;

}