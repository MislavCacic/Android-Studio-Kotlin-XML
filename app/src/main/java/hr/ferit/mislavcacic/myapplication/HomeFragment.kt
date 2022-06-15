package hr.ferit.mislavcacic.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentTransaction

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val registerButton = view.findViewById<Button>(R.id.RegisterButton)

        registerButton.setOnClickListener {
            val sureFragment = RegistrationFragment()
            val fragmentTransaction: FragmentTransaction? =
                activity?.supportFragmentManager?.beginTransaction()
            fragmentTransaction?.replace(R.id.fragmentContainerView, sureFragment)
            fragmentTransaction?.commit()
        }

        val loginButton = view.findViewById<Button>(R.id.LoginButton)

        loginButton.setOnClickListener {
            val sureFragment = SwipingFragment()
            val fragmentTransaction: FragmentTransaction? =
                activity?.supportFragmentManager?.beginTransaction()
            fragmentTransaction?.replace(R.id.fragmentContainerView, sureFragment)
            fragmentTransaction?.commit()
        }

        return view
    }


}