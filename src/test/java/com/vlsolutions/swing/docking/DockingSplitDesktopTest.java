package com.vlsolutions.swing.docking;

import com.vlsolutions.swing.sample.MySplitDockApp;
import org.assertj.swing.core.GenericTypeMatcher;
import org.assertj.swing.data.TableCell;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.junit.testcase.AssertJSwingJUnitTestCase;
import org.junit.Test;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.Dimension;


public class DockingSplitDesktopTest extends AssertJSwingJUnitTestCase {

    protected FrameFixture window;
    protected MySplitDockApp application;

    @Override
    protected void onSetUp() {
        application = GuiActionRunner.execute(() -> {
            MySplitDockApp frame = new MySplitDockApp();
            frame.setPreferredSize(new Dimension(800, 600));
            frame.setMinimumSize(new Dimension(800, 600));
            frame.validate();
            return frame;
        });
        window = new FrameFixture(robot(), application);
        window.show();
    }

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

        window.panel("DockingPanel").panel(new PanelMatcher("DockView", 0))
                .panel("DockViewTitleBar").label("TitleLabel").requireText("The tree");
        window.panel("DockingPanel").panel(new PanelMatcher("DockView", 1))
                .panel("DockViewTitleBar").label("TitleLabel").requireText("The Grid of Buttons");
        window.panel("DockingPanel").panel(new PanelMatcher("DockView", 2))
                .panel("DockViewTitleBar").label("TitleLabel").requireText("The table");

        window.panel("DockingPanel").panel(new PanelMatcher("DockView", 2))
                .panel("DockViewTitleBar").button("DockButton").click();
        window.panel("AutoHideButtonPanel").label(new AutoHideButtonMatcher("AutoHideButton", 0)).click();
        window.panel("AutoHideExpandPanel").panel("DockViewTitleBar").label("TitleLabel").requireText("The table");
        window.panel("AutoHideExpandPanel").panel("DockViewTitleBar").button("DockButton").click();
    }

    private static class AutoHideButtonMatcher extends GenericTypeMatcher<JLabel> {
        private final String name;
        private final int index;
        private int count = 0;

        public AutoHideButtonMatcher(String name, int index) {
            super(JLabel.class);
            this.name = name;
            this.index = index;
        }

        @Override
        protected boolean isMatching(JLabel button) {
            return name.equals(button.getName()) && count++ == index;
        }
    }

    private static class PanelMatcher extends GenericTypeMatcher<JPanel> {
        private final String name;
        private final int index;
        private int count = 0;

        public PanelMatcher(String name, int index) {
            super(JPanel.class);
            this.name = name;
            this.index = index;
        }

        @Override
        protected boolean isMatching(JPanel jPanel) {
            return name.equals(jPanel.getName()) && count++ == index;
        }
    }
}
