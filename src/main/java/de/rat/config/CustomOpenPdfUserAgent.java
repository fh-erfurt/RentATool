package de.rat.config;

import org.xhtmlrenderer.pdf.ITextOutputDevice;
import org.xhtmlrenderer.pdf.ITextUserAgent;
import java.io.*;

public class CustomOpenPdfUserAgent  extends ITextUserAgent{
    public CustomOpenPdfUserAgent(ITextOutputDevice outputDevice) {
        super(outputDevice);
    }

    @Override
    protected InputStream resolveAndOpenStream(String uri) {
        InputStream is = getClass()
                .getClassLoader().getResourceAsStream(uri);
        return is;
    }
}
