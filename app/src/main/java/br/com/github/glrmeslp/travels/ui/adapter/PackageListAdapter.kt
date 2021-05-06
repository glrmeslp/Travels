package br.com.github.glrmeslp.travels.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import br.com.github.glrmeslp.travels.R
import br.com.github.glrmeslp.travels.model.Package
import br.com.github.glrmeslp.travels.util.ResourceUtil

class PackageListAdapter(
    private val packages: List<Package>
) : BaseAdapter() {

    private lateinit var view: View
    private lateinit var holder: PackageListViewHolder
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        if(convertView == null) {
            view = LayoutInflater.from(parent.context).inflate(R.layout.package_item,parent,false)
            holder = PackageListViewHolder(view)
            view.tag = holder
        } else {
            view = convertView
            holder = view.tag as PackageListViewHolder
        }

        getItem(position).run {
            holder.setImage(image)
            holder.setLocal(local)
            holder.setDays(days)
            holder.setPrice(price)
        }
        return view
    }

    override fun getItem(position: Int): Package = packages[position]

    override fun getItemId(position: Int): Long = 0

    override fun getCount(): Int = packages.count()


}
