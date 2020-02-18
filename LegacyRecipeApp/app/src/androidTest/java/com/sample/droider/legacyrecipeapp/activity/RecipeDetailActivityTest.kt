package com.sample.droider.legacyrecipeapp.activity


import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.sample.droider.legacyrecipeapp.R
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RecipeDetailActivityTest {
    private lateinit var mActivity: RecipeListActivity
    private lateinit var recycler: RecyclerView
    private var itemCount: Int = 0

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(RecipeListActivity::class.java)

    @Before
    fun setUpTest() {
        mActivity = mActivityTestRule.activity
        recycler = mActivity.findViewById(R.id.recycler)
        itemCount = recycler.adapter?.itemCount ?: 0
    }

    @Test
    fun displayFixedLabel() {
        for (i in 0 until itemCount) {
            // セルタップ
            onView(withId(R.id.recycler))
                    .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(i, click()))
            // 材料ラベル
            onView(withId(R.id.recycler))
                    .check(matches((hasDescendant(withText(mActivity.getString(R.string.label_ingredient))))))
            // 手順ラベル
            onView(withId(R.id.recycler))
                    .check(matches((hasDescendant(withText(mActivity.getString(R.string.label_method))))))
            pressBack()
        }
    }
}
