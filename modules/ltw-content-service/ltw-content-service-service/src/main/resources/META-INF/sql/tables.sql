create table LTW_LTW_content (
	uuid_ VARCHAR(75) null,
	ltwId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	motorcycleName VARCHAR(75) null,
	motorcycleManufacturing VARCHAR(75) null,
	motorcycleYear INTEGER
);

create table LTW_content_LTW_content (
	uuid_ VARCHAR(75) null,
	ltwId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	motorcycleName VARCHAR(75) null,
	motorcycleManufacturing VARCHAR(75) null,
	motorcycleYear INTEGER
);