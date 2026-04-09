/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.sohlman.liferay.bfdms.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;

import com.sohlman.liferay.bfdms.exception.NoSuchFileDataException;
import com.sohlman.liferay.bfdms.model.FileData;
import com.sohlman.liferay.bfdms.model.FileDataTable;
import com.sohlman.liferay.bfdms.model.impl.FileDataImpl;
import com.sohlman.liferay.bfdms.model.impl.FileDataModelImpl;
import com.sohlman.liferay.bfdms.service.persistence.FileDataPersistence;
import com.sohlman.liferay.bfdms.service.persistence.FileDataUtil;
import com.sohlman.liferay.bfdms.service.persistence.impl.constants.bfdmsPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the file data service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = FileDataPersistence.class)
public class FileDataPersistenceImpl
	extends BasePersistenceImpl<FileData> implements FileDataPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>FileDataUtil</code> to access the file data persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		FileDataImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByFingerPrint;
	private FinderPath _finderPathWithoutPaginationFindByFingerPrint;
	private FinderPath _finderPathCountByFingerPrint;

	/**
	 * Returns all the file datas where fingerprint = &#63;.
	 *
	 * @param fingerprint the fingerprint
	 * @return the matching file datas
	 */
	@Override
	public List<FileData> findByFingerPrint(String fingerprint) {
		return findByFingerPrint(
			fingerprint, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the file datas where fingerprint = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileDataModelImpl</code>.
	 * </p>
	 *
	 * @param fingerprint the fingerprint
	 * @param start the lower bound of the range of file datas
	 * @param end the upper bound of the range of file datas (not inclusive)
	 * @return the range of matching file datas
	 */
	@Override
	public List<FileData> findByFingerPrint(
		String fingerprint, int start, int end) {

		return findByFingerPrint(fingerprint, start, end, null);
	}

	/**
	 * Returns an ordered range of all the file datas where fingerprint = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileDataModelImpl</code>.
	 * </p>
	 *
	 * @param fingerprint the fingerprint
	 * @param start the lower bound of the range of file datas
	 * @param end the upper bound of the range of file datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching file datas
	 */
	@Override
	public List<FileData> findByFingerPrint(
		String fingerprint, int start, int end,
		OrderByComparator<FileData> orderByComparator) {

		return findByFingerPrint(
			fingerprint, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the file datas where fingerprint = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileDataModelImpl</code>.
	 * </p>
	 *
	 * @param fingerprint the fingerprint
	 * @param start the lower bound of the range of file datas
	 * @param end the upper bound of the range of file datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching file datas
	 */
	@Override
	public List<FileData> findByFingerPrint(
		String fingerprint, int start, int end,
		OrderByComparator<FileData> orderByComparator, boolean useFinderCache) {

		fingerprint = Objects.toString(fingerprint, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByFingerPrint;
				finderArgs = new Object[] {fingerprint};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByFingerPrint;
			finderArgs = new Object[] {
				fingerprint, start, end, orderByComparator
			};
		}

		List<FileData> list = null;

		if (useFinderCache) {
			list = (List<FileData>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (FileData fileData : list) {
					if (!fingerprint.equals(fileData.getFingerprint())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_FILEDATA_WHERE);

			boolean bindFingerprint = false;

			if (fingerprint.isEmpty()) {
				sb.append(_FINDER_COLUMN_FINGERPRINT_FINGERPRINT_3);
			}
			else {
				bindFingerprint = true;

				sb.append(_FINDER_COLUMN_FINGERPRINT_FINGERPRINT_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(FileDataModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindFingerprint) {
					queryPos.add(fingerprint);
				}

				list = (List<FileData>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first file data in the ordered set where fingerprint = &#63;.
	 *
	 * @param fingerprint the fingerprint
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file data
	 * @throws NoSuchFileDataException if a matching file data could not be found
	 */
	@Override
	public FileData findByFingerPrint_First(
			String fingerprint, OrderByComparator<FileData> orderByComparator)
		throws NoSuchFileDataException {

		FileData fileData = fetchByFingerPrint_First(
			fingerprint, orderByComparator);

		if (fileData != null) {
			return fileData;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("fingerprint=");
		sb.append(fingerprint);

		sb.append("}");

		throw new NoSuchFileDataException(sb.toString());
	}

	/**
	 * Returns the first file data in the ordered set where fingerprint = &#63;.
	 *
	 * @param fingerprint the fingerprint
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file data, or <code>null</code> if a matching file data could not be found
	 */
	@Override
	public FileData fetchByFingerPrint_First(
		String fingerprint, OrderByComparator<FileData> orderByComparator) {

		List<FileData> list = findByFingerPrint(
			fingerprint, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last file data in the ordered set where fingerprint = &#63;.
	 *
	 * @param fingerprint the fingerprint
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file data
	 * @throws NoSuchFileDataException if a matching file data could not be found
	 */
	@Override
	public FileData findByFingerPrint_Last(
			String fingerprint, OrderByComparator<FileData> orderByComparator)
		throws NoSuchFileDataException {

		FileData fileData = fetchByFingerPrint_Last(
			fingerprint, orderByComparator);

		if (fileData != null) {
			return fileData;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("fingerprint=");
		sb.append(fingerprint);

		sb.append("}");

		throw new NoSuchFileDataException(sb.toString());
	}

	/**
	 * Returns the last file data in the ordered set where fingerprint = &#63;.
	 *
	 * @param fingerprint the fingerprint
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file data, or <code>null</code> if a matching file data could not be found
	 */
	@Override
	public FileData fetchByFingerPrint_Last(
		String fingerprint, OrderByComparator<FileData> orderByComparator) {

		int count = countByFingerPrint(fingerprint);

		if (count == 0) {
			return null;
		}

		List<FileData> list = findByFingerPrint(
			fingerprint, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the file datas before and after the current file data in the ordered set where fingerprint = &#63;.
	 *
	 * @param fileDataId the primary key of the current file data
	 * @param fingerprint the fingerprint
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next file data
	 * @throws NoSuchFileDataException if a file data with the primary key could not be found
	 */
	@Override
	public FileData[] findByFingerPrint_PrevAndNext(
			long fileDataId, String fingerprint,
			OrderByComparator<FileData> orderByComparator)
		throws NoSuchFileDataException {

		fingerprint = Objects.toString(fingerprint, "");

		FileData fileData = findByPrimaryKey(fileDataId);

		Session session = null;

		try {
			session = openSession();

			FileData[] array = new FileDataImpl[3];

			array[0] = getByFingerPrint_PrevAndNext(
				session, fileData, fingerprint, orderByComparator, true);

			array[1] = fileData;

			array[2] = getByFingerPrint_PrevAndNext(
				session, fileData, fingerprint, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected FileData getByFingerPrint_PrevAndNext(
		Session session, FileData fileData, String fingerprint,
		OrderByComparator<FileData> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_FILEDATA_WHERE);

		boolean bindFingerprint = false;

		if (fingerprint.isEmpty()) {
			sb.append(_FINDER_COLUMN_FINGERPRINT_FINGERPRINT_3);
		}
		else {
			bindFingerprint = true;

			sb.append(_FINDER_COLUMN_FINGERPRINT_FINGERPRINT_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(FileDataModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindFingerprint) {
			queryPos.add(fingerprint);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(fileData)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FileData> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the file datas where fingerprint = &#63; from the database.
	 *
	 * @param fingerprint the fingerprint
	 */
	@Override
	public void removeByFingerPrint(String fingerprint) {
		for (FileData fileData :
				findByFingerPrint(
					fingerprint, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(fileData);
		}
	}

	/**
	 * Returns the number of file datas where fingerprint = &#63;.
	 *
	 * @param fingerprint the fingerprint
	 * @return the number of matching file datas
	 */
	@Override
	public int countByFingerPrint(String fingerprint) {
		fingerprint = Objects.toString(fingerprint, "");

		FinderPath finderPath = _finderPathCountByFingerPrint;

		Object[] finderArgs = new Object[] {fingerprint};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FILEDATA_WHERE);

			boolean bindFingerprint = false;

			if (fingerprint.isEmpty()) {
				sb.append(_FINDER_COLUMN_FINGERPRINT_FINGERPRINT_3);
			}
			else {
				bindFingerprint = true;

				sb.append(_FINDER_COLUMN_FINGERPRINT_FINGERPRINT_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindFingerprint) {
					queryPos.add(fingerprint);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_FINGERPRINT_FINGERPRINT_2 =
		"fileData.fingerprint = ?";

	private static final String _FINDER_COLUMN_FINGERPRINT_FINGERPRINT_3 =
		"(fileData.fingerprint IS NULL OR fileData.fingerprint = '')";

	private FinderPath _finderPathFetchByName;

	/**
	 * Returns the file data where name = &#63; or throws a <code>NoSuchFileDataException</code> if it could not be found.
	 *
	 * @param name the name
	 * @return the matching file data
	 * @throws NoSuchFileDataException if a matching file data could not be found
	 */
	@Override
	public FileData findByName(String name) throws NoSuchFileDataException {
		FileData fileData = fetchByName(name);

		if (fileData == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("name=");
			sb.append(name);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchFileDataException(sb.toString());
		}

		return fileData;
	}

	/**
	 * Returns the file data where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching file data, or <code>null</code> if a matching file data could not be found
	 */
	@Override
	public FileData fetchByName(String name) {
		return fetchByName(name, true);
	}

	/**
	 * Returns the file data where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching file data, or <code>null</code> if a matching file data could not be found
	 */
	@Override
	public FileData fetchByName(String name, boolean useFinderCache) {
		name = Objects.toString(name, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {name};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByName, finderArgs, this);
		}

		if (result instanceof FileData) {
			FileData fileData = (FileData)result;

			if (!Objects.equals(name, fileData.getName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_FILEDATA_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindName) {
					queryPos.add(name);
				}

				List<FileData> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByName, finderArgs, list);
					}
				}
				else {
					FileData fileData = list.get(0);

					result = fileData;

					cacheResult(fileData);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (FileData)result;
		}
	}

	/**
	 * Removes the file data where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the file data that was removed
	 */
	@Override
	public FileData removeByName(String name) throws NoSuchFileDataException {
		FileData fileData = findByName(name);

		return remove(fileData);
	}

	/**
	 * Returns the number of file datas where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching file datas
	 */
	@Override
	public int countByName(String name) {
		FileData fileData = fetchByName(name);

		if (fileData == null) {
			return 0;
		}

		return 1;
	}

	private static final String _FINDER_COLUMN_NAME_NAME_2 =
		"fileData.name = ?";

	private static final String _FINDER_COLUMN_NAME_NAME_3 =
		"(fileData.name IS NULL OR fileData.name = '')";

	public FileDataPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("size", "size_");

		setDBColumnNames(dbColumnNames);

		setModelClass(FileData.class);

		setModelImplClass(FileDataImpl.class);
		setModelPKClass(long.class);

		setTable(FileDataTable.INSTANCE);
	}

	/**
	 * Caches the file data in the entity cache if it is enabled.
	 *
	 * @param fileData the file data
	 */
	@Override
	public void cacheResult(FileData fileData) {
		entityCache.putResult(
			FileDataImpl.class, fileData.getPrimaryKey(), fileData);

		finderCache.putResult(
			_finderPathFetchByName, new Object[] {fileData.getName()},
			fileData);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the file datas in the entity cache if it is enabled.
	 *
	 * @param fileDatas the file datas
	 */
	@Override
	public void cacheResult(List<FileData> fileDatas) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (fileDatas.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (FileData fileData : fileDatas) {
			if (entityCache.getResult(
					FileDataImpl.class, fileData.getPrimaryKey()) == null) {

				cacheResult(fileData);
			}
		}
	}

	/**
	 * Clears the cache for all file datas.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(FileDataImpl.class);

		finderCache.clearCache(FileDataImpl.class);
	}

	/**
	 * Clears the cache for the file data.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FileData fileData) {
		entityCache.removeResult(FileDataImpl.class, fileData);
	}

	@Override
	public void clearCache(List<FileData> fileDatas) {
		for (FileData fileData : fileDatas) {
			entityCache.removeResult(FileDataImpl.class, fileData);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FileDataImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(FileDataImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		FileDataModelImpl fileDataModelImpl) {

		Object[] args = new Object[] {fileDataModelImpl.getName()};

		finderCache.putResult(_finderPathFetchByName, args, fileDataModelImpl);
	}

	/**
	 * Creates a new file data with the primary key. Does not add the file data to the database.
	 *
	 * @param fileDataId the primary key for the new file data
	 * @return the new file data
	 */
	@Override
	public FileData create(long fileDataId) {
		FileData fileData = new FileDataImpl();

		fileData.setNew(true);
		fileData.setPrimaryKey(fileDataId);

		fileData.setCompanyId(CompanyThreadLocal.getCompanyId());

		return fileData;
	}

	/**
	 * Removes the file data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fileDataId the primary key of the file data
	 * @return the file data that was removed
	 * @throws NoSuchFileDataException if a file data with the primary key could not be found
	 */
	@Override
	public FileData remove(long fileDataId) throws NoSuchFileDataException {
		return remove((Serializable)fileDataId);
	}

	/**
	 * Removes the file data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the file data
	 * @return the file data that was removed
	 * @throws NoSuchFileDataException if a file data with the primary key could not be found
	 */
	@Override
	public FileData remove(Serializable primaryKey)
		throws NoSuchFileDataException {

		Session session = null;

		try {
			session = openSession();

			FileData fileData = (FileData)session.get(
				FileDataImpl.class, primaryKey);

			if (fileData == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFileDataException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(fileData);
		}
		catch (NoSuchFileDataException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected FileData removeImpl(FileData fileData) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(fileData)) {
				fileData = (FileData)session.get(
					FileDataImpl.class, fileData.getPrimaryKeyObj());
			}

			if (fileData != null) {
				session.delete(fileData);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (fileData != null) {
			clearCache(fileData);
		}

		return fileData;
	}

	@Override
	public FileData updateImpl(FileData fileData) {
		boolean isNew = fileData.isNew();

		if (!(fileData instanceof FileDataModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(fileData.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(fileData);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in fileData proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom FileData implementation " +
					fileData.getClass());
		}

		FileDataModelImpl fileDataModelImpl = (FileDataModelImpl)fileData;

		if (isNew && (fileData.getCreateDate() == null)) {
			ServiceContext serviceContext =
				ServiceContextThreadLocal.getServiceContext();

			Date date = new Date();

			if (serviceContext == null) {
				fileData.setCreateDate(date);
			}
			else {
				fileData.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(fileData);
			}
			else {
				fileData = (FileData)session.merge(fileData);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			FileDataImpl.class, fileDataModelImpl, false, true);

		cacheUniqueFindersCache(fileDataModelImpl);

		if (isNew) {
			fileData.setNew(false);
		}

		fileData.resetOriginalValues();

		return fileData;
	}

	/**
	 * Returns the file data with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the file data
	 * @return the file data
	 * @throws NoSuchFileDataException if a file data with the primary key could not be found
	 */
	@Override
	public FileData findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFileDataException {

		FileData fileData = fetchByPrimaryKey(primaryKey);

		if (fileData == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFileDataException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return fileData;
	}

	/**
	 * Returns the file data with the primary key or throws a <code>NoSuchFileDataException</code> if it could not be found.
	 *
	 * @param fileDataId the primary key of the file data
	 * @return the file data
	 * @throws NoSuchFileDataException if a file data with the primary key could not be found
	 */
	@Override
	public FileData findByPrimaryKey(long fileDataId)
		throws NoSuchFileDataException {

		return findByPrimaryKey((Serializable)fileDataId);
	}

	/**
	 * Returns the file data with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fileDataId the primary key of the file data
	 * @return the file data, or <code>null</code> if a file data with the primary key could not be found
	 */
	@Override
	public FileData fetchByPrimaryKey(long fileDataId) {
		return fetchByPrimaryKey((Serializable)fileDataId);
	}

	/**
	 * Returns all the file datas.
	 *
	 * @return the file datas
	 */
	@Override
	public List<FileData> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the file datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileDataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of file datas
	 * @param end the upper bound of the range of file datas (not inclusive)
	 * @return the range of file datas
	 */
	@Override
	public List<FileData> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the file datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileDataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of file datas
	 * @param end the upper bound of the range of file datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of file datas
	 */
	@Override
	public List<FileData> findAll(
		int start, int end, OrderByComparator<FileData> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the file datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileDataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of file datas
	 * @param end the upper bound of the range of file datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of file datas
	 */
	@Override
	public List<FileData> findAll(
		int start, int end, OrderByComparator<FileData> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<FileData> list = null;

		if (useFinderCache) {
			list = (List<FileData>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_FILEDATA);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_FILEDATA;

				sql = sql.concat(FileDataModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<FileData>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the file datas from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (FileData fileData : findAll()) {
			remove(fileData);
		}
	}

	/**
	 * Returns the number of file datas.
	 *
	 * @return the number of file datas
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_FILEDATA);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "fileDataId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_FILEDATA;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return FileDataModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the file data persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByFingerPrint = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFingerPrint",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"fingerprint"}, true);

		_finderPathWithoutPaginationFindByFingerPrint = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFingerPrint",
			new String[] {String.class.getName()}, new String[] {"fingerprint"},
			true);

		_finderPathCountByFingerPrint = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFingerPrint",
			new String[] {String.class.getName()}, new String[] {"fingerprint"},
			false);

		_finderPathFetchByName = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByName",
			new String[] {String.class.getName()}, new String[] {"name"}, true);

		FileDataUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		FileDataUtil.setPersistence(null);

		entityCache.removeCache(FileDataImpl.class.getName());
	}

	@Override
	@Reference(
		target = bfdmsPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = bfdmsPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = bfdmsPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_FILEDATA =
		"SELECT fileData FROM FileData fileData";

	private static final String _SQL_SELECT_FILEDATA_WHERE =
		"SELECT fileData FROM FileData fileData WHERE ";

	private static final String _SQL_COUNT_FILEDATA =
		"SELECT COUNT(fileData) FROM FileData fileData";

	private static final String _SQL_COUNT_FILEDATA_WHERE =
		"SELECT COUNT(fileData) FROM FileData fileData WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "fileData.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No FileData exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No FileData exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		FileDataPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"size"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}