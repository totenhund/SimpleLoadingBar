package totenhund.com.simpleloadingbar

class SizeComputation {

    fun computeGap(radius: Int, defaultRadius: Int, defaultGap: Int): Int{
        return (defaultGap * radius) / defaultRadius
    }

}