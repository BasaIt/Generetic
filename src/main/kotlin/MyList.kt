interface MyList<T> {
    fun get(index:Int): T
    fun add(string: T)
    fun remove(element: T)
    fun removeAddIndex(index: Int)
    fun size():Int


}