package com.mattrubacky.jade

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.google.firebase.auth.FirebaseAuth

private var mAuth: FirebaseAuth? = null


class LoginFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onStart() {
        super.onStart()
        var emailField: EditText? = view?.findViewById(R.id.usernameInput)
        var passwordField: EditText? = view?.findViewById(R.id.passwordInput)
        var loginButton: Button? = view?.findViewById(R.id.submit)
        loginButton?.setOnClickListener {
            if(emailField?.text.toString().trim() == ""){
                emailField?.error = getString(R.string.emptyUsername)
            }
            if(passwordField?.text.toString().trim() == ""){
                passwordField?.error = getString(R.string.emptyPassword)
            }
            if(emailField?.text.toString().trim() != "" && passwordField?.text.toString().trim() != ""){
                login(emailField?.text.toString(),passwordField?.text.toString())
            }
        }
    }

    fun login(email:String,password:String){
        mAuth = FirebaseAuth.getInstance()
        mAuth!!.signInWithEmailAndPassword(email,password).addOnCompleteListener {
            if(it.isSuccessful){
                var navController: NavController = NavHostFragment.findNavController(this)
                navController!!.navigate(R.id.action_loginFragment_to_teas)
            }else{
                Toast.makeText(context,getString(R.string.loginFailed),Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            LoginFragment().apply {
                arguments = Bundle().apply {}
            }
    }
}
