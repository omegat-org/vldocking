package com.vlsolutions.swing.docking;

import com.vlsolutions.swing.TestBase;
import com.vlsolutions.swing.sample.MySplitTabDockApp;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;

public class DockingSplitTabDesktopTest extends TestBase {

    @Test
    public void testSplitTab() {
        window.panel("myTreePanel").requireVisible();
        window.panel("myTextEditorPanel").requireVisible();
        window.panel("myGridOfButtonsPanel").requireVisible();
        window.panel("myGridOfButtonsPanel").button("myGridOfButtonsButton0").requireText("btn0");

        window.panel("DockingPanel").panel(new PanelMatcher("DockView", 0)).panel("DockViewTitleBar")
                .label("TitleLabel").requireText("The Grid of Buttons");
    }

    @Override
    protected JFrame createApplication() {
        MySplitTabDockApp frame = new MySplitTabDockApp();
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
