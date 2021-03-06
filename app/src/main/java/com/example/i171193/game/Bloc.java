package com.example.i171193.game;

import android.view.ViewGroup;
import android.widget.ImageView;

public class Bloc {

    private Game context;
    private ImageView imageBloc;

    public Bloc(Game pContexte){
        this.context = pContexte;
        this.imageBloc = new ImageView(context);
        this.genereBloc();
    }

    public void genereBloc(){
        imageBloc.setBackgroundResource(R.drawable.bloc);
        //Redimentionnement de l'image
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams((int)(context.largeurEcran/15 *1.5), (int)((context.largeurEcran/15 *1.5)/3));
        imageBloc.setLayoutParams(params);
        imageBloc.setX(this.positionAleatoire());
        imageBloc.setY((int)((context.largeurEcran/15 *1.5)/3));
        context.fenetrePrincipal.addView(imageBloc); //Ajout du bloc dans la fenetre principale
    }

    private float positionAleatoire() {
        float X = (float) (Math.random() * context.largeurEcran);
        if (X > context.largeurEcran-150){
            X -= 150;
        }
        return X;
    }

    public ImageView getImageBloc(){
        return this.imageBloc;
    }

    public void bouger() {
        if (this.context.score >= 75*this.context.compteurTimeBloc) { //Faire apparaitre les cube plus vite au file du jeux
            this.context.compteurTimeBloc+=1;
            if (this.context.timeBloc > 55) {
                this.context.timeBloc -= 10; //Les bloc décende plus vite pour augmenter la difficulté
            }
        }
        imageBloc.setY(this.getImageBloc().getY() + 50);
    }
}
