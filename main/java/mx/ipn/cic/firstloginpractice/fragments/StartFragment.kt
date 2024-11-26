package mx.ipn.cic.firstloginpractice.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import mx.ipn.cic.firstloginpractice.R

class StartFragment : Fragment() {

    lateinit var tvBienvenida : TextView
    lateinit var texto : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            this.texto = it.getString(USUARIO_ARG,"")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_start, container, false)
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        this.tvBienvenida = view.findViewById(R.id.textoBienvenida)
        this.tvBienvenida.text = "Bienvenid@ ${texto}"
    }

    companion object {

        private const val USUARIO_ARG = "USUARIO_ARG"

        @JvmStatic
        fun newInstance(usuario:String) =
            StartFragment().apply {
                arguments = Bundle().apply {
                    this.putString(USUARIO_ARG,usuario)
                }
            }
    }
}