/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.sohlman.liferay.bffss.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.ReflectionTestUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.rule.TransactionalTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;

import com.sohlman.liferay.bffss.exception.NoSuchFileInfoException;
import com.sohlman.liferay.bffss.model.FileInfo;
import com.sohlman.liferay.bffss.service.FileInfoLocalServiceUtil;
import com.sohlman.liferay.bffss.service.persistence.FileInfoPersistence;
import com.sohlman.liferay.bffss.service.persistence.FileInfoUtil;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

import org.junit.runner.RunWith;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class FileInfoPersistenceTest {
	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule = new AggregateTestRule(new LiferayIntegrationTestRule(),
			PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(Propagation.REQUIRED));

	@Before
	public void setUp() {
		_persistence = FileInfoUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<FileInfo> iterator = _fileInfos.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		FileInfo fileInfo = _persistence.create(pk);

		Assert.assertNotNull(fileInfo);

		Assert.assertEquals(fileInfo.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		FileInfo newFileInfo = addFileInfo();

		_persistence.remove(newFileInfo);

		FileInfo existingFileInfo = _persistence.fetchByPrimaryKey(newFileInfo.getPrimaryKey());

		Assert.assertNull(existingFileInfo);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addFileInfo();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		FileInfo newFileInfo = _persistence.create(pk);

		newFileInfo.setCompanyId(RandomTestUtil.nextLong());

		newFileInfo.setRepositoryId(RandomTestUtil.nextLong());

		newFileInfo.setPath(RandomTestUtil.randomString());

		newFileInfo.setVersion(RandomTestUtil.randomString());

		newFileInfo.setFileDataId(RandomTestUtil.nextLong());

		_fileInfos.add(_persistence.update(newFileInfo));

		FileInfo existingFileInfo = _persistence.findByPrimaryKey(newFileInfo.getPrimaryKey());

		Assert.assertEquals(existingFileInfo.getFileInfoId(),
			newFileInfo.getFileInfoId());
		Assert.assertEquals(existingFileInfo.getCompanyId(),
			newFileInfo.getCompanyId());
		Assert.assertEquals(existingFileInfo.getRepositoryId(),
			newFileInfo.getRepositoryId());
		Assert.assertEquals(existingFileInfo.getPath(), newFileInfo.getPath());
		Assert.assertEquals(existingFileInfo.getVersion(),
			newFileInfo.getVersion());
		Assert.assertEquals(existingFileInfo.getFileDataId(),
			newFileInfo.getFileDataId());
	}

	@Test
	public void testCountByC_R() throws Exception {
		_persistence.countByC_R(RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong());

		_persistence.countByC_R(0L, 0L);
	}

	@Test
	public void testCountByC_R_P() throws Exception {
		_persistence.countByC_R_P(RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong(), StringPool.BLANK);

		_persistence.countByC_R_P(0L, 0L, StringPool.NULL);

		_persistence.countByC_R_P(0L, 0L, (String)null);
	}

	@Test
	public void testCountByC_R_LikeP() throws Exception {
		_persistence.countByC_R_LikeP(RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong(), StringPool.BLANK);

		_persistence.countByC_R_LikeP(0L, 0L, StringPool.NULL);

		_persistence.countByC_R_LikeP(0L, 0L, (String)null);
	}

	@Test
	public void testCountByC_R_P_V() throws Exception {
		_persistence.countByC_R_P_V(RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong(), StringPool.BLANK, StringPool.BLANK);

		_persistence.countByC_R_P_V(0L, 0L, StringPool.NULL, StringPool.NULL);

		_persistence.countByC_R_P_V(0L, 0L, (String)null, (String)null);
	}

	@Test
	public void testCountByFileData() throws Exception {
		_persistence.countByFileData(RandomTestUtil.nextLong());

		_persistence.countByFileData(0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		FileInfo newFileInfo = addFileInfo();

		FileInfo existingFileInfo = _persistence.findByPrimaryKey(newFileInfo.getPrimaryKey());

		Assert.assertEquals(existingFileInfo, newFileInfo);
	}

	@Test(expected = NoSuchFileInfoException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			getOrderByComparator());
	}

	protected OrderByComparator<FileInfo> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create("bffss_FileInfo",
			"fileInfoId", true, "companyId", true, "repositoryId", true,
			"path", true, "version", true, "fileDataId", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		FileInfo newFileInfo = addFileInfo();

		FileInfo existingFileInfo = _persistence.fetchByPrimaryKey(newFileInfo.getPrimaryKey());

		Assert.assertEquals(existingFileInfo, newFileInfo);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		FileInfo missingFileInfo = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingFileInfo);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {
		FileInfo newFileInfo1 = addFileInfo();
		FileInfo newFileInfo2 = addFileInfo();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newFileInfo1.getPrimaryKey());
		primaryKeys.add(newFileInfo2.getPrimaryKey());

		Map<Serializable, FileInfo> fileInfos = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, fileInfos.size());
		Assert.assertEquals(newFileInfo1,
			fileInfos.get(newFileInfo1.getPrimaryKey()));
		Assert.assertEquals(newFileInfo2,
			fileInfos.get(newFileInfo2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {
		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, FileInfo> fileInfos = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(fileInfos.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {
		FileInfo newFileInfo = addFileInfo();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newFileInfo.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, FileInfo> fileInfos = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, fileInfos.size());
		Assert.assertEquals(newFileInfo,
			fileInfos.get(newFileInfo.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys()
		throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, FileInfo> fileInfos = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(fileInfos.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey()
		throws Exception {
		FileInfo newFileInfo = addFileInfo();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newFileInfo.getPrimaryKey());

		Map<Serializable, FileInfo> fileInfos = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, fileInfos.size());
		Assert.assertEquals(newFileInfo,
			fileInfos.get(newFileInfo.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery = FileInfoLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(new ActionableDynamicQuery.PerformActionMethod<FileInfo>() {
				@Override
				public void performAction(FileInfo fileInfo) {
					Assert.assertNotNull(fileInfo);

					count.increment();
				}
			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		FileInfo newFileInfo = addFileInfo();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(FileInfo.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("fileInfoId",
				newFileInfo.getFileInfoId()));

		List<FileInfo> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		FileInfo existingFileInfo = result.get(0);

		Assert.assertEquals(existingFileInfo, newFileInfo);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(FileInfo.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("fileInfoId",
				RandomTestUtil.nextLong()));

		List<FileInfo> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting()
		throws Exception {
		FileInfo newFileInfo = addFileInfo();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(FileInfo.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("fileInfoId"));

		Object newFileInfoId = newFileInfo.getFileInfoId();

		dynamicQuery.add(RestrictionsFactoryUtil.in("fileInfoId",
				new Object[] { newFileInfoId }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingFileInfoId = result.get(0);

		Assert.assertEquals(existingFileInfoId, newFileInfoId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(FileInfo.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("fileInfoId"));

		dynamicQuery.add(RestrictionsFactoryUtil.in("fileInfoId",
				new Object[] { RandomTestUtil.nextLong() }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		FileInfo newFileInfo = addFileInfo();

		_persistence.clearCache();

		FileInfo existingFileInfo = _persistence.findByPrimaryKey(newFileInfo.getPrimaryKey());

		Assert.assertEquals(Long.valueOf(existingFileInfo.getCompanyId()),
			ReflectionTestUtil.<Long>invoke(existingFileInfo,
				"getOriginalCompanyId", new Class<?>[0]));
		Assert.assertEquals(Long.valueOf(existingFileInfo.getRepositoryId()),
			ReflectionTestUtil.<Long>invoke(existingFileInfo,
				"getOriginalRepositoryId", new Class<?>[0]));
		Assert.assertTrue(Validator.equals(existingFileInfo.getPath(),
				ReflectionTestUtil.invoke(existingFileInfo, "getOriginalPath",
					new Class<?>[0])));
		Assert.assertTrue(Validator.equals(existingFileInfo.getVersion(),
				ReflectionTestUtil.invoke(existingFileInfo,
					"getOriginalVersion", new Class<?>[0])));
	}

	protected FileInfo addFileInfo() throws Exception {
		long pk = RandomTestUtil.nextLong();

		FileInfo fileInfo = _persistence.create(pk);

		fileInfo.setCompanyId(RandomTestUtil.nextLong());

		fileInfo.setRepositoryId(RandomTestUtil.nextLong());

		fileInfo.setPath(RandomTestUtil.randomString());

		fileInfo.setVersion(RandomTestUtil.randomString());

		fileInfo.setFileDataId(RandomTestUtil.nextLong());

		_fileInfos.add(_persistence.update(fileInfo));

		return fileInfo;
	}

	private List<FileInfo> _fileInfos = new ArrayList<FileInfo>();
	private FileInfoPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;
}