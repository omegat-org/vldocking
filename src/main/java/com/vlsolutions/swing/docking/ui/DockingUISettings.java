/*
    VLDocking Framework 3.0
    Copyright Lilian Chamontin, 2004-2013

    www.vldocking.com
    vldocking@googlegroups.com
------------------------------------------------------------------------
This software is distributed under the LGPL license

The fact that you are presently reading this and using this class means that you have had
knowledge of the LGPL license and that you accept its terms.

You can read the complete license here :

    http://www.gnu.org/licenses/lgpl.html

 */

package com.vlsolutions.swing.docking.ui;

import com.vlsolutions.swing.toolbars.ToolBarPanelBorder;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.Objects;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.border.Border;

/**
 * Central class to manage Look and feel settings for the docking framework.
 * <p>
 * There are two ways of modifying the look and feel of the docking framework :
 * <ul>
 * <li>provide a subclass of DockingUISettings and override the getDefaults(UIDefaults table) method.
 * <li>directly put UI properties (UIManager.put(key,value)) awaited by the desktop UI delegates.
 * </ul>
 * The UI properteis are described below.
 * <table border="1">
 * <tr>
 * <th>UI property</th>
 * <th>type</th>
 * <th>effect</th>
 * </tr>
 * <tr>
 * <td>DockView.singleDockableBorder</td>
 * <td>Border</td>
 * <td>border used when the DockView is docked alone (not in a tab)</td>
 * </tr>
 * <tr>
 * <td>DockView.tabbedDockableBorder</td>
 * <td>Border</td>
 * <td>border used when the DockView is contained in a tabbed pane</td>
 * </tr>
 * <tr>
 * <td>DockView.maximizedDockableBorder</td>
 * <td>Border</td>
 * <td>border used when the DockView is maxmized</td>
 * </tr>
 * <tr>
 * <td>AutoHideButtonUI</td>
 * <td>class name</td>
 * <td>UI delegate for the AutoHideButton</td>
 * </tr>
 * <tr>
 * <td>AutoHideButtonPanelUI</td>
 * <td>class name</td>
 * <td>UI delegate for the AutoHideButtonPanel</td>
 * </tr>
 * <tr>
 * <td>AutoHideExpandPanelUI</td>
 * <td>class name</td>
 * <td>UI delegate for the AutoHideExpandPanel</td>
 * </tr>
 * <tr>
 * <td>AutoHideButton.expandBorderTop</td>
 * <td>Border</td>
 * <td>Border of the autohide button when it is on top of the desktop</td>
 * </tr>
 * <tr>
 * <td>AutoHideButton.expandBorderBottom</td>
 * <td>Border</td>
 * <td>Border of the autohide button when it is at bottom of the desktop</td>
 * </tr>
 * <tr>
 * <td>AutoHideButton.expandBorderLeft</td>
 * <td>Border</td>
 * <td>Border of the autohide button when it is on the left of the desktop</td>
 * </tr>
 * <tr>
 * <td>AutoHideButton.expandBorderRight</td>
 * <td>Border</td>
 * <td>Border of the autohide button when it is on the right of the desktop</td>
 * </tr>
 * <tr>
 * <td>AutoHideButtonPanel.topBorder</td>
 * <td>Border</td>
 * <td>Border of the AutoHideButtonPanel when it is on top of the desktop</td>
 * </tr>
 * <tr>
 * <td>AutoHideButtonPanel.bottomBorder</td>
 * <td>Border</td>
 * <td>Border of the AutoHideButtonPanel when it is at bottom of the desktop</td>
 * </tr>
 * <tr>
 * <td>AutoHideButtonPanel.leftBorder</td>
 * <td>Border</td>
 * <td>Border of the AutoHideButtonPanel when it is on the left of the desktop</td>
 * </tr>
 * <tr>
 * <td>AutoHideButtonPanel.rightBorder</td>
 * <td>Border</td>
 * <td>Border of the AutoHideButtonPanel when it is on the right of the desktop</td>
 * </tr>
 * <tr>
 * <td>DockViewUI</td>
 * <td>class name</td>
 * <td>UI delegate for DockView</td>
 * </tr>
 * <tr>
 * <td>DetachedDockViewUI</td>
 * <td>class name</td>
 * <td>UI delegate for DetachedDockView</td>
 * </tr>
 * <tr>
 * <td>DockViewTitleBarUI</td>
 * <td>class name</td>
 * <td>UI delegate for DockViewTitleBar</td>
 * </tr>
 * <tr>
 * <td>DockViewTitleBar.height</td>
 * <td>int</td>
 * <td>Height of the title bars. If set to 0, then every title bar will compute its preferred size (based on
 * fonts and icons)</td>
 * </tr>
 * <tr>
 * <td>DockViewTitleBar.closeButtonText</td>
 * <td>String</td>
 * <td>Text of the close button</td>
 * </tr>
 * <tr>
 * <td>DockViewTitleBar.minimizeButtonText</td>
 * <td>String</td>
 * <td>Text of the minimize (hide) button</td>
 * </tr>
 * <tr>
 * <td>DockViewTitleBar.maximizeButtonText</td>
 * <td>String</td>
 * <td>Text of the maximize button</td>
 * </tr>
 * <tr>
 * <td>DockViewTitleBar.restoreButtonText</td>
 * <td>String</td>
 * <td>Text of the restore button(opposite of maximize)</td>
 * </tr>
 * <tr>
 * <td>DockViewTitleBar.floatButtonText</td>
 * <td>String</td>
 * <td>Text of the float button (detach)</td>
 * </tr>
 * <tr>
 * <td>DockViewTitleBar.attachButtonText</td>
 * <td>String</td>
 * <td>Text of the attach button(opposite of float)</td>
 * </tr>
 * <tr>
 * <td>DockViewTitleBar.titleFont</td>
 * <td>Font</td>
 * <td>Font used by the title bar</td>
 * </tr>
 * <tr>
 * <td>DockViewTitleBar.isCloseButtonDisplayed</td>
 * <td>boolean</td>
 * <td>display or not the close button in the title bar (still accessible from pop-up menu)</td>
 * </tr>
 * <tr>
 * <td>DockViewTitleBar.isHideButtonDisplayed</td>
 * <td>boolean</td>
 * <td>display or not the hide button in the title bar</td>
 * </tr>
 * <tr>
 * <td>DockViewTitleBar.isDockButtonDisplayed</td>
 * <td>boolean</td>
 * <td>display or not the dock button in the title bar</td>
 * </tr>
 * <tr>
 * <td>DockViewTitleBar.isMaximizeButtonDisplayed</td>
 * <td>boolean</td>
 * <td>display or not the maximize button in the title bar</td>
 * </tr>
 * <tr>
 * <td>DockViewTitleBar.isRestoreButtonDisplayed</td>
 * <td>boolean</td>
 * <td>display or not the restore button in the title bar</td>
 * </tr>
 * <tr>
 * <td>DockViewTitleBar.isFloatButtonDisplayed</td>
 * <td>boolean</td>
 * <td>display or not the float button in the title bar</td>
 * </tr>
 * <tr>
 * <td>DockViewTitleBar.isAttachButtonDisplayed</td>
 * <td>boolean</td>
 * <td>display or not the attach button in the title bar</td>
 * </tr>
 * <tr>
 * <td>DockViewTitleBar.border</td>
 * <td>Border</td>
 * <td>Border of the title bar</td>
 * </tr>
 * <tr>
 * <td>DockingSplitPaneUI</td>
 * <td>class name</td>
 * <td>UI delegate for SplitContainer component</td>
 * </tr>
 * <tr>
 * <td>SplitContainer.dividerSize</td>
 * <td>int</td>
 * <td>Divider size of the split panes</td>
 * </tr>
 * <tr>
 * <td>TabbedDockableContainer.tabPlacement</td>
 * <td>int (SwingConstants.TOP / BOTTOM)</td>
 * <td>Global tab style</td>
 * </tr>
 * <tr>
 * <td>DockTabbedPane.closeButtonText</td>
 * <td>String</td>
 * <td>Text for the close button in tab</td>
 * </tr>
 * <tr>
 * <td>DockTabbedPane.minimizeButtonText</td>
 * <td>String</td>
 * <td>Text for the minimize button in tab</td>
 * </tr>
 * <tr>
 * <td>DockTabbedPane.restoreButtonText</td>
 * <td>String</td>
 * <td>Text for the restore button in tab</td>
 * </tr>
 * <tr>
 * <td>DockTabbedPane.maximizeButtonText</td>
 * <td>String</td>
 * <td>Text for the maximize button in tab</td>
 * </tr>
 * <tr>
 * <td>DockTabbedPane.floatButtonText</td>
 * <td>String</td>
 * <td>Text for the float button in tab</td>
 * </tr>
 * <tr>
 * <td>DockTabbedPane.attachButtonText</td>
 * <td>String</td>
 * <td>Text for the attach button in tab (when floating)</td>
 * </tr>
 * <tr>
 * <td>TabbedContainer.requestFocusOnTabSelection</td>
 * <td>boolean</td>
 * <td>Automatically puts focus on the selected tabbed component (default false)</td>
 * </tr>
 * <tr>
 * <td>TabbedPane.otherIconsGap</td>
 * <td>int</td>
 * <td>Gap between text and close icon in closeable tab</td>
 * </tr>
 * <tr>
 * <td>TabbedPane.inBetweenOtherIconsGap</td>
 * <td>int</td>
 * <td>Gap between two icons</td>
 * </tr>
 * <tr>
 * <td>DockViewTitleBar.close</td>
 * <td>Icon</td>
 * <td>Icon for the close button</td>
 * </tr>
 * <tr>
 * <td>DockViewTitleBar.close.rollover</td>
 * <td>Icon</td>
 * <td>Icon for the close button</td>
 * </tr>
 * <tr>
 * <td>DockViewTitleBar.close.pressed</td>
 * <td>Icon</td>
 * <td>Icon for the close button</td>
 * </tr>
 * <tr>
 * <td>DockViewTitleBar.dock</td>
 * <td>Icon</td>
 * <td>Icon for the dock button</td>
 * </tr>
 * <tr>
 * <td>DockViewTitleBar.dock.rollover</td>
 * <td>Icon</td>
 * <td>Icon for the dock button</td>
 * </tr>
 * <tr>
 * <td>DockViewTitleBar.dock.pressed</td>
 * <td>Icon</td>
 * <td>Icon for the dock button</td>
 * </tr>
 * <tr>
 * <td>DockViewTitleBar.hide</td>
 * <td>Icon</td>
 * <td>Icon for the hide button</td>
 * </tr>
 * <tr>
 * <td>DockViewTitleBar.hide.rollover</td>
 * <td>Icon</td>
 * <td>Icon for the hide button</td>
 * </tr>
 * <tr>
 * <td>DockViewTitleBar.hide.pressed</td>
 * <td>Icon</td>
 * <td>Icon for the hide button</td>
 * </tr>
 * <tr>
 * <td>DockViewTitleBar.maximize</td>
 * <td>Icon</td>
 * <td>Icon for the maximize button</td>
 * </tr>
 * <tr>
 * <td>DockViewTitleBar.maximize.rollover</td>
 * <td>Icon</td>
 * <td>Icon for the maximize button</td>
 * </tr>
 * <tr>
 * <td>DockViewTitleBar.maximize.pressed</td>
 * <td>Icon</td>
 * <td>Icon for the maximize button</td>
 * </tr>
 * <tr>
 * <td>DockViewTitleBar.restore</td>
 * <td>Icon</td>
 * <td>Icon for the restore button</td>
 * </tr>
 * <tr>
 * <td>DockViewTitleBar.restore.rollover</td>
 * <td>Icon</td>
 * <td>Icon for the restore button</td>
 * </tr>
 * <tr>
 * <td>DockViewTitleBar.restore.pressed</td>
 * <td>Icon</td>
 * <td>Icon for the restore button</td>
 * </tr>
 * <tr>
 * <td>DockViewTitleBar.float</td>
 * <td>Icon</td>
 * <td>Icon for the float button</td>
 * </tr>
 * <tr>
 * <td>DockViewTitleBar.float.rollover</td>
 * <td>Icon</td>
 * <td>Icon for the float button</td>
 * </tr>
 * <tr>
 * <td>DockViewTitleBar.float.pressed</td>
 * <td>Icon</td>
 * <td>Icon for the float button</td>
 * </tr>
 * <tr>
 * <td>DockViewTitleBar.attach</td>
 * <td>Icon</td>
 * <td>Icon for the attach button</td>
 * </tr>
 * <tr>
 * <td>DockViewTitleBar.attach.rollover</td>
 * <td>Icon</td>
 * <td>Icon for the attach button</td>
 * </tr>
 * <tr>
 * <td>DockViewTitleBar.attach.pressed</td>
 * <td>Icon</td>
 * <td>Icon for the attach button</td>
 * </tr>
 * <tr>
 * <td>DockViewTitleBar.menu.close</td>
 * <td>Icon</td>
 * <td>Icon for the close button, in pop-up menu</td>
 * </tr>
 * <tr>
 * <td>DockViewTitleBar.menu.hide</td>
 * <td>Icon</td>
 * <td>Icon for the hide button, in pop-up menu</td>
 * </tr>
 * <tr>
 * <td>DockViewTitleBar.menu.maximize</td>
 * <td>Icon</td>
 * <td>Icon for the maximize button, in pop-up menu</td>
 * </tr>
 * <tr>
 * <td>DockViewTitleBar.menu.restore</td>
 * <td>Icon</td>
 * <td>Icon for the restore button, in pop-up menu</td>
 * </tr>
 * <tr>
 * <td>DockViewTitleBar.menu.dock</td>
 * <td>Icon</td>
 * <td>Icon for the dock button, in pop-up menu</td>
 * </tr>
 * <tr>
 * <td>DockViewTitleBar.menu.float</td>
 * <td>Icon</td>
 * <td>Icon for the float button, in pop-up menu</td>
 * </tr>
 * <tr>
 * <td>DockViewTitleBar.menu.attach</td>
 * <td>Icon</td>
 * <td>Icon for the attach button, in pop-up menu</td>
 * </tr>
 * <tr>
 * <td>DockTabbedPane.close</td>
 * <td>Icon</td>
 * <td>Icon for the close button, in tabs</td>
 * </tr>
 * <tr>
 * <td>DockTabbedPane.close.rollover</td>
 * <td>Icon</td>
 * <td>Icon for the close button, in tabs</td>
 * </tr>
 * <tr>
 * <td>DockTabbedPane.close.pressed</td>
 * <td>Icon</td>
 * <td>Icon for the close button, in tabs</td>
 * </tr>
 * <tr>
 * <td>DockTabbedPane.menu.close</td>
 * <td>Icon</td>
 * <td>Icon for the close button, in tab pop-up menu</td>
 * </tr>
 * <tr>
 * <td>DockTabbedPane.menu.hide</td>
 * <td>Icon</td>
 * <td>Icon for the hide button, in tab pop-up menu</td>
 * </tr>
 * <tr>
 * <td>DockTabbedPane.menu.maximize</td>
 * <td>Icon</td>
 * <td>Icon for the maximize button, in tab pop-up menu</td>
 * </tr>
 * <tr>
 * <td>DockTabbedPane.menu.float</td>
 * <td>Icon</td>
 * <td>Icon for the float button, in tab pop-up menu</td>
 * </tr>
 * <tr>
 * <td>DockTabbedPane.menu.attach</td>
 * <td>Icon</td>
 * <td>Icon for the attach button, in tab pop-up menu (when floating)</td>
 * </tr>
 * <tr>
 * <td>DockTabbedPane.menu.closeAll</td>
 * <td>Icon</td>
 * <td>Icon for the "close all" button, in tab pop-up menu</td>
 * </tr>
 * <tr>
 * <td>DockTabbedPane.menu.closeAllOther</td>
 * <td>Icon</td>
 * <td>Icon for the "close all other" button, in tab pop-up menu</td>
 * </tr>
 * <tr>
 * <td>DockingDesktop.closeActionAccelerator</td>
 * <td>KeyStroke</td>
 * <td>KeyStroke for close action (on selected dockable)</td>
 * </tr>
 * <tr>
 * <td>DockingDesktop.maximizeActionAccelerator</td>
 * <td>KeyStroke</td>
 * <td>KeyStroke for maximize/restore action (on selected dockable)</td>
 * </tr>
 * <tr>
 * <td>DockingDesktop.dockActionAccelerator</td>
 * <td>KeyStroke</td>
 * <td>KeyStroke for hide/dock action (on selected dockable)</td>
 * </tr>
 * <tr>
 * <td>DockingDesktop.floatActionAccelerator</td>
 * <td>KeyStroke</td>
 * <td>KeyStroke for float/attach action (on selected dockable)</td>
 * </tr>
 * <tr>
 * <td>DockingDesktop.notificationColor</td>
 * <td>Color</td>
 * <td>blinking color for notifications</td>
 * </tr>
 * <tr>
 * <td>DockingDesktop.notificationBlinkCount</td>
 * <td>int</td>
 * <td>maximum number of blinking for notifications</td>
 * </tr>
 * <tr>
 * <td>DragControler.stopDragCursor"</td>
 * <td>Image</td>
 * <td>Cursor image used when a drag and drop move is not allowed</td>
 * </tr>
 * <tr>
 * <td>DragControler.detachCursor"</td>
 * <td>Image</td>
 * <td>Cursor image used when a drag and drop move will detach the dockable</td>
 * </tr>
 * <tr>
 * <td>DragControler.dragCursor"</td>
 * <td>Image</td>
 * <td>Cursor image used when a drag and drop move is allowed(not leading to a detached dockable)</td>
 * </tr>
 * <tr>
 * <td>DragControler.swapDragCursor</td>
 * <td>Image</td>
 * <td>Cursor image used when doing a drag and drop with Ctrl key (hot swap)</td>
 * </tr>
 * <tr>
 * <td>DragControler.isDragAndDropEnabled</td>
 * <td>Boolean</td>
 * <td>Global switch to turn on/off drag and drop support in vldocking (default set to true)</td>
 * </tr>
 * <tr>
 * <td>DragControler.paintBackgroundUnderDragRect</td>
 * <td>Boolean</td>
 * <td>Global switch to turn on/off background painting under drag shapes (which can be slow on some linux
 * distributions) (default set to true)</td>
 * </tr>
 * <tr>
 * <td>ToolBarGripperUI</td>
 * <td>class name</td>
 * <td>UI delegate for the toolbar "gripper"</td>
 * </tr>
 * <tr>
 * <td>ToolBarPanel.topBorder</td>
 * <td>Border</td>
 * <td>Border used when a toolbar in on the top of a container</td>
 * </tr>
 * <tr>
 * <td>ToolBarPanel.leftBorder</td>
 * <td>Border</td>
 * <td>Border used when a toolbar in on the left of a container</td>
 * </tr>
 * <tr>
 * <td>ToolBarPanel.bottomBorder</td>
 * <td>Border</td>
 * <td>Border used when a toolbar in at the bottom of a container</td>
 * </tr>
 * <tr>
 * <td>ToolBarPanel.rightBorder</td>
 * <td>Border</td>
 * <td>Border used when a toolbar in on the right of a container</td>
 * </tr>
 * <tr>
 * <td>FloatingDialog.dialogBorder</td>
 * <td>Border</td>
 * <td>Border used for the FloatingDialog</td>
 * </tr>
 * <tr>
 * <td>FloatingDialog.titleBorder</td>
 * <td>Border</td>
 * <td>Border used for the title (drag header) of the FloatingDialog</td>
 * </tr>
 * <tr>
 * <td>FloatingContainer.followParentWindow</td>
 * <td>Boolean</td>
 * <td>if true, the floating dialogs will follow the movements of their parent window on screen</td>
 * </tr>
 * <tr>
 * <td>FloatingContainer.paintDragShape</td>
 * <td>Boolean</td>
 * <td>if true, a drag outline shape will follow the mouse when dragging</td>
 * </tr>
 * </table>
 *
 * @author Lilian Chamontin, VLSolutions
 */
