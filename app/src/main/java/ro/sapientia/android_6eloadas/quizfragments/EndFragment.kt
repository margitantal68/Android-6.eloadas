package ro.sapientia.android_6eloadas.quizfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import ro.sapientia.android_6eloadas.R


class EndFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_end, container, false)
        val button: Button = view.findViewById(R.id.button9)
        button.setOnClickListener{
            this.findNavController().navigate(R.id.action_endFragment_to_mainFragment)
        }

        return view
    }
}