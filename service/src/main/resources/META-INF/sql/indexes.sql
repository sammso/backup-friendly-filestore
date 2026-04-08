create index IX_CB63EAEF on bfdms_FileData (fingerprint[$COLUMN_LENGTH:75$]);

create unique index IX_CF393FF6 on bfdms_FileInfo (companyId, repositoryId, path_[$COLUMN_LENGTH:75$], version[$COLUMN_LENGTH:75$]);
create index IX_C0C1ECFE on bfdms_FileInfo (fileDataId);

create index IX_491DFF2B on bffss_FileData (fingerprint[$COLUMN_LENGTH:75$]);

create unique index IX_BE86E232 on bffss_FileInfo (companyId, repositoryId, path_[$COLUMN_LENGTH:75$], version[$COLUMN_LENGTH:75$]);
create index IX_DD966142 on bffss_FileInfo (fileDataId);