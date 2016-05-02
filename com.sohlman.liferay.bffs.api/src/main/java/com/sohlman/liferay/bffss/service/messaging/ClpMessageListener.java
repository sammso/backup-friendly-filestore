package com.sohlman.liferay.bffss.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import com.sohlman.liferay.bffss.service.ClpSerializer;
import com.sohlman.liferay.bffss.service.FileDataLocalServiceUtil;
import com.sohlman.liferay.bffss.service.FileInfoLocalServiceUtil;


public class ClpMessageListener extends BaseMessageListener {
    public static String getServletContextName() {
        return ClpSerializer.getServletContextName();
    }

    @Override
    protected void doReceive(Message message) throws Exception {
        String command = message.getString("command");
        String servletContextName = message.getString("servletContextName");

        if (command.equals("undeploy") &&
                servletContextName.equals(getServletContextName())) {
            FileDataLocalServiceUtil.clearService();

            FileInfoLocalServiceUtil.clearService();
        }
    }
}
