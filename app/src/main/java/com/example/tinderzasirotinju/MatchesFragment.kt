package com.example.tinderzasirotinju

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.FragmentTransaction

class MatchesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_matches, container, false)
        val backButtonMatches = view.findViewById<ImageButton>(R.id.backButtonMatches)

        backButtonMatches.setOnClickListener {
            val sureFragment = SwipingFragment()
            val fragmentTransaction: FragmentTransaction? =
                activity?.supportFragmentManager?.beginTransaction()
            fragmentTransaction?.replace(R.id.fragmentContainerView, sureFragment)
            fragmentTransaction?.commit()
        }

        val profileButton = view.findViewById<ImageButton>(R.id.profileButton)

        profileButton.setOnClickListener {
            val sureFragment = ProfileFragment()
            val fragmentTransaction: FragmentTransaction? =
                activity?.supportFragmentManager?.beginTransaction()
            fragmentTransaction?.replace(R.id.fragmentContainerView, sureFragment)
            fragmentTransaction?.commit()
        }

        return view
    }
}