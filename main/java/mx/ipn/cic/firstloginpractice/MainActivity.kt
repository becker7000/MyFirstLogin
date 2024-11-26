package mx.ipn.cic.firstloginpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import mx.ipn.cic.firstloginpractice.fragments.LoginFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState==null){

            val fragment1 = LoginFragment.newInstance()

            // Iniciando la transacción
            val fragmentTransaction = this.supportFragmentManager.beginTransaction()

            // Definiendo mi transacción
            fragmentTransaction.add(
                R.id.fragmentContainer,
                fragment1
            )

            // Confirmando mi transacción
            fragmentTransaction.commit()

        }

    }
}