public class DockingUISettings {

    static DockingUISettings instance = null;

    /** Field for installing settings only once */
    protected boolean isSettingsInstalled = false;

    public DockingUISettings() {
    }

    /**
     * returns the singleton instance used to store and install UI settings for the framework
     */
    public static DockingUISettings getInstance() {
        // give a chance to subclassers to install their own subclass instance
        if (instance == null) {
            instance = new DockingUISettings();
        }
        return instance;
    }

    /**
     * Allows replacement of the settings instance (used to override global look and feel settings of the
     * framework.
     * <p>
     * This method must be called before DockingDesktop is referenced, as the settings are statically
     * installed at that moment.
     */
    public static void setInstance(DockingUISettings newInstance) {
        instance = newInstance;
    }

    /**
     * Installs the UI settings. This is executed only once, and automatically called at DockingDesktop class
     * loading in case it was not called by the application.
     */
    public void installUI() {
        if (!isSettingsInstalled) {
            installUI(getDefaults());
            isSettingsInstalled = true;
        }
    }

    protected UIDefaults getDefaults(UIDefaults table) {
        getColors(table); // should call getColors first.
        getAutoHideSettings(table);
        getBorderSettings(table);
        getDockViewSettings(table);
        getDockViewTitleBarSettings(table);
        getSplitContainerSettings(table);
        getCloseableTabs(table);
        getTabbedContainerSettings(table);
        getIcons(table);
        getAccelerators(table);
        getDesktopSettings(table);
        getFloatingSettings(table);
        getToolBarSettings(table);
        return table;
    }

