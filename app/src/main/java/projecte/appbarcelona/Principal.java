package projecte.appbarcelona;


import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Principal extends AppCompatActivity implements Animation.AnimationListener {

    //Animacions de transició de les dues fotos
    Animation movimentFoto1;
    Animation movimentFoto2;
    //Animació d'aparició dels botons
    Animation efecteBotons;

    //Animacio d'aparició titol
    Animation efecteTitol;

    //Botons Entrar i Realitat augmentada
    Button botoEntrar;
    Button botoRealitat;

    //ImaggeView de les dues fotos
    ImageView foto;
    ImageView foto2;

    //Titol
    TextView titol;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        botoEntrar = (Button) findViewById(R.id.botoEntrar);
        botoRealitat = (Button) findViewById(R.id.botoRA);

        movimentFoto1 = AnimationUtils.loadAnimation(this,R.anim.movimentbcna);
        movimentFoto2 = AnimationUtils.loadAnimation(this,R.anim.movimentbcnb);

        efecteBotons = AnimationUtils.loadAnimation(this, R.anim.botonsprincipalstransparents);
        efecteTitol = AnimationUtils.loadAnimation(this, R.anim.botonsprincipalstransparents);

        foto = (ImageView) findViewById(R.id.imageView);
        foto.setVisibility(View.VISIBLE);
        foto2 = (ImageView) findViewById(R.id.imageView2);
        foto2.setVisibility(View.INVISIBLE);

        titol = (TextView) findViewById(R.id.titol);
        titol.setVisibility(View.INVISIBLE);


    }

    @Override
    protected void onResume() {
        super.onResume();


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //Cridem a la funció per iniciar les animacions
                creaAnimacions();
            }
        },2000);



    }

    @Override
    protected void onStart() {
        super.onStart();



    }


    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        /**
         * Un cop l'animació de transició de les fotos finaliti
         * s'inicia l'animació d'aparació dels dos botons
         */
        if(animation.equals(movimentFoto2)) {
            botoEntrar.startAnimation(efecteBotons);
            botoRealitat.startAnimation(efecteBotons);
            titol.startAnimation(efecteTitol);
        }

        botoEntrar.setVisibility(View.VISIBLE);
        botoRealitat.setVisibility(View.VISIBLE);
        titol.setVisibility(View.VISIBLE);
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }

    /**
     * Funció que crea les animacions de les dues fotos (en realitat n'és una)
     * i també crea l'animació d'aparició dels dos botons
     */
    public void creaAnimacions(){
        movimentFoto1.setAnimationListener(this);
        movimentFoto2.setAnimationListener(this);


        foto2.setVisibility(View.VISIBLE);



        foto.startAnimation(movimentFoto1);
        foto2.startAnimation(movimentFoto2);
    }
}
