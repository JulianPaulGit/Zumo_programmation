package com.pauljulian.zumo_programmation;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ActivityProgrammation extends AppCompatActivity {

    private final static String TAG = "mTag";
    private ImageView barreMenu, barreBoutons, dragTest, curseurMenu;
    private ViewGroup viewGroup; // Absolute Layout
    private List<ElementaryAction> listElementaryActions = new ArrayList<ElementaryAction>();
    private ArrayList<Action> arrayListActions;
    private boolean readyToStart = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.layout_programmation);

        importViews();

        createElementaryListView();
        //createScrollingListView();

    }

    public void createElementaryListView() {
        listElementaryActions.add(new ElementaryAction(R.drawable.start));
        listElementaryActions.add(new ElementaryAction(R.drawable.tourner_gauche));
        listElementaryActions.add(new ElementaryAction(R.drawable.finish));
        //ArrayAdapter<ElementaryAction> adapter = new ElementaryAdapter(this.getApplicationContext(), R.layout.elementary, listElementaryActions, this, this.listElementaryActions);
        ListView listView = (ListView) findViewById(R.id.elementaryActionListView);
        //listView.setAdapter(adapter);
    }

    public void createScrollingListView() {
        ArrayList<String> mCheeseList = new ArrayList<String>();
        for (int i = 0; i < Cheeses.sCheeseStrings.length; ++i) {
            mCheeseList.add(Cheeses.sCheeseStrings[i]);
        }

        StableArrayAdapter adapter = new StableArrayAdapter(this, R.layout.text_view, mCheeseList);
        DynamicListView listView = (DynamicListView) findViewById(R.id.listview);

        listView.setCheeseList(mCheeseList);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
    }

    public void importViews() {
        viewGroup = (ViewGroup) findViewById(R.id.relative_layout_drag);
        dragTest = (ImageView) findViewById(R.id.dragTest);

        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(150,150);
        dragTest.setLayoutParams(layoutParams);
        dragTest.setOnTouchListener(new ChoiceTouchListener(viewGroup));
        //dragTest.setVisibility(View.INVISIBLE);

        curseurMenu = (ImageView) findViewById(R.id.curseurMenu);
        barreMenu = (ImageView) findViewById(R.id.barreMenu);
    }

    private void lancerNouveauTour() {
        // Lancement du nouveau Thread
        ThreadNouveauTour threadNouveauTour = new ThreadNouveauTour(this.arrayListActions);
        threadNouveauTour.start();
    }

    public void commencerTour(View view) {
        if (readyToStart) {
            String erreurProgrammation = VerificationCommandes.verificationCommandes(this.arrayListActions);
            if (erreurProgrammation.equals("")) {
                lancerNouveauTour();
            } else {
                // Afficher le message erreurProgrammation
                AlertDialog.Builder myAlert = new AlertDialog.Builder(this);
                myAlert.setMessage(erreurProgrammation);
                myAlert.show();
            }
        } else {
            AlertDialog.Builder myAlert = new AlertDialog.Builder(this);
            myAlert.setMessage("Vous ne pouvez pas lancer un nouveau tour, le zumo n'a pas terminé !");
            myAlert.show();
        }
    }

    public void commandeBrasClick(View view) {
        // Afficher le menu relatif au bras
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.setMargins(0, 100, 0, 0);
        curseurMenu.setLayoutParams(lp);
    }

    public void commandeCapteursClick(View view) {
        // Afficher le menu relatif aux capteurs
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.setMargins(0, 150, 0, 0);
        curseurMenu.setLayoutParams(lp);
    }

    public void commandeRouesClick(View view) {
        // Afficher le menu relatif aux roues
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.setMargins(0, 200, 0, 0);
        curseurMenu.setLayoutParams(lp);
    }

}
