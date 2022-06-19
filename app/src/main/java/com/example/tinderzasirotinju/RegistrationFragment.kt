package com.example.tinderzasirotinju

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class RegistrationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_registration, container, false)
        val registerButton = view.findViewById<Button>(R.id.registerButton)
        val backButtonRegistration = view.findViewById<ImageButton>(R.id.backButtonRegistration)

        val emailEditText = view.findViewById<EditText>(R.id.registrationEmail)
        val passwordEditText = view.findViewById<EditText>(R.id.choosePassword)
        val usernameEditText = view.findViewById<EditText>(R.id.chooseUserName)
        val nameEditText = view.findViewById<EditText>(R.id.nameOfUser)
        val ageEditText = view.findViewById<EditText>(R.id.ageOfUser)

        registerButton.setOnClickListener {
            val database: FirebaseDatabase =
                FirebaseDatabase.getInstance("https://hotlin-e650d-default-rtdb.europe-west1.firebasedatabase.app/")
            var root: DatabaseReference = database.getReference().child("Users")

            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            val username = usernameEditText.text.toString()
            val name = nameEditText.text.toString()
            val age = ageEditText.text.toString()

            val userMap: HashMap<String, String> = HashMap<String, String>()

            userMap.put("E-mail", email)
            userMap.put("Password", password)
            userMap.put("Username", username)
            userMap.put("Name", name)
            userMap.put("Age", age)

            root.push().setValue(userMap)

            root=database.getReference().child("Current user")
            root.setValue(userMap)

            Toast.makeText(activity, "Registrirani ste!", Toast.LENGTH_LONG).show()

            val sureFragment = SwipingFragment()
            val fragmentTransaction: FragmentTransaction? =
                activity?.supportFragmentManager?.beginTransaction()
            fragmentTransaction?.replace(R.id.fragmentContainerView, sureFragment)
            fragmentTransaction?.commit()
        }

        backButtonRegistration.setOnClickListener {
            val sureFragment = HomeFragment()
            val fragmentTransaction: FragmentTransaction? =
                activity?.supportFragmentManager?.beginTransaction()
            fragmentTransaction?.replace(R.id.fragmentContainerView, sureFragment)
            fragmentTransaction?.commit()
        }

        return view
    }
}