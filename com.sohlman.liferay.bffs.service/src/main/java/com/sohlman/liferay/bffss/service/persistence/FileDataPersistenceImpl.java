package com.sohlman.liferay.bffss.service.persistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.sohlman.liferay.bffss.NoSuchFileDataException;
import com.sohlman.liferay.bffss.model.FileData;
import com.sohlman.liferay.bffss.model.impl.FileDataImpl;
import com.sohlman.liferay.bffss.model.impl.FileDataModelImpl;
import com.sohlman.liferay.bffss.service.persistence.FileDataPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the file data service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FileDataPersistence
 * @see FileDataUtil
 * @generated
 */
public class FileDataPersistenceImpl extends BasePersistenceImpl<FileData>
    implements FileDataPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link FileDataUtil} to access the file data persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = FileDataImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FileDataModelImpl.ENTITY_CACHE_ENABLED,
            FileDataModelImpl.FINDER_CACHE_ENABLED, FileDataImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FileDataModelImpl.ENTITY_CACHE_ENABLED,
            FileDataModelImpl.FINDER_CACHE_ENABLED, FileDataImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FileDataModelImpl.ENTITY_CACHE_ENABLED,
            FileDataModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FINGERPRINT =
        new FinderPath(FileDataModelImpl.ENTITY_CACHE_ENABLED,
            FileDataModelImpl.FINDER_CACHE_ENABLED, FileDataImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFingerPrint",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FINGERPRINT =
        new FinderPath(FileDataModelImpl.ENTITY_CACHE_ENABLED,
            FileDataModelImpl.FINDER_CACHE_ENABLED, FileDataImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFingerPrint",
            new String[] { String.class.getName() },
            FileDataModelImpl.FINGERPRINT_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_FINGERPRINT = new FinderPath(FileDataModelImpl.ENTITY_CACHE_ENABLED,
            FileDataModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFingerPrint",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_FINGERPRINT_FINGERPRINT_1 = "fileData.fingerprint IS NULL";
    private static final String _FINDER_COLUMN_FINGERPRINT_FINGERPRINT_2 = "fileData.fingerprint = ?";
    private static final String _FINDER_COLUMN_FINGERPRINT_FINGERPRINT_3 = "(fileData.fingerprint IS NULL OR fileData.fingerprint = '')";
    private static final String _SQL_SELECT_FILEDATA = "SELECT fileData FROM FileData fileData";
    private static final String _SQL_SELECT_FILEDATA_WHERE = "SELECT fileData FROM FileData fileData WHERE ";
    private static final String _SQL_COUNT_FILEDATA = "SELECT COUNT(fileData) FROM FileData fileData";
    private static final String _SQL_COUNT_FILEDATA_WHERE = "SELECT COUNT(fileData) FROM FileData fileData WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "fileData.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No FileData exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No FileData exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(FileDataPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "size"
            });
    private static FileData _nullFileData = new FileDataImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<FileData> toCacheModel() {
                return _nullFileDataCacheModel;
            }
        };

    private static CacheModel<FileData> _nullFileDataCacheModel = new CacheModel<FileData>() {
            @Override
            public FileData toEntityModel() {
                return _nullFileData;
            }
        };

    public FileDataPersistenceImpl() {
        setModelClass(FileData.class);
    }

    /**
     * Returns all the file datas where fingerprint = &#63;.
     *
     * @param fingerprint the fingerprint
     * @return the matching file datas
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<FileData> findByFingerPrint(String fingerprint)
        throws SystemException {
        return findByFingerPrint(fingerprint, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the file datas where fingerprint = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sohlman.liferay.bffss.model.impl.FileDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param fingerprint the fingerprint
     * @param start the lower bound of the range of file datas
     * @param end the upper bound of the range of file datas (not inclusive)
     * @return the range of matching file datas
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<FileData> findByFingerPrint(String fingerprint, int start,
        int end) throws SystemException {
        return findByFingerPrint(fingerprint, start, end, null);
    }

    /**
     * Returns an ordered range of all the file datas where fingerprint = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sohlman.liferay.bffss.model.impl.FileDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param fingerprint the fingerprint
     * @param start the lower bound of the range of file datas
     * @param end the upper bound of the range of file datas (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching file datas
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<FileData> findByFingerPrint(String fingerprint, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FINGERPRINT;
            finderArgs = new Object[] { fingerprint };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_FINGERPRINT;
            finderArgs = new Object[] { fingerprint, start, end, orderByComparator };
        }

        List<FileData> list = (List<FileData>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (FileData fileData : list) {
                if (!Validator.equals(fingerprint, fileData.getFingerprint())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_FILEDATA_WHERE);

            boolean bindFingerprint = false;

            if (fingerprint == null) {
                query.append(_FINDER_COLUMN_FINGERPRINT_FINGERPRINT_1);
            } else if (fingerprint.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_FINGERPRINT_FINGERPRINT_3);
            } else {
                bindFingerprint = true;

                query.append(_FINDER_COLUMN_FINGERPRINT_FINGERPRINT_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(FileDataModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindFingerprint) {
                    qPos.add(fingerprint);
                }

                if (!pagination) {
                    list = (List<FileData>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<FileData>(list);
                } else {
                    list = (List<FileData>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
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
     * @throws com.sohlman.liferay.bffss.NoSuchFileDataException if a matching file data could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public FileData findByFingerPrint_First(String fingerprint,
        OrderByComparator orderByComparator)
        throws NoSuchFileDataException, SystemException {
        FileData fileData = fetchByFingerPrint_First(fingerprint,
                orderByComparator);

        if (fileData != null) {
            return fileData;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("fingerprint=");
        msg.append(fingerprint);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchFileDataException(msg.toString());
    }

    /**
     * Returns the first file data in the ordered set where fingerprint = &#63;.
     *
     * @param fingerprint the fingerprint
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching file data, or <code>null</code> if a matching file data could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public FileData fetchByFingerPrint_First(String fingerprint,
        OrderByComparator orderByComparator) throws SystemException {
        List<FileData> list = findByFingerPrint(fingerprint, 0, 1,
                orderByComparator);

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
     * @throws com.sohlman.liferay.bffss.NoSuchFileDataException if a matching file data could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public FileData findByFingerPrint_Last(String fingerprint,
        OrderByComparator orderByComparator)
        throws NoSuchFileDataException, SystemException {
        FileData fileData = fetchByFingerPrint_Last(fingerprint,
                orderByComparator);

        if (fileData != null) {
            return fileData;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("fingerprint=");
        msg.append(fingerprint);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchFileDataException(msg.toString());
    }

    /**
     * Returns the last file data in the ordered set where fingerprint = &#63;.
     *
     * @param fingerprint the fingerprint
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching file data, or <code>null</code> if a matching file data could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public FileData fetchByFingerPrint_Last(String fingerprint,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByFingerPrint(fingerprint);

        if (count == 0) {
            return null;
        }

        List<FileData> list = findByFingerPrint(fingerprint, count - 1, count,
                orderByComparator);

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
     * @throws com.sohlman.liferay.bffss.NoSuchFileDataException if a file data with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public FileData[] findByFingerPrint_PrevAndNext(long fileDataId,
        String fingerprint, OrderByComparator orderByComparator)
        throws NoSuchFileDataException, SystemException {
        FileData fileData = findByPrimaryKey(fileDataId);

        Session session = null;

        try {
            session = openSession();

            FileData[] array = new FileDataImpl[3];

            array[0] = getByFingerPrint_PrevAndNext(session, fileData,
                    fingerprint, orderByComparator, true);

            array[1] = fileData;

            array[2] = getByFingerPrint_PrevAndNext(session, fileData,
                    fingerprint, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected FileData getByFingerPrint_PrevAndNext(Session session,
        FileData fileData, String fingerprint,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_FILEDATA_WHERE);

        boolean bindFingerprint = false;

        if (fingerprint == null) {
            query.append(_FINDER_COLUMN_FINGERPRINT_FINGERPRINT_1);
        } else if (fingerprint.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_FINGERPRINT_FINGERPRINT_3);
        } else {
            bindFingerprint = true;

            query.append(_FINDER_COLUMN_FINGERPRINT_FINGERPRINT_2);
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
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
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
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(FileDataModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindFingerprint) {
            qPos.add(fingerprint);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(fileData);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<FileData> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the file datas where fingerprint = &#63; from the database.
     *
     * @param fingerprint the fingerprint
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByFingerPrint(String fingerprint)
        throws SystemException {
        for (FileData fileData : findByFingerPrint(fingerprint,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(fileData);
        }
    }

    /**
     * Returns the number of file datas where fingerprint = &#63;.
     *
     * @param fingerprint the fingerprint
     * @return the number of matching file datas
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByFingerPrint(String fingerprint) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_FINGERPRINT;

        Object[] finderArgs = new Object[] { fingerprint };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_FILEDATA_WHERE);

            boolean bindFingerprint = false;

            if (fingerprint == null) {
                query.append(_FINDER_COLUMN_FINGERPRINT_FINGERPRINT_1);
            } else if (fingerprint.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_FINGERPRINT_FINGERPRINT_3);
            } else {
                bindFingerprint = true;

                query.append(_FINDER_COLUMN_FINGERPRINT_FINGERPRINT_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindFingerprint) {
                    qPos.add(fingerprint);
                }

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Caches the file data in the entity cache if it is enabled.
     *
     * @param fileData the file data
     */
    @Override
    public void cacheResult(FileData fileData) {
        EntityCacheUtil.putResult(FileDataModelImpl.ENTITY_CACHE_ENABLED,
            FileDataImpl.class, fileData.getPrimaryKey(), fileData);

        fileData.resetOriginalValues();
    }

    /**
     * Caches the file datas in the entity cache if it is enabled.
     *
     * @param fileDatas the file datas
     */
    @Override
    public void cacheResult(List<FileData> fileDatas) {
        for (FileData fileData : fileDatas) {
            if (EntityCacheUtil.getResult(
                        FileDataModelImpl.ENTITY_CACHE_ENABLED,
                        FileDataImpl.class, fileData.getPrimaryKey()) == null) {
                cacheResult(fileData);
            } else {
                fileData.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all file datas.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(FileDataImpl.class.getName());
        }

        EntityCacheUtil.clearCache(FileDataImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the file data.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(FileData fileData) {
        EntityCacheUtil.removeResult(FileDataModelImpl.ENTITY_CACHE_ENABLED,
            FileDataImpl.class, fileData.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<FileData> fileDatas) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (FileData fileData : fileDatas) {
            EntityCacheUtil.removeResult(FileDataModelImpl.ENTITY_CACHE_ENABLED,
                FileDataImpl.class, fileData.getPrimaryKey());
        }
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

        return fileData;
    }

    /**
     * Removes the file data with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param fileDataId the primary key of the file data
     * @return the file data that was removed
     * @throws com.sohlman.liferay.bffss.NoSuchFileDataException if a file data with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public FileData remove(long fileDataId)
        throws NoSuchFileDataException, SystemException {
        return remove((Serializable) fileDataId);
    }

    /**
     * Removes the file data with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the file data
     * @return the file data that was removed
     * @throws com.sohlman.liferay.bffss.NoSuchFileDataException if a file data with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public FileData remove(Serializable primaryKey)
        throws NoSuchFileDataException, SystemException {
        Session session = null;

        try {
            session = openSession();

            FileData fileData = (FileData) session.get(FileDataImpl.class,
                    primaryKey);

            if (fileData == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchFileDataException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(fileData);
        } catch (NoSuchFileDataException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected FileData removeImpl(FileData fileData) throws SystemException {
        fileData = toUnwrappedModel(fileData);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(fileData)) {
                fileData = (FileData) session.get(FileDataImpl.class,
                        fileData.getPrimaryKeyObj());
            }

            if (fileData != null) {
                session.delete(fileData);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (fileData != null) {
            clearCache(fileData);
        }

        return fileData;
    }

    @Override
    public FileData updateImpl(
        com.sohlman.liferay.bffss.model.FileData fileData)
        throws SystemException {
        fileData = toUnwrappedModel(fileData);

        boolean isNew = fileData.isNew();

        FileDataModelImpl fileDataModelImpl = (FileDataModelImpl) fileData;

        Session session = null;

        try {
            session = openSession();

            if (fileData.isNew()) {
                session.save(fileData);

                fileData.setNew(false);
            } else {
                session.merge(fileData);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !FileDataModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((fileDataModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FINGERPRINT.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        fileDataModelImpl.getOriginalFingerprint()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FINGERPRINT,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FINGERPRINT,
                    args);

                args = new Object[] { fileDataModelImpl.getFingerprint() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FINGERPRINT,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FINGERPRINT,
                    args);
            }
        }

        EntityCacheUtil.putResult(FileDataModelImpl.ENTITY_CACHE_ENABLED,
            FileDataImpl.class, fileData.getPrimaryKey(), fileData);

        return fileData;
    }

    protected FileData toUnwrappedModel(FileData fileData) {
        if (fileData instanceof FileDataImpl) {
            return fileData;
        }

        FileDataImpl fileDataImpl = new FileDataImpl();

        fileDataImpl.setNew(fileData.isNew());
        fileDataImpl.setPrimaryKey(fileData.getPrimaryKey());

        fileDataImpl.setFileDataId(fileData.getFileDataId());
        fileDataImpl.setCompanyId(fileData.getCompanyId());
        fileDataImpl.setCreateDate(fileData.getCreateDate());
        fileDataImpl.setName(fileData.getName());
        fileDataImpl.setSize(fileData.getSize());
        fileDataImpl.setFingerprint(fileData.getFingerprint());

        return fileDataImpl;
    }

    /**
     * Returns the file data with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the file data
     * @return the file data
     * @throws com.sohlman.liferay.bffss.NoSuchFileDataException if a file data with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public FileData findByPrimaryKey(Serializable primaryKey)
        throws NoSuchFileDataException, SystemException {
        FileData fileData = fetchByPrimaryKey(primaryKey);

        if (fileData == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchFileDataException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return fileData;
    }

    /**
     * Returns the file data with the primary key or throws a {@link com.sohlman.liferay.bffss.NoSuchFileDataException} if it could not be found.
     *
     * @param fileDataId the primary key of the file data
     * @return the file data
     * @throws com.sohlman.liferay.bffss.NoSuchFileDataException if a file data with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public FileData findByPrimaryKey(long fileDataId)
        throws NoSuchFileDataException, SystemException {
        return findByPrimaryKey((Serializable) fileDataId);
    }

    /**
     * Returns the file data with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the file data
     * @return the file data, or <code>null</code> if a file data with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public FileData fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        FileData fileData = (FileData) EntityCacheUtil.getResult(FileDataModelImpl.ENTITY_CACHE_ENABLED,
                FileDataImpl.class, primaryKey);

        if (fileData == _nullFileData) {
            return null;
        }

        if (fileData == null) {
            Session session = null;

            try {
                session = openSession();

                fileData = (FileData) session.get(FileDataImpl.class, primaryKey);

                if (fileData != null) {
                    cacheResult(fileData);
                } else {
                    EntityCacheUtil.putResult(FileDataModelImpl.ENTITY_CACHE_ENABLED,
                        FileDataImpl.class, primaryKey, _nullFileData);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(FileDataModelImpl.ENTITY_CACHE_ENABLED,
                    FileDataImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return fileData;
    }

    /**
     * Returns the file data with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param fileDataId the primary key of the file data
     * @return the file data, or <code>null</code> if a file data with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public FileData fetchByPrimaryKey(long fileDataId)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) fileDataId);
    }

    /**
     * Returns all the file datas.
     *
     * @return the file datas
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<FileData> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the file datas.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sohlman.liferay.bffss.model.impl.FileDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of file datas
     * @param end the upper bound of the range of file datas (not inclusive)
     * @return the range of file datas
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<FileData> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the file datas.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sohlman.liferay.bffss.model.impl.FileDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of file datas
     * @param end the upper bound of the range of file datas (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of file datas
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<FileData> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
            finderArgs = FINDER_ARGS_EMPTY;
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
            finderArgs = new Object[] { start, end, orderByComparator };
        }

        List<FileData> list = (List<FileData>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_FILEDATA);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_FILEDATA;

                if (pagination) {
                    sql = sql.concat(FileDataModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<FileData>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<FileData>(list);
                } else {
                    list = (List<FileData>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the file datas from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (FileData fileData : findAll()) {
            remove(fileData);
        }
    }

    /**
     * Returns the number of file datas.
     *
     * @return the number of file datas
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_FILEDATA);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    @Override
    protected Set<String> getBadColumnNames() {
        return _badColumnNames;
    }

    /**
     * Initializes the file data persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.sohlman.liferay.bffss.model.FileData")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<FileData>> listenersList = new ArrayList<ModelListener<FileData>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<FileData>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(FileDataImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
