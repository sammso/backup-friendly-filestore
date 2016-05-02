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

package com.sohlman.liferay.bffss.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.sohlman.liferay.bffss.exception.NoSuchFileInfoException;
import com.sohlman.liferay.bffss.model.FileInfo;
import com.sohlman.liferay.bffss.model.impl.FileInfoImpl;
import com.sohlman.liferay.bffss.model.impl.FileInfoModelImpl;
import com.sohlman.liferay.bffss.service.persistence.FileInfoPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the file info service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FileInfoPersistence
 * @see com.sohlman.liferay.bffss.service.persistence.FileInfoUtil
 * @generated
 */
@ProviderType
public class FileInfoPersistenceImpl extends BasePersistenceImpl<FileInfo>
	implements FileInfoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FileInfoUtil} to access the file info persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FileInfoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FileInfoModelImpl.ENTITY_CACHE_ENABLED,
			FileInfoModelImpl.FINDER_CACHE_ENABLED, FileInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FileInfoModelImpl.ENTITY_CACHE_ENABLED,
			FileInfoModelImpl.FINDER_CACHE_ENABLED, FileInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FileInfoModelImpl.ENTITY_CACHE_ENABLED,
			FileInfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_R = new FinderPath(FileInfoModelImpl.ENTITY_CACHE_ENABLED,
			FileInfoModelImpl.FINDER_CACHE_ENABLED, FileInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_R",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_R = new FinderPath(FileInfoModelImpl.ENTITY_CACHE_ENABLED,
			FileInfoModelImpl.FINDER_CACHE_ENABLED, FileInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_R",
			new String[] { Long.class.getName(), Long.class.getName() },
			FileInfoModelImpl.COMPANYID_COLUMN_BITMASK |
			FileInfoModelImpl.REPOSITORYID_COLUMN_BITMASK |
			FileInfoModelImpl.VERSION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_R = new FinderPath(FileInfoModelImpl.ENTITY_CACHE_ENABLED,
			FileInfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_R",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the file infos where companyId = &#63; and repositoryId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 * @return the matching file infos
	 */
	@Override
	public List<FileInfo> findByC_R(long companyId, long repositoryId) {
		return findByC_R(companyId, repositoryId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the file infos where companyId = &#63; and repositoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FileInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 * @param start the lower bound of the range of file infos
	 * @param end the upper bound of the range of file infos (not inclusive)
	 * @return the range of matching file infos
	 */
	@Override
	public List<FileInfo> findByC_R(long companyId, long repositoryId,
		int start, int end) {
		return findByC_R(companyId, repositoryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the file infos where companyId = &#63; and repositoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FileInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 * @param start the lower bound of the range of file infos
	 * @param end the upper bound of the range of file infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching file infos
	 */
	@Override
	public List<FileInfo> findByC_R(long companyId, long repositoryId,
		int start, int end, OrderByComparator<FileInfo> orderByComparator) {
		return findByC_R(companyId, repositoryId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the file infos where companyId = &#63; and repositoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FileInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 * @param start the lower bound of the range of file infos
	 * @param end the upper bound of the range of file infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching file infos
	 */
	@Override
	public List<FileInfo> findByC_R(long companyId, long repositoryId,
		int start, int end, OrderByComparator<FileInfo> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_R;
			finderArgs = new Object[] { companyId, repositoryId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_R;
			finderArgs = new Object[] {
					companyId, repositoryId,
					
					start, end, orderByComparator
				};
		}

		List<FileInfo> list = null;

		if (retrieveFromCache) {
			list = (List<FileInfo>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (FileInfo fileInfo : list) {
					if ((companyId != fileInfo.getCompanyId()) ||
							(repositoryId != fileInfo.getRepositoryId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_FILEINFO_WHERE);

			query.append(_FINDER_COLUMN_C_R_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_R_REPOSITORYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FileInfoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(repositoryId);

				if (!pagination) {
					list = (List<FileInfo>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<FileInfo>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first file info in the ordered set where companyId = &#63; and repositoryId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file info
	 * @throws NoSuchFileInfoException if a matching file info could not be found
	 */
	@Override
	public FileInfo findByC_R_First(long companyId, long repositoryId,
		OrderByComparator<FileInfo> orderByComparator)
		throws NoSuchFileInfoException {
		FileInfo fileInfo = fetchByC_R_First(companyId, repositoryId,
				orderByComparator);

		if (fileInfo != null) {
			return fileInfo;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", repositoryId=");
		msg.append(repositoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFileInfoException(msg.toString());
	}

	/**
	 * Returns the first file info in the ordered set where companyId = &#63; and repositoryId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file info, or <code>null</code> if a matching file info could not be found
	 */
	@Override
	public FileInfo fetchByC_R_First(long companyId, long repositoryId,
		OrderByComparator<FileInfo> orderByComparator) {
		List<FileInfo> list = findByC_R(companyId, repositoryId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last file info in the ordered set where companyId = &#63; and repositoryId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file info
	 * @throws NoSuchFileInfoException if a matching file info could not be found
	 */
	@Override
	public FileInfo findByC_R_Last(long companyId, long repositoryId,
		OrderByComparator<FileInfo> orderByComparator)
		throws NoSuchFileInfoException {
		FileInfo fileInfo = fetchByC_R_Last(companyId, repositoryId,
				orderByComparator);

		if (fileInfo != null) {
			return fileInfo;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", repositoryId=");
		msg.append(repositoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFileInfoException(msg.toString());
	}

	/**
	 * Returns the last file info in the ordered set where companyId = &#63; and repositoryId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file info, or <code>null</code> if a matching file info could not be found
	 */
	@Override
	public FileInfo fetchByC_R_Last(long companyId, long repositoryId,
		OrderByComparator<FileInfo> orderByComparator) {
		int count = countByC_R(companyId, repositoryId);

		if (count == 0) {
			return null;
		}

		List<FileInfo> list = findByC_R(companyId, repositoryId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the file infos before and after the current file info in the ordered set where companyId = &#63; and repositoryId = &#63;.
	 *
	 * @param fileInfoId the primary key of the current file info
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next file info
	 * @throws NoSuchFileInfoException if a file info with the primary key could not be found
	 */
	@Override
	public FileInfo[] findByC_R_PrevAndNext(long fileInfoId, long companyId,
		long repositoryId, OrderByComparator<FileInfo> orderByComparator)
		throws NoSuchFileInfoException {
		FileInfo fileInfo = findByPrimaryKey(fileInfoId);

		Session session = null;

		try {
			session = openSession();

			FileInfo[] array = new FileInfoImpl[3];

			array[0] = getByC_R_PrevAndNext(session, fileInfo, companyId,
					repositoryId, orderByComparator, true);

			array[1] = fileInfo;

			array[2] = getByC_R_PrevAndNext(session, fileInfo, companyId,
					repositoryId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected FileInfo getByC_R_PrevAndNext(Session session, FileInfo fileInfo,
		long companyId, long repositoryId,
		OrderByComparator<FileInfo> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_FILEINFO_WHERE);

		query.append(_FINDER_COLUMN_C_R_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_R_REPOSITORYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(FileInfoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(repositoryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(fileInfo);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FileInfo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the file infos where companyId = &#63; and repositoryId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 */
	@Override
	public void removeByC_R(long companyId, long repositoryId) {
		for (FileInfo fileInfo : findByC_R(companyId, repositoryId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(fileInfo);
		}
	}

	/**
	 * Returns the number of file infos where companyId = &#63; and repositoryId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 * @return the number of matching file infos
	 */
	@Override
	public int countByC_R(long companyId, long repositoryId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_R;

		Object[] finderArgs = new Object[] { companyId, repositoryId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_FILEINFO_WHERE);

			query.append(_FINDER_COLUMN_C_R_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_R_REPOSITORYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(repositoryId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_C_R_COMPANYID_2 = "fileInfo.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_R_REPOSITORYID_2 = "fileInfo.repositoryId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_R_P = new FinderPath(FileInfoModelImpl.ENTITY_CACHE_ENABLED,
			FileInfoModelImpl.FINDER_CACHE_ENABLED, FileInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_R_P",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_R_P = new FinderPath(FileInfoModelImpl.ENTITY_CACHE_ENABLED,
			FileInfoModelImpl.FINDER_CACHE_ENABLED, FileInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_R_P",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			FileInfoModelImpl.COMPANYID_COLUMN_BITMASK |
			FileInfoModelImpl.REPOSITORYID_COLUMN_BITMASK |
			FileInfoModelImpl.PATH_COLUMN_BITMASK |
			FileInfoModelImpl.VERSION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_R_P = new FinderPath(FileInfoModelImpl.ENTITY_CACHE_ENABLED,
			FileInfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_R_P",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns all the file infos where companyId = &#63; and repositoryId = &#63; and path = &#63;.
	 *
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 * @param path the path
	 * @return the matching file infos
	 */
	@Override
	public List<FileInfo> findByC_R_P(long companyId, long repositoryId,
		String path) {
		return findByC_R_P(companyId, repositoryId, path, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the file infos where companyId = &#63; and repositoryId = &#63; and path = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FileInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 * @param path the path
	 * @param start the lower bound of the range of file infos
	 * @param end the upper bound of the range of file infos (not inclusive)
	 * @return the range of matching file infos
	 */
	@Override
	public List<FileInfo> findByC_R_P(long companyId, long repositoryId,
		String path, int start, int end) {
		return findByC_R_P(companyId, repositoryId, path, start, end, null);
	}

	/**
	 * Returns an ordered range of all the file infos where companyId = &#63; and repositoryId = &#63; and path = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FileInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 * @param path the path
	 * @param start the lower bound of the range of file infos
	 * @param end the upper bound of the range of file infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching file infos
	 */
	@Override
	public List<FileInfo> findByC_R_P(long companyId, long repositoryId,
		String path, int start, int end,
		OrderByComparator<FileInfo> orderByComparator) {
		return findByC_R_P(companyId, repositoryId, path, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the file infos where companyId = &#63; and repositoryId = &#63; and path = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FileInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 * @param path the path
	 * @param start the lower bound of the range of file infos
	 * @param end the upper bound of the range of file infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching file infos
	 */
	@Override
	public List<FileInfo> findByC_R_P(long companyId, long repositoryId,
		String path, int start, int end,
		OrderByComparator<FileInfo> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_R_P;
			finderArgs = new Object[] { companyId, repositoryId, path };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_R_P;
			finderArgs = new Object[] {
					companyId, repositoryId, path,
					
					start, end, orderByComparator
				};
		}

		List<FileInfo> list = null;

		if (retrieveFromCache) {
			list = (List<FileInfo>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (FileInfo fileInfo : list) {
					if ((companyId != fileInfo.getCompanyId()) ||
							(repositoryId != fileInfo.getRepositoryId()) ||
							!Validator.equals(path, fileInfo.getPath())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_FILEINFO_WHERE);

			query.append(_FINDER_COLUMN_C_R_P_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_R_P_REPOSITORYID_2);

			boolean bindPath = false;

			if (path == null) {
				query.append(_FINDER_COLUMN_C_R_P_PATH_1);
			}
			else if (path.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_R_P_PATH_3);
			}
			else {
				bindPath = true;

				query.append(_FINDER_COLUMN_C_R_P_PATH_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FileInfoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(repositoryId);

				if (bindPath) {
					qPos.add(path);
				}

				if (!pagination) {
					list = (List<FileInfo>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<FileInfo>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first file info in the ordered set where companyId = &#63; and repositoryId = &#63; and path = &#63;.
	 *
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 * @param path the path
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file info
	 * @throws NoSuchFileInfoException if a matching file info could not be found
	 */
	@Override
	public FileInfo findByC_R_P_First(long companyId, long repositoryId,
		String path, OrderByComparator<FileInfo> orderByComparator)
		throws NoSuchFileInfoException {
		FileInfo fileInfo = fetchByC_R_P_First(companyId, repositoryId, path,
				orderByComparator);

		if (fileInfo != null) {
			return fileInfo;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", repositoryId=");
		msg.append(repositoryId);

		msg.append(", path=");
		msg.append(path);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFileInfoException(msg.toString());
	}

	/**
	 * Returns the first file info in the ordered set where companyId = &#63; and repositoryId = &#63; and path = &#63;.
	 *
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 * @param path the path
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file info, or <code>null</code> if a matching file info could not be found
	 */
	@Override
	public FileInfo fetchByC_R_P_First(long companyId, long repositoryId,
		String path, OrderByComparator<FileInfo> orderByComparator) {
		List<FileInfo> list = findByC_R_P(companyId, repositoryId, path, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last file info in the ordered set where companyId = &#63; and repositoryId = &#63; and path = &#63;.
	 *
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 * @param path the path
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file info
	 * @throws NoSuchFileInfoException if a matching file info could not be found
	 */
	@Override
	public FileInfo findByC_R_P_Last(long companyId, long repositoryId,
		String path, OrderByComparator<FileInfo> orderByComparator)
		throws NoSuchFileInfoException {
		FileInfo fileInfo = fetchByC_R_P_Last(companyId, repositoryId, path,
				orderByComparator);

		if (fileInfo != null) {
			return fileInfo;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", repositoryId=");
		msg.append(repositoryId);

		msg.append(", path=");
		msg.append(path);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFileInfoException(msg.toString());
	}

	/**
	 * Returns the last file info in the ordered set where companyId = &#63; and repositoryId = &#63; and path = &#63;.
	 *
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 * @param path the path
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file info, or <code>null</code> if a matching file info could not be found
	 */
	@Override
	public FileInfo fetchByC_R_P_Last(long companyId, long repositoryId,
		String path, OrderByComparator<FileInfo> orderByComparator) {
		int count = countByC_R_P(companyId, repositoryId, path);

		if (count == 0) {
			return null;
		}

		List<FileInfo> list = findByC_R_P(companyId, repositoryId, path,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the file infos before and after the current file info in the ordered set where companyId = &#63; and repositoryId = &#63; and path = &#63;.
	 *
	 * @param fileInfoId the primary key of the current file info
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 * @param path the path
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next file info
	 * @throws NoSuchFileInfoException if a file info with the primary key could not be found
	 */
	@Override
	public FileInfo[] findByC_R_P_PrevAndNext(long fileInfoId, long companyId,
		long repositoryId, String path,
		OrderByComparator<FileInfo> orderByComparator)
		throws NoSuchFileInfoException {
		FileInfo fileInfo = findByPrimaryKey(fileInfoId);

		Session session = null;

		try {
			session = openSession();

			FileInfo[] array = new FileInfoImpl[3];

			array[0] = getByC_R_P_PrevAndNext(session, fileInfo, companyId,
					repositoryId, path, orderByComparator, true);

			array[1] = fileInfo;

			array[2] = getByC_R_P_PrevAndNext(session, fileInfo, companyId,
					repositoryId, path, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected FileInfo getByC_R_P_PrevAndNext(Session session,
		FileInfo fileInfo, long companyId, long repositoryId, String path,
		OrderByComparator<FileInfo> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_FILEINFO_WHERE);

		query.append(_FINDER_COLUMN_C_R_P_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_R_P_REPOSITORYID_2);

		boolean bindPath = false;

		if (path == null) {
			query.append(_FINDER_COLUMN_C_R_P_PATH_1);
		}
		else if (path.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_C_R_P_PATH_3);
		}
		else {
			bindPath = true;

			query.append(_FINDER_COLUMN_C_R_P_PATH_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(FileInfoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(repositoryId);

		if (bindPath) {
			qPos.add(path);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(fileInfo);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FileInfo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the file infos where companyId = &#63; and repositoryId = &#63; and path = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 * @param path the path
	 */
	@Override
	public void removeByC_R_P(long companyId, long repositoryId, String path) {
		for (FileInfo fileInfo : findByC_R_P(companyId, repositoryId, path,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(fileInfo);
		}
	}

	/**
	 * Returns the number of file infos where companyId = &#63; and repositoryId = &#63; and path = &#63;.
	 *
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 * @param path the path
	 * @return the number of matching file infos
	 */
	@Override
	public int countByC_R_P(long companyId, long repositoryId, String path) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_R_P;

		Object[] finderArgs = new Object[] { companyId, repositoryId, path };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_FILEINFO_WHERE);

			query.append(_FINDER_COLUMN_C_R_P_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_R_P_REPOSITORYID_2);

			boolean bindPath = false;

			if (path == null) {
				query.append(_FINDER_COLUMN_C_R_P_PATH_1);
			}
			else if (path.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_R_P_PATH_3);
			}
			else {
				bindPath = true;

				query.append(_FINDER_COLUMN_C_R_P_PATH_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(repositoryId);

				if (bindPath) {
					qPos.add(path);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_C_R_P_COMPANYID_2 = "fileInfo.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_R_P_REPOSITORYID_2 = "fileInfo.repositoryId = ? AND ";
	private static final String _FINDER_COLUMN_C_R_P_PATH_1 = "fileInfo.path IS NULL";
	private static final String _FINDER_COLUMN_C_R_P_PATH_2 = "fileInfo.path = ?";
	private static final String _FINDER_COLUMN_C_R_P_PATH_3 = "(fileInfo.path IS NULL OR fileInfo.path = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_R_LIKEP =
		new FinderPath(FileInfoModelImpl.ENTITY_CACHE_ENABLED,
			FileInfoModelImpl.FINDER_CACHE_ENABLED, FileInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_R_LikeP",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_C_R_LIKEP =
		new FinderPath(FileInfoModelImpl.ENTITY_CACHE_ENABLED,
			FileInfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByC_R_LikeP",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns all the file infos where companyId = &#63; and repositoryId = &#63; and path LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 * @param path the path
	 * @return the matching file infos
	 */
	@Override
	public List<FileInfo> findByC_R_LikeP(long companyId, long repositoryId,
		String path) {
		return findByC_R_LikeP(companyId, repositoryId, path,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the file infos where companyId = &#63; and repositoryId = &#63; and path LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FileInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 * @param path the path
	 * @param start the lower bound of the range of file infos
	 * @param end the upper bound of the range of file infos (not inclusive)
	 * @return the range of matching file infos
	 */
	@Override
	public List<FileInfo> findByC_R_LikeP(long companyId, long repositoryId,
		String path, int start, int end) {
		return findByC_R_LikeP(companyId, repositoryId, path, start, end, null);
	}

	/**
	 * Returns an ordered range of all the file infos where companyId = &#63; and repositoryId = &#63; and path LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FileInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 * @param path the path
	 * @param start the lower bound of the range of file infos
	 * @param end the upper bound of the range of file infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching file infos
	 */
	@Override
	public List<FileInfo> findByC_R_LikeP(long companyId, long repositoryId,
		String path, int start, int end,
		OrderByComparator<FileInfo> orderByComparator) {
		return findByC_R_LikeP(companyId, repositoryId, path, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the file infos where companyId = &#63; and repositoryId = &#63; and path LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FileInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 * @param path the path
	 * @param start the lower bound of the range of file infos
	 * @param end the upper bound of the range of file infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching file infos
	 */
	@Override
	public List<FileInfo> findByC_R_LikeP(long companyId, long repositoryId,
		String path, int start, int end,
		OrderByComparator<FileInfo> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_R_LIKEP;
		finderArgs = new Object[] {
				companyId, repositoryId, path,
				
				start, end, orderByComparator
			};

		List<FileInfo> list = null;

		if (retrieveFromCache) {
			list = (List<FileInfo>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (FileInfo fileInfo : list) {
					if ((companyId != fileInfo.getCompanyId()) ||
							(repositoryId != fileInfo.getRepositoryId()) ||
							!StringUtil.wildcardMatches(fileInfo.getPath(),
								path, CharPool.UNDERLINE, CharPool.PERCENT,
								CharPool.BACK_SLASH, true)) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_FILEINFO_WHERE);

			query.append(_FINDER_COLUMN_C_R_LIKEP_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_R_LIKEP_REPOSITORYID_2);

			boolean bindPath = false;

			if (path == null) {
				query.append(_FINDER_COLUMN_C_R_LIKEP_PATH_1);
			}
			else if (path.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_R_LIKEP_PATH_3);
			}
			else {
				bindPath = true;

				query.append(_FINDER_COLUMN_C_R_LIKEP_PATH_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FileInfoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(repositoryId);

				if (bindPath) {
					qPos.add(path);
				}

				if (!pagination) {
					list = (List<FileInfo>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<FileInfo>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first file info in the ordered set where companyId = &#63; and repositoryId = &#63; and path LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 * @param path the path
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file info
	 * @throws NoSuchFileInfoException if a matching file info could not be found
	 */
	@Override
	public FileInfo findByC_R_LikeP_First(long companyId, long repositoryId,
		String path, OrderByComparator<FileInfo> orderByComparator)
		throws NoSuchFileInfoException {
		FileInfo fileInfo = fetchByC_R_LikeP_First(companyId, repositoryId,
				path, orderByComparator);

		if (fileInfo != null) {
			return fileInfo;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", repositoryId=");
		msg.append(repositoryId);

		msg.append(", path=");
		msg.append(path);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFileInfoException(msg.toString());
	}

	/**
	 * Returns the first file info in the ordered set where companyId = &#63; and repositoryId = &#63; and path LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 * @param path the path
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file info, or <code>null</code> if a matching file info could not be found
	 */
	@Override
	public FileInfo fetchByC_R_LikeP_First(long companyId, long repositoryId,
		String path, OrderByComparator<FileInfo> orderByComparator) {
		List<FileInfo> list = findByC_R_LikeP(companyId, repositoryId, path, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last file info in the ordered set where companyId = &#63; and repositoryId = &#63; and path LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 * @param path the path
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file info
	 * @throws NoSuchFileInfoException if a matching file info could not be found
	 */
	@Override
	public FileInfo findByC_R_LikeP_Last(long companyId, long repositoryId,
		String path, OrderByComparator<FileInfo> orderByComparator)
		throws NoSuchFileInfoException {
		FileInfo fileInfo = fetchByC_R_LikeP_Last(companyId, repositoryId,
				path, orderByComparator);

		if (fileInfo != null) {
			return fileInfo;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", repositoryId=");
		msg.append(repositoryId);

		msg.append(", path=");
		msg.append(path);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFileInfoException(msg.toString());
	}

	/**
	 * Returns the last file info in the ordered set where companyId = &#63; and repositoryId = &#63; and path LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 * @param path the path
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file info, or <code>null</code> if a matching file info could not be found
	 */
	@Override
	public FileInfo fetchByC_R_LikeP_Last(long companyId, long repositoryId,
		String path, OrderByComparator<FileInfo> orderByComparator) {
		int count = countByC_R_LikeP(companyId, repositoryId, path);

		if (count == 0) {
			return null;
		}

		List<FileInfo> list = findByC_R_LikeP(companyId, repositoryId, path,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the file infos before and after the current file info in the ordered set where companyId = &#63; and repositoryId = &#63; and path LIKE &#63;.
	 *
	 * @param fileInfoId the primary key of the current file info
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 * @param path the path
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next file info
	 * @throws NoSuchFileInfoException if a file info with the primary key could not be found
	 */
	@Override
	public FileInfo[] findByC_R_LikeP_PrevAndNext(long fileInfoId,
		long companyId, long repositoryId, String path,
		OrderByComparator<FileInfo> orderByComparator)
		throws NoSuchFileInfoException {
		FileInfo fileInfo = findByPrimaryKey(fileInfoId);

		Session session = null;

		try {
			session = openSession();

			FileInfo[] array = new FileInfoImpl[3];

			array[0] = getByC_R_LikeP_PrevAndNext(session, fileInfo, companyId,
					repositoryId, path, orderByComparator, true);

			array[1] = fileInfo;

			array[2] = getByC_R_LikeP_PrevAndNext(session, fileInfo, companyId,
					repositoryId, path, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected FileInfo getByC_R_LikeP_PrevAndNext(Session session,
		FileInfo fileInfo, long companyId, long repositoryId, String path,
		OrderByComparator<FileInfo> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_FILEINFO_WHERE);

		query.append(_FINDER_COLUMN_C_R_LIKEP_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_R_LIKEP_REPOSITORYID_2);

		boolean bindPath = false;

		if (path == null) {
			query.append(_FINDER_COLUMN_C_R_LIKEP_PATH_1);
		}
		else if (path.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_C_R_LIKEP_PATH_3);
		}
		else {
			bindPath = true;

			query.append(_FINDER_COLUMN_C_R_LIKEP_PATH_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(FileInfoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(repositoryId);

		if (bindPath) {
			qPos.add(path);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(fileInfo);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FileInfo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the file infos where companyId = &#63; and repositoryId = &#63; and path LIKE &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 * @param path the path
	 */
	@Override
	public void removeByC_R_LikeP(long companyId, long repositoryId, String path) {
		for (FileInfo fileInfo : findByC_R_LikeP(companyId, repositoryId, path,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(fileInfo);
		}
	}

	/**
	 * Returns the number of file infos where companyId = &#63; and repositoryId = &#63; and path LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 * @param path the path
	 * @return the number of matching file infos
	 */
	@Override
	public int countByC_R_LikeP(long companyId, long repositoryId, String path) {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_C_R_LIKEP;

		Object[] finderArgs = new Object[] { companyId, repositoryId, path };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_FILEINFO_WHERE);

			query.append(_FINDER_COLUMN_C_R_LIKEP_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_R_LIKEP_REPOSITORYID_2);

			boolean bindPath = false;

			if (path == null) {
				query.append(_FINDER_COLUMN_C_R_LIKEP_PATH_1);
			}
			else if (path.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_R_LIKEP_PATH_3);
			}
			else {
				bindPath = true;

				query.append(_FINDER_COLUMN_C_R_LIKEP_PATH_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(repositoryId);

				if (bindPath) {
					qPos.add(path);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_C_R_LIKEP_COMPANYID_2 = "fileInfo.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_R_LIKEP_REPOSITORYID_2 = "fileInfo.repositoryId = ? AND ";
	private static final String _FINDER_COLUMN_C_R_LIKEP_PATH_1 = "fileInfo.path IS NULL";
	private static final String _FINDER_COLUMN_C_R_LIKEP_PATH_2 = "fileInfo.path LIKE ?";
	private static final String _FINDER_COLUMN_C_R_LIKEP_PATH_3 = "(fileInfo.path IS NULL OR fileInfo.path LIKE '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_C_R_P_V = new FinderPath(FileInfoModelImpl.ENTITY_CACHE_ENABLED,
			FileInfoModelImpl.FINDER_CACHE_ENABLED, FileInfoImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByC_R_P_V",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), String.class.getName()
			},
			FileInfoModelImpl.COMPANYID_COLUMN_BITMASK |
			FileInfoModelImpl.REPOSITORYID_COLUMN_BITMASK |
			FileInfoModelImpl.PATH_COLUMN_BITMASK |
			FileInfoModelImpl.VERSION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_R_P_V = new FinderPath(FileInfoModelImpl.ENTITY_CACHE_ENABLED,
			FileInfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_R_P_V",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), String.class.getName()
			});

	/**
	 * Returns the file info where companyId = &#63; and repositoryId = &#63; and path = &#63; and version = &#63; or throws a {@link NoSuchFileInfoException} if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 * @param path the path
	 * @param version the version
	 * @return the matching file info
	 * @throws NoSuchFileInfoException if a matching file info could not be found
	 */
	@Override
	public FileInfo findByC_R_P_V(long companyId, long repositoryId,
		String path, String version) throws NoSuchFileInfoException {
		FileInfo fileInfo = fetchByC_R_P_V(companyId, repositoryId, path,
				version);

		if (fileInfo == null) {
			StringBundler msg = new StringBundler(10);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(", repositoryId=");
			msg.append(repositoryId);

			msg.append(", path=");
			msg.append(path);

			msg.append(", version=");
			msg.append(version);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchFileInfoException(msg.toString());
		}

		return fileInfo;
	}

	/**
	 * Returns the file info where companyId = &#63; and repositoryId = &#63; and path = &#63; and version = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 * @param path the path
	 * @param version the version
	 * @return the matching file info, or <code>null</code> if a matching file info could not be found
	 */
	@Override
	public FileInfo fetchByC_R_P_V(long companyId, long repositoryId,
		String path, String version) {
		return fetchByC_R_P_V(companyId, repositoryId, path, version, true);
	}

	/**
	 * Returns the file info where companyId = &#63; and repositoryId = &#63; and path = &#63; and version = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 * @param path the path
	 * @param version the version
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching file info, or <code>null</code> if a matching file info could not be found
	 */
	@Override
	public FileInfo fetchByC_R_P_V(long companyId, long repositoryId,
		String path, String version, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] {
				companyId, repositoryId, path, version
			};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_C_R_P_V,
					finderArgs, this);
		}

		if (result instanceof FileInfo) {
			FileInfo fileInfo = (FileInfo)result;

			if ((companyId != fileInfo.getCompanyId()) ||
					(repositoryId != fileInfo.getRepositoryId()) ||
					!Validator.equals(path, fileInfo.getPath()) ||
					!Validator.equals(version, fileInfo.getVersion())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(6);

			query.append(_SQL_SELECT_FILEINFO_WHERE);

			query.append(_FINDER_COLUMN_C_R_P_V_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_R_P_V_REPOSITORYID_2);

			boolean bindPath = false;

			if (path == null) {
				query.append(_FINDER_COLUMN_C_R_P_V_PATH_1);
			}
			else if (path.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_R_P_V_PATH_3);
			}
			else {
				bindPath = true;

				query.append(_FINDER_COLUMN_C_R_P_V_PATH_2);
			}

			boolean bindVersion = false;

			if (version == null) {
				query.append(_FINDER_COLUMN_C_R_P_V_VERSION_1);
			}
			else if (version.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_R_P_V_VERSION_3);
			}
			else {
				bindVersion = true;

				query.append(_FINDER_COLUMN_C_R_P_V_VERSION_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(repositoryId);

				if (bindPath) {
					qPos.add(path);
				}

				if (bindVersion) {
					qPos.add(version);
				}

				List<FileInfo> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_C_R_P_V,
						finderArgs, list);
				}
				else {
					FileInfo fileInfo = list.get(0);

					result = fileInfo;

					cacheResult(fileInfo);

					if ((fileInfo.getCompanyId() != companyId) ||
							(fileInfo.getRepositoryId() != repositoryId) ||
							(fileInfo.getPath() == null) ||
							!fileInfo.getPath().equals(path) ||
							(fileInfo.getVersion() == null) ||
							!fileInfo.getVersion().equals(version)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_C_R_P_V,
							finderArgs, fileInfo);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_C_R_P_V,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (FileInfo)result;
		}
	}

	/**
	 * Removes the file info where companyId = &#63; and repositoryId = &#63; and path = &#63; and version = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 * @param path the path
	 * @param version the version
	 * @return the file info that was removed
	 */
	@Override
	public FileInfo removeByC_R_P_V(long companyId, long repositoryId,
		String path, String version) throws NoSuchFileInfoException {
		FileInfo fileInfo = findByC_R_P_V(companyId, repositoryId, path, version);

		return remove(fileInfo);
	}

	/**
	 * Returns the number of file infos where companyId = &#63; and repositoryId = &#63; and path = &#63; and version = &#63;.
	 *
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 * @param path the path
	 * @param version the version
	 * @return the number of matching file infos
	 */
	@Override
	public int countByC_R_P_V(long companyId, long repositoryId, String path,
		String version) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_R_P_V;

		Object[] finderArgs = new Object[] {
				companyId, repositoryId, path, version
			};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_FILEINFO_WHERE);

			query.append(_FINDER_COLUMN_C_R_P_V_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_R_P_V_REPOSITORYID_2);

			boolean bindPath = false;

			if (path == null) {
				query.append(_FINDER_COLUMN_C_R_P_V_PATH_1);
			}
			else if (path.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_R_P_V_PATH_3);
			}
			else {
				bindPath = true;

				query.append(_FINDER_COLUMN_C_R_P_V_PATH_2);
			}

			boolean bindVersion = false;

			if (version == null) {
				query.append(_FINDER_COLUMN_C_R_P_V_VERSION_1);
			}
			else if (version.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_R_P_V_VERSION_3);
			}
			else {
				bindVersion = true;

				query.append(_FINDER_COLUMN_C_R_P_V_VERSION_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(repositoryId);

				if (bindPath) {
					qPos.add(path);
				}

				if (bindVersion) {
					qPos.add(version);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_C_R_P_V_COMPANYID_2 = "fileInfo.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_R_P_V_REPOSITORYID_2 = "fileInfo.repositoryId = ? AND ";
	private static final String _FINDER_COLUMN_C_R_P_V_PATH_1 = "fileInfo.path IS NULL AND ";
	private static final String _FINDER_COLUMN_C_R_P_V_PATH_2 = "fileInfo.path = ? AND ";
	private static final String _FINDER_COLUMN_C_R_P_V_PATH_3 = "(fileInfo.path IS NULL OR fileInfo.path = '') AND ";
	private static final String _FINDER_COLUMN_C_R_P_V_VERSION_1 = "fileInfo.version IS NULL";
	private static final String _FINDER_COLUMN_C_R_P_V_VERSION_2 = "fileInfo.version = ?";
	private static final String _FINDER_COLUMN_C_R_P_V_VERSION_3 = "(fileInfo.version IS NULL OR fileInfo.version = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FILEDATA = new FinderPath(FileInfoModelImpl.ENTITY_CACHE_ENABLED,
			FileInfoModelImpl.FINDER_CACHE_ENABLED, FileInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFileData",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FILEDATA =
		new FinderPath(FileInfoModelImpl.ENTITY_CACHE_ENABLED,
			FileInfoModelImpl.FINDER_CACHE_ENABLED, FileInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFileData",
			new String[] { Long.class.getName() },
			FileInfoModelImpl.FILEDATAID_COLUMN_BITMASK |
			FileInfoModelImpl.VERSION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FILEDATA = new FinderPath(FileInfoModelImpl.ENTITY_CACHE_ENABLED,
			FileInfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFileData",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the file infos where fileDataId = &#63;.
	 *
	 * @param fileDataId the file data ID
	 * @return the matching file infos
	 */
	@Override
	public List<FileInfo> findByFileData(long fileDataId) {
		return findByFileData(fileDataId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the file infos where fileDataId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FileInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param fileDataId the file data ID
	 * @param start the lower bound of the range of file infos
	 * @param end the upper bound of the range of file infos (not inclusive)
	 * @return the range of matching file infos
	 */
	@Override
	public List<FileInfo> findByFileData(long fileDataId, int start, int end) {
		return findByFileData(fileDataId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the file infos where fileDataId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FileInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param fileDataId the file data ID
	 * @param start the lower bound of the range of file infos
	 * @param end the upper bound of the range of file infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching file infos
	 */
	@Override
	public List<FileInfo> findByFileData(long fileDataId, int start, int end,
		OrderByComparator<FileInfo> orderByComparator) {
		return findByFileData(fileDataId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the file infos where fileDataId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FileInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param fileDataId the file data ID
	 * @param start the lower bound of the range of file infos
	 * @param end the upper bound of the range of file infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching file infos
	 */
	@Override
	public List<FileInfo> findByFileData(long fileDataId, int start, int end,
		OrderByComparator<FileInfo> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FILEDATA;
			finderArgs = new Object[] { fileDataId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_FILEDATA;
			finderArgs = new Object[] { fileDataId, start, end, orderByComparator };
		}

		List<FileInfo> list = null;

		if (retrieveFromCache) {
			list = (List<FileInfo>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (FileInfo fileInfo : list) {
					if ((fileDataId != fileInfo.getFileDataId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_FILEINFO_WHERE);

			query.append(_FINDER_COLUMN_FILEDATA_FILEDATAID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FileInfoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(fileDataId);

				if (!pagination) {
					list = (List<FileInfo>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<FileInfo>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first file info in the ordered set where fileDataId = &#63;.
	 *
	 * @param fileDataId the file data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file info
	 * @throws NoSuchFileInfoException if a matching file info could not be found
	 */
	@Override
	public FileInfo findByFileData_First(long fileDataId,
		OrderByComparator<FileInfo> orderByComparator)
		throws NoSuchFileInfoException {
		FileInfo fileInfo = fetchByFileData_First(fileDataId, orderByComparator);

		if (fileInfo != null) {
			return fileInfo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("fileDataId=");
		msg.append(fileDataId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFileInfoException(msg.toString());
	}

	/**
	 * Returns the first file info in the ordered set where fileDataId = &#63;.
	 *
	 * @param fileDataId the file data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file info, or <code>null</code> if a matching file info could not be found
	 */
	@Override
	public FileInfo fetchByFileData_First(long fileDataId,
		OrderByComparator<FileInfo> orderByComparator) {
		List<FileInfo> list = findByFileData(fileDataId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last file info in the ordered set where fileDataId = &#63;.
	 *
	 * @param fileDataId the file data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file info
	 * @throws NoSuchFileInfoException if a matching file info could not be found
	 */
	@Override
	public FileInfo findByFileData_Last(long fileDataId,
		OrderByComparator<FileInfo> orderByComparator)
		throws NoSuchFileInfoException {
		FileInfo fileInfo = fetchByFileData_Last(fileDataId, orderByComparator);

		if (fileInfo != null) {
			return fileInfo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("fileDataId=");
		msg.append(fileDataId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFileInfoException(msg.toString());
	}

	/**
	 * Returns the last file info in the ordered set where fileDataId = &#63;.
	 *
	 * @param fileDataId the file data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file info, or <code>null</code> if a matching file info could not be found
	 */
	@Override
	public FileInfo fetchByFileData_Last(long fileDataId,
		OrderByComparator<FileInfo> orderByComparator) {
		int count = countByFileData(fileDataId);

		if (count == 0) {
			return null;
		}

		List<FileInfo> list = findByFileData(fileDataId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the file infos before and after the current file info in the ordered set where fileDataId = &#63;.
	 *
	 * @param fileInfoId the primary key of the current file info
	 * @param fileDataId the file data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next file info
	 * @throws NoSuchFileInfoException if a file info with the primary key could not be found
	 */
	@Override
	public FileInfo[] findByFileData_PrevAndNext(long fileInfoId,
		long fileDataId, OrderByComparator<FileInfo> orderByComparator)
		throws NoSuchFileInfoException {
		FileInfo fileInfo = findByPrimaryKey(fileInfoId);

		Session session = null;

		try {
			session = openSession();

			FileInfo[] array = new FileInfoImpl[3];

			array[0] = getByFileData_PrevAndNext(session, fileInfo, fileDataId,
					orderByComparator, true);

			array[1] = fileInfo;

			array[2] = getByFileData_PrevAndNext(session, fileInfo, fileDataId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected FileInfo getByFileData_PrevAndNext(Session session,
		FileInfo fileInfo, long fileDataId,
		OrderByComparator<FileInfo> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FILEINFO_WHERE);

		query.append(_FINDER_COLUMN_FILEDATA_FILEDATAID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(FileInfoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(fileDataId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(fileInfo);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FileInfo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the file infos where fileDataId = &#63; from the database.
	 *
	 * @param fileDataId the file data ID
	 */
	@Override
	public void removeByFileData(long fileDataId) {
		for (FileInfo fileInfo : findByFileData(fileDataId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(fileInfo);
		}
	}

	/**
	 * Returns the number of file infos where fileDataId = &#63;.
	 *
	 * @param fileDataId the file data ID
	 * @return the number of matching file infos
	 */
	@Override
	public int countByFileData(long fileDataId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_FILEDATA;

		Object[] finderArgs = new Object[] { fileDataId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FILEINFO_WHERE);

			query.append(_FINDER_COLUMN_FILEDATA_FILEDATAID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(fileDataId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_FILEDATA_FILEDATAID_2 = "fileInfo.fileDataId = ?";

	public FileInfoPersistenceImpl() {
		setModelClass(FileInfo.class);
	}

	/**
	 * Caches the file info in the entity cache if it is enabled.
	 *
	 * @param fileInfo the file info
	 */
	@Override
	public void cacheResult(FileInfo fileInfo) {
		entityCache.putResult(FileInfoModelImpl.ENTITY_CACHE_ENABLED,
			FileInfoImpl.class, fileInfo.getPrimaryKey(), fileInfo);

		finderCache.putResult(FINDER_PATH_FETCH_BY_C_R_P_V,
			new Object[] {
				fileInfo.getCompanyId(), fileInfo.getRepositoryId(),
				fileInfo.getPath(), fileInfo.getVersion()
			}, fileInfo);

		fileInfo.resetOriginalValues();
	}

	/**
	 * Caches the file infos in the entity cache if it is enabled.
	 *
	 * @param fileInfos the file infos
	 */
	@Override
	public void cacheResult(List<FileInfo> fileInfos) {
		for (FileInfo fileInfo : fileInfos) {
			if (entityCache.getResult(FileInfoModelImpl.ENTITY_CACHE_ENABLED,
						FileInfoImpl.class, fileInfo.getPrimaryKey()) == null) {
				cacheResult(fileInfo);
			}
			else {
				fileInfo.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all file infos.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(FileInfoImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the file info.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FileInfo fileInfo) {
		entityCache.removeResult(FileInfoModelImpl.ENTITY_CACHE_ENABLED,
			FileInfoImpl.class, fileInfo.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((FileInfoModelImpl)fileInfo);
	}

	@Override
	public void clearCache(List<FileInfo> fileInfos) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (FileInfo fileInfo : fileInfos) {
			entityCache.removeResult(FileInfoModelImpl.ENTITY_CACHE_ENABLED,
				FileInfoImpl.class, fileInfo.getPrimaryKey());

			clearUniqueFindersCache((FileInfoModelImpl)fileInfo);
		}
	}

	protected void cacheUniqueFindersCache(
		FileInfoModelImpl fileInfoModelImpl, boolean isNew) {
		if (isNew) {
			Object[] args = new Object[] {
					fileInfoModelImpl.getCompanyId(),
					fileInfoModelImpl.getRepositoryId(),
					fileInfoModelImpl.getPath(), fileInfoModelImpl.getVersion()
				};

			finderCache.putResult(FINDER_PATH_COUNT_BY_C_R_P_V, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_C_R_P_V, args,
				fileInfoModelImpl);
		}
		else {
			if ((fileInfoModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_C_R_P_V.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						fileInfoModelImpl.getCompanyId(),
						fileInfoModelImpl.getRepositoryId(),
						fileInfoModelImpl.getPath(),
						fileInfoModelImpl.getVersion()
					};

				finderCache.putResult(FINDER_PATH_COUNT_BY_C_R_P_V, args,
					Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_C_R_P_V, args,
					fileInfoModelImpl);
			}
		}
	}

	protected void clearUniqueFindersCache(FileInfoModelImpl fileInfoModelImpl) {
		Object[] args = new Object[] {
				fileInfoModelImpl.getCompanyId(),
				fileInfoModelImpl.getRepositoryId(), fileInfoModelImpl.getPath(),
				fileInfoModelImpl.getVersion()
			};

		finderCache.removeResult(FINDER_PATH_COUNT_BY_C_R_P_V, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_C_R_P_V, args);

		if ((fileInfoModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_C_R_P_V.getColumnBitmask()) != 0) {
			args = new Object[] {
					fileInfoModelImpl.getOriginalCompanyId(),
					fileInfoModelImpl.getOriginalRepositoryId(),
					fileInfoModelImpl.getOriginalPath(),
					fileInfoModelImpl.getOriginalVersion()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_C_R_P_V, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_C_R_P_V, args);
		}
	}

	/**
	 * Creates a new file info with the primary key. Does not add the file info to the database.
	 *
	 * @param fileInfoId the primary key for the new file info
	 * @return the new file info
	 */
	@Override
	public FileInfo create(long fileInfoId) {
		FileInfo fileInfo = new FileInfoImpl();

		fileInfo.setNew(true);
		fileInfo.setPrimaryKey(fileInfoId);

		fileInfo.setCompanyId(companyProvider.getCompanyId());

		return fileInfo;
	}

	/**
	 * Removes the file info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fileInfoId the primary key of the file info
	 * @return the file info that was removed
	 * @throws NoSuchFileInfoException if a file info with the primary key could not be found
	 */
	@Override
	public FileInfo remove(long fileInfoId) throws NoSuchFileInfoException {
		return remove((Serializable)fileInfoId);
	}

	/**
	 * Removes the file info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the file info
	 * @return the file info that was removed
	 * @throws NoSuchFileInfoException if a file info with the primary key could not be found
	 */
	@Override
	public FileInfo remove(Serializable primaryKey)
		throws NoSuchFileInfoException {
		Session session = null;

		try {
			session = openSession();

			FileInfo fileInfo = (FileInfo)session.get(FileInfoImpl.class,
					primaryKey);

			if (fileInfo == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFileInfoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(fileInfo);
		}
		catch (NoSuchFileInfoException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected FileInfo removeImpl(FileInfo fileInfo) {
		fileInfo = toUnwrappedModel(fileInfo);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(fileInfo)) {
				fileInfo = (FileInfo)session.get(FileInfoImpl.class,
						fileInfo.getPrimaryKeyObj());
			}

			if (fileInfo != null) {
				session.delete(fileInfo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (fileInfo != null) {
			clearCache(fileInfo);
		}

		return fileInfo;
	}

	@Override
	public FileInfo updateImpl(FileInfo fileInfo) {
		fileInfo = toUnwrappedModel(fileInfo);

		boolean isNew = fileInfo.isNew();

		FileInfoModelImpl fileInfoModelImpl = (FileInfoModelImpl)fileInfo;

		Session session = null;

		try {
			session = openSession();

			if (fileInfo.isNew()) {
				session.save(fileInfo);

				fileInfo.setNew(false);
			}
			else {
				fileInfo = (FileInfo)session.merge(fileInfo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !FileInfoModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((fileInfoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_R.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						fileInfoModelImpl.getOriginalCompanyId(),
						fileInfoModelImpl.getOriginalRepositoryId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_C_R, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_R,
					args);

				args = new Object[] {
						fileInfoModelImpl.getCompanyId(),
						fileInfoModelImpl.getRepositoryId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_C_R, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_R,
					args);
			}

			if ((fileInfoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_R_P.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						fileInfoModelImpl.getOriginalCompanyId(),
						fileInfoModelImpl.getOriginalRepositoryId(),
						fileInfoModelImpl.getOriginalPath()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_C_R_P, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_R_P,
					args);

				args = new Object[] {
						fileInfoModelImpl.getCompanyId(),
						fileInfoModelImpl.getRepositoryId(),
						fileInfoModelImpl.getPath()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_C_R_P, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_R_P,
					args);
			}

			if ((fileInfoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FILEDATA.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						fileInfoModelImpl.getOriginalFileDataId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_FILEDATA, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FILEDATA,
					args);

				args = new Object[] { fileInfoModelImpl.getFileDataId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_FILEDATA, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FILEDATA,
					args);
			}
		}

		entityCache.putResult(FileInfoModelImpl.ENTITY_CACHE_ENABLED,
			FileInfoImpl.class, fileInfo.getPrimaryKey(), fileInfo, false);

		clearUniqueFindersCache(fileInfoModelImpl);
		cacheUniqueFindersCache(fileInfoModelImpl, isNew);

		fileInfo.resetOriginalValues();

		return fileInfo;
	}

	protected FileInfo toUnwrappedModel(FileInfo fileInfo) {
		if (fileInfo instanceof FileInfoImpl) {
			return fileInfo;
		}

		FileInfoImpl fileInfoImpl = new FileInfoImpl();

		fileInfoImpl.setNew(fileInfo.isNew());
		fileInfoImpl.setPrimaryKey(fileInfo.getPrimaryKey());

		fileInfoImpl.setFileInfoId(fileInfo.getFileInfoId());
		fileInfoImpl.setCompanyId(fileInfo.getCompanyId());
		fileInfoImpl.setRepositoryId(fileInfo.getRepositoryId());
		fileInfoImpl.setPath(fileInfo.getPath());
		fileInfoImpl.setVersion(fileInfo.getVersion());
		fileInfoImpl.setFileDataId(fileInfo.getFileDataId());

		return fileInfoImpl;
	}

	/**
	 * Returns the file info with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the file info
	 * @return the file info
	 * @throws NoSuchFileInfoException if a file info with the primary key could not be found
	 */
	@Override
	public FileInfo findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFileInfoException {
		FileInfo fileInfo = fetchByPrimaryKey(primaryKey);

		if (fileInfo == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFileInfoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return fileInfo;
	}

	/**
	 * Returns the file info with the primary key or throws a {@link NoSuchFileInfoException} if it could not be found.
	 *
	 * @param fileInfoId the primary key of the file info
	 * @return the file info
	 * @throws NoSuchFileInfoException if a file info with the primary key could not be found
	 */
	@Override
	public FileInfo findByPrimaryKey(long fileInfoId)
		throws NoSuchFileInfoException {
		return findByPrimaryKey((Serializable)fileInfoId);
	}

	/**
	 * Returns the file info with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the file info
	 * @return the file info, or <code>null</code> if a file info with the primary key could not be found
	 */
	@Override
	public FileInfo fetchByPrimaryKey(Serializable primaryKey) {
		FileInfo fileInfo = (FileInfo)entityCache.getResult(FileInfoModelImpl.ENTITY_CACHE_ENABLED,
				FileInfoImpl.class, primaryKey);

		if (fileInfo == _nullFileInfo) {
			return null;
		}

		if (fileInfo == null) {
			Session session = null;

			try {
				session = openSession();

				fileInfo = (FileInfo)session.get(FileInfoImpl.class, primaryKey);

				if (fileInfo != null) {
					cacheResult(fileInfo);
				}
				else {
					entityCache.putResult(FileInfoModelImpl.ENTITY_CACHE_ENABLED,
						FileInfoImpl.class, primaryKey, _nullFileInfo);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(FileInfoModelImpl.ENTITY_CACHE_ENABLED,
					FileInfoImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return fileInfo;
	}

	/**
	 * Returns the file info with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fileInfoId the primary key of the file info
	 * @return the file info, or <code>null</code> if a file info with the primary key could not be found
	 */
	@Override
	public FileInfo fetchByPrimaryKey(long fileInfoId) {
		return fetchByPrimaryKey((Serializable)fileInfoId);
	}

	@Override
	public Map<Serializable, FileInfo> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, FileInfo> map = new HashMap<Serializable, FileInfo>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			FileInfo fileInfo = fetchByPrimaryKey(primaryKey);

			if (fileInfo != null) {
				map.put(primaryKey, fileInfo);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			FileInfo fileInfo = (FileInfo)entityCache.getResult(FileInfoModelImpl.ENTITY_CACHE_ENABLED,
					FileInfoImpl.class, primaryKey);

			if (fileInfo == null) {
				if (uncachedPrimaryKeys == null) {
					uncachedPrimaryKeys = new HashSet<Serializable>();
				}

				uncachedPrimaryKeys.add(primaryKey);
			}
			else {
				map.put(primaryKey, fileInfo);
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_FILEINFO_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append(String.valueOf(primaryKey));

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (FileInfo fileInfo : (List<FileInfo>)q.list()) {
				map.put(fileInfo.getPrimaryKeyObj(), fileInfo);

				cacheResult(fileInfo);

				uncachedPrimaryKeys.remove(fileInfo.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(FileInfoModelImpl.ENTITY_CACHE_ENABLED,
					FileInfoImpl.class, primaryKey, _nullFileInfo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the file infos.
	 *
	 * @return the file infos
	 */
	@Override
	public List<FileInfo> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the file infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FileInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of file infos
	 * @param end the upper bound of the range of file infos (not inclusive)
	 * @return the range of file infos
	 */
	@Override
	public List<FileInfo> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the file infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FileInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of file infos
	 * @param end the upper bound of the range of file infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of file infos
	 */
	@Override
	public List<FileInfo> findAll(int start, int end,
		OrderByComparator<FileInfo> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the file infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FileInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of file infos
	 * @param end the upper bound of the range of file infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of file infos
	 */
	@Override
	public List<FileInfo> findAll(int start, int end,
		OrderByComparator<FileInfo> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<FileInfo> list = null;

		if (retrieveFromCache) {
			list = (List<FileInfo>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_FILEINFO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FILEINFO;

				if (pagination) {
					sql = sql.concat(FileInfoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<FileInfo>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<FileInfo>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the file infos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (FileInfo fileInfo : findAll()) {
			remove(fileInfo);
		}
	}

	/**
	 * Returns the number of file infos.
	 *
	 * @return the number of file infos
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_FILEINFO);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
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
	protected Map<String, Integer> getTableColumnsMap() {
		return FileInfoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the file info persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(FileInfoImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_FILEINFO = "SELECT fileInfo FROM FileInfo fileInfo";
	private static final String _SQL_SELECT_FILEINFO_WHERE_PKS_IN = "SELECT fileInfo FROM FileInfo fileInfo WHERE fileInfoId IN (";
	private static final String _SQL_SELECT_FILEINFO_WHERE = "SELECT fileInfo FROM FileInfo fileInfo WHERE ";
	private static final String _SQL_COUNT_FILEINFO = "SELECT COUNT(fileInfo) FROM FileInfo fileInfo";
	private static final String _SQL_COUNT_FILEINFO_WHERE = "SELECT COUNT(fileInfo) FROM FileInfo fileInfo WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "fileInfo.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No FileInfo exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No FileInfo exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(FileInfoPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"path"
			});
	private static final FileInfo _nullFileInfo = new FileInfoImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<FileInfo> toCacheModel() {
				return _nullFileInfoCacheModel;
			}
		};

	private static final CacheModel<FileInfo> _nullFileInfoCacheModel = new CacheModel<FileInfo>() {
			@Override
			public FileInfo toEntityModel() {
				return _nullFileInfo;
			}
		};
}