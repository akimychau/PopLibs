package ru.akimychev.poplibs

class CountersPresenter(private val view: MainView) {

    private val model = CountersModel()

    fun onCounterClick(id: Int){
        when(id){
            R.id.btnBoom ->{
                val newValue = model.next(0)
                view.setText(newValue.toString(), 0)
            }
            R.id.btnBoom1 ->{
                val newValue = model.next(1)
                view.setText(newValue.toString(), 1)
            }
            R.id.btnBoom2 ->{
                val newValue = model.next(2)
                view.setText(newValue.toString(), 2)
            }
        }
    }
}