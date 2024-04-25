package com.principal.botonmisterioso;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private String[] frases = {
            "Estamos trabajando arduamente en ello, por favor, espera.",
            "La creación está en curso; tu paciencia es apreciada.",
            "Pronto verás los frutos de nuestro esfuerzo. ¡Mantente atento!",
            "Nuestro equipo está ocupado construyendo algo grandioso.",
            "En el taller digital, estamos dando forma a tu experiencia.",
            "La magia está en proceso; emocionantes sorpresas están por venir.",
            "Aguarda un momento mientras perfeccionamos cada detalle.",
            "Estamos forjando una experiencia única. Gracias por esperar.",
            "La innovación toma tiempo, pero valdrá la pena la espera.",
            "En el mundo de la programación, estamos en plena acción.",
            "La espera fortalece la anticipación de lo que está por venir.",
            "El progreso está en marcha; pronto disfrutarás los resultados.",
            "Estamos en la fase final de preparación. ¡Casi estamos listos!",
            "La obra maestra está a punto de revelarse. ¡Estén preparados!",
            "Tu paciencia nos impulsa a alcanzar la excelencia.",
            "La creación es un viaje, y estamos avanzando con determinación.",
            "Estamos en la etapa de refinamiento. Tu espera valdrá la pena.",
            "En el taller de desarrollo, estamos dando vida a tu visión.",
            "La sinfonía de la creatividad está llegando a su clímax.",
            "Los engranajes están girando; el resultado será extraordinario.",
            "Estamos tejiendo sueños digitales con esmero.",
            "Cada segundo invertido vale la pena en nuestro proceso de creación.",
            "Estamos navegando en aguas desconocidas, pero avanzamos con confianza.",
            "La espera es el preludio de la maravilla que está por venir.",
            "En el laboratorio de desarrollo, estamos experimentando con pasión.",
            "Nuestro equipo está comprometido en brindarte lo mejor.",
            "La perfección lleva tiempo, y estamos comprometidos con ello.",
            "Estamos en el horno de la creatividad, preparando algo épico.",
            "El reloj avanza, y con él, nuestra obra toma forma.",
            "Estamos en el proceso de dar vida a tu visión.",
            "La espera es el tributo que pagamos a la excelencia.",
            "En el taller de la imaginación, estamos esculpiendo el futuro.",
            "Nuestra creación se está cocinando a fuego lento; pronto estará lista.",
            "Estamos perfeccionando los detalles para sorprenderte.",
            "La chispa de la inspiración brilla en cada línea de código.",
            "El universo digital es nuestro lienzo; estamos pintando con cuidado.",
            "Cada clic que das nos acerca más a la grandeza.",
            "Nuestro equipo está enfocado en crear una experiencia inolvidable.",
            "La espera solo hace que nuestro logro sea más satisfactorio.",
            "El tiempo se desvanece mientras trabajamos en la magia.",
            "Estamos en el taller de la innovación, dando forma a tus sueños.",
            "La paciencia es la llave que abre las puertas de la maravilla.",
            "Nuestra obra de arte digital está tomando vida; pronto será tuya.",
            "Cada momento invertido se traducirá en una experiencia asombrosa.",
            "Estamos escribiendo el próximo capítulo de tu aventura digital.",
            "La espera es el eco de la grandeza que está por llegar.",
            "Nuestro equipo se esfuerza por brindarte lo mejor de lo mejor.",
            "Estamos en el núcleo de la creación, trabajando con dedicación.",
            "La espera es el aperitivo de una experiencia inolvidable.",
            "Cada día que pasa nos acerca más al momento de revelación.",
            "Estamos en la fase final de preparación; emociones intensas se avecinan.",
            "La búsqueda de la perfección es nuestro lema y objetivo.",
            "Cada clic tuyo es un ladrillo en la construcción de algo extraordinario.",
            "Nuestro equipo está comprometido en superar tus expectativas.",
            "La espera es solo un capítulo en la historia de tu sorpresa.",
            "Estamos en el taller de la imaginación, esculpiendo tus deseos.",
            "La magia está a punto de desplegarse; tu paciencia será recompensada.",
            "Cada instante que pasa nos acerca un paso más a la gloria.",
            "Nuestro compromiso es ofrecerte lo mejor de lo mejor.",
            "La paciencia es la semilla de la recompensa que está por venir.",
            "Estamos en el corazón de la creación, trabajando con pasión.",
            "La espera es el preludio de una experiencia que nunca olvidarás.",
            "Cada momento que pasa nos acerca un paso más al momento de revelación.",
            "Estamos en la fase final de preparación; emociones intensas se avecinan.",
            "La excelencia es nuestro destino, y la perseguimos con fervor.",
            "Cada clic que haces nos lleva un paso hacia la grandeza que estamos creando.",
            "Nuestro equipo está comprometido en superar tus expectativas.",
            "La espera es solo un acto en el drama de tu sorpresa.",
            "Estamos en el taller de la imaginación, labrando el futuro.",
            "La magia está a punto de desplegarse; tu paciencia será recompensada.",
            "Cada momento que pasa nos acerca un paso más a la gloria.",
            "El arte de la paciencia está creando algo memorable. Espera lo inesperado.",
            "Cada paso en nuestro proceso es un paso hacia la perfección. Tu espera será recompensada.",
            "Estamos tejiendo cada hilo de innovación con precisión y cuidado.",
            "Nuestro equipo se sumerge en un mar de creatividad para traerte algo único.",
            "La magia digital está en marcha, transformando sueños en realidad.",
            "Cada segundo de espera es un segundo de mejora y refinamiento.",
            "Estamos pintando tu experiencia con los colores de la innovación y la originalidad.",
            "La perfección es una escalera que estamos subiendo paso a paso para ti.",
            "En la fragua de la creatividad, estamos moldeando una obra maestra.",
            "El tiempo se convierte en calidad; tu paciencia forja maravillas.",
            "Nuestra dedicación está en cada detalle. Pronto lo verás por ti mismo.",
            "Estamos esculpiendo en el mármol digital para dar vida a tus ideas.",
            "La espera es el precio de un producto que trasciende lo ordinario.",
            "Nuestros desarrolladores están tejiendo la tela de una experiencia inolvidable.",
            "El reloj de la creatividad tic-tac; cada momento cuenta hacia la grandeza.",
            "Estamos escribiendo líneas de código como poetas componen versos.",
            "Nuestra obra se está cocinando en el horno de la innovación. Pronto estará lista.",
            "Cada pincelada en nuestro lienzo digital está llena de pasión y dedicación.",
            "La espera es el puente hacia una experiencia que trascenderá tus expectativas.",
            "En nuestra orquesta digital, cada nota es cuidadosamente afinada para ti.",
            "Estamos tallando el futuro con las herramientas de hoy.",
            "La paciencia es la compañera de la excelencia en nuestra labor.",
            "En el laboratorio de ideas, estamos mezclando los ingredientes para tu sorpresa.",
            "Estamos plantando las semillas de una experiencia revolucionaria.",
            "Cada minuto de espera es un minuto invertido en perfeccionar tu experiencia.",
            "En el anfiteatro de la creatividad, estamos preparando un espectáculo asombroso.",
            "Estamos componiendo la sinfonía de una tecnología avanzada y amigable.",
            "La espera es el suspenso antes del estreno de nuestra última innovación.",
            "Estamos trenzando la red de una experiencia digital sin precedentes.",
            "Cada momento de anticipación es un preludio a la satisfacción y el asombro.",
            "Estamos bordando con hilo de oro tu próxima experiencia digital.",
            "Cada línea de código es un paso más cerca de la perfección.",
            "En el crisol de la creatividad, estamos forjando una experiencia única.",
            "La paciencia es el lienzo sobre el que pintamos nuestra obra maestra.",
            "Nuestro equipo está en una odisea de innovación, navegando hacia nuevos horizontes.",
            "Estamos entretejiendo la trama de una narrativa digital sin igual.",
            "Cada píxel está siendo cuidadosamente colocado en su lugar perfecto.",
            "Estamos orquestando una sinfonía de tecnología y arte.",
            "La espera es la antecámara de un mundo de maravillas tecnológicas.",
            "En el laboratorio de sueños, estamos destilando la esencia de tu próxima aventura.",
            "Cada prueba y ajuste nos acerca más a la excelencia.",
            "Estamos tejiendo la alfombra mágica de tu viaje digital.",
            "En el jardín de la creatividad, estamos cultivando una flor única.",
            "La paciencia es la llave de oro que abrirá un mundo de asombro.",
            "Estamos tallando cuidadosamente en el granito de la innovación.",
            "Cada clic en nuestro taller es un paso hacia un futuro emocionante.",
            "En el horno de nuestras ideas, estamos horneando una delicia digital.",
            "Estamos en una misión para convertir lo ordinario en extraordinario.",
            "La espera es la melodía antes del gran concierto de la revelación.",
            "Nuestros artesanos digitales están esculpiendo tu próxima maravilla.",
            "Estamos en el acto final de preparar una experiencia trascendental.",
            "Cada momento de desarrollo es un acorde en la música del progreso.",
            "Estamos tejiendo una red de experiencias que cambiarán tu mundo.",
            "Nuestro equipo está en una búsqueda épica de excelencia y sorpresa.",
            "La paciencia es la puerta a un reino de descubrimientos digitales.",
            "Estamos esculpiendo en el tiempo la estatua de tu satisfacción.",
            "En el caldero de la innovación, estamos cocinando algo mágico.",
            "Cada minuto de espera es una semilla de asombro futuro.",
            "Estamos en la forja de la creatividad, martillando tu próxima experiencia.",
            "La espera es el preámbulo a una sinfonía de soluciones creativas.",
            "Estamos diseñando el tapiz de tu aventura digital.",
            "Cada pincelada es un paso más en el camino de la maravilla.",
            "En el taller del futuro, estamos construyendo algo brillante.",
            "La paciencia es el acompañante fiel en el viaje hacia la excelencia.",
            "Estamos navegando en el océano de la posibilidad, hacia tu destino digital.",
            "Cada segundo de espera es un segundo de inspiración y creación.",
            "Estamos en la cocina de la creatividad, preparando un banquete de innovaciones.",
            "La espera es la sombra que precede al amanecer de una nueva era digital.",
            "Nuestros alquimistas digitales están transformando ideas en oro.",
            "Estamos en el lienzo del progreso, pintando tu futuro digital.",
            "Cada ajuste y mejora nos acerca más a la obra maestra final.",
            "Estamos entre las estrellas del desarrollo, buscando tu constelación perfecta.",
            "La paciencia es el pasaporte para un viaje increíble en el mundo digital.",
            "Estamos componiendo el poema de tu próxima gran experiencia.",
            "En el teatro de la innovación, estamos preparando un espectáculo deslumbrante.",
            "Cada minuto de refinamiento es un homenaje a tu experiencia futura.",
            "Estamos navegando con viento de creatividad hacia el puerto de tu satisfacción.",
            "La espera es el prólogo a un libro de descubrimientos y maravillas.",
            "En el taller de sueños, estamos construyendo tu realidad de mañana.",
            "Cada esfuerzo de hoy es una estrella en el cielo de nuestro logro.",
            "Estamos trabajando arduamente en ello, por favor, espera.",
            "La creación está en curso; tu paciencia es apreciada.",
            "Pronto verás los frutos de nuestro esfuerzo. ¡Mantente atento!",
            "Nuestro equipo está ocupado construyendo algo grandioso.",
            "En el taller digital, estamos dando forma a tu experiencia.",
            "La magia está en proceso; emocionantes sorpresas están por venir.",
            "Aguarda un momento mientras perfeccionamos cada detalle.",
            "Estamos forjando una experiencia única. Gracias por esperar.",
            "La innovación toma tiempo, pero valdrá la pena la espera.",
            "En el mundo de la programación, estamos en plena acción.",
            "La espera fortalece la anticipación de lo que está por venir.",
            "El progreso está en marcha; pronto disfrutarás los resultados.",
            "Estamos en la fase final de preparación. ¡Casi estamos listos!",
            "La obra maestra está a punto de revelarse. ¡Estén preparados!",
            "Tu paciencia nos impulsa a alcanzar la excelencia.",
            "La creación es un viaje, y estamos avanzando con determinación.",
            "Estamos en la etapa de refinamiento. Tu espera valdrá la pena.",
            "En el taller de desarrollo, estamos dando vida a tu visión.",
            "La sinfonía de la creatividad está llegando a su clímax.",
            "Los engranajes están girando; el resultado será extraordinario.",
            "Estamos tejiendo sueños digitales con esmero.",
            "Cada segundo invertido vale la pena en nuestro proceso de creación.",
            "Estamos navegando en aguas desconocidas, pero avanzamos con confianza.",
            "La espera es el preludio de la maravilla que está por venir.",
            "En el laboratorio de desarrollo, estamos experimentando con pasión.",
            "Nuestro equipo está comprometido en brindarte lo mejor.",
            "La perfección lleva tiempo, y estamos comprometidos con ello.",
            "Estamos en el horno de la creatividad, preparando algo épico.",
            "El reloj avanza, y con él, nuestra obra toma forma.",
            "Estamos en el proceso de dar vida a tu visión.",
            "La espera es el tributo que pagamos a la excelencia.",
            "En el taller de la imaginación, estamos esculpiendo el futuro.",
            "Nuestra creación se está cocinando a fuego lento; pronto estará lista.",
            "Estamos perfeccionando los detalles para sorprenderte.",
            "La chispa de la inspiración brilla en cada línea de código.",
            "El universo digital es nuestro lienzo; estamos pintando con cuidado.",
            "Cada clic que das nos acerca más a la grandeza.",
            "Nuestro equipo está enfocado en crear una experiencia inolvidable.",
            "La espera solo hace que nuestro logro sea más satisfactorio.",
            "El tiempo se desvanece mientras trabajamos en la magia.",
            "Estamos en el taller de la innovación, dando forma a tus sueños.",
            "La paciencia es la llave que abre las puertas de la maravilla.",
            "Nuestra obra de arte digital está tomando vida; pronto será tuya.",
            "Cada momento invertido se traducirá en una experiencia asombrosa.",
            "Estamos escribiendo el próximo capítulo de tu aventura digital.",
            "La espera es el eco de la grandeza que está por llegar.",
            "Nuestro equipo se esfuerza por brindarte lo mejor de lo mejor.",
            "Estamos en el núcleo de la creación, trabajando con dedicación.",
            "La espera es el aperitivo de una experiencia inolvidable.",
            "Cada día que pasa nos acerca más al momento de revelación.",
            "Estamos en la fase final de preparación; emociones intensas se avecinan.",
            "La búsqueda de la perfección es nuestro lema y objetivo.",
            "Cada clic tuyo es un ladrillo en la construcción de algo extraordinario.",
            "Nuestro equipo está comprometido en superar tus expectativas.",
            "La espera es solo un capítulo en la historia de tu sorpresa.",
            "Estamos en el taller de la imaginación, esculpiendo tus deseos.",
            "La magia está a punto de desplegarse; tu paciencia será recompensada.",
            "Cada instante que pasa nos acerca un paso más a la gloria.",
            "Nuestro compromiso es ofrecerte lo mejor de lo mejor.",
            "La paciencia es la semilla de la recompensa que está por venir.",
            "Estamos en el corazón de la creación, trabajando con pasión.",
            "La espera es el preludio de una experiencia que nunca olvidarás.",
            "Cada momento que pasa nos acerca un paso más al momento de revelación.",
            "Estamos en la fase final de preparación; emociones intensas se avecinan.",
            "La excelencia es nuestro destino, y la perseguimos con fervor.",
            "Cada clic que haces nos lleva un paso hacia la grandeza que estamos creando.",
            "Nuestro equipo está comprometido en superar tus expectativas.",
            "La espera es solo un acto en el drama de tu sorpresa.",
            "Estamos en el taller de la imaginación, labrando el futuro.",
            "La magia está a punto de desplegarse; tu paciencia será recompensada.",
            "Cada momento que pasa nos acerca un paso más a la gloria.",
            "El arte de la paciencia está creando algo memorable. Espera lo inesperado.",
            "Cada paso en nuestro proceso es un paso hacia la perfección. Tu espera será recompensada.",
            "Estamos tejiendo cada hilo de innovación con precisión y cuidado.",
            "Nuestro equipo se sumerge en un mar de creatividad para traerte algo único.",
            "La magia digital está en marcha, transformando sueños en realidad.",
            "Cada segundo de espera es un segundo de mejora y refinamiento.",
            "Estamos pintando tu experiencia con los colores de la innovación y la originalidad.",
            "La perfección es una escalera que estamos subiendo paso a paso para ti.",
            "En la fragua de la creatividad, estamos moldeando una obra maestra."

    };
    private boolean animacionEnCurso = false;
    private ImageView botonImagen;
    private TextView textView;
    private InterstitialAd mInterstitialAd;
    int contadorActual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contadorActual= obtenerContador();

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {}
        });

        botonImagen = findViewById(R.id.botonImagen);
        textView = findViewById(R.id.texto);

        botonImagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!animacionEnCurso) {
                    ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.9f, 1.0f, 0.9f,
                            Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                    scaleAnimation.setDuration(100);
                    view.startAnimation(scaleAnimation);

                    Random random = new Random();
                    int indice = random.nextInt(frases.length);
                    String fraseSeleccionada = frases[indice];

                    textView.setVisibility(View.INVISIBLE);

                    textView.setGravity(Gravity.CENTER);

                    contadorActual = obtenerContador();
                    contadorActual++;

                    if (contadorActual == 28800) {
                        mostrarMensajeEnPantalla();
                    } else {
                        escribirTextoEstiloMaquina(textView, fraseSeleccionada);
                    }
                    guardarContador(contadorActual);
                }

            }
        });
    }
    private void cargarAnuncioIntersticial() {
        AdRequest adRequest = new AdRequest.Builder().build();
        InterstitialAd.load(this,"ca-app-pub-8683726498901677/7038232787", adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        mInterstitialAd = interstitialAd;
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        mInterstitialAd = null;
                    }
                });
    }

    private void mostrarMensajeEnPantalla() {
        botonImagen.setVisibility(View.INVISIBLE);

        ConstraintLayout constraintLayout = findViewById(R.id.layout);
        for (int i = 0; i < constraintLayout.getChildCount(); i++) {
            View child = constraintLayout.getChildAt(i);
            if (child.getId() != R.id.texto) {
                constraintLayout.removeView(child);
            }
        }
        final String mensaje = "En los anales de la interacción digital, tus acciones han forjado una leyenda. Un titánico esfuerzo ha sido revelado, una odisea que ha desafiado los límites del tiempo y la persistencia. Tu determinación ha iluminado el camino, un sendero digital ilustre y sorprendente.\n\n"
                + "¡Asombroso! Tus dedos han danzado sobre el misterioso botón unas asombrosas 28800 veces. En promedio, solo tres fugaces segundos se interpusieron entre cada pulsación, tejiendo un tapiz de dedicación. Ese es un día completo de tu vida que has regalado a nuestra aplicación, un tributo a tu devoción incansable.\n\n"
                + "Desde las profundidades de nuestros algoritmos hasta las alturas de tu compromiso, queremos expresar nuestro sincero agradecimiento. En Desarrollos Patito, valoramos cada instante que has dedicado, cada pulsación que has ofrecido. Tu tiempo es el tesoro más preciado, y lo has invertido en nuestra creación.\n\n"
                + "Gracias por ser una parte fundamental de nuestra historia, por teñir de épica esta travesía digital. Tu dedicación es una inspiración para todos nosotros. ¡Te queremos, intrépido aventurero digital! ¡Sigamos explorando juntos los límites de lo posible!";
        View pantallaCompleta = getLayoutInflater().inflate(R.layout.constraint_layout, null);
        final TextView mensajeCompleto = pantallaCompleta.findViewById(R.id.mensajeCompleto);
        mensajeCompleto.setText(mensaje);

        setContentView(pantallaCompleta);
        mensajeCompleto.setVisibility(View.VISIBLE);
        mensajeCompleto.setGravity(Gravity.CENTER);

        escribirTextoEstiloMaquina(mensajeCompleto, mensaje);
    }
    private int obtenerContador() {
        SharedPreferences sharedPreferences = getSharedPreferences("MiPreferencia", Context.MODE_PRIVATE);
        return sharedPreferences.getInt("contador", 0);
    }
    private void guardarContador(int contador) {
        SharedPreferences sharedPreferences = getSharedPreferences("MiPreferencia", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("contador", contador);
        editor.apply();
    }

    private void escribirTextoEstiloMaquina(final TextView textView, final String texto) {
        final int velocidadEscritura = 50;
        final Handler handler = new Handler();
        textView.setText("");

        animacionEnCurso = true;

        final int[] index = {0};

        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if (index[0] < texto.length()) {
                    String textoActual = textView.getText().toString();
                    textoActual += texto.charAt(index[0]);
                    textView.setText(textoActual);

                    textView.setVisibility(View.VISIBLE);

                    index[0]++;
                    handler.postDelayed(this, velocidadEscritura);
                } else {
                    animacionEnCurso = false;

                    cargarAnuncioIntersticial();
                    if (contadorActual % 3 == 0) {
                        if (mInterstitialAd != null) {
                            mInterstitialAd.show(MainActivity.this);
                        } else {

                        }
                    }

                }
            }
        };
        handler.postDelayed(runnable, velocidadEscritura);
    }
}
