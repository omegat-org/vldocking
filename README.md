# vldocking

This is a fork of https://github.com/cmadsen/vldocking, a fork of https://bitbucket.org/akuhtz/vldocking

## Why?

Because upstream appears to have been abandoned, but bug fixes and new features were desired for [OmegaT](http://www.omegat.org/).

See https://code.google.com/p/vldocking/ for more information.

## So what's new?

* Switched to Gradle
* Made an important fix for Linux (see https://github.com/cmadsen/vldocking/pull/9)
* Additional customization:
  * The background of `AutoHideButton`s is now customizable via the `AutoHideButton.background` key for `UIManager` (`Color` value)
  * The background of `AutoHideButtonPanel` is now customizable via the `AutoHideButtonPanel.background` key for `UIManager` (`Color` value)
  * Disable the gradient on `DockViewTitleBar` via the `DockViewTitleBar.disableCustomPaint` key for `UIManager` (`Boolean` value)
  * The border of the main `DockingDesktop` component can be set via the `DockingDesktop.border` key for `UIManager` (`Border` value)
* Allow customization with key-value in `UIDefaults defaults = UIManager.getDefaults()` table in `LookAndFeel#getDefaults`.
* Released version 3.1.0 with the above changes
* More changes in CHANGELOG.md

Changes introduced by cmadsen/vldocking:

* Renamed package names to use old vlsolutions instead of vldocking
* Fixed issues with read/wrilXML on multiple screens
* Added new empty ctor to `FloatingDialog` to make floating windows appear in taskbar. Extend `DefaultDockableContainerFactory.createFloatingDockableContainer` and return `new FloatingDialog()`
* Fixed LAF issues, e.g., when switching Substance skin
* Fixed issue with borders not being set on single dock windows until an ancestor change events occurred

## How to get the released versions?

### Maven Central

Add this to your `build.gradle` file's `dependencies` block:

```
implementation 'org.omegat:vldocking:3.1.1'
```

VLDocking, the swing docking framework

The VLDocking framework is a commercial-grade Swing Framework providing rich docking features
which can easily be integrated with existing applications (and of course, new ones).

VLDocking was created in 2004, and is licensed under the LGPL-3.0.

![](https://vldocking.readthedocs.io/en/latest/vldocking3.jpg)

License and copyright
=====================

VLDocking is licensed under GNU LESSER GENERAL PUBLIC LICENSE version 3.0 or later (as your choice).
VLDocking was initially designed by Lilian Chamontin at his former company VLSolutions. 

Documentation
============

The VLDocking tutorial can be found here https://vldocking.readthedocs.io/en/latest/

## I found a bug; what can I do?

Feel free to fork this repo, and make a "pull request": http://help.github.com/send-pull-requests/.
Ideally, write a test!
 
