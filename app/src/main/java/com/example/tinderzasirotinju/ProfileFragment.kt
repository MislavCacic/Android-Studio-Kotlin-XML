package com.example.tinderzasirotinju

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.FragmentTransaction
import com.google.firebase.database.*

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        val backButtonProfile = view.findViewById<ImageButton>(R.id.backButtonProfile)

        val usernameTextView=view.findViewById<TextView>(R.id.Username)
        val userFullNameTextView=view.findViewById<TextView>(R.id.UserFullName)
        val userAgeTextView=view.findViewById<TextView>(R.id.UserAge)

        val database: FirebaseDatabase = FirebaseDatabase.getInstance("https://hotlin-e650d-default-rtdb.europe-west1.firebasedatabase.app/")
        val root: DatabaseReference = database.getReference().child("Current user")

        root.addValueEventListener(object: ValueEventListener
        {
            override fun onDataChange(snapshot: DataSnapshot) {
                val userMap: HashMap<String, String> = snapshot.getValue() as HashMap<String, String>
                usernameTextView.text=userMap.getValue("Username")
                userFullNameTextView.text=userMap.getValue("Name")
                userAgeTextView.text=userMap.getValue("Age")
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })

        backButtonProfile.setOnClickListener {
            val sureFragment = SwipingFragment()
            val fragmentTransaction: FragmentTransaction? =
                activity?.supportFragmentManager?.beginTransaction()
            fragmentTransaction?.replace(R.id.fragmentContainerView, sureFragment)
            fragmentTransaction?.commit()
        }

        return view
    }
}