package co.n0lik.test.mainscreen.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import io.reactivex.subjects.PublishSubject
import co.n0lik.test.model.SampleEntity
import co.n0lik.test.mainscreen.R
import java.util.*

class RecyclerViewAdapter: RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    val subjectClick: PublishSubject<SampleEntity> = PublishSubject.create()

    private val data: ArrayList<SampleEntity> = ArrayList()

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        init {
            itemView.setOnClickListener { subjectClick.onNext(data[adapterPosition]) }
        }
        private val title by lazy {
            itemView.findViewById<TextView>(R.id.text1)
        }
        fun bind(item: SampleEntity){
            title.text = item.text
        }

    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(p0.context)
                .inflate(R.layout.item_main_data, p0, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.bind(data[p1])
    }

    fun add(item: SampleEntity){
        val pos = data.size
        data.add(item)
        notifyItemInserted(pos)
        println("Totally items = ${data.size}")
    }

    fun addList(list: List<SampleEntity>){
        val pos = data.size
        data.addAll(list)
        notifyItemRangeChanged(pos, list.size)
////        notifyItemInserted(pos)
//        notifyDataSetChanged()
    }


}