package com.example.parcial;
import androidx.appcompat.app.AppCompatActivity;
import com.example.parcial.logica.Pregunta;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import com.example.parcial.logica.Opciones;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    public Pregunta[] p;
    public Pregunta aux;
    public Opciones[][] op;
    public Opciones aux_op;
    public Button boton_opcion_a;
    public Button boton_opcion_b;
    public Button boton_opcion_c;
    public Button boton_opcion_d;
    public ImageButton boton_reinicio;
    public ImageButton boton_comodin_llamada;
    public ImageButton boton_comodin_5050;
    public ImageButton boton_comodin_publico;
    public TextView tx;
    public TextView tx_ronda;
    public int ind;
    public int[] visibles;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        ind=0;
        visibles= new int[]{0, 0, 0, 0};
        p=new Pregunta[15];
        aux= new Pregunta();
        op=new Opciones[15][4];
        aux_op=new Opciones();
        boton_opcion_a=findViewById(R.id.Button_opcion_a);
        boton_opcion_b=findViewById(R.id.button_opcion_b);
        boton_opcion_c=findViewById(R.id.button_opcion_c);
        boton_opcion_d=findViewById(R.id.button_opcion_d);
        boton_reinicio=findViewById(R.id.button_reinicion);
        boton_comodin_llamada=findViewById(R.id.Button_llamada);
        boton_comodin_5050=findViewById(R.id.Button_5050);
        boton_comodin_publico=findViewById(R.id.Button_publico);
        tx= findViewById(R.id.Text_pregunta);
        tx_ronda=findViewById(R.id.Text_ronda);
        Cargar_preguntas();
        Cargar_opciones();
    }
    public void opciones(View v){
        if(boton_opcion_a.getId()==v.getId()){
            for(int i=0;i<4;i++){
                if(boton_opcion_a.getText().equals
                        (op[(Integer.parseInt((String) tx_ronda.getText())) -1][i].getOpcion())
                        && op[(Integer.parseInt((String) tx_ronda.getText())) -1][i].correcto==true){
                    Toast.makeText( this, "bien ", Toast.LENGTH_SHORT).show();
                    Siguiente_ronda();
                }else if(boton_opcion_a.getText().equals(op[(Integer.parseInt((String) tx_ronda.getText())) -1][i].getOpcion())
                        && op[(Integer.parseInt((String) tx_ronda.getText())) -1][i].correcto==false){
                    Perder();
                }
            }
        }else{
            if(boton_opcion_b.getId()==v.getId()){
                for(int i=0;i<4;i++){
                    String a="";
                    if( ((String)boton_opcion_b.getText()).equals(op[(Integer.parseInt((String) tx_ronda.getText())) -1][i].getOpcion())
                            && op[(Integer.parseInt((String) tx_ronda.getText())) -1][i].correcto==true){
                        Toast.makeText( this, "bien ", Toast.LENGTH_SHORT).show();
                        Siguiente_ronda();
                    }else if(boton_opcion_b.getText().equals(op[(Integer.parseInt((String) tx_ronda.getText())) -1][i].getOpcion())
                            && op[(Integer.parseInt((String) tx_ronda.getText())) -1][i].correcto==false){
                        Perder();
                    }
                }

            }else{
                if(boton_opcion_c.getId()==v.getId()){
                    for(int i=0;i<4;i++){
                        if(boton_opcion_c.getText().equals(op[(Integer.parseInt((String) tx_ronda.getText())) -1][i].getOpcion())
                                && op[(Integer.parseInt((String) tx_ronda.getText())) -1][i].correcto==true){
                            Toast.makeText( this, "bien ", Toast.LENGTH_SHORT).show();
                            Siguiente_ronda();
                        }else if(boton_opcion_c.getText().equals(op[(Integer.parseInt((String) tx_ronda.getText())) -1][i].getOpcion())
                                && op[(Integer.parseInt((String) tx_ronda.getText())) -1][i].correcto==false){
                            Perder();
                        }
                    }
                }else{
                    if(boton_opcion_d.getId()==v.getId()){
                        for(int i=0;i<4;i++){
                            if(boton_opcion_d.getText().equals(op[(Integer.parseInt((String) tx_ronda.getText())) -1][i].getOpcion())
                                    && op[(Integer.parseInt((String) tx_ronda.getText())) -1][i].correcto==true){
                                Toast.makeText( this, "bien ", Toast.LENGTH_SHORT).show();
                                Siguiente_ronda();
                            }else if(boton_opcion_d.getText().equals(op[(Integer.parseInt((String) tx_ronda.getText())) -1][i].getOpcion())
                                    && op[(Integer.parseInt((String) tx_ronda.getText())) -1][i].correcto==false){
                                Perder();
                            }
                        }
                    }
                }
            }
        }
    }
    public void comodin_llamada(View V){
        Toast.makeText( this, "Llamando a un amigo", Toast.LENGTH_LONG).show();
        String [] respuestas= {"A","B","C","D",};
        int cont=0,r=0;
        for(int i=0;i<4;i++){
            if(visibles[i]==1){
                respuestas[i]="";
            }
        }
        while(cont==0){
            r=(int) (Math.random() * (3 - 0))+0;
            if(respuestas[r].equals("")){
                cont=0;
            }else{
                cont++;
            }
        }
        Toast.makeText( this, "Respuesta sugerida por el amigo : "+respuestas[r], Toast.LENGTH_LONG).show();
        boton_comodin_llamada.setEnabled(false);
        boton_comodin_llamada.setVisibility(View.INVISIBLE);
    }
    public void comodin_5050(View V){
        Toast.makeText( this, "Se han eliminado 2 respuestas", Toast.LENGTH_SHORT).show();
        int cont=0;
        for(int i=0;i<4;i++){
            if(boton_opcion_a.getText().equals(op[(Integer.parseInt((String) tx_ronda.getText())) -1][i].getOpcion())
                    && op[(Integer.parseInt((String) tx_ronda.getText())) -1][i].correcto==false && cont<2){
                boton_opcion_a.setText("");
                boton_opcion_a.setEnabled(false);
                cont++;
                visibles[0]=1;
            }
        }
        for(int i=0;i<4;i++) {
            if (boton_opcion_b.getText().equals(op[(Integer.parseInt((String) tx_ronda.getText())) - 1][i].getOpcion())
                    && op[(Integer.parseInt((String) tx_ronda.getText())) - 1][i].correcto == false && cont<2) {
                boton_opcion_b.setText("");
                boton_opcion_b.setEnabled(false);
                cont++;
                visibles[1]=1;
            }
        }
        for(int i=0;i<4;i++) {
            if (boton_opcion_c.getText().equals(op[(Integer.parseInt((String) tx_ronda.getText())) - 1][i].getOpcion())
                    && op[(Integer.parseInt((String) tx_ronda.getText())) - 1][i].correcto == false && cont<2) {
                boton_opcion_c.setText("");
                boton_opcion_c.setEnabled(false);
                cont++;
                visibles[2]=1;
            }
        }
        for(int i=0;i<4;i++) {
            if (boton_opcion_d.getText().equals(op[(Integer.parseInt((String) tx_ronda.getText())) - 1][i].getOpcion())
                    && op[(Integer.parseInt((String) tx_ronda.getText())) - 1][i].correcto == false && cont<2) {
                boton_opcion_d.setText("");
                boton_opcion_d.setEnabled(false);
                cont++;
                visibles[3]=1;
            }
        }
        boton_comodin_5050.setEnabled(false);
        boton_comodin_5050.setVisibility(View.INVISIBLE);
    }
    public void comodin_publico(View V){
        Toast.makeText( this, "El publico esta decidiendo", Toast.LENGTH_LONG).show();
        String [] respuestas= {"A","B","C","D",};
        String salida="";
        salida+=System.getProperty("line.separator");
        int cont=0,r=0,porcen_aux=0;
        for(int i=0;i<4;i++){
            if(visibles[i]==1) {
                respuestas[i] = "";
               porcen_aux=1;
            }
        }
        if(porcen_aux==1){
            r=(int) (Math.random() * (100 - 0))+0;
            for(int i=0;i<4;i++){
                if(respuestas[i].equals("")){
                }else{
                    if(cont==1){
                        salida += "La opcion " + respuestas[i] + " tiene un " + (100-r) + " % de apoyo";
                    }else {
                        salida += "La opcion " + respuestas[i] + " tiene un " + (r) + " % de apoyo"+
                                System.getProperty("line.separator");
                        cont = 1;
                    }
                }
            }
        }else{
            r=(int) (Math.random() * (100 - 0))+0;
            salida+="La opcion A tiene un " + (r) + " % de apoyo"+
                    System.getProperty("line.separator");
            cont=r;
            r=(int) (Math.random() * ( (100-cont) - 0))+0;
            salida+="La opcion B tiene un " + (r) + " % de apoyo"+
                    System.getProperty("line.separator");
            cont=(100-cont)-r;
            r=(int) (Math.random() * ( cont - 0))+0;
            salida+="La opcion C tiene un " + (r) + " % de apoyo"+
                    System.getProperty("line.separator");
            salida+="La opcion D tiene un " + (cont-r) + " % de apoyo";
        }
        Toast.makeText( this, "El resultado del publico es : "+salida, Toast.LENGTH_LONG).show();
        boton_comodin_publico.setEnabled(false);
        boton_comodin_publico.setVisibility(View.INVISIBLE);
    }

    public void Cargar_preguntas() {
        int primer=Primera();
        // FACIL
        aux.setId(1);
        aux.setPregunta("¿Cuál de los siguientes sería atraído por un imán?");
        p[0] = aux;
        aux=new Pregunta();
        aux.setId(2);
        aux.setPregunta("¿Cuál de estos nombres no aparece en el título de una obra de Shakespeare?");
        p[1] = aux;
        aux=new Pregunta();
        aux.setId(3);
        aux.setPregunta("En los hoteles elegantes, ¿qué snack suele dejarse sobre las almohadas?");
        p[2] = aux;
        aux=new Pregunta();
        aux.setId(4);
        aux.setPregunta("¿Cuáles de estas aplicaciones ofrecen más o menos el mismo tipo de servicio?");
        p[3] = aux;
        aux=new Pregunta();
        aux.setId(5);
        aux.setPregunta("Cuando algo se encuentra en un lugar muy obvio, se dice que está abajo...");
        p[4] = aux;
        aux=new Pregunta();
        // MEDIO
        aux.setId(6);
        aux.setPregunta("¿De qué país forma parte Hawaii?");
        p[5] = aux;
        aux=new Pregunta();
        aux.setId(7);
        aux.setPregunta("¿Cuál es el océano más grande del mundo?");
        p[6] = aux;
        aux=new Pregunta();
        aux.setId(8);
        aux.setPregunta("¿En qué año se creó la Organización de las Naciones Unidas (ONU)?");
        p[7] = aux;
        aux=new Pregunta();
        aux.setId(9);
        aux.setPregunta("¿Cuál es la isla más grande del mundo?");
        p[8] = aux;
        aux=new Pregunta();
        aux.setId(10);
        aux.setPregunta("¿En qué conflicto participó Juana de Arco?");
        p[9] = aux;
        aux=new Pregunta();
        // DIFICIL
        aux.setId(11);
        aux.setPregunta("¿Cuál era el primer nombre del Rey Jorge VI?");
        p[10] = aux;
        aux=new Pregunta();
        aux.setId(12);
        aux.setPregunta("¿De qué color son las “Cajas Negras” de los aviones?");
        p[11] = aux;
        aux=new Pregunta();
        aux.setId(13);
        aux.setPregunta("¿Cuánto duró la famosa Guerra de los 100 años?");
        p[12] = aux;
        aux=new Pregunta();
        aux.setId(14);
        aux.setPregunta("Los neurólogos creen que la corteza prefrontal del cerebro se activa cuando...");
        p[13] = aux;
        aux=new Pregunta();
        aux.setId(15);
        aux.setPregunta("¿Quién fue el primero en recibir un premio Nobel de Literatura?");
        p[14] = aux;
        tx.setText(p[ind].getPregunta());
        ind++;
    }

   public void Cargar_opciones(){
        //FACILES
        aux_op.setOpcion("Plástico");
        aux_op.setCorrecto(false);
        op[0][0]=aux_op;
        aux_op=new Opciones();
        aux_op.setOpcion("Metal");
        aux_op.setCorrecto(true);
        op[0][1]=aux_op;
        aux_op=new Opciones();
        aux_op.setOpcion("Madera");
        aux_op.setCorrecto(false);
        op[0][2]=aux_op;
        aux_op=new Opciones();
        aux_op.setOpcion("El hombre equivocado");
        aux_op.setCorrecto(false);
        op[0][3]=aux_op;
        aux_op=new Opciones();
        //2
        aux_op.setOpcion("Hamlet");
        aux_op.setCorrecto(false);
        op[1][0]=aux_op;
        aux_op=new Opciones();
        aux_op.setOpcion("Romeo");
        aux_op.setCorrecto(false);
        op[1][1]=aux_op;
        aux_op=new Opciones();
        aux_op.setOpcion("Macbeth");
        aux_op.setCorrecto(false);
        op[1][2]=aux_op;
        aux_op=new Opciones();
        aux_op.setOpcion("Darren");
        aux_op.setCorrecto(true);
        op[1][3]=aux_op;
        aux_op=new Opciones();
        //3
        aux_op.setOpcion("Un pretzel");
        aux_op.setCorrecto(false);
        op[2][0]=aux_op;
        aux_op=new Opciones();
        aux_op.setOpcion("Una manzana");
        aux_op.setCorrecto(false);
        op[2][1]=aux_op;
        aux_op=new Opciones();
        aux_op.setOpcion("Una menta");
        aux_op.setCorrecto(true);
        op[2][2]=aux_op;
        aux_op=new Opciones();
        aux_op.setOpcion("Una foto de Wolf Blitzer");
        aux_op.setCorrecto(false);
        op[2][3]=aux_op;
        aux_op=new Opciones();
        //4
        aux_op.setOpcion("Snapchat y Grubhub");
        aux_op.setCorrecto(false);
        op[3][0]=aux_op;
        aux_op=new Opciones();
        aux_op.setOpcion("Whatsapp y SHAREit");
        aux_op.setCorrecto(false);
        op[3][1]=aux_op;
        aux_op=new Opciones();
        aux_op.setOpcion("TikTok y Spotify");
        aux_op.setCorrecto(false);
        op[3][2]=aux_op;
        aux_op=new Opciones();
        aux_op.setOpcion("Lyft y Uber");
        aux_op.setCorrecto(true);
        op[3][3]=aux_op;
        aux_op=new Opciones();
        //5
        aux_op.setOpcion("De tus narices");
        aux_op.setCorrecto(true);
        op[4][0]=aux_op;
        aux_op=new Opciones();
        aux_op.setOpcion("Del colchon");
        aux_op.setCorrecto(false);
        op[4][1]=aux_op;
        aux_op=new Opciones();
        aux_op.setOpcion("De las azaleas");
        aux_op.setCorrecto(false);
        op[4][2]=aux_op;
        aux_op=new Opciones();
        aux_op.setOpcion("De tus boxers");
        aux_op.setCorrecto(false);
        op[4][3]=aux_op;
        aux_op=new Opciones();
        //6
        aux_op.setOpcion("Rusia");
        aux_op.setCorrecto(false);
        op[5][0]=aux_op;
        aux_op=new Opciones();
        aux_op.setOpcion("Estados Unidos");
        aux_op.setCorrecto(true);
        op[5][1]=aux_op;
        aux_op=new Opciones();
        aux_op.setOpcion("Afganistán");
        aux_op.setCorrecto(false);
        op[5][2]=aux_op;
        aux_op=new Opciones();
        aux_op.setOpcion("Andorra");
        aux_op.setCorrecto(false);
        op[5][3]=aux_op;
        aux_op=new Opciones();
        //7
        aux_op.setOpcion("Océano Atlántico");
        aux_op.setCorrecto(false);
        op[6][0]=aux_op;
        aux_op=new Opciones();
        aux_op.setOpcion("Océano Artico");
        aux_op.setCorrecto(false);
        op[6][1]=aux_op;
        aux_op=new Opciones();
        aux_op.setOpcion("Océano Pacífico");
        aux_op.setCorrecto(true);
        op[6][2]=aux_op;
        aux_op=new Opciones();
        aux_op.setOpcion("Océano Indico");
        aux_op.setCorrecto(false);
        op[6][3]=aux_op;
        aux_op=new Opciones();
        //8
        aux_op.setOpcion("1925");
        aux_op.setCorrecto(false);
        op[7][0]=aux_op;
        aux_op=new Opciones();
        aux_op.setOpcion("1970");
        aux_op.setCorrecto(false);
        op[7][1]=aux_op;
        aux_op=new Opciones();
        aux_op.setOpcion("1845");
        aux_op.setCorrecto(false);
        op[7][2]=aux_op;
        aux_op=new Opciones();
        aux_op.setOpcion("1945");
        aux_op.setCorrecto(true);
        op[7][3]=aux_op;
        aux_op=new Opciones();
        //9
        aux_op.setOpcion("Groenlandia");
        aux_op.setCorrecto(true);
        op[8][0]=aux_op;
        aux_op=new Opciones();
        aux_op.setOpcion("La isla de Borneo");
        aux_op.setCorrecto(false);
        op[8][1]=aux_op;
        aux_op=new Opciones();
        aux_op.setOpcion("Nueva Guinea");
        aux_op.setCorrecto(false);
        op[8][2]=aux_op;
        aux_op=new Opciones();
        aux_op.setOpcion("Madagascar");
        aux_op.setCorrecto(false);
        op[8][3]=aux_op;
        aux_op=new Opciones();
        //10
        aux_op.setOpcion("La guerra santa");
        aux_op.setCorrecto(false);
        op[9][0]=aux_op;
        aux_op=new Opciones();
        aux_op.setOpcion("La guerra de los 100 años");
        aux_op.setCorrecto(true);
        op[9][1]=aux_op;
        aux_op=new Opciones();
        aux_op.setOpcion("Las cruzadas");
        aux_op.setCorrecto(false);
        op[9][2]=aux_op;
        aux_op=new Opciones();
        aux_op.setOpcion("La revolucion de francia");
        aux_op.setCorrecto(false);
        op[9][3]=aux_op;
        aux_op=new Opciones();
        //11
        aux_op.setOpcion("Alberto");
        aux_op.setCorrecto(true);
        op[10][0]=aux_op;
        aux_op=new Opciones();
        aux_op.setOpcion("Jorge");
        aux_op.setCorrecto(false);
        op[10][1]=aux_op;
        aux_op=new Opciones();
        aux_op.setOpcion("Federico");
        aux_op.setCorrecto(false);
        op[10][2]=aux_op;
        aux_op=new Opciones();
        aux_op.setOpcion("Arturo");
        aux_op.setCorrecto(false);
        op[10][3]=aux_op;
        aux_op=new Opciones();
        //12
        aux_op.setOpcion("Negro");
        aux_op.setCorrecto(false);
        op[11][0]=aux_op;
        aux_op=new Opciones();
        aux_op.setOpcion("Blanco");
        aux_op.setCorrecto(false);
        op[11][1]=aux_op;
        aux_op=new Opciones();
        aux_op.setOpcion("Naranja");
        aux_op.setCorrecto(true);
        op[11][2]=aux_op;
        aux_op=new Opciones();
        aux_op.setOpcion("Azul");
        aux_op.setCorrecto(false);
        op[11][3]=aux_op;
        aux_op=new Opciones();
        //13
        aux_op.setOpcion("100");
        aux_op.setCorrecto(false);
        op[12][0]=aux_op;
        aux_op=new Opciones();
        aux_op.setOpcion("133");
        aux_op.setCorrecto(false);
        op[12][1]=aux_op;
        aux_op=new Opciones();
        aux_op.setOpcion("99");
        aux_op.setCorrecto(true);
        op[12][2]=aux_op;
        aux_op=new Opciones();
        aux_op.setOpcion("116");
        aux_op.setCorrecto(false);
        op[12][3]=aux_op;
        aux_op=new Opciones();
        //14
        aux_op.setOpcion("Tienes un ataque de pánico");
        aux_op.setCorrecto(false);
        op[13][0]=aux_op;
        aux_op=new Opciones();
        aux_op.setOpcion("Recuerdas un nombre");
        aux_op.setCorrecto(false);
        op[13][1]=aux_op;
        aux_op=new Opciones();
        aux_op.setOpcion("Entiendes una broma");
        aux_op.setCorrecto(true);
        op[13][2]=aux_op;
        aux_op=new Opciones();
        aux_op.setOpcion("Escuchas música");
        aux_op.setCorrecto(false);
        op[13][3]=aux_op;
        aux_op=new Opciones();
        //15
        aux_op.setOpcion("Ensayista");
        aux_op.setCorrecto(false);
        op[14][0]=aux_op;
        aux_op=new Opciones();
        aux_op.setOpcion("Novelista");
        aux_op.setCorrecto(false);
        op[14][1]=aux_op;
        aux_op=new Opciones();
        aux_op.setOpcion("Dramaturgo");
        aux_op.setCorrecto(false);
        op[14][2]=aux_op;
        aux_op=new Opciones();
        aux_op.setOpcion("Poeta");
        aux_op.setCorrecto(true);
        op[14][3]=aux_op;
        int []vec=Ubicar_opciones();
        boton_opcion_a.setText(op[0][0].getOpcion());
        boton_opcion_b.setText(op[0][1].getOpcion());
        boton_opcion_c.setText(op[0][2].getOpcion());
        boton_opcion_d.setText(op[0][3].getOpcion());
    }

    public int[] Ubicar_opciones(){
        int []ub={30,30,30,30};
        int a=0;
        for(int i=0;i<4;i++){
            while(a==0) {
                ub[i] = (int) (Math.random() * (3 - 0))+0;
                for (int o = 0; o < 4; o++) {
                    if (ub[i] == ub[o] && i != o) {
                        a++;
                        o=4;
                    }
                }
                if(a>0){
                    a=0;
                }else{
                    a=1;
                }
            }
        }
        return ub;
    }

    public int Primera(){
        Random r=new Random();
        return r.nextInt(4-0)+0;
    }
    public void Siguiente_ronda(){
        tx_ronda.setText(""+(ind+1));
        tx.setText(p[ind].getPregunta());
        ind++;
        boton_opcion_a.setEnabled(true);
        boton_opcion_b.setEnabled(true);
        boton_opcion_c.setEnabled(true);
        boton_opcion_d.setEnabled(true);
        boton_opcion_a.setText(op[(Integer.parseInt((String) tx_ronda.getText())-1) ][0].getOpcion());
        boton_opcion_b.setText(op[(Integer.parseInt((String) tx_ronda.getText())-1) ][1].getOpcion());
        boton_opcion_c.setText(op[(Integer.parseInt((String) tx_ronda.getText())-1) ][2].getOpcion());
        boton_opcion_d.setText(op[(Integer.parseInt((String) tx_ronda.getText())-1) ][3].getOpcion());
        for(int i=0;i<4;i++){
            visibles[i]=0;
        }
        if(ind==14){
            tx.setText("Increible has ganado");
            boton_opcion_a.setEnabled(false);
            boton_opcion_b.setEnabled(false);
            boton_opcion_c.setEnabled(false);
            boton_opcion_d.setEnabled(false);
            boton_comodin_llamada.setEnabled(false);
            boton_comodin_publico.setEnabled(false);
            boton_comodin_5050.setEnabled(false);
        }
    }
    public void Reiniciar(View v){
        tx_ronda.setText(""+1);
        ind=0;
        tx.setText(p[ind].getPregunta());
        Cargar_preguntas();
        Cargar_opciones();
        boton_opcion_a.setEnabled(true);
        boton_opcion_b.setEnabled(true);
        boton_opcion_c.setEnabled(true);
        boton_opcion_d.setEnabled(true);
        boton_comodin_llamada.setEnabled(true);
        boton_comodin_publico.setEnabled(true);
        boton_comodin_5050.setEnabled(true);
        boton_comodin_llamada.setVisibility(View.VISIBLE);
        boton_comodin_5050.setVisibility(View.VISIBLE);
        boton_comodin_publico.setVisibility(View.VISIBLE);
    }
    public void Perder(){
        boton_opcion_a.setEnabled(false);
        boton_opcion_b.setEnabled(false);
        boton_opcion_c.setEnabled(false);
        boton_opcion_d.setEnabled(false);
        boton_comodin_llamada.setEnabled(false);
        boton_comodin_publico.setEnabled(false);
        boton_comodin_5050.setEnabled(false);
        tx.setText("RESPUESTA INCORRECTA.Por favor reinicia el juego");
    }
}