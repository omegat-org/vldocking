package com.vlsolutions.swing.docking;

import com.vlsolutions.swing.TestBase;
import org.junit.Test;

import javax.swing.*;

public class AutoHideButtonTest extends TestBase {

    @Test
    public void testAutoHideButton() {
        SwingUtilities.invokeLater(() -> application.setVisible(true));
        window.panel("DockingPanel").panel(new PanelMatcher("DockView", 2)).panel("DockViewTitleBar")
                .button("DockButton").click();
        window.panel("AutoHideButtonPanel").label(new AutoHideButtonMatcher("AutoHideButton", 0)).click();
        window.panel("AutoHideExpandPanel").panel("DockViewTitleBar").label("TitleLabel")
                .requireText("The table");
        window.panel("AutoHideExpandPanel").panel("DockViewTitleBar").button("DockButton").click();
    }
}
