package com.sample.droider.legacyrecipeapp.util

import android.content.Context
import android.content.res.Resources
import android.util.DisplayMetrics
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DimensUtilTest {
    @Mock
    private lateinit var mockContext: Context
    @Mock
    private lateinit var metrics: DisplayMetrics
    @Mock
    private lateinit var resources: Resources

    @Test
    fun dpToPxForPixel() {
        metrics.xdpi = 420.0F

        `when`(mockContext.resources).thenReturn(resources)
        `when`(resources.displayMetrics).thenReturn(metrics)

        // expected: 実際にEmulatorでビルドした時の値を適用
        Assert.assertEquals(21, DimensUtil.dpToPx(8, mockContext))
    }

    @Test
    fun dpToPxForNexus6() {
        metrics.xdpi = 560.0F

        `when`(mockContext.resources).thenReturn(resources)
        `when`(resources.displayMetrics).thenReturn(metrics)

        // expected: 実際にEmulatorでビルドした時の値を適用
        Assert.assertEquals(28, DimensUtil.dpToPx(8, mockContext))
    }

    @Test
    fun pxToDpForPixel() {
        metrics.xdpi = 420.0F

        `when`(mockContext.resources).thenReturn(resources)
        `when`(resources.displayMetrics).thenReturn(metrics)

        // expected: 実際にEmulatorでビルドした時の値を適用
        Assert.assertEquals(8, DimensUtil.pxToDp(21, mockContext))
    }

    @Test
    fun pxToDpForNexus6() {
        metrics.xdpi = 560.0F

        `when`(mockContext.resources).thenReturn(resources)
        `when`(resources.displayMetrics).thenReturn(metrics)

        // expected: 実際にEmulatorでビルドした時の値を適用
        Assert.assertEquals(8, DimensUtil.pxToDp(28, mockContext))
    }
}