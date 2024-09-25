package com.vlsolutions.swing.sample;

import com.vlsolutions.swing.docking.DockKey;
import com.vlsolutions.swing.docking.Dockable;
import com.vlsolutions.swing.docking.DockingConstants;

import javax.swing.*;
import java.awt.*;

class DockableScrollPane extends JScrollPane implements Dockable {

    private static final String KEY = "SCROLLPANE";
    private static final String NAME = "ScrollPane";

    DockKey dockKey;

    public DockableScrollPane(Component view) {
        super(view);
        dockKey = new DockKey(KEY, NAME, null, null, DockingConstants.HIDE_BOTTOM);
        dockKey.setCloseEnabled(false);
    }

    @Override
    public DockKey getDockKey() {
        return dockKey;
    }

    @Override
    public Component getComponent() {
        return this;
    }

    public void notification() {
        dockKey.setNotification(true);
    }
}
