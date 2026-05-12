package com.nukc.stateview

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout

/**
 * Lightweight in-project StateView fallback used by screens that only need
 * showLoading/showContent/showEmpty visibility toggles.
 */
class StateView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private enum class State { LOADING, CONTENT, EMPTY }

    private var state: State = State.CONTENT

    fun showLoading() {
        state = State.LOADING
        visibility = View.VISIBLE
    }

    fun showContent() {
        state = State.CONTENT
        visibility = View.GONE
    }

    fun showEmpty() {
        state = State.EMPTY
        visibility = View.VISIBLE
    }

    fun currentState(): String = state.name
}
