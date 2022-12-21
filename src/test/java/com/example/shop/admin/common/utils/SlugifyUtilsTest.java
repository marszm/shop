package com.example.shop.admin.common.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SlugifyUtilsTest {

    @ParameterizedTest
    @CsvSource({
            "tęst tęst.png, test-test.png",
            "test test.png, test-test.png",
            "hello word.png, hello-word.png",
            "ąęśćżźńłó.png, aesczznlo.png",
            "Produkt 1.png, produkt-1.png",
            "Produkt - 1.png, produkt-1.png",
            "Produkt__1.png, produkt-1.png"
    })
    void shouldSlugifyFileName(String input, String output) {
        String filename = SlugifyUtils.slugifyFilename(input);
        Assertions.assertEquals(filename, output);
    }

}