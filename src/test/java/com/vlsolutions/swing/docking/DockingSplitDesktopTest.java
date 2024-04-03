package com.vlsolutions.swing.docking;

import com.vlsolutions.swing.TestBase;
import com.vlsolutions.swing.sample.MySplitDockApp;
import org.assertj.swing.data.TableCell;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;

public class DockingSplitDesktopTest extends TestBase {
    @Test
    public void testDockableSplitDesktop() {
        SwingUtilities.invokeLater(() -> application.setVisible(true));
        window.panel("myJTablePanel").requireVisible();
        window.panel("myTreePanel").requireVisible();
        window.panel("myTextEditorPanel").requireVisible();
        window.panel("myGridOfButtonsPanel").requireVisible();
        window.panel("myGridOfButtonsPanel").button("myGridOfButtonsButton0").requireText("btn0");
        window.panel("myJTablePanel").table().requireCellValue(TableCell.row(0).column(0), "");
        window.panel("myJTablePanel").table().requireColumnCount(5);

        window.panel("DockingPanel").panel(new PanelMatcher("DockView", 0)).panel("DockViewTitleBar")
                .label("TitleLabel").requireText("Tree");
        window.panel("DockingPanel").panel(new PanelMatcher("DockView", 1)).panel("DockViewTitleBar")
                .label("TitleLabel").requireText("The Grid of Buttons");
        window.panel("DockingPanel").panel(new PanelMatcher("DockView", 2)).panel("DockViewTitleBar")
                .label("TitleLabel").requireText("Table");

        window.panel("DockingPanel").panel(new PanelMatcher("DockView", 2)).panel("DockViewTitleBar")
                .button("DockButton").click();
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
