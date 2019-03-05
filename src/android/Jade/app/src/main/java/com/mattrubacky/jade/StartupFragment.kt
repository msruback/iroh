package com.mattrubacky.jade

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser


class StartupFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
        var mAuth: FirebaseAuth? = FirebaseAuth.getInstance()
        var user: FirebaseUser? = mAuth?.currentUser
        var navController: NavController? = NavHostFragment.findNavController(this);
        if(user==null){
            navController?.navigate(R.id.action_startupFragment_to_loginFragment)
        }else{
            navController?.navigate(R.id.action_startupFragment_to_teas)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return null
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onDetach() {
        super.onDetach()
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            StartupFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}
