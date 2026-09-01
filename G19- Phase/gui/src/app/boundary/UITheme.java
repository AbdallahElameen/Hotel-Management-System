package app.boundary;

import java.awt.Color;
import java.awt.Font;

// Shared colour palette and font choices so every form uses the same look.
public final class UITheme {

    private UITheme() { }

    public static final Color PRIMARY        = new Color(26, 42, 74);
    public static final Color PRIMARY_LIGHT  = new Color(45, 69, 117);
    public static final Color ACCENT         = new Color(182, 136, 60);

    public static final Color SUCCESS        = new Color(40, 141, 80);
    public static final Color INFO           = new Color(23, 126, 192);
    public static final Color WARNING        = new Color(214, 158, 46);
    public static final Color DANGER         = new Color(192, 57, 43);

    public static final Color SURFACE_BG     = new Color(244, 246, 250);
    public static final Color SURFACE_CARD   = new Color(255, 255, 255);
    public static final Color TEXT_MUTED     = new Color(108, 117, 125);
    public static final Color TEXT_HEADING   = PRIMARY;
    public static final Color DIVIDER        = new Color(221, 226, 233);

    public static final Font FONT_TITLE      = new Font("SansSerif", Font.BOLD,   24);
    public static final Font FONT_HEADING    = new Font("SansSerif", Font.BOLD,   18);
    public static final Font FONT_SUBTITLE   = new Font("SansSerif", Font.ITALIC, 13);
    public static final Font FONT_LABEL      = new Font("SansSerif", Font.BOLD,   14);
    public static final Font FONT_FIELD      = new Font("SansSerif", Font.PLAIN,  14);
    public static final Font FONT_BUTTON     = new Font("SansSerif", Font.BOLD,   13);
    public static final Font FONT_MONO       = new Font("Monospaced", Font.PLAIN, 12);
}
