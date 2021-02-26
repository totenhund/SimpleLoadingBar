package totenhund.com.simpleloadingbar

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class SimpleLoadingBar(context: Context, attrs: AttributeSet) : View(context, attrs) {

    companion object {
        private const val DEFAULT_COLOR = Color.RED
        private const val DEFAULT_CIRCLE_RADIUS = 3
        private const val DEFAULT_CIRCLE_GAP = 12
    }

    private val painter = Paint(Paint.ANTI_ALIAS_FLAG)

    private var color = DEFAULT_COLOR
    private var circleRadius = DEFAULT_CIRCLE_RADIUS
    private var densityComp: DensityComputation =
        DensityComputation(resources.displayMetrics.density)
    private var sizeComp: SizeComputation = SizeComputation()

    init {
        setupAttributes(attrs)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        drawCircle(canvas)
        invalidate()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        setMeasuredDimension(widthMeasureSpec, heightMeasureSpec)
    }


    private fun drawCircle(canvas: Canvas?) {
        painter.color = color
        painter.style = Paint.Style.FILL

        val gap = sizeComp.computeGap(circleRadius, DEFAULT_CIRCLE_RADIUS, DEFAULT_CIRCLE_GAP)

        canvas?.drawCircle(
            width / 2 - densityComp.dpToPx(gap),
            height / 2 - densityComp.dpToPx(20) * densityComp.verticalPosition(
                System.currentTimeMillis(),
                0
            ).toFloat(),
            densityComp.dpToPx(circleRadius), painter
        )

        canvas?.drawCircle(
            (width / 2).toFloat(),
            height / 2 - densityComp.dpToPx(20) * densityComp.verticalPosition(
                System.currentTimeMillis(),
                125
            ).toFloat(),
            densityComp.dpToPx(circleRadius), painter
        )

        canvas?.drawCircle(
            width / 2 + densityComp.dpToPx(gap),
            height / 2 - densityComp.dpToPx(20) * densityComp.verticalPosition(
                System.currentTimeMillis(),
                250
            ).toFloat(),
            densityComp.dpToPx(circleRadius), painter
        )
    }

    private fun setupAttributes(attrs: AttributeSet?) {

        val typedArray = context.theme.obtainStyledAttributes(
            attrs, R.styleable.SimpleLoadingBar,
            0, 0
        )

        color = typedArray.getColor(R.styleable.SimpleLoadingBar_loadingBarColor, DEFAULT_COLOR)
        circleRadius = typedArray.getColor(
            R.styleable.SimpleLoadingBar_loadingCircleRadius,
            DEFAULT_CIRCLE_RADIUS
        )

    }


}
