package com.haulmont.sampler.gui.components.button;

import com.haulmont.cuba.gui.components.AbstractFrame;

public class ActionButtonFrame extends AbstractFrame {
    public void someAction() {
        showNotification("Action performed!", NotificationType.HUMANIZED);
    }
}