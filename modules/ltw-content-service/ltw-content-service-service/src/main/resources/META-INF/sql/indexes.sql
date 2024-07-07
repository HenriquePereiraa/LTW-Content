create index IX_25A35DA9 on LTW_LTW_content (companyId);
create unique index IX_598370E9 on LTW_LTW_content (groupId, uuid_[$COLUMN_LENGTH:75$]);
create index IX_233586DE on LTW_LTW_content (motorcycleManufacturing[$COLUMN_LENGTH:75$]);
create index IX_C072D14F on LTW_LTW_content (motorcycleName[$COLUMN_LENGTH:75$]);
create index IX_D36B3A81 on LTW_LTW_content (motorcycleYear);
create index IX_1F395659 on LTW_LTW_content (userId);
create index IX_3EBAA4C9 on LTW_LTW_content (userName[$COLUMN_LENGTH:75$]);

create index IX_2AA216AF on LTW_content_LTW_content (companyId);
create unique index IX_7E0D6BA3 on LTW_content_LTW_content (groupId, uuid_[$COLUMN_LENGTH:75$]);
create index IX_3EA0FD64 on LTW_content_LTW_content (motorcycleManufacturing[$COLUMN_LENGTH:75$]);
create index IX_E4FCCC09 on LTW_content_LTW_content (motorcycleName[$COLUMN_LENGTH:75$]);
create index IX_F7F5353B on LTW_content_LTW_content (motorcycleYear);
create index IX_4A9EAB13 on LTW_content_LTW_content (userId);
create index IX_261DB303 on LTW_content_LTW_content (userName[$COLUMN_LENGTH:75$]);