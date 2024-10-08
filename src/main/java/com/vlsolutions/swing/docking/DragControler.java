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

package com.vlsolutions.swing.docking;

import java.awt.Shape;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * This interface defines the features required for a drag controler.
 *
 * @since 3.0
 * @author Lilian Chamontin, vlsolutions.
 */
public interface DragControler extends MouseListener, MouseMotionListener {

    void cancelDrag();

    Dockable getDockable();

    DockDropReceiver getDropReceiver();

    Shape getDropShape();

    boolean isFloatingShape();
}
