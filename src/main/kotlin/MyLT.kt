import java.lang.IndexOutOfBoundsException

class MyLT<T>:MyList<T> {


    var arrayList = arrayOfNulls<Any>(10)
    var size = 0


    override fun get(index: Int): T {
        for (i in 0 .. size){
            arrayList[size]?.let {
                return it as T
            }
        }
        throw IndexOutOfBoundsException()
    }

    override fun removeAddIndex(index: Int) {
        if (index in 0 .. size){
            for (i in index until size){
                arrayList[i] = arrayList[i+1]
            }
            size--
        }else{
            throw IndexOutOfBoundsException()
        }
    }

    override fun size(): Int {
        return size
    }

    override fun remove(element: T) {
        for ((index, i) in arrayList.withIndex()){
            if (i == element){
                removeAddIndex(index)
                return
            }
        }
    }

    override fun add(string: T) {
         if (size >= arrayList.size){
            arrayList = arrayList.copyOf(arrayList.size*2)
        }
        arrayList[size] = string
        size++
    }
}