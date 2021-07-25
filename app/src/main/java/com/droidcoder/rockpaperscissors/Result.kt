package com.droidcoder.rockpaperscissors

import androidx.annotation.DrawableRes

enum class Result(@DrawableRes val resourceId: Int) {
    WIN(R.drawable.win),
    DRAW(R.drawable.draw),
    LOSE(R.drawable.lose);
}
