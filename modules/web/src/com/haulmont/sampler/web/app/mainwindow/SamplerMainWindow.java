package com.haulmont.sampler.web.app.mainwindow;

import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.UserSessionSource;
import com.haulmont.cuba.core.sys.AppContext;
import com.haulmont.cuba.gui.components.Embedded;
import com.haulmont.cuba.gui.components.mainwindow.LogoutButton;
import com.haulmont.cuba.gui.components.mainwindow.UserIndicator;
import com.haulmont.cuba.security.entity.Role;
import com.haulmont.cuba.security.entity.UserRole;
import com.haulmont.cuba.web.app.mainwindow.AppMainWindow;
import org.apache.commons.lang.BooleanUtils;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

public class SamplerMainWindow extends AppMainWindow {

    @Inject
    private UserIndicator userIndicator;
    @Inject
    private Embedded platformLogoImage;
    @Inject
    private LogoutButton logoutButton;

    @Override
    public void init(Map<String, Object> params) {
        super.init(params);

        platformLogoImage.setSource("platform-logo.png");
        platformLogoImage.setWidth("350px");
        platformLogoImage.setHeight("60px");

        initUserIndicator();

        if (BooleanUtils.toBoolean(AppContext.getProperty("sampler.developerMode"))) {
            logoutButton.setVisible(true);
        }
    }

    private void initUserIndicator() {
        UserSessionSource userSessionSource = AppBeans.get(UserSessionSource.NAME);
        List<UserRole> roles = userSessionSource.getUserSession().getUser().getUserRoles();
        for (UserRole userRole : roles) {
            Role role = userRole.getRole();
            if ("Demo users".equals(role.getName())) {
                userIndicator.setVisible(false);
                return;
            }
        }
    }
}
