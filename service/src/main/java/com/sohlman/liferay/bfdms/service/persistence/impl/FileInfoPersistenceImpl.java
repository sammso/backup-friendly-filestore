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
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;

import com.sohlman.liferay.bfdms.exception.NoSuchFileInfoException;
import com.sohlman.liferay.bfdms.model.FileInfo;
import com.sohlman.liferay.bfdms.model.FileInfoTable;
import com.sohlman.liferay.bfdms.model.impl.FileInfoImpl;
import com.sohlman.liferay.bfdms.model.impl.FileInfoModelImpl;
import com.sohlman.liferay.bfdms.service.persistence.FileInfoPersistence;
import com.sohlman.liferay.bfdms.service.persistence.FileInfoUtil;
import com.sohlman.liferay.bfdms.service.persistence.impl.constants.bfdmsPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

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
 * The persistence implementation for the file info service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = FileInfoPersistence.class)
public class FileInfoPersistenceImpl
	extends BasePersistenceImpl<FileInfo> implements FileInfoPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>FileInfoUtil</code> to access the file info persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		FileInfoImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByC_R;
	private FinderPath _finderPathWithoutPaginationFindByC_R;
	private FinderPath _finderPathCountByC_R;

	/**
	 * Returns all the file infos where companyId = &#63; and repositoryId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 * @return the matching file infos
	 */
	@Override
	public List<FileInfo> findByC_R(long companyId, long repositoryId) {
		return findByC_R(
			companyId, repositoryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the file infos where companyId = &#63; and repositoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileInfoModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 * @param start the lower bound of the range of file infos
	 * @param end the upper bound of the range of file infos (not inclusive)
	 * @return the range of matching file infos
	 */
	@Override
	public List<FileInfo> findByC_R(
		long companyId, long repositoryId, int start, int end) {

		return findByC_R(companyId, repositoryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the file infos where companyId = &#63; and repositoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileInfoModelImpl</code>.
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
	public List<FileInfo> findByC_R(
		long companyId, long repositoryId, int start, int end,
		OrderByComparator<FileInfo> orderByComparator) {

		return findByC_R(
			companyId, repositoryId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the file infos where companyId = &#63; and repositoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileInfoModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 * @param start the lower bound of the range of file infos
	 * @param end the upper bound of the range of file infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching file infos
	 */
	@Override
	public List<FileInfo> findByC_R(
		long companyId, long repositoryId, int start, int end,
		OrderByComparator<FileInfo> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByC_R;
				finderArgs = new Object[] {companyId, repositoryId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByC_R;
			finderArgs = new Object[] {
				companyId, repositoryId, start, end, orderByComparator
			};
		}

		List<FileInfo> list = null;

		if (useFinderCache) {
			list = (List<FileInfo>)finderCache.getResult(
				finderPath, finderArgs, this);

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
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_FILEINFO_WHERE);

			sb.append(_FINDER_COLUMN_C_R_COMPANYID_2);

			sb.append(_FINDER_COLUMN_C_R_REPOSITORYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(FileInfoModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				queryPos.add(repositoryId);

				list = (List<FileInfo>)QueryUtil.list(
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
	 * Returns the first file info in the ordered set where companyId = &#63; and repositoryId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file info
	 * @throws NoSuchFileInfoException if a matching file info could not be found
	 */
	@Override
	public FileInfo findByC_R_First(
			long companyId, long repositoryId,
			OrderByComparator<FileInfo> orderByComparator)
		throws NoSuchFileInfoException {

		FileInfo fileInfo = fetchByC_R_First(
			companyId, repositoryId, orderByComparator);

		if (fileInfo != null) {
			return fileInfo;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append(", repositoryId=");
		sb.append(repositoryId);

		sb.append("}");

		throw new NoSuchFileInfoException(sb.toString());
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
	public FileInfo fetchByC_R_First(
		long companyId, long repositoryId,
		OrderByComparator<FileInfo> orderByComparator) {

		List<FileInfo> list = findByC_R(
			companyId, repositoryId, 0, 1, orderByComparator);

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
	public FileInfo findByC_R_Last(
			long companyId, long repositoryId,
			OrderByComparator<FileInfo> orderByComparator)
		throws NoSuchFileInfoException {

		FileInfo fileInfo = fetchByC_R_Last(
			companyId, repositoryId, orderByComparator);

		if (fileInfo != null) {
			return fileInfo;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append(", repositoryId=");
		sb.append(repositoryId);

		sb.append("}");

		throw new NoSuchFileInfoException(sb.toString());
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
	public FileInfo fetchByC_R_Last(
		long companyId, long repositoryId,
		OrderByComparator<FileInfo> orderByComparator) {

		int count = countByC_R(companyId, repositoryId);

		if (count == 0) {
			return null;
		}

		List<FileInfo> list = findByC_R(
			companyId, repositoryId, count - 1, count, orderByComparator);

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
	public FileInfo[] findByC_R_PrevAndNext(
			long fileInfoId, long companyId, long repositoryId,
			OrderByComparator<FileInfo> orderByComparator)
		throws NoSuchFileInfoException {

		FileInfo fileInfo = findByPrimaryKey(fileInfoId);

		Session session = null;

		try {
			session = openSession();

			FileInfo[] array = new FileInfoImpl[3];

			array[0] = getByC_R_PrevAndNext(
				session, fileInfo, companyId, repositoryId, orderByComparator,
				true);

			array[1] = fileInfo;

			array[2] = getByC_R_PrevAndNext(
				session, fileInfo, companyId, repositoryId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected FileInfo getByC_R_PrevAndNext(
		Session session, FileInfo fileInfo, long companyId, long repositoryId,
		OrderByComparator<FileInfo> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_FILEINFO_WHERE);

		sb.append(_FINDER_COLUMN_C_R_COMPANYID_2);

		sb.append(_FINDER_COLUMN_C_R_REPOSITORYID_2);

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
			sb.append(FileInfoModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(companyId);

		queryPos.add(repositoryId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(fileInfo)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FileInfo> list = query.list();

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
		for (FileInfo fileInfo :
				findByC_R(
					companyId, repositoryId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

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
		FinderPath finderPath = _finderPathCountByC_R;

		Object[] finderArgs = new Object[] {companyId, repositoryId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_FILEINFO_WHERE);

			sb.append(_FINDER_COLUMN_C_R_COMPANYID_2);

			sb.append(_FINDER_COLUMN_C_R_REPOSITORYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				queryPos.add(repositoryId);

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

	private static final String _FINDER_COLUMN_C_R_COMPANYID_2 =
		"fileInfo.companyId = ? AND ";

	private static final String _FINDER_COLUMN_C_R_REPOSITORYID_2 =
		"fileInfo.repositoryId = ?";

	private FinderPath _finderPathWithPaginationFindByC_R_P;
	private FinderPath _finderPathWithoutPaginationFindByC_R_P;
	private FinderPath _finderPathCountByC_R_P;

	/**
	 * Returns all the file infos where companyId = &#63; and repositoryId = &#63; and path = &#63;.
	 *
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 * @param path the path
	 * @return the matching file infos
	 */
	@Override
	public List<FileInfo> findByC_R_P(
		long companyId, long repositoryId, String path) {

		return findByC_R_P(
			companyId, repositoryId, path, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the file infos where companyId = &#63; and repositoryId = &#63; and path = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileInfoModelImpl</code>.
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
	public List<FileInfo> findByC_R_P(
		long companyId, long repositoryId, String path, int start, int end) {

		return findByC_R_P(companyId, repositoryId, path, start, end, null);
	}

	/**
	 * Returns an ordered range of all the file infos where companyId = &#63; and repositoryId = &#63; and path = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileInfoModelImpl</code>.
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
	public List<FileInfo> findByC_R_P(
		long companyId, long repositoryId, String path, int start, int end,
		OrderByComparator<FileInfo> orderByComparator) {

		return findByC_R_P(
			companyId, repositoryId, path, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the file infos where companyId = &#63; and repositoryId = &#63; and path = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileInfoModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 * @param path the path
	 * @param start the lower bound of the range of file infos
	 * @param end the upper bound of the range of file infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching file infos
	 */
	@Override
	public List<FileInfo> findByC_R_P(
		long companyId, long repositoryId, String path, int start, int end,
		OrderByComparator<FileInfo> orderByComparator, boolean useFinderCache) {

		path = Objects.toString(path, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByC_R_P;
				finderArgs = new Object[] {companyId, repositoryId, path};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByC_R_P;
			finderArgs = new Object[] {
				companyId, repositoryId, path, start, end, orderByComparator
			};
		}

		List<FileInfo> list = null;

		if (useFinderCache) {
			list = (List<FileInfo>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (FileInfo fileInfo : list) {
					if ((companyId != fileInfo.getCompanyId()) ||
						(repositoryId != fileInfo.getRepositoryId()) ||
						!path.equals(fileInfo.getPath())) {

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
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(5);
			}

			sb.append(_SQL_SELECT_FILEINFO_WHERE);

			sb.append(_FINDER_COLUMN_C_R_P_COMPANYID_2);

			sb.append(_FINDER_COLUMN_C_R_P_REPOSITORYID_2);

			boolean bindPath = false;

			if (path.isEmpty()) {
				sb.append(_FINDER_COLUMN_C_R_P_PATH_3);
			}
			else {
				bindPath = true;

				sb.append(_FINDER_COLUMN_C_R_P_PATH_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(FileInfoModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				queryPos.add(repositoryId);

				if (bindPath) {
					queryPos.add(path);
				}

				list = (List<FileInfo>)QueryUtil.list(
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
	public FileInfo findByC_R_P_First(
			long companyId, long repositoryId, String path,
			OrderByComparator<FileInfo> orderByComparator)
		throws NoSuchFileInfoException {

		FileInfo fileInfo = fetchByC_R_P_First(
			companyId, repositoryId, path, orderByComparator);

		if (fileInfo != null) {
			return fileInfo;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append(", repositoryId=");
		sb.append(repositoryId);

		sb.append(", path=");
		sb.append(path);

		sb.append("}");

		throw new NoSuchFileInfoException(sb.toString());
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
	public FileInfo fetchByC_R_P_First(
		long companyId, long repositoryId, String path,
		OrderByComparator<FileInfo> orderByComparator) {

		List<FileInfo> list = findByC_R_P(
			companyId, repositoryId, path, 0, 1, orderByComparator);

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
	public FileInfo findByC_R_P_Last(
			long companyId, long repositoryId, String path,
			OrderByComparator<FileInfo> orderByComparator)
		throws NoSuchFileInfoException {

		FileInfo fileInfo = fetchByC_R_P_Last(
			companyId, repositoryId, path, orderByComparator);

		if (fileInfo != null) {
			return fileInfo;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append(", repositoryId=");
		sb.append(repositoryId);

		sb.append(", path=");
		sb.append(path);

		sb.append("}");

		throw new NoSuchFileInfoException(sb.toString());
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
	public FileInfo fetchByC_R_P_Last(
		long companyId, long repositoryId, String path,
		OrderByComparator<FileInfo> orderByComparator) {

		int count = countByC_R_P(companyId, repositoryId, path);

		if (count == 0) {
			return null;
		}

		List<FileInfo> list = findByC_R_P(
			companyId, repositoryId, path, count - 1, count, orderByComparator);

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
	public FileInfo[] findByC_R_P_PrevAndNext(
			long fileInfoId, long companyId, long repositoryId, String path,
			OrderByComparator<FileInfo> orderByComparator)
		throws NoSuchFileInfoException {

		path = Objects.toString(path, "");

		FileInfo fileInfo = findByPrimaryKey(fileInfoId);

		Session session = null;

		try {
			session = openSession();

			FileInfo[] array = new FileInfoImpl[3];

			array[0] = getByC_R_P_PrevAndNext(
				session, fileInfo, companyId, repositoryId, path,
				orderByComparator, true);

			array[1] = fileInfo;

			array[2] = getByC_R_P_PrevAndNext(
				session, fileInfo, companyId, repositoryId, path,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected FileInfo getByC_R_P_PrevAndNext(
		Session session, FileInfo fileInfo, long companyId, long repositoryId,
		String path, OrderByComparator<FileInfo> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		sb.append(_SQL_SELECT_FILEINFO_WHERE);

		sb.append(_FINDER_COLUMN_C_R_P_COMPANYID_2);

		sb.append(_FINDER_COLUMN_C_R_P_REPOSITORYID_2);

		boolean bindPath = false;

		if (path.isEmpty()) {
			sb.append(_FINDER_COLUMN_C_R_P_PATH_3);
		}
		else {
			bindPath = true;

			sb.append(_FINDER_COLUMN_C_R_P_PATH_2);
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
			sb.append(FileInfoModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(companyId);

		queryPos.add(repositoryId);

		if (bindPath) {
			queryPos.add(path);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(fileInfo)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FileInfo> list = query.list();

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
		for (FileInfo fileInfo :
				findByC_R_P(
					companyId, repositoryId, path, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

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
		path = Objects.toString(path, "");

		FinderPath finderPath = _finderPathCountByC_R_P;

		Object[] finderArgs = new Object[] {companyId, repositoryId, path};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_FILEINFO_WHERE);

			sb.append(_FINDER_COLUMN_C_R_P_COMPANYID_2);

			sb.append(_FINDER_COLUMN_C_R_P_REPOSITORYID_2);

			boolean bindPath = false;

			if (path.isEmpty()) {
				sb.append(_FINDER_COLUMN_C_R_P_PATH_3);
			}
			else {
				bindPath = true;

				sb.append(_FINDER_COLUMN_C_R_P_PATH_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				queryPos.add(repositoryId);

				if (bindPath) {
					queryPos.add(path);
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

	private static final String _FINDER_COLUMN_C_R_P_COMPANYID_2 =
		"fileInfo.companyId = ? AND ";

	private static final String _FINDER_COLUMN_C_R_P_REPOSITORYID_2 =
		"fileInfo.repositoryId = ? AND ";

	private static final String _FINDER_COLUMN_C_R_P_PATH_2 =
		"fileInfo.path = ?";

	private static final String _FINDER_COLUMN_C_R_P_PATH_3 =
		"(fileInfo.path IS NULL OR fileInfo.path = '')";

	private FinderPath _finderPathWithPaginationFindByC_R_LikeP;
	private FinderPath _finderPathWithPaginationCountByC_R_LikeP;

	/**
	 * Returns all the file infos where companyId = &#63; and repositoryId = &#63; and path LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 * @param path the path
	 * @return the matching file infos
	 */
	@Override
	public List<FileInfo> findByC_R_LikeP(
		long companyId, long repositoryId, String path) {

		return findByC_R_LikeP(
			companyId, repositoryId, path, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the file infos where companyId = &#63; and repositoryId = &#63; and path LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileInfoModelImpl</code>.
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
	public List<FileInfo> findByC_R_LikeP(
		long companyId, long repositoryId, String path, int start, int end) {

		return findByC_R_LikeP(companyId, repositoryId, path, start, end, null);
	}

	/**
	 * Returns an ordered range of all the file infos where companyId = &#63; and repositoryId = &#63; and path LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileInfoModelImpl</code>.
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
	public List<FileInfo> findByC_R_LikeP(
		long companyId, long repositoryId, String path, int start, int end,
		OrderByComparator<FileInfo> orderByComparator) {

		return findByC_R_LikeP(
			companyId, repositoryId, path, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the file infos where companyId = &#63; and repositoryId = &#63; and path LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileInfoModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 * @param path the path
	 * @param start the lower bound of the range of file infos
	 * @param end the upper bound of the range of file infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching file infos
	 */
	@Override
	public List<FileInfo> findByC_R_LikeP(
		long companyId, long repositoryId, String path, int start, int end,
		OrderByComparator<FileInfo> orderByComparator, boolean useFinderCache) {

		path = Objects.toString(path, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = _finderPathWithPaginationFindByC_R_LikeP;
		finderArgs = new Object[] {
			companyId, repositoryId, path, start, end, orderByComparator
		};

		List<FileInfo> list = null;

		if (useFinderCache) {
			list = (List<FileInfo>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (FileInfo fileInfo : list) {
					if ((companyId != fileInfo.getCompanyId()) ||
						(repositoryId != fileInfo.getRepositoryId()) ||
						!StringUtil.wildcardMatches(
							fileInfo.getPath(), path, '_', '%', '\\', true)) {

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
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(5);
			}

			sb.append(_SQL_SELECT_FILEINFO_WHERE);

			sb.append(_FINDER_COLUMN_C_R_LIKEP_COMPANYID_2);

			sb.append(_FINDER_COLUMN_C_R_LIKEP_REPOSITORYID_2);

			boolean bindPath = false;

			if (path.isEmpty()) {
				sb.append(_FINDER_COLUMN_C_R_LIKEP_PATH_3);
			}
			else {
				bindPath = true;

				sb.append(_FINDER_COLUMN_C_R_LIKEP_PATH_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(FileInfoModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				queryPos.add(repositoryId);

				if (bindPath) {
					queryPos.add(path);
				}

				list = (List<FileInfo>)QueryUtil.list(
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
	public FileInfo findByC_R_LikeP_First(
			long companyId, long repositoryId, String path,
			OrderByComparator<FileInfo> orderByComparator)
		throws NoSuchFileInfoException {

		FileInfo fileInfo = fetchByC_R_LikeP_First(
			companyId, repositoryId, path, orderByComparator);

		if (fileInfo != null) {
			return fileInfo;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append(", repositoryId=");
		sb.append(repositoryId);

		sb.append(", pathLIKE");
		sb.append(path);

		sb.append("}");

		throw new NoSuchFileInfoException(sb.toString());
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
	public FileInfo fetchByC_R_LikeP_First(
		long companyId, long repositoryId, String path,
		OrderByComparator<FileInfo> orderByComparator) {

		List<FileInfo> list = findByC_R_LikeP(
			companyId, repositoryId, path, 0, 1, orderByComparator);

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
	public FileInfo findByC_R_LikeP_Last(
			long companyId, long repositoryId, String path,
			OrderByComparator<FileInfo> orderByComparator)
		throws NoSuchFileInfoException {

		FileInfo fileInfo = fetchByC_R_LikeP_Last(
			companyId, repositoryId, path, orderByComparator);

		if (fileInfo != null) {
			return fileInfo;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append(", repositoryId=");
		sb.append(repositoryId);

		sb.append(", pathLIKE");
		sb.append(path);

		sb.append("}");

		throw new NoSuchFileInfoException(sb.toString());
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
	public FileInfo fetchByC_R_LikeP_Last(
		long companyId, long repositoryId, String path,
		OrderByComparator<FileInfo> orderByComparator) {

		int count = countByC_R_LikeP(companyId, repositoryId, path);

		if (count == 0) {
			return null;
		}

		List<FileInfo> list = findByC_R_LikeP(
			companyId, repositoryId, path, count - 1, count, orderByComparator);

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
	public FileInfo[] findByC_R_LikeP_PrevAndNext(
			long fileInfoId, long companyId, long repositoryId, String path,
			OrderByComparator<FileInfo> orderByComparator)
		throws NoSuchFileInfoException {

		path = Objects.toString(path, "");

		FileInfo fileInfo = findByPrimaryKey(fileInfoId);

		Session session = null;

		try {
			session = openSession();

			FileInfo[] array = new FileInfoImpl[3];

			array[0] = getByC_R_LikeP_PrevAndNext(
				session, fileInfo, companyId, repositoryId, path,
				orderByComparator, true);

			array[1] = fileInfo;

			array[2] = getByC_R_LikeP_PrevAndNext(
				session, fileInfo, companyId, repositoryId, path,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected FileInfo getByC_R_LikeP_PrevAndNext(
		Session session, FileInfo fileInfo, long companyId, long repositoryId,
		String path, OrderByComparator<FileInfo> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		sb.append(_SQL_SELECT_FILEINFO_WHERE);

		sb.append(_FINDER_COLUMN_C_R_LIKEP_COMPANYID_2);

		sb.append(_FINDER_COLUMN_C_R_LIKEP_REPOSITORYID_2);

		boolean bindPath = false;

		if (path.isEmpty()) {
			sb.append(_FINDER_COLUMN_C_R_LIKEP_PATH_3);
		}
		else {
			bindPath = true;

			sb.append(_FINDER_COLUMN_C_R_LIKEP_PATH_2);
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
			sb.append(FileInfoModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(companyId);

		queryPos.add(repositoryId);

		if (bindPath) {
			queryPos.add(path);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(fileInfo)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FileInfo> list = query.list();

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
	public void removeByC_R_LikeP(
		long companyId, long repositoryId, String path) {

		for (FileInfo fileInfo :
				findByC_R_LikeP(
					companyId, repositoryId, path, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

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
	public int countByC_R_LikeP(
		long companyId, long repositoryId, String path) {

		path = Objects.toString(path, "");

		FinderPath finderPath = _finderPathWithPaginationCountByC_R_LikeP;

		Object[] finderArgs = new Object[] {companyId, repositoryId, path};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_FILEINFO_WHERE);

			sb.append(_FINDER_COLUMN_C_R_LIKEP_COMPANYID_2);

			sb.append(_FINDER_COLUMN_C_R_LIKEP_REPOSITORYID_2);

			boolean bindPath = false;

			if (path.isEmpty()) {
				sb.append(_FINDER_COLUMN_C_R_LIKEP_PATH_3);
			}
			else {
				bindPath = true;

				sb.append(_FINDER_COLUMN_C_R_LIKEP_PATH_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				queryPos.add(repositoryId);

				if (bindPath) {
					queryPos.add(path);
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

	private static final String _FINDER_COLUMN_C_R_LIKEP_COMPANYID_2 =
		"fileInfo.companyId = ? AND ";

	private static final String _FINDER_COLUMN_C_R_LIKEP_REPOSITORYID_2 =
		"fileInfo.repositoryId = ? AND ";

	private static final String _FINDER_COLUMN_C_R_LIKEP_PATH_2 =
		"fileInfo.path LIKE ?";

	private static final String _FINDER_COLUMN_C_R_LIKEP_PATH_3 =
		"(fileInfo.path IS NULL OR fileInfo.path LIKE '')";

	private FinderPath _finderPathFetchByC_R_P_V;

	/**
	 * Returns the file info where companyId = &#63; and repositoryId = &#63; and path = &#63; and version = &#63; or throws a <code>NoSuchFileInfoException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 * @param path the path
	 * @param version the version
	 * @return the matching file info
	 * @throws NoSuchFileInfoException if a matching file info could not be found
	 */
	@Override
	public FileInfo findByC_R_P_V(
			long companyId, long repositoryId, String path, String version)
		throws NoSuchFileInfoException {

		FileInfo fileInfo = fetchByC_R_P_V(
			companyId, repositoryId, path, version);

		if (fileInfo == null) {
			StringBundler sb = new StringBundler(10);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("companyId=");
			sb.append(companyId);

			sb.append(", repositoryId=");
			sb.append(repositoryId);

			sb.append(", path=");
			sb.append(path);

			sb.append(", version=");
			sb.append(version);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchFileInfoException(sb.toString());
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
	public FileInfo fetchByC_R_P_V(
		long companyId, long repositoryId, String path, String version) {

		return fetchByC_R_P_V(companyId, repositoryId, path, version, true);
	}

	/**
	 * Returns the file info where companyId = &#63; and repositoryId = &#63; and path = &#63; and version = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 * @param path the path
	 * @param version the version
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching file info, or <code>null</code> if a matching file info could not be found
	 */
	@Override
	public FileInfo fetchByC_R_P_V(
		long companyId, long repositoryId, String path, String version,
		boolean useFinderCache) {

		path = Objects.toString(path, "");
		version = Objects.toString(version, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {companyId, repositoryId, path, version};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByC_R_P_V, finderArgs, this);
		}

		if (result instanceof FileInfo) {
			FileInfo fileInfo = (FileInfo)result;

			if ((companyId != fileInfo.getCompanyId()) ||
				(repositoryId != fileInfo.getRepositoryId()) ||
				!Objects.equals(path, fileInfo.getPath()) ||
				!Objects.equals(version, fileInfo.getVersion())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_SQL_SELECT_FILEINFO_WHERE);

			sb.append(_FINDER_COLUMN_C_R_P_V_COMPANYID_2);

			sb.append(_FINDER_COLUMN_C_R_P_V_REPOSITORYID_2);

			boolean bindPath = false;

			if (path.isEmpty()) {
				sb.append(_FINDER_COLUMN_C_R_P_V_PATH_3);
			}
			else {
				bindPath = true;

				sb.append(_FINDER_COLUMN_C_R_P_V_PATH_2);
			}

			boolean bindVersion = false;

			if (version.isEmpty()) {
				sb.append(_FINDER_COLUMN_C_R_P_V_VERSION_3);
			}
			else {
				bindVersion = true;

				sb.append(_FINDER_COLUMN_C_R_P_V_VERSION_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				queryPos.add(repositoryId);

				if (bindPath) {
					queryPos.add(path);
				}

				if (bindVersion) {
					queryPos.add(version);
				}

				List<FileInfo> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByC_R_P_V, finderArgs, list);
					}
				}
				else {
					FileInfo fileInfo = list.get(0);

					result = fileInfo;

					cacheResult(fileInfo);
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
	public FileInfo removeByC_R_P_V(
			long companyId, long repositoryId, String path, String version)
		throws NoSuchFileInfoException {

		FileInfo fileInfo = findByC_R_P_V(
			companyId, repositoryId, path, version);

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
	public int countByC_R_P_V(
		long companyId, long repositoryId, String path, String version) {

		FileInfo fileInfo = fetchByC_R_P_V(
			companyId, repositoryId, path, version);

		if (fileInfo == null) {
			return 0;
		}

		return 1;
	}

	private static final String _FINDER_COLUMN_C_R_P_V_COMPANYID_2 =
		"fileInfo.companyId = ? AND ";

	private static final String _FINDER_COLUMN_C_R_P_V_REPOSITORYID_2 =
		"fileInfo.repositoryId = ? AND ";

	private static final String _FINDER_COLUMN_C_R_P_V_PATH_2 =
		"fileInfo.path = ? AND ";

	private static final String _FINDER_COLUMN_C_R_P_V_PATH_3 =
		"(fileInfo.path IS NULL OR fileInfo.path = '') AND ";

	private static final String _FINDER_COLUMN_C_R_P_V_VERSION_2 =
		"fileInfo.version = ?";

	private static final String _FINDER_COLUMN_C_R_P_V_VERSION_3 =
		"(fileInfo.version IS NULL OR fileInfo.version = '')";

	private FinderPath _finderPathWithPaginationFindByFileData;
	private FinderPath _finderPathWithoutPaginationFindByFileData;
	private FinderPath _finderPathCountByFileData;

	/**
	 * Returns all the file infos where fileDataId = &#63;.
	 *
	 * @param fileDataId the file data ID
	 * @return the matching file infos
	 */
	@Override
	public List<FileInfo> findByFileData(long fileDataId) {
		return findByFileData(
			fileDataId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the file infos where fileDataId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileInfoModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileInfoModelImpl</code>.
	 * </p>
	 *
	 * @param fileDataId the file data ID
	 * @param start the lower bound of the range of file infos
	 * @param end the upper bound of the range of file infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching file infos
	 */
	@Override
	public List<FileInfo> findByFileData(
		long fileDataId, int start, int end,
		OrderByComparator<FileInfo> orderByComparator) {

		return findByFileData(fileDataId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the file infos where fileDataId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileInfoModelImpl</code>.
	 * </p>
	 *
	 * @param fileDataId the file data ID
	 * @param start the lower bound of the range of file infos
	 * @param end the upper bound of the range of file infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching file infos
	 */
	@Override
	public List<FileInfo> findByFileData(
		long fileDataId, int start, int end,
		OrderByComparator<FileInfo> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByFileData;
				finderArgs = new Object[] {fileDataId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByFileData;
			finderArgs = new Object[] {
				fileDataId, start, end, orderByComparator
			};
		}

		List<FileInfo> list = null;

		if (useFinderCache) {
			list = (List<FileInfo>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (FileInfo fileInfo : list) {
					if (fileDataId != fileInfo.getFileDataId()) {
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

			sb.append(_SQL_SELECT_FILEINFO_WHERE);

			sb.append(_FINDER_COLUMN_FILEDATA_FILEDATAID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(FileInfoModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(fileDataId);

				list = (List<FileInfo>)QueryUtil.list(
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
	 * Returns the first file info in the ordered set where fileDataId = &#63;.
	 *
	 * @param fileDataId the file data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file info
	 * @throws NoSuchFileInfoException if a matching file info could not be found
	 */
	@Override
	public FileInfo findByFileData_First(
			long fileDataId, OrderByComparator<FileInfo> orderByComparator)
		throws NoSuchFileInfoException {

		FileInfo fileInfo = fetchByFileData_First(
			fileDataId, orderByComparator);

		if (fileInfo != null) {
			return fileInfo;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("fileDataId=");
		sb.append(fileDataId);

		sb.append("}");

		throw new NoSuchFileInfoException(sb.toString());
	}

	/**
	 * Returns the first file info in the ordered set where fileDataId = &#63;.
	 *
	 * @param fileDataId the file data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file info, or <code>null</code> if a matching file info could not be found
	 */
	@Override
	public FileInfo fetchByFileData_First(
		long fileDataId, OrderByComparator<FileInfo> orderByComparator) {

		List<FileInfo> list = findByFileData(
			fileDataId, 0, 1, orderByComparator);

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
	public FileInfo findByFileData_Last(
			long fileDataId, OrderByComparator<FileInfo> orderByComparator)
		throws NoSuchFileInfoException {

		FileInfo fileInfo = fetchByFileData_Last(fileDataId, orderByComparator);

		if (fileInfo != null) {
			return fileInfo;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("fileDataId=");
		sb.append(fileDataId);

		sb.append("}");

		throw new NoSuchFileInfoException(sb.toString());
	}

	/**
	 * Returns the last file info in the ordered set where fileDataId = &#63;.
	 *
	 * @param fileDataId the file data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file info, or <code>null</code> if a matching file info could not be found
	 */
	@Override
	public FileInfo fetchByFileData_Last(
		long fileDataId, OrderByComparator<FileInfo> orderByComparator) {

		int count = countByFileData(fileDataId);

		if (count == 0) {
			return null;
		}

		List<FileInfo> list = findByFileData(
			fileDataId, count - 1, count, orderByComparator);

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
	public FileInfo[] findByFileData_PrevAndNext(
			long fileInfoId, long fileDataId,
			OrderByComparator<FileInfo> orderByComparator)
		throws NoSuchFileInfoException {

		FileInfo fileInfo = findByPrimaryKey(fileInfoId);

		Session session = null;

		try {
			session = openSession();

			FileInfo[] array = new FileInfoImpl[3];

			array[0] = getByFileData_PrevAndNext(
				session, fileInfo, fileDataId, orderByComparator, true);

			array[1] = fileInfo;

			array[2] = getByFileData_PrevAndNext(
				session, fileInfo, fileDataId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected FileInfo getByFileData_PrevAndNext(
		Session session, FileInfo fileInfo, long fileDataId,
		OrderByComparator<FileInfo> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_FILEINFO_WHERE);

		sb.append(_FINDER_COLUMN_FILEDATA_FILEDATAID_2);

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
			sb.append(FileInfoModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(fileDataId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(fileInfo)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FileInfo> list = query.list();

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
		for (FileInfo fileInfo :
				findByFileData(
					fileDataId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

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
		FinderPath finderPath = _finderPathCountByFileData;

		Object[] finderArgs = new Object[] {fileDataId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FILEINFO_WHERE);

			sb.append(_FINDER_COLUMN_FILEDATA_FILEDATAID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(fileDataId);

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

	private static final String _FINDER_COLUMN_FILEDATA_FILEDATAID_2 =
		"fileInfo.fileDataId = ?";

	private FinderPath _finderPathWithPaginationFindByC;
	private FinderPath _finderPathWithoutPaginationFindByC;
	private FinderPath _finderPathCountByC;

	/**
	 * Returns all the file infos where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching file infos
	 */
	@Override
	public List<FileInfo> findByC(long companyId) {
		return findByC(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the file infos where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileInfoModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of file infos
	 * @param end the upper bound of the range of file infos (not inclusive)
	 * @return the range of matching file infos
	 */
	@Override
	public List<FileInfo> findByC(long companyId, int start, int end) {
		return findByC(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the file infos where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileInfoModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of file infos
	 * @param end the upper bound of the range of file infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching file infos
	 */
	@Override
	public List<FileInfo> findByC(
		long companyId, int start, int end,
		OrderByComparator<FileInfo> orderByComparator) {

		return findByC(companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the file infos where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileInfoModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of file infos
	 * @param end the upper bound of the range of file infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching file infos
	 */
	@Override
	public List<FileInfo> findByC(
		long companyId, int start, int end,
		OrderByComparator<FileInfo> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByC;
				finderArgs = new Object[] {companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByC;
			finderArgs = new Object[] {
				companyId, start, end, orderByComparator
			};
		}

		List<FileInfo> list = null;

		if (useFinderCache) {
			list = (List<FileInfo>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (FileInfo fileInfo : list) {
					if (companyId != fileInfo.getCompanyId()) {
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

			sb.append(_SQL_SELECT_FILEINFO_WHERE);

			sb.append(_FINDER_COLUMN_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(FileInfoModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				list = (List<FileInfo>)QueryUtil.list(
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
	 * Returns the first file info in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file info
	 * @throws NoSuchFileInfoException if a matching file info could not be found
	 */
	@Override
	public FileInfo findByC_First(
			long companyId, OrderByComparator<FileInfo> orderByComparator)
		throws NoSuchFileInfoException {

		FileInfo fileInfo = fetchByC_First(companyId, orderByComparator);

		if (fileInfo != null) {
			return fileInfo;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchFileInfoException(sb.toString());
	}

	/**
	 * Returns the first file info in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file info, or <code>null</code> if a matching file info could not be found
	 */
	@Override
	public FileInfo fetchByC_First(
		long companyId, OrderByComparator<FileInfo> orderByComparator) {

		List<FileInfo> list = findByC(companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last file info in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file info
	 * @throws NoSuchFileInfoException if a matching file info could not be found
	 */
	@Override
	public FileInfo findByC_Last(
			long companyId, OrderByComparator<FileInfo> orderByComparator)
		throws NoSuchFileInfoException {

		FileInfo fileInfo = fetchByC_Last(companyId, orderByComparator);

		if (fileInfo != null) {
			return fileInfo;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchFileInfoException(sb.toString());
	}

	/**
	 * Returns the last file info in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file info, or <code>null</code> if a matching file info could not be found
	 */
	@Override
	public FileInfo fetchByC_Last(
		long companyId, OrderByComparator<FileInfo> orderByComparator) {

		int count = countByC(companyId);

		if (count == 0) {
			return null;
		}

		List<FileInfo> list = findByC(
			companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the file infos before and after the current file info in the ordered set where companyId = &#63;.
	 *
	 * @param fileInfoId the primary key of the current file info
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next file info
	 * @throws NoSuchFileInfoException if a file info with the primary key could not be found
	 */
	@Override
	public FileInfo[] findByC_PrevAndNext(
			long fileInfoId, long companyId,
			OrderByComparator<FileInfo> orderByComparator)
		throws NoSuchFileInfoException {

		FileInfo fileInfo = findByPrimaryKey(fileInfoId);

		Session session = null;

		try {
			session = openSession();

			FileInfo[] array = new FileInfoImpl[3];

			array[0] = getByC_PrevAndNext(
				session, fileInfo, companyId, orderByComparator, true);

			array[1] = fileInfo;

			array[2] = getByC_PrevAndNext(
				session, fileInfo, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected FileInfo getByC_PrevAndNext(
		Session session, FileInfo fileInfo, long companyId,
		OrderByComparator<FileInfo> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_FILEINFO_WHERE);

		sb.append(_FINDER_COLUMN_C_COMPANYID_2);

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
			sb.append(FileInfoModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(fileInfo)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FileInfo> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the file infos where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	@Override
	public void removeByC(long companyId) {
		for (FileInfo fileInfo :
				findByC(
					companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(fileInfo);
		}
	}

	/**
	 * Returns the number of file infos where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching file infos
	 */
	@Override
	public int countByC(long companyId) {
		FinderPath finderPath = _finderPathCountByC;

		Object[] finderArgs = new Object[] {companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FILEINFO_WHERE);

			sb.append(_FINDER_COLUMN_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

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

	private static final String _FINDER_COLUMN_C_COMPANYID_2 =
		"fileInfo.companyId = ?";

	public FileInfoPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("path", "path_");

		setDBColumnNames(dbColumnNames);

		setModelClass(FileInfo.class);

		setModelImplClass(FileInfoImpl.class);
		setModelPKClass(long.class);

		setTable(FileInfoTable.INSTANCE);
	}

	/**
	 * Caches the file info in the entity cache if it is enabled.
	 *
	 * @param fileInfo the file info
	 */
	@Override
	public void cacheResult(FileInfo fileInfo) {
		entityCache.putResult(
			FileInfoImpl.class, fileInfo.getPrimaryKey(), fileInfo);

		finderCache.putResult(
			_finderPathFetchByC_R_P_V,
			new Object[] {
				fileInfo.getCompanyId(), fileInfo.getRepositoryId(),
				fileInfo.getPath(), fileInfo.getVersion()
			},
			fileInfo);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the file infos in the entity cache if it is enabled.
	 *
	 * @param fileInfos the file infos
	 */
	@Override
	public void cacheResult(List<FileInfo> fileInfos) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (fileInfos.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (FileInfo fileInfo : fileInfos) {
			if (entityCache.getResult(
					FileInfoImpl.class, fileInfo.getPrimaryKey()) == null) {

				cacheResult(fileInfo);
			}
		}
	}

	/**
	 * Clears the cache for all file infos.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(FileInfoImpl.class);

		finderCache.clearCache(FileInfoImpl.class);
	}

	/**
	 * Clears the cache for the file info.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FileInfo fileInfo) {
		entityCache.removeResult(FileInfoImpl.class, fileInfo);
	}

	@Override
	public void clearCache(List<FileInfo> fileInfos) {
		for (FileInfo fileInfo : fileInfos) {
			entityCache.removeResult(FileInfoImpl.class, fileInfo);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FileInfoImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(FileInfoImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		FileInfoModelImpl fileInfoModelImpl) {

		Object[] args = new Object[] {
			fileInfoModelImpl.getCompanyId(),
			fileInfoModelImpl.getRepositoryId(), fileInfoModelImpl.getPath(),
			fileInfoModelImpl.getVersion()
		};

		finderCache.putResult(
			_finderPathFetchByC_R_P_V, args, fileInfoModelImpl);
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

		fileInfo.setCompanyId(CompanyThreadLocal.getCompanyId());

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

			FileInfo fileInfo = (FileInfo)session.get(
				FileInfoImpl.class, primaryKey);

			if (fileInfo == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFileInfoException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(fileInfo);
		}
		catch (NoSuchFileInfoException noSuchEntityException) {
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
	protected FileInfo removeImpl(FileInfo fileInfo) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(fileInfo)) {
				fileInfo = (FileInfo)session.get(
					FileInfoImpl.class, fileInfo.getPrimaryKeyObj());
			}

			if (fileInfo != null) {
				session.delete(fileInfo);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
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
		boolean isNew = fileInfo.isNew();

		if (!(fileInfo instanceof FileInfoModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(fileInfo.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(fileInfo);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in fileInfo proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom FileInfo implementation " +
					fileInfo.getClass());
		}

		FileInfoModelImpl fileInfoModelImpl = (FileInfoModelImpl)fileInfo;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(fileInfo);
			}
			else {
				fileInfo = (FileInfo)session.merge(fileInfo);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			FileInfoImpl.class, fileInfoModelImpl, false, true);

		cacheUniqueFindersCache(fileInfoModelImpl);

		if (isNew) {
			fileInfo.setNew(false);
		}

		fileInfo.resetOriginalValues();

		return fileInfo;
	}

	/**
	 * Returns the file info with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
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

			throw new NoSuchFileInfoException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return fileInfo;
	}

	/**
	 * Returns the file info with the primary key or throws a <code>NoSuchFileInfoException</code> if it could not be found.
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
	 * @param fileInfoId the primary key of the file info
	 * @return the file info, or <code>null</code> if a file info with the primary key could not be found
	 */
	@Override
	public FileInfo fetchByPrimaryKey(long fileInfoId) {
		return fetchByPrimaryKey((Serializable)fileInfoId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileInfoModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileInfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of file infos
	 * @param end the upper bound of the range of file infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of file infos
	 */
	@Override
	public List<FileInfo> findAll(
		int start, int end, OrderByComparator<FileInfo> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the file infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileInfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of file infos
	 * @param end the upper bound of the range of file infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of file infos
	 */
	@Override
	public List<FileInfo> findAll(
		int start, int end, OrderByComparator<FileInfo> orderByComparator,
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

		List<FileInfo> list = null;

		if (useFinderCache) {
			list = (List<FileInfo>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_FILEINFO);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_FILEINFO;

				sql = sql.concat(FileInfoModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<FileInfo>)QueryUtil.list(
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
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_FILEINFO);

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
		return "fileInfoId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_FILEINFO;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return FileInfoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the file info persistence.
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

		_finderPathWithPaginationFindByC_R = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_R",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"companyId", "repositoryId"}, true);

		_finderPathWithoutPaginationFindByC_R = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_R",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"companyId", "repositoryId"}, true);

		_finderPathCountByC_R = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_R",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"companyId", "repositoryId"}, false);

		_finderPathWithPaginationFindByC_R_P = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_R_P",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"companyId", "repositoryId", "path_"}, true);

		_finderPathWithoutPaginationFindByC_R_P = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_R_P",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			new String[] {"companyId", "repositoryId", "path_"}, true);

		_finderPathCountByC_R_P = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_R_P",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			new String[] {"companyId", "repositoryId", "path_"}, false);

		_finderPathWithPaginationFindByC_R_LikeP = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_R_LikeP",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"companyId", "repositoryId", "path_"}, true);

		_finderPathWithPaginationCountByC_R_LikeP = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByC_R_LikeP",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			new String[] {"companyId", "repositoryId", "path_"}, false);

		_finderPathFetchByC_R_P_V = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByC_R_P_V",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), String.class.getName()
			},
			new String[] {"companyId", "repositoryId", "path_", "version"},
			true);

		_finderPathWithPaginationFindByFileData = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFileData",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"fileDataId"}, true);

		_finderPathWithoutPaginationFindByFileData = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFileData",
			new String[] {Long.class.getName()}, new String[] {"fileDataId"},
			true);

		_finderPathCountByFileData = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFileData",
			new String[] {Long.class.getName()}, new String[] {"fileDataId"},
			false);

		_finderPathWithPaginationFindByC = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"companyId"}, true);

		_finderPathWithoutPaginationFindByC = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC",
			new String[] {Long.class.getName()}, new String[] {"companyId"},
			true);

		_finderPathCountByC = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC",
			new String[] {Long.class.getName()}, new String[] {"companyId"},
			false);

		FileInfoUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		FileInfoUtil.setPersistence(null);

		entityCache.removeCache(FileInfoImpl.class.getName());
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

	private static final String _SQL_SELECT_FILEINFO =
		"SELECT fileInfo FROM FileInfo fileInfo";

	private static final String _SQL_SELECT_FILEINFO_WHERE =
		"SELECT fileInfo FROM FileInfo fileInfo WHERE ";

	private static final String _SQL_COUNT_FILEINFO =
		"SELECT COUNT(fileInfo) FROM FileInfo fileInfo";

	private static final String _SQL_COUNT_FILEINFO_WHERE =
		"SELECT COUNT(fileInfo) FROM FileInfo fileInfo WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "fileInfo.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No FileInfo exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No FileInfo exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		FileInfoPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"path"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}