package com.example.tinderzasirotinju

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.fragment.app.FragmentTransaction

class SwipingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_swiping, container, false)
        val chatButton = view.findViewById<ImageButton>(R.id.chatButton)

        chatButton.setOnClickListener {
            val sureFragment = MatchesFragment()
            val fragmentTransaction: FragmentTransaction? =
                activity?.supportFragmentManager?.beginTransaction()
            fragmentTransaction?.replace(R.id.fragmentContainerView, sureFragment)
            fragmentTransaction?.commit()
        }

        val menuButton = view.findViewById<ImageButton>(R.id.menuButton)

        menuButton.setOnClickListener {
            val sureFragment = ProfileFragment()
            val fragmentTransaction: FragmentTransaction? =
                activity?.supportFragmentManager?.beginTransaction()
            fragmentTransaction?.replace(R.id.fragmentContainerView, sureFragment)
            fragmentTransaction?.commit()
        }
        return view
    }
}