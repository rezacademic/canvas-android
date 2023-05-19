/*
 * Copyright (C) 2021 - present Instructure, Inc.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 3 of the License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.instructure.student.binding

import androidx.annotation.ColorInt
import androidx.databinding.BindingAdapter
import com.google.android.material.tabs.TabLayout
import com.instructure.student.features.elementary.course.ElementaryCourseTab
import com.instructure.student.mobius.assignmentDetails.ui.gradeCell.DonutChartView
import com.instructure.student.mobius.assignmentDetails.ui.gradeCell.GradeCellViewState
import com.instructure.student.mobius.assignmentDetails.ui.gradeCell.GradeStatisticsView

@BindingAdapter("tabs")
fun bindCourseTabs(tabLayout: TabLayout, tabs: List<ElementaryCourseTab>?) {
    tabLayout.removeAllTabs()
    tabs?.forEach { tab ->
        tabLayout.addTab(tabLayout.newTab().apply {
            icon = tab.icon
            text = tab.text
        })
    }
}

@BindingAdapter("progress", "color", "trackColor")
fun DonutChartView.setProgress(progress: Float, @ColorInt color: Int, @ColorInt trackColor: Int) {
    setColor(color)
    setTrackColor(trackColor)
    setPercentage(progress, true)
}

@BindingAdapter("stats", "color")
fun GradeStatisticsView.setStatistics(stats: GradeCellViewState.GradeStats?, @ColorInt color: Int) {
    stats?.let {
        setStats(stats)
        setAccentColor(color)
    }
}
