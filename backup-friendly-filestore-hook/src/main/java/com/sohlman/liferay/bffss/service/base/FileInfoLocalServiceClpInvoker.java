package com.sohlman.liferay.bffss.service.base;

import com.sohlman.liferay.bffss.service.FileInfoLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class FileInfoLocalServiceClpInvoker {
    private String _methodName0;
    private String[] _methodParameterTypes0;
    private String _methodName1;
    private String[] _methodParameterTypes1;
    private String _methodName2;
    private String[] _methodParameterTypes2;
    private String _methodName3;
    private String[] _methodParameterTypes3;
    private String _methodName4;
    private String[] _methodParameterTypes4;
    private String _methodName5;
    private String[] _methodParameterTypes5;
    private String _methodName6;
    private String[] _methodParameterTypes6;
    private String _methodName7;
    private String[] _methodParameterTypes7;
    private String _methodName8;
    private String[] _methodParameterTypes8;
    private String _methodName9;
    private String[] _methodParameterTypes9;
    private String _methodName10;
    private String[] _methodParameterTypes10;
    private String _methodName11;
    private String[] _methodParameterTypes11;
    private String _methodName12;
    private String[] _methodParameterTypes12;
    private String _methodName13;
    private String[] _methodParameterTypes13;
    private String _methodName14;
    private String[] _methodParameterTypes14;
    private String _methodName15;
    private String[] _methodParameterTypes15;
    private String _methodName36;
    private String[] _methodParameterTypes36;
    private String _methodName37;
    private String[] _methodParameterTypes37;
    private String _methodName42;
    private String[] _methodParameterTypes42;
    private String _methodName43;
    private String[] _methodParameterTypes43;
    private String _methodName45;
    private String[] _methodParameterTypes45;
    private String _methodName46;
    private String[] _methodParameterTypes46;
    private String _methodName47;
    private String[] _methodParameterTypes47;
    private String _methodName48;
    private String[] _methodParameterTypes48;
    private String _methodName49;
    private String[] _methodParameterTypes49;
    private String _methodName50;
    private String[] _methodParameterTypes50;
    private String _methodName51;
    private String[] _methodParameterTypes51;
    private String _methodName52;
    private String[] _methodParameterTypes52;
    private String _methodName53;
    private String[] _methodParameterTypes53;
    private String _methodName54;
    private String[] _methodParameterTypes54;
    private String _methodName55;
    private String[] _methodParameterTypes55;
    private String _methodName56;
    private String[] _methodParameterTypes56;

    public FileInfoLocalServiceClpInvoker() {
        _methodName0 = "addFileInfo";

        _methodParameterTypes0 = new String[] {
                "com.sohlman.liferay.bffss.model.FileInfo"
            };

        _methodName1 = "createFileInfo";

        _methodParameterTypes1 = new String[] { "long" };

        _methodName2 = "deleteFileInfo";

        _methodParameterTypes2 = new String[] { "long" };

        _methodName3 = "deleteFileInfo";

        _methodParameterTypes3 = new String[] {
                "com.sohlman.liferay.bffss.model.FileInfo"
            };

        _methodName4 = "dynamicQuery";

        _methodParameterTypes4 = new String[] {  };

        _methodName5 = "dynamicQuery";

        _methodParameterTypes5 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery"
            };

        _methodName6 = "dynamicQuery";

        _methodParameterTypes6 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
            };

        _methodName7 = "dynamicQuery";

        _methodParameterTypes7 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };

        _methodName8 = "dynamicQueryCount";

        _methodParameterTypes8 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery"
            };

        _methodName9 = "dynamicQueryCount";

        _methodParameterTypes9 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery",
                "com.liferay.portal.kernel.dao.orm.Projection"
            };

        _methodName10 = "fetchFileInfo";

        _methodParameterTypes10 = new String[] { "long" };

        _methodName11 = "getFileInfo";

        _methodParameterTypes11 = new String[] { "long" };

        _methodName12 = "getPersistedModel";

        _methodParameterTypes12 = new String[] { "java.io.Serializable" };

        _methodName13 = "getFileInfos";

        _methodParameterTypes13 = new String[] { "int", "int" };

        _methodName14 = "getFileInfosCount";

        _methodParameterTypes14 = new String[] {  };

        _methodName15 = "updateFileInfo";

        _methodParameterTypes15 = new String[] {
                "com.sohlman.liferay.bffss.model.FileInfo"
            };

        _methodName36 = "getBeanIdentifier";

        _methodParameterTypes36 = new String[] {  };

        _methodName37 = "setBeanIdentifier";

        _methodParameterTypes37 = new String[] { "java.lang.String" };

        _methodName42 = "addFileInfo";

        _methodParameterTypes42 = new String[] {
                "long", "long", "java.lang.String", "java.lang.String",
                "byte[][]"
            };

        _methodName43 = "addFileInfo";

        _methodParameterTypes43 = new String[] {
                "long", "long", "java.lang.String", "java.lang.String",
                "java.io.InputStream", "long"
            };

        _methodName45 = "deleteFileInfo";

        _methodParameterTypes45 = new String[] {
                "long", "long", "java.lang.String", "java.lang.String"
            };

        _methodName46 = "deleteFileInfos";

        _methodParameterTypes46 = new String[] {
                "long", "long", "java.lang.String"
            };

        _methodName47 = "deleteFileInfosByDirectory";

        _methodParameterTypes47 = new String[] {
                "long", "long", "java.lang.String"
            };

        _methodName48 = "getFileInfo";

        _methodParameterTypes48 = new String[] {
                "long", "long", "java.lang.String"
            };

        _methodName49 = "getFileInfo";

        _methodParameterTypes49 = new String[] {
                "long", "long", "java.lang.String", "java.lang.String"
            };

        _methodName50 = "getFileInfos";

        _methodParameterTypes50 = new String[] { "long", "long" };

        _methodName51 = "getFileInfos";

        _methodParameterTypes51 = new String[] {
                "long", "long", "java.lang.String"
            };

        _methodName52 = "getFileInfosByDirectory";

        _methodParameterTypes52 = new String[] {
                "long", "long", "java.lang.String"
            };

        _methodName53 = "getFileAsStream";

        _methodParameterTypes53 = new String[] {
                "long", "long", "java.lang.String"
            };

        _methodName54 = "getFileAsStream";

        _methodParameterTypes54 = new String[] {
                "long", "long", "java.lang.String", "java.lang.String"
            };

        _methodName55 = "hasFileInfo";

        _methodParameterTypes55 = new String[] {
                "long", "long", "java.lang.String", "java.lang.String"
            };

        _methodName56 = "updateFileInfo";

        _methodParameterTypes56 = new String[] {
                "long", "long", "long", "java.lang.String", "java.lang.String"
            };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName0.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
            return FileInfoLocalServiceUtil.addFileInfo((com.sohlman.liferay.bffss.model.FileInfo) arguments[0]);
        }

        if (_methodName1.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
            return FileInfoLocalServiceUtil.createFileInfo(((Long) arguments[0]).longValue());
        }

        if (_methodName2.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
            return FileInfoLocalServiceUtil.deleteFileInfo(((Long) arguments[0]).longValue());
        }

        if (_methodName3.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
            return FileInfoLocalServiceUtil.deleteFileInfo((com.sohlman.liferay.bffss.model.FileInfo) arguments[0]);
        }

        if (_methodName4.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
            return FileInfoLocalServiceUtil.dynamicQuery();
        }

        if (_methodName5.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
            return FileInfoLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName6.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
            return FileInfoLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName7.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
            return FileInfoLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName8.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
            return FileInfoLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName9.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
            return FileInfoLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                (com.liferay.portal.kernel.dao.orm.Projection) arguments[1]);
        }

        if (_methodName10.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
            return FileInfoLocalServiceUtil.fetchFileInfo(((Long) arguments[0]).longValue());
        }

        if (_methodName11.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
            return FileInfoLocalServiceUtil.getFileInfo(((Long) arguments[0]).longValue());
        }

        if (_methodName12.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
            return FileInfoLocalServiceUtil.getPersistedModel((java.io.Serializable) arguments[0]);
        }

        if (_methodName13.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
            return FileInfoLocalServiceUtil.getFileInfos(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName14.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
            return FileInfoLocalServiceUtil.getFileInfosCount();
        }

        if (_methodName15.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
            return FileInfoLocalServiceUtil.updateFileInfo((com.sohlman.liferay.bffss.model.FileInfo) arguments[0]);
        }

        if (_methodName36.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes36, parameterTypes)) {
            return FileInfoLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName37.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes37, parameterTypes)) {
            FileInfoLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName42.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes42, parameterTypes)) {
            return FileInfoLocalServiceUtil.addFileInfo(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue(),
                (java.lang.String) arguments[2],
                (java.lang.String) arguments[3], (byte[]) arguments[4]);
        }

        if (_methodName43.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes43, parameterTypes)) {
            return FileInfoLocalServiceUtil.addFileInfo(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue(),
                (java.lang.String) arguments[2],
                (java.lang.String) arguments[3],
                (java.io.InputStream) arguments[4],
                ((Long) arguments[5]).longValue());
        }

        if (_methodName45.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes45, parameterTypes)) {
            FileInfoLocalServiceUtil.deleteFileInfo(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue(),
                (java.lang.String) arguments[2], (java.lang.String) arguments[3]);

            return null;
        }

        if (_methodName46.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes46, parameterTypes)) {
            FileInfoLocalServiceUtil.deleteFileInfos(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue(),
                (java.lang.String) arguments[2]);

            return null;
        }

        if (_methodName47.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes47, parameterTypes)) {
            FileInfoLocalServiceUtil.deleteFileInfosByDirectory(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue(),
                (java.lang.String) arguments[2]);

            return null;
        }

        if (_methodName48.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes48, parameterTypes)) {
            return FileInfoLocalServiceUtil.getFileInfo(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue(),
                (java.lang.String) arguments[2]);
        }

        if (_methodName49.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes49, parameterTypes)) {
            return FileInfoLocalServiceUtil.getFileInfo(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue(),
                (java.lang.String) arguments[2], (java.lang.String) arguments[3]);
        }

        if (_methodName50.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes50, parameterTypes)) {
            return FileInfoLocalServiceUtil.getFileInfos(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue());
        }

        if (_methodName51.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes51, parameterTypes)) {
            return FileInfoLocalServiceUtil.getFileInfos(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue(),
                (java.lang.String) arguments[2]);
        }

        if (_methodName52.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes52, parameterTypes)) {
            return FileInfoLocalServiceUtil.getFileInfosByDirectory(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue(),
                (java.lang.String) arguments[2]);
        }

        if (_methodName53.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes53, parameterTypes)) {
            return FileInfoLocalServiceUtil.getFileAsStream(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue(),
                (java.lang.String) arguments[2]);
        }

        if (_methodName54.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes54, parameterTypes)) {
            return FileInfoLocalServiceUtil.getFileAsStream(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue(),
                (java.lang.String) arguments[2], (java.lang.String) arguments[3]);
        }

        if (_methodName55.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes55, parameterTypes)) {
            return FileInfoLocalServiceUtil.hasFileInfo(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue(),
                (java.lang.String) arguments[2], (java.lang.String) arguments[3]);
        }

        if (_methodName56.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes56, parameterTypes)) {
            FileInfoLocalServiceUtil.updateFileInfo(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue(),
                ((Long) arguments[2]).longValue(),
                (java.lang.String) arguments[3], (java.lang.String) arguments[4]);

            return null;
        }

        throw new UnsupportedOperationException();
    }
}