    protected void installUI(UIDefaults table) {
        installColors(table);
        installAutoHideSettings(table);
        installBorderSettings(table);
        installDockViewSettings(table);
        installDockViewTitleBarSettings(table);
        installSplitContainerSettings(table);
        installCloseableTabs(table);
        installTabbedContainerSettings(table);
        installIcons(table);
        installAccelerators(table);
        installDesktopSettings(table);
        installFloatingSettings(table);
        installToolBarSettings(table);
        isSettingsInstalled = true;
    }

    /**
     * Allows updating of the ui after a look and feel change.
     * <p>
     * The Docking framework uses references of UI elements from this class to install its UI according to the
     * look and feel. When Laf is changed, and before calling
     * SwingUtilities.updateComponentTreeUI(topLevelComponent), invoke updateUI() in order to reset
     * everything.
     * <p>
     * Calling this method after SwingUtilities.updateComponentTreeUI(topLevelComponent) is unspecified (some
     * things will be updated, others not).
     */
    @Deprecated
    public void updateUI() {
        isSettingsInstalled = false;
        installUI();
    }

    /** installs the borders */
    @Deprecated
    public void installBorderSettings() {
        installBorderSettings(getDefaults());
    }

    /** installs the autohide related properties */
    @Deprecated
    public void installAutoHideSettings() {
        installAutoHideSettings(getDefaults());
    }

