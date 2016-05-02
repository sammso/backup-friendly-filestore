create table bffss_FileData (
	fileDataId LONG not null primary key,
	companyId LONG,
	createDate DATE null,
	name VARCHAR(75) null,
	size_ LONG,
	fingerprint VARCHAR(75) null
);

create table bffss_FileInfo (
	fileInfoId LONG not null primary key,
	companyId LONG,
	repositoryId LONG,
	path_ VARCHAR(75) null,
	version VARCHAR(75) null,
	fileDataId LONG
);