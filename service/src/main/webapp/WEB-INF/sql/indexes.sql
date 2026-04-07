create index IX_491DFF2B on bffss_FileData (fingerprint);

create index IX_C61D31F4 on bffss_FileInfo (companyId, repositoryId);
create index IX_44595C96 on bffss_FileInfo (companyId, repositoryId, path_);
create unique index IX_BE86E232 on bffss_FileInfo (companyId, repositoryId, path_, version);
create index IX_DD966142 on bffss_FileInfo (fileDataId);