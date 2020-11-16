package com.alfred0ga.examenandroid.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.alfred0ga.examenandroid.R
import com.alfred0ga.examenandroid.models.Employee
import kotlinx.android.synthetic.main.colaborador_item.view.*

class EmployeeAdapter : RecyclerView.Adapter<EmployeeAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.colaborador_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val employee = differ.currentList[position]

        holder.itemView.apply {
            tv_name.text = employee.name
            tv_contacto.text = employee.mail
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    val diffCallback = object: DiffUtil.ItemCallback<Employee>() {
        override fun areItemsTheSame(oldItem: Employee, newItem: Employee): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Employee, newItem: Employee): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }

    val differ = AsyncListDiffer(this, diffCallback)
    fun submitList(list: List<Employee>) = differ.submitList(list)

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}