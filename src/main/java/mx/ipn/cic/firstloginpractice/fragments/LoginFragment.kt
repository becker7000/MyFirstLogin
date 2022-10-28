package mx.ipn.cic.firstloginpractice.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout
import mx.ipn.cic.firstloginpractice.R
import mx.ipn.cic.firstloginpractice.models.User

class LoginFragment : Fragment() {

    lateinit var tilCampoUsuario : TextInputLayout
    lateinit var tilCampoContra : TextInputLayout
    lateinit var btnLogin : Button

    val usuario = User("Becker123","password123")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(
            R.layout.fragment_login,
            container,
            false
        )
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        this.tilCampoUsuario = view.findViewById(R.id.tilCampoUsuario)
        this.tilCampoContra = view.findViewById(R.id.tilCampoContra)
        this.btnLogin = view.findViewById(R.id.btnLogin)

        val textoCampoUsuario = this.tilCampoUsuario.editText!!.text
        val textoCampoContra = this.tilCampoContra.editText!!.text

        this.btnLogin.setOnClickListener {

            if( textoCampoUsuario.isNotEmpty() && textoCampoUsuario.length>=6
                && textoCampoUsuario.isNotEmpty() && textoCampoContra.length>=8
                && textoCampoContra.length<=15
            ){

                if(textoCampoUsuario.toString().equals(usuario.name) && textoCampoContra.toString().equals(usuario.pass)){
                    this.tilCampoUsuario.error = null

                    val fragment2 =StartFragment.newInstance(
                        this.tilCampoUsuario.editText?.text.toString()
                    )
                    val transaction = this.parentFragmentManager.beginTransaction()
                    transaction.replace(
                        R.id.fragmentContainer,
                        fragment2
                    )
                    transaction.addToBackStack("firstContainer")
                    transaction.commit()
                }else{
                    Toast.makeText(this.context,
                        "Usuario o contraseña incorrectos.",
                        Toast.LENGTH_SHORT).show()
                    this.tilCampoUsuario.editText!!.setText("")
                    this.tilCampoContra.editText!!.setText("")
                }

            }else{
                if(textoCampoUsuario.isEmpty() || textoCampoUsuario.length<6){
                    this.tilCampoUsuario.error = "El usuario debe al menos tener 6 caracteres."
                }

                if(textoCampoContra.isEmpty() || textoCampoContra.length<8 || textoCampoContra.length>15 ){
                    this.tilCampoContra.error = "La constraseña debe contener entre 8 y 15 caracteres"
                }
            }
        }


    }

    companion object {
        @JvmStatic
        fun newInstance() =
            LoginFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}