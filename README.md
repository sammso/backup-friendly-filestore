
# Backup Friendly Filesystem Storage for Liferay Document and Media

## Overview

Backup Friendly Filesystem Storage, abbreviated as BFFSS, is a Liferay plugin. The purpose of this plugin is to make Liferay easier for System Administrators, since only a single Database Backup point is required. Any later File System backup will work together with that. This allows easier use of database transaction logs to roll back to the correct point and revert user mistakes to a specific time.

## How it works

BFFSS does not actually remove files from the filesystem, but only "marks" those as deleted and the file status will be handled at the database level. The filesystem filename is unique by having a Random + UUID so the probability of a collision even in the case of a rollback is nonexistent.

BFFSS is also optimising file system usage by _**trying**_ to store every file only once. There are use cases where there might be the same file twice, for example when two identical files are uploaded at the same time.

## Disclaimer: 

This is still beta so do not use at production yet.

# Build

## Prerequisites

- Java 17
- Maven Wrapper (`mvnw`) is included — no separate Maven installation needed

## Full build

Make sure that Java 17 installed. To test it run

```bash
java -version
```

## Regenerate Service Builder output

Run this after modifying `service.xml`:

```bash
./mvnw com.liferay:com.liferay.portal.tools.service.builder:1.0.508:build -pl service
```

Then rebuild:

```bash
./mvnw clean install
```

