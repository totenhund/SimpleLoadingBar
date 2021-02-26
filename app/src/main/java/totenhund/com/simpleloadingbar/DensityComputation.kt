package totenhund.com.simpleloadingbar

class DensityComputation (private val density: Float) {

    private val ANIMATION_LENGTH = 1000

    fun dpToPx(size: Int): Float {
        return size * density
    }

    fun verticalPosition(time: Long, offset: Long): Double {
        val X: Double = 2 * Math.PI * (time + offset) / ANIMATION_LENGTH
        return (Math.sin(X) + 1) / 2.0
    }

}