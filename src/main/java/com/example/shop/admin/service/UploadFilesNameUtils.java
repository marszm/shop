package com.example.shop.admin.service;

import com.github.slugify.Slugify;
import org.apache.commons.io.FilenameUtils;

public class UploadFilesNameUtils {
    public static String slugifyFilename(String filename) {
        String name = FilenameUtils.getBaseName(filename);
        Slugify slg = new Slugify();
        String changedName = slg
                .withCustomReplacement("_", "-")
                .slugify(name);
        return changedName + "." + FilenameUtils.getExtension(filename);
    }
}