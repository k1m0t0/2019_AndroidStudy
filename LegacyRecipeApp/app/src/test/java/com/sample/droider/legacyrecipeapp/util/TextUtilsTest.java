package com.sample.droider.legacyrecipeapp.util;

import android.text.TextUtils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.*;

/**
 * Android TextUtilsクラスのテストコード
 */
@RunWith(RobolectricTestRunner.class)
public class TextUtilsTest {

    @Test
    public void isEmpty_Blank() {
        assertTrue(TextUtils.isEmpty(""));
    }

    @Test
    public void isEmpty_Null() {
        assertTrue(TextUtils.isEmpty(null));
    }

    @Test
    public void isEmpty_false() {
        assertFalse(TextUtils.isEmpty("test"));
    }
}