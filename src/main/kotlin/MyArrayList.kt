import java.lang.IndexOutOfBoundsException

class MyArrayList<T>:MyList<T> {

    var array = arrayOfNulls<Any>(10)
    var size = 0

    companion object{
        fun <E>myListOf(vararg element:E):MyArrayList<E>{
            val list = MyArrayList<E>()
            for (i in element){
                list.add(i)
            }
            return list
        }
    }

    override fun get(index: Int): T {
        if (index in 0 until size ){
            array[index]?.let {
                return it as T
            }
        }
        throw IndexOutOfBoundsException()
    }

    override fun add(string: T) {
        if (size >= array.size){
            array = array.copyOf(array.size*2)
        }
        array[size] = string
        size++
    }

    override fun remove(element: T) {
        for ((index,i) in array.withIndex()){
            if (i == element){
                removeAddIndex(index)
                return
            }
        }
    }

    override fun removeAddIndex(index: Int) {
        if (index in 0 .. size){
        for (i in index until size-1){
            array[i] = array[i+1]
        }
            size--
        }else{
            throw IndexOutOfBoundsException()
        }

    }

    override fun size(): Int {
        return size
    }
}