    @Deprecated
    public void installDockViewSettings() {
        installDockViewSettings(getDefaults());
    }

    @Deprecated
    public void installDockViewTitleBarSettings() {
        installDockViewTitleBarSettings(getDefaults());
    }

    /** installs the splitpanes related properties */
    @Deprecated
    public void installSplitContainerSettings() {
        installSplitContainerSettings(getDefaults());
    }

    /** installs the tabbed pane related properties */
    @Deprecated
    public void installTabbedContainerSettings() {
        installTabbedContainerSettings(getDefaults());
    }

    @Deprecated
    public void installCloseableTabs() {
        installCloseableTabs(getDefaults());
    }

    /** installs icons used by the framework */
    @Deprecated
    public void installIcons() {
        installIcons(getDefaults());
    }

    /** installs the eyboard shortcuts */
    @Deprecated
    public void installAccelerators() {
        installAccelerators(getDefaults());
    }

    /** installs the DockinDesktop related properties */
    @Deprecated
    public void installDesktopSettings() {
        installDesktopSettings(getDefaults());
    }

    /** installs the FloatingDialog related properties */
    @Deprecated
    public void installFloatingSettings() {
        installFloatingSettings(getDefaults());
    }

    /** installs the toolbar related properties */
    @Deprecated
    public void installToolBarSettings() {
        installToolBarSettings(getDefaults());
    }

    // ==== Private methods

    private UIDefaults getDefaults() {
        return getDefaults(UIManager.getDefaults());
    }

    private void getBorderSettings(UIDefaults table) {
        // this is for the "flat style" (comment this line, or put a FALSE to
        // revert to "shadow style"

        // flat style is the default
        // (outside: empty 1 pix /
        // inside: highlight-top-left + shadow-bottom-right
        if (table.get("DockView.singleDockableBorder") == null) {
            final Color shadow = table.getColor("VLDocking.shadow");
            final Color highlight = table.getColor("VLDocking.highlight");

            Border innerFlatSingleBorder = BorderFactory.createCompoundBorder(
                    BorderFactory.createMatteBorder(1, 1, 0, 0, highlight),
                    BorderFactory.createMatteBorder(0, 0, 1, 1, shadow));
            Border flatSingleBorder = BorderFactory
                    .createCompoundBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1), innerFlatSingleBorder);

            table.put("DockView.singleDockableBorder", flatSingleBorder);
            table.put("DockView.tabbedDockableBorder", null);
            table.put("DockView.maximizedDockableBorder", null);
        }
    }

    private void installBorderSettings(UIDefaults table) {
        putValue(table, "DockView.singleDockableBorder");
        putValue(table, "DockView.tabbedDockableBorder");
        putValue(table, "DockView.maximizedDockableBorder");
    }

    private void getAutoHideSettings(UIDefaults table) {
        table.putIfAbsent("AutoHideButtonUI", "com.vlsolutions.swing.docking.ui.AutoHideButtonUI");
        table.putIfAbsent("AutoHideButtonPanelUI", "com.vlsolutions.swing.docking.ui.AutoHideButtonPanelUI");
        table.putIfAbsent("AutoHideExpandPanelUI", "com.vlsolutions.swing.docking.ui.AutoHideExpandPanelUI");

        final Color shadow = table.getColor("VLDocking.shadow");
        final Color highlight = table.getColor("VLDocking.highlight");

        table.putIfAbsent("AutoHideButton.expandBorderTop", BorderFactory.createCompoundBorder(
                BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(1, 1, 0, 1, shadow),
                        BorderFactory.createMatteBorder(1, 1, 0, 1, highlight)),
                BorderFactory.createEmptyBorder(0, 6, 0, 6)));
        table.putIfAbsent("AutoHideButton.expandBorderBottom", BorderFactory.createCompoundBorder(
                BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, shadow),
                        BorderFactory.createMatteBorder(0, 1, 1, 1, highlight)),
                BorderFactory.createEmptyBorder(0, 6, 0, 6)));
        table.putIfAbsent("AutoHideButton.expandBorderLeft", BorderFactory.createCompoundBorder(
                BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(1, 1, 1, 0, shadow),
                        BorderFactory.createMatteBorder(1, 1, 1, 0, highlight)),
                BorderFactory.createEmptyBorder(6, 0, 6, 0)));
        table.putIfAbsent("AutoHideButton.expandBorderRight", BorderFactory.createCompoundBorder(
                BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(1, 0, 1, 1, shadow),
                        BorderFactory.createMatteBorder(1, 0, 1, 1, highlight)),
                BorderFactory.createEmptyBorder(6, 0, 6, 0)));

        table.putIfAbsent("AutoHideButtonPanel.topBorder",
                BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(1, 0, 0, 0),
                        BorderFactory.createMatteBorder(0, 0, 1, 0, shadow)));
        table.putIfAbsent("AutoHideButtonPanel.bottomBorder",
                BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(0, 0, 1, 0),
                        BorderFactory.createMatteBorder(1, 0, 0, 0, shadow)));

        table.putIfAbsent("AutoHideButtonPanel.leftBorder",
                BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(0, 1, 0, 1),
                        BorderFactory.createMatteBorder(0, 0, 0, 1, shadow)));
        table.putIfAbsent("AutoHideButtonPanel.rightBorder",
                BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(0, 1, 0, 1),
                        BorderFactory.createMatteBorder(0, 1, 0, 0, shadow)));

        table.putIfAbsent("AutoHideButton.font", table.get("MenuItem.font")); // 2006/01/23
    }

    private void installAutoHideSettings(UIDefaults table) {
        putValue(table, "AutoHideButtonUI");
        putValue(table, "AutoHideButtonPanelUI");
        putValue(table, "AutoHideExpandPanelUI");
        putValue(table, "AutoHideButton.expandBorderTop");
        putValue(table, "AutoHideButton.expandBorderBottom");

        putValue(table, "AutoHideButton.expandBorderLeft");
        putValue(table, "AutoHideButton.expandBorderRight");
        putValue(table, "AutoHideButtonPanel.topBorder");
        putValue(table, "AutoHideButtonPanel.bottomBorder");
        putValue(table, "AutoHideButtonPanel.leftBorder");
        putValue(table, "AutoHideButtonPanel.rightBorder");
        putValue(table, "AutoHideButton.font");
    }

    private void getDockViewSettings(UIDefaults table) {
        table.putIfAbsent("DockViewUI", "com.vlsolutions.swing.docking.ui.DockViewUI");
        table.putIfAbsent("DetachedDockViewUI", "com.vlsolutions.swing.docking.ui.DetachedDockViewUI");
    }

    /** installs the DockView related properties */
    private void installDockViewSettings(UIDefaults table) {
        putValue(table, "DockViewUI");
        putValue(table, "DetachedDockViewUI");
    }

    /** installs the DockVieTitleBar related properties */
    private void getDockViewTitleBarSettings(UIDefaults table) {
        table.putIfAbsent("DockViewTitleBarUI", "com.vlsolutions.swing.docking.ui.DockViewTitleBarUI");

        table.putIfAbsent("DockViewTitleBar.height", 20);
        table.putIfAbsent("DockViewTitleBar.closeButtonText",
                table.getString("InternalFrameTitlePane.closeButtonText"));
        table.putIfAbsent("DockViewTitleBar.minimizeButtonText",
                table.getString("InternalFrameTitlePane.minimizeButtonText"));
        table.putIfAbsent("DockViewTitleBar.restoreButtonText",
                table.getString("InternalFrameTitlePane.restoreButtonText"));
        table.putIfAbsent("DockViewTitleBar.maximizeButtonText",
                table.getString("InternalFrameTitlePane.maximizeButtonText"));
        table.putIfAbsent("DockViewTitleBar.floatButtonText", "Detach");
        table.putIfAbsent("DockViewTitleBar.attachButtonText", "Attach");

        // font to be used in the title bar
        table.putIfAbsent("DockViewTitleBar.titleFont", table.get("InternalFrame.titleFont"));

        // are buttons displayed or just accessible from the contextual menu ?
        // setting one of these flags to false hide the button from the title
        // bar
        // setting to true not necessarily shows the button, as it then depends
        // on the DockKey allowed states.
        table.putIfAbsent("DockViewTitleBar.isCloseButtonDisplayed", Boolean.TRUE);
        table.putIfAbsent("DockViewTitleBar.isHideButtonDisplayed", Boolean.TRUE);
        table.putIfAbsent("DockViewTitleBar.isDockButtonDisplayed", Boolean.TRUE);
        table.putIfAbsent("DockViewTitleBar.isMaximizeButtonDisplayed", Boolean.TRUE);
        table.putIfAbsent("DockViewTitleBar.isRestoreButtonDisplayed", Boolean.TRUE);
        table.putIfAbsent("DockViewTitleBar.isFloatButtonDisplayed", Boolean.TRUE);
        table.putIfAbsent("DockViewTitleBar.isAttachButtonDisplayed", Boolean.TRUE);

        if (table.get("DockViewTitleBar.border") == null) {
            final Color shadow = table.getColor("controlShadow");
            table.put("DockViewTitleBar.border", BorderFactory.createMatteBorder(0, 0, 1, 0, shadow));
        }
    }

    private void installDockViewTitleBarSettings(UIDefaults table) {
        putValue(table, "DockViewTitleBarUI");
        putValue(table, "DockViewTitleBar.height");
        putValue(table, "DockViewTitleBar.closeButtonText");
        putValue(table, "DockViewTitleBar.minimizeButtonText");
        putValue(table, "DockViewTitleBar.restoreButtonText");
        putValue(table, "DockViewTitleBar.maximizeButtonText");
        putValue(table, "DockViewTitleBar.floatButtonText");
        putValue(table, "DockViewTitleBar.attachButtonText");
        putValue(table, "DockViewTitleBar.titleFont");
        putValue(table, "DockViewTitleBar.isCloseButtonDisplayed");
        putValue(table, "DockViewTitleBar.isHideButtonDisplayed");
        putValue(table, "DockViewTitleBar.isDockButtonDisplayed");
        putValue(table, "DockViewTitleBar.isMaximizeButtonDisplayed");
        putValue(table, "DockViewTitleBar.isRestoreButtonDisplayed");
        putValue(table, "DockViewTitleBar.isFloatButtonDisplayed");
        putValue(table, "DockViewTitleBar.isAttachButtonDisplayed");
        putValue(table, "DockViewTitleBar.border");
    }

    private void getSplitContainerSettings(UIDefaults table) {
        table.putIfAbsent("DockingSplitPaneUI", "com.vlsolutions.swing.docking.ui.DockingSplitPaneUI");
        table.putIfAbsent("SplitContainer.dividerSize", 4);
        table.putIfAbsent("SplitContainer.isResizingEnabled", Boolean.TRUE); // 2007/08/11
    }

    private void installSplitContainerSettings(UIDefaults table) {
        putValue(table, "DockingSplitPaneUI");
        putValue(table, "SplitContainer.dividerSize");
        putValue(table, "SplitContainer.isResizingEnabled");
    }

    private void getTabbedContainerSettings(UIDefaults table) {
        table.putIfAbsent("TabbedDockableContainer.tabPlacement", SwingConstants.TOP);

        table.putIfAbsent("DockTabbedPane.closeButtonText",
                table.getString("InternalFrameTitlePane.closeButtonText"));
        table.putIfAbsent("DockTabbedPane.minimizeButtonText",
                table.getString("InternalFrameTitlePane.minimizeButtonText"));
        table.putIfAbsent("DockTabbedPane.restoreButtonText",
                table.getString("InternalFrameTitlePane.restoreButtonText"));
        table.putIfAbsent("DockTabbedPane.maximizeButtonText",
                table.getString("InternalFrameTitlePane.maximizeButtonText"));
        table.putIfAbsent("DockTabbedPane.floatButtonText", "Detach");
        table.putIfAbsent("DockTabbedPane.attachButtonText", "Attach"); // 2005/10/07

        table.putIfAbsent("JTabbedPaneSmartIcon.font", table.getFont("TabbedPane.font")); // 2006/01/23

        // set to true to set focus directly into a tabbed component when it
        // becomes
        // selected
        table.putIfAbsent("TabbedContainer.requestFocusOnTabSelection", Boolean.FALSE);
    }

    private void installTabbedContainerSettings(UIDefaults table) {
        putValue(table, "TabbedDockableContainer.tabPlacement");
        putValue(table, "DockTabbedPane.closeButtonText");
        putValue(table, "DockTabbedPane.minimizeButtonText");
        putValue(table, "DockTabbedPane.restoreButtonText");
        putValue(table, "DockTabbedPane.maximizeButtonText");
        putValue(table, "DockTabbedPane.floatButtonText");
        putValue(table, "DockTabbedPane.attachButtonText");
        putValue(table, "DockTabbedPane.titleFont");
        putValue(table, "TabbedContainer.requestFocusOnTabSelection");
    }

    private void getCloseableTabs(UIDefaults table) {
        // this one is already provided by the look and feel
        // UIManager.put("TabbedPane.textIconGap", new Integer(4));
        table.putIfAbsent("TabbedPane.otherIconsGap", 8);
        table.putIfAbsent("TabbedPane.inBetweenOtherIconsGap", 4);
        table.putIfAbsent("TabbedPane.alternateTabIcons", Boolean.FALSE);
    }

    /** installs the closable tabs properties */
    private void installCloseableTabs(UIDefaults table) {
        putValue(table, "TabbedPane.otherIconsGap");
        putValue(table, "TabbedPane.inBetweenOtherIconsGap");
        putValue(table, "TabbedPane.alternateTabIcons");
    }

    private void getIcons(UIDefaults table) {
        setIcon(table, "DockViewTitleBar.close", "close16v2.png");
        setIcon(table, "DockViewTitleBar.close.rollover", "close16v2rollover.png");
        setIcon(table, "DockViewTitleBar.close.pressed", "close16v2pressed.png");
        setIcon(table, "DockViewTitleBar.closeTab", "close16tab.png");
        setIcon(table, "DockViewTitleBar.closeTab.rollover", "close16tabRollover.png");
        setIcon(table, "DockViewTitleBar.closeTab.pressed", "close16tabPressed.png");

        setIcon(table, "DockViewTitleBar.dock", "dock16v2.png");
        setIcon(table, "DockViewTitleBar.dock.rollover", "dock16v2rollover.png");
        setIcon(table, "DockViewTitleBar.dock.pressed", "dock16v2pressed.png");

        setIcon(table, "DockViewTitleBar.hide", "hide16v2.png");
        setIcon(table, "DockViewTitleBar.hide.rollover", "hide16v2rollover.png");
        setIcon(table, "DockViewTitleBar.hide.pressed", "hide16v2pressed.png");

        setIcon(table, "DockViewTitleBar.maximize", "maximize16v2.png");
        setIcon(table, "DockViewTitleBar.maximize.pressed", "maximize16v2pressed.png");
        setIcon(table, "DockViewTitleBar.maximize.rollover", "maximize16v2rollover.png");

        setIcon(table, "DockViewTitleBar.restore", "restore16v2.png");
        setIcon(table, "DockViewTitleBar.restore.pressed", "restore16v2pressed.png");
        setIcon(table, "DockViewTitleBar.restore.rollover", "restore16v2rollover.png");

        setIcon(table, "DockViewTitleBar.float", "float16v2.png");
        setIcon(table, "DockViewTitleBar.float.rollover", "float16v2rollover.png");
        setIcon(table, "DockViewTitleBar.float.pressed", "float16v2pressed.png");

        setIcon(table, "DockViewTitleBar.attach", "attach16v2.png");
        setIcon(table, "DockViewTitleBar.attach.rollover", "attach16v2rollover.png");
        setIcon(table, "DockViewTitleBar.attach.pressed", "attach16v2pressed.png");

        setIcon(table, "DockViewTitleBar.menu.close", "close16v2rollover.png");
        setIcon(table, "DockViewTitleBar.menu.hide", "hide16v2rollover.png");
        setIcon(table, "DockViewTitleBar.menu.maximize", "maximize16v2rollover.png");
        setIcon(table, "DockViewTitleBar.menu.restore", "restore16v2rollover.png");
        setIcon(table, "DockViewTitleBar.menu.dock", "dock16v2rollover.png");
        setIcon(table, "DockViewTitleBar.menu.float", "float16v2rollover.png");
        setIcon(table, "DockViewTitleBar.menu.attach", "attach16v2rollover.png");

        setIcon(table, "DockTabbedPane.close", "close16v2.png");
        setIcon(table, "DockTabbedPane.close.rollover", "close16v2rollover.png");
        setIcon(table, "DockTabbedPane.close.pressed", "close16v2pressed.png");

        // table.putIfAbsent("DockTabbedPane.unselected_close", null); // 2005/11/14
        setIcon(table, "DockTabbedPane.unselected_close.rollover", "close16v2rollover.png");
        setIcon(table, "DockTabbedPane.unselected_close.pressed", "close16v2pressed.png");

        setIcon(table, "DockTabbedPane.menu.close", "close16v2rollover.png");
        setIcon(table, "DockTabbedPane.menu.hide", "hide16v2rollover.png");
        setIcon(table, "DockTabbedPane.menu.maximize", "maximize16v2rollover.png");
        setIcon(table, "DockTabbedPane.menu.float", "float16v2rollover.png");
        setIcon(table, "DockTabbedPane.closeAll", "closeAll16.png");
        setIcon(table, "DockTabbedPane.closeAllOther", "closeAllOther16.png");
        setIcon(table, "DockTabbedPane.menu.attach", "attach16v2rollover.png");
    }

    private void installIcons(UIDefaults table) {
        putValue(table, "DockViewTitleBar.close");
        putValue(table, "DockViewTitleBar.close.rollover");
        putValue(table, "DockViewTitleBar.close.pressed");
        putValue(table, "DockViewTitleBar.closeTab");
        putValue(table, "DockViewTitleBar.closeTab.rollover");
        putValue(table, "DockViewTitleBar.closeTab.pressed");
        putValue(table, "DockViewTitleBar.dock");
        putValue(table, "DockViewTitleBar.dock.rollover");
        putValue(table, "DockViewTitleBar.dock.pressed");
        putValue(table, "DockViewTitleBar.hide");
        putValue(table, "DockViewTitleBar.hide.rollover");
        putValue(table, "DockViewTitleBar.hide.pressed");
        putValue(table, "DockViewTitleBar.maximize");
        putValue(table, "DockViewTitleBar.maximize.pressed");
        putValue(table, "DockViewTitleBar.maximize.rollover");
        putValue(table, "DockViewTitleBar.restore");
        putValue(table, "DockViewTitleBar.restore.pressed");
        putValue(table, "DockViewTitleBar.restore.rollover");
        putValue(table, "DockViewTitleBar.float");
        putValue(table, "DockViewTitleBar.float.rollover");
        putValue(table, "DockViewTitleBar.float.pressed");
        putValue(table, "DockViewTitleBar.attach");
        putValue(table, "DockViewTitleBar.attach.rollover");
        putValue(table, "DockViewTitleBar.attach.pressed");
        putValue(table, "DockViewTitleBar.menu.close");
        putValue(table, "DockViewTitleBar.menu.hide");
        putValue(table, "DockViewTitleBar.menu.maximize");
        putValue(table, "DockViewTitleBar.menu.restore");
        putValue(table, "DockViewTitleBar.menu.dock");
        putValue(table, "DockViewTitleBar.menu.float");
        putValue(table, "DockViewTitleBar.menu.attach");
        putValue(table, "DockTabbedPane.close");
        putValue(table, "DockTabbedPane.close.rollover");
        putValue(table, "DockTabbedPane.close.pressed");
        putValue(table, "DockTabbedPane.unselected_close");
        putValue(table, "DockTabbedPane.unselected_close.rollover");
        putValue(table, "DockTabbedPane.unselected_close.pressed");
        putValue(table, "DockTabbedPane.menu.close");
        putValue(table, "DockTabbedPane.menu.hide");
        putValue(table, "DockTabbedPane.menu.maximize");
        putValue(table, "DockTabbedPane.menu.float");
        putValue(table, "DockTabbedPane.closeAll");
        putValue(table, "DockTabbedPane.closeAllOther");
        putValue(table, "DockTabbedPane.menu.attach");
    }

    private void getAccelerators(UIDefaults table) {
        final int mask = Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx();
        setAccelerators(table, "DockingDesktop.closeActionAccelerator", KeyEvent.VK_F4, mask);
        // toggle maximize/restore
        setAccelerators(table, "DockingDesktop.maximizeActionAccelerator", KeyEvent.VK_ESCAPE,
                KeyEvent.SHIFT_DOWN_MASK);
        // toggle autohide/dock
        setAccelerators(table, "DockingDesktop.dockActionAccelerator", KeyEvent.VK_BACK_SPACE, mask);
        setAccelerators(table, "DockingDesktop.floatActionAccelerator", KeyEvent.VK_F5, mask);
    }

    private void installAccelerators(UIDefaults table) {
        putValue(table, "DockingDesktop.closeActionAccelerator");
        putValue(table, "DockingDesktop.maximizeActionAccelerator");
        putValue(table, "DockingDesktop.dockActionAccelerator");
        putValue(table, "DockingDesktop.floatActionAccelerator");
    }

    private void getDesktopSettings(UIDefaults table) {
        table.putIfAbsent("DockingDesktop.notificationColor", Color.ORANGE);
        table.putIfAbsent("DockingDesktop.notificationBlinkCount", 5);
        setImage(table, "DragControler.stopDragCursor", "stopdragcursor.gif");
        setImage(table, "DragControler.detachCursor", "detachCursor.png");
        setImage(table, "DragControler.dragCursor", "dragcursor.gif");
        setImage(table, "DragControler.swapDragCursor", "swapdragcursor.gif");
        table.putIfAbsent("DragControler.isDragAndDropEnabled", Boolean.TRUE);
        table.putIfAbsent("DragControler.paintBackgroundUnderDragRect", Boolean.FALSE);
    }

    private void installDesktopSettings(UIDefaults table) {
        putValue(table, "DockingDesktop.notificationColor");
        putValue(table, "DockingDesktop.notificationBlinkCount");
        putValue(table, "DragControler.stopDragCursor");
        putValue(table, "DragControler.detachCursor");
        putValue(table, "DragControler.dragCursor");
        putValue(table, "DragControler.swapDragCursor");
        putValue(table, "DragControler.isDragAndDropEnabled");
        putValue(table, "DragControler.paintBackgroundUnderDragRect");
    }

    private void getFloatingSettings(UIDefaults table) {
        // Because these values are null in default, don't override
        // - table.put("FloatingDialog.dialogBorder", null);
        // - table.put("FloatingDialog.titleBorder", null);
        table.putIfAbsent("FloatingContainer.followParentWindow", Boolean.TRUE);
        table.putIfAbsent("FloatingContainer.paintDragShape", Boolean.TRUE);
    }

    private void installFloatingSettings(UIDefaults table) {
        putValue(table, "FloatingDialog.dialogBorder");
        putValue(table, "FloatingDialog.titleBorder");
        putValue(table, "FloatingContainer.followParentWindow");
        putValue(table, "FloatingContainer.paintDragShape");
    }

    private void getToolBarSettings(UIDefaults table) {
        table.putIfAbsent("ToolBarGripperUI", "com.vlsolutions.swing.toolbars.ToolBarGripperUI");
        // borders to use with toolbarpanels depending on their position
        setBorder(table, "ToolBarPanel.topBorder", ToolBarPanelBorder.TOP_PANEL);
        setBorder(table, "ToolBarPanel.leftBorder", ToolBarPanelBorder.LEFT_PANEL);
        setBorder(table, "ToolBarPanel.bottomBorder", ToolBarPanelBorder.BOTTOM_PANEL);
        setBorder(table, "ToolBarPanel.rightBorder", ToolBarPanelBorder.RIGHT_PANEL);
    }

    private void installToolBarSettings(UIDefaults table) {
        putValue(table, "ToolBarGripperUI");
        putValue(table, "ToolBarPanel.topBorder");
        putValue(table, "ToolBarPanel.leftBorder");
        putValue(table, "ToolBarPanel.bottomBorder");
        putValue(table, "ToolBarPanel.rightBorder");
    }

    private void getColors(UIDefaults table) {
        if (table.get("VLDocking.shadow") == null) {
            Color shadow = table.getColor("controlShadow");
            if (shadow == null) {
                shadow = Color.GRAY;
            }
            table.put("VLDocking.shadow", shadow);
        }
        if (table.get("VLDocking.highlight") == null) {
            Color highlight = table.getColor("controlLtHighlight");
            if (highlight == null) {
                highlight = table.getColor("VLDocking.shadow").brighter();
            }
            table.put("VLDocking.highlight", highlight);
        }
    }

    private void installColors(UIDefaults table) {
        putValue(table, "VLDocking.shadow");
        putValue(table, "VLDocking.highlight");
    }

    private void putValue(UIDefaults table, String key) {
        UIManager.put(key, table.get(key));
    }

    private void setBorder(UIDefaults table, String key, int border) {
        if (table.get(key) == null) {
            table.put(key, new ToolBarPanelBorder(border));
        }
    }

    private void setAccelerators(UIDefaults table, String key, int keyEvent, int mask) {
        if (table.get(key) == null) {
            table.put(key, KeyStroke.getKeyStroke(keyEvent, mask));
        }
    }

    private void setIcon(UIDefaults table, String key, String resName) {
        if (table.get(key) == null) {
            table.put(key, getIconByName(resName));
        }
    }

    private void setImage(UIDefaults table, String key, String resName) {
        if (table.get(key) == null) {
            table.put(key, getImageByName(resName));
        }
    }

    private ImageIcon getIconByName(String resName) {
        final String prefix = "/com/vlsolutions/swing/docking/";
        return new ImageIcon(Objects.requireNonNull(getClass().getResource(prefix + resName)));
    }

    private Image getImageByName(String resName) {
        return getIconByName(resName).getImage();
    }
}
