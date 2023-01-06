package ru.akimychev.poplibs

class CountersPresenter(private val view: MainView) {

    private val model = CountersModel()

    fun onCounterClick(id: Int){
        when(id){
            0 ->{
                val newValue = model.next(0)
                view.setTextForBoom(newValue.toString())
            }
            1 ->{
                val newValue = model.next(1)
                view.setTextForBoomOne(newValue.toString())
            }
            2 ->{
                val newValue = model.next(2)
                view.setTextForBoomTwo(newValue.toString())
            }
        }
    }
}