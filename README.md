
# Backup Friendly Filesystem Storage for Liferay Document and Media

## Overview

Backup Friendly Filesystem Storage just shortly abbreviated as BFFSS is a Liferay hook plugin. The purpose of the this plugin is make System Administrators Liferay easier, since the only Database Backup point is required. Any later File System backup will work together with that. This allows easier to use database transaction log to roll up to correct location and revert the user mistakes to specific time.

## How it does work:

BFFSS does not actually remove files from the filesystem, but only "marks" those as deleted and the file status will be handled at database Level. The filesystem filename is unique by having Random + UUID so the probability of the collision even case of rollback is unexistent.

BFFSS also is also optimising file system usage by _**trying**_ to store every file only once. There are use cases that there might be same file twice, example use cases when two same files are uploaded same time. 

## Disclaimer: 

This is still beta so do not use at production yet.
