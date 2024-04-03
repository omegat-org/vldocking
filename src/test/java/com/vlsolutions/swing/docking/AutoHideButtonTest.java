package com.vlsolutions.swing.docking;

import com.vlsolutions.swing.TestBase;
import com.vlsolutions.swing.sample.MySplitDockApp;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;

public class AutoHideButtonTest extends TestBase {

    @Test
    public void testAutoHideButton() {
        window.panel("DockingPanel").panel(new PanelMatcher("DockView", 2)).panel("DockViewTitleBar")
                .button("DockButton").click();
        window.panel("AutoHideButtonPanel").label(new AutoHideButtonMatcher("AutoHideButton", 0)).click();
        window.panel("AutoHideExpandPanel").panel("DockViewTitleBar").label("TitleLabel")
                .requireText("Table");
        window.panel("AutoHideExpandPanel").panel("DockViewTitleBar").button("DockButton").click();
    }

    @Override
    protected JFrame createApplication() {
        MySplitDockApp frame = new MySplitDockApp();
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setMinimumSize(new Dimension(800, 600));
        frame.validate();
        return frame;
    }

    @Override
    protected void startApplication() {
        SwingUtilities.invokeLater(() -> application.setVisible(true));
    }
}
