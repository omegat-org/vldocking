package com.vlsolutions.swing.docking;

import com.vlsolutions.swing.TestBase;
import org.assertj.swing.data.TableCell;
import org.junit.Test;

import javax.swing.SwingUtilities;

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
                .label("TitleLabel").requireText("The tree");
        window.panel("DockingPanel").panel(new PanelMatcher("DockView", 1)).panel("DockViewTitleBar")
                .label("TitleLabel").requireText("The Grid of Buttons");
        window.panel("DockingPanel").panel(new PanelMatcher("DockView", 2)).panel("DockViewTitleBar")
                .label("TitleLabel").requireText("The table");

        window.panel("DockingPanel").panel(new PanelMatcher("DockView", 2)).panel("DockViewTitleBar")
                .button("DockButton").click();
    }
}
