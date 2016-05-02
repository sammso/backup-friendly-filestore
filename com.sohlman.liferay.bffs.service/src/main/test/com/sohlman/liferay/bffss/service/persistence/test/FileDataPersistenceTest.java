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
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.rule.TransactionalTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;

import com.sohlman.liferay.bffss.exception.NoSuchFileDataException;
import com.sohlman.liferay.bffss.model.FileData;
import com.sohlman.liferay.bffss.service.FileDataLocalServiceUtil;
import com.sohlman.liferay.bffss.service.persistence.FileDataPersistence;
import com.sohlman.liferay.bffss.service.persistence.FileDataUtil;

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
public class FileDataPersistenceTest {
	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule = new AggregateTestRule(new LiferayIntegrationTestRule(),
			PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(Propagation.REQUIRED));

	@Before
	public void setUp() {
		_persistence = FileDataUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<FileData> iterator = _fileDatas.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		FileData fileData = _persistence.create(pk);

		Assert.assertNotNull(fileData);

		Assert.assertEquals(fileData.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		FileData newFileData = addFileData();

		_persistence.remove(newFileData);

		FileData existingFileData = _persistence.fetchByPrimaryKey(newFileData.getPrimaryKey());

		Assert.assertNull(existingFileData);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addFileData();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		FileData newFileData = _persistence.create(pk);

		newFileData.setCompanyId(RandomTestUtil.nextLong());

		newFileData.setCreateDate(RandomTestUtil.nextDate());

		newFileData.setName(RandomTestUtil.randomString());

		newFileData.setSize(RandomTestUtil.nextLong());

		newFileData.setFingerprint(RandomTestUtil.randomString());

		_fileDatas.add(_persistence.update(newFileData));

		FileData existingFileData = _persistence.findByPrimaryKey(newFileData.getPrimaryKey());

		Assert.assertEquals(existingFileData.getFileDataId(),
			newFileData.getFileDataId());
		Assert.assertEquals(existingFileData.getCompanyId(),
			newFileData.getCompanyId());
		Assert.assertEquals(Time.getShortTimestamp(
				existingFileData.getCreateDate()),
			Time.getShortTimestamp(newFileData.getCreateDate()));
		Assert.assertEquals(existingFileData.getName(), newFileData.getName());
		Assert.assertEquals(existingFileData.getSize(), newFileData.getSize());
		Assert.assertEquals(existingFileData.getFingerprint(),
			newFileData.getFingerprint());
	}

	@Test
	public void testCountByFingerPrint() throws Exception {
		_persistence.countByFingerPrint(StringPool.BLANK);

		_persistence.countByFingerPrint(StringPool.NULL);

		_persistence.countByFingerPrint((String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		FileData newFileData = addFileData();

		FileData existingFileData = _persistence.findByPrimaryKey(newFileData.getPrimaryKey());

		Assert.assertEquals(existingFileData, newFileData);
	}

	@Test(expected = NoSuchFileDataException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			getOrderByComparator());
	}

	protected OrderByComparator<FileData> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create("bffss_FileData",
			"fileDataId", true, "companyId", true, "createDate", true, "name",
			true, "size", true, "fingerprint", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		FileData newFileData = addFileData();

		FileData existingFileData = _persistence.fetchByPrimaryKey(newFileData.getPrimaryKey());

		Assert.assertEquals(existingFileData, newFileData);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		FileData missingFileData = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingFileData);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {
		FileData newFileData1 = addFileData();
		FileData newFileData2 = addFileData();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newFileData1.getPrimaryKey());
		primaryKeys.add(newFileData2.getPrimaryKey());

		Map<Serializable, FileData> fileDatas = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, fileDatas.size());
		Assert.assertEquals(newFileData1,
			fileDatas.get(newFileData1.getPrimaryKey()));
		Assert.assertEquals(newFileData2,
			fileDatas.get(newFileData2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {
		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, FileData> fileDatas = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(fileDatas.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {
		FileData newFileData = addFileData();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newFileData.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, FileData> fileDatas = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, fileDatas.size());
		Assert.assertEquals(newFileData,
			fileDatas.get(newFileData.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys()
		throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, FileData> fileDatas = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(fileDatas.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey()
		throws Exception {
		FileData newFileData = addFileData();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newFileData.getPrimaryKey());

		Map<Serializable, FileData> fileDatas = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, fileDatas.size());
		Assert.assertEquals(newFileData,
			fileDatas.get(newFileData.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery = FileDataLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(new ActionableDynamicQuery.PerformActionMethod<FileData>() {
				@Override
				public void performAction(FileData fileData) {
					Assert.assertNotNull(fileData);

					count.increment();
				}
			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		FileData newFileData = addFileData();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(FileData.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("fileDataId",
				newFileData.getFileDataId()));

		List<FileData> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		FileData existingFileData = result.get(0);

		Assert.assertEquals(existingFileData, newFileData);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(FileData.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("fileDataId",
				RandomTestUtil.nextLong()));

		List<FileData> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting()
		throws Exception {
		FileData newFileData = addFileData();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(FileData.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("fileDataId"));

		Object newFileDataId = newFileData.getFileDataId();

		dynamicQuery.add(RestrictionsFactoryUtil.in("fileDataId",
				new Object[] { newFileDataId }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingFileDataId = result.get(0);

		Assert.assertEquals(existingFileDataId, newFileDataId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(FileData.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("fileDataId"));

		dynamicQuery.add(RestrictionsFactoryUtil.in("fileDataId",
				new Object[] { RandomTestUtil.nextLong() }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected FileData addFileData() throws Exception {
		long pk = RandomTestUtil.nextLong();

		FileData fileData = _persistence.create(pk);

		fileData.setCompanyId(RandomTestUtil.nextLong());

		fileData.setCreateDate(RandomTestUtil.nextDate());

		fileData.setName(RandomTestUtil.randomString());

		fileData.setSize(RandomTestUtil.nextLong());

		fileData.setFingerprint(RandomTestUtil.randomString());

		_fileDatas.add(_persistence.update(fileData));

		return fileData;
	}

	private List<FileData> _fileDatas = new ArrayList<FileData>();
	private FileDataPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;
}