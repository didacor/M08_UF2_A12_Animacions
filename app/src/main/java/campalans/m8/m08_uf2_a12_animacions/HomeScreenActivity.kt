package campalans.m8.m08_uf2_a12_animacions

import android.content.Intent
import android.os.Bundle
import android.animation.Animator
import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import androidx.appcompat.app.AppCompatActivity
import campalans.m8.m08_uf2_a12_animacions.databinding.ActivityHomeScreenBinding

class HomeScreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.splashImageView.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // Carregar Animator des del XML
        val animacio1: Animator = AnimatorInflater.loadAnimator(applicationContext, R.animator.primera_animacio)
        val animacio2: Animator = AnimatorInflater.loadAnimator(applicationContext, R.animator.segona_animacio)
        val animacio3: Animator = AnimatorInflater.loadAnimator(applicationContext, R.animator.tercera_animacio)
        val animacio4: Animator = AnimatorInflater.loadAnimator(applicationContext, R.animator.quarta_animacio)
        val animacio5: Animator = AnimatorInflater.loadAnimator(applicationContext, R.animator.cinquena_animacio)

        // Assignar el target al ImageView de la pilota
        animacio1.setTarget(binding.splashImageView)
        animacio2.setTarget(binding.splashImageView)
        animacio3.setTarget(binding.splashImageView)
        animacio4.setTarget(binding.splashImageView)
        animacio5.setTarget(binding.splashImageView)

        //Creem un AnimatorSet
        val animacioSequencia = AnimatorSet()

        //Configurar l'ordre de les animacions
        animacioSequencia.playSequentially(animacio1, animacio2, animacio3, animacio4, animacio5)

        //Iniciar la sequencia d'animacions
        animacioSequencia.start()
    }
}
