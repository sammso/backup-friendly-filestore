create table bfdms_FileData (
	fileDataId LONG not null primary key,
	companyId LONG,
	createDate DATE null,
	name VARCHAR(255) null,
	size_ LONG,
	fingerprint VARCHAR(255) null
);

create table bfdms_FileInfo (
	fileInfoId LONG not null primary key,
	companyId LONG,
	repositoryId LONG,
	path_ VARCHAR(255) null,
	version VARCHAR(255) null,
	fileDataId LONG